package com.tencent.mobileqq.profilecard.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IProfileCardApi
  extends QRouteApi
{
  public abstract void openProfileCard(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.IProfileCardApi
 * JD-Core Version:    0.7.0.1
 */