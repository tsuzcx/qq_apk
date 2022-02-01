package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FolderUtils
{
  public static Runnable a;
  public static boolean a = true;
  
  static
  {
    jdField_a_of_type_JavaLangRunnable = new FolderUtils.1();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("device busy ");
      localStringBuilder.append(paramBoolean);
      QLog.i("PicReporter", 2, localStringBuilder.toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "Pic.Mkdir.DeviceBusy", paramBoolean, 0L, 0L, null, "");
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  /* Error */
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 83	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   5: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +20 -> 30
    //   13: new 91	java/io/File
    //   16: dup
    //   17: getstatic 97	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   20: invokestatic 103	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: goto +10 -> 37
    //   30: invokestatic 54	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   33: invokevirtual 110	com/tencent/qphone/base/util/BaseApplication:getCacheDir	()Ljava/io/File;
    //   36: astore_3
    //   37: new 91	java/io/File
    //   40: dup
    //   41: aload_3
    //   42: ldc 112
    //   44: invokespecial 115	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_3
    //   48: aload_3
    //   49: invokevirtual 118	java/io/File:exists	()Z
    //   52: ifeq +5 -> 57
    //   55: iconst_1
    //   56: ireturn
    //   57: aload_3
    //   58: invokevirtual 121	java/io/File:mkdirs	()Z
    //   61: istore_2
    //   62: getstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   65: ifne +7 -> 72
    //   68: iconst_1
    //   69: putstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   72: iload_2
    //   73: ifne +36 -> 109
    //   76: invokestatic 128	com/tencent/mobileqq/utils/FileUtils:checkTencentFolderExist	()Z
    //   79: ifeq +15 -> 94
    //   82: invokestatic 131	com/tencent/mobileqq/utils/FileUtils:checkMobileQQFolderExist	()Z
    //   85: ifeq +9 -> 94
    //   88: invokestatic 134	com/tencent/mobileqq/utils/FileUtils:checkDiskCacheExist	()Z
    //   91: ifne +18 -> 109
    //   94: invokestatic 140	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   97: new 142	com/tencent/mobileqq/utils/FolderUtils$2
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 145	com/tencent/mobileqq/utils/FolderUtils$2:<init>	(Landroid/content/Context;)V
    //   105: invokevirtual 151	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   108: pop
    //   109: iload_1
    //   110: ifeq +25 -> 135
    //   113: iload_2
    //   114: ifne +9 -> 123
    //   117: getstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   120: ifeq +15 -> 135
    //   123: iload_2
    //   124: invokestatic 153	com/tencent/mobileqq/utils/FolderUtils:a	(Z)V
    //   127: iload_2
    //   128: ifne +7 -> 135
    //   131: iconst_0
    //   132: putstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   135: iload_2
    //   136: ireturn
    //   137: astore_3
    //   138: goto +6 -> 144
    //   141: astore_3
    //   142: iconst_0
    //   143: istore_2
    //   144: iload_2
    //   145: ifne +36 -> 181
    //   148: invokestatic 128	com/tencent/mobileqq/utils/FileUtils:checkTencentFolderExist	()Z
    //   151: ifeq +15 -> 166
    //   154: invokestatic 131	com/tencent/mobileqq/utils/FileUtils:checkMobileQQFolderExist	()Z
    //   157: ifeq +9 -> 166
    //   160: invokestatic 134	com/tencent/mobileqq/utils/FileUtils:checkDiskCacheExist	()Z
    //   163: ifne +18 -> 181
    //   166: invokestatic 140	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   169: new 142	com/tencent/mobileqq/utils/FolderUtils$2
    //   172: dup
    //   173: aload_0
    //   174: invokespecial 145	com/tencent/mobileqq/utils/FolderUtils$2:<init>	(Landroid/content/Context;)V
    //   177: invokevirtual 151	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   180: pop
    //   181: iload_1
    //   182: ifeq +25 -> 207
    //   185: iload_2
    //   186: ifne +9 -> 195
    //   189: getstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   192: ifeq +15 -> 207
    //   195: iload_2
    //   196: invokestatic 153	com/tencent/mobileqq/utils/FolderUtils:a	(Z)V
    //   199: iload_2
    //   200: ifne +7 -> 207
    //   203: iconst_0
    //   204: putstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   207: aload_3
    //   208: athrow
    //   209: invokestatic 128	com/tencent/mobileqq/utils/FileUtils:checkTencentFolderExist	()Z
    //   212: ifeq +15 -> 227
    //   215: invokestatic 131	com/tencent/mobileqq/utils/FileUtils:checkMobileQQFolderExist	()Z
    //   218: ifeq +9 -> 227
    //   221: invokestatic 134	com/tencent/mobileqq/utils/FileUtils:checkDiskCacheExist	()Z
    //   224: ifne +18 -> 242
    //   227: invokestatic 140	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   230: new 142	com/tencent/mobileqq/utils/FolderUtils$2
    //   233: dup
    //   234: aload_0
    //   235: invokespecial 145	com/tencent/mobileqq/utils/FolderUtils$2:<init>	(Landroid/content/Context;)V
    //   238: invokevirtual 151	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   241: pop
    //   242: iload_1
    //   243: ifeq +17 -> 260
    //   246: getstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   249: ifeq +11 -> 260
    //   252: iconst_0
    //   253: invokestatic 153	com/tencent/mobileqq/utils/FolderUtils:a	(Z)V
    //   256: iconst_0
    //   257: putstatic 123	com/tencent/mobileqq/utils/FolderUtils:jdField_a_of_type_Boolean	Z
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +12 -> 278
    //   269: ldc 155
    //   271: iconst_2
    //   272: ldc 157
    //   274: aload_0
    //   275: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   278: iconst_0
    //   279: ireturn
    //   280: astore_3
    //   281: goto -72 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramContext	Context
    //   0	284	1	paramBoolean	boolean
    //   8	192	2	bool	boolean
    //   26	32	3	localFile	java.io.File
    //   137	1	3	localObject1	Object
    //   141	67	3	localObject2	Object
    //   280	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   62	72	137	finally
    //   57	62	141	finally
    //   0	9	262	java/lang/NullPointerException
    //   57	62	280	java/lang/Exception
    //   62	72	280	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.FolderUtils
 * JD-Core Version:    0.7.0.1
 */