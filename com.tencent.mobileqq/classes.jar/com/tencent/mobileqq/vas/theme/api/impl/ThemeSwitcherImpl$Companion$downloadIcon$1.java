package com.tencent.mobileqq.vas.theme.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/vas/theme/api/impl/ThemeSwitcherImpl$Companion$downloadIcon$1", "Lcom/tencent/mobileqq/vip/DownloadListener;", "onDone", "", "task", "Lcom/tencent/mobileqq/vip/DownloadTask;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ThemeSwitcherImpl$Companion$downloadIcon$1
  extends DownloadListener
{
  ThemeSwitcherImpl$Companion$downloadIcon$1(String paramString1, String paramString2, boolean paramBoolean, File paramFile) {}
  
  public void onDone(@NotNull DownloadTask paramDownloadTask)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadTask, "task");
    if (paramDownloadTask.a() != 3) {
      QLog.d("ThemeSwitcher", 1, "downloadExtraTabIcon Failed zip not Exist!");
    }
    FileUtils.uncompressZip(this.jdField_a_of_type_JavaLangString, this.b, false);
    paramDownloadTask = ThemeUtil.getCreateAppRuntime();
    if ((this.jdField_a_of_type_JavaIoFile.exists()) && (paramDownloadTask != null) && (this.jdField_a_of_type_Boolean))
    {
      Intent localIntent = new Intent("com.tencent.qplus.THEME_UPDATE");
      paramDownloadTask.getApplicationContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      QLog.d("ThemeSwitcher", 1, "downloadExtraTabIcon:success!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.impl.ThemeSwitcherImpl.Companion.downloadIcon.1
 * JD-Core Version:    0.7.0.1
 */