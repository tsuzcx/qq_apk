package com.tencent.mobileqq.identification;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.WeJson;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.YTLiveStyleReq;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;

public class FaceLoginHelper
{
  private static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 15) {
        return HardCodeUtil.a(2131911829);
      }
      return HardCodeUtil.a(2131889130);
    }
    return HardCodeUtil.a(2131911829);
  }
  
  public static void a(Context paramContext, FaceConf paramFaceConf, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    YTAGReflectLiveCheckInterface.getLiveCheckType(paramContext.getApplicationContext(), new FaceLoginHelper.1(localAtomicBoolean, paramFaceConf, paramIConfInterface));
  }
  
  protected static void a(Bundle paramBundle, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_app_conf", paramBundle, new FaceLoginHelper.2(paramIConfInterface));
  }
  
  protected static void a(FaceConf paramFaceConf, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    WeJson localWeJson = new WeJson();
    int i = paramFaceConf.getAppId();
    LiveStyleRequester.YTLiveStyleReq localYTLiveStyleReq = new LiveStyleRequester.YTLiveStyleReq(-2.0F, String.valueOf(i));
    localYTLiveStyleReq.app_id = String.valueOf(i);
    a(paramFaceConf, localWeJson.toJson(localYTLiveStyleReq), paramIConfInterface);
  }
  
  protected static void a(FaceConf paramFaceConf, String paramString, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    int i = paramFaceConf.getAppId();
    QLog.d("FaceLoginHelper", 1, new Object[] { "start sendPacket appid : ", Integer.valueOf(i) });
    if (QLog.isColorLevel()) {
      QLog.d("FaceLoginHelper", 1, new Object[] { "sendPacket", paramString });
    }
    if (i == 0) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("srcAppId", i);
    localBundle.putString("key", paramFaceConf.getKey());
    localBundle.putString("lightInfo", paramString);
    localBundle.putString("method", paramFaceConf.getMethod());
    localBundle.putString("uin", paramFaceConf.getUin());
    localBundle.putLong("nonce", paramFaceConf.getNonce());
    a(localBundle, paramIConfInterface);
  }
  
  protected static void a(LiveStyleRequester.YTLiveStyleReq paramYTLiveStyleReq, FaceConf paramFaceConf, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    paramYTLiveStyleReq.app_id = String.valueOf(paramFaceConf.getAppId());
    a(paramFaceConf, new WeJson().toJson(paramYTLiveStyleReq), paramIConfInterface);
  }
  
  protected static void a(EIPCResult paramEIPCResult, FaceLoginHelper.IConfInterface paramIConfInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callServer error_code:");
    localStringBuilder.append(paramEIPCResult.code);
    QLog.d("FaceLoginHelper", 1, localStringBuilder.toString());
    if (a(paramEIPCResult))
    {
      paramIConfInterface.a((AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf"));
      return;
    }
    paramIConfInterface.a(paramEIPCResult.code, a(paramEIPCResult.code));
  }
  
  private static boolean a(EIPCResult paramEIPCResult)
  {
    return (paramEIPCResult.code == 0) && (paramEIPCResult.data != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper
 * JD-Core Version:    0.7.0.1
 */