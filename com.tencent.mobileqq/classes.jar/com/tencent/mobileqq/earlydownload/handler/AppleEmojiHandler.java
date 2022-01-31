package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.text.AppleEmojiManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AppleEmojiHandler
  extends EarlyHandler
{
  public AppleEmojiHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.appleemoji", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10001;
  }
  
  public Class a()
  {
    return AppleEmojiData.class;
  }
  
  public String a()
  {
    return "AppleMojiHandler";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess:" + paramString);
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("apple_emoji_file", AppConstants.aK + "early/" + localFile.getName()).commit();
    AppleEmojiManager.a(localFile);
    super.a(paramString);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler
 * JD-Core Version:    0.7.0.1
 */