package com.tencent.mobileqq.earlydownload.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.AppleEmojiManager;
import java.io.File;

class AppleEmojiHandler$1
  implements Runnable
{
  AppleEmojiHandler$1(AppleEmojiHandler paramAppleEmojiHandler, File paramFile, String paramString) {}
  
  public void run()
  {
    Object localObject2 = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferencesName((Context)localObject2);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject2).getPackageName());
      ((StringBuilder)localObject1).append("_preferences");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = ((Context)localObject2).getSharedPreferences((String)localObject1, 4).edit();
    localObject2 = AIOUtils.a();
    ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject2).append("early/");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaIoFile.getName());
    ((SharedPreferences.Editor)localObject1).putString("apple_emoji_file", ((StringBuilder)localObject2).toString()).commit();
    AppleEmojiManager.unzip(this.jdField_a_of_type_JavaIoFile);
    AppleEmojiHandler.a(this.this$0, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler.1
 * JD-Core Version:    0.7.0.1
 */