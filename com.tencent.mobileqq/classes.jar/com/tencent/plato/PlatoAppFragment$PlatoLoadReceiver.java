package com.tencent.plato;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class PlatoAppFragment$PlatoLoadReceiver
  extends QQUIEventReceiver
{
  public PlatoAppFragment$PlatoLoadReceiver(@NonNull PlatoAppFragment paramPlatoAppFragment)
  {
    super(paramPlatoAppFragment);
  }
  
  public Class acceptEventClass()
  {
    return PlatoLoadEvent.class;
  }
  
  public void onEvent(@NonNull PlatoAppFragment paramPlatoAppFragment, @NonNull PlatoLoadEvent paramPlatoLoadEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlatoAppActivity", 2, "receive event:" + paramPlatoLoadEvent.toString());
    }
    if (paramPlatoLoadEvent.type == 0)
    {
      paramPlatoAppFragment.mSoLoadResult = paramPlatoLoadEvent.code;
      paramPlatoAppFragment.preload();
    }
    if ((paramPlatoLoadEvent.type == 1) && (paramPlatoAppFragment.mBid.equals(paramPlatoLoadEvent.bid)))
    {
      paramPlatoAppFragment.mJsLoadResult = paramPlatoLoadEvent.code;
      paramPlatoAppFragment.mBundlerPath = paramPlatoLoadEvent.path;
      paramPlatoAppFragment.preload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.plato.PlatoAppFragment.PlatoLoadReceiver
 * JD-Core Version:    0.7.0.1
 */