package com.tencent.mobileqq.conditionsearch;

import android.content.res.Resources;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.List;

class ConditionSearchFriendActivity$4
  implements IphonePickerView.IphonePickListener
{
  ConditionSearchFriendActivity$4(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void onConfirmBtClicked()
  {
    if ((this.a.P == 0) && (this.a.h > this.a.i) && (this.a.i != 0))
    {
      ConditionSearchFriendActivity localConditionSearchFriendActivity = this.a;
      QQToast.makeText(localConditionSearchFriendActivity, localConditionSearchFriendActivity.getResources().getString(2131887990), 0).show(this.a.getTitleBarHeight());
      return;
    }
    if ((this.a.N != null) && (this.a.N.isShowing())) {
      this.a.N.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onItemSelected|pickerType : ");
      ((StringBuilder)localObject).append(this.a.P);
      ((StringBuilder)localObject).append(", column : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", row : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.P == 0)
    {
      int i;
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.j.length) {}
      }
      else
      {
        i = 0;
      }
      if (paramInt1 != 0)
      {
        if (paramInt1 == 1) {
          this.a.i = i;
        }
      }
      else {
        this.a.h = i;
      }
      if ((this.a.h <= this.a.i) || (this.a.i == 0))
      {
        localObject = this.a;
        ((ConditionSearchFriendActivity)localObject).d = ConditionSearchFriendActivity.b((ConditionSearchFriendActivity)localObject, ((ConditionSearchFriendActivity)localObject).h);
        localObject = this.a;
        ((ConditionSearchFriendActivity)localObject).e = ConditionSearchFriendActivity.b((ConditionSearchFriendActivity)localObject, ((ConditionSearchFriendActivity)localObject).i);
      }
      localObject = this.a.a.b(this.a.d, this.a.e);
      this.a.l.setRightText((CharSequence)localObject);
      return;
    }
    if (this.a.P == 3)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ConditionSearchManager.k.length) {}
      }
      else
      {
        paramInt1 = 0;
      }
      localObject = this.a;
      ((ConditionSearchFriendActivity)localObject).f = paramInt1;
      ((ConditionSearchFriendActivity)localObject).p.setRightText(ConditionSearchManager.k[paramInt1]);
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if ((paramInt1 == 2) && (this.a.G > 2) && (this.a.F[2] != null) && (((List)this.a.F[2]).size() > 0))
        {
          if (paramInt2 >= 0)
          {
            paramInt1 = paramInt2;
            if (paramInt2 < ((List)this.a.F[2]).size()) {}
          }
          else
          {
            paramInt1 = 0;
          }
          this.a.I[2] = paramInt1;
          this.a.H[2] = ((BaseAddress)((List)this.a.F[2]).get(paramInt1));
          this.a.J[2] = this.a.H[2].code;
        }
      }
      else if ((this.a.F.length > 1) && (this.a.F[1] != null) && (((List)this.a.F[1]).size() > 0))
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = paramInt2;
          if (paramInt2 < ((List)this.a.F[1]).size()) {}
        }
        else
        {
          paramInt1 = 0;
        }
        this.a.I[1] = paramInt1;
        this.a.H[1] = ((BaseAddress)((List)this.a.F[1]).get(paramInt1));
        this.a.J[1] = this.a.H[1].code;
        localObject = this.a.H[1].getDataList();
        if (this.a.G > 2)
        {
          this.a.F[2] = localObject;
          this.a.I[2] = 0;
          this.a.H[2] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.a.J[2] = "0";
          try
          {
            this.a.O.a(2);
            this.a.O.setSelection(2, 0);
          }
          catch (Exception localException1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, localException1, new Object[0]);
            }
            if (this.a.N == null) {
              break label1162;
            }
          }
          if (this.a.N.isShowing()) {
            this.a.N.dismiss();
          }
        }
      }
    }
    else if ((this.a.F.length > 0) && (this.a.F[0] != null) && (((List)this.a.F[0]).size() > 0))
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = paramInt2;
        if (paramInt2 < ((List)this.a.F[0]).size()) {}
      }
      else
      {
        paramInt1 = 0;
      }
      this.a.I[0] = paramInt1;
      this.a.H[0] = ((BaseAddress)((List)this.a.F[0]).get(paramInt1));
      this.a.J[0] = this.a.H[0].code;
      ArrayList localArrayList = this.a.H[0].getDataList();
      if (this.a.G > 1)
      {
        this.a.F[1] = localArrayList;
        this.a.I[1] = 0;
        this.a.H[1] = new AddressData.NO_LIMIT_ADDRESS(2);
        this.a.J[1] = "0";
        try
        {
          this.a.O.a(1);
          this.a.O.setSelection(1, 0);
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearchFriendActivity", 2, localException2, new Object[0]);
          }
          if ((this.a.N != null) && (this.a.N.isShowing())) {
            this.a.N.dismiss();
          }
        }
        if (this.a.G > 2)
        {
          this.a.F[2] = null;
          this.a.I[2] = 0;
          this.a.H[2] = new AddressData.NO_LIMIT_ADDRESS(2);
          this.a.J[2] = "0";
          try
          {
            this.a.O.a(2);
            this.a.O.setSelection(2, 0);
          }
          catch (Exception localException3)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ConditionSearchFriendActivity", 2, localException3, new Object[0]);
            }
            if ((this.a.N != null) && (this.a.N.isShowing())) {
              this.a.N.dismiss();
            }
          }
        }
      }
    }
    label1162:
    if (this.a.P == 1)
    {
      this.a.m.setRightText(this.a.a.d(ConditionSearchFriendActivity.b(this.a)));
      return;
    }
    if (this.a.P == 2) {
      this.a.n.setRightText(this.a.a.d(ConditionSearchFriendActivity.b(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.4
 * JD-Core Version:    0.7.0.1
 */