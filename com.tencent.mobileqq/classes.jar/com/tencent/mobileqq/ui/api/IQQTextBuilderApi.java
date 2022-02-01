package com.tencent.mobileqq.ui.api;

import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQTextBuilderApi
  extends QRouteApi
{
  public abstract String toPlainText(SpannableStringBuilder paramSpannableStringBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ui.api.IQQTextBuilderApi
 * JD-Core Version:    0.7.0.1
 */