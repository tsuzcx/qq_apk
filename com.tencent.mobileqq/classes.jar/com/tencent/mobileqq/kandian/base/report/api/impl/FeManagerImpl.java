package com.tencent.mobileqq.kandian.base.report.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.report.api.IFeManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/report/api/impl/FeManagerImpl;", "Lcom/tencent/mobileqq/kandian/base/report/api/IFeManager;", "()V", "isForceReport", "", "app", "Lmqq/app/AppRuntime;", "updateForceReport", "", "force", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FeManagerImpl
  implements IFeManager
{
  public static final FeManagerImpl.Companion Companion = new FeManagerImpl.Companion(null);
  private static final String READINJOY_FORCE_UPDATE_ONCE = "simple_force_report_once";
  private boolean isForceReport;
  
  public FeManagerImpl()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication().runtime");
    if (isForceReport((AppRuntime)localObject))
    {
      this.isForceReport = true;
      localObject = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
      updateForceReport(((BaseApplicationImpl)localObject).getRuntime(), false);
    }
  }
  
  private final boolean isForceReport(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime != null) {
      return paramAppRuntime.getBoolean("simple_force_report_once", false);
    }
    return false;
  }
  
  public boolean isForceReport()
  {
    return this.isForceReport;
  }
  
  public void updateForceReport(@Nullable AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = RIJSPUtils.a(paramAppRuntime, true, true);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
      RIJSPUtils.a(paramAppRuntime, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.api.impl.FeManagerImpl
 * JD-Core Version:    0.7.0.1
 */