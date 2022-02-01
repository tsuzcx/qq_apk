package com.tencent.mobileqq.location.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ISlidePanelListener;
import com.tencent.qphone.base.util.QLog;

class LocationPickFragment$11
  implements ISlidePanelListener
{
  LocationPickFragment$11(LocationPickFragment paramLocationPickFragment, View paramView1, View paramView2, View paramView3, ImageView paramImageView, View paramView4) {}
  
  public void cancelAnimator() {}
  
  public void displayPanel() {}
  
  public void displayPanelFinish()
  {
    if (LocationPickFragment.f(this.f) != null) {
      LocationPickFragment.f(this.f).setEnabled(false);
    }
    ReportController.b(null, "CliOper", "", "", "0X800A95F", "0X800A95F", LocationPickFragment.d(this.f).getDisplayFromType(), 0, "", "0", "0", "");
    this.b.setVisibility(8);
    this.c.setContentDescription(this.f.getString(2131891395));
    if ((this.d != null) && (LocationPickFragment.d(this.f).h())) {
      this.d.setImageResource(2130851763);
    }
  }
  
  public void fadeBackground(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[panel] fadeBackground: invoked. alpha: ");
      localStringBuilder.append(paramFloat);
      QLog.d("LocationPickFragment", 2, localStringBuilder.toString());
    }
    this.a.setBackgroundColor(Color.argb(Math.round(paramFloat * 0.7F * 255.0F), 0, 0, 0));
  }
  
  public void hidePanel()
  {
    LocationPickFragment.e(this.f);
  }
  
  public void hidePanelFinish()
  {
    if (LocationPickFragment.f(this.f) != null) {
      LocationPickFragment.f(this.f).setEnabled(true);
    }
    LocationPickFragment.d(this.f).setDisplayFromType(2);
    this.e.requestFocus();
    this.b.setVisibility(0);
    this.c.setContentDescription(this.f.getString(2131891393));
    if ((this.d != null) && (!LocationPickFragment.d(this.f).h())) {
      this.d.setImageResource(2130851762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.11
 * JD-Core Version:    0.7.0.1
 */