package com.tencent.mobileqq.guild.api;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IGuildContextApi
  extends QRouteApi
{
  public abstract FragmentManager getChildFragmentManager(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildContextApi
 * JD-Core Version:    0.7.0.1
 */