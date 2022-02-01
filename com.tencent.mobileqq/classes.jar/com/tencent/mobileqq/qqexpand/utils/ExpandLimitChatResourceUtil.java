package com.tencent.mobileqq.qqexpand.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qqexpand.bean.chat.LimitChatRes;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

public class ExpandLimitChatResourceUtil
{
  public static final Set<String> a;
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "coverVertical.png", "coverVerticalSmall.png", "coverHorizontal.png", "expend_match_ellipisis.json", "expand_voice_animation2.json", "fire/fire_00.png", "bomb/bomb_00.png" };
    jdField_a_of_type_JavaUtilSet = new HashSet(1);
    jdField_a_of_type_JavaUtilSet.add("matchAndAIOPageForNewVersion");
  }
  
  public static String a()
  {
    return "matchAndAIOPageForNewVersion";
  }
  
  public static String a(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "coverVertical.png";
    } else if (paramInt == 2) {
      str = "coverVerticalSmall.png";
    } else {
      str = "coverHorizontal.png";
    }
    return a(str);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("limit_chat_bg_pic_md5_", null);
  }
  
  public static String a(String paramString)
  {
    return String.format("%s/%s", new Object[] { c(), paramString });
  }
  
  public static void a()
  {
    a(jdField_a_of_type_ArrayOfJavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "delBgPicFiles ");
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("limit_chat_bg_pic_md5_", paramString);
    paramContext.apply();
  }
  
  public static void a(String paramString)
  {
    a(MobileQQ.sMobileQQ, paramString);
    if (QLog.isColorLevel())
    {
      if (paramString != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBgPicResMd5 ");
        localStringBuilder.append(paramString);
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, localStringBuilder.toString());
        return;
      }
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 null");
    }
  }
  
  private static void a(String[] paramArrayOfString)
  {
    paramArrayOfString = a(paramArrayOfString);
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramArrayOfString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean a()
  {
    return a(jdField_a_of_type_ArrayOfJavaLangString);
  }
  
  public static boolean a(HashMap<String, LimitChatRes> paramHashMap)
  {
    if (paramHashMap != null)
    {
      paramHashMap = (LimitChatRes)paramHashMap.get(a());
      if (paramHashMap != null)
      {
        String str1 = paramHashMap.c;
        String str2 = b();
        boolean bool2 = TextUtils.isEmpty(str2);
        bool1 = bool2;
        paramHashMap = str1;
        if (TextUtils.isEmpty(str1)) {
          break label70;
        }
        bool1 = bool2;
        paramHashMap = str1;
        if (str1.equalsIgnoreCase(str2)) {
          break label70;
        }
        bool1 = true;
        paramHashMap = str1;
        break label70;
      }
    }
    boolean bool1 = false;
    paramHashMap = null;
    label70:
    if ((bool1) && (paramHashMap != null)) {
      a(paramHashMap);
    }
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("checkBgPicMd5 ");
      paramHashMap.append(bool1);
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, paramHashMap.toString());
    }
    return bool1;
  }
  
  private static boolean a(String[] paramArrayOfString)
  {
    return ExpandResourceUtil.a(a(paramArrayOfString));
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      String[] arrayOfString2 = new String[j];
      int i = 0;
      for (;;)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= j) {
          break;
        }
        arrayOfString2[i] = a(paramArrayOfString[i]);
        i += 1;
      }
    }
    String[] arrayOfString1 = null;
    return arrayOfString1;
  }
  
  public static String b()
  {
    String str = a(MobileQQ.sMobileQQ);
    if (QLog.isColorLevel())
    {
      if (str != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBgPicResMd5 ");
        localStringBuilder.append(str);
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, localStringBuilder.toString());
        return str;
      }
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 null");
    }
    return str;
  }
  
  public static String c()
  {
    return String.format("%s/matchChat", new Object[] { ExpandResourceUtil.a() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExpandLimitChatResourceUtil
 * JD-Core Version:    0.7.0.1
 */