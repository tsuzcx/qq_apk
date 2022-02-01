package com.tencent.mobileqq.newnearby.util;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mobileqq.newnearby.model.AddrInfo;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

final class PickLocationHelper$4
  implements IphonePickerView.IphonePickListener
{
  PickLocationHelper$4(Promise paramPromise) {}
  
  public void onConfirmBtClicked()
  {
    PickLocationHelper.m().dismiss();
    NearbyHippyCallback.a(this.a, PickLocationHelper.f(), PickLocationHelper.k(), PickLocationHelper.n());
    QLog.d("PickLocationHelper", 2, "showPickerView onConfirmBtClicked");
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    Object localObject;
    Iterator localIterator;
    String str;
    if (paramInt1 == 0)
    {
      PickLocationHelper.d().setPickListener(null);
      PickLocationHelper.a(paramInt2);
      PickLocationHelper.a((AddrInfo)PickLocationHelper.e().get(paramInt2));
      localObject = PickLocationHelper.f().a;
      PickLocationHelper.g().clear();
      localIterator = PickLocationHelper.h().keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (((AddrInfo)PickLocationHelper.h().get(str)).b.equals(localObject)) {
          PickLocationHelper.g().add(PickLocationHelper.h().get(str));
        }
      }
      if (PickLocationHelper.g().size() > 0) {
        PickLocationHelper.b((AddrInfo)PickLocationHelper.g().get(0));
      } else {
        PickLocationHelper.b(null);
      }
      localObject = ((AddrInfo)PickLocationHelper.g().get(0)).a;
      PickLocationHelper.i().clear();
      localIterator = PickLocationHelper.j().keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (((AddrInfo)PickLocationHelper.j().get(str)).b.equals(localObject)) {
          PickLocationHelper.i().add(PickLocationHelper.j().get(str));
        }
      }
      if (PickLocationHelper.i().size() > 0) {
        PickLocationHelper.c((AddrInfo)PickLocationHelper.i().get(0));
      } else {
        PickLocationHelper.c(null);
      }
      localObject = PickLocationHelper.d();
      paramInt2 = paramInt1 + 1;
      ((IphonePickerView)localObject).a(paramInt2);
      localObject = PickLocationHelper.d();
      paramInt1 += 2;
      ((IphonePickerView)localObject).a(paramInt1);
      PickLocationHelper.d().setSelection(paramInt2, 0);
      PickLocationHelper.d().setSelection(paramInt1, 0);
      PickLocationHelper.d().setPickListener(this);
    }
    else if (paramInt1 == 1)
    {
      PickLocationHelper.d().setPickListener(null);
      PickLocationHelper.b(paramInt2);
      PickLocationHelper.b((AddrInfo)PickLocationHelper.g().get(paramInt2));
      localObject = PickLocationHelper.k().a;
      PickLocationHelper.i().clear();
      localIterator = PickLocationHelper.j().keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (((AddrInfo)PickLocationHelper.j().get(str)).b.equals(localObject)) {
          PickLocationHelper.i().add(PickLocationHelper.j().get(str));
        }
      }
      if (PickLocationHelper.i().size() > 0) {
        PickLocationHelper.c((AddrInfo)PickLocationHelper.i().get(0));
      } else {
        PickLocationHelper.c(null);
      }
      localObject = PickLocationHelper.d();
      paramInt1 += 1;
      ((IphonePickerView)localObject).a(paramInt1);
      PickLocationHelper.d().setSelection(paramInt1, 0);
      PickLocationHelper.d().setPickListener(this);
    }
    else if (paramInt1 == 2)
    {
      PickLocationHelper.c(paramInt2);
      PickLocationHelper.c((AddrInfo)PickLocationHelper.i().get(paramInt2));
    }
    PickLocationHelper.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickLocationHelper.4
 * JD-Core Version:    0.7.0.1
 */