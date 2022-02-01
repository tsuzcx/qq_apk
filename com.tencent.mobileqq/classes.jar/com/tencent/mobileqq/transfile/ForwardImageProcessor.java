package com.tencent.mobileqq.transfile;

import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class ForwardImageProcessor
  implements IHttpCommunicatorListener
{
  private QQAppInterface app;
  private String downloadProcessorKey;
  private String filepath;
  private String orgUin;
  private int orgUinType;
  private long orgUniseq;
  private String orgUrl;
  private String targetUin;
  private int targetUinType;
  private TransProcessorHandler thandler = new ForwardImageProcessor.1(this);
  private long uniseq;
  
  public ForwardImageProcessor(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    this.downloadProcessorKey = paramString1;
    this.targetUinType = paramInt1;
    this.targetUin = paramString2;
    this.filepath = paramString3;
    this.orgUin = paramString5;
    this.app = paramQQAppInterface;
    this.uniseq = paramLong1;
    this.orgUrl = paramString4;
    this.orgUniseq = paramLong2;
    this.orgUinType = paramInt2;
    this.thandler.addFilter(new Class[] { BuddyTransfileProcessor.class, ((IPicTransFile)paramQQAppInterface.getRuntimeService(IPicTransFile.class)).getC2CUploadProClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getGroupPttDownloadProcessorClass(), ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getC2CPttDownloadProcessorClass() });
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.thandler);
  }
  
  private void sendReceiveFailToUI()
  {
    stopListening();
    Object localObject1 = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.targetUin);
    ((StringBuilder)localObject2).append(this.uniseq);
    ((ITransFileController)localObject1).removeProcessor(((StringBuilder)localObject2).toString());
    localObject1 = new Message();
    ((Message)localObject1).what = 1005;
    localObject2 = new FileMsg(this.targetUin, this.filepath, 0);
    ((FileMsg)localObject2).fileType = 1;
    ((FileMsg)localObject2).uniseq = this.uniseq;
    ((Message)localObject1).obj = localObject2;
    ((Message)localObject1).arg1 = 0;
    BaseTransProcessor.sendCustomMessageToUpdateDelay((Message)localObject1, ForwardImageProcessor.class, 0L);
    this.app.getMessageFacade().a(this.targetUin, this.targetUinType, this.uniseq, this.orgUrl, this.orgUin, this.orgUniseq, this.orgUinType);
  }
  
  private void uploadImage()
  {
    Object localObject = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.targetUin);
    localStringBuilder.append(this.uniseq);
    ((ITransFileController)localObject).removeProcessor(localStringBuilder.toString());
    int i = this.targetUinType;
    if ((i == 1) || (i == 1001) || (i == 10002) || (i == 3000))
    {
      long l;
      if (this.targetUinType == 1001) {
        l = AppSetting.l;
      } else {
        l = ((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
      }
      i = (int)l;
      if (new File(this.filepath).length() > i)
      {
        ImageUtil.a(-1L, this.targetUinType, true, "group_compress", "ForwardImageProcessor.uploadImage");
        this.filepath = ImageUtil.a(this.app.getApp().getBaseContext(), this.filepath, i);
      }
      if (!ImageUtil.a(null, this.filepath, 5, null, "ForwardImageProcessor.handleMessage.compress")) {
        return;
      }
    }
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.app.getAccount();
    ((TransferRequest)localObject).mPeerUin = this.targetUin;
    ((TransferRequest)localObject).mUinType = this.targetUinType;
    ((TransferRequest)localObject).mFileType = 1;
    ((TransferRequest)localObject).mUniseq = this.uniseq;
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mBusiType = 1009;
    ((TransferRequest)localObject).mLocalPath = this.filepath;
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2) {}
  
  public void handleRedirect(String paramString) {}
  
  public void setId(long paramLong)
  {
    this.uniseq = paramLong;
  }
  
  public void startListen()
  {
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).addHandle(this.thandler);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return false;
  }
  
  public void stopListening()
  {
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).removeHandle(this.thandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardImageProcessor
 * JD-Core Version:    0.7.0.1
 */