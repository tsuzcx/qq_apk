package com.tencent.mobileqq.vas.theme.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureProcessor;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateCallback;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher.DownloadListenser;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.StringBuilderUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl$Companion;", "", "()V", "downloadExtraTabIcon", "", "scid", "", "needSwitch", "downloadIcon", "url", "extraZipPath", "unzipPath", "unzipDir", "Ljava/io/File;", "onComplete", "", "errorCode", "", "searchNameByFile", "name", "file", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThemeSwitcherImpl$Companion
{
  @JvmStatic
  private final boolean a(String paramString1, String paramString2, String paramString3, File paramFile, boolean paramBoolean)
  {
    DownloaderInterface localDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(4);
    if (localDownloaderInterface == null)
    {
      QLog.e("ThemeSwitcher", 1, "downloadExtraTabIcon downloader == null");
      return true;
    }
    localDownloaderInterface.startDownload(new DownloadTask(paramString1, new File(paramString2)), (DownloadListener)new ThemeSwitcherImpl.Companion.downloadIcon.1(paramString2, paramString3, paramBoolean, paramFile), null);
    return false;
  }
  
  @JvmStatic
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "scid");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onComplete: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(',');
    ((StringBuilder)localObject1).append(paramInt);
    QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = (String)null;
    localObject1 = localObject2;
    if (paramInt == 0)
    {
      String str = ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX;
      Intrinsics.checkExpressionValueIsNotNull(str, "ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX");
      localObject1 = localObject2;
      if (StringsKt.startsWith$default(paramString, str, false, 2, null))
      {
        localObject2 = ThemeSwitcher.a(paramString, false);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          VasMonitorDT.a("individual_v2_theme_setup_err", "unzip_fail");
          localObject1 = localObject2;
        }
        else if (!QQTheme.a(ThemeUtil.getIDFromSCID(paramString)))
        {
          localObject1 = localObject2;
          if (!Intrinsics.areEqual("999", ThemeUtil.getIDFromSCID(paramString))) {}
        }
        else
        {
          ((Companion)this).a(paramString, ThemeSwitcher.a());
          localObject1 = localObject2;
        }
      }
    }
    if (ThemeSwitcher.a())
    {
      localObject2 = ThemeSwitcher.jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher;
      if (localObject2 != null)
      {
        localObject2 = ((ThemeSwitcher)localObject2).jdField_a_of_type_ComTencentMobileqqVasThemeThemeSwitcher$DownloadListenser;
        if (localObject2 != null) {
          ((ThemeSwitcher.DownloadListenser)localObject2).a(paramString, (String)localObject1, paramInt);
        }
      }
    }
    else if (paramInt == 0)
    {
      localObject1 = ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ThemeUpdateCallback.SCID_THEME_ZIP_PREFIX");
      if (StringsKt.startsWith$default(paramString, (String)localObject1, false, 2, null))
      {
        paramString = ThemeUtil.getIDFromSCID(paramString);
        localObject1 = ThemeUtil.getCurrentThemeId();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("theme update: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" engineId: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.e("ThemeSwitcher", 1, ((StringBuilder)localObject2).toString());
        if ((!TextUtils.isEmpty((CharSequence)paramString)) && (Intrinsics.areEqual(paramString, localObject1))) {
          ThemeSwitcher.a(paramString, "208", null);
        }
        ThemeReporter.a(null, "theme_detail", "208", 153, 1, 35, paramString, "20000000", ThemeReporter.a, "");
      }
    }
  }
  
  @JvmStatic
  public final boolean a(@NotNull String paramString, @NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        Intrinsics.checkExpressionValueIsNotNull(localObject, "f");
        boolean bool;
        if (localObject.isDirectory()) {
          bool = ((Companion)this).a(paramString, localObject);
        } else if ((localObject.isFile()) && (Intrinsics.areEqual(localObject.getName(), paramString))) {
          bool = true;
        } else {
          bool = false;
        }
        if (bool) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  @JvmStatic
  public final boolean a(@Nullable String paramString, boolean paramBoolean)
  {
    if (!QVipFeatureProcessor.a().enableDownloadExtraTabIcon)
    {
      QLog.e("ThemeSwitcher", 1, "downloadExtraTabIcon: config off");
      return false;
    }
    Object localObject1 = MobileQQ.getContext();
    String str = ThemeUtil.getIDFromSCID(paramString);
    ThemeLocator localThemeLocator = new ThemeLocator().a(str);
    Object localObject2 = (Context)localObject1;
    localThemeLocator = localThemeLocator.a((Context)localObject2, paramString, "");
    Intrinsics.checkExpressionValueIsNotNull(localThemeLocator, "locator");
    Object localObject3 = FileUtils.encryptFile(localThemeLocator.c(), "MD5");
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      QLog.e("ThemeSwitcher", 1, "downloadExtraTabIcon: fail to get md5");
      return false;
    }
    localThemeLocator.a((Context)localObject2, paramString, (String)localObject3);
    paramString = localThemeLocator.d();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downloadExtraTabIcon to ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d("ThemeSwitcher", 1, ((StringBuilder)localObject2).toString());
    try
    {
      localObject2 = new File(paramString);
      if (!((File)localObject2).exists())
      {
        QLog.e("ThemeSwitcher", 1, "downloadExtraTabIcon:path not exists");
        return false;
      }
      if (((Companion)this).a("skin_tab_icon_1.png", (File)localObject2))
      {
        QLog.d("ThemeSwitcher", 1, "downloadExtraTabIcon: extra icon already exist");
        return false;
      }
      localObject3 = (Map)new HashMap();
      Intrinsics.checkExpressionValueIsNotNull(str, "themeId");
      ((Map)localObject3).put("[id]", str);
      localObject3 = IndividuationUrlHelper.a("themepatch", (Map)localObject3);
      if (localObject3 == null)
      {
        QLog.d("ThemeSwitcher", 1, "downloadExtraTabIcon: url is null");
        return false;
      }
      StringBuilder localStringBuilder = StringBuilderUtils.a();
      localStringBuilder.append(localThemeLocator.a((Context)localObject1));
      localStringBuilder.append(str);
      localStringBuilder.append(".zip");
      localObject1 = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilderUtils.obtai…              .toString()");
      paramBoolean = ((Companion)this).a((String)localObject3, (String)localObject1, paramString, (File)localObject2, paramBoolean);
      return paramBoolean;
    }
    catch (Exception paramString)
    {
      QLog.e("ThemeSwitcher", 1, "downloadExtraTabIcon failed", (Throwable)paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl.Companion
 * JD-Core Version:    0.7.0.1
 */