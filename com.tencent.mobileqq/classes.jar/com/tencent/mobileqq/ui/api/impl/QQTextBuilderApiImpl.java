package com.tencent.mobileqq.ui.api.impl;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.ui.api.IQQTextBuilderApi;

public class QQTextBuilderApiImpl
  implements IQQTextBuilderApi
{
  public String toPlainText(SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramSpannableStringBuilder instanceof QQTextBuilder))
    {
      paramSpannableStringBuilder = (QQTextBuilder)paramSpannableStringBuilder;
      if (paramSpannableStringBuilder != null) {
        return paramSpannableStringBuilder.toPlainText();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.ui.api.impl.QQTextBuilderApiImpl
 * JD-Core Version:    0.7.0.1
 */