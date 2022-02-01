package com.tencent.mobileqq.nearby.now;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISmallVideoFragmentUtil
  extends QRouteApi
{
  public abstract void launch(Context paramContext, Bundle paramBundle);
  
  public abstract void launch(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil
 * JD-Core Version:    0.7.0.1
 */