package dov.com.qq.im.capture.text;

import amxn;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicTextBuilder
{
  private static final String jdField_a_of_type_JavaLangString = DynamicTextBuilder.class.getSimpleName();
  private static final Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = (DynamicTextConfigManager)QIMManager.a(7);
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), Collections.singletonList("普通文字"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), Collections.singletonList("Hi (•ω•)"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), Collections.singletonList("莫负好春光"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(3), Collections.singletonList("嘿哈"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(4), Collections.singletonList("早安"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(5), Arrays.asList(new String[] { "旅行的意义", "MY JOURNEY" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(6), Collections.singletonList("开心一整夜"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(7), Collections.singletonList("发生了什么..."));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(8), Collections.singletonList("哈哈哈哈哈"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9), Collections.singletonList("震惊了"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(10), Collections.singletonList("有句话不知当讲不当讲"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(11), Collections.singletonList("冷漠"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(12), Collections.singletonList("深夜食堂"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(13), Collections.singletonList("WHAT A FUN!"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(14), Arrays.asList(new String[] { "怪谈", "看不看得见，都在你身边" }));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(15), Collections.singletonList("吃独食"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(16), Collections.singletonList("出去浪"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(17), Collections.singletonList("沉迷学习"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(18), Collections.singletonList("企鹅岛"));
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(19), Collections.singletonList("一起来斗图"));
    ThreadManager.post(new amxn(localQQAppInterface), 5, null, false);
  }
  
  public static int a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DText", 2, "getIconDrawable type is: " + paramInt);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return 2130841765;
    case 1: 
      return 2130841749;
    case 2: 
      return 2130841756;
    case 3: 
      return 2130841752;
    case 4: 
      return 2130841755;
    case 5: 
      return 2130841753;
    case 6: 
      return 2130841750;
    case 7: 
      return 2130841767;
    case 8: 
      return 2130841751;
    case 9: 
      return 2130841769;
    case 10: 
      return 2130841760;
    case 11: 
      return 2130841744;
    case 12: 
      return 2130841764;
    case 13: 
      return 2130841768;
    case 14: 
      return 2130841770;
    case 15: 
      return 2130841758;
    case 16: 
      return 2130841762;
    case 17: 
      return 2130841759;
    case 18: 
      return 2130841754;
    }
    return 2130841748;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    List localList = a(paramInt1);
    if ((localList != null) && (paramInt2 >= 0) && (paramInt2 < localList.size())) {
      return (String)localList.get(paramInt2);
    }
    return "";
  }
  
  public static List a(int paramInt)
  {
    List localList = null;
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      localList = (List)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return localList;
  }
  
  public static List a(List paramList, @NonNull DynamicTextItem paramDynamicTextItem)
  {
    int j = 0;
    ArrayList localArrayList = paramDynamicTextItem.a();
    if ((localArrayList.isEmpty()) || (TextUtils.isEmpty((CharSequence)localArrayList.get(0)))) {
      return paramList;
    }
    Iterator localIterator = localArrayList.iterator();
    if (localIterator.hasNext())
    {
      localIterator.next();
      i = 1;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str != null) && (str.equals(a(paramDynamicTextItem.c(), i)))) {
          localIterator.remove();
        }
        i += 1;
      }
    }
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    int i = localArrayList.size();
    int m = paramList.size();
    int k = Math.min(i, paramDynamicTextItem.a());
    i = j;
    for (;;)
    {
      if ((i >= k) || (i >= m))
      {
        i = k;
        while (i < m)
        {
          localArrayList.add(paramList.get(i));
          i += 1;
        }
      }
      if (((String)localArrayList.get(i)).equals(a(paramDynamicTextItem.c(), i))) {
        localArrayList.set(i, paramList.get(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public int a(DynamicTextItem paramDynamicTextItem)
  {
    if (NormalTextItem.class.isInstance(paramDynamicTextItem)) {}
    do
    {
      return 0;
      if (BubbleTextItem.class.isInstance(paramDynamicTextItem)) {
        return 1;
      }
      if (FringesTextItems.class.isInstance(paramDynamicTextItem)) {
        return 3;
      }
      if (DonotGiveUpHealing.class.isInstance(paramDynamicTextItem)) {
        return 2;
      }
      if (RandomSizeTextItem.class.isInstance(paramDynamicTextItem)) {
        return 4;
      }
      if (JourneyTextItem.class.isInstance(paramDynamicTextItem)) {
        return 5;
      }
      if (FluorescenceTextItem.class.isInstance(paramDynamicTextItem)) {
        return 6;
      }
      if (ShadowBubbleTextItem.class.isInstance(paramDynamicTextItem)) {
        return 7;
      }
      if (FoldOverTextItem.class.isInstance(paramDynamicTextItem)) {
        return 8;
      }
      if (ShockTextItem.class.isInstance(paramDynamicTextItem)) {
        return 9;
      }
      if (HelplessTextItem.class.isInstance(paramDynamicTextItem)) {
        return 10;
      }
      if (ApathyTextItem.class.isInstance(paramDynamicTextItem)) {
        return 11;
      }
      if (MidNightTextItem.class.isInstance(paramDynamicTextItem)) {
        return 12;
      }
      if (ShakingTextItem.class.isInstance(paramDynamicTextItem)) {
        return 13;
      }
      if (GridTextItem.class.isInstance(paramDynamicTextItem)) {
        return 17;
      }
      if (SupernaturalTextItem.class.isInstance(paramDynamicTextItem)) {
        return 14;
      }
      if (FoodAloneTextItem.class.isInstance(paramDynamicTextItem)) {
        return 15;
      }
      if (LangTextItem.class.isInstance(paramDynamicTextItem)) {
        return 16;
      }
      if (LocationTextItem.class.isInstance(paramDynamicTextItem)) {
        return 18;
      }
    } while (!BoldTextItem.class.isInstance(paramDynamicTextItem));
    return 19;
  }
  
  /* Error */
  public DynamicTextItem a(int paramInt, @NonNull List paramList)
  {
    // Byte code:
    //   0: new 218	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 322	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_2
    //   9: invokeinterface 323 1 0
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface 238 1 0
    //   21: ifeq +22 -> 43
    //   24: aload_3
    //   25: aload_2
    //   26: invokeinterface 242 1 0
    //   31: checkcast 69	java/lang/String
    //   34: invokeinterface 324 2 0
    //   39: pop
    //   40: goto -25 -> 15
    //   43: aload_3
    //   44: astore 6
    //   46: aload_3
    //   47: invokeinterface 254 1 0
    //   52: ifeq +9 -> 61
    //   55: iload_1
    //   56: invokestatic 190	dov/com/qq/im/capture/text/DynamicTextBuilder:a	(I)Ljava/util/List;
    //   59: astore 6
    //   61: aload_0
    //   62: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   65: iload_1
    //   66: invokestatic 327	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: invokevirtual 330	dov/com/qq/im/capture/text/DynamicTextConfigManager:a	(Ljava/lang/String;)Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean;
    //   72: astore 8
    //   74: aload 8
    //   76: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   79: invokevirtual 221	java/util/ArrayList:isEmpty	()Z
    //   82: ifeq +230 -> 312
    //   85: aconst_null
    //   86: astore 5
    //   88: aconst_null
    //   89: astore_2
    //   90: aload 5
    //   92: ifnull +19 -> 111
    //   95: aload_0
    //   96: getfield 127	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   99: aload 5
    //   101: getfield 340	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   104: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 343	android/graphics/Typeface
    //   110: astore_2
    //   111: iload_1
    //   112: tableswitch	default:+96 -> 208, 0:+217->329, 1:+231->343, 2:+364->476, 3:+441->553, 4:+605->717, 5:+685->797, 6:+773->885, 7:+1268->1380, 8:+1564->1676, 9:+1707->1819, 10:+2027->2139, 11:+1852->1964, 12:+2172->2284, 13:+2335->2447, 14:+2469->2581, 15:+2817->2929, 16:+2951->3063, 17:+2598->2710, 18:+3225->3337, 19:+3295->3407
    //   209: nop
    //   210: fcmpl
    //   211: dup
    //   212: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 345
    //   218: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload_1
    //   222: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore_3
    //   229: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +30 -> 262
    //   235: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   238: iconst_2
    //   239: new 149	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 347
    //   249: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_3
    //   253: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: new 275	dov/com/qq/im/capture/text/NormalTextItem
    //   265: dup
    //   266: iload_1
    //   267: aload 6
    //   269: invokespecial 350	dov/com/qq/im/capture/text/NormalTextItem:<init>	(ILjava/util/List;)V
    //   272: astore_3
    //   273: aload_2
    //   274: ifnull +36 -> 310
    //   277: aload_0
    //   278: getfield 127	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   281: iload_1
    //   282: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   288: ifnonnull +22 -> 310
    //   291: aload 5
    //   293: ifnull +17 -> 310
    //   296: aload_0
    //   297: getfield 127	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   300: aload 5
    //   302: getfield 340	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   305: aload_2
    //   306: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   309: pop
    //   310: aload_3
    //   311: areturn
    //   312: aload 8
    //   314: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   317: iconst_0
    //   318: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   321: checkcast 338	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   324: astore 5
    //   326: goto -238 -> 88
    //   329: new 275	dov/com/qq/im/capture/text/NormalTextItem
    //   332: dup
    //   333: iload_1
    //   334: aload 6
    //   336: invokespecial 350	dov/com/qq/im/capture/text/NormalTextItem:<init>	(ILjava/util/List;)V
    //   339: astore_3
    //   340: goto -67 -> 273
    //   343: aload_0
    //   344: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   347: ldc_w 352
    //   350: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   356: checkcast 354	android/graphics/Bitmap
    //   359: astore 7
    //   361: aload_2
    //   362: ifnull +14 -> 376
    //   365: aload 7
    //   367: astore_3
    //   368: aload_2
    //   369: astore 4
    //   371: aload 7
    //   373: ifnonnull +68 -> 441
    //   376: new 149	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   383: aload_0
    //   384: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   387: aload 5
    //   389: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   392: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc_w 359
    //   398: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   407: astore_3
    //   408: aload_3
    //   409: astore_2
    //   410: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   413: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   416: ldc_w 352
    //   419: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   422: astore_3
    //   423: aload_0
    //   424: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   427: ldc_w 352
    //   430: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: aload_3
    //   434: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   437: pop
    //   438: aload_2
    //   439: astore 4
    //   441: new 280	dov/com/qq/im/capture/text/BubbleTextItem
    //   444: dup
    //   445: iload_1
    //   446: aload 6
    //   448: aload 4
    //   450: aload_3
    //   451: invokespecial 382	dov/com/qq/im/capture/text/BubbleTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   454: astore_3
    //   455: aload 4
    //   457: astore_2
    //   458: goto -185 -> 273
    //   461: astore_3
    //   462: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   465: iconst_2
    //   466: aload_3
    //   467: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   470: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: goto -63 -> 410
    //   476: aload_2
    //   477: astore 4
    //   479: aload_2
    //   480: ifnonnull +36 -> 516
    //   483: new 149	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   490: aload_0
    //   491: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   494: aload 5
    //   496: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   499: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 359
    //   505: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   514: astore 4
    //   516: new 284	dov/com/qq/im/capture/text/DonotGiveUpHealing
    //   519: dup
    //   520: iload_1
    //   521: aload 6
    //   523: aload 4
    //   525: invokespecial 391	dov/com/qq/im/capture/text/DonotGiveUpHealing:<init>	(ILjava/util/List;Landroid/graphics/Typeface;)V
    //   528: astore_3
    //   529: aload 4
    //   531: astore_2
    //   532: goto -259 -> 273
    //   535: astore_3
    //   536: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: iconst_2
    //   540: aload_3
    //   541: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   544: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_2
    //   548: astore 4
    //   550: goto -34 -> 516
    //   553: aload_0
    //   554: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   557: ldc_w 392
    //   560: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   566: checkcast 354	android/graphics/Bitmap
    //   569: astore 4
    //   571: aload_0
    //   572: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   575: ldc_w 393
    //   578: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   584: checkcast 354	android/graphics/Bitmap
    //   587: astore_3
    //   588: aload_2
    //   589: ifnonnull +2938 -> 3527
    //   592: new 149	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   599: aload_0
    //   600: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   603: aload 5
    //   605: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   608: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: ldc_w 359
    //   614: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   623: astore_3
    //   624: aload_3
    //   625: astore_2
    //   626: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   629: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   632: ldc_w 392
    //   635: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   638: astore 4
    //   640: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   643: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   646: ldc_w 393
    //   649: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   652: astore_3
    //   653: aload_0
    //   654: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   657: ldc_w 392
    //   660: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   663: aload 4
    //   665: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   668: pop
    //   669: aload_0
    //   670: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   673: ldc_w 393
    //   676: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   679: aload_3
    //   680: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   683: pop
    //   684: new 282	dov/com/qq/im/capture/text/FringesTextItems
    //   687: dup
    //   688: iload_1
    //   689: aload 6
    //   691: aload_2
    //   692: aload 4
    //   694: aload_3
    //   695: invokespecial 396	dov/com/qq/im/capture/text/FringesTextItems:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   698: astore_3
    //   699: goto -426 -> 273
    //   702: astore_3
    //   703: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   706: iconst_2
    //   707: aload_3
    //   708: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   711: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: goto -88 -> 626
    //   717: aload_2
    //   718: astore 4
    //   720: aload_2
    //   721: ifnonnull +36 -> 757
    //   724: new 149	java/lang/StringBuilder
    //   727: dup
    //   728: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   731: aload_0
    //   732: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   735: aload 5
    //   737: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   740: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: ldc_w 359
    //   746: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   755: astore 4
    //   757: new 286	dov/com/qq/im/capture/text/RandomSizeTextItem
    //   760: dup
    //   761: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   764: iload_1
    //   765: aload 6
    //   767: aload 4
    //   769: invokespecial 399	dov/com/qq/im/capture/text/RandomSizeTextItem:<init>	(Landroid/content/Context;ILjava/util/List;Landroid/graphics/Typeface;)V
    //   772: astore_3
    //   773: aload 4
    //   775: astore_2
    //   776: goto -503 -> 273
    //   779: astore_3
    //   780: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   783: iconst_2
    //   784: aload_3
    //   785: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   788: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: aload_2
    //   792: astore 4
    //   794: goto -37 -> 757
    //   797: aload_0
    //   798: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   801: ldc_w 400
    //   804: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   807: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   810: checkcast 354	android/graphics/Bitmap
    //   813: astore 7
    //   815: aload_0
    //   816: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   819: ldc_w 401
    //   822: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   825: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   828: checkcast 354	android/graphics/Bitmap
    //   831: astore 4
    //   833: aload 7
    //   835: astore_3
    //   836: aload 7
    //   838: ifnonnull +30 -> 868
    //   841: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   844: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   847: ldc_w 400
    //   850: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   853: astore_3
    //   854: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   857: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   860: ldc_w 401
    //   863: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   866: astore 4
    //   868: new 288	dov/com/qq/im/capture/text/JourneyTextItem
    //   871: dup
    //   872: iload_1
    //   873: aload 6
    //   875: aload_3
    //   876: aload 4
    //   878: invokespecial 404	dov/com/qq/im/capture/text/JourneyTextItem:<init>	(ILjava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   881: astore_3
    //   882: goto -609 -> 273
    //   885: aload_0
    //   886: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   889: ldc_w 405
    //   892: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   895: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   898: checkcast 354	android/graphics/Bitmap
    //   901: astore 4
    //   903: aload 4
    //   905: astore_3
    //   906: aload 4
    //   908: ifnonnull +31 -> 939
    //   911: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   914: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   917: ldc_w 405
    //   920: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   923: astore_3
    //   924: aload_0
    //   925: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   928: ldc_w 405
    //   931: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   934: aload_3
    //   935: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   938: pop
    //   939: aload_0
    //   940: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   943: ldc_w 406
    //   946: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   949: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   952: checkcast 354	android/graphics/Bitmap
    //   955: astore 7
    //   957: aload 7
    //   959: astore 4
    //   961: aload 7
    //   963: ifnonnull +33 -> 996
    //   966: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   969: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   972: ldc_w 406
    //   975: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   978: astore 4
    //   980: aload_0
    //   981: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   984: ldc_w 406
    //   987: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   990: aload 4
    //   992: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   995: pop
    //   996: aload_0
    //   997: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1000: ldc_w 407
    //   1003: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1006: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1009: checkcast 354	android/graphics/Bitmap
    //   1012: astore 8
    //   1014: aload 8
    //   1016: astore 7
    //   1018: aload 8
    //   1020: ifnonnull +33 -> 1053
    //   1023: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1026: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1029: ldc_w 407
    //   1032: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1035: astore 7
    //   1037: aload_0
    //   1038: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1041: ldc_w 407
    //   1044: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1047: aload 7
    //   1049: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1052: pop
    //   1053: aload_0
    //   1054: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1057: ldc_w 408
    //   1060: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1063: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1066: checkcast 354	android/graphics/Bitmap
    //   1069: astore 9
    //   1071: aload 9
    //   1073: astore 8
    //   1075: aload 9
    //   1077: ifnonnull +33 -> 1110
    //   1080: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1083: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1086: ldc_w 408
    //   1089: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1092: astore 8
    //   1094: aload_0
    //   1095: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1098: ldc_w 408
    //   1101: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1104: aload 8
    //   1106: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1109: pop
    //   1110: aload_0
    //   1111: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1114: ldc_w 409
    //   1117: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1120: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: checkcast 354	android/graphics/Bitmap
    //   1126: astore 10
    //   1128: aload 10
    //   1130: astore 9
    //   1132: aload 10
    //   1134: ifnonnull +33 -> 1167
    //   1137: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1140: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1143: ldc_w 409
    //   1146: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1149: astore 9
    //   1151: aload_0
    //   1152: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1155: ldc_w 409
    //   1158: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1161: aload 9
    //   1163: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1166: pop
    //   1167: aload_0
    //   1168: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1171: ldc_w 410
    //   1174: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1177: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1180: checkcast 354	android/graphics/Bitmap
    //   1183: astore 11
    //   1185: aload 11
    //   1187: astore 10
    //   1189: aload 11
    //   1191: ifnonnull +33 -> 1224
    //   1194: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1197: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1200: ldc_w 410
    //   1203: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1206: astore 10
    //   1208: aload_0
    //   1209: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1212: ldc_w 410
    //   1215: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1218: aload 10
    //   1220: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1223: pop
    //   1224: new 218	java/util/ArrayList
    //   1227: dup
    //   1228: invokespecial 322	java/util/ArrayList:<init>	()V
    //   1231: astore 11
    //   1233: aload 11
    //   1235: iconst_0
    //   1236: aload_3
    //   1237: invokeinterface 413 3 0
    //   1242: aload 11
    //   1244: iconst_1
    //   1245: aload 7
    //   1247: invokeinterface 413 3 0
    //   1252: aload 11
    //   1254: iconst_2
    //   1255: aload 4
    //   1257: invokeinterface 413 3 0
    //   1262: aload 11
    //   1264: iconst_3
    //   1265: aload 8
    //   1267: invokeinterface 413 3 0
    //   1272: aload 11
    //   1274: iconst_4
    //   1275: aload 9
    //   1277: invokeinterface 413 3 0
    //   1282: aload 11
    //   1284: iconst_5
    //   1285: aload 10
    //   1287: invokeinterface 413 3 0
    //   1292: aload_2
    //   1293: astore 4
    //   1295: aload_2
    //   1296: ifnonnull +36 -> 1332
    //   1299: new 149	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1306: aload_0
    //   1307: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1310: aload 5
    //   1312: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1315: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: ldc_w 359
    //   1321: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1327: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1330: astore 4
    //   1332: new 290	dov/com/qq/im/capture/text/FluorescenceTextItem
    //   1335: dup
    //   1336: iload_1
    //   1337: aload 6
    //   1339: aload 11
    //   1341: aload 4
    //   1343: invokespecial 416	dov/com/qq/im/capture/text/FluorescenceTextItem:<init>	(ILjava/util/List;Ljava/util/List;Landroid/graphics/Typeface;)V
    //   1346: astore_3
    //   1347: aload 4
    //   1349: astore_2
    //   1350: goto -1077 -> 273
    //   1353: astore_3
    //   1354: aload_2
    //   1355: astore 4
    //   1357: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1360: ifeq -28 -> 1332
    //   1363: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1366: iconst_2
    //   1367: aload_3
    //   1368: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1371: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1374: aload_2
    //   1375: astore 4
    //   1377: goto -45 -> 1332
    //   1380: aload_0
    //   1381: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1384: ldc_w 420
    //   1387: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1390: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1393: checkcast 354	android/graphics/Bitmap
    //   1396: astore 4
    //   1398: aload 4
    //   1400: astore_3
    //   1401: aload 4
    //   1403: ifnonnull +31 -> 1434
    //   1406: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1409: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1412: ldc_w 420
    //   1415: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1418: astore_3
    //   1419: aload_0
    //   1420: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1423: ldc_w 420
    //   1426: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1429: aload_3
    //   1430: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1433: pop
    //   1434: aload_0
    //   1435: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1438: ldc_w 421
    //   1441: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1444: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1447: checkcast 354	android/graphics/Bitmap
    //   1450: astore 7
    //   1452: aload 7
    //   1454: astore 4
    //   1456: aload 7
    //   1458: ifnonnull +33 -> 1491
    //   1461: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1464: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1467: ldc_w 421
    //   1470: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1473: astore 4
    //   1475: aload_0
    //   1476: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1479: ldc_w 421
    //   1482: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1485: aload 4
    //   1487: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1490: pop
    //   1491: aload_0
    //   1492: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1495: ldc_w 422
    //   1498: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1501: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1504: checkcast 354	android/graphics/Bitmap
    //   1507: astore 8
    //   1509: aload 8
    //   1511: astore 7
    //   1513: aload 8
    //   1515: ifnonnull +33 -> 1548
    //   1518: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1521: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1524: ldc_w 422
    //   1527: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1530: astore 7
    //   1532: aload_0
    //   1533: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1536: ldc_w 422
    //   1539: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1542: aload 7
    //   1544: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1547: pop
    //   1548: new 218	java/util/ArrayList
    //   1551: dup
    //   1552: iconst_3
    //   1553: invokespecial 425	java/util/ArrayList:<init>	(I)V
    //   1556: astore 8
    //   1558: aload 8
    //   1560: aload_3
    //   1561: invokeinterface 324 2 0
    //   1566: pop
    //   1567: aload 8
    //   1569: aload 4
    //   1571: invokeinterface 324 2 0
    //   1576: pop
    //   1577: aload 8
    //   1579: aload 7
    //   1581: invokeinterface 324 2 0
    //   1586: pop
    //   1587: aload_2
    //   1588: astore 4
    //   1590: aload_2
    //   1591: ifnonnull +36 -> 1627
    //   1594: new 149	java/lang/StringBuilder
    //   1597: dup
    //   1598: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1601: aload_0
    //   1602: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1605: aload 5
    //   1607: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1610: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: ldc_w 359
    //   1616: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1619: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1625: astore 4
    //   1627: new 292	dov/com/qq/im/capture/text/ShadowBubbleTextItem
    //   1630: dup
    //   1631: iload_1
    //   1632: aload 4
    //   1634: aload 6
    //   1636: aload 8
    //   1638: invokespecial 428	dov/com/qq/im/capture/text/ShadowBubbleTextItem:<init>	(ILandroid/graphics/Typeface;Ljava/util/List;Ljava/util/List;)V
    //   1641: astore_3
    //   1642: aload 4
    //   1644: astore_2
    //   1645: goto -1372 -> 273
    //   1648: astore_3
    //   1649: aload_2
    //   1650: astore 4
    //   1652: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1655: ifeq -28 -> 1627
    //   1658: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1661: iconst_2
    //   1662: aload_3
    //   1663: invokevirtual 431	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1666: aload_3
    //   1667: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1670: aload_2
    //   1671: astore 4
    //   1673: goto -46 -> 1627
    //   1676: aload_0
    //   1677: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1680: ldc_w 435
    //   1683: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1686: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1689: checkcast 354	android/graphics/Bitmap
    //   1692: astore 4
    //   1694: aload 4
    //   1696: astore_3
    //   1697: aload 4
    //   1699: ifnonnull +31 -> 1730
    //   1702: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1705: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1708: ldc_w 435
    //   1711: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1714: astore_3
    //   1715: aload_0
    //   1716: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1719: ldc_w 435
    //   1722: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1725: aload_3
    //   1726: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1729: pop
    //   1730: aload_2
    //   1731: astore 4
    //   1733: aload_2
    //   1734: ifnonnull +36 -> 1770
    //   1737: new 149	java/lang/StringBuilder
    //   1740: dup
    //   1741: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1744: aload_0
    //   1745: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1748: aload 5
    //   1750: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1753: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: ldc_w 359
    //   1759: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1765: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1768: astore 4
    //   1770: new 294	dov/com/qq/im/capture/text/FoldOverTextItem
    //   1773: dup
    //   1774: iload_1
    //   1775: aload 6
    //   1777: aload 4
    //   1779: aload_3
    //   1780: invokespecial 436	dov/com/qq/im/capture/text/FoldOverTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   1783: astore_3
    //   1784: aload 4
    //   1786: astore_2
    //   1787: goto -1514 -> 273
    //   1790: astore 7
    //   1792: aload_2
    //   1793: astore 4
    //   1795: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1798: ifeq -28 -> 1770
    //   1801: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1804: iconst_2
    //   1805: aload 7
    //   1807: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1810: invokestatic 419	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1813: aload_2
    //   1814: astore 4
    //   1816: goto -46 -> 1770
    //   1819: aload_0
    //   1820: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1823: ldc_w 437
    //   1826: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1829: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1832: checkcast 354	android/graphics/Bitmap
    //   1835: astore 4
    //   1837: aload 4
    //   1839: astore_3
    //   1840: aload 4
    //   1842: ifnonnull +31 -> 1873
    //   1845: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1848: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1851: ldc_w 437
    //   1854: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1857: astore_3
    //   1858: aload_0
    //   1859: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1862: ldc_w 437
    //   1865: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1868: aload_3
    //   1869: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1872: pop
    //   1873: aload_2
    //   1874: astore 4
    //   1876: aload_2
    //   1877: ifnonnull +36 -> 1913
    //   1880: new 149	java/lang/StringBuilder
    //   1883: dup
    //   1884: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1887: aload_0
    //   1888: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1891: aload 5
    //   1893: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1896: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: ldc_w 359
    //   1902: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1905: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1908: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1911: astore 4
    //   1913: new 296	dov/com/qq/im/capture/text/ShockTextItem
    //   1916: dup
    //   1917: iload_1
    //   1918: aload 6
    //   1920: aload 4
    //   1922: aload_3
    //   1923: invokespecial 438	dov/com/qq/im/capture/text/ShockTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   1926: astore_3
    //   1927: aload 4
    //   1929: astore_2
    //   1930: goto -1657 -> 273
    //   1933: astore 7
    //   1935: aload_2
    //   1936: astore 4
    //   1938: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1941: ifeq -28 -> 1913
    //   1944: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1947: iconst_2
    //   1948: aload 7
    //   1950: invokevirtual 431	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1953: aload 7
    //   1955: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1958: aload_2
    //   1959: astore 4
    //   1961: goto -48 -> 1913
    //   1964: aload_0
    //   1965: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1968: ldc_w 439
    //   1971: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1974: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1977: checkcast 354	android/graphics/Bitmap
    //   1980: astore_3
    //   1981: aload_0
    //   1982: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1985: ldc_w 440
    //   1988: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1991: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1994: checkcast 354	android/graphics/Bitmap
    //   1997: astore 4
    //   1999: aload_0
    //   2000: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2003: ldc_w 441
    //   2006: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2009: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2012: checkcast 354	android/graphics/Bitmap
    //   2015: astore 7
    //   2017: aload_3
    //   2018: ifnonnull +1506 -> 3524
    //   2021: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2024: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2027: ldc_w 439
    //   2030: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2033: astore_3
    //   2034: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2037: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2040: ldc_w 440
    //   2043: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2046: astore 4
    //   2048: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2051: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2054: ldc_w 441
    //   2057: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2060: astore 7
    //   2062: aload_2
    //   2063: ifnonnull +73 -> 2136
    //   2066: new 149	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2073: aload_0
    //   2074: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2077: aload 5
    //   2079: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2082: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2085: ldc_w 359
    //   2088: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2097: astore 8
    //   2099: aload 8
    //   2101: astore_2
    //   2102: new 300	dov/com/qq/im/capture/text/ApathyTextItem
    //   2105: dup
    //   2106: iload_1
    //   2107: aload 6
    //   2109: aload_2
    //   2110: aload_3
    //   2111: aload 4
    //   2113: aload 7
    //   2115: invokespecial 444	dov/com/qq/im/capture/text/ApathyTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   2118: astore_3
    //   2119: goto -1846 -> 273
    //   2122: astore 8
    //   2124: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2127: iconst_2
    //   2128: aload 8
    //   2130: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2133: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2136: goto -34 -> 2102
    //   2139: aload_0
    //   2140: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2143: ldc_w 445
    //   2146: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2149: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2152: checkcast 354	android/graphics/Bitmap
    //   2155: astore 4
    //   2157: aload 4
    //   2159: astore_3
    //   2160: aload 4
    //   2162: ifnonnull +31 -> 2193
    //   2165: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2168: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2171: ldc_w 445
    //   2174: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2177: astore_3
    //   2178: aload_0
    //   2179: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2182: ldc_w 445
    //   2185: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2188: aload_3
    //   2189: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2192: pop
    //   2193: aload_2
    //   2194: astore 4
    //   2196: aload_2
    //   2197: ifnonnull +36 -> 2233
    //   2200: new 149	java/lang/StringBuilder
    //   2203: dup
    //   2204: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2207: aload_0
    //   2208: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2211: aload 5
    //   2213: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2216: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2219: ldc_w 359
    //   2222: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2228: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2231: astore 4
    //   2233: new 298	dov/com/qq/im/capture/text/HelplessTextItem
    //   2236: dup
    //   2237: iload_1
    //   2238: aload 6
    //   2240: aload 4
    //   2242: aload_3
    //   2243: invokespecial 446	dov/com/qq/im/capture/text/HelplessTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   2246: astore_3
    //   2247: aload 4
    //   2249: astore_2
    //   2250: goto -1977 -> 273
    //   2253: astore 7
    //   2255: aload_2
    //   2256: astore 4
    //   2258: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2261: ifeq -28 -> 2233
    //   2264: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2267: iconst_2
    //   2268: aload 7
    //   2270: invokevirtual 431	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2273: aload 7
    //   2275: invokestatic 434	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2278: aload_2
    //   2279: astore 4
    //   2281: goto -48 -> 2233
    //   2284: aload_0
    //   2285: getfield 127	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   2288: bipush 6
    //   2290: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2293: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2296: checkcast 343	android/graphics/Typeface
    //   2299: astore_3
    //   2300: aload_3
    //   2301: ifnonnull +123 -> 2424
    //   2304: new 149	java/lang/StringBuilder
    //   2307: dup
    //   2308: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2311: aload_0
    //   2312: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2315: aload 8
    //   2317: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   2320: iconst_1
    //   2321: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2324: checkcast 338	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   2327: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2330: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2333: ldc_w 359
    //   2336: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2342: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2345: astore 4
    //   2347: aload 4
    //   2349: astore_3
    //   2350: aload_2
    //   2351: astore 4
    //   2353: aload_2
    //   2354: ifnonnull +36 -> 2390
    //   2357: new 149	java/lang/StringBuilder
    //   2360: dup
    //   2361: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2364: aload_0
    //   2365: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2368: aload 5
    //   2370: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2373: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2376: ldc_w 359
    //   2379: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2382: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2385: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2388: astore 4
    //   2390: new 302	dov/com/qq/im/capture/text/MidNightTextItem
    //   2393: dup
    //   2394: iload_1
    //   2395: aload 6
    //   2397: aload 4
    //   2399: aload_3
    //   2400: invokespecial 449	dov/com/qq/im/capture/text/MidNightTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Typeface;)V
    //   2403: astore_3
    //   2404: aload 4
    //   2406: astore_2
    //   2407: goto -2134 -> 273
    //   2410: astore 4
    //   2412: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2415: iconst_2
    //   2416: aload 4
    //   2418: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2421: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2424: goto -74 -> 2350
    //   2427: astore 4
    //   2429: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2432: iconst_2
    //   2433: aload 4
    //   2435: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2438: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2441: aload_2
    //   2442: astore 4
    //   2444: goto -54 -> 2390
    //   2447: aload_0
    //   2448: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2451: ldc_w 450
    //   2454: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2457: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2460: checkcast 354	android/graphics/Bitmap
    //   2463: astore 4
    //   2465: aload 4
    //   2467: astore_3
    //   2468: aload 4
    //   2470: ifnonnull +31 -> 2501
    //   2473: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2476: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2479: ldc_w 450
    //   2482: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2485: astore_3
    //   2486: aload_0
    //   2487: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2490: ldc_w 450
    //   2493: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2496: aload_3
    //   2497: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2500: pop
    //   2501: aload_2
    //   2502: astore 4
    //   2504: aload_2
    //   2505: ifnonnull +36 -> 2541
    //   2508: new 149	java/lang/StringBuilder
    //   2511: dup
    //   2512: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2515: aload_0
    //   2516: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2519: aload 5
    //   2521: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2524: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2527: ldc_w 359
    //   2530: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2533: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2536: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2539: astore 4
    //   2541: new 304	dov/com/qq/im/capture/text/ShakingTextItem
    //   2544: dup
    //   2545: iload_1
    //   2546: aload 6
    //   2548: aload 4
    //   2550: aload_3
    //   2551: invokespecial 451	dov/com/qq/im/capture/text/ShakingTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   2554: astore_3
    //   2555: aload 4
    //   2557: astore_2
    //   2558: goto -2285 -> 273
    //   2561: astore 4
    //   2563: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2566: iconst_2
    //   2567: aload 4
    //   2569: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2572: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2575: aload_2
    //   2576: astore 4
    //   2578: goto -37 -> 2541
    //   2581: aload_2
    //   2582: astore 4
    //   2584: aload_2
    //   2585: ifnonnull +36 -> 2621
    //   2588: new 149	java/lang/StringBuilder
    //   2591: dup
    //   2592: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2595: aload_0
    //   2596: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2599: aload 5
    //   2601: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2604: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2607: ldc_w 359
    //   2610: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2613: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2616: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2619: astore 4
    //   2621: aload_0
    //   2622: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2625: ldc_w 452
    //   2628: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2631: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2634: checkcast 354	android/graphics/Bitmap
    //   2637: astore_3
    //   2638: aload_3
    //   2639: astore_2
    //   2640: aload_3
    //   2641: ifnonnull +31 -> 2672
    //   2644: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2647: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2650: ldc_w 452
    //   2653: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2656: astore_2
    //   2657: aload_0
    //   2658: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2661: ldc_w 452
    //   2664: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2667: aload_2
    //   2668: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2671: pop
    //   2672: new 308	dov/com/qq/im/capture/text/SupernaturalTextItem
    //   2675: dup
    //   2676: iload_1
    //   2677: aload 6
    //   2679: aload 4
    //   2681: aload_2
    //   2682: invokespecial 453	dov/com/qq/im/capture/text/SupernaturalTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   2685: astore_3
    //   2686: aload 4
    //   2688: astore_2
    //   2689: goto -2416 -> 273
    //   2692: astore_3
    //   2693: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2696: iconst_2
    //   2697: aload_3
    //   2698: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2701: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2704: aload_2
    //   2705: astore 4
    //   2707: goto -86 -> 2621
    //   2710: aload_0
    //   2711: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2714: ldc_w 454
    //   2717: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2720: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2723: checkcast 354	android/graphics/Bitmap
    //   2726: astore 4
    //   2728: aload 4
    //   2730: astore_3
    //   2731: aload 4
    //   2733: ifnonnull +31 -> 2764
    //   2736: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2739: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2742: ldc_w 454
    //   2745: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2748: astore_3
    //   2749: aload_0
    //   2750: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2753: ldc_w 454
    //   2756: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2759: aload_3
    //   2760: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2763: pop
    //   2764: aload_0
    //   2765: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2768: ldc_w 455
    //   2771: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2774: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2777: checkcast 354	android/graphics/Bitmap
    //   2780: astore 7
    //   2782: aload 7
    //   2784: astore 4
    //   2786: aload 7
    //   2788: ifnonnull +33 -> 2821
    //   2791: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2794: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2797: ldc_w 455
    //   2800: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2803: astore 4
    //   2805: aload_0
    //   2806: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2809: ldc_w 455
    //   2812: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2815: aload 4
    //   2817: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2820: pop
    //   2821: new 218	java/util/ArrayList
    //   2824: dup
    //   2825: iconst_3
    //   2826: invokespecial 425	java/util/ArrayList:<init>	(I)V
    //   2829: astore 7
    //   2831: aload 7
    //   2833: aload_3
    //   2834: invokeinterface 324 2 0
    //   2839: pop
    //   2840: aload 7
    //   2842: aload 4
    //   2844: invokeinterface 324 2 0
    //   2849: pop
    //   2850: aload_2
    //   2851: astore 4
    //   2853: aload_2
    //   2854: ifnonnull +36 -> 2890
    //   2857: new 149	java/lang/StringBuilder
    //   2860: dup
    //   2861: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2864: aload_0
    //   2865: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2868: aload 5
    //   2870: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2873: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: ldc_w 359
    //   2879: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2882: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2885: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2888: astore 4
    //   2890: new 306	dov/com/qq/im/capture/text/GridTextItem
    //   2893: dup
    //   2894: iload_1
    //   2895: aload 6
    //   2897: aload 4
    //   2899: aload 7
    //   2901: invokespecial 458	dov/com/qq/im/capture/text/GridTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Ljava/util/List;)V
    //   2904: astore_3
    //   2905: aload 4
    //   2907: astore_2
    //   2908: goto -2635 -> 273
    //   2911: astore_3
    //   2912: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2915: iconst_2
    //   2916: aload_3
    //   2917: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2920: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2923: aload_2
    //   2924: astore 4
    //   2926: goto -36 -> 2890
    //   2929: aload_0
    //   2930: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2933: ldc_w 459
    //   2936: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2939: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2942: checkcast 354	android/graphics/Bitmap
    //   2945: astore 4
    //   2947: aload 4
    //   2949: astore_3
    //   2950: aload 4
    //   2952: ifnonnull +31 -> 2983
    //   2955: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2958: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2961: ldc_w 459
    //   2964: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2967: astore_3
    //   2968: aload_0
    //   2969: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2972: ldc_w 459
    //   2975: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2978: aload_3
    //   2979: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2982: pop
    //   2983: aload_2
    //   2984: astore 4
    //   2986: aload_2
    //   2987: ifnonnull +36 -> 3023
    //   2990: new 149	java/lang/StringBuilder
    //   2993: dup
    //   2994: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2997: aload_0
    //   2998: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3001: aload 5
    //   3003: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3006: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3009: ldc_w 359
    //   3012: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3015: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3018: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3021: astore 4
    //   3023: new 310	dov/com/qq/im/capture/text/FoodAloneTextItem
    //   3026: dup
    //   3027: iload_1
    //   3028: aload 6
    //   3030: aload 4
    //   3032: aload_3
    //   3033: invokespecial 460	dov/com/qq/im/capture/text/FoodAloneTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   3036: astore_3
    //   3037: aload 4
    //   3039: astore_2
    //   3040: goto -2767 -> 273
    //   3043: astore 4
    //   3045: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3048: iconst_2
    //   3049: aload 4
    //   3051: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3054: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3057: aload_2
    //   3058: astore 4
    //   3060: goto -37 -> 3023
    //   3063: aload_0
    //   3064: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3067: ldc_w 461
    //   3070: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3073: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3076: checkcast 354	android/graphics/Bitmap
    //   3079: astore 4
    //   3081: aload 4
    //   3083: ifnonnull +438 -> 3521
    //   3086: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3089: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   3092: ldc_w 461
    //   3095: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   3098: astore 4
    //   3100: aload_0
    //   3101: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3104: ldc_w 461
    //   3107: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3110: aload 4
    //   3112: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3115: pop
    //   3116: aload_2
    //   3117: ifnonnull +200 -> 3317
    //   3120: new 149	java/lang/StringBuilder
    //   3123: dup
    //   3124: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   3127: aload_0
    //   3128: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3131: aload 5
    //   3133: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3136: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3139: ldc_w 359
    //   3142: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3145: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3148: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3151: astore_3
    //   3152: aload_3
    //   3153: astore_2
    //   3154: aconst_null
    //   3155: astore 7
    //   3157: aload 7
    //   3159: astore_3
    //   3160: aload 8
    //   3162: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3165: invokevirtual 255	java/util/ArrayList:size	()I
    //   3168: iconst_1
    //   3169: if_icmple +118 -> 3287
    //   3172: aload 7
    //   3174: astore_3
    //   3175: aload 8
    //   3177: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3180: iconst_1
    //   3181: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3184: ifnull +103 -> 3287
    //   3187: aload 7
    //   3189: astore_3
    //   3190: aload 8
    //   3192: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3195: iconst_1
    //   3196: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3199: checkcast 338	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   3202: getfield 340	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   3205: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3208: ifne +79 -> 3287
    //   3211: aload_0
    //   3212: getfield 127	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3215: aload 8
    //   3217: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3220: iconst_1
    //   3221: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3224: checkcast 338	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   3227: getfield 340	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   3230: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3233: checkcast 343	android/graphics/Typeface
    //   3236: astore_3
    //   3237: aload_3
    //   3238: ifnonnull +96 -> 3334
    //   3241: new 149	java/lang/StringBuilder
    //   3244: dup
    //   3245: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   3248: aload_0
    //   3249: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3252: aload 8
    //   3254: getfield 336	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3257: iconst_1
    //   3258: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3261: checkcast 338	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   3264: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3267: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3270: ldc_w 359
    //   3273: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3276: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3279: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3282: astore 7
    //   3284: aload 7
    //   3286: astore_3
    //   3287: new 312	dov/com/qq/im/capture/text/LangTextItem
    //   3290: dup
    //   3291: iload_1
    //   3292: aload 6
    //   3294: aload_2
    //   3295: aload_3
    //   3296: aload 4
    //   3298: invokespecial 464	dov/com/qq/im/capture/text/LangTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   3301: astore_3
    //   3302: goto -3029 -> 273
    //   3305: astore_3
    //   3306: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3309: iconst_2
    //   3310: aload_3
    //   3311: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3314: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3317: goto -163 -> 3154
    //   3320: astore 7
    //   3322: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3325: iconst_2
    //   3326: aload 7
    //   3328: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3331: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3334: goto -47 -> 3287
    //   3337: aload_0
    //   3338: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3341: ldc_w 465
    //   3344: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3347: invokevirtual 341	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3350: checkcast 354	android/graphics/Bitmap
    //   3353: astore 4
    //   3355: aload 4
    //   3357: astore_3
    //   3358: aload 4
    //   3360: ifnonnull +31 -> 3391
    //   3363: invokestatic 367	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3366: invokevirtual 373	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   3369: ldc_w 465
    //   3372: invokestatic 379	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   3375: astore_3
    //   3376: aload_0
    //   3377: getfield 129	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3380: ldc_w 465
    //   3383: invokestatic 45	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3386: aload_3
    //   3387: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3390: pop
    //   3391: new 314	dov/com/qq/im/capture/text/LocationTextItem
    //   3394: dup
    //   3395: iload_1
    //   3396: aload 6
    //   3398: aload_3
    //   3399: aconst_null
    //   3400: invokespecial 468	dov/com/qq/im/capture/text/LocationTextItem:<init>	(ILjava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Typeface;)V
    //   3403: astore_3
    //   3404: goto -3131 -> 273
    //   3407: aload_2
    //   3408: astore 4
    //   3410: aload_2
    //   3411: ifnonnull +73 -> 3484
    //   3414: aload_2
    //   3415: astore 4
    //   3417: new 149	java/lang/StringBuilder
    //   3420: dup
    //   3421: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   3424: aload_0
    //   3425: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3428: aload 5
    //   3430: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3433: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: ldc_w 359
    //   3439: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokestatic 473	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   3448: ifeq +36 -> 3484
    //   3451: new 149	java/lang/StringBuilder
    //   3454: dup
    //   3455: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   3458: aload_0
    //   3459: getfield 138	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3462: aload 5
    //   3464: invokevirtual 357	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3467: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3470: ldc_w 359
    //   3473: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3476: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3479: invokestatic 363	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3482: astore 4
    //   3484: new 316	dov/com/qq/im/capture/text/BoldTextItem
    //   3487: dup
    //   3488: iload_1
    //   3489: aload 6
    //   3491: aload 4
    //   3493: invokespecial 474	dov/com/qq/im/capture/text/BoldTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;)V
    //   3496: astore_3
    //   3497: aload 4
    //   3499: astore_2
    //   3500: goto -3227 -> 273
    //   3503: astore_3
    //   3504: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3507: iconst_2
    //   3508: aload_3
    //   3509: invokestatic 388	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3512: invokestatic 166	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3515: aload_2
    //   3516: astore 4
    //   3518: goto -34 -> 3484
    //   3521: goto -405 -> 3116
    //   3524: goto -1462 -> 2062
    //   3527: goto -2843 -> 684
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3530	0	this	DynamicTextBuilder
    //   0	3530	1	paramInt	int
    //   0	3530	2	paramList	List
    //   7	448	3	localObject1	Object
    //   461	6	3	localException1	java.lang.Exception
    //   528	1	3	localDonotGiveUpHealing	DonotGiveUpHealing
    //   535	6	3	localException2	java.lang.Exception
    //   587	112	3	localObject2	Object
    //   702	6	3	localException3	java.lang.Exception
    //   772	1	3	localRandomSizeTextItem	RandomSizeTextItem
    //   779	6	3	localException4	java.lang.Exception
    //   835	512	3	localObject3	Object
    //   1353	15	3	localRuntimeException1	java.lang.RuntimeException
    //   1400	242	3	localObject4	Object
    //   1648	19	3	localException5	java.lang.Exception
    //   1696	990	3	localObject5	Object
    //   2692	6	3	localException6	java.lang.Exception
    //   2730	175	3	localObject6	Object
    //   2911	6	3	localException7	java.lang.Exception
    //   2949	353	3	localObject7	Object
    //   3305	6	3	localException8	java.lang.Exception
    //   3357	140	3	localObject8	Object
    //   3503	6	3	localException9	java.lang.Exception
    //   369	2036	4	localObject9	Object
    //   2410	7	4	localException10	java.lang.Exception
    //   2427	7	4	localException11	java.lang.Exception
    //   2442	114	4	localObject10	Object
    //   2561	7	4	localException12	java.lang.Exception
    //   2576	462	4	localObject11	Object
    //   3043	7	4	localException13	java.lang.Exception
    //   3058	459	4	localObject12	Object
    //   86	3377	5	localDynamicTextFontInfo	DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo
    //   44	3446	6	localObject13	Object
    //   359	1221	7	localObject14	Object
    //   1790	16	7	localRuntimeException2	java.lang.RuntimeException
    //   1933	21	7	localException14	java.lang.Exception
    //   2015	99	7	localBitmap	android.graphics.Bitmap
    //   2253	21	7	localException15	java.lang.Exception
    //   2780	505	7	localObject15	Object
    //   3320	7	7	localException16	java.lang.Exception
    //   72	2028	8	localObject16	Object
    //   2122	1131	8	localException17	java.lang.Exception
    //   1069	207	9	localObject17	Object
    //   1126	160	10	localObject18	Object
    //   1183	157	11	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   376	408	461	java/lang/Exception
    //   483	516	535	java/lang/Exception
    //   592	624	702	java/lang/Exception
    //   724	757	779	java/lang/Exception
    //   1299	1332	1353	java/lang/RuntimeException
    //   1594	1627	1648	java/lang/Exception
    //   1737	1770	1790	java/lang/RuntimeException
    //   1880	1913	1933	java/lang/Exception
    //   2066	2099	2122	java/lang/Exception
    //   2200	2233	2253	java/lang/Exception
    //   2304	2347	2410	java/lang/Exception
    //   2357	2390	2427	java/lang/Exception
    //   2508	2541	2561	java/lang/Exception
    //   2588	2621	2692	java/lang/Exception
    //   2857	2890	2911	java/lang/Exception
    //   2990	3023	3043	java/lang/Exception
    //   3120	3152	3305	java/lang/Exception
    //   3241	3284	3320	java/lang/Exception
    //   3451	3484	3503	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextBuilder
 * JD-Core Version:    0.7.0.1
 */