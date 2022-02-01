package com.tencent.mobileqq.mutualmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.webview.util.WebViewComUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MutualMarkUtils
{
  public static HashMap<String, Integer> a;
  public static final long[] a;
  public static HashMap<String, Integer> b;
  private static HashMap<String, Integer> c = new HashMap();
  
  static
  {
    Object localObject1 = c;
    Integer localInteger1 = Integer.valueOf(2130850516);
    ((HashMap)localObject1).put("hot_reactive_gray_intimate_lover_1_icon", localInteger1);
    Object localObject2 = c;
    localObject1 = Integer.valueOf(2130850517);
    ((HashMap)localObject2).put("hot_reactive_gray_intimate_lover_2_icon", localObject1);
    Object localObject3 = c;
    localObject2 = Integer.valueOf(2130850518);
    ((HashMap)localObject3).put("hot_reactive_gray_intimate_lover_3_icon", localObject2);
    Object localObject4 = c;
    localObject3 = Integer.valueOf(2130850510);
    ((HashMap)localObject4).put("hot_reactive_gray_intimate_guimi_1_icon", localObject3);
    Object localObject5 = c;
    localObject4 = Integer.valueOf(2130850511);
    ((HashMap)localObject5).put("hot_reactive_gray_intimate_guimi_2_icon", localObject4);
    HashMap localHashMap = c;
    localObject5 = Integer.valueOf(2130850512);
    localHashMap.put("hot_reactive_gray_intimate_guimi_3_icon", localObject5);
    localHashMap = c;
    Integer localInteger2 = Integer.valueOf(2130850513);
    localHashMap.put("hot_reactive_gray_intimate_jiyou_1_icon", localInteger2);
    c.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130850514));
    c.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130850515));
    c.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130850507));
    c.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130850508));
    c.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130850509));
    c.put("gray_small_fire", Integer.valueOf(2130850540));
    c.put("gray_big_fire", Integer.valueOf(2130850487));
    c.put("gray_small_zan", Integer.valueOf(2130850544));
    c.put("gray_big_zan", Integer.valueOf(2130850491));
    c.put("gray_small_lover", Integer.valueOf(2130850532));
    c.put("gray_big_lover", Integer.valueOf(2130850531));
    c.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130850538));
    c.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130850539));
    c.put("gray_small_ship", Integer.valueOf(2130850543));
    c.put("gray_big_ship", Integer.valueOf(2130850490));
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_small_fire", Integer.valueOf(2130850540));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_big_fire", Integer.valueOf(2130850487));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_1", Integer.valueOf(2130850498));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_2", Integer.valueOf(2130850499));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_3", Integer.valueOf(2130850500));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_4", Integer.valueOf(2130850501));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_5", Integer.valueOf(2130850502));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_6", Integer.valueOf(2130850503));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_small_flower", Integer.valueOf(2130850543));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_big_flower", Integer.valueOf(2130850490));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_small_praise", Integer.valueOf(2130850544));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_big_praise", Integer.valueOf(2130850491));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_lover_small", Integer.valueOf(2130850532));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_lover_big", Integer.valueOf(2130850531));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130850538));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_qzone_visit_super", Integer.valueOf(2130850539));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_frdship_1", Integer.valueOf(2130850507));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_frdship_2", Integer.valueOf(2130850508));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_frdship_3", Integer.valueOf(2130850509));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_lover_1", localInteger1);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_lover_2", localObject1);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_lover_3", localObject2);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_guimi_1", localObject3);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_guimi_2", localObject4);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_guimi_3", localObject5);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_sidang_1", Integer.valueOf(2130850522));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_sidang_2", Integer.valueOf(2130850523));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_sidang_3", Integer.valueOf(2130850524));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_jiyou_1", localInteger2);
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130850514));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130850515));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130850537));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship", Integer.valueOf(2130850535));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship_svip", Integer.valueOf(2130850534));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130850536));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship_newyear", Integer.valueOf(2130850533));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_kapu_1", Integer.valueOf(2130850525));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_kapu_2", Integer.valueOf(2130850526));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_kapu_3", Integer.valueOf(2130850527));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_forget_me_not_1", Integer.valueOf(2130850504));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_forget_me_not_2", Integer.valueOf(2130850505));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_forget_me_not_3", Integer.valueOf(2130850506));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_listen_together_1", Integer.valueOf(2130850528));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_listen_together_2", Integer.valueOf(2130850529));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_listen_together_3", Integer.valueOf(2130850530));
    b = new HashMap();
    b.putAll(c);
    b.putAll(jdField_a_of_type_JavaUtilHashMap);
    b.putAll(MutualMarkAlienationUtils.jdField_a_of_type_JavaUtilHashMap);
    jdField_a_of_type_ArrayOfLong = new long[] { 1L, 2L, 3L, 26L };
  }
  
  public static int a()
  {
    return TimeFormatterUtils.a(NetConnInfoCenter.getServerTimeMillis());
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    return (int)(paramLong1 * 10L + 100000L + paramLong2);
  }
  
  public static long a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        long l = Long.valueOf(Long.parseLong(paramString)).longValue();
        return l % 10L;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTypeLevel error:");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("MutualMarkUtils", 1, localStringBuilder.toString());
      }
    }
    return 0L;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_0
    //   4: invokestatic 300	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 306	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   10: ldc_w 308
    //   13: invokevirtual 314	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokestatic 319	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_0
    //   28: aload_2
    //   29: ifnull +32 -> 61
    //   32: aload_2
    //   33: invokevirtual 324	java/io/InputStream:close	()V
    //   36: aload_3
    //   37: areturn
    //   38: astore_1
    //   39: goto +24 -> 63
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 327	java/lang/Throwable:printStackTrace	()V
    //   49: aload_1
    //   50: ifnull +7 -> 57
    //   53: aload_1
    //   54: invokevirtual 324	java/io/InputStream:close	()V
    //   57: ldc_w 329
    //   60: astore_0
    //   61: aload_0
    //   62: areturn
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 324	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: athrow
    //   73: astore_0
    //   74: aload_3
    //   75: areturn
    //   76: astore_0
    //   77: goto -20 -> 57
    //   80: astore_0
    //   81: goto -10 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	65	0	localObject1	Object
    //   73	1	0	localIOException1	java.io.IOException
    //   76	1	0	localIOException2	java.io.IOException
    //   80	1	0	localIOException3	java.io.IOException
    //   1	20	1	localObject2	Object
    //   38	34	1	localObject3	Object
    //   16	17	2	localInputStream	java.io.InputStream
    //   42	4	2	localThrowable	java.lang.Throwable
    //   25	50	3	str	String
    // Exception table:
    //   from	to	target	type
    //   4	17	38	finally
    //   21	26	38	finally
    //   45	49	38	finally
    //   4	17	42	java/lang/Throwable
    //   21	26	42	java/lang/Throwable
    //   32	36	73	java/io/IOException
    //   53	57	76	java/io/IOException
    //   67	71	80	java/io/IOException
  }
  
  public static String a(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    localIterator = MutualMarkAlienationUtils.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public static String a(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1 * 10L + 100000L + paramLong2);
  }
  
  public static String a(String paramString)
  {
    Object localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    if (((Matcher)localObject).matches())
    {
      localObject = ((Matcher)localObject).group(1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMutualMarkImageUrlTemplateUrl. url:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" template:");
        localStringBuilder.append(paramString);
        QLog.i("MutualMarkUtils", 2, localStringBuilder.toString());
      }
      return localObject;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString2;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString2;
        if (!b(paramString2))
        {
          if ((paramString1.endsWith("/")) && (paramString2.startsWith("/")))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(paramString2.substring(1));
            return ((StringBuilder)localObject).toString();
          }
          if ((paramString1.endsWith("/")) && (!paramString2.startsWith("/")))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(paramString2);
            return ((StringBuilder)localObject).toString();
          }
          if ((!paramString1.endsWith("/")) && (paramString2.startsWith("/")))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString1);
            ((StringBuilder)localObject).append(paramString2);
            return ((StringBuilder)localObject).toString();
          }
          localObject = paramString2;
          if (!paramString1.endsWith("/"))
          {
            localObject = paramString2;
            if (!paramString2.startsWith("/"))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString1);
              ((StringBuilder)localObject).append("/");
              ((StringBuilder)localObject).append(paramString2);
              localObject = ((StringBuilder)localObject).toString();
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static ArrayList<MutualMarkUtils.ImageUrlTemplateInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    while (paramString.find())
    {
      MutualMarkUtils.ImageUrlTemplateInfo localImageUrlTemplateInfo = new MutualMarkUtils.ImageUrlTemplateInfo();
      localImageUrlTemplateInfo.jdField_a_of_type_JavaLangString = paramString.group();
      localImageUrlTemplateInfo.jdField_a_of_type_Int = paramString.start();
      localImageUrlTemplateInfo.jdField_b_of_type_Int = (localImageUrlTemplateInfo.jdField_a_of_type_Int + localImageUrlTemplateInfo.jdField_a_of_type_JavaLangString.length());
      localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString = paramString.group(1);
      Object localObject;
      if ((!TextUtils.isEmpty(localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString)) && (localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString.contains("client/42px-")))
      {
        localObject = Pattern.compile("x_character/([^\\)]+?)/client").matcher(localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString);
        if (((Matcher)localObject).find()) {
          localImageUrlTemplateInfo.c = ((Matcher)localObject).group(1);
        }
      }
      localArrayList.add(localImageUrlTemplateInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMutualMarkImageUrlTemplateInfos. url:");
        ((StringBuilder)localObject).append(localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" template:");
        ((StringBuilder)localObject).append(localImageUrlTemplateInfo.jdField_a_of_type_JavaLangString);
        QLog.i("MutualMarkUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localArrayList;
  }
  
  public static List<String> a()
  {
    ArrayList localArrayList = new ArrayList(b.keySet());
    Collections.sort(localArrayList, new MutualMarkUtils.1());
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = MutualMarkConfProcessor.a().a();
      boolean bool = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(false);
      paramQQAppInterface = MutualMarkConfProcessor.a().f;
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append("switch=");
      ((StringBuilder)localObject).append(bool ^ true);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("prefix=");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("entry=");
      ((StringBuilder)localObject).append(paramInt);
      paramQQAppInterface = ((StringBuilder)localObject).toString();
      if ((WebViewComUtils.a(1000L)) && (!TextUtils.isEmpty(paramQQAppInterface)))
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramQQAppInterface);
        paramContext.startActivity((Intent)localObject);
        return;
      }
      if ((paramContext instanceof Activity)) {
        QQToast.a(paramContext, 1, 2131699018, 0).a();
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt > 100000)
    {
      if (paramInt >= 200000) {
        return false;
      }
      return b(String.valueOf(paramInt)) > 0L;
    }
    return false;
  }
  
  public static boolean a(long paramLong)
  {
    boolean bool2 = false;
    if (paramLong <= 0L) {
      return false;
    }
    int i = a();
    boolean bool1 = bool2;
    if (i >= 18)
    {
      bool1 = bool2;
      if (i < 24)
      {
        if (TimeFormatterUtils.c(paramLong) == 2131719716) {
          return false;
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAppInterface != null)
    {
      bool1 = bool2;
      if (paramAppInterface.getApp() != null)
      {
        bool1 = bool2;
        if (paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 0) == 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("#image_url")) && (Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString).matches())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isMutualMarkImageUrlTemplate. res:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" template:");
      localStringBuilder.append(paramString);
      QLog.i("MutualMarkUtils", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return true;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return AppSetting.a(paramString1) >= 0;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return AppSetting.a(paramString2) <= 0;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return (AppSetting.a(paramString1) >= 0) && (AppSetting.a(paramString2) <= 0);
    }
    return true;
  }
  
  public static long b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = Long.valueOf(Long.parseLong(paramString));
        long l = (paramString.longValue() - 100000L - paramString.longValue() % 10L) / 10L;
        return l;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getType error:");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("MutualMarkUtils", 1, localStringBuilder.toString());
      }
    }
    return 0L;
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!b(paramString)) {
        str = a(MutualMarkConfProcessor.a().f, paramString);
      }
    }
    return str;
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 2097153) || (paramInt == 2097154) || (paramInt == 2097155);
  }
  
  public static boolean b(long paramLong)
  {
    Object localObject = MutualMarkConfProcessor.a();
    if ((((MutualMarkConfBean)localObject).jdField_a_of_type_JavaUtilHashMap != null) && (((MutualMarkConfBean)localObject).jdField_a_of_type_JavaUtilHashMap.keySet().size() > 0))
    {
      localObject = ((MutualMarkConfBean)localObject).jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Long)((Iterator)localObject).next()).longValue() == paramLong) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return paramString.contains("://");
  }
  
  public static boolean c(long paramLong)
  {
    if (b(paramLong))
    {
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfLong[i] == paramLong) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkUtils
 * JD-Core Version:    0.7.0.1
 */