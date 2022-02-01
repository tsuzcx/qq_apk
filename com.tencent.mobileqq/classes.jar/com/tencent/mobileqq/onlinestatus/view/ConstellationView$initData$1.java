package com.tencent.mobileqq.onlinestatus.view;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/ConstellationView$initData$1", "Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "onGetConstellationTrend", "", "success", "", "bundle", "Landroid/os/Bundle;", "qqonlinestatus-impl_release"}, k=1, mv={1, 1, 16})
public final class ConstellationView$initData$1
  extends StatusExtInfoObserver
{
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bundle: ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("ConstellationView", 2, new Object[] { "onGetConstellationTrend: called. ", ((StringBuilder)localObject).toString() });
    }
    Object localObject = this.a;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_today_constellation_trend");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    ConstellationView.a((ConstellationView)localObject, paramBundle);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView.initData.1
 * JD-Core Version:    0.7.0.1
 */