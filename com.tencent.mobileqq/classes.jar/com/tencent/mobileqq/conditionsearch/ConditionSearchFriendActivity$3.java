package com.tencent.mobileqq.conditionsearch;

import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ConditionSearchFriendActivity$3
  implements IphonePickerView.PickerViewAdapter
{
  ConditionSearchFriendActivity$3(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public int getColumnCount()
  {
    int j = this.a.i;
    int i = 1;
    if (j == 0) {
      i = 2;
    } else if ((this.a.i != 3) && ((this.a.i == 1) || (this.a.i == 2))) {
      i = this.a.h;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getColumnCount|pickerType : ");
      localStringBuilder.append(this.a.i);
      localStringBuilder.append(", count : ");
      localStringBuilder.append(i);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public int getRowCount(int paramInt)
  {
    int i;
    if (this.a.i == 0) {
      i = ConditionSearchManager.b.length - 17;
    } else if (this.a.i == 3) {
      i = ConditionSearchManager.c.length;
    } else if (((this.a.i == 1) || (this.a.i == 2)) && (paramInt < this.a.h) && (paramInt >= 0) && (this.a.a[paramInt] != null)) {
      i = ((List)this.a.a[paramInt]).size();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRowCount|pickerType : ");
      localStringBuilder.append(this.a.i);
      localStringBuilder.append(", column : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", count : ");
      localStringBuilder.append(i);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    int i;
    String str;
    if (this.a.i == 0)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.b.length) {}
      }
      else
      {
        i = 0;
      }
      paramInt2 = ConditionSearchFriendActivity.b(this.a, i);
      str = ConditionSearchManager.b[paramInt2];
      paramInt2 = i;
    }
    else if (this.a.i == 3)
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ConditionSearchManager.c.length) {}
      }
      else
      {
        i = 0;
      }
      str = ConditionSearchManager.c[i];
      paramInt2 = i;
    }
    else if (((this.a.i == 1) || (this.a.i == 2)) && (paramInt1 < this.a.a.length) && (this.a.a[paramInt1] != null) && (((List)this.a.a[paramInt1]).size() > 0))
    {
      if (paramInt2 >= 0)
      {
        i = paramInt2;
        if (paramInt2 < ((List)this.a.a[paramInt1]).size()) {}
      }
      else
      {
        i = 0;
      }
      if (((BaseAddress)((List)this.a.a[paramInt1]).get(i)).code.equals("0"))
      {
        str = ConditionSearchFriendActivity.a();
        paramInt2 = i;
      }
      else
      {
        str = ((BaseAddress)((List)this.a.a[paramInt1]).get(i)).name;
        paramInt2 = i;
      }
    }
    else
    {
      str = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getText|pickerType : ");
      localStringBuilder.append(this.a.i);
      localStringBuilder.append(", column : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", row : ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", result : ");
      localStringBuilder.append(str);
      QLog.d("ConditionSearchFriendActivity", 2, localStringBuilder.toString());
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.3
 * JD-Core Version:    0.7.0.1
 */