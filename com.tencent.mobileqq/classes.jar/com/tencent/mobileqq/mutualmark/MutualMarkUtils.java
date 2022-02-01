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
  public static HashMap<String, Integer> b;
  public static final long[] c = { 1L, 2L, 3L, 26L };
  private static HashMap<String, Integer> d = new HashMap();
  
  static
  {
    Object localObject1 = d;
    Integer localInteger1 = Integer.valueOf(2130852312);
    ((HashMap)localObject1).put("hot_reactive_gray_intimate_lover_1_icon", localInteger1);
    Object localObject2 = d;
    localObject1 = Integer.valueOf(2130852313);
    ((HashMap)localObject2).put("hot_reactive_gray_intimate_lover_2_icon", localObject1);
    Object localObject3 = d;
    localObject2 = Integer.valueOf(2130852314);
    ((HashMap)localObject3).put("hot_reactive_gray_intimate_lover_3_icon", localObject2);
    Object localObject4 = d;
    localObject3 = Integer.valueOf(2130852306);
    ((HashMap)localObject4).put("hot_reactive_gray_intimate_guimi_1_icon", localObject3);
    Object localObject5 = d;
    localObject4 = Integer.valueOf(2130852307);
    ((HashMap)localObject5).put("hot_reactive_gray_intimate_guimi_2_icon", localObject4);
    HashMap localHashMap = d;
    localObject5 = Integer.valueOf(2130852308);
    localHashMap.put("hot_reactive_gray_intimate_guimi_3_icon", localObject5);
    localHashMap = d;
    Integer localInteger2 = Integer.valueOf(2130852309);
    localHashMap.put("hot_reactive_gray_intimate_jiyou_1_icon", localInteger2);
    d.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130852310));
    d.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130852311));
    d.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130852303));
    d.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130852304));
    d.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130852305));
    d.put("gray_small_fire", Integer.valueOf(2130852336));
    d.put("gray_big_fire", Integer.valueOf(2130852283));
    d.put("gray_small_zan", Integer.valueOf(2130852340));
    d.put("gray_big_zan", Integer.valueOf(2130852287));
    d.put("gray_small_lover", Integer.valueOf(2130852328));
    d.put("gray_big_lover", Integer.valueOf(2130852327));
    d.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130852334));
    d.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130852335));
    d.put("gray_small_ship", Integer.valueOf(2130852339));
    d.put("gray_big_ship", Integer.valueOf(2130852286));
    a = new HashMap();
    a.put("skin_icon_small_fire", Integer.valueOf(2130852336));
    a.put("skin_icon_big_fire", Integer.valueOf(2130852283));
    a.put("skin_icon_fire_1", Integer.valueOf(2130852294));
    a.put("skin_icon_fire_2", Integer.valueOf(2130852295));
    a.put("skin_icon_fire_3", Integer.valueOf(2130852296));
    a.put("skin_icon_fire_4", Integer.valueOf(2130852297));
    a.put("skin_icon_fire_5", Integer.valueOf(2130852298));
    a.put("skin_icon_fire_6", Integer.valueOf(2130852299));
    a.put("skin_icon_small_flower", Integer.valueOf(2130852339));
    a.put("skin_icon_big_flower", Integer.valueOf(2130852286));
    a.put("skin_icon_small_praise", Integer.valueOf(2130852340));
    a.put("skin_icon_big_praise", Integer.valueOf(2130852287));
    a.put("skin_icon_lover_small", Integer.valueOf(2130852328));
    a.put("skin_icon_lover_big", Integer.valueOf(2130852327));
    a.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130852334));
    a.put("skin_icon_qzone_visit_super", Integer.valueOf(2130852335));
    a.put("skin_icon_frdship_1", Integer.valueOf(2130852303));
    a.put("skin_icon_frdship_2", Integer.valueOf(2130852304));
    a.put("skin_icon_frdship_3", Integer.valueOf(2130852305));
    a.put("skin_icon_intimate_lover_1", localInteger1);
    a.put("skin_icon_intimate_lover_2", localObject1);
    a.put("skin_icon_intimate_lover_3", localObject2);
    a.put("skin_icon_intimate_guimi_1", localObject3);
    a.put("skin_icon_intimate_guimi_2", localObject4);
    a.put("skin_icon_intimate_guimi_3", localObject5);
    a.put("skin_icon_intimate_sidang_1", Integer.valueOf(2130852318));
    a.put("skin_icon_intimate_sidang_2", Integer.valueOf(2130852319));
    a.put("skin_icon_intimate_sidang_3", Integer.valueOf(2130852320));
    a.put("skin_icon_intimate_jiyou_1", localInteger2);
    a.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130852310));
    a.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130852311));
    a.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130852333));
    a.put("skin_icon_mentorship", Integer.valueOf(2130852331));
    a.put("skin_icon_mentorship_svip", Integer.valueOf(2130852330));
    a.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130852332));
    a.put("skin_icon_mentorship_newyear", Integer.valueOf(2130852329));
    a.put("skin_icon_kapu_1", Integer.valueOf(2130852321));
    a.put("skin_icon_kapu_2", Integer.valueOf(2130852322));
    a.put("skin_icon_kapu_3", Integer.valueOf(2130852323));
    a.put("skin_icon_forget_me_not_1", Integer.valueOf(2130852300));
    a.put("skin_icon_forget_me_not_2", Integer.valueOf(2130852301));
    a.put("skin_icon_forget_me_not_3", Integer.valueOf(2130852302));
    a.put("skin_icon_listen_together_1", Integer.valueOf(2130852324));
    a.put("skin_icon_listen_together_2", Integer.valueOf(2130852325));
    a.put("skin_icon_listen_together_3", Integer.valueOf(2130852326));
    b = new HashMap();
    b.putAll(d);
    b.putAll(a);
    b.putAll(MutualMarkAlienationUtils.a);
  }
  
  public static int a()
  {
    return TimeFormatterUtils.a(NetConnInfoCenter.getServerTimeMillis());
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
  
  public static String a(long paramLong1, long paramLong2)
  {
    return String.valueOf(paramLong1 * 10L + 100000L + paramLong2);
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
        if (!f(paramString2))
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject = MutualMarkConfProcessor.a().b();
      boolean bool = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(false);
      paramQQAppInterface = MutualMarkConfProcessor.a().k;
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
        QQToast.makeText(paramContext, 1, 2131897027, 0).show();
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
        if (TimeFormatterUtils.c(paramLong) == 2131917319) {
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
  
  public static int b(long paramLong1, long paramLong2)
  {
    return (int)(paramLong1 * 10L + 100000L + paramLong2);
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
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_0
    //   4: invokestatic 447	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   7: invokevirtual 451	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   10: ldc_w 453
    //   13: invokevirtual 459	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_0
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokestatic 464	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: astore_0
    //   28: aload_2
    //   29: ifnull +32 -> 61
    //   32: aload_2
    //   33: invokevirtual 469	java/io/InputStream:close	()V
    //   36: aload_3
    //   37: areturn
    //   38: astore_1
    //   39: goto +24 -> 63
    //   42: astore_2
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: invokevirtual 472	java/lang/Throwable:printStackTrace	()V
    //   49: aload_1
    //   50: ifnull +7 -> 57
    //   53: aload_1
    //   54: invokevirtual 469	java/io/InputStream:close	()V
    //   57: ldc_w 474
    //   60: astore_0
    //   61: aload_0
    //   62: areturn
    //   63: aload_0
    //   64: ifnull +7 -> 71
    //   67: aload_0
    //   68: invokevirtual 469	java/io/InputStream:close	()V
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
  
  public static String b(int paramInt)
  {
    Iterator localIterator = a.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    localIterator = MutualMarkAlienationUtils.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getValue()).intValue() == paramInt) {
        return (String)localEntry.getKey();
      }
    }
    return "";
  }
  
  public static boolean b(long paramLong)
  {
    Object localObject = MutualMarkConfProcessor.a();
    if ((((MutualMarkConfBean)localObject).f != null) && (((MutualMarkConfBean)localObject).f.keySet().size() > 0))
    {
      localObject = ((MutualMarkConfBean)localObject).f.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Long)((Iterator)localObject).next()).longValue() == paramLong) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return true;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return AppSetting.b(paramString1) >= 0;
    }
    if ((TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return AppSetting.b(paramString2) <= 0;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return (AppSetting.b(paramString1) >= 0) && (AppSetting.b(paramString2) <= 0);
    }
    return true;
  }
  
  public static List<String> c()
  {
    ArrayList localArrayList = new ArrayList(b.keySet());
    Collections.sort(localArrayList, new MutualMarkUtils.1());
    return localArrayList;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 2097153) || (paramInt == 2097154) || (paramInt == 2097155);
  }
  
  public static boolean c(long paramLong)
  {
    if (b(paramLong))
    {
      long[] arrayOfLong = c;
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
  
  public static boolean c(String paramString)
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
  
  public static String d(String paramString)
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
  
  public static ArrayList<MutualMarkUtils.ImageUrlTemplateInfo> e(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    while (paramString.find())
    {
      MutualMarkUtils.ImageUrlTemplateInfo localImageUrlTemplateInfo = new MutualMarkUtils.ImageUrlTemplateInfo();
      localImageUrlTemplateInfo.c = paramString.group();
      localImageUrlTemplateInfo.a = paramString.start();
      localImageUrlTemplateInfo.b = (localImageUrlTemplateInfo.a + localImageUrlTemplateInfo.c.length());
      localImageUrlTemplateInfo.d = paramString.group(1);
      Object localObject;
      if ((!TextUtils.isEmpty(localImageUrlTemplateInfo.d)) && (localImageUrlTemplateInfo.d.contains("client/42px-")))
      {
        localObject = Pattern.compile("x_character/([^\\)]+?)/client").matcher(localImageUrlTemplateInfo.d);
        if (((Matcher)localObject).find()) {
          localImageUrlTemplateInfo.e = ((Matcher)localObject).group(1);
        }
      }
      localArrayList.add(localImageUrlTemplateInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMutualMarkImageUrlTemplateInfos. url:");
        ((StringBuilder)localObject).append(localImageUrlTemplateInfo.d);
        ((StringBuilder)localObject).append(" template:");
        ((StringBuilder)localObject).append(localImageUrlTemplateInfo.c);
        QLog.i("MutualMarkUtils", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localArrayList;
  }
  
  public static boolean f(String paramString)
  {
    return paramString.contains("://");
  }
  
  public static String g(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!f(paramString)) {
        str = a(MutualMarkConfProcessor.a().k, paramString);
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkUtils
 * JD-Core Version:    0.7.0.1
 */