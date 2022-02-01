package com.tencent.mobileqq.mini.push;

import com.tencent.mobileqq.mini.utils.ReportLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class UploadLogAction
  implements PushAction
{
  public static final String KEY_APPID = "appid";
  public static final String TAG = "UploadLogAction";
  
  public void exec(MiniAppControlInfo paramMiniAppControlInfo)
  {
    if (paramMiniAppControlInfo.data.containsKey("appid"))
    {
      paramMiniAppControlInfo = (String)paramMiniAppControlInfo.data.get("appid");
      QLog.d("UploadLogAction", 1, "UploadLogAction appid:" + paramMiniAppControlInfo);
      ReportLogUtil.compressAndUploadLog(paramMiniAppControlInfo);
      return;
    }
    QLog.d("UploadLogAction", 1, "UploadLogAction has no appid parameter! " + paramMiniAppControlInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.UploadLogAction
 * JD-Core Version:    0.7.0.1
 */