package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SignTextEditFragment$11
  implements CompoundButton.OnCheckedChangeListener
{
  SignTextEditFragment$11(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.a.getBaseActivity() != null)
    {
      if ((NetworkUtil.isNetSupport(this.a.getBaseActivity())) && (SignTextEditFragment.c(this.a) != null))
      {
        if (AppSetting.e) {
          this.a.m.setContentDescription(HardCodeUtil.a(2131905741));
        }
        SignTextEditFragment.c(this.a).c(paramBoolean);
      }
      else
      {
        Object localObject = this.a.getBaseActivity();
        int i;
        if (SignTextEditFragment.c(this.a) != null) {
          i = 2131892155;
        } else {
          i = 2131916364;
        }
        QQToast.makeText((Context)localObject, i, 1).show();
        localObject = this.a;
        SignTextEditFragment.a((SignTextEditFragment)localObject, ((SignTextEditFragment)localObject).m, paramBoolean ^ true);
      }
      ReportController.b(this.a.r, "dc00898", "", "", "0X800A97B", "0X800A97B", 0, 0, "0", "0", "", "");
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.11
 * JD-Core Version:    0.7.0.1
 */