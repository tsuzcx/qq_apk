package com.tencent.mobileqq.utils;

import android.content.Context;

public class FolderUtils
{
  public static Runnable a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangRunnable = new FolderUtils.1();
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 30
    //   2: invokestatic 36	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   5: invokevirtual 42	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +61 -> 71
    //   13: new 44	java/io/File
    //   16: dup
    //   17: getstatic 50	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   20: invokestatic 56	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 4
    //   28: new 44	java/io/File
    //   31: dup
    //   32: aload 4
    //   34: ldc 61
    //   36: invokespecial 64	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 68	java/io/File:exists	()Z
    //   46: ifeq +36 -> 82
    //   49: iconst_1
    //   50: istore_3
    //   51: iload_3
    //   52: ireturn
    //   53: astore_0
    //   54: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +12 -> 69
    //   60: ldc 75
    //   62: iconst_2
    //   63: ldc 77
    //   65: aload_0
    //   66: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   69: iconst_0
    //   70: ireturn
    //   71: invokestatic 87	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   74: invokevirtual 91	com/tencent/qphone/base/util/BaseApplication:getCacheDir	()Ljava/io/File;
    //   77: astore 4
    //   79: goto -51 -> 28
    //   82: aload 4
    //   84: invokevirtual 94	java/io/File:mkdirs	()Z
    //   87: istore_2
    //   88: getstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   91: ifne +7 -> 98
    //   94: iconst_1
    //   95: putstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   98: iload_2
    //   99: ifne +36 -> 135
    //   102: invokestatic 99	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   105: ifeq +15 -> 120
    //   108: invokestatic 102	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   111: ifeq +9 -> 120
    //   114: invokestatic 105	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   117: ifne +18 -> 135
    //   120: invokestatic 111	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   123: new 113	com/tencent/mobileqq/utils/FolderUtils$2
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 116	com/tencent/mobileqq/utils/FolderUtils$2:<init>	(Landroid/content/Context;)V
    //   131: invokevirtual 122	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   134: pop
    //   135: iload_2
    //   136: istore_3
    //   137: iload_1
    //   138: ifeq -87 -> 51
    //   141: iload_2
    //   142: ifne +11 -> 153
    //   145: iload_2
    //   146: istore_3
    //   147: getstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   150: ifeq -99 -> 51
    //   153: iload_2
    //   154: invokestatic 127	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   157: iload_2
    //   158: istore_3
    //   159: iload_2
    //   160: ifne -109 -> 51
    //   163: iconst_0
    //   164: putstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   167: iload_2
    //   168: ireturn
    //   169: astore 4
    //   171: invokestatic 99	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   174: ifeq +15 -> 189
    //   177: invokestatic 102	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   180: ifeq +9 -> 189
    //   183: invokestatic 105	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   186: ifne +18 -> 204
    //   189: invokestatic 111	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   192: new 113	com/tencent/mobileqq/utils/FolderUtils$2
    //   195: dup
    //   196: aload_0
    //   197: invokespecial 116	com/tencent/mobileqq/utils/FolderUtils$2:<init>	(Landroid/content/Context;)V
    //   200: invokevirtual 122	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   203: pop
    //   204: iload_1
    //   205: ifeq +94 -> 299
    //   208: getstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   211: ifeq +88 -> 299
    //   214: iconst_0
    //   215: invokestatic 127	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   218: iconst_0
    //   219: putstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   222: iconst_0
    //   223: ireturn
    //   224: astore 4
    //   226: iconst_0
    //   227: istore_2
    //   228: iload_2
    //   229: ifne +36 -> 265
    //   232: invokestatic 99	com/tencent/mobileqq/utils/FileUtils:b	()Z
    //   235: ifeq +15 -> 250
    //   238: invokestatic 102	com/tencent/mobileqq/utils/FileUtils:c	()Z
    //   241: ifeq +9 -> 250
    //   244: invokestatic 105	com/tencent/mobileqq/utils/FileUtils:d	()Z
    //   247: ifne +18 -> 265
    //   250: invokestatic 111	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   253: new 113	com/tencent/mobileqq/utils/FolderUtils$2
    //   256: dup
    //   257: aload_0
    //   258: invokespecial 116	com/tencent/mobileqq/utils/FolderUtils$2:<init>	(Landroid/content/Context;)V
    //   261: invokevirtual 122	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   264: pop
    //   265: iload_1
    //   266: ifeq +25 -> 291
    //   269: iload_2
    //   270: ifne +9 -> 279
    //   273: getstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   276: ifeq +15 -> 291
    //   279: iload_2
    //   280: invokestatic 127	com/tencent/mobileqq/pic/PicReporter:a	(Z)V
    //   283: iload_2
    //   284: ifne +7 -> 291
    //   287: iconst_0
    //   288: putstatic 11	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   291: aload 4
    //   293: athrow
    //   294: astore 4
    //   296: goto -68 -> 228
    //   299: iconst_0
    //   300: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramBoolean	boolean
    //   8	276	2	bool1	boolean
    //   50	109	3	bool2	boolean
    //   26	57	4	localFile	java.io.File
    //   169	1	4	localException	java.lang.Exception
    //   224	68	4	localObject1	Object
    //   294	1	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/lang/NullPointerException
    //   82	88	169	java/lang/Exception
    //   88	98	169	java/lang/Exception
    //   82	88	224	finally
    //   88	98	294	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FolderUtils
 * JD-Core Version:    0.7.0.1
 */