package cooperation.vip.vipcomponent;

import android.text.TextUtils;
import java.io.File;

public class VipUtils
{
  public static int a(String paramString)
  {
    if (b(paramString)) {
      return 0;
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return 0;
    }
    if (i == paramString.length() - 1) {
      return 0;
    }
    paramString = paramString.substring(0, i);
    if (b(paramString)) {
      return 0;
    }
    i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return 0;
    }
    if (i == paramString.length() - 1) {
      return 0;
    }
    try
    {
      i = Integer.parseInt(paramString.substring(i + 1));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: ifnull +77 -> 90
    //   16: aload 7
    //   18: astore_2
    //   19: aload_1
    //   20: getfield 55	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: ifeq +67 -> 90
    //   26: aload 7
    //   28: astore_2
    //   29: new 57	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore_0
    //   38: new 62	java/io/BufferedInputStream
    //   41: dup
    //   42: aload_0
    //   43: sipush 8192
    //   46: invokespecial 65	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   49: aconst_null
    //   50: aload_1
    //   51: invokestatic 71	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   54: astore_1
    //   55: aload_0
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: goto +183 -> 242
    //   62: astore_1
    //   63: aload_0
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: goto +262 -> 329
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_0
    //   74: astore_1
    //   75: aload_2
    //   76: astore_0
    //   77: goto +185 -> 262
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_0
    //   84: astore_1
    //   85: aload_2
    //   86: astore_0
    //   87: goto +212 -> 299
    //   90: aload 7
    //   92: astore_2
    //   93: new 19	java/io/File
    //   96: dup
    //   97: aload_0
    //   98: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 78	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   104: ifeq +81 -> 185
    //   107: aload 7
    //   109: astore_2
    //   110: aload_0
    //   111: invokestatic 82	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   114: astore_3
    //   115: aload 6
    //   117: astore_2
    //   118: aload_3
    //   119: astore_0
    //   120: aload_3
    //   121: ifnull +121 -> 242
    //   124: aload 6
    //   126: astore_2
    //   127: aload_3
    //   128: astore_0
    //   129: aload_1
    //   130: ifnull +112 -> 242
    //   133: aload 7
    //   135: astore_2
    //   136: aload_1
    //   137: aload_3
    //   138: invokevirtual 87	android/graphics/Bitmap:getHeight	()I
    //   141: putfield 91	android/graphics/BitmapFactory$Options:outHeight	I
    //   144: aload 7
    //   146: astore_2
    //   147: aload_1
    //   148: aload_3
    //   149: invokevirtual 94	android/graphics/Bitmap:getWidth	()I
    //   152: putfield 97	android/graphics/BitmapFactory$Options:outWidth	I
    //   155: aload 6
    //   157: astore_2
    //   158: aload_3
    //   159: astore_0
    //   160: goto +82 -> 242
    //   163: astore_1
    //   164: aload_3
    //   165: astore_0
    //   166: aload_1
    //   167: astore_3
    //   168: aload 4
    //   170: astore_1
    //   171: goto +91 -> 262
    //   174: astore_1
    //   175: aload_3
    //   176: astore_0
    //   177: aload_1
    //   178: astore_3
    //   179: aload 5
    //   181: astore_1
    //   182: goto +117 -> 299
    //   185: aload 7
    //   187: astore_2
    //   188: invokestatic 103	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   191: invokevirtual 107	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   194: instanceof 109
    //   197: ifeq +33 -> 230
    //   200: aload 7
    //   202: astore_2
    //   203: invokestatic 115	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   206: invokevirtual 119	com/tencent/component/media/image/ImageManager:getDecoder	()Lcom/tencent/component/media/image/IDecoder;
    //   209: new 19	java/io/File
    //   212: dup
    //   213: aload_0
    //   214: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: aload_1
    //   218: invokeinterface 125 3 0
    //   223: astore_0
    //   224: aload 6
    //   226: astore_2
    //   227: goto +15 -> 242
    //   230: aload 7
    //   232: astore_2
    //   233: aload_0
    //   234: aload_1
    //   235: invokestatic 129	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   238: astore_0
    //   239: aload 6
    //   241: astore_2
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 134	java/io/InputStream:close	()V
    //   250: aload_0
    //   251: areturn
    //   252: astore_0
    //   253: goto +76 -> 329
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_0
    //   259: aload 4
    //   261: astore_1
    //   262: aload_1
    //   263: astore_2
    //   264: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +14 -> 281
    //   270: aload_1
    //   271: astore_2
    //   272: ldc 142
    //   274: iconst_2
    //   275: ldc 144
    //   277: aload_3
    //   278: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_0
    //   282: astore_2
    //   283: aload_1
    //   284: ifnull +43 -> 327
    //   287: aload_1
    //   288: invokevirtual 134	java/io/InputStream:close	()V
    //   291: aload_0
    //   292: areturn
    //   293: astore_3
    //   294: aconst_null
    //   295: astore_0
    //   296: aload 5
    //   298: astore_1
    //   299: aload_1
    //   300: astore_2
    //   301: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq +14 -> 318
    //   307: aload_1
    //   308: astore_2
    //   309: ldc 142
    //   311: iconst_2
    //   312: ldc 144
    //   314: aload_3
    //   315: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   318: aload_0
    //   319: astore_2
    //   320: aload_1
    //   321: ifnull +6 -> 327
    //   324: goto -37 -> 287
    //   327: aload_2
    //   328: areturn
    //   329: aload_2
    //   330: ifnull +7 -> 337
    //   333: aload_2
    //   334: invokevirtual 134	java/io/InputStream:close	()V
    //   337: goto +5 -> 342
    //   340: aload_0
    //   341: athrow
    //   342: goto -2 -> 340
    //   345: astore_1
    //   346: goto -96 -> 250
    //   349: astore_1
    //   350: aload_0
    //   351: areturn
    //   352: astore_1
    //   353: goto -16 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString	String
    //   0	356	1	paramOptions	android.graphics.BitmapFactory.Options
    //   18	316	2	localObject1	Object
    //   70	1	3	localException1	Exception
    //   80	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   114	65	3	localObject2	Object
    //   256	22	3	localException2	Exception
    //   293	22	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   4	256	4	localObject3	Object
    //   7	290	5	localObject4	Object
    //   10	230	6	localObject5	Object
    //   1	230	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   38	55	62	finally
    //   38	55	70	java/lang/Exception
    //   38	55	80	java/lang/OutOfMemoryError
    //   136	144	163	java/lang/Exception
    //   147	155	163	java/lang/Exception
    //   136	144	174	java/lang/OutOfMemoryError
    //   147	155	174	java/lang/OutOfMemoryError
    //   19	26	252	finally
    //   29	38	252	finally
    //   93	107	252	finally
    //   110	115	252	finally
    //   136	144	252	finally
    //   147	155	252	finally
    //   188	200	252	finally
    //   203	224	252	finally
    //   233	239	252	finally
    //   264	270	252	finally
    //   272	281	252	finally
    //   301	307	252	finally
    //   309	318	252	finally
    //   19	26	256	java/lang/Exception
    //   29	38	256	java/lang/Exception
    //   93	107	256	java/lang/Exception
    //   110	115	256	java/lang/Exception
    //   188	200	256	java/lang/Exception
    //   203	224	256	java/lang/Exception
    //   233	239	256	java/lang/Exception
    //   19	26	293	java/lang/OutOfMemoryError
    //   29	38	293	java/lang/OutOfMemoryError
    //   93	107	293	java/lang/OutOfMemoryError
    //   110	115	293	java/lang/OutOfMemoryError
    //   188	200	293	java/lang/OutOfMemoryError
    //   203	224	293	java/lang/OutOfMemoryError
    //   233	239	293	java/lang/OutOfMemoryError
    //   246	250	345	java/io/IOException
    //   287	291	349	java/io/IOException
    //   333	337	352	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 4) {
        return "";
      }
      int i = paramString.lastIndexOf("/") + 1;
      int j = paramString.length() - 4;
      if (i <= j) {
        return paramString.substring(i, j);
      }
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return paramString;
    }
    if (i == paramString.length() - 1) {
      return "";
    }
    paramString = paramString.substring(0, i);
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    i = paramString.lastIndexOf(File.separator);
    if (i == -1) {
      return paramString;
    }
    if (i == paramString.length() - 1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.VipUtils
 * JD-Core Version:    0.7.0.1
 */