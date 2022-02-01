package dov.com.qq.im.ae.qipc;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.debug.EnvSwitchActivity;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.util.AEQLog;
import eipc.EIPCResult;
import java.util.Map;

public class AECameraGetInfoServer
  extends QIPCModule
{
  public AECameraGetInfoServer()
  {
    super("AECameraGetInfoServer");
  }
  
  private QQAppInterface a()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    return null;
  }
  
  public static AECameraGetInfoServer a()
  {
    return AECameraGetInfoServer.Holder.a;
  }
  
  private String a(@NonNull String paramString)
  {
    if (paramString.contains("14.18.180.90")) {
      return "IPv4";
    }
    if (paramString.contains("240e:e1:a900:50::18")) {
      return "IPv6";
    }
    return "Unknown";
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (a() == null) {
      return null;
    }
    Object localObject;
    if ("ACTION_GET_ENV_INFO".equals(paramString))
    {
      paramBundle = new Bundle();
      if (EnvSwitchActivity.isTestEnvironment())
      {
        localObject = EnvSwitchActivity.loadTestEnvironment()[0];
        paramString = "Unknown";
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramString = a((String)localObject);
        }
        paramBundle.putString("KEY_ENV_INFO", "TestEnv: " + paramString);
      }
      for (;;)
      {
        paramString = EIPCResult.createSuccessResult(paramBundle);
        callbackResult(paramInt, paramString);
        return paramString;
        paramBundle.putString("KEY_ENV_INFO", "ProdEnv");
      }
    }
    if ("ACTION_SEND_GIF".equals(paramString)) {
      if (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        break label330;
      }
    }
    label330:
    for (paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; paramString = null)
    {
      if (paramString == null) {
        return null;
      }
      localObject = new SessionWrap(paramBundle.getString("curFriendUin"), paramBundle.getString("curFriendNick"), paramBundle.getInt("curType"), paramBundle.getString("troopUin"));
      CameraEmoticonInfo localCameraEmoticonInfo = new CameraEmoticonInfo();
      localCameraEmoticonInfo.path = paramBundle.getString("ARG_GIF_PATH");
      localCameraEmoticonInfo.url = localCameraEmoticonInfo.path;
      localCameraEmoticonInfo.contextKey = paramBundle.getString("forward_summary_extra", "");
      localCameraEmoticonInfo.templateId = paramBundle.getString("widgetinfo", "");
      localCameraEmoticonInfo.send(paramString, BaseApplicationImpl.getContext(), null, ((SessionWrap)localObject).a());
      return null;
      if ("ACTION_DOWNLOAD_AE_RES".equals(paramString))
      {
        paramString = paramBundle.getString("KEY_RES_PREFIX");
        paramString = (AEResInfo)AEResUtil.a.get(paramString);
        AEQLog.b("PreCheckAERes", "[onCall] action=ACTION_DOWNLOAD_AE_RES, aeResInfo=" + paramString);
        if (paramString != null)
        {
          AEResManager.a().a(paramString, null, false);
          return EIPCResult.createSuccessResult(new Bundle());
        }
        return null;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.qipc.AECameraGetInfoServer
 * JD-Core Version:    0.7.0.1
 */