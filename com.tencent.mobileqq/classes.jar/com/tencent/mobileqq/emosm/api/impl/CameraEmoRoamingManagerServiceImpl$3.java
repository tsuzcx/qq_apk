package com.tencent.mobileqq.emosm.api.impl;

import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class CameraEmoRoamingManagerServiceImpl$3
  extends TransProcessorHandler
{
  CameraEmoRoamingManagerServiceImpl$3(CameraEmoRoamingManagerServiceImpl paramCameraEmoRoamingManagerServiceImpl, Looper paramLooper, CameraEmotionData paramCameraEmotionData)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (CameraEmoRoamingManagerServiceImpl.access$000(this.b) == null) {
      return;
    }
    Object localObject3;
    if ((localFileMsg != null) && (localFileMsg.commandId == this.b.getUploadProcessorID()))
    {
      localObject3 = new Bdh_extinfo.CommFileExtRsp();
      localObject2 = "";
      localObject1 = localObject2;
      if (localFileMsg.bdhExtendInfo == null) {}
    }
    try
    {
      ((Bdh_extinfo.CommFileExtRsp)localObject3).mergeFrom(localFileMsg.bdhExtendInfo);
      localObject1 = localObject2;
      if (!((Bdh_extinfo.CommFileExtRsp)localObject3).bytes_download_url.has()) {
        break label114;
      }
      localObject1 = ((Bdh_extinfo.CommFileExtRsp)localObject3).bytes_download_url.get().toStringUtf8();
    }
    catch (Exception localException)
    {
      label104:
      break label104;
    }
    QLog.d("CameraEmoRoamingManager", 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed");
    Object localObject1 = localObject2;
    label114:
    Object localObject2 = new HashMap();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1005: 
      ((ITransFileController)CameraEmoRoamingManagerServiceImpl.access$400(this.b).getRuntimeService(ITransFileController.class)).removeHandle(this);
      paramMessage = new StringBuilder();
      paramMessage.append("upload camera emo error:");
      paramMessage.append(((Bdh_extinfo.CommFileExtRsp)localObject3).int32_retcode.get());
      QLog.i("CameraEmoRoamingManager", 1, paramMessage.toString());
      ((CameraEmoRoamingHandler)CameraEmoRoamingManagerServiceImpl.access$500(this.b).getBusinessHandler(CameraEmoRoamingHandler.a)).a(this.a, false);
      ((HashMap)localObject2).put("sucFlag", "0");
      ((HashMap)localObject2).put("retCode", String.valueOf(((Bdh_extinfo.CommFileExtRsp)localObject3).int32_retcode.get()));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject2, null);
      return;
    case 1004: 
      ((ITransFileController)CameraEmoRoamingManagerServiceImpl.access$600(this.b).getRuntimeService(ITransFileController.class)).removeHandle(this);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("upload camera emo cancel:");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.i("CameraEmoRoamingManager", 1, ((StringBuilder)localObject3).toString());
      ((CameraEmoRoamingHandler)CameraEmoRoamingManagerServiceImpl.access$700(this.b).getBusinessHandler(CameraEmoRoamingHandler.a)).a(this.a, false);
      ((HashMap)localObject2).put("sucFlag", "0");
      ((HashMap)localObject2).put("retCode", String.valueOf(paramMessage.what));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", false, 0L, 0L, (HashMap)localObject2, null);
      return;
    case 1003: 
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("finish upload camera emo serverPath=");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.d("CameraEmoRoamingManager", 2, ((StringBuilder)localObject3).toString());
      }
      ((ITransFileController)CameraEmoRoamingManagerServiceImpl.access$200(this.b).getRuntimeService(ITransFileController.class)).removeHandle(this);
      ((CameraEmoRoamingHandler)CameraEmoRoamingManagerServiceImpl.access$300(this.b).getBusinessHandler(CameraEmoRoamingHandler.a)).a(this.a, true);
      ((HashMap)localObject2).put("sucFlag", "1");
      ((HashMap)localObject2).put("retCode", String.valueOf(paramMessage.what));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoRealUpload", true, 0L, 0L, (HashMap)localObject2, null);
      return;
    case 1001: 
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingManager", 2, "start upload camera emo");
      }
      break;
    }
    return;
    ((ITransFileController)CameraEmoRoamingManagerServiceImpl.access$100(this.b).getRuntimeService(ITransFileController.class)).removeHandle(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CameraEmoRoamingManagerServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */