package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INowViewCreater
  extends QRouteApi
{
  public abstract IShortVideoCommentsView createShortVideoCommentsView(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.INowViewCreater
 * JD-Core Version:    0.7.0.1
 */