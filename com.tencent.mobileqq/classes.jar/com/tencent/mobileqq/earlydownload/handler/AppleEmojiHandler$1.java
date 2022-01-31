package com.tencent.mobileqq.earlydownload.handler;

import ajsd;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import anpj;
import ayjv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class AppleEmojiHandler$1
  implements Runnable
{
  public AppleEmojiHandler$1(anpj paramanpj, File paramFile, String paramString) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (String str = PreferenceManager.getDefaultSharedPreferencesName(localBaseApplication);; str = localBaseApplication.getPackageName() + "_preferences")
    {
      localBaseApplication.getSharedPreferences(str, 4).edit().putString("apple_emoji_file", ajsd.aW + "early/" + this.jdField_a_of_type_JavaIoFile.getName()).commit();
      ayjv.a(this.jdField_a_of_type_JavaIoFile);
      anpj.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler.1
 * JD-Core Version:    0.7.0.1
 */