package dov.com.qq.im.capture.text;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import anwf;
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
    ThreadManager.post(new anwf(), 5, null, false);
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
      return 2130841831;
    case 1: 
      return 2130841815;
    case 2: 
      return 2130841822;
    case 3: 
      return 2130841818;
    case 4: 
      return 2130841821;
    case 5: 
      return 2130841819;
    case 6: 
      return 2130841816;
    case 7: 
      return 2130841833;
    case 8: 
      return 2130841817;
    case 9: 
      return 2130841835;
    case 10: 
      return 2130841826;
    case 11: 
      return 2130841810;
    case 12: 
      return 2130841830;
    case 13: 
      return 2130841834;
    case 14: 
      return 2130841836;
    case 15: 
      return 2130841824;
    case 16: 
      return 2130841828;
    case 17: 
      return 2130841825;
    case 18: 
      return 2130841820;
    }
    return 2130841814;
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
    //   0: new 204	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 308	java/util/ArrayList:<init>	()V
    //   7: astore_3
    //   8: aload_2
    //   9: ifnull +38 -> 47
    //   12: aload_2
    //   13: invokeinterface 309 1 0
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 224 1 0
    //   25: ifeq +22 -> 47
    //   28: aload_3
    //   29: aload_2
    //   30: invokeinterface 228 1 0
    //   35: checkcast 57	java/lang/String
    //   38: invokeinterface 310 2 0
    //   43: pop
    //   44: goto -25 -> 19
    //   47: aload_3
    //   48: astore 6
    //   50: aload_3
    //   51: invokeinterface 240 1 0
    //   56: ifeq +9 -> 65
    //   59: iload_1
    //   60: invokestatic 176	dov/com/qq/im/capture/text/DynamicTextBuilder:a	(I)Ljava/util/List;
    //   63: astore 6
    //   65: aload_0
    //   66: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   69: iload_1
    //   70: invokestatic 313	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   73: invokevirtual 316	dov/com/qq/im/capture/text/DynamicTextConfigManager:a	(Ljava/lang/String;)Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean;
    //   76: astore 8
    //   78: aload 8
    //   80: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   83: invokevirtual 207	java/util/ArrayList:isEmpty	()Z
    //   86: ifeq +230 -> 316
    //   89: aconst_null
    //   90: astore 5
    //   92: aconst_null
    //   93: astore_2
    //   94: aload 5
    //   96: ifnull +19 -> 115
    //   99: aload_0
    //   100: getfield 113	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   103: aload 5
    //   105: getfield 326	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   108: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: checkcast 329	android/graphics/Typeface
    //   114: astore_2
    //   115: iload_1
    //   116: tableswitch	default:+96 -> 212, 0:+217->333, 1:+231->347, 2:+364->480, 3:+441->557, 4:+605->721, 5:+685->801, 6:+773->889, 7:+1268->1384, 8:+1564->1680, 9:+1707->1823, 10:+2027->2143, 11:+1852->1968, 12:+2172->2288, 13:+2335->2451, 14:+2469->2585, 15:+2817->2933, 16:+2951->3067, 17:+2598->2714, 18:+3225->3341, 19:+3295->3411
    //   213: nop
    //   214: i2d
    //   215: dup
    //   216: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 331
    //   222: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: iload_1
    //   226: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore_3
    //   233: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +30 -> 266
    //   239: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   242: iconst_2
    //   243: new 135	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 333
    //   253: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_3
    //   257: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: new 261	dov/com/qq/im/capture/text/NormalTextItem
    //   269: dup
    //   270: iload_1
    //   271: aload 6
    //   273: invokespecial 336	dov/com/qq/im/capture/text/NormalTextItem:<init>	(ILjava/util/List;)V
    //   276: astore_3
    //   277: aload_2
    //   278: ifnull +36 -> 314
    //   281: aload_0
    //   282: getfield 113	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   285: iload_1
    //   286: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   292: ifnonnull +22 -> 314
    //   295: aload 5
    //   297: ifnull +17 -> 314
    //   300: aload_0
    //   301: getfield 113	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   304: aload 5
    //   306: getfield 326	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   309: aload_2
    //   310: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   313: pop
    //   314: aload_3
    //   315: areturn
    //   316: aload 8
    //   318: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   321: iconst_0
    //   322: invokevirtual 208	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   325: checkcast 324	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   328: astore 5
    //   330: goto -238 -> 92
    //   333: new 261	dov/com/qq/im/capture/text/NormalTextItem
    //   336: dup
    //   337: iload_1
    //   338: aload 6
    //   340: invokespecial 336	dov/com/qq/im/capture/text/NormalTextItem:<init>	(ILjava/util/List;)V
    //   343: astore_3
    //   344: goto -67 -> 277
    //   347: aload_0
    //   348: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   351: ldc_w 338
    //   354: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   360: checkcast 340	android/graphics/Bitmap
    //   363: astore 7
    //   365: aload_2
    //   366: ifnull +14 -> 380
    //   369: aload 7
    //   371: astore_3
    //   372: aload_2
    //   373: astore 4
    //   375: aload 7
    //   377: ifnonnull +68 -> 445
    //   380: new 135	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   387: aload_0
    //   388: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   391: aload 5
    //   393: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   396: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc_w 345
    //   402: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   411: astore_3
    //   412: aload_3
    //   413: astore_2
    //   414: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   417: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   420: ldc_w 338
    //   423: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   426: astore_3
    //   427: aload_0
    //   428: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   431: ldc_w 338
    //   434: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   437: aload_3
    //   438: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   441: pop
    //   442: aload_2
    //   443: astore 4
    //   445: new 266	dov/com/qq/im/capture/text/BubbleTextItem
    //   448: dup
    //   449: iload_1
    //   450: aload 6
    //   452: aload 4
    //   454: aload_3
    //   455: invokespecial 370	dov/com/qq/im/capture/text/BubbleTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   458: astore_3
    //   459: aload 4
    //   461: astore_2
    //   462: goto -185 -> 277
    //   465: astore_3
    //   466: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   469: iconst_2
    //   470: aload_3
    //   471: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   474: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -63 -> 414
    //   480: aload_2
    //   481: astore 4
    //   483: aload_2
    //   484: ifnonnull +36 -> 520
    //   487: new 135	java/lang/StringBuilder
    //   490: dup
    //   491: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   494: aload_0
    //   495: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   498: aload 5
    //   500: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   503: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc_w 345
    //   509: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   518: astore 4
    //   520: new 270	dov/com/qq/im/capture/text/DonotGiveUpHealing
    //   523: dup
    //   524: iload_1
    //   525: aload 6
    //   527: aload 4
    //   529: invokespecial 379	dov/com/qq/im/capture/text/DonotGiveUpHealing:<init>	(ILjava/util/List;Landroid/graphics/Typeface;)V
    //   532: astore_3
    //   533: aload 4
    //   535: astore_2
    //   536: goto -259 -> 277
    //   539: astore_3
    //   540: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   543: iconst_2
    //   544: aload_3
    //   545: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   548: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: aload_2
    //   552: astore 4
    //   554: goto -34 -> 520
    //   557: aload_0
    //   558: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   561: ldc_w 380
    //   564: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   570: checkcast 340	android/graphics/Bitmap
    //   573: astore 4
    //   575: aload_0
    //   576: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   579: ldc_w 381
    //   582: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   585: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   588: checkcast 340	android/graphics/Bitmap
    //   591: astore_3
    //   592: aload_2
    //   593: ifnonnull +2938 -> 3531
    //   596: new 135	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   603: aload_0
    //   604: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   607: aload 5
    //   609: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   612: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: ldc_w 345
    //   618: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   627: astore_3
    //   628: aload_3
    //   629: astore_2
    //   630: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   633: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   636: ldc_w 380
    //   639: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   642: astore 4
    //   644: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   647: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   650: ldc_w 381
    //   653: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   656: astore_3
    //   657: aload_0
    //   658: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   661: ldc_w 380
    //   664: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: aload 4
    //   669: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   672: pop
    //   673: aload_0
    //   674: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   677: ldc_w 381
    //   680: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: aload_3
    //   684: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   687: pop
    //   688: new 268	dov/com/qq/im/capture/text/FringesTextItems
    //   691: dup
    //   692: iload_1
    //   693: aload 6
    //   695: aload_2
    //   696: aload 4
    //   698: aload_3
    //   699: invokespecial 384	dov/com/qq/im/capture/text/FringesTextItems:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   702: astore_3
    //   703: goto -426 -> 277
    //   706: astore_3
    //   707: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   710: iconst_2
    //   711: aload_3
    //   712: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   715: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: goto -88 -> 630
    //   721: aload_2
    //   722: astore 4
    //   724: aload_2
    //   725: ifnonnull +36 -> 761
    //   728: new 135	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   735: aload_0
    //   736: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   739: aload 5
    //   741: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   744: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: ldc_w 345
    //   750: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   759: astore 4
    //   761: new 272	dov/com/qq/im/capture/text/RandomSizeTextItem
    //   764: dup
    //   765: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   768: iload_1
    //   769: aload 6
    //   771: aload 4
    //   773: invokespecial 387	dov/com/qq/im/capture/text/RandomSizeTextItem:<init>	(Landroid/content/Context;ILjava/util/List;Landroid/graphics/Typeface;)V
    //   776: astore_3
    //   777: aload 4
    //   779: astore_2
    //   780: goto -503 -> 277
    //   783: astore_3
    //   784: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   787: iconst_2
    //   788: aload_3
    //   789: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   792: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: aload_2
    //   796: astore 4
    //   798: goto -37 -> 761
    //   801: aload_0
    //   802: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   805: ldc_w 388
    //   808: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   811: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   814: checkcast 340	android/graphics/Bitmap
    //   817: astore 7
    //   819: aload_0
    //   820: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   823: ldc_w 389
    //   826: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   829: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   832: checkcast 340	android/graphics/Bitmap
    //   835: astore 4
    //   837: aload 7
    //   839: astore_3
    //   840: aload 7
    //   842: ifnonnull +30 -> 872
    //   845: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   848: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   851: ldc_w 388
    //   854: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   857: astore_3
    //   858: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   861: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   864: ldc_w 389
    //   867: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   870: astore 4
    //   872: new 274	dov/com/qq/im/capture/text/JourneyTextItem
    //   875: dup
    //   876: iload_1
    //   877: aload 6
    //   879: aload_3
    //   880: aload 4
    //   882: invokespecial 392	dov/com/qq/im/capture/text/JourneyTextItem:<init>	(ILjava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   885: astore_3
    //   886: goto -609 -> 277
    //   889: aload_0
    //   890: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   893: ldc_w 393
    //   896: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   899: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   902: checkcast 340	android/graphics/Bitmap
    //   905: astore 4
    //   907: aload 4
    //   909: astore_3
    //   910: aload 4
    //   912: ifnonnull +31 -> 943
    //   915: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   918: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   921: ldc_w 393
    //   924: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   927: astore_3
    //   928: aload_0
    //   929: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   932: ldc_w 393
    //   935: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   938: aload_3
    //   939: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   942: pop
    //   943: aload_0
    //   944: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   947: ldc_w 394
    //   950: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   953: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   956: checkcast 340	android/graphics/Bitmap
    //   959: astore 7
    //   961: aload 7
    //   963: astore 4
    //   965: aload 7
    //   967: ifnonnull +33 -> 1000
    //   970: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   973: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   976: ldc_w 394
    //   979: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   982: astore 4
    //   984: aload_0
    //   985: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   988: ldc_w 394
    //   991: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   994: aload 4
    //   996: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   999: pop
    //   1000: aload_0
    //   1001: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1004: ldc_w 395
    //   1007: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1010: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1013: checkcast 340	android/graphics/Bitmap
    //   1016: astore 8
    //   1018: aload 8
    //   1020: astore 7
    //   1022: aload 8
    //   1024: ifnonnull +33 -> 1057
    //   1027: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1030: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1033: ldc_w 395
    //   1036: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1039: astore 7
    //   1041: aload_0
    //   1042: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1045: ldc_w 395
    //   1048: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1051: aload 7
    //   1053: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1056: pop
    //   1057: aload_0
    //   1058: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1061: ldc_w 396
    //   1064: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1067: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1070: checkcast 340	android/graphics/Bitmap
    //   1073: astore 9
    //   1075: aload 9
    //   1077: astore 8
    //   1079: aload 9
    //   1081: ifnonnull +33 -> 1114
    //   1084: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1087: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1090: ldc_w 396
    //   1093: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1096: astore 8
    //   1098: aload_0
    //   1099: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1102: ldc_w 396
    //   1105: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1108: aload 8
    //   1110: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1113: pop
    //   1114: aload_0
    //   1115: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1118: ldc_w 397
    //   1121: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1124: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1127: checkcast 340	android/graphics/Bitmap
    //   1130: astore 10
    //   1132: aload 10
    //   1134: astore 9
    //   1136: aload 10
    //   1138: ifnonnull +33 -> 1171
    //   1141: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1144: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1147: ldc_w 397
    //   1150: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1153: astore 9
    //   1155: aload_0
    //   1156: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1159: ldc_w 397
    //   1162: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1165: aload 9
    //   1167: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1170: pop
    //   1171: aload_0
    //   1172: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1175: ldc_w 398
    //   1178: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1181: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1184: checkcast 340	android/graphics/Bitmap
    //   1187: astore 11
    //   1189: aload 11
    //   1191: astore 10
    //   1193: aload 11
    //   1195: ifnonnull +33 -> 1228
    //   1198: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1201: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1204: ldc_w 398
    //   1207: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1210: astore 10
    //   1212: aload_0
    //   1213: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1216: ldc_w 398
    //   1219: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1222: aload 10
    //   1224: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1227: pop
    //   1228: new 204	java/util/ArrayList
    //   1231: dup
    //   1232: invokespecial 308	java/util/ArrayList:<init>	()V
    //   1235: astore 11
    //   1237: aload 11
    //   1239: iconst_0
    //   1240: aload_3
    //   1241: invokeinterface 401 3 0
    //   1246: aload 11
    //   1248: iconst_1
    //   1249: aload 7
    //   1251: invokeinterface 401 3 0
    //   1256: aload 11
    //   1258: iconst_2
    //   1259: aload 4
    //   1261: invokeinterface 401 3 0
    //   1266: aload 11
    //   1268: iconst_3
    //   1269: aload 8
    //   1271: invokeinterface 401 3 0
    //   1276: aload 11
    //   1278: iconst_4
    //   1279: aload 9
    //   1281: invokeinterface 401 3 0
    //   1286: aload 11
    //   1288: iconst_5
    //   1289: aload 10
    //   1291: invokeinterface 401 3 0
    //   1296: aload_2
    //   1297: astore 4
    //   1299: aload_2
    //   1300: ifnonnull +36 -> 1336
    //   1303: new 135	java/lang/StringBuilder
    //   1306: dup
    //   1307: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1310: aload_0
    //   1311: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1314: aload 5
    //   1316: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1319: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: ldc_w 345
    //   1325: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1331: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1334: astore 4
    //   1336: new 276	dov/com/qq/im/capture/text/FluorescenceTextItem
    //   1339: dup
    //   1340: iload_1
    //   1341: aload 6
    //   1343: aload 11
    //   1345: aload 4
    //   1347: invokespecial 404	dov/com/qq/im/capture/text/FluorescenceTextItem:<init>	(ILjava/util/List;Ljava/util/List;Landroid/graphics/Typeface;)V
    //   1350: astore_3
    //   1351: aload 4
    //   1353: astore_2
    //   1354: goto -1077 -> 277
    //   1357: astore_3
    //   1358: aload_2
    //   1359: astore 4
    //   1361: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1364: ifeq -28 -> 1336
    //   1367: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1370: iconst_2
    //   1371: aload_3
    //   1372: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1375: invokestatic 407	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1378: aload_2
    //   1379: astore 4
    //   1381: goto -45 -> 1336
    //   1384: aload_0
    //   1385: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1388: ldc_w 408
    //   1391: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1394: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1397: checkcast 340	android/graphics/Bitmap
    //   1400: astore 4
    //   1402: aload 4
    //   1404: astore_3
    //   1405: aload 4
    //   1407: ifnonnull +31 -> 1438
    //   1410: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1413: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1416: ldc_w 408
    //   1419: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1422: astore_3
    //   1423: aload_0
    //   1424: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1427: ldc_w 408
    //   1430: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1433: aload_3
    //   1434: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1437: pop
    //   1438: aload_0
    //   1439: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1442: ldc_w 409
    //   1445: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1448: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1451: checkcast 340	android/graphics/Bitmap
    //   1454: astore 7
    //   1456: aload 7
    //   1458: astore 4
    //   1460: aload 7
    //   1462: ifnonnull +33 -> 1495
    //   1465: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1468: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1471: ldc_w 409
    //   1474: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1477: astore 4
    //   1479: aload_0
    //   1480: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1483: ldc_w 409
    //   1486: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1489: aload 4
    //   1491: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1494: pop
    //   1495: aload_0
    //   1496: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1499: ldc_w 410
    //   1502: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1505: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1508: checkcast 340	android/graphics/Bitmap
    //   1511: astore 8
    //   1513: aload 8
    //   1515: astore 7
    //   1517: aload 8
    //   1519: ifnonnull +33 -> 1552
    //   1522: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1525: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1528: ldc_w 410
    //   1531: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1534: astore 7
    //   1536: aload_0
    //   1537: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1540: ldc_w 410
    //   1543: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1546: aload 7
    //   1548: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1551: pop
    //   1552: new 204	java/util/ArrayList
    //   1555: dup
    //   1556: iconst_3
    //   1557: invokespecial 413	java/util/ArrayList:<init>	(I)V
    //   1560: astore 8
    //   1562: aload 8
    //   1564: aload_3
    //   1565: invokeinterface 310 2 0
    //   1570: pop
    //   1571: aload 8
    //   1573: aload 4
    //   1575: invokeinterface 310 2 0
    //   1580: pop
    //   1581: aload 8
    //   1583: aload 7
    //   1585: invokeinterface 310 2 0
    //   1590: pop
    //   1591: aload_2
    //   1592: astore 4
    //   1594: aload_2
    //   1595: ifnonnull +36 -> 1631
    //   1598: new 135	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1605: aload_0
    //   1606: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1609: aload 5
    //   1611: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1614: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: ldc_w 345
    //   1620: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1626: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1629: astore 4
    //   1631: new 278	dov/com/qq/im/capture/text/ShadowBubbleTextItem
    //   1634: dup
    //   1635: iload_1
    //   1636: aload 4
    //   1638: aload 6
    //   1640: aload 8
    //   1642: invokespecial 416	dov/com/qq/im/capture/text/ShadowBubbleTextItem:<init>	(ILandroid/graphics/Typeface;Ljava/util/List;Ljava/util/List;)V
    //   1645: astore_3
    //   1646: aload 4
    //   1648: astore_2
    //   1649: goto -1372 -> 277
    //   1652: astore_3
    //   1653: aload_2
    //   1654: astore 4
    //   1656: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1659: ifeq -28 -> 1631
    //   1662: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1665: iconst_2
    //   1666: aload_3
    //   1667: invokevirtual 419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1670: aload_3
    //   1671: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1674: aload_2
    //   1675: astore 4
    //   1677: goto -46 -> 1631
    //   1680: aload_0
    //   1681: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1684: ldc_w 423
    //   1687: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1690: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1693: checkcast 340	android/graphics/Bitmap
    //   1696: astore 4
    //   1698: aload 4
    //   1700: astore_3
    //   1701: aload 4
    //   1703: ifnonnull +31 -> 1734
    //   1706: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1709: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1712: ldc_w 423
    //   1715: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1718: astore_3
    //   1719: aload_0
    //   1720: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1723: ldc_w 423
    //   1726: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1729: aload_3
    //   1730: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1733: pop
    //   1734: aload_2
    //   1735: astore 4
    //   1737: aload_2
    //   1738: ifnonnull +36 -> 1774
    //   1741: new 135	java/lang/StringBuilder
    //   1744: dup
    //   1745: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1748: aload_0
    //   1749: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1752: aload 5
    //   1754: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1757: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: ldc_w 345
    //   1763: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1769: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1772: astore 4
    //   1774: new 280	dov/com/qq/im/capture/text/FoldOverTextItem
    //   1777: dup
    //   1778: iload_1
    //   1779: aload 6
    //   1781: aload 4
    //   1783: aload_3
    //   1784: invokespecial 424	dov/com/qq/im/capture/text/FoldOverTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   1787: astore_3
    //   1788: aload 4
    //   1790: astore_2
    //   1791: goto -1514 -> 277
    //   1794: astore 7
    //   1796: aload_2
    //   1797: astore 4
    //   1799: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1802: ifeq -28 -> 1774
    //   1805: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1808: iconst_2
    //   1809: aload 7
    //   1811: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1814: invokestatic 407	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1817: aload_2
    //   1818: astore 4
    //   1820: goto -46 -> 1774
    //   1823: aload_0
    //   1824: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1827: ldc_w 425
    //   1830: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1833: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1836: checkcast 340	android/graphics/Bitmap
    //   1839: astore 4
    //   1841: aload 4
    //   1843: astore_3
    //   1844: aload 4
    //   1846: ifnonnull +31 -> 1877
    //   1849: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1852: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   1855: ldc_w 425
    //   1858: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1861: astore_3
    //   1862: aload_0
    //   1863: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1866: ldc_w 425
    //   1869: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1872: aload_3
    //   1873: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1876: pop
    //   1877: aload_2
    //   1878: astore 4
    //   1880: aload_2
    //   1881: ifnonnull +36 -> 1917
    //   1884: new 135	java/lang/StringBuilder
    //   1887: dup
    //   1888: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1891: aload_0
    //   1892: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   1895: aload 5
    //   1897: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   1900: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: ldc_w 345
    //   1906: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1912: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   1915: astore 4
    //   1917: new 282	dov/com/qq/im/capture/text/ShockTextItem
    //   1920: dup
    //   1921: iload_1
    //   1922: aload 6
    //   1924: aload 4
    //   1926: aload_3
    //   1927: invokespecial 426	dov/com/qq/im/capture/text/ShockTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   1930: astore_3
    //   1931: aload 4
    //   1933: astore_2
    //   1934: goto -1657 -> 277
    //   1937: astore 7
    //   1939: aload_2
    //   1940: astore 4
    //   1942: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1945: ifeq -28 -> 1917
    //   1948: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1951: iconst_2
    //   1952: aload 7
    //   1954: invokevirtual 419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1957: aload 7
    //   1959: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1962: aload_2
    //   1963: astore 4
    //   1965: goto -48 -> 1917
    //   1968: aload_0
    //   1969: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1972: ldc_w 427
    //   1975: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1978: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1981: checkcast 340	android/graphics/Bitmap
    //   1984: astore_3
    //   1985: aload_0
    //   1986: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   1989: ldc_w 428
    //   1992: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1995: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1998: checkcast 340	android/graphics/Bitmap
    //   2001: astore 4
    //   2003: aload_0
    //   2004: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2007: ldc_w 429
    //   2010: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2013: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2016: checkcast 340	android/graphics/Bitmap
    //   2019: astore 7
    //   2021: aload_3
    //   2022: ifnonnull +1506 -> 3528
    //   2025: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2028: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2031: ldc_w 427
    //   2034: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2037: astore_3
    //   2038: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2041: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2044: ldc_w 428
    //   2047: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2050: astore 4
    //   2052: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2055: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2058: ldc_w 429
    //   2061: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2064: astore 7
    //   2066: aload_2
    //   2067: ifnonnull +73 -> 2140
    //   2070: new 135	java/lang/StringBuilder
    //   2073: dup
    //   2074: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2077: aload_0
    //   2078: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2081: aload 5
    //   2083: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2086: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: ldc_w 345
    //   2092: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2098: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2101: astore 8
    //   2103: aload 8
    //   2105: astore_2
    //   2106: new 286	dov/com/qq/im/capture/text/ApathyTextItem
    //   2109: dup
    //   2110: iload_1
    //   2111: aload 6
    //   2113: aload_2
    //   2114: aload_3
    //   2115: aload 4
    //   2117: aload 7
    //   2119: invokespecial 432	dov/com/qq/im/capture/text/ApathyTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    //   2122: astore_3
    //   2123: goto -1846 -> 277
    //   2126: astore 8
    //   2128: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2131: iconst_2
    //   2132: aload 8
    //   2134: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2137: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2140: goto -34 -> 2106
    //   2143: aload_0
    //   2144: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2147: ldc_w 433
    //   2150: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2153: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2156: checkcast 340	android/graphics/Bitmap
    //   2159: astore 4
    //   2161: aload 4
    //   2163: astore_3
    //   2164: aload 4
    //   2166: ifnonnull +31 -> 2197
    //   2169: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2172: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2175: ldc_w 433
    //   2178: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2181: astore_3
    //   2182: aload_0
    //   2183: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2186: ldc_w 433
    //   2189: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2192: aload_3
    //   2193: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2196: pop
    //   2197: aload_2
    //   2198: astore 4
    //   2200: aload_2
    //   2201: ifnonnull +36 -> 2237
    //   2204: new 135	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2211: aload_0
    //   2212: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2215: aload 5
    //   2217: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2220: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: ldc_w 345
    //   2226: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2229: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2232: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2235: astore 4
    //   2237: new 284	dov/com/qq/im/capture/text/HelplessTextItem
    //   2240: dup
    //   2241: iload_1
    //   2242: aload 6
    //   2244: aload 4
    //   2246: aload_3
    //   2247: invokespecial 434	dov/com/qq/im/capture/text/HelplessTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   2250: astore_3
    //   2251: aload 4
    //   2253: astore_2
    //   2254: goto -1977 -> 277
    //   2257: astore 7
    //   2259: aload_2
    //   2260: astore 4
    //   2262: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2265: ifeq -28 -> 2237
    //   2268: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2271: iconst_2
    //   2272: aload 7
    //   2274: invokevirtual 419	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2277: aload 7
    //   2279: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2282: aload_2
    //   2283: astore 4
    //   2285: goto -48 -> 2237
    //   2288: aload_0
    //   2289: getfield 113	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   2292: bipush 6
    //   2294: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2297: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2300: checkcast 329	android/graphics/Typeface
    //   2303: astore_3
    //   2304: aload_3
    //   2305: ifnonnull +123 -> 2428
    //   2308: new 135	java/lang/StringBuilder
    //   2311: dup
    //   2312: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2315: aload_0
    //   2316: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2319: aload 8
    //   2321: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   2324: iconst_1
    //   2325: invokevirtual 208	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2328: checkcast 324	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   2331: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2334: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2337: ldc_w 345
    //   2340: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2343: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2346: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2349: astore 4
    //   2351: aload 4
    //   2353: astore_3
    //   2354: aload_2
    //   2355: astore 4
    //   2357: aload_2
    //   2358: ifnonnull +36 -> 2394
    //   2361: new 135	java/lang/StringBuilder
    //   2364: dup
    //   2365: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2368: aload_0
    //   2369: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2372: aload 5
    //   2374: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2377: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2380: ldc_w 345
    //   2383: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2386: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2389: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2392: astore 4
    //   2394: new 288	dov/com/qq/im/capture/text/MidNightTextItem
    //   2397: dup
    //   2398: iload_1
    //   2399: aload 6
    //   2401: aload 4
    //   2403: aload_3
    //   2404: invokespecial 437	dov/com/qq/im/capture/text/MidNightTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Typeface;)V
    //   2407: astore_3
    //   2408: aload 4
    //   2410: astore_2
    //   2411: goto -2134 -> 277
    //   2414: astore 4
    //   2416: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2419: iconst_2
    //   2420: aload 4
    //   2422: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2425: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2428: goto -74 -> 2354
    //   2431: astore 4
    //   2433: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2436: iconst_2
    //   2437: aload 4
    //   2439: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2442: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2445: aload_2
    //   2446: astore 4
    //   2448: goto -54 -> 2394
    //   2451: aload_0
    //   2452: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2455: ldc_w 438
    //   2458: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2461: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2464: checkcast 340	android/graphics/Bitmap
    //   2467: astore 4
    //   2469: aload 4
    //   2471: astore_3
    //   2472: aload 4
    //   2474: ifnonnull +31 -> 2505
    //   2477: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2480: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2483: ldc_w 438
    //   2486: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2489: astore_3
    //   2490: aload_0
    //   2491: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2494: ldc_w 438
    //   2497: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2500: aload_3
    //   2501: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2504: pop
    //   2505: aload_2
    //   2506: astore 4
    //   2508: aload_2
    //   2509: ifnonnull +36 -> 2545
    //   2512: new 135	java/lang/StringBuilder
    //   2515: dup
    //   2516: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2519: aload_0
    //   2520: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2523: aload 5
    //   2525: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2528: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2531: ldc_w 345
    //   2534: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2537: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2540: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2543: astore 4
    //   2545: new 290	dov/com/qq/im/capture/text/ShakingTextItem
    //   2548: dup
    //   2549: iload_1
    //   2550: aload 6
    //   2552: aload 4
    //   2554: aload_3
    //   2555: invokespecial 439	dov/com/qq/im/capture/text/ShakingTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   2558: astore_3
    //   2559: aload 4
    //   2561: astore_2
    //   2562: goto -2285 -> 277
    //   2565: astore 4
    //   2567: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2570: iconst_2
    //   2571: aload 4
    //   2573: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2576: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2579: aload_2
    //   2580: astore 4
    //   2582: goto -37 -> 2545
    //   2585: aload_2
    //   2586: astore 4
    //   2588: aload_2
    //   2589: ifnonnull +36 -> 2625
    //   2592: new 135	java/lang/StringBuilder
    //   2595: dup
    //   2596: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2599: aload_0
    //   2600: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2603: aload 5
    //   2605: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2608: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: ldc_w 345
    //   2614: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2617: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2620: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2623: astore 4
    //   2625: aload_0
    //   2626: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2629: ldc_w 440
    //   2632: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2635: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2638: checkcast 340	android/graphics/Bitmap
    //   2641: astore_3
    //   2642: aload_3
    //   2643: astore_2
    //   2644: aload_3
    //   2645: ifnonnull +31 -> 2676
    //   2648: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2651: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2654: ldc_w 440
    //   2657: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2660: astore_2
    //   2661: aload_0
    //   2662: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2665: ldc_w 440
    //   2668: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2671: aload_2
    //   2672: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2675: pop
    //   2676: new 294	dov/com/qq/im/capture/text/SupernaturalTextItem
    //   2679: dup
    //   2680: iload_1
    //   2681: aload 6
    //   2683: aload 4
    //   2685: aload_2
    //   2686: invokespecial 441	dov/com/qq/im/capture/text/SupernaturalTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   2689: astore_3
    //   2690: aload 4
    //   2692: astore_2
    //   2693: goto -2416 -> 277
    //   2696: astore_3
    //   2697: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2700: iconst_2
    //   2701: aload_3
    //   2702: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2705: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2708: aload_2
    //   2709: astore 4
    //   2711: goto -86 -> 2625
    //   2714: aload_0
    //   2715: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2718: ldc_w 442
    //   2721: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2724: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2727: checkcast 340	android/graphics/Bitmap
    //   2730: astore 4
    //   2732: aload 4
    //   2734: astore_3
    //   2735: aload 4
    //   2737: ifnonnull +31 -> 2768
    //   2740: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2743: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2746: ldc_w 442
    //   2749: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2752: astore_3
    //   2753: aload_0
    //   2754: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2757: ldc_w 442
    //   2760: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2763: aload_3
    //   2764: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2767: pop
    //   2768: aload_0
    //   2769: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2772: ldc_w 443
    //   2775: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2778: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2781: checkcast 340	android/graphics/Bitmap
    //   2784: astore 7
    //   2786: aload 7
    //   2788: astore 4
    //   2790: aload 7
    //   2792: ifnonnull +33 -> 2825
    //   2795: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2798: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2801: ldc_w 443
    //   2804: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2807: astore 4
    //   2809: aload_0
    //   2810: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2813: ldc_w 443
    //   2816: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2819: aload 4
    //   2821: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2824: pop
    //   2825: new 204	java/util/ArrayList
    //   2828: dup
    //   2829: iconst_3
    //   2830: invokespecial 413	java/util/ArrayList:<init>	(I)V
    //   2833: astore 7
    //   2835: aload 7
    //   2837: aload_3
    //   2838: invokeinterface 310 2 0
    //   2843: pop
    //   2844: aload 7
    //   2846: aload 4
    //   2848: invokeinterface 310 2 0
    //   2853: pop
    //   2854: aload_2
    //   2855: astore 4
    //   2857: aload_2
    //   2858: ifnonnull +36 -> 2894
    //   2861: new 135	java/lang/StringBuilder
    //   2864: dup
    //   2865: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2868: aload_0
    //   2869: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   2872: aload 5
    //   2874: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   2877: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2880: ldc_w 345
    //   2883: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2886: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2889: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   2892: astore 4
    //   2894: new 292	dov/com/qq/im/capture/text/GridTextItem
    //   2897: dup
    //   2898: iload_1
    //   2899: aload 6
    //   2901: aload 4
    //   2903: aload 7
    //   2905: invokespecial 446	dov/com/qq/im/capture/text/GridTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Ljava/util/List;)V
    //   2908: astore_3
    //   2909: aload 4
    //   2911: astore_2
    //   2912: goto -2635 -> 277
    //   2915: astore_3
    //   2916: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2919: iconst_2
    //   2920: aload_3
    //   2921: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2924: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2927: aload_2
    //   2928: astore 4
    //   2930: goto -36 -> 2894
    //   2933: aload_0
    //   2934: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2937: ldc_w 447
    //   2940: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2943: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2946: checkcast 340	android/graphics/Bitmap
    //   2949: astore 4
    //   2951: aload 4
    //   2953: astore_3
    //   2954: aload 4
    //   2956: ifnonnull +31 -> 2987
    //   2959: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2962: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2965: ldc_w 447
    //   2968: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   2971: astore_3
    //   2972: aload_0
    //   2973: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   2976: ldc_w 447
    //   2979: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2982: aload_3
    //   2983: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2986: pop
    //   2987: aload_2
    //   2988: astore 4
    //   2990: aload_2
    //   2991: ifnonnull +36 -> 3027
    //   2994: new 135	java/lang/StringBuilder
    //   2997: dup
    //   2998: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   3001: aload_0
    //   3002: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3005: aload 5
    //   3007: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3010: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3013: ldc_w 345
    //   3016: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3019: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3022: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3025: astore 4
    //   3027: new 296	dov/com/qq/im/capture/text/FoodAloneTextItem
    //   3030: dup
    //   3031: iload_1
    //   3032: aload 6
    //   3034: aload 4
    //   3036: aload_3
    //   3037: invokespecial 448	dov/com/qq/im/capture/text/FoodAloneTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   3040: astore_3
    //   3041: aload 4
    //   3043: astore_2
    //   3044: goto -2767 -> 277
    //   3047: astore 4
    //   3049: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3052: iconst_2
    //   3053: aload 4
    //   3055: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3058: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3061: aload_2
    //   3062: astore 4
    //   3064: goto -37 -> 3027
    //   3067: aload_0
    //   3068: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3071: ldc_w 449
    //   3074: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3077: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3080: checkcast 340	android/graphics/Bitmap
    //   3083: astore 4
    //   3085: aload 4
    //   3087: ifnonnull +438 -> 3525
    //   3090: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3093: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   3096: ldc_w 449
    //   3099: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   3102: astore 4
    //   3104: aload_0
    //   3105: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3108: ldc_w 449
    //   3111: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3114: aload 4
    //   3116: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3119: pop
    //   3120: aload_2
    //   3121: ifnonnull +200 -> 3321
    //   3124: new 135	java/lang/StringBuilder
    //   3127: dup
    //   3128: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   3131: aload_0
    //   3132: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3135: aload 5
    //   3137: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3140: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3143: ldc_w 345
    //   3146: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3149: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3152: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3155: astore_3
    //   3156: aload_3
    //   3157: astore_2
    //   3158: aconst_null
    //   3159: astore 7
    //   3161: aload 7
    //   3163: astore_3
    //   3164: aload 8
    //   3166: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3169: invokevirtual 241	java/util/ArrayList:size	()I
    //   3172: iconst_1
    //   3173: if_icmple +118 -> 3291
    //   3176: aload 7
    //   3178: astore_3
    //   3179: aload 8
    //   3181: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3184: iconst_1
    //   3185: invokevirtual 208	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3188: ifnull +103 -> 3291
    //   3191: aload 7
    //   3193: astore_3
    //   3194: aload 8
    //   3196: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3199: iconst_1
    //   3200: invokevirtual 208	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3203: checkcast 324	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   3206: getfield 326	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   3209: invokestatic 215	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3212: ifne +79 -> 3291
    //   3215: aload_0
    //   3216: getfield 113	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3219: aload 8
    //   3221: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3224: iconst_1
    //   3225: invokevirtual 208	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3228: checkcast 324	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   3231: getfield 326	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo:c	Ljava/lang/String;
    //   3234: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3237: checkcast 329	android/graphics/Typeface
    //   3240: astore_3
    //   3241: aload_3
    //   3242: ifnonnull +96 -> 3338
    //   3245: new 135	java/lang/StringBuilder
    //   3248: dup
    //   3249: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   3252: aload_0
    //   3253: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3256: aload 8
    //   3258: getfield 322	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean:fontInfos	Ljava/util/ArrayList;
    //   3261: iconst_1
    //   3262: invokevirtual 208	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3265: checkcast 324	dov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo
    //   3268: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3271: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3274: ldc_w 345
    //   3277: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3280: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3283: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3286: astore 7
    //   3288: aload 7
    //   3290: astore_3
    //   3291: new 298	dov/com/qq/im/capture/text/LangTextItem
    //   3294: dup
    //   3295: iload_1
    //   3296: aload 6
    //   3298: aload_2
    //   3299: aload_3
    //   3300: aload 4
    //   3302: invokespecial 452	dov/com/qq/im/capture/text/LangTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;Landroid/graphics/Typeface;Landroid/graphics/Bitmap;)V
    //   3305: astore_3
    //   3306: goto -3029 -> 277
    //   3309: astore_3
    //   3310: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3313: iconst_2
    //   3314: aload_3
    //   3315: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3318: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3321: goto -163 -> 3158
    //   3324: astore 7
    //   3326: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3329: iconst_2
    //   3330: aload 7
    //   3332: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3335: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3338: goto -47 -> 3291
    //   3341: aload_0
    //   3342: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3345: ldc_w 453
    //   3348: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3351: invokevirtual 327	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3354: checkcast 340	android/graphics/Bitmap
    //   3357: astore 4
    //   3359: aload 4
    //   3361: astore_3
    //   3362: aload 4
    //   3364: ifnonnull +31 -> 3395
    //   3367: invokestatic 355	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3370: invokevirtual 361	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   3373: ldc_w 453
    //   3376: invokestatic 367	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   3379: astore_3
    //   3380: aload_0
    //   3381: getfield 115	dov/com/qq/im/capture/text/DynamicTextBuilder:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   3384: ldc_w 453
    //   3387: invokestatic 33	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3390: aload_3
    //   3391: invokevirtual 337	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3394: pop
    //   3395: new 300	dov/com/qq/im/capture/text/LocationTextItem
    //   3398: dup
    //   3399: iload_1
    //   3400: aload 6
    //   3402: aload_3
    //   3403: aconst_null
    //   3404: invokespecial 456	dov/com/qq/im/capture/text/LocationTextItem:<init>	(ILjava/util/List;Landroid/graphics/Bitmap;Landroid/graphics/Typeface;)V
    //   3407: astore_3
    //   3408: goto -3131 -> 277
    //   3411: aload_2
    //   3412: astore 4
    //   3414: aload_2
    //   3415: ifnonnull +73 -> 3488
    //   3418: aload_2
    //   3419: astore 4
    //   3421: new 135	java/lang/StringBuilder
    //   3424: dup
    //   3425: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   3428: aload_0
    //   3429: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3432: aload 5
    //   3434: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3437: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3440: ldc_w 345
    //   3443: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3449: invokestatic 461	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/lang/String;)Z
    //   3452: ifeq +36 -> 3488
    //   3455: new 135	java/lang/StringBuilder
    //   3458: dup
    //   3459: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   3462: aload_0
    //   3463: getfield 124	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager	Ldov/com/qq/im/capture/text/DynamicTextConfigManager;
    //   3466: aload 5
    //   3468: invokevirtual 343	dov/com/qq/im/capture/text/DynamicTextConfigManager:b	(Ldov/com/qq/im/capture/text/DynamicTextConfigManager$DynamicTextConfigBean$DynamicTextFontInfo;)Ljava/lang/String;
    //   3471: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3474: ldc_w 345
    //   3477: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3480: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3483: invokestatic 349	android/graphics/Typeface:createFromFile	(Ljava/lang/String;)Landroid/graphics/Typeface;
    //   3486: astore 4
    //   3488: new 302	dov/com/qq/im/capture/text/BoldTextItem
    //   3491: dup
    //   3492: iload_1
    //   3493: aload 6
    //   3495: aload 4
    //   3497: invokespecial 462	dov/com/qq/im/capture/text/BoldTextItem:<init>	(ILjava/util/List;Landroid/graphics/Typeface;)V
    //   3500: astore_3
    //   3501: aload 4
    //   3503: astore_2
    //   3504: goto -3227 -> 277
    //   3507: astore_3
    //   3508: getstatic 20	dov/com/qq/im/capture/text/DynamicTextBuilder:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3511: iconst_2
    //   3512: aload_3
    //   3513: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3516: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3519: aload_2
    //   3520: astore 4
    //   3522: goto -34 -> 3488
    //   3525: goto -405 -> 3120
    //   3528: goto -1462 -> 2066
    //   3531: goto -2843 -> 688
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3534	0	this	DynamicTextBuilder
    //   0	3534	1	paramInt	int
    //   0	3534	2	paramList	List
    //   7	452	3	localObject1	Object
    //   465	6	3	localException1	java.lang.Exception
    //   532	1	3	localDonotGiveUpHealing	DonotGiveUpHealing
    //   539	6	3	localException2	java.lang.Exception
    //   591	112	3	localObject2	Object
    //   706	6	3	localException3	java.lang.Exception
    //   776	1	3	localRandomSizeTextItem	RandomSizeTextItem
    //   783	6	3	localException4	java.lang.Exception
    //   839	512	3	localObject3	Object
    //   1357	15	3	localRuntimeException1	java.lang.RuntimeException
    //   1404	242	3	localObject4	Object
    //   1652	19	3	localException5	java.lang.Exception
    //   1700	990	3	localObject5	Object
    //   2696	6	3	localException6	java.lang.Exception
    //   2734	175	3	localObject6	Object
    //   2915	6	3	localException7	java.lang.Exception
    //   2953	353	3	localObject7	Object
    //   3309	6	3	localException8	java.lang.Exception
    //   3361	140	3	localObject8	Object
    //   3507	6	3	localException9	java.lang.Exception
    //   373	2036	4	localObject9	Object
    //   2414	7	4	localException10	java.lang.Exception
    //   2431	7	4	localException11	java.lang.Exception
    //   2446	114	4	localObject10	Object
    //   2565	7	4	localException12	java.lang.Exception
    //   2580	462	4	localObject11	Object
    //   3047	7	4	localException13	java.lang.Exception
    //   3062	459	4	localObject12	Object
    //   90	3377	5	localDynamicTextFontInfo	DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo
    //   48	3446	6	localObject13	Object
    //   363	1221	7	localObject14	Object
    //   1794	16	7	localRuntimeException2	java.lang.RuntimeException
    //   1937	21	7	localException14	java.lang.Exception
    //   2019	99	7	localBitmap	android.graphics.Bitmap
    //   2257	21	7	localException15	java.lang.Exception
    //   2784	505	7	localObject15	Object
    //   3324	7	7	localException16	java.lang.Exception
    //   76	2028	8	localObject16	Object
    //   2126	1131	8	localException17	java.lang.Exception
    //   1073	207	9	localObject17	Object
    //   1130	160	10	localObject18	Object
    //   1187	157	11	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   380	412	465	java/lang/Exception
    //   487	520	539	java/lang/Exception
    //   596	628	706	java/lang/Exception
    //   728	761	783	java/lang/Exception
    //   1303	1336	1357	java/lang/RuntimeException
    //   1598	1631	1652	java/lang/Exception
    //   1741	1774	1794	java/lang/RuntimeException
    //   1884	1917	1937	java/lang/Exception
    //   2070	2103	2126	java/lang/Exception
    //   2204	2237	2257	java/lang/Exception
    //   2308	2351	2414	java/lang/Exception
    //   2361	2394	2431	java/lang/Exception
    //   2512	2545	2565	java/lang/Exception
    //   2592	2625	2696	java/lang/Exception
    //   2861	2894	2915	java/lang/Exception
    //   2994	3027	3047	java/lang/Exception
    //   3124	3156	3309	java/lang/Exception
    //   3245	3288	3324	java/lang/Exception
    //   3455	3488	3507	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextBuilder
 * JD-Core Version:    0.7.0.1
 */