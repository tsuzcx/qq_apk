package com.tencent.tbs.video.interfaces;

import android.app.Activity;
import android.content.Intent;

public abstract interface IUserStateHolder
{
  public abstract boolean isSuperVipUser();
  
  public abstract void onVipActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void requestOpenSuperVip(Activity paramActivity);
  
  public abstract void setUserStateChangedListener(IUserStateChangedListener paramIUserStateChangedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.tbs.video.interfaces.IUserStateHolder
 * JD-Core Version:    0.7.0.1
 */