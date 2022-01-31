package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import bbdx;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin.JSContext;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

public class GroupCheckInUploadPlugin
  implements NativePlugin, EIPCResultCallback
{
  public static final String PLUGIN_NAME = "checkin_uploadRes";
  public static final String TAG = "GroupCheckInUploadPlugin";
  NativePlugin.JSContext mContext;
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    int i = paramEIPCResult.code;
    Object localObject = paramEIPCResult.data;
    if (QLog.isColorLevel()) {
      QLog.d("GroupCheckInUploadPlugin", 2, "result = " + i + ", data = " + ((Bundle)localObject).toString());
    }
    paramEIPCResult = new JSONObject();
    for (;;)
    {
      try
      {
        int j = ((Bundle)localObject).getInt("isVideo");
        int k = ((Bundle)localObject).getInt("result");
        if (k != 1) {
          break label286;
        }
        i = 1;
        paramEIPCResult.put("isVideo", j);
        paramEIPCResult.put("result", k);
        if (j == 1)
        {
          if (i != 0)
          {
            paramEIPCResult.put("url", ((Bundle)localObject).getString("url"));
            paramEIPCResult.put("vid", ((Bundle)localObject).getString("vid"));
            if (QLog.isColorLevel()) {
              QLog.d("GroupCheckInUploadPlugin", 2, "onCallback json = " + paramEIPCResult.toString());
            }
            localObject = this.mContext;
            if (k != 1) {
              break label280;
            }
            ((NativePlugin.JSContext)localObject).evaluateCallback(bool, paramEIPCResult, "");
            return;
          }
          paramEIPCResult.put("error", ((Bundle)localObject).getString("error"));
          continue;
        }
        if (i == 0) {
          break label263;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.mContext.evaluateCallback(false, paramEIPCResult, "");
        return;
      }
      paramEIPCResult.put("url", localException.getString("url"));
      continue;
      label263:
      paramEIPCResult.put("error", localException.getString("error"));
      continue;
      label280:
      bool = false;
      continue;
      label286:
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
  }
  
  public void onInvoke(JSONObject paramJSONObject, NativePlugin.JSContext paramJSContext)
  {
    int i = 1;
    this.mContext = paramJSContext;
    paramJSONObject = paramJSONObject.optJSONObject("data");
    QLog.d("GroupCheckInUploadPlugin", 1, "data: " + paramJSONObject);
    paramJSContext = MiniAppFileManager.getInstance().getAbsolutePath(paramJSONObject.optString("filePath"));
    if (paramJSONObject.optInt("isVideo") == 1) {}
    Bundle localBundle;
    String str;
    for (;;)
    {
      localBundle = new Bundle();
      if (i == 0) {
        break label158;
      }
      str = MiniAppFileManager.getInstance().getAbsolutePath(paramJSONObject.optString("cover"));
      if ((bbdx.a(paramJSContext)) && (bbdx.a(str))) {
        break;
      }
      return;
      i = 0;
    }
    localBundle.putString("BUNDLE_NAME_FILEPATH", paramJSContext);
    localBundle.putString("BUNDLE_NAME_COVER", str);
    localBundle.putLong("BUNDLE_NAME_VIDEOTIME", paramJSONObject.optLong("videoDuration"));
    for (;;)
    {
      if (i == 0) {
        break label176;
      }
      QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", localBundle, this);
      return;
      label158:
      if (!bbdx.a(paramJSContext)) {
        break;
      }
      localBundle.putString("BUNDLE_NAME_FILEPATH", paramJSContext);
    }
    label176:
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", localBundle, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin
 * JD-Core Version:    0.7.0.1
 */