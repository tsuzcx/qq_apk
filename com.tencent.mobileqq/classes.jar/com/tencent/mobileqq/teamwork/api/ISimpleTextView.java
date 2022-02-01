package com.tencent.mobileqq.teamwork.api;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISimpleTextView
  extends QRouteApi
{
  public abstract void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ISimpleTextView
 * JD-Core Version:    0.7.0.1
 */