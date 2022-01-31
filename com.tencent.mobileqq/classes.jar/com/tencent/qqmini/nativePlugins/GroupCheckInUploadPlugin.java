package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import bdcs;
import bgjm;
import bgkd;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupCheckInUploadPlugin
  extends BaseJsPlugin
  implements EIPCResultCallback
{
  public static final String TAG = "GroupCheckInUploadPlugin";
  private bgkd req;
  
  public void checkinUploadRes(bgkd parambgkd)
  {
    for (int i = 1;; i = 0) {
      for (;;)
      {
        try
        {
          this.req = parambgkd;
          JSONObject localJSONObject = new JSONObject(parambgkd.b).optJSONObject("data");
          QMLog.d("GroupCheckInUploadPlugin", "data: " + localJSONObject);
          str1 = bgjm.a().a(localJSONObject.optString("filePath"));
          if (localJSONObject.optInt("isVideo") != 1) {
            break;
          }
          localBundle = new Bundle();
          if (i == 0) {
            continue;
          }
          String str2 = bgjm.a().a(localJSONObject.optString("cover"));
          if (!bdcs.a(str1)) {
            break label244;
          }
          if (!bdcs.a(str2)) {
            return;
          }
          localBundle.putString("BUNDLE_NAME_FILEPATH", str1);
          localBundle.putString("BUNDLE_NAME_COVER", str2);
          localBundle.putLong("BUNDLE_NAME_VIDEOTIME", localJSONObject.optLong("videoDuration"));
          if (i == 0) {
            continue;
          }
          QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_VIDEO", localBundle, this);
        }
        catch (JSONException localJSONException)
        {
          String str1;
          Bundle localBundle;
          QMLog.e("GroupCheckInUploadPlugin", "checkinUploadRes(). Failed to parse jsonParams=" + parambgkd.b);
          continue;
          QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_UPLOAD_PIC", localBundle, this);
          continue;
        }
        QMLog.i("Demo", "checkin_uploadRes succeed");
        parambgkd.a();
        return;
        if (bdcs.a(str1)) {
          localBundle.putString("BUNDLE_NAME_FILEPATH", str1);
        } else {
          label244:
          return;
        }
      }
    }
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = paramEIPCResult.code;
    Bundle localBundle = paramEIPCResult.data;
    if (QLog.isColorLevel()) {
      QLog.d("GroupCheckInUploadPlugin", 2, "result = " + i + ", data = " + localBundle.toString());
    }
    paramEIPCResult = new JSONObject();
    for (;;)
    {
      try
      {
        int j = localBundle.getInt("isVideo");
        int k = localBundle.getInt("result");
        if (k != 1) {
          break label275;
        }
        i = 1;
        paramEIPCResult.put("isVideo", j);
        paramEIPCResult.put("result", k);
        if (j != 1) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramEIPCResult.put("url", localBundle.getString("url"));
        paramEIPCResult.put("vid", localBundle.getString("vid"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (this.req == null) {
          break label274;
        }
        this.req.a(paramEIPCResult, "");
        return;
        if (i == 0) {
          continue;
        }
        paramEIPCResult.put("url", localException.getString("url"));
        continue;
        paramEIPCResult.put("error", localException.getString("error"));
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupCheckInUploadPlugin", 2, "onCallback json = " + paramEIPCResult.toString());
      }
      if (this.req != null)
      {
        this.req.a(paramEIPCResult);
        return;
        paramEIPCResult.put("error", localBundle.getString("error"));
      }
      else
      {
        label274:
        return;
        label275:
        i = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    QIPCClientHelper.getInstance().callServer("Module_CheckInServer", "ACTION_CANCEL", null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GroupCheckInUploadPlugin
 * JD-Core Version:    0.7.0.1
 */