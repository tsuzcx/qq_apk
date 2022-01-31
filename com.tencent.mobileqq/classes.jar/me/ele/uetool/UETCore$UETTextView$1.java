package me.ele.uetool;

import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;

class UETCore$UETTextView$1
  implements AddMinusEditItem.CustomAddMin
{
  int[] fontSize = { 20, 24, 28, 32, 34 };
  
  UETCore$UETTextView$1(UETCore.UETTextView paramUETTextView) {}
  
  public int add(int paramInt)
  {
    int[] arrayOfInt = this.fontSize;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (paramInt < k) {
        return k;
      }
      i += 1;
    }
    return paramInt + 2;
  }
  
  public int min(int paramInt)
  {
    int i = this.fontSize.length - 1;
    while (i >= 0)
    {
      if (paramInt > this.fontSize[i]) {
        return this.fontSize[i];
      }
      i -= 1;
    }
    return paramInt - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.UETCore.UETTextView.1
 * JD-Core Version:    0.7.0.1
 */