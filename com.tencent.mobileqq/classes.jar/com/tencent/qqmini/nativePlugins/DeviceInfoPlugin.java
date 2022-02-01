package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

public class DeviceInfoPlugin
  extends BaseJsPlugin
{
  @JsEvent({"getGUID"})
  public void checkGameBuddyType(RequestEvent paramRequestEvent)
  {
    QLog.d("DeviceInfoPlugin", 1, "checkGameBuddyType getGUID");
    QIPCClientHelper.getInstance().callServer("DeviceProtectQIPCModule", "ACTION_GET_GUID_INFO", null, new DeviceInfoPlugin.1(this, paramRequestEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.DeviceInfoPlugin
 * JD-Core Version:    0.7.0.1
 */