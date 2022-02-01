package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.statistics.ReportTask;

class NearbyProfileDisplayTribePanel$2
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$2(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a)
    {
      NearbyProfileDisplayTribePanel.a(this.d, 1);
      new ReportTask(this.d.e.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.d.e.allinone.uin).a();
    }
    else if (paramView == this.b)
    {
      NearbyProfileDisplayTribePanel.a(this.d, 2);
      new ReportTask(this.d.e.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.d.e.allinone.uin).a();
    }
    else if (paramView == this.c)
    {
      NearbyProfileDisplayTribePanel.a(this.d, 3);
      new ReportTask(this.d.e.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.d.e.allinone.uin).a();
    }
    NearbyProfileDisplayTribePanel.b(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.2
 * JD-Core Version:    0.7.0.1
 */