package com.tencent.mobileqq.conditionsearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$5
  implements DialogInterface.OnDismissListener
{
  ConditionSearchFriendActivity$5(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("onDismiss|pickerType : ");
      paramDialogInterface.append(this.a.P);
      QLog.d("ConditionSearchFriendActivity", 2, paramDialogInterface.toString());
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.a.P == 0)
    {
      this.a.l.setRightTextColor(2);
      this.a.a.a(this.a.d, this.a.e);
      paramDialogInterface = this.a.a.b(this.a.d, this.a.e);
      if (AppSetting.e)
      {
        localObject = this.a.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131900531));
        localStringBuilder.append(paramDialogInterface);
        ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
        localObject = this.a.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131900534));
        localStringBuilder.append(paramDialogInterface);
        AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
      }
      if (QLog.isColorLevel())
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("onDismiss|mCurAgeIndex1 : ");
        paramDialogInterface.append(this.a.h);
        paramDialogInterface.append(", mCurAgeIndex2 : ");
        paramDialogInterface.append(this.a.i);
        paramDialogInterface.append(", mAgeSelectIndex1 : ");
        paramDialogInterface.append(this.a.d);
        paramDialogInterface.append(", mAgeSelectIndex2 : ");
        paramDialogInterface.append(this.a.e);
        QLog.d("ConditionSearchFriendActivity", 2, paramDialogInterface.toString());
      }
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.d);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.e);
      localStringBuilder.append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8004243", "0X8004243", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
    }
    else if (this.a.P == 3)
    {
      this.a.p.setRightTextColor(2);
      this.a.a.c(this.a.f);
      if (AppSetting.e)
      {
        paramDialogInterface = this.a.p;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131900533));
        ((StringBuilder)localObject).append(ConditionSearchManager.k[this.a.f]);
        paramDialogInterface.setContentDescription(((StringBuilder)localObject).toString());
        paramDialogInterface = this.a.p;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131900544));
        ((StringBuilder)localObject).append(ConditionSearchManager.k[this.a.f]);
        AccessibilityUtils.a(paramDialogInterface, ((StringBuilder)localObject).toString());
      }
      paramDialogInterface = this.a.app;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.f);
      ((StringBuilder)localObject).append("");
      ReportController.b(paramDialogInterface, "CliOper", "", "", "0X8006F0B", "0X8006F0B", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    else
    {
      paramDialogInterface = this.a;
      paramDialogInterface.u = null;
      paramDialogInterface = ConditionSearchFriendActivity.b(paramDialogInterface);
      localObject = new String[4];
      localObject[0] = this.a.D;
      localObject[1] = this.a.J[0];
      localObject[2] = this.a.J[1];
      localObject[3] = this.a.J[2];
      if (this.a.P == 1)
      {
        this.a.m.setRightTextColor(2);
        this.a.a.a(0, paramDialogInterface);
        this.a.a.b((String[])localObject);
        if (AppSetting.e)
        {
          localObject = this.a.m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131900530));
          localStringBuilder.append(paramDialogInterface);
          ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
          localObject = this.a.m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131900529));
          localStringBuilder.append(paramDialogInterface);
          AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
        }
      }
      else if (this.a.P == 2)
      {
        this.a.n.setRightTextColor(2);
        this.a.a.a(1, paramDialogInterface);
        this.a.a.c((String[])localObject);
        if (AppSetting.e)
        {
          localObject = this.a.n;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131900540));
          localStringBuilder.append(paramDialogInterface);
          ((FormSimpleItem)localObject).setContentDescription(localStringBuilder.toString());
          localObject = this.a.n;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131900541));
          localStringBuilder.append(paramDialogInterface);
          AccessibilityUtils.a((View)localObject, localStringBuilder.toString());
        }
      }
    }
    paramDialogInterface = this.a;
    paramDialogInterface.O = null;
    if (ConditionSearchFriendActivity.c(paramDialogInterface) > 0)
    {
      this.a.z.scrollBy(0, -ConditionSearchFriendActivity.c(this.a));
      ConditionSearchFriendActivity.c(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */