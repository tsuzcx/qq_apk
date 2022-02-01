package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQCircleRFWApi
  extends QRouteApi
{
  public abstract void checkExceptionWhetherCauseByQCircle(String paramString);
  
  public abstract String getDefaultSavePath(String paramString);
  
  public abstract Typeface getTypeface(Context paramContext, String paramString);
  
  public abstract String getUniKeyFromUrl(String paramString);
  
  public abstract void setNumberTypeface(TextView paramTextView, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleRFWApi
 * JD-Core Version:    0.7.0.1
 */