package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FMActivity$3
  implements RadioGroup.OnCheckedChangeListener
{
  FMActivity$3(FMActivity paramFMActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (this.a.Q != null) {
      this.a.Q.setVisibility(8);
    }
    this.a.l();
    this.a.X.setVisibility(8);
    this.a.a.setVisibility(0);
    if (this.a.W != null)
    {
      this.a.V.removeAllViews();
      this.a.W.setVisibility(8);
      this.a.W.a();
      localObject = this.a;
      ((FMActivity)localObject).W = null;
      ((FMActivity)localObject).V.addView(this.a.G);
    }
    int j = -1;
    int i;
    if ((paramInt == 2131444379) && (this.a.N.isChecked()))
    {
      this.a.A().f();
      FMActivity.b(this.a);
      this.a.M.setSelected(false);
      this.a.O.setSelected(false);
      if (FMActivity.c(this.a)) {
        this.a.P.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 1);
      i = 0;
    }
    else if ((paramInt == 2131437672) && (this.a.M.isChecked()))
    {
      this.a.A().e();
      FMActivity.d(this.a);
      if ((this.a.ae == 0) && (this.a.l)) {
        this.a.X.setVisibility(0);
      }
      this.a.N.setSelected(false);
      this.a.O.setSelected(false);
      if (FMActivity.c(this.a)) {
        this.a.P.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 2);
      i = 1;
    }
    else if ((paramInt == 2131430857) && (this.a.O.isChecked()))
    {
      this.a.A().d();
      FMActivity.b(this.a, 2);
      this.a.M.setSelected(false);
      this.a.N.setSelected(false);
      if (FMActivity.c(this.a)) {
        this.a.P.setSelected(false);
      }
      this.a.i(false);
      FMActivity.a(this.a, 0);
      i = 2;
    }
    else
    {
      i = j;
      if (paramInt == 2131432804)
      {
        i = j;
        if (this.a.P.isChecked())
        {
          this.a.A().g();
          FMActivity.e(this.a);
          i = 1408041718;
          this.a.M.setSelected(false);
          this.a.N.setSelected(false);
          this.a.O.setSelected(false);
          this.a.i(false);
          FMActivity.a(this.a, 5);
          ReportController.b(this.a.p, "dc00898", "", "", "0X800AFA6", "0X800AFA6", 0, 0, "", "", "", "");
        }
      }
    }
    Object localObject = this.a.p.getApplicationContext().getSharedPreferences("aio_last_select_file", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("last_select_tab_type", i);
    ((SharedPreferences.Editor)localObject).commit();
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.3
 * JD-Core Version:    0.7.0.1
 */