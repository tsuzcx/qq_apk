package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

public class GroupCheckInUploadPlugin
  implements NativePlugin, EIPCResultCallback
{
  public static final String PLUGIN_NAME = "checkin_uploadRes";
  public static final String TAG = "GroupCheckInUploadPlugin";
  JSContext mContext;
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = paramEIPCResult.code;
    Object localObject = paramEIPCResult.data;
    if (QLog.isColorLevel())
    {
      paramEIPCResult = new StringBuilder();
      paramEIPCResult.append("result = ");
      paramEIPCResult.append(i);
      paramEIPCResult.append(", data = ");
      paramEIPCResult.append(((Bundle)localObject).toString());
      QLog.d("GroupCheckInUploadPlugin", 2, paramEIPCResult.toString());
    }
    paramEIPCResult = new JSONObject();
    for (;;)
    {
      try
      {
        int j = ((Bundle)localObject).getInt("isVideo");
        int k = ((Bundle)localObject).getInt("result");
        bool = true;
        if (k == 1)
        {
          i = 1;
          paramEIPCResult.put("isVideo", j);
          paramEIPCResult.put("result", k);
          if (j == 1)
          {
            if (i != 0)
            {
              paramEIPCResult.put("url", ((Bundle)localObject).getString("url"));
              paramEIPCResult.put("vid", ((Bundle)localObject).getString("vid"));
            }
            else
            {
              paramEIPCResult.put("error", ((Bundle)localObject).getString("error"));
            }
          }
          else if (i != 0) {
            paramEIPCResult.put("url", ((Bundle)localObject).getString("url"));
          } else {
            paramEIPCResult.put("error", ((Bundle)localObject).getString("error"));
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onCallback json = ");
            ((StringBuilder)localObject).append(paramEIPCResult.toString());
            QLog.d("GroupCheckInUploadPlugin", 2, ((StringBuilder)localObject).toString());
          }
          localObject = this.mContext;
          if (k != 1) {
            break label311;
          }
          ((JSContext)localObject).evaluateCallback(bool, paramEIPCResult, "");
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.mContext.evaluateCallback(false, paramEIPCResult, "");
        return;
      }
      i = 0;
      continue;
      label311:
      boolean bool = false;
    }
  }
  
  public void onDestroy()
  {
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
  }
  
  public void onInvoke(JSONObject paramJSONObject, JSContext paramJSContext)
  {
    this.mContext = paramJSContext;
    paramJSONObject = paramJSONObject.optJSONObject("data");
    paramJSContext = new StringBuilder();
    paramJSContext.append("data: ");
    paramJSContext.append(paramJSONObject);
    paramJSContext = paramJSContext.toString();
    int i = 1;
    QLog.d("GroupCheckInUploadPlugin", 1, paramJSContext);
    paramJSContext = MiniAppFileManager.getInstance().getAbsolutePath(paramJSONObject.optString("filePath"));
    if (paramJSONObject.optInt("isVideo") != 1) {
      i = 0;
    }
    Bundle localBundle = new Bundle();
    if (i != 0)
    {
      String str = MiniAppFileManager.getInstance().getAbsolutePath(paramJSONObject.optString("cover"));
      if (FileUtils.fileExists(paramJSContext))
      {
        if (!FileUtils.fileExists(str)) {
          return;
        }
        localBundle.putString("BUNDLE_NAME_FILEPATH", paramJSContext);
        localBundle.putString("BUNDLE_NAME_COVER", str);
        localBundle.putLong("BUNDLE_NAME_VIDEOTIME", paramJSONObject.optLong("videoDuration"));
      }
    }
    else
    {
      if (!FileUtils.fileExists(paramJSContext)) {
        return;
      }
      localBundle.putString("BUNDLE_NAME_FILEPATH", paramJSContext);
    }
    if (i != 0)
    {
      QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", localBundle, this);
      return;
    }
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", localBundle, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin
 * JD-Core Version:    0.7.0.1
 */