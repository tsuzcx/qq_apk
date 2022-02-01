package com.tencent.mobileqq.earlydownload.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.AppleEmojiManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

class AppleEmojiHandler$1
  implements Runnable
{
  AppleEmojiHandler$1(AppleEmojiHandler paramAppleEmojiHandler, File paramFile, String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(localBaseApplication);; str = localBaseApplication.getPackageName() + "_preferences")
    {
      localBaseApplication.getSharedPreferences(str, 4).edit().putString("apple_emoji_file", AppConstants.SDCARD_PATH + "early/" + this.jdField_a_of_type_JavaIoFile.getName()).commit();
      AppleEmojiManager.unzip(this.jdField_a_of_type_JavaIoFile);
      AppleEmojiHandler.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler.1
 * JD-Core Version:    0.7.0.1
 */