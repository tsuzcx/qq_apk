package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class GroupCheckInUploadPlugin
  extends BaseJsPlugin
  implements EIPCResultCallback
{
  private RequestEvent a;
  
  @JsEvent({"checkin_uploadRes"})
  public void checkinUploadRes(RequestEvent paramRequestEvent)
  {
    try
    {
      this.a = paramRequestEvent;
      localObject1 = new JSONObject(paramRequestEvent.jsonParams).optJSONObject("data");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("data: ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("GroupCheckInUploadPlugin", 1, ((StringBuilder)localObject2).toString());
      localObject2 = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(((JSONObject)localObject1).optString("filePath"));
      if (((JSONObject)localObject1).optInt("isVideo") != 1) {
        break label296;
      }
      i = 1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        Bundle localBundle;
        String str;
        label278:
        continue;
        label296:
        int i = 0;
      }
    }
    localBundle = new Bundle();
    if (i != 0)
    {
      str = ((IMiniAppFileManager)this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(((JSONObject)localObject1).optString("cover"));
      if (!FileUtils.fileExists((String)localObject2)) {
        return;
      }
      if (!FileUtils.fileExists(str)) {
        return;
      }
      localBundle.putString("BUNDLE_NAME_FILEPATH", (String)localObject2);
      localBundle.putString("BUNDLE_NAME_COVER", str);
      localBundle.putLong("BUNDLE_NAME_VIDEOTIME", ((JSONObject)localObject1).optLong("videoDuration"));
    }
    else
    {
      if (!FileUtils.fileExists((String)localObject2)) {
        return;
      }
      localBundle.putString("BUNDLE_NAME_FILEPATH", (String)localObject2);
    }
    if (i != 0)
    {
      QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", localBundle, this);
    }
    else
    {
      QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", localBundle, this);
      break label278;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkinUploadRes(). Failed to parse jsonParams=");
      ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
      QLog.e("GroupCheckInUploadPlugin", 1, ((StringBuilder)localObject1).toString());
    }
    QLog.d("GroupCheckInUploadPlugin", 1, "checkin_uploadRes succeed");
    paramRequestEvent.ok();
    return;
  }
  
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
        if (k != 1) {
          break label299;
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
        if (this.a != null)
        {
          this.a.ok(paramEIPCResult);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        RequestEvent localRequestEvent = this.a;
        if (localRequestEvent != null) {
          localRequestEvent.fail(paramEIPCResult, "");
        }
      }
      return;
      label299:
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupCheckInUploadPlugin
 * JD-Core Version:    0.7.0.1
 */