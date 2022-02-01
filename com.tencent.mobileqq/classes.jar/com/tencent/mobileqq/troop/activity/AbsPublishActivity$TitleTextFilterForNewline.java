package com.tencent.mobileqq.troop.activity;

import android.text.InputFilter;
import android.text.Spanned;

class AbsPublishActivity$TitleTextFilterForNewline
  implements InputFilter
{
  AbsPublishActivity$TitleTextFilterForNewline(AbsPublishActivity paramAbsPublishActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence != null)
    {
      paramCharSequence = paramCharSequence.toString();
      if (paramCharSequence.contains("\n")) {
        return paramCharSequence.replaceAll("\n", "");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.AbsPublishActivity.TitleTextFilterForNewline
 * JD-Core Version:    0.7.0.1
 */