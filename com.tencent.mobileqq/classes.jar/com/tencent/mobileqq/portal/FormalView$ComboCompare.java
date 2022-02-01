package com.tencent.mobileqq.portal;

import java.util.Comparator;

class FormalView$ComboCompare
  implements Comparator<PortalManager.ComboNumber>
{
  public int a(PortalManager.ComboNumber paramComboNumber1, PortalManager.ComboNumber paramComboNumber2)
  {
    if (paramComboNumber1.number > paramComboNumber2.number) {
      return 1;
    }
    if (paramComboNumber1.number < paramComboNumber2.number) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView.ComboCompare
 * JD-Core Version:    0.7.0.1
 */