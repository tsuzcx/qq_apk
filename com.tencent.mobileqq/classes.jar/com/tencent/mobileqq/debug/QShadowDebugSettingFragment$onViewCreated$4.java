package com.tencent.mobileqq.debug;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k=3, mv={1, 1, 16})
final class QShadowDebugSettingFragment$onViewCreated$4
  implements CompoundButton.OnCheckedChangeListener
{
  QShadowDebugSettingFragment$onViewCreated$4(QShadowDebugSettingFragment paramQShadowDebugSettingFragment) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    PluginUpdater.a(paramBoolean, (Context)this.a.getActivity());
    if (!paramBoolean)
    {
      Object localObject = BaseApplicationImpl.sApplication;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.sApplication");
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((AppRuntime)localObject).getManager(QQManagerFactory.MGR_PLUGIN);
        if (localObject != null) {
          ((IPluginManager)localObject).b();
        } else {
          throw new TypeCastException("null cannot be cast to non-null type cooperation.plugin.IPluginManager");
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.QShadowDebugSettingFragment.onViewCreated.4
 * JD-Core Version:    0.7.0.1
 */