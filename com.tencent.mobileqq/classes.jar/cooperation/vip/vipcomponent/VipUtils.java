package cooperation.vip.vipcomponent;

import android.text.TextUtils;
import java.io.File;

public class VipUtils
{
  public static int a(String paramString)
  {
    if (a(paramString)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return 0;
          i = paramString.lastIndexOf(File.separator);
        } while ((i == -1) || (i == paramString.length() - 1));
        paramString = paramString.substring(0, i);
      } while (a(paramString));
      i = paramString.lastIndexOf(File.separator);
    } while ((i == -1) || (i == paramString.length() - 1));
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
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_1
    //   12: ifnull +60 -> 72
    //   15: aload 6
    //   17: astore_2
    //   18: aload_1
    //   19: getfield 54	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   22: ifeq +50 -> 72
    //   25: aload 6
    //   27: astore_2
    //   28: new 56	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 59	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: new 61	java/io/BufferedInputStream
    //   40: dup
    //   41: aload_0
    //   42: sipush 8192
    //   45: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   48: aconst_null
    //   49: aload_1
    //   50: invokestatic 70	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: astore_1
    //   54: aload_0
    //   55: astore_2
    //   56: aload_1
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload_2
    //   61: ifnull +9 -> 70
    //   64: aload_2
    //   65: invokevirtual 75	java/io/InputStream:close	()V
    //   68: aload_0
    //   69: astore_1
    //   70: aload_1
    //   71: areturn
    //   72: aload 6
    //   74: astore_2
    //   75: new 18	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokestatic 82	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   86: ifeq +47 -> 133
    //   89: aload 6
    //   91: astore_2
    //   92: aload_0
    //   93: invokestatic 86	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +229 -> 327
    //   101: aload_1
    //   102: ifnull +225 -> 327
    //   105: aload 6
    //   107: astore_2
    //   108: aload_1
    //   109: aload_0
    //   110: invokevirtual 91	android/graphics/Bitmap:getHeight	()I
    //   113: putfield 95	android/graphics/BitmapFactory$Options:outHeight	I
    //   116: aload 6
    //   118: astore_2
    //   119: aload_1
    //   120: aload_0
    //   121: invokevirtual 98	android/graphics/Bitmap:getWidth	()I
    //   124: putfield 101	android/graphics/BitmapFactory$Options:outWidth	I
    //   127: aload 5
    //   129: astore_2
    //   130: goto -72 -> 58
    //   133: aload 6
    //   135: astore_2
    //   136: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   139: invokevirtual 111	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   142: instanceof 113
    //   145: ifeq +33 -> 178
    //   148: aload 6
    //   150: astore_2
    //   151: invokestatic 119	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   154: invokevirtual 123	com/tencent/component/media/image/ImageManager:getDecoder	()Lcom/tencent/component/media/image/IDecoder;
    //   157: new 18	java/io/File
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: aload_1
    //   166: invokeinterface 129 3 0
    //   171: astore_0
    //   172: aload 5
    //   174: astore_2
    //   175: goto -117 -> 58
    //   178: aload 6
    //   180: astore_2
    //   181: aload_0
    //   182: aload_1
    //   183: invokestatic 133	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   186: astore_0
    //   187: aload 5
    //   189: astore_2
    //   190: goto -132 -> 58
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_3
    //   197: astore_2
    //   198: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +14 -> 215
    //   204: aload_3
    //   205: astore_2
    //   206: ldc 141
    //   208: iconst_2
    //   209: ldc 143
    //   211: aload_1
    //   212: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: aload_0
    //   216: astore_1
    //   217: aload_3
    //   218: ifnull -148 -> 70
    //   221: aload_3
    //   222: invokevirtual 75	java/io/InputStream:close	()V
    //   225: aload_0
    //   226: areturn
    //   227: astore_1
    //   228: aload_0
    //   229: areturn
    //   230: astore_1
    //   231: aconst_null
    //   232: astore_0
    //   233: aload 4
    //   235: astore_3
    //   236: aload_3
    //   237: astore_2
    //   238: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +14 -> 255
    //   244: aload_3
    //   245: astore_2
    //   246: ldc 141
    //   248: iconst_2
    //   249: ldc 143
    //   251: aload_1
    //   252: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   255: aload_0
    //   256: astore_1
    //   257: aload_3
    //   258: ifnull -188 -> 70
    //   261: aload_3
    //   262: invokevirtual 75	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: areturn
    //   267: astore_1
    //   268: aload_0
    //   269: areturn
    //   270: astore_0
    //   271: aload_2
    //   272: ifnull +7 -> 279
    //   275: aload_2
    //   276: invokevirtual 75	java/io/InputStream:close	()V
    //   279: aload_0
    //   280: athrow
    //   281: astore_1
    //   282: aload_0
    //   283: areturn
    //   284: astore_1
    //   285: goto -6 -> 279
    //   288: astore_1
    //   289: aload_0
    //   290: astore_2
    //   291: aload_1
    //   292: astore_0
    //   293: goto -22 -> 271
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_2
    //   299: aload_0
    //   300: astore_3
    //   301: aload_2
    //   302: astore_0
    //   303: goto -67 -> 236
    //   306: astore_1
    //   307: aload 4
    //   309: astore_3
    //   310: goto -74 -> 236
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aload_0
    //   317: astore_3
    //   318: aload_2
    //   319: astore_0
    //   320: goto -124 -> 196
    //   323: astore_1
    //   324: goto -128 -> 196
    //   327: aload 5
    //   329: astore_2
    //   330: goto -272 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramString	String
    //   0	333	1	paramOptions	android.graphics.BitmapFactory.Options
    //   17	313	2	localObject1	Object
    //   1	317	3	localObject2	Object
    //   3	305	4	localObject3	Object
    //   9	319	5	localObject4	Object
    //   6	173	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	193	java/lang/OutOfMemoryError
    //   28	37	193	java/lang/OutOfMemoryError
    //   75	89	193	java/lang/OutOfMemoryError
    //   92	97	193	java/lang/OutOfMemoryError
    //   136	148	193	java/lang/OutOfMemoryError
    //   151	172	193	java/lang/OutOfMemoryError
    //   181	187	193	java/lang/OutOfMemoryError
    //   221	225	227	java/io/IOException
    //   18	25	230	java/lang/Exception
    //   28	37	230	java/lang/Exception
    //   75	89	230	java/lang/Exception
    //   92	97	230	java/lang/Exception
    //   136	148	230	java/lang/Exception
    //   151	172	230	java/lang/Exception
    //   181	187	230	java/lang/Exception
    //   261	265	267	java/io/IOException
    //   18	25	270	finally
    //   28	37	270	finally
    //   75	89	270	finally
    //   92	97	270	finally
    //   108	116	270	finally
    //   119	127	270	finally
    //   136	148	270	finally
    //   151	172	270	finally
    //   181	187	270	finally
    //   198	204	270	finally
    //   206	215	270	finally
    //   238	244	270	finally
    //   246	255	270	finally
    //   64	68	281	java/io/IOException
    //   275	279	284	java/io/IOException
    //   37	54	288	finally
    //   37	54	296	java/lang/Exception
    //   108	116	306	java/lang/Exception
    //   119	127	306	java/lang/Exception
    //   37	54	313	java/lang/OutOfMemoryError
    //   108	116	323	java/lang/OutOfMemoryError
    //   119	127	323	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return "";
    }
    int i = paramString.lastIndexOf("/") + 1;
    int j = paramString.length() - 4;
    if (i <= j) {
      return paramString.substring(i, j);
    }
    return "";
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String b(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        return str;
        i = paramString.lastIndexOf(File.separator);
        str = paramString;
      } while (i == -1);
      if (i == paramString.length() - 1) {
        return "";
      }
      paramString = paramString.substring(0, i);
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      i = paramString.lastIndexOf(File.separator);
      str = paramString;
    } while (i == -1);
    if (i == paramString.length() - 1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.vipcomponent.VipUtils
 * JD-Core Version:    0.7.0.1
 */