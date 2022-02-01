package com.tencent.widget.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFitSystemWindowsUtil
  extends QRouteApi
{
  public abstract int getTopInset(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.api.IFitSystemWindowsUtil
 * JD-Core Version:    0.7.0.1
 */