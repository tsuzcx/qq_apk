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
  public static final TroopGiftResManager a = new TroopGiftResManager();
  private static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".troopgift/");
    b = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  /* Error */
  private final void a(Context paramContext, String paramString, Function1<? super File, Unit> paramFunction1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 49	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:a	Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;
    //   5: aload_2
    //   6: invokespecial 84	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:c	(Ljava/lang/String;)Z
    //   9: ifne +37 -> 46
    //   12: new 51	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc 86
    //   23: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_1
    //   28: aload_2
    //   29: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 88
    //   35: iconst_1
    //   36: aload_1
    //   37: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: getstatic 49	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:a	Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;
    //   49: aload_2
    //   50: invokespecial 97	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:b	(Ljava/lang/String;)Ljava/io/File;
    //   53: astore 6
    //   55: aload 6
    //   57: invokevirtual 103	java/io/File:isDirectory	()Z
    //   60: ifne +8 -> 68
    //   63: aload 6
    //   65: invokestatic 109	com/tencent/mobileqq/utils/FileUtils:deleteFile	(Ljava/io/File;)V
    //   68: aload 6
    //   70: invokevirtual 112	java/io/File:exists	()Z
    //   73: ifeq +15 -> 88
    //   76: aload_3
    //   77: aload 6
    //   79: invokeinterface 118 2 0
    //   84: pop
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: getstatic 49	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:a	Lcom/tencent/mobileqq/vas/troopgift/TroopGiftResManager;
    //   91: aload_2
    //   92: invokevirtual 120	com/tencent/mobileqq/vas/troopgift/TroopGiftResManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   95: astore 7
    //   97: new 122	com/tencent/mobileqq/vip/DownloadTask
    //   100: dup
    //   101: aload_2
    //   102: aload 7
    //   104: invokespecial 125	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   107: astore 8
    //   109: aload 8
    //   111: iconst_1
    //   112: putfield 129	com/tencent/mobileqq/vip/DownloadTask:x	Z
    //   115: aload 8
    //   117: aconst_null
    //   118: aload_1
    //   119: invokestatic 134	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Ljava/lang/String;Landroid/content/Context;)I
    //   122: istore 4
    //   124: iload 4
    //   126: ifne +207 -> 333
    //   129: aload 7
    //   131: invokevirtual 112	java/io/File:exists	()Z
    //   134: istore 5
    //   136: iload 5
    //   138: ifeq +133 -> 271
    //   141: aload 7
    //   143: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   146: aload 6
    //   148: invokevirtual 137	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   151: iconst_0
    //   152: invokestatic 141	com/tencent/mobileqq/utils/FileUtils:uncompressZip	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   155: aload 6
    //   157: invokevirtual 145	java/io/File:listFiles	()[Ljava/io/File;
    //   160: astore_1
    //   161: aload_1
    //   162: ifnull +23 -> 185
    //   165: aload_1
    //   166: arraylength
    //   167: ifne +6 -> 173
    //   170: goto +15 -> 185
    //   173: aload_3
    //   174: aload 6
    //   176: invokeinterface 118 2 0
    //   181: pop
    //   182: aload_0
    //   183: monitorexit
    //   184: return
    //   185: new 51	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   192: astore_1
    //   193: aload_1
    //   194: ldc 147
    //   196: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_1
    //   201: aload_2
    //   202: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: ldc 149
    //   209: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: aload 7
    //   216: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_1
    //   221: ldc 154
    //   223: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_1
    //   228: iload 4
    //   230: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: ldc 88
    //   236: iconst_2
    //   237: aload_1
    //   238: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto +148 -> 392
    //   247: astore_1
    //   248: goto +21 -> 269
    //   251: astore_1
    //   252: ldc 88
    //   254: iconst_1
    //   255: aload_1
    //   256: checkcast 159	java/lang/Throwable
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   266: goto +126 -> 392
    //   269: aload_1
    //   270: athrow
    //   271: new 51	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   278: astore_1
    //   279: aload_1
    //   280: ldc 164
    //   282: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: aload_2
    //   288: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_1
    //   293: ldc 149
    //   295: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_1
    //   300: aload 7
    //   302: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_1
    //   307: ldc 154
    //   309: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_1
    //   314: iload 4
    //   316: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 88
    //   322: iconst_2
    //   323: aload_1
    //   324: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto +62 -> 392
    //   333: new 51	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   340: astore_1
    //   341: aload_1
    //   342: ldc 166
    //   344: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_1
    //   349: aload_2
    //   350: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload_1
    //   355: ldc 149
    //   357: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_1
    //   362: aload 7
    //   364: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_1
    //   369: ldc 154
    //   371: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload_1
    //   376: iload 4
    //   378: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 88
    //   384: iconst_1
    //   385: aload_1
    //   386: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 94	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload_3
    //   393: aload 6
    //   395: invokeinterface 118 2 0
    //   400: pop
    //   401: getstatic 172	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   404: astore_1
    //   405: aload_0
    //   406: monitorexit
    //   407: return
    //   408: astore_1
    //   409: aload_0
    //   410: monitorexit
    //   411: aload_1
    //   412: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	TroopGiftResManager
    //   0	413	1	paramContext	Context
    //   0	413	2	paramString	String
    //   0	413	3	paramFunction1	Function1<? super File, Unit>
    //   122	255	4	i	int
    //   134	3	5	bool	boolean
    //   53	341	6	localFile1	File
    //   95	268	7	localFile2	File
    //   107	9	8	localDownloadTask	com.tencent.mobileqq.vip.DownloadTask
    // Exception table:
    //   from	to	target	type
    //   141	161	247	finally
    //   165	170	247	finally
    //   173	182	247	finally
    //   185	244	247	finally
    //   252	266	247	finally
    //   141	161	251	java/lang/Exception
    //   165	170	251	java/lang/Exception
    //   173	182	251	java/lang/Exception
    //   185	244	251	java/lang/Exception
    //   2	43	408	finally
    //   46	68	408	finally
    //   68	85	408	finally
    //   88	124	408	finally
    //   129	136	408	finally
    //   269	271	408	finally
    //   271	330	408	finally
    //   333	392	408	finally
    //   392	405	408	finally
  }
  
  private final File b(String paramString)
  {
    return new File(b, MD5Utils.toMD5(paramString));
  }
  
  private final boolean c(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      return StringsKt.startsWith$default(paramString, "http", false, 2, null);
    }
    return false;
  }
  
  @NotNull
  public final File a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MD5Utils.toMD5(paramString));
    localStringBuilder.append(".zip");
    return new File(str, localStringBuilder.toString());
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
      if (!a.c(str)) {
        return false;
      }
      if (!a.b(str).exists()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  @NotNull
  public final File[] b(@NotNull String[] paramArrayOfString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftResManager
 * JD-Core Version:    0.7.0.1
 */