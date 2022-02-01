package com.tencent.qcircle.shadow.core.runtime;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator;

public abstract interface ShadowContext$PluginComponentLauncher
{
  public abstract Pair<Boolean, Boolean> bindService(ShadowContext paramShadowContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt);
  
  public abstract Intent convertPluginActivityIntent(Intent paramIntent);
  
  public abstract boolean startActivity(ShadowContext paramShadowContext, Intent paramIntent, Bundle paramBundle);
  
  public abstract boolean startActivityForResult(HostActivityDelegator paramHostActivityDelegator, Intent paramIntent, int paramInt, Bundle paramBundle, ComponentName paramComponentName);
  
  public abstract Pair<Boolean, ComponentName> startService(ShadowContext paramShadowContext, Intent paramIntent);
  
  public abstract Pair<Boolean, Boolean> stopService(ShadowContext paramShadowContext, Intent paramIntent);
  
  public abstract Pair<Boolean, ?> unbindService(ShadowContext paramShadowContext, ServiceConnection paramServiceConnection);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowContext.PluginComponentLauncher
 * JD-Core Version:    0.7.0.1
 */