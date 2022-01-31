package com.tencent.mobileqq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload;

public class BusinessCommonConfig$GestureConfigHandler
  extends BusinessCommonConfig.ConfigHandler
{
  public int a()
  {
    return a(a(), "config", "ver");
  }
  
  public SharedPreferences a()
  {
    return DownloadInfo.a();
  }
  
  public Class a()
  {
    return DownloadInfo.class;
  }
  
  public String a()
  {
    return "QavGesture";
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, BusinessCommonConfig.ConfigInfo paramConfigInfo)
  {
    GestureMgrAppDownload.a(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    if (TextUtils.isEmpty(paramString)) {
      localSharedPreferences.edit().remove("config");
    }
    for (;;)
    {
      localSharedPreferences.edit().putInt("ver", paramInt);
      localSharedPreferences.edit().commit();
      return;
      localSharedPreferences.edit().putString("config", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BusinessCommonConfig.GestureConfigHandler
 * JD-Core Version:    0.7.0.1
 */