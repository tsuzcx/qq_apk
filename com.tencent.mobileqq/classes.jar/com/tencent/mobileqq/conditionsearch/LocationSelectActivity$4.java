package com.tencent.mobileqq.conditionsearch;

import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LocationSelectActivity$4
  implements IphonePickerView.IphonePickListener
{
  LocationSelectActivity$4(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onConfirmBtClicked()
  {
    LocationSelectActivity.b(this.a).setRightTextColor(2);
    this.a.i.dismiss();
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (this.a.j == null) {
      return;
    }
    Object localObject2 = null;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          break label778;
        }
        if (Collections.emptyList().equals(this.a.b[2]))
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("LocationSelectActivity", 2, "columnListArray at 2 is empty");
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = (ArrayList)this.a.b[2];
        }
        if ((localObject1 == null) || (paramInt2 >= ((ArrayList)localObject1).size()) || (paramInt2 < 0)) {
          break label778;
        }
        this.a.c[2] = ((BaseAddress)((ArrayList)localObject1).get(paramInt2));
        this.a.d[2] = paramInt2;
        break label778;
      }
      this.a.d[1] = paramInt2;
      this.a.j.setPickListener(null);
    }
    try
    {
      this.a.c[1] = ((BaseAddress)((ArrayList)this.a.b[1]).get(paramInt2));
    }
    catch (Exception localException)
    {
      label185:
      break label185;
    }
    this.a.c[1] = new BaseAddress("不限", "0", 2);
    Object localObject1 = this.a.c[1].getDataList();
    if (((ArrayList)localObject1).size() > 0)
    {
      this.a.b[2] = localObject1;
      this.a.c[2] = ((BaseAddress)((ArrayList)localObject1).get(0));
      this.a.d[2] = 0;
    }
    else if (this.a.f > 2)
    {
      this.a.c[2] = new AddressData.NO_LIMIT_ADDRESS(3);
      this.a.b[2] = null;
      this.a.d[2] = 0;
    }
    if (this.a.f > 2)
    {
      this.a.j.a(2);
      this.a.j.setSelection(2, this.a.d[2]);
    }
    this.a.j.setPickListener(this);
    break label778;
    this.a.j.setPickListener(null);
    this.a.d[0] = paramInt2;
    this.a.c[0] = ((BaseAddress)((ArrayList)this.a.b[0]).get(paramInt2));
    localObject1 = this.a.c[0].getDataList();
    if (((ArrayList)localObject1).size() > 0)
    {
      this.a.b[1] = localObject1;
      this.a.c[1] = ((BaseAddress)((ArrayList)localObject1).get(0));
      this.a.d[1] = 0;
      localObject1 = this.a.c[1].getDataList();
      if (((ArrayList)localObject1).size() > 0)
      {
        this.a.b[2] = localObject1;
        this.a.c[2] = ((BaseAddress)((ArrayList)localObject1).get(0));
        this.a.d[2] = 0;
      }
      else if (this.a.f == 3)
      {
        this.a.c[2] = new AddressData.NO_LIMIT_ADDRESS(3);
        this.a.b[2] = null;
        this.a.d[2] = 0;
      }
    }
    else if (this.a.f > 1)
    {
      this.a.c[1] = new AddressData.NO_LIMIT_ADDRESS(2);
      this.a.b[1] = null;
      this.a.d[1] = 0;
      if (this.a.f == 3)
      {
        this.a.c[2] = new AddressData.NO_LIMIT_ADDRESS(3);
        this.a.b[2] = null;
        this.a.d[2] = 0;
      }
    }
    if (this.a.f > 1)
    {
      this.a.j.a(1);
      this.a.j.setSelection(1, this.a.d[1]);
      if (this.a.f == 3)
      {
        this.a.j.a(2);
        this.a.j.setSelection(2, this.a.d[2]);
      }
    }
    this.a.j.setPickListener(this);
    label778:
    localObject1 = this.a;
    LocationSelectActivity.a((LocationSelectActivity)localObject1, LocationSelectActivity.b((LocationSelectActivity)localObject1), LocationSelectActivity.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.LocationSelectActivity.4
 * JD-Core Version:    0.7.0.1
 */