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
    String str;
    if (paramBoolean) {
      str = "qqsetting_auto_save_path_pic_key";
    } else {
      str = "qqsetting_auto_save_path_video_key";
    }
    return SharedPreferencesHandler.a(localSharedPreferences, str, new HashSet());
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
      if (paramBoolean2)
      {
        paramString.run();
        return;
      }
      ThreadManagerV2.executeOnFileThread(paramString);
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
    String str;
    if (paramBoolean) {
      str = "qqsetting_auto_save_path_pic_key";
    } else {
      str = "qqsetting_auto_save_path_video_key";
    }
    localEditor.putStringSet(str, new HashSet());
    localEditor.commit();
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
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (a(paramBoolean))
      {
        Set localSet = a(paramBoolean);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("autoSaveMediaInSp: isPic ");
            localStringBuilder.append(paramBoolean);
            localStringBuilder.append(",path=");
            localStringBuilder.append(str);
            QLog.d("AutoSaveUtils", 2, localStringBuilder.toString());
          }
          if (localSet.contains(str)) {
            a(str, paramBoolean);
          }
        }
        a(paramBoolean);
      }
    }
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramBoolean1) {
      str = "qqsetting_auto_save_pic_key";
    } else {
      str = "qqsetting_auto_save_video_key";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean2);
    localEditor.commit();
  }
  
  public static boolean a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramBoolean) {
      str = "qqsetting_auto_save_pic_key";
    } else {
      str = "qqsetting_auto_save_video_key";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static void b(boolean paramBoolean, String paramString)
  {
    if (a(paramBoolean))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addAutoSavePath: isPic ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(",tempPath=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AutoSaveUtils", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new HashSet(a(paramBoolean));
      ((Set)localObject).add(paramString);
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("setting_auto_save_sp", 4).edit();
      if (paramBoolean) {
        paramString = "qqsetting_auto_save_path_pic_key";
      } else {
        paramString = "qqsetting_auto_save_path_video_key";
      }
      SharedPreferencesHandler.a(localEditor, paramString, (Set)localObject);
      localEditor.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.AutoSaveUtils
 * JD-Core Version:    0.7.0.1
 */