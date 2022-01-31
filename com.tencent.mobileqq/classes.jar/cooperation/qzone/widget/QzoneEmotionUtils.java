package cooperation.qzone.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QzoneEmotionUtils
{
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(106);
  private static Map jdField_a_of_type_JavaUtilMap;
  public static ConcurrentHashMap a;
  public static final Pattern a;
  private static boolean jdField_a_of_type_Boolean;
  private static final HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap(106);
  private static Map jdField_b_of_type_JavaUtilMap;
  public static final Pattern b;
  public static final Pattern c = Pattern.compile("\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b", 2);
  public static final Pattern d = Pattern.compile("\\{uin:.*?\\}");
  private static Pattern e;
  private static Pattern f;
  private static Pattern g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]", 2);
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\[/美女\\]|\\[/钱\\]");
  }
  
  public static int a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap == null) {
      c();
    }
    if (jdField_a_of_type_JavaUtilMap != null)
    {
      paramString = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return -1;
  }
  
  public static final Drawable a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= QzoneEmoticonConstants.jdField_c_of_type_ArrayOfInt.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(QzoneEmoticonConstants.jdField_c_of_type_ArrayOfInt[paramInt]);
  }
  
  public static String a(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    Matcher localMatcher = g.matcher(paramString);
    while (localMatcher.find())
    {
      String str = localMatcher.group();
      if (jdField_b_of_type_JavaUtilHashMap.containsKey(str)) {
        paramString = paramString.replace(str, (CharSequence)jdField_b_of_type_JavaUtilHashMap.get(str));
      }
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString1);
    while (localMatcher.find()) {
      paramString1 = paramString1.replace(localMatcher.group(), paramString2);
    }
    return paramString1;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: iconst_0
    //   5: istore_0
    //   6: aload_3
    //   7: astore 4
    //   9: iload_2
    //   10: istore_1
    //   11: aload_3
    //   12: astore 5
    //   14: aload_3
    //   15: astore 6
    //   17: iload_0
    //   18: getstatic 162	cooperation/qzone/widget/QzoneEmoticonConstants:jdField_a_of_type_ArrayOfInt	[I
    //   21: arraylength
    //   22: if_icmpge +145 -> 167
    //   25: aload_3
    //   26: astore 5
    //   28: aload_3
    //   29: astore 6
    //   31: getstatic 164	cooperation/qzone/widget/QzoneEmoticonConstants:b	[I
    //   34: getstatic 162	cooperation/qzone/widget/QzoneEmoticonConstants:jdField_a_of_type_ArrayOfInt	[I
    //   37: iload_0
    //   38: iaload
    //   39: iaload
    //   40: istore_1
    //   41: aload_3
    //   42: astore 4
    //   44: aload_3
    //   45: astore 5
    //   47: aload_3
    //   48: astore 6
    //   50: getstatic 25	cooperation/qzone/widget/QzoneEmotionUtils:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: iload_1
    //   54: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: ifnonnull +74 -> 134
    //   63: aload_3
    //   64: astore 5
    //   66: aload_3
    //   67: astore 6
    //   69: invokestatic 111	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   72: invokevirtual 117	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   75: iload_1
    //   76: invokevirtual 173	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   79: astore_3
    //   80: aload_3
    //   81: astore 5
    //   83: aload_3
    //   84: astore 4
    //   86: aload_3
    //   87: aconst_null
    //   88: invokestatic 179	android/graphics/drawable/BitmapDrawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   91: invokevirtual 185	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   94: astore 6
    //   96: aload_3
    //   97: astore 5
    //   99: aload_3
    //   100: astore 4
    //   102: getstatic 25	cooperation/qzone/widget/QzoneEmotionUtils:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   105: iload_1
    //   106: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aload 6
    //   111: checkcast 175	android/graphics/drawable/BitmapDrawable
    //   114: invokevirtual 189	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   117: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload_3
    //   122: astore 5
    //   124: aload_3
    //   125: astore 4
    //   127: aload_3
    //   128: invokevirtual 198	java/io/InputStream:close	()V
    //   131: aload_3
    //   132: astore 4
    //   134: iload_0
    //   135: iconst_1
    //   136: iadd
    //   137: istore_0
    //   138: aload 4
    //   140: astore_3
    //   141: goto -135 -> 6
    //   144: astore 6
    //   146: aload_3
    //   147: astore 5
    //   149: aload_3
    //   150: astore 4
    //   152: ldc 200
    //   154: ldc 202
    //   156: aload 6
    //   158: invokestatic 207	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: aload_3
    //   162: astore 4
    //   164: goto -30 -> 134
    //   167: aload 4
    //   169: astore 5
    //   171: aload 4
    //   173: astore 6
    //   175: iload_1
    //   176: getstatic 209	cooperation/qzone/widget/QzoneEmoticonConstants:jdField_d_of_type_ArrayOfInt	[I
    //   179: arraylength
    //   180: if_icmpge +141 -> 321
    //   183: aload 4
    //   185: astore 5
    //   187: aload 4
    //   189: astore 6
    //   191: getstatic 209	cooperation/qzone/widget/QzoneEmoticonConstants:jdField_d_of_type_ArrayOfInt	[I
    //   194: iload_1
    //   195: iaload
    //   196: istore_0
    //   197: aload 4
    //   199: astore_3
    //   200: aload 4
    //   202: astore 5
    //   204: aload 4
    //   206: astore 6
    //   208: getstatic 25	cooperation/qzone/widget/QzoneEmotionUtils:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   211: iload_0
    //   212: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: ifnonnull +73 -> 291
    //   221: aload 4
    //   223: astore 5
    //   225: aload 4
    //   227: astore 6
    //   229: invokestatic 111	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   232: invokevirtual 117	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   235: iload_0
    //   236: invokevirtual 173	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   239: astore_3
    //   240: aload_3
    //   241: astore 5
    //   243: aload_3
    //   244: astore 4
    //   246: aload_3
    //   247: aconst_null
    //   248: invokestatic 179	android/graphics/drawable/BitmapDrawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   251: invokevirtual 185	android/graphics/drawable/Drawable:mutate	()Landroid/graphics/drawable/Drawable;
    //   254: astore 6
    //   256: aload_3
    //   257: astore 5
    //   259: aload_3
    //   260: astore 4
    //   262: getstatic 25	cooperation/qzone/widget/QzoneEmotionUtils:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   265: iload_0
    //   266: invokestatic 168	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aload 6
    //   271: checkcast 175	android/graphics/drawable/BitmapDrawable
    //   274: invokevirtual 189	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   277: invokevirtual 193	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: aload_3
    //   282: astore 5
    //   284: aload_3
    //   285: astore 4
    //   287: aload_3
    //   288: invokevirtual 198	java/io/InputStream:close	()V
    //   291: iload_1
    //   292: iconst_1
    //   293: iadd
    //   294: istore_1
    //   295: aload_3
    //   296: astore 4
    //   298: goto -131 -> 167
    //   301: astore 6
    //   303: aload_3
    //   304: astore 5
    //   306: aload_3
    //   307: astore 4
    //   309: ldc 200
    //   311: ldc 202
    //   313: aload 6
    //   315: invokestatic 207	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   318: goto -27 -> 291
    //   321: aload 4
    //   323: ifnull +8 -> 331
    //   326: aload 4
    //   328: invokevirtual 198	java/io/InputStream:close	()V
    //   331: return
    //   332: astore_3
    //   333: ldc 200
    //   335: ldc 202
    //   337: aload_3
    //   338: invokestatic 207	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: return
    //   342: astore_3
    //   343: aload 5
    //   345: astore 4
    //   347: ldc 211
    //   349: ldc 213
    //   351: aload_3
    //   352: invokestatic 216	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   355: aload 5
    //   357: ifnull -26 -> 331
    //   360: aload 5
    //   362: invokevirtual 198	java/io/InputStream:close	()V
    //   365: return
    //   366: astore_3
    //   367: ldc 200
    //   369: ldc 202
    //   371: aload_3
    //   372: invokestatic 207	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   375: return
    //   376: astore_3
    //   377: aload 4
    //   379: ifnull +8 -> 387
    //   382: aload 4
    //   384: invokevirtual 198	java/io/InputStream:close	()V
    //   387: aload_3
    //   388: athrow
    //   389: astore 4
    //   391: ldc 200
    //   393: ldc 202
    //   395: aload 4
    //   397: invokestatic 207	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   400: goto -13 -> 387
    //   403: astore_3
    //   404: aload 5
    //   406: astore 4
    //   408: goto -31 -> 377
    //   411: astore_3
    //   412: aload 6
    //   414: astore 5
    //   416: goto -73 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	261	0	i	int
    //   10	285	1	j	int
    //   1	9	2	k	int
    //   3	304	3	localObject1	Object
    //   332	6	3	localException1	java.lang.Exception
    //   342	10	3	localThrowable1	java.lang.Throwable
    //   366	6	3	localException2	java.lang.Exception
    //   376	12	3	localObject2	Object
    //   403	1	3	localObject3	Object
    //   411	1	3	localThrowable2	java.lang.Throwable
    //   7	376	4	localObject4	Object
    //   389	7	4	localException3	java.lang.Exception
    //   406	1	4	localObject5	Object
    //   12	403	5	localObject6	Object
    //   15	95	6	localObject7	Object
    //   144	13	6	localException4	java.lang.Exception
    //   173	97	6	localObject8	Object
    //   301	112	6	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   127	131	144	java/lang/Exception
    //   287	291	301	java/lang/Exception
    //   326	331	332	java/lang/Exception
    //   86	96	342	java/lang/Throwable
    //   102	121	342	java/lang/Throwable
    //   127	131	342	java/lang/Throwable
    //   152	161	342	java/lang/Throwable
    //   246	256	342	java/lang/Throwable
    //   262	281	342	java/lang/Throwable
    //   287	291	342	java/lang/Throwable
    //   309	318	342	java/lang/Throwable
    //   360	365	366	java/lang/Exception
    //   86	96	376	finally
    //   102	121	376	finally
    //   127	131	376	finally
    //   152	161	376	finally
    //   246	256	376	finally
    //   262	281	376	finally
    //   287	291	376	finally
    //   309	318	376	finally
    //   347	355	376	finally
    //   382	387	389	java/lang/Exception
    //   17	25	403	finally
    //   31	41	403	finally
    //   50	63	403	finally
    //   69	80	403	finally
    //   175	183	403	finally
    //   191	197	403	finally
    //   208	221	403	finally
    //   229	240	403	finally
    //   17	25	411	java/lang/Throwable
    //   31	41	411	java/lang/Throwable
    //   50	63	411	java/lang/Throwable
    //   69	80	411	java/lang/Throwable
    //   175	183	411	java/lang/Throwable
    //   191	197	411	java/lang/Throwable
    //   208	221	411	java/lang/Throwable
    //   229	240	411	java/lang/Throwable
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    while (paramString.find()) {
      i += 1;
    }
    return i;
  }
  
  public static final Drawable b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= QzoneEmoticonConstants.jdField_d_of_type_ArrayOfInt.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(QzoneEmoticonConstants.jdField_d_of_type_ArrayOfInt[paramInt]);
  }
  
  public static String b(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    if ((e == null) || (paramString == null)) {
      return paramString;
    }
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    Matcher localMatcher = f.matcher(paramString);
    while (localMatcher.find())
    {
      if (localMatcher.start() >= i)
      {
        localStringBuilder.append(g(paramString.substring(i, localMatcher.start())));
        localStringBuilder.append(paramString.substring(localMatcher.start(), localMatcher.end()));
      }
      i = localMatcher.end();
    }
    localStringBuilder.append(g(paramString.substring(i, paramString.length())));
    return localStringBuilder.toString();
  }
  
  private static void b()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        int k = QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString.length;
        int i = 0;
        Object localObject1;
        if (i < k)
        {
          jdField_a_of_type_JavaUtilHashMap.put(QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString[i], QzoneEmoticonConstants.jdField_c_of_type_ArrayOfJavaLangString[i]);
          HashMap localHashMap = jdField_b_of_type_JavaUtilHashMap;
          String str2 = QzoneEmoticonConstants.jdField_c_of_type_ArrayOfJavaLangString[i];
          if (i < QzoneEmoticonConstants.h.length)
          {
            localObject1 = QzoneEmoticonConstants.h[i];
            localHashMap.put(str2, localObject1);
            i += 1;
          }
        }
        else
        {
          localObject1 = new StringBuffer("(" + QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString[0] + ")");
          i = j;
          if (i < k)
          {
            ((StringBuffer)localObject1).append("|(" + QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString[i] + ")");
            i += 1;
            continue;
          }
          f = Pattern.compile("@\\{uin:.*?,\\s*nick:.*?\\}");
          e = Pattern.compile(((StringBuffer)localObject1).toString());
          g = Pattern.compile("\\[em\\]e\\d{1,}\\[/em\\]");
          jdField_a_of_type_Boolean = true;
          return;
        }
      }
      finally {}
      String str1 = "";
    }
  }
  
  public static String c(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {
      b();
    }
    if (paramString == null) {
      return paramString;
    }
    int j = QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString.length;
    String str = null;
    int i = 0;
    while (i < j)
    {
      if (QzoneEmoticonConstants.jdField_c_of_type_ArrayOfJavaLangString[i].equalsIgnoreCase(paramString)) {
        str = QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString[i];
      }
      i += 1;
    }
    return str;
  }
  
  private static void c()
  {
    int m = 0;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    int i = 0;
    int j;
    int k;
    for (;;)
    {
      j = i;
      k = m;
      if (i >= QzoneEmoticonConstants.jdField_e_of_type_ArrayOfJavaLangString.length) {
        break;
      }
      jdField_a_of_type_JavaUtilMap.put(QzoneEmoticonConstants.jdField_e_of_type_ArrayOfJavaLangString[i], Integer.valueOf(i));
      i += 1;
    }
    while (k < QzoneEmoticonConstants.g.length)
    {
      jdField_a_of_type_JavaUtilMap.put(QzoneEmoticonConstants.g[k], Integer.valueOf(j));
      k += 1;
      j += 1;
    }
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (jdField_b_of_type_JavaUtilMap == null) {
        d();
      }
    } while (!jdField_b_of_type_JavaUtilMap.containsKey(paramString));
    return (String)jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  private static void d()
  {
    int m = 0;
    jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    int j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= QzoneEmoticonConstants.jdField_a_of_type_ArrayOfInt.length) {
        break;
      }
      int i = (char)QzoneEmoticonConstants.jdField_a_of_type_ArrayOfInt[j];
      jdField_b_of_type_JavaUtilMap.put(QzoneEmoticonConstants.jdField_a_of_type_ArrayOfJavaLangString[j], String.valueOf(new char[] { '\024', i }));
      j += 1;
    }
    while (k < QzoneEmoticonConstants.jdField_e_of_type_ArrayOfInt.length)
    {
      jdField_b_of_type_JavaUtilMap.put(QzoneEmoticonConstants.g[k], String.valueOf(Character.toChars(QzoneEmoticonConstants.jdField_e_of_type_ArrayOfInt[k])));
      k += 1;
    }
  }
  
  public static String e(String paramString)
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "EmotionURL", "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1").replace("$id", paramString);
  }
  
  public static String f(String paramString)
  {
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    for (;;)
    {
      if (!localMatcher.find()) {
        return paramString;
      }
      String str = localMatcher.group();
      int i = 0;
      try
      {
        int j = Integer.parseInt(str.substring(5, 8));
        i = j - 100;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QZLog.w("EmoWindow", "parseInt error.");
        }
      }
      if ((i >= 0) && (i < QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString.length)) {
        paramString = paramString.replace(str, QzoneEmoticonConstants.jdField_d_of_type_ArrayOfJavaLangString[i]);
      }
    }
    return paramString;
  }
  
  private static String g(String paramString)
  {
    Matcher localMatcher = e.matcher(paramString);
    while (localMatcher.find())
    {
      String str1 = localMatcher.group();
      if (str1 != null)
      {
        String str2 = (String)jdField_a_of_type_JavaUtilHashMap.get(str1);
        if (str2 != null)
        {
          str1 = paramString.replace(str1, str2);
          if (str1 != null) {
            paramString = str1;
          }
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.QzoneEmotionUtils
 * JD-Core Version:    0.7.0.1
 */