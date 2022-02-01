package com.tencent.mobileqq.mutualmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
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
    c.put("hot_reactive_gray_intimate_lover_1_icon", Integer.valueOf(2130850590));
    c.put("hot_reactive_gray_intimate_lover_2_icon", Integer.valueOf(2130850591));
    c.put("hot_reactive_gray_intimate_lover_3_icon", Integer.valueOf(2130850592));
    c.put("hot_reactive_gray_intimate_guimi_1_icon", Integer.valueOf(2130850584));
    c.put("hot_reactive_gray_intimate_guimi_2_icon", Integer.valueOf(2130850585));
    c.put("hot_reactive_gray_intimate_guimi_3_icon", Integer.valueOf(2130850586));
    c.put("hot_reactive_gray_intimate_jiyou_1_icon", Integer.valueOf(2130850587));
    c.put("hot_reactive_gray_intimate_jiyou_2_icon", Integer.valueOf(2130850588));
    c.put("hot_reactive_gray_intimate_jiyou_3_icon", Integer.valueOf(2130850589));
    c.put("hot_reactive_gray_friendship_1_icon", Integer.valueOf(2130850581));
    c.put("hot_reactive_gray_friendship_2_icon", Integer.valueOf(2130850582));
    c.put("hot_reactive_gray_friendship_3_icon", Integer.valueOf(2130850583));
    c.put("gray_small_fire", Integer.valueOf(2130850614));
    c.put("gray_big_fire", Integer.valueOf(2130850561));
    c.put("gray_small_zan", Integer.valueOf(2130850618));
    c.put("gray_big_zan", Integer.valueOf(2130850565));
    c.put("gray_small_lover", Integer.valueOf(2130850606));
    c.put("gray_big_lover", Integer.valueOf(2130850605));
    c.put("qzone_gray_qzone_visit_normal", Integer.valueOf(2130850612));
    c.put("qzone_gray_qzone_visit_super", Integer.valueOf(2130850613));
    c.put("gray_small_ship", Integer.valueOf(2130850617));
    c.put("gray_big_ship", Integer.valueOf(2130850564));
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_small_fire", Integer.valueOf(2130850614));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_big_fire", Integer.valueOf(2130850561));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_1", Integer.valueOf(2130850572));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_2", Integer.valueOf(2130850573));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_3", Integer.valueOf(2130850574));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_4", Integer.valueOf(2130850575));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_5", Integer.valueOf(2130850576));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_fire_6", Integer.valueOf(2130850577));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_small_flower", Integer.valueOf(2130850617));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_big_flower", Integer.valueOf(2130850564));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_small_praise", Integer.valueOf(2130850618));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_big_praise", Integer.valueOf(2130850565));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_lover_small", Integer.valueOf(2130850606));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_lover_big", Integer.valueOf(2130850605));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_qzone_visit_normal", Integer.valueOf(2130850612));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_qzone_visit_super", Integer.valueOf(2130850613));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_frdship_1", Integer.valueOf(2130850581));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_frdship_2", Integer.valueOf(2130850582));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_frdship_3", Integer.valueOf(2130850583));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_lover_1", Integer.valueOf(2130850590));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_lover_2", Integer.valueOf(2130850591));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_lover_3", Integer.valueOf(2130850592));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_guimi_1", Integer.valueOf(2130850584));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_guimi_2", Integer.valueOf(2130850585));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_guimi_3", Integer.valueOf(2130850586));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_sidang_1", Integer.valueOf(2130850596));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_sidang_2", Integer.valueOf(2130850597));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_sidang_3", Integer.valueOf(2130850598));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_jiyou_1", Integer.valueOf(2130850587));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_jiyou_2", Integer.valueOf(2130850588));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_intimate_jiyou_3", Integer.valueOf(2130850589));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mutual_x_character_1", Integer.valueOf(2130850611));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship", Integer.valueOf(2130850609));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship_svip", Integer.valueOf(2130850608));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship_yellowvip", Integer.valueOf(2130850610));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_mentorship_newyear", Integer.valueOf(2130850607));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_kapu_1", Integer.valueOf(2130850599));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_kapu_2", Integer.valueOf(2130850600));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_kapu_3", Integer.valueOf(2130850601));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_forget_me_not_1", Integer.valueOf(2130850578));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_forget_me_not_2", Integer.valueOf(2130850579));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_forget_me_not_3", Integer.valueOf(2130850580));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_listen_together_1", Integer.valueOf(2130850602));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_listen_together_2", Integer.valueOf(2130850603));
    jdField_a_of_type_JavaUtilHashMap.put("skin_icon_listen_together_3", Integer.valueOf(2130850604));
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
    return (int)(100000L + 10L * paramLong1 + paramLong2);
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.valueOf(Long.parseLong(paramString)).longValue() % 10L;
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("MutualMarkUtils", 1, "getTypeLevel error:" + paramString.getMessage());
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
    //   4: ldc_w 296
    //   7: astore_3
    //   8: invokestatic 302	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 308	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc_w 310
    //   17: invokevirtual 316	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: aload_2
    //   24: astore_1
    //   25: aload_2
    //   26: invokestatic 321	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   29: astore 4
    //   31: aload 4
    //   33: astore_0
    //   34: aload_0
    //   35: astore_1
    //   36: aload_2
    //   37: ifnull +9 -> 46
    //   40: aload_2
    //   41: invokevirtual 326	java/io/InputStream:close	()V
    //   44: aload_0
    //   45: astore_1
    //   46: aload_1
    //   47: areturn
    //   48: astore_2
    //   49: aload_0
    //   50: astore_1
    //   51: aload_2
    //   52: invokevirtual 329	java/lang/Throwable:printStackTrace	()V
    //   55: aload_3
    //   56: astore_1
    //   57: aload_0
    //   58: ifnull -12 -> 46
    //   61: aload_0
    //   62: invokevirtual 326	java/io/InputStream:close	()V
    //   65: ldc_w 296
    //   68: areturn
    //   69: astore_0
    //   70: ldc_w 296
    //   73: areturn
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 326	java/io/InputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -6 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	59	0	localObject1	Object
    //   69	1	0	localIOException1	java.io.IOException
    //   74	13	0	str1	String
    //   1	79	1	localObject2	Object
    //   85	1	1	localIOException2	java.io.IOException
    //   88	1	1	localIOException3	java.io.IOException
    //   20	21	2	localInputStream	java.io.InputStream
    //   48	4	2	localThrowable	java.lang.Throwable
    //   7	49	3	str2	String
    //   29	3	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   8	21	48	java/lang/Throwable
    //   25	31	48	java/lang/Throwable
    //   61	65	69	java/io/IOException
    //   8	21	74	finally
    //   25	31	74	finally
    //   51	55	74	finally
    //   40	44	85	java/io/IOException
    //   79	83	88	java/io/IOException
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
    return String.valueOf(100000L + 10L * paramLong1 + paramLong2);
  }
  
  public static String a(String paramString)
  {
    Object localObject = Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString);
    if (((Matcher)localObject).matches())
    {
      localObject = ((Matcher)localObject).group(1);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateUrl. url:" + (String)localObject + " template:" + paramString);
      }
      return localObject;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (!b(paramString2))
        {
          if ((!paramString1.endsWith("/")) || (!paramString2.startsWith("/"))) {
            break label72;
          }
          str = paramString1 + paramString2.substring(1);
        }
      }
    }
    label72:
    do
    {
      do
      {
        return str;
        if ((paramString1.endsWith("/")) && (!paramString2.startsWith("/"))) {
          return paramString1 + paramString2;
        }
        if ((!paramString1.endsWith("/")) && (paramString2.startsWith("/"))) {
          return paramString1 + paramString2;
        }
        str = paramString2;
      } while (paramString1.endsWith("/"));
      str = paramString2;
    } while (paramString2.startsWith("/"));
    return paramString1 + "/" + paramString2;
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
      if ((!TextUtils.isEmpty(localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString)) && (localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString.contains("client/42px-")))
      {
        Matcher localMatcher = Pattern.compile("x_character/([^\\)]+?)/client").matcher(localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString);
        if (localMatcher.find()) {
          localImageUrlTemplateInfo.c = localMatcher.group(1);
        }
      }
      localArrayList.add(localImageUrlTemplateInfo);
      if (QLog.isColorLevel()) {
        QLog.i("MutualMarkUtils", 2, "getMutualMarkImageUrlTemplateInfos. url:" + localImageUrlTemplateInfo.jdField_b_of_type_JavaLangString + " template:" + localImageUrlTemplateInfo.jdField_a_of_type_JavaLangString);
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
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return;
      Object localObject = MutualMarkConfProcessor.a().a();
      boolean bool = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(false);
      paramQQAppInterface = MutualMarkConfProcessor.a().f;
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append("?");
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append("switch=");
      if (bool) {}
      for (int i = 0;; i = 1)
      {
        localStringBuilder.append(i).append("&");
        ((StringBuilder)localObject).append("prefix=").append(paramQQAppInterface).append("&");
        ((StringBuilder)localObject).append("entry=").append(paramInt);
        paramQQAppInterface = ((StringBuilder)localObject).toString();
        if ((!QQBrowserActivity.checkNotFrequentlyThenEnter(1000L)) || (TextUtils.isEmpty(paramQQAppInterface))) {
          break;
        }
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramQQAppInterface);
        paramContext.startActivity((Intent)localObject);
        return;
      }
    } while (!(paramContext instanceof Activity));
    QQToast.a(paramContext, 1, 2131698939, 0).a();
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt <= 100000) || (paramInt >= 200000)) {}
    while (b(String.valueOf(paramInt)) <= 0L) {
      return false;
    }
    return true;
  }
  
  public static boolean a(long paramLong)
  {
    if (paramLong <= 0L) {}
    int i;
    do
    {
      return false;
      i = a();
    } while ((i < 18) || (i >= 24) || (TimeFormatterUtils.c(paramLong) == 2131719984));
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null)) {
      return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 0) == 1;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.startsWith("#image_url"))
      {
        bool1 = bool2;
        if (Pattern.compile("#image_url\\{([^\\)]+?)\\}").matcher(paramString).matches()) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkUtils", 2, "isMutualMarkImageUrlTemplate. res:" + bool1 + " template:" + paramString);
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        do
        {
          return true;
          if ((TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) {
            break;
          }
        } while (AppSetting.a(paramString1) >= 0);
        return false;
        if ((!TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
          break;
        }
      } while (AppSetting.a(paramString2) <= 0);
      return false;
    } while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || ((AppSetting.a(paramString1) >= 0) && (AppSetting.a(paramString2) <= 0)));
    return false;
  }
  
  public static long b(String paramString)
  {
    long l = 0L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = Long.valueOf(Long.parseLong(paramString));
      l = (paramString.longValue() - 100000L - paramString.longValue() % 10L) / 10L;
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("MutualMarkUtils", 1, "getType error:" + paramString.getMessage());
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
    long[] arrayOfLong;
    int j;
    int i;
    if (b(paramLong))
    {
      arrayOfLong = jdField_a_of_type_ArrayOfLong;
      j = arrayOfLong.length;
      i = 0;
    }
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkUtils
 * JD-Core Version:    0.7.0.1
 */