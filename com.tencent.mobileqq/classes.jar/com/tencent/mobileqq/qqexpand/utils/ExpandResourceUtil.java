package com.tencent.mobileqq.qqexpand.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ExpandResourceUtil
{
  public static final String[] a = { "expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png", "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png", "expand_square_blank.png", "expand_voice_animation.json", "expand_summary_bg.png", "expand_summary_default_bg.png", "expand_guide_wording.png", "expand_guide_profile.png", "expand_guide_switch.png", "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png" };
  public static final String[] b = { "expand_summary_bg1.png", "expand_summary_bg2.png", "expand_summary_bg3.png", "expand_summary_bg4.png" };
  public static final String[] c = { "expand_feed_bg1.png", "expand_feed_bg2.png", "expand_feed_bg3.png", "expand_feed_bg4.png" };
  public static final String[] d = { "expand_voice_logo1.png", "expand_voice_logo2.png", "expand_voice_logo3.png", "expand_voice_logo4.png" };
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +202 -> 206
    //   7: new 76	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 83	java/io/File:exists	()Z
    //   20: ifeq +167 -> 187
    //   23: new 85	java/io/BufferedInputStream
    //   26: dup
    //   27: new 87	java/io/FileInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore_2
    //   41: aload_3
    //   42: aconst_null
    //   43: aload_1
    //   44: invokestatic 99	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   47: astore_1
    //   48: aload_3
    //   49: invokevirtual 104	java/io/InputStream:close	()V
    //   52: goto +13 -> 65
    //   55: astore_0
    //   56: ldc 106
    //   58: iconst_1
    //   59: ldc 108
    //   61: aload_0
    //   62: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: goto +16 -> 84
    //   71: astore_1
    //   72: goto +47 -> 119
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_2
    //   78: goto +86 -> 164
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_3
    //   84: aload_3
    //   85: astore_2
    //   86: ldc 106
    //   88: iconst_1
    //   89: ldc 116
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: aastore
    //   99: invokestatic 120	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: aload_1
    //   103: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_3
    //   107: ifnull +99 -> 206
    //   110: aload_3
    //   111: invokevirtual 104	java/io/InputStream:close	()V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_3
    //   119: aload_3
    //   120: astore_2
    //   121: ldc 106
    //   123: iconst_1
    //   124: ldc 116
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_0
    //   133: aastore
    //   134: invokestatic 120	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   137: aload_1
    //   138: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   141: aload_3
    //   142: ifnull +64 -> 206
    //   145: aload_3
    //   146: invokevirtual 104	java/io/InputStream:close	()V
    //   149: aconst_null
    //   150: areturn
    //   151: astore_0
    //   152: ldc 106
    //   154: iconst_1
    //   155: ldc 108
    //   157: aload_0
    //   158: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: aload_2
    //   165: ifnull +20 -> 185
    //   168: aload_2
    //   169: invokevirtual 104	java/io/InputStream:close	()V
    //   172: goto +13 -> 185
    //   175: astore_1
    //   176: ldc 106
    //   178: iconst_1
    //   179: ldc 108
    //   181: aload_1
    //   182: invokestatic 114	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   185: aload_0
    //   186: athrow
    //   187: ldc 106
    //   189: iconst_1
    //   190: ldc 124
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_0
    //   199: aastore
    //   200: invokestatic 120	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   203: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aconst_null
    //   207: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   0	208	1	paramOptions	android.graphics.BitmapFactory.Options
    //   15	154	2	localObject	Object
    //   38	108	3	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   48	52	55	java/lang/Exception
    //   41	48	67	java/lang/OutOfMemoryError
    //   41	48	71	java/lang/Exception
    //   23	39	75	finally
    //   23	39	81	java/lang/OutOfMemoryError
    //   23	39	116	java/lang/Exception
    //   110	114	151	java/lang/Exception
    //   145	149	151	java/lang/Exception
    //   41	48	163	finally
    //   86	106	163	finally
    //   121	141	163	finally
    //   168	172	175	java/lang/Exception
  }
  
  public static String a()
  {
    return String.format("%s/res", new Object[] { d() });
  }
  
  public static String a(String paramString)
  {
    return String.format("%s/%s", new Object[] { a(), paramString });
  }
  
  public static String[] a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      String[] arrayOfString2 = new String[paramArrayOfString.length];
      int i = 0;
      for (;;)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= paramArrayOfString.length) {
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
    return String.format("%s/res", new Object[] { e() });
  }
  
  public static String b(String paramString)
  {
    return String.format("%s/%s.zip", new Object[] { e(), paramString });
  }
  
  public static boolean b(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!new File(str).exists())
      {
        QLog.e("ExtendFriendResourceUtil", 1, String.format("isFilesExist check fail. filePath=%s", new Object[] { str }));
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean c()
  {
    return b(a(a));
  }
  
  private static String d()
  {
    Object localObject1 = MobileQQ.sMobileQQ.getFilesDir();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/pddata/prd/ef_res");
      localObject2 = ((StringBuilder)localObject2).toString();
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        return localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  private static String e()
  {
    Object localObject1 = MobileQQ.sMobileQQ.getFilesDir();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append("/pddata/prd/ef_flutter_res_v5");
      localObject2 = ((StringBuilder)localObject2).toString();
      File localFile = new File((String)localObject2);
      localObject1 = localObject2;
      if (!localFile.exists())
      {
        localFile.mkdirs();
        return localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil
 * JD-Core Version:    0.7.0.1
 */