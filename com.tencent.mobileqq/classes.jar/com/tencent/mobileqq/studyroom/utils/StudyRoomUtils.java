package com.tencent.mobileqq.studyroom.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class StudyRoomUtils
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if ("master".equals(paramString)) {
      return "https://downv6.qq.com/innovate/qq/plugin/master/studyroom-qshadow-master.zip";
    }
    return String.format("https://downv6.qq.com/innovate/qq/plugin/debug/studyroom-qshadow-debug-%s.zip", new Object[] { paramString });
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("action", "");
      localJSONObject2.put("android_pkg_name", "");
      localJSONObject2.put("app_type", 1);
      localJSONObject2.put("appid", 1111);
      localJSONObject2.put("desc", paramString4);
      localJSONObject2.put("jumpUrl", paramString3);
      localJSONObject2.put("preview", paramString5);
      localJSONObject2.put("source_icon", "");
      localJSONObject2.put("source_url", "");
      localJSONObject2.put("tag", paramString2);
      localJSONObject2.put("title", paramString1);
      localJSONObject1.put("news", localJSONObject2);
      paramString1 = localJSONObject1.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.e("StudyRoomUtils", 1, "shareToFriendForArk: error, data bundle is null");
      return;
    }
    b(paramActivity, paramBundle, paramInt);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new QZoneShareData();
    paramBundle.mTitle = localBundle.getString("title");
    paramBundle.mSummary = localBundle.getString("summary");
    String str = localBundle.getString("imageUrl");
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(str);
    paramBundle.mImageUrls = localArrayList;
    paramBundle.targetUrl = localBundle.getString("targetUrl");
    paramBundle.iUrlInfoFrm = -1;
    paramBundle.mShareBeginTime = System.currentTimeMillis();
    paramBundle.from = 0;
    QZoneShareManager.shareToQzone(paramActivity, paramString, paramBundle, null, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, Intent paramIntent, String paramString)
  {
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("handleShareToFriend: resultCode=");
    paramQQAppInterface.append(paramInt);
    QLog.d(paramString, 2, paramQQAppInterface.toString());
    paramActivity.setResult(paramInt);
  }
  
  public static boolean a()
  {
    return new File(b()).exists();
  }
  
  public static boolean a(boolean paramBoolean)
  {
    File localFile = new File(b());
    if ((!paramBoolean) || (!localFile.exists())) {}
    try
    {
      localFile.getParentFile().mkdirs();
      paramBoolean = localFile.createNewFile();
      return paramBoolean;
    }
    catch (IOException|SecurityException localIOException)
    {
      label37:
      break label37;
    }
    return false;
    if (localFile.exists()) {
      return localFile.delete();
    }
    return true;
  }
  
  private static String b()
  {
    try
    {
      str = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    catch (RuntimeException localRuntimeException)
    {
      String str;
      label10:
      StringBuilder localStringBuilder;
      break label10;
    }
    str = "/sdcard";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/odapp/odsdk.test");
    return localStringBuilder.toString();
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      if (!paramBundle.containsKey("roomId")) {
        QLog.e("StudyRoomUtils", 1, "shareToFriendForArk: error, roomId is null");
      }
      paramBundle.getString("roomId");
      String str7 = paramBundle.getString("members", "");
      String str2 = paramBundle.getString("version", "1.0.0.16");
      Object localObject = paramBundle.getString("summary");
      String str3 = paramBundle.getString("targetUrl");
      String str4 = paramBundle.getString("tag", paramActivity.getString(2131916828));
      String str5 = paramBundle.getString("title", paramActivity.getString(2131916829));
      String str6 = paramBundle.getString("imageUrl");
      String str1 = paramBundle.getString("prompt");
      paramBundle = str1;
      if (TextUtils.isEmpty(str1))
      {
        paramBundle = paramActivity.getString(2131916826);
        if (TextUtils.isEmpty(str7))
        {
          paramBundle = new StringBuilder();
          paramBundle.append(paramActivity.getString(2131916827));
          paramBundle.append((String)localObject);
          paramBundle = paramBundle.toString();
        }
        else
        {
          paramBundle = String.format(paramBundle, new Object[] { str7 });
        }
      }
      str1 = a(str5, str4, str3, (String)localObject, str6);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareToFriendForArk: meta[");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append("]");
      QLog.i("StudyRoomUtils", 1, ((StringBuilder)localObject).toString());
      localObject = new Intent();
      ((Intent)localObject).setClass(paramActivity, ForwardRecentActivity.class);
      ((Intent)localObject).putExtra("forward_type", 27);
      ((Intent)localObject).putExtra("is_ark_display_share", true);
      ((Intent)localObject).putExtra("forward_ark_app_name", "com.tencent.studyroom");
      ((Intent)localObject).putExtra("forward_ark_app_view", "news");
      ((Intent)localObject).putExtra("forward_ark_app_ver", str2);
      ((Intent)localObject).putExtra("forward_ark_app_prompt", paramBundle);
      ((Intent)localObject).putExtra("forward_ark_app_meta", str1);
      ((Intent)localObject).putExtra("forward_ark_app_config", "{}");
      ((Intent)localObject).putExtra("appName", "com.tencent.studyroom");
      ((Intent)localObject).putExtra("appView", "news");
      ((Intent)localObject).putExtra("appMinVersion", str2);
      ((Intent)localObject).putExtra("metaData", str1);
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      return;
    }
    QLog.e("StudyRoomUtils", 1, "shareToFriendForArk: error, data bundle is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.utils.StudyRoomUtils
 * JD-Core Version:    0.7.0.1
 */