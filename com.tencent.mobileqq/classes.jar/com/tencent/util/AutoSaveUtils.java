package com.tencent.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class AutoSaveUtils
{
  private static Set<String> a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
    if (paramBoolean) {}
    for (String str = "qqsetting_auto_save_path_pic_key";; str = "qqsetting_auto_save_path_video_key") {
      return SharedPreferencesHandler.a(localSharedPreferences, str, new HashSet());
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, false);
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(paramBoolean1))
    {
      paramString = new AutoSaveUtils.1(paramString, paramBoolean1);
      if (paramBoolean2) {
        paramString.run();
      }
    }
    else
    {
      return;
    }
    ThreadManagerV2.executeOnFileThread(paramString);
  }
  
  private static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
    if (paramBoolean) {}
    for (String str = "qqsetting_auto_save_path_pic_key";; str = "qqsetting_auto_save_path_video_key")
    {
      localEditor.putStringSet(str, new HashSet());
      localEditor.commit();
      return;
    }
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramString == null) {
      return;
    }
    a(paramBoolean, Collections.singletonList(paramString));
  }
  
  public static void a(boolean paramBoolean, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    while (!a(paramBoolean)) {
      return;
    }
    Set localSet = a(paramBoolean);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.d("AutoSaveUtils", 2, "autoSaveMediaInSp: isPic " + paramBoolean + ",path=" + str);
      }
      if (localSet.contains(str)) {
        a(str, paramBoolean);
      }
    }
    a(paramBoolean);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {}
    for (String str = "qqsetting_auto_save_pic_key";; str = "qqsetting_auto_save_video_key")
    {
      localEditor.putBoolean(str + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramBoolean2);
      localEditor.commit();
      return;
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = "qqsetting_auto_save_pic_key";; str = "qqsetting_auto_save_video_key") {
      return localSharedPreferences.getBoolean(str + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false);
    }
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    HashSet localHashSet;
    SharedPreferences.Editor localEditor;
    if (a(paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoSaveUtils", 2, "addAutoSavePath: isPic " + paramBoolean + ",tempPath=" + paramString);
      }
      localHashSet = new HashSet(a(paramBoolean));
      localHashSet.add(paramString);
      localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (paramString = "qqsetting_auto_save_path_pic_key";; paramString = "qqsetting_auto_save_path_video_key")
    {
      SharedPreferencesHandler.a(localEditor, paramString, localHashSet);
      localEditor.commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.util.AutoSaveUtils
 * JD-Core Version:    0.7.0.1
 */