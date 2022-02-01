package com.tencent.qidian.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQidianApi
  extends QRouteApi
{
  public abstract Intent getProfileCardIntent(Context paramContext, AllInOne paramAllInOne);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.api.IQidianApi
 * JD-Core Version:    0.7.0.1
 */