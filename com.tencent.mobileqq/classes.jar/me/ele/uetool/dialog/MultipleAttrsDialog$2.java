package me.ele.uetool.dialog;

import me.ele.uetool.base.item.AddMinusEditItem.CustomAddMin;

final class MultipleAttrsDialog$2
  implements AddMinusEditItem.CustomAddMin
{
  int[] fontSize = { 20, 24, 28, 32, 34 };
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.2
 * JD-Core Version:    0.7.0.1
 */