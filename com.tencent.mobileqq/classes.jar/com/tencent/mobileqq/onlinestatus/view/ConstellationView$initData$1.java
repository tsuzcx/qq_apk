package com.tencent.mobileqq.onlinestatus.view;

import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.constellation.StatusExtInfoObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/ConstellationView$initData$1", "Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "onGetConstellationTrend", "", "success", "", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ConstellationView$initData$1
  extends StatusExtInfoObserver
{
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationView", 2, new Object[] { "onGetConstellationTrend: called. ", "bundle: " + paramBundle });
    }
    ConstellationView localConstellationView = this.a;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_today_constellation_trend");
      if (paramBundle == null) {}
    }
    for (;;)
    {
      ConstellationView.a(localConstellationView, paramBundle);
      this.a.a();
      return;
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.ConstellationView.initData.1
 * JD-Core Version:    0.7.0.1
 */