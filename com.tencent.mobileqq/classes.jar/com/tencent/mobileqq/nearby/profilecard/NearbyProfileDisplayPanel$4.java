package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.statistics.ReportTask;

class NearbyProfileDisplayPanel$4
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$4(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a)
    {
      NearbyProfileDisplayPanel.a(this.d, 1);
      new ReportTask(this.d.e.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_dislike").e(this.d.e.allinone.uin).a();
    }
    else if (paramView == this.b)
    {
      NearbyProfileDisplayPanel.a(this.d, 2);
      new ReportTask(this.d.e.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_superlike").e(this.d.e.allinone.uin).a();
    }
    else if (paramView == this.c)
    {
      NearbyProfileDisplayPanel.a(this.d, 3);
      new ReportTask(this.d.e.app).a("dc00899").b("grp_lbs").c("data_card").d("clk_face_like").e(this.d.e.allinone.uin).a();
    }
    NearbyProfileDisplayPanel.b(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.4
 * JD-Core Version:    0.7.0.1
 */