package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IMagazinePlayerViewCreater
  extends QRouteApi
{
  public abstract IMagazinePlayerView create(Context paramContext, ActCallBack paramActCallBack, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.IMagazinePlayerViewCreater
 * JD-Core Version:    0.7.0.1
 */