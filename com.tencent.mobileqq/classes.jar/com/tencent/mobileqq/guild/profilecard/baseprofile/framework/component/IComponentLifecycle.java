package com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;

public abstract interface IComponentLifecycle<DATA>
{
  public abstract void onCreate(Fragment paramFragment, AppInterface paramAppInterface, Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onInitData(DATA paramDATA);
  
  public abstract void onPause();
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.profilecard.baseprofile.framework.component.IComponentLifecycle
 * JD-Core Version:    0.7.0.1
 */