package com.tencent.mobileqq.troop.fragment;

import android.text.InputFilter;
import android.text.Spanned;

class TroopRemarkEditFragment$5
  implements InputFilter
{
  TroopRemarkEditFragment$5(TroopRemarkEditFragment paramTroopRemarkEditFragment) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.toString().contains("\n")) {
      return paramCharSequence.toString().replace("\n", "");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fragment.TroopRemarkEditFragment.5
 * JD-Core Version:    0.7.0.1
 */