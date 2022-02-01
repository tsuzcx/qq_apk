package com.tencent.mobileqq.mini.push;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class MiniAppPushControl
{
  public static final String KEY_CTRL_CMD = "key_ctrl_cmd";
  public static final String KEY_CTRL_CMD_CLEAR_CACHE = "clear_cache";
  public static final String KEY_CTRL_CMD_DOWNGRADE = "sdk_downgrade";
  public static final String KEY_CTRL_CMD_UPLOAD_LOG = "upload_log";
  public static final String TAG = "MiniAppPushControl";
  private static MiniAppPushControl instance;
  private static Object lock = new Object();
  public String mUin;
  public HashMap<String, PushAction> pushActions = new HashMap();
  
  MiniAppPushControl(String paramString)
  {
    this.mUin = paramString;
    this.pushActions.put("upload_log", new UploadLogAction());
    this.pushActions.put("clear_cache", new ClearCacheAction());
    this.pushActions.put("sdk_downgrade", new SDKDowngradeAction());
  }
  
  public static MiniAppPushControl getInstance(String paramString)
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new MiniAppPushControl(paramString);
        }
      }
    }
    return instance;
  }
  
  public void processControlInfo(MiniAppControlInfo paramMiniAppControlInfo)
  {
    try
    {
      if (this.pushActions.containsKey(paramMiniAppControlInfo.cmd))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MiniAppPushControl processControlInfo cmd:");
        localStringBuilder.append(paramMiniAppControlInfo);
        QLog.d("MiniAppPushControl", 1, localStringBuilder.toString());
        ((PushAction)this.pushActions.get(paramMiniAppControlInfo.cmd)).exec(paramMiniAppControlInfo);
        return;
      }
    }
    catch (Exception paramMiniAppControlInfo)
    {
      QLog.e("MiniAppPushControl", 1, "processControlInfo failed:", paramMiniAppControlInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.MiniAppPushControl
 * JD-Core Version:    0.7.0.1
 */