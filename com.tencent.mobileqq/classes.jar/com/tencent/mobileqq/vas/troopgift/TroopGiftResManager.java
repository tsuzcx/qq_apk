package com.tencent.mobileqq.vas.troopgift;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
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
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".troopgift/");
  }
  
  private final File a(String paramString)
  {
    return new File(jdField_a_of_type_JavaLangString, MD5Utils.toMD5(paramString) + ".zip");
  }
  
  private final void a(Context paramContext, String paramString, Function1<? super File, Unit> paramFunction1)
  {
    try
    {
      if (!jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.a(paramString)) {
        throw ((Throwable)new RuntimeException("url not valid : " + paramString));
      }
    }
    finally {}
    File localFile2 = jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.b(paramString);
    if (!localFile2.isDirectory()) {
      FileUtils.a(localFile2);
    }
    if (localFile2.exists())
    {
      paramFunction1.invoke(localFile2);
      return;
    }
    File localFile1 = jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.a(paramString);
    DownloadTask localDownloadTask = new DownloadTask(paramString, localFile1);
    localDownloadTask.h = true;
    int i = DownloaderFactory.a(localDownloadTask, null, paramContext);
    if (i == 0)
    {
      boolean bool = localFile1.exists();
      if (!bool) {}
    }
    for (;;)
    {
      try
      {
        FileUtils.a(localFile1.getAbsolutePath(), localFile2.getAbsolutePath(), false);
        paramContext = localFile2.listFiles();
        if ((paramContext != null) && (paramContext.length != 0)) {
          continue;
        }
        QLog.e("TroopGiftResManager", 2, "unzip error, url=" + paramString + ", path=" + localFile1 + ", ret:" + i);
      }
      catch (Exception paramContext)
      {
        QLog.e("TroopGiftResManager", 1, (Throwable)paramContext, new Object[0]);
        FileUtils.a(localFile1);
        continue;
      }
      finally
      {
        FileUtils.a(localFile1);
      }
      paramFunction1.invoke(localFile2);
      paramContext = Unit.INSTANCE;
      return;
      paramFunction1.invoke(localFile2);
      FileUtils.a(localFile1);
      return;
      QLog.e("TroopGiftResManager", 2, "downloadImage file not exists, url=" + paramString + ", path=" + localFile1 + ", ret:" + i);
      continue;
      QLog.e("TroopGiftResManager", 1, "downloadImage Error url=" + paramString + ", path=" + localFile1 + ", ret:" + i);
    }
  }
  
  private final boolean a(String paramString)
  {
    return (!TextUtils.isEmpty((CharSequence)paramString)) && (StringsKt.startsWith$default(paramString, "http", false, 2, null));
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
      if (!jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.a(str)) {}
      while (!jdField_a_of_type_ComTencentMobileqqVasTroopgiftTroopGiftResManager.b(str).exists()) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftResManager
 * JD-Core Version:    0.7.0.1
 */