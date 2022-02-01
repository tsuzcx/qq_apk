package com.tencent.mobileqq.qwallet.widget;

class NumAnim$1
  implements NumAnim.Ruler
{
  NumAnim$1(NumAnim paramNumAnim) {}
  
  public NumAnim.SpannableValue getNumber(double paramDouble)
  {
    if (((paramDouble < 1000.0D) || (paramDouble >= 10000.0D)) && (paramDouble >= 0.0D)) {}
    String str2 = NumAnim.a(paramDouble, true);
    String str1;
    if (paramDouble >= 10000.0D) {
      str1 = "万";
    } else {
      str1 = ".";
    }
    return new NumAnim.SpannableValue(str2, 0, str2.indexOf(str1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.NumAnim.1
 * JD-Core Version:    0.7.0.1
 */