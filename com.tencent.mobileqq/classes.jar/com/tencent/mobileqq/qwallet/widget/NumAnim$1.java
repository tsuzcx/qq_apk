package com.tencent.mobileqq.qwallet.widget;

class NumAnim$1
  implements NumAnim.Ruler
{
  NumAnim$1(NumAnim paramNumAnim) {}
  
  public NumAnim.SpannableValue getNumber(double paramDouble)
  {
    if (((paramDouble < 1000.0D) || (paramDouble >= 10000.0D)) && (paramDouble >= 0.0D)) {}
    String str = NumAnim.a(paramDouble, true);
    return new NumAnim.SpannableValue(str, 0, str.indexOf("."), str.indexOf("万"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.NumAnim.1
 * JD-Core Version:    0.7.0.1
 */