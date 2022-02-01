package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
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
    this.activity.setTitle(HardCodeUtil.a(2131701098));
  }
  
  public String decodeUrl(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Decode pendant market url: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("AvatarPendantUiPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramString == null) {
      return null;
    }
    Object localObject2 = paramString.replace("[client]", "androidQQ").replace("[version]", "8.7.0.5295").replace("[system]", Build.VERSION.RELEASE).replace("[device]", Build.DEVICE);
    Object localObject1 = super.getInfoIntent();
    if (((Intent)localObject1).getBooleanExtra("key_update_flag", false)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    paramString = ((String)localObject2).replace("[updateFlag]", paramString);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(((Intent)localObject1).getIntExtra("updateId", 0));
    paramString = paramString.replace("[updateId]", ((StringBuilder)localObject2).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("After decode pendant market url: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("AvatarPendantUiPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    return paramString;
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong == 8589934605L)
    {
      bool1 = bool2;
      if (paramMap != null)
      {
        paramString = (Intent)paramMap.get("intent");
        bool1 = bool2;
        if (paramString != null)
        {
          paramString = paramString.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
          bool1 = bool2;
          if (paramString != null)
          {
            bool1 = bool2;
            if (sJsHandler != null)
            {
              if (sCallbackId == null) {
                return false;
              }
              paramMap = new Bundle();
              paramMap.putString("path", paramString);
              paramString = DataFactory.a("changeAvatar", sCallbackId, sJsHandler.getIPCResponseKey(), paramMap);
              paramMap = new JSONObject();
              try
              {
                paramMap.put("result", 0);
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(sCallbackId);
                localStringBuilder.append("(");
                localStringBuilder.append(paramMap.toString());
                localStringBuilder.append(");");
                super.callJs(localStringBuilder.toString());
              }
              catch (JSONException paramMap)
              {
                StringBuilder localStringBuilder;
                if (QLog.isColorLevel())
                {
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("Failed to notify starting upload avatar:");
                  localStringBuilder.append(paramMap.getMessage());
                  QLog.e("AvatarPendantUiPlugin", 2, localStringBuilder.toString());
                }
              }
              sJsHandler.sendRemoteReq(paramString, false, false);
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  protected long getPluginBusiness()
  {
    return 512L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 35L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 32L) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("_bid=160"))) {
      ReportController.b(null, "CliOper", "", "", "PendantMarket", "StartLoad", 0, 0, "", "", "", "");
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.i("AvatarPendantUiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if (sUploadPhotoUri == null) {
          break label465;
        }
        paramIntent = ImageUtil.b(this.activity, sUploadPhotoUri);
        paramInt1 = Math.min(482, ProfileCardUtil.a(this.activity));
        localObject = new Intent();
        ((Intent)localObject).putExtra("keyFromPendantPhoto", true);
        ((Intent)localObject).putExtra("Business_Origin", 100);
        PhotoUtils.startPhotoEdit((Intent)localObject, this.activity, QQBrowserActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, FaceUtil.a());
        sUploadPhotoUri = null;
        return true;
      }
      if ((paramInt2 != 0) || (sJsHandler == null) || (sCallbackId == null)) {
        break label465;
      }
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("result", 2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(sCallbackId);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramIntent.toString());
        ((StringBuilder)localObject).append(");");
        super.callJs(((StringBuilder)localObject).toString());
        return true;
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cancel select photo: ");
          ((StringBuilder)localObject).append(paramIntent.getMessage());
          QLog.e("AvatarPendantUiPlugin", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null) && (sJsHandler != null))
    {
      paramIntent.getStringExtra("callbackSn");
      localObject = paramIntent.getStringExtra("result");
      try
      {
        paramIntent = new JSONObject();
        paramIntent.put("result", localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(sCallbackId);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramIntent.toString());
        ((StringBuilder)localObject).append(");");
        super.callJs(((StringBuilder)localObject).toString());
        return true;
      }
      catch (JSONException paramIntent)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Open service failed: ");
          ((StringBuilder)localObject).append(paramIntent.getMessage());
          QLog.e("AvatarPendantUiPlugin", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    label465:
    return false;
  }
  
  public void onDestroy()
  {
    sCallbackId = null;
    sUploadPhotoUri = null;
    sJsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin
 * JD-Core Version:    0.7.0.1
 */