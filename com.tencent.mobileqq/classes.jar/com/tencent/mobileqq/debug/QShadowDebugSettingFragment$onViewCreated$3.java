package com.tencent.mobileqq.debug;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.R.id;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.plugin.PluginUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class QShadowDebugSettingFragment$onViewCreated$3
  implements View.OnClickListener
{
  QShadowDebugSettingFragment$onViewCreated$3(QShadowDebugSettingFragment paramQShadowDebugSettingFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject;
    if (!PluginUpdater.b((Context)this.a.getActivity()))
    {
      localObject = new QQToast((Context)this.a.getActivity());
      ((QQToast)localObject).setToastMsg((CharSequence)"请先打开自定义加载开关！");
      ((QQToast)localObject).show();
    }
    else
    {
      localObject = (EditText)this.a.a(R.id.pluginIdEditText);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "pluginIdEditText");
      int i = ((CharSequence)((EditText)localObject).getText().toString()).length();
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        localObject = (EditText)this.a.a(R.id.pluginBranchEditText);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "pluginBranchEditText");
        if (((CharSequence)((EditText)localObject).getText().toString()).length() == 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          QShadowDebugSettingFragment.b(this.a);
          break label210;
        }
      }
      localObject = new QQToast((Context)this.a.getActivity());
      ((QQToast)localObject).setToastMsg((CharSequence)"请先输入插件信息！");
      ((QQToast)localObject).show();
    }
    label210:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.debug.QShadowDebugSettingFragment.onViewCreated.3
 * JD-Core Version:    0.7.0.1
 */