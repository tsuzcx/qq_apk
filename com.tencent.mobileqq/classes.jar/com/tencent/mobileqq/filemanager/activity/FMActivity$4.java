package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

class FMActivity$4
  implements VerifyPwdView.VerifyPswEvent
{
  FMActivity$4(FMActivity paramFMActivity, int paramInt) {}
  
  public void a()
  {
    this.b.e();
    if (this.b.q()) {
      this.b.a.setVisibility(0);
    }
    this.b.am.setVisibility(8);
    this.b.V.removeAllViews();
    this.b.V.addView(this.b.G);
    this.b.b.setTabType(this.a);
    this.b.G.d();
    this.b.G.setTabTitleList(new String[] { this.b.getString(2131889602), this.b.getString(2131889610), this.b.getString(2131889612), this.b.getString(2131889607), this.b.getString(2131889609) });
    this.b.G.a(16, this.b.getString(2131889602));
    this.b.G.a(15, this.b.getString(2131889610));
    this.b.G.a(17, this.b.getString(2131889612));
    this.b.G.a(18, this.b.getString(2131889607));
    this.b.G.a(19, this.b.getString(2131889609));
    if ((this.b.Y) && (this.b.h == 2) && (this.b.aa >= 15) && (this.b.aa <= 19)) {
      this.b.G.setSelectedTab(this.b.aa);
    } else {
      this.b.G.setSelectedTab(16);
    }
    if (this.b.W != null)
    {
      this.b.W.a();
      this.b.W = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.4
 * JD-Core Version:    0.7.0.1
 */