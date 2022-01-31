package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantUiPlugin
  extends VasWebviewUiPlugin
{
  public static final String KEY_UPDATE_FLAG = "key_update_flag";
  private static final String LOG_TAG = "AvatarPendantUiPlugin";
  public static final int REQUEST_CODE_TAKE_PHOTO = 1;
  public static String sCallbackId;
  public static AvatarPendantJsPlugin sJsHandler;
  public static Uri sUploadPhotoUri;
  
  void OnActivityResume()
  {
    super.OnActivityResume();
    this.activity.setTitle("挂件");
  }
  
  public String decodeUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUiPlugin", 2, "Decode pendant market url: " + paramString);
    }
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str = paramString.replace("[client]", "androidQQ").replace("[version]", "7.6.8.3615").replace("[system]", Build.VERSION.RELEASE).replace("[device]", Build.DEVICE);
    Intent localIntent = super.getInfoIntent();
    if (localIntent.getBooleanExtra("key_update_flag", false)) {}
    for (paramString = "1";; paramString = "0")
    {
      str = str.replace("[updateFlag]", paramString).replace("[updateId]", "" + localIntent.getIntExtra("updateId", 0));
      paramString = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AvatarPendantUiPlugin", 2, "After decode pendant market url: " + str);
      return str;
    }
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 8589934605L) && (paramMap != null))
    {
      paramString = (Intent)paramMap.get("intent");
      if (paramString != null)
      {
        paramString = paramString.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        if (paramString != null)
        {
          if ((sJsHandler == null) || (sCallbackId == null)) {
            return false;
          }
          paramMap = new Bundle();
          paramMap.putString("path", paramString);
          paramString = DataFactory.a("changeAvatar", sCallbackId, sJsHandler.getIPCResponseKey(), paramMap);
          paramMap = new JSONObject();
          try
          {
            paramMap.put("result", 0);
            super.callJs(sCallbackId + "(" + paramMap.toString() + ");");
            sJsHandler.sendRemoteReq(paramString, false, false);
            return true;
          }
          catch (JSONException paramMap)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("AvatarPendantUiPlugin", 2, "Failed to notify starting upload avatar:" + paramMap.getMessage());
              }
            }
          }
        }
      }
    }
    return false;
  }
  
  protected long getPluginBusiness()
  {
    return 512L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 32L) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("_bid=160"))) {
      ReportController.b(null, "CliOper", "", "", "PendantMarket", "StartLoad", 0, 0, "", "", "", "");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUiPlugin", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2 + ", data=" + paramIntent);
    }
    Object localObject;
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (sUploadPhotoUri == null) {
          break label394;
        }
        paramIntent = ImageUtil.b(this.activity, sUploadPhotoUri);
        paramInt1 = Math.min(482, ProfileCardUtil.a(this.activity));
        localObject = new Intent();
        ((Intent)localObject).putExtra("keyFromPendantPhoto", true);
        ((Intent)localObject).putExtra("Business_Origin", 100);
        PhotoUtils.a((Intent)localObject, this.activity, QQBrowserActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
        sUploadPhotoUri = null;
        return true;
      }
      if ((paramInt2 != 0) || (sJsHandler == null) || (sCallbackId == null)) {
        break label394;
      }
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("result", 2);
        super.callJs(sCallbackId + "(" + paramIntent.toString() + ");");
        return true;
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AvatarPendantUiPlugin", 2, "cancel select photo: " + paramIntent.getMessage());
          }
        }
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null) && (sJsHandler != null))
    {
      paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("result", paramIntent);
        super.callJs(sCallbackId + "(" + ((JSONObject)localObject).toString() + ");");
        return true;
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AvatarPendantUiPlugin", 2, "Open service failed: " + paramIntent.getMessage());
          }
        }
      }
    }
    label394:
    return false;
  }
  
  public void onDestroy()
  {
    sCallbackId = null;
    sUploadPhotoUri = null;
    sJsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin
 * JD-Core Version:    0.7.0.1
 */