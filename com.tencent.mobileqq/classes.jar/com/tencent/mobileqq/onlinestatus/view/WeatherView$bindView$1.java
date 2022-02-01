package com.tencent.mobileqq.onlinestatus.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WeatherView$bindView$1
  implements View.OnClickListener
{
  WeatherView$bindView$1(WeatherView paramWeatherView) {}
  
  public final void onClick(View paramView)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.makeText((Context)this.a.c(), 1, 2131916775, 0).show();
      this.a.n.a(1030);
    }
    else
    {
      Object localObject = WeatherView.a(this.a).getRuntimeService(IOnlineStatusManagerService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "app.getRuntimeService(IO…va, ProcessConstant.MAIN)");
      localObject = ((IOnlineStatusManagerService)localObject).getManager(IOnlineStatusDataManager.class);
      if (localObject == null) {
        break label259;
      }
      localObject = (OnlineStatusDataManager)localObject;
      Intent localIntent = new Intent();
      if (WeatherView.b(this.a) != null) {
        localIntent.putExtra("online_status_permission_item", (Serializable)WeatherView.b(this.a));
      }
      localIntent.putExtra("from_modify", WeatherView.c(this.a) ^ true);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("needSwitchOnlineStatus: ");
        localStringBuilder.append(WeatherView.c(this.a));
        QLog.d("WeatherView", 2, new Object[] { "bindView: called. ", localStringBuilder.toString() });
      }
      ((OnlineStatusDataManager)localObject).b(8, localIntent);
    }
    this.a.n.a(1030);
    this.a.dismiss();
    ReportHelperKt.a("0X800AF48", 0, null, null, 14, null);
    ReportHelperKt.a("0X8009DE0", 1030, null, null, 12, null);
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label259:
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.WeatherView.bindView.1
 * JD-Core Version:    0.7.0.1
 */