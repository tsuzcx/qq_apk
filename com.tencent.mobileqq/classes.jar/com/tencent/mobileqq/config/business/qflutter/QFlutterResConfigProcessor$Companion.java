package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "TAG", "", "getConfig", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "isAlwaysPreload", "", "module", "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "preloadOptions", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfigProcessor$OptionList;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfigProcessor$Companion
{
  @JvmStatic
  @NotNull
  public final QFlutterResConfig a()
  {
    QFlutterResConfig localQFlutterResConfig = (QFlutterResConfig)QConfigManager.b().b(706);
    if (localQFlutterResConfig == null) {
      localQFlutterResConfig = new QFlutterResConfig();
    }
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject = ((LogUtils)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfig ");
      localStringBuilder.append(localQFlutterResConfig);
      ((ILog)localObject).a("QFlutterResConfigProcessor", 2, localStringBuilder.toString());
    }
    return localQFlutterResConfig;
  }
  
  @JvmStatic
  @NotNull
  public final QFlutterResConfigProcessor.OptionList a(@NotNull ExpandModuleKey paramExpandModuleKey)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandModuleKey, "module");
    return new QFlutterResConfigProcessor.OptionList(((Companion)this).a().a(paramExpandModuleKey));
  }
  
  @JvmStatic
  public final boolean b(@NotNull ExpandModuleKey paramExpandModuleKey)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandModuleKey, "module");
    return ((Companion)this).a().a(paramExpandModuleKey).contains(PreloadEngineOption.ALWAYS_PRELOAD.getDesc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */