package com.tencent.mobileqq.mini.api.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.mini.config.FileMaterialConfig;
import com.tencent.mobileqq.mini.config.FileMaterialConfigProcessor;
import com.tencent.mobileqq.mini.config.FileMaterialConfigProcessor.Companion;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/api/impl/MiniAppFileMaterialServiceImpl;", "Lcom/tencent/mobileqq/mini/api/IMiniAppFileMaterialService;", "()V", "checkEntranceEnabledState", "", "getFileMimeTypeImpl", "", "filePath", "isFileSupported", "isMimeTypeSupported", "mimeType", "isMimeTypeSupportedImpl", "reportMenuItemClickedOrExposed", "", "isClick", "showAppListDialog", "activity", "Landroid/app/Activity;", "showSupportedAppList", "Companion", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniAppFileMaterialServiceImpl
  implements IMiniAppFileMaterialService
{
  public static final MiniAppFileMaterialServiceImpl.Companion Companion = new MiniAppFileMaterialServiceImpl.Companion(null);
  private static final String EXP_KEY_ENTRANCE = "is_entrance_enabled";
  private static final String EXP_VALUE_ENTRANCE_ENABLED = "1";
  private static final String SP_KEY_ENTRANCE_ENABLED = "is_file_material_entrance_enabled";
  private static final String TAG = "MiniAppFileMaterialServiceImpl";
  
  private final boolean checkEntranceEnabledState()
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_qq_miniapp_progame_aiofile");
    Intrinsics.checkExpressionValueIsNotNull(localExpEntityInfo, "ABTestController.getInst…EXP_QQ_MINI_APP_AIO_FILE)");
    localExpEntityInfo.h();
    if (localExpEntityInfo.a().containsKey("is_entrance_enabled"))
    {
      boolean bool = Intrinsics.areEqual((String)localExpEntityInfo.a().get("is_entrance_enabled"), "1");
      StorageUtil.getPreference().edit().putBoolean("is_file_material_entrance_enabled", bool).apply();
      return bool;
    }
    return StorageUtil.getPreference().getBoolean("is_file_material_entrance_enabled", false);
  }
  
  private final String getFileMimeTypeImpl(String paramString)
  {
    FileMaterialConfig localFileMaterialConfig = FileMaterialConfigProcessor.Companion.getConfig();
    if (localFileMaterialConfig != null) {
      return localFileMaterialConfig.getFileMimeType(paramString);
    }
    return null;
  }
  
  private final boolean isMimeTypeSupportedImpl(String paramString)
  {
    FileMaterialConfig localFileMaterialConfig = FileMaterialConfigProcessor.Companion.getConfig();
    if (localFileMaterialConfig != null) {
      return localFileMaterialConfig.isMimeTypeSupported(paramString);
    }
    return false;
  }
  
  private final void reportMenuItemClickedOrExposed(String paramString, boolean paramBoolean)
  {
    ExpEntityInfo localExpEntityInfo = ABTestController.a().a("exp_qq_miniapp_progame_aiofile");
    Intrinsics.checkExpressionValueIsNotNull(localExpEntityInfo, "ABTestController.getInst…EXP_QQ_MINI_APP_AIO_FILE)");
    String str;
    if (paramBoolean) {
      str = "click";
    } else {
      str = "expo";
    }
    MiniProgramLpReportDC04239.reportAsync("aio_file", "miniprogram_open", str, paramString, localExpEntityInfo.e(), "");
  }
  
  private final void showAppListDialog(Activity paramActivity, String paramString1, String paramString2)
  {
    CharSequence localCharSequence = (CharSequence)paramString1;
    int j = 0;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      QLog.e("MiniAppFileMaterialServiceImpl", 1, "showAppListDialog: filePath is empty");
      return;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      QLog.e("MiniAppFileMaterialServiceImpl", 1, "showAppListDialog: file not exist");
      return;
    }
    localCharSequence = (CharSequence)paramString2;
    if (localCharSequence != null)
    {
      i = j;
      if (localCharSequence.length() != 0) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      QLog.e("MiniAppFileMaterialServiceImpl", 1, "showAppListDialog: unknown mimeType");
      return;
    }
    reportMenuItemClickedOrExposed(paramString2, true);
    new FileMaterialAppListDialog(paramActivity, paramString1, paramString2).show();
  }
  
  public boolean isFileSupported(@Nullable String paramString)
  {
    paramString = getFileMimeTypeImpl(paramString);
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    return isMimeTypeSupported(paramString);
  }
  
  public boolean isMimeTypeSupported(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "mimeType");
    boolean bool1 = isMimeTypeSupportedImpl(paramString);
    boolean bool2 = checkEntranceEnabledState();
    if ((bool1) && (bool2)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {
      reportMenuItemClickedOrExposed(paramString, false);
    }
    return bool1;
  }
  
  public void showSupportedAppList(@NotNull Activity paramActivity, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject = (CharSequence)paramString;
    int j = 0;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    localObject = getFileMimeTypeImpl(paramString);
    CharSequence localCharSequence = (CharSequence)localObject;
    if (localCharSequence != null)
    {
      i = j;
      if (localCharSequence.length() != 0) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    showAppListDialog(paramActivity, paramString, (String)localObject);
  }
  
  public void showSupportedAppList(@NotNull Activity paramActivity, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString2, "mimeType");
    showAppListDialog(paramActivity, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppFileMaterialServiceImpl
 * JD-Core Version:    0.7.0.1
 */