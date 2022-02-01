package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5Utils;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;", "", "()V", "ROOT", "", "kotlin.jvm.PlatformType", "TAG", "asyncDownload", "", "context", "Landroid/content/Context;", "urls", "", "block", "Lkotlin/Function1;", "Ljava/io/File;", "(Landroid/content/Context;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "checkurl", "", "url", "clear", "getFiles", "([Ljava/lang/String;)[Ljava/io/File;", "getRealFile", "getZipFile", "isDownloaded", "([Ljava/lang/String;)Z", "requestDownload", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopGiftResManager
{
  public static final TroopGiftResManager a;
  private static final String a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager = new TroopGiftResManager();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".troopgift/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  private final File a(String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MD5Utils.toMD5(paramString));
    localStringBuilder.append(".zip");
    return new File(str, localStringBuilder.toString());
  }
  
  /* Error */
  private final void a(Context paramContext, String paramString, Function1<? super File, Unit> paramFunction1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 48	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager	Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;
    //   5: aload_2
    //   6: invokespecial 95	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:a	(Ljava/lang/String;)Z
    //   9: ifeq +380 -> 389
    //   12: getstatic 48	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager	Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;
    //   15: aload_2
    //   16: invokespecial 98	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:b	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore 7
    //   21: aload 7
    //   23: invokevirtual 102	java/io/File:isDirectory	()Z
    //   26: ifne +8 -> 34
    //   29: aload 7
    //   31: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/io/File;)V
    //   34: aload 7
    //   36: invokevirtual 111	java/io/File:exists	()Z
    //   39: ifeq +15 -> 54
    //   42: aload_3
    //   43: aload 7
    //   45: invokeinterface 117 2 0
    //   50: pop
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: getstatic 48	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager	Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;
    //   57: aload_2
    //   58: invokespecial 119	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   61: astore 6
    //   63: new 121	com/tencent/mobileqq/vip/DownloadTask
    //   66: dup
    //   67: aload_2
    //   68: aload 6
    //   70: invokespecial 124	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   73: astore 8
    //   75: aload 8
    //   77: iconst_1
    //   78: putfield 128	com/tencent/mobileqq/vip/DownloadTask:h	Z
    //   81: aload 8
    //   83: aconst_null
    //   84: aload_1
    //   85: invokestatic 133	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/lang/String;Landroid/content/Context;)I
    //   88: istore 4
    //   90: iload 4
    //   92: ifne +222 -> 314
    //   95: aload 6
    //   97: invokevirtual 111	java/io/File:exists	()Z
    //   100: istore 5
    //   102: iload 5
    //   104: ifeq +148 -> 252
    //   107: aload 6
    //   109: invokevirtual 136	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: aload 7
    //   114: invokevirtual 136	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: iconst_0
    //   118: invokestatic 140	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   121: aload 7
    //   123: invokevirtual 144	java/io/File:listFiles	()[Ljava/io/File;
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +28 -> 156
    //   131: aload_1
    //   132: arraylength
    //   133: ifne +6 -> 139
    //   136: goto +20 -> 156
    //   139: aload_3
    //   140: aload 7
    //   142: invokeinterface 117 2 0
    //   147: pop
    //   148: aload 6
    //   150: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/io/File;)V
    //   153: aload_0
    //   154: monitorexit
    //   155: return
    //   156: new 50	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   163: astore_1
    //   164: aload_1
    //   165: ldc 146
    //   167: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: aload_2
    //   173: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: ldc 148
    //   180: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: aload 6
    //   187: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: ldc 153
    //   194: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_1
    //   199: iload 4
    //   201: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 158
    //   207: iconst_2
    //   208: aload_1
    //   209: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload 6
    //   217: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/io/File;)V
    //   220: goto +153 -> 373
    //   223: astore_1
    //   224: goto +21 -> 245
    //   227: astore_1
    //   228: ldc 158
    //   230: iconst_1
    //   231: aload_1
    //   232: checkcast 166	java/lang/Throwable
    //   235: iconst_0
    //   236: anewarray 4	java/lang/Object
    //   239: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   242: goto -27 -> 215
    //   245: aload 6
    //   247: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/io/File;)V
    //   250: aload_1
    //   251: athrow
    //   252: new 50	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   259: astore_1
    //   260: aload_1
    //   261: ldc 171
    //   263: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: aload_2
    //   269: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_1
    //   274: ldc 148
    //   276: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_1
    //   281: aload 6
    //   283: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: ldc 153
    //   290: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_1
    //   295: iload 4
    //   297: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 158
    //   303: iconst_2
    //   304: aload_1
    //   305: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: goto +62 -> 373
    //   314: new 50	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   321: astore_1
    //   322: aload_1
    //   323: ldc 173
    //   325: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_1
    //   330: aload_2
    //   331: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: ldc 148
    //   338: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_1
    //   343: aload 6
    //   345: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: ldc 153
    //   352: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: iload 4
    //   359: invokevirtual 156	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: ldc 158
    //   365: iconst_1
    //   366: aload_1
    //   367: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload_3
    //   374: aload 7
    //   376: invokeinterface 117 2 0
    //   381: pop
    //   382: getstatic 179	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   385: astore_1
    //   386: aload_0
    //   387: monitorexit
    //   388: return
    //   389: new 50	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   396: astore_1
    //   397: aload_1
    //   398: ldc 181
    //   400: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload_1
    //   405: aload_2
    //   406: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: new 183	java/lang/RuntimeException
    //   413: dup
    //   414: aload_1
    //   415: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokespecial 186	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   421: checkcast 166	java/lang/Throwable
    //   424: athrow
    //   425: astore_1
    //   426: aload_0
    //   427: monitorexit
    //   428: goto +5 -> 433
    //   431: aload_1
    //   432: athrow
    //   433: goto -2 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	TroopGiftResManager
    //   0	436	1	paramContext	Context
    //   0	436	2	paramString	String
    //   0	436	3	paramFunction1	Function1<? super File, Unit>
    //   88	270	4	i	int
    //   100	3	5	bool	boolean
    //   61	283	6	localFile1	File
    //   19	356	7	localFile2	File
    //   73	9	8	localDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    // Exception table:
    //   from	to	target	type
    //   107	127	223	finally
    //   131	136	223	finally
    //   139	148	223	finally
    //   156	215	223	finally
    //   228	242	223	finally
    //   107	127	227	java/lang/Exception
    //   131	136	227	java/lang/Exception
    //   139	148	227	java/lang/Exception
    //   156	215	227	java/lang/Exception
    //   2	34	425	finally
    //   34	51	425	finally
    //   54	90	425	finally
    //   95	102	425	finally
    //   148	153	425	finally
    //   215	220	425	finally
    //   245	252	425	finally
    //   252	311	425	finally
    //   314	373	425	finally
    //   373	386	425	finally
    //   389	425	425	finally
  }
  
  private final boolean a(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      return StringsKt.startsWith$default(paramString, "http", false, 2, null);
    }
    return false;
  }
  
  private final File b(String paramString)
  {
    return new File(jdField_a_of_type_JavaLangString, MD5Utils.toMD5(paramString));
  }
  
  public final void a(@NotNull Context paramContext, @NotNull String[] paramArrayOfString, @NotNull Function1<? super File[], Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "urls");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    ThreadManagerV2.excute((Runnable)new TroopGiftResManager.asyncDownload.1(paramArrayOfString, paramContext, paramFunction1), 128, null, false);
  }
  
  public final boolean a(@NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "urls");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.a(str)) {
        return false;
      }
      if (!jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.b(str).exists()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @NotNull
  public final File[] a(@NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "urls");
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(b(paramArrayOfString[i]));
      i += 1;
    }
    paramArrayOfString = localArrayList.toArray(new File[0]);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfString, "files.toArray(emptyArray())");
    return (File[])paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftResManager
 * JD-Core Version:    0.7.0.1
 */