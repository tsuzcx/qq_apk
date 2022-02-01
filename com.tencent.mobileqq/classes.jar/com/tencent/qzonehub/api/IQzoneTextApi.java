package com.tencent.qzonehub.api;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneTextApi
  extends QRouteApi
{
  public abstract SpannableStringBuilder createQzoneTextBuilder(String paramString);
  
  public abstract Editable.Factory getEmoctationFacory();
  
  public abstract String toPlainText(Editable paramEditable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneTextApi
 * JD-Core Version:    0.7.0.1
 */