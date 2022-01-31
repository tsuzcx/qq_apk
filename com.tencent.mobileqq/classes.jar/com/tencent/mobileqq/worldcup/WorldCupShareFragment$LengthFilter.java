package com.tencent.mobileqq.worldcup;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class WorldCupShareFragment$LengthFilter
  implements InputFilter
{
  private final int jdField_a_of_type_Int;
  
  public WorldCupShareFragment$LengthFilter(WorldCupShareFragment paramWorldCupShareFragment, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (!(paramCharSequence instanceof String)) {}
    String str;
    int i;
    do
    {
      return paramCharSequence;
      str = paramCharSequence.toString().replaceAll("[^a-zA-Z\\u4E00-\\u9FA5]", "");
      i = str.length() + paramInt1;
      if (paramInt2 != i)
      {
        QQToast.a(BaseApplication.getContext(), 2131439418, 0).a();
        WorldCupShareFragment.a("0X8009319", 3);
      }
      paramInt2 = this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3));
      if (paramInt2 <= 0) {
        return "";
      }
      paramCharSequence = str;
    } while (paramInt2 >= i - paramInt1);
    paramInt3 = paramInt2 + paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(str.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1) {
        return "";
      }
    }
    return str.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.WorldCupShareFragment.LengthFilter
 * JD-Core Version:    0.7.0.1
 */