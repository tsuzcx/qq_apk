package com.tencent.mobileqq.troop.api;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopNickEdit
  extends QRouteApi
{
  public abstract void onDetachedFromWindow(Drawable paramDrawable);
  
  public abstract void setCustomCloth(TextView paramTextView, Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract void updateDrawablePadding(Drawable paramDrawable, PointF paramPointF);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopNickEdit
 * JD-Core Version:    0.7.0.1
 */