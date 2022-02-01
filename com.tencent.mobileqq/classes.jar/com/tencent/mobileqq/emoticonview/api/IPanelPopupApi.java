package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPanelPopupApi
  extends QRouteApi
{
  public abstract IPanelDependListener createPanelDependListener();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IPanelPopupApi
 * JD-Core Version:    0.7.0.1
 */