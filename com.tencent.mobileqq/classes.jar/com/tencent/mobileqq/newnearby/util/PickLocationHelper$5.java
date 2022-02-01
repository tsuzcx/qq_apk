package com.tencent.mobileqq.newnearby.util;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.newnearby.model.AddrInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class PickLocationHelper$5
  implements IphonePickerView.PickerViewAdapter
{
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount(int paramInt)
  {
    if (paramInt == 0) {
      return PickLocationHelper.e().size();
    }
    if (paramInt == 1) {
      return PickLocationHelper.g().size();
    }
    if (paramInt == 2) {
      return PickLocationHelper.i().size();
    }
    return 0;
  }
  
  public String getText(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    try
    {
      return ((AddrInfo)PickLocationHelper.e().get(paramInt2)).c;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      String str;
      break label58;
    }
    if (paramInt1 == 1) {
      return ((AddrInfo)PickLocationHelper.g().get(paramInt2)).c;
    }
    if (paramInt1 == 2)
    {
      str = ((AddrInfo)PickLocationHelper.i().get(paramInt2)).c;
      return str;
      label58:
      if (QLog.isColorLevel()) {
        QLog.e("PickLocationHelper", 2, "", str);
      }
    }
    return "----";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickLocationHelper.5
 * JD-Core Version:    0.7.0.1
 */