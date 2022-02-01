package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.FirstLoadDataCallback;
import com.tencent.mobileqq.statistics.ReportTask;

class NearbyProfileDisplayPanel$3
  implements NearbyMomentFragment.FirstLoadDataCallback
{
  NearbyProfileDisplayPanel$3(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, int paramInt) {}
  
  public void a(int paramInt)
  {
    if (this.a == -1) {
      if (paramInt > 0)
      {
        localObject1 = this.b;
        ((NearbyProfileDisplayPanel)localObject1).a(((NearbyProfileDisplayPanel)localObject1).ab, false);
      }
      else
      {
        localObject1 = this.b;
        ((NearbyProfileDisplayPanel)localObject1).a(((NearbyProfileDisplayPanel)localObject1).ac, false);
      }
    }
    this.b.L.a(null);
    int i = this.b.v();
    Object localObject1 = "1";
    Object localObject2;
    if (i == 0)
    {
      localObject2 = new ReportTask(this.b.e.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
      if (this.b.e.mMode != 2) {
        localObject1 = "2";
      }
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
    }
    ReportTask localReportTask = new ReportTask(this.b.e.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp");
    if (this.b.e.mMode == 2) {
      localObject2 = "1";
    } else {
      localObject2 = "2";
    }
    if (paramInt != 0) {
      localObject1 = "2";
    }
    localReportTask.a(new String[] { localObject2, localObject1 }).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.3
 * JD-Core Version:    0.7.0.1
 */