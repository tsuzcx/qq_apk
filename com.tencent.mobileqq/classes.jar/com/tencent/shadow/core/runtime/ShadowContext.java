package com.tencent.shadow.core.runtime;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.shadow.core.runtime.qcircle.container.HostActivityDelegator;
import com.tencent.shadow.core.runtime.remoteview.ShadowRemoteViewCreatorProvider;
import com.tencent.shadow.core.runtime.skin.entity.SkinItem;
import java.util.HashMap;

public class ShadowContext
  extends SubDirContextThemeWrapper
{
  ApplicationInfo mApplicationInfo;
  private String mBusinessName;
  LayoutInflater mLayoutInflater;
  Resources mMixResources;
  protected String mPartKey;
  ClassLoader mPluginClassLoader;
  ShadowContext.PluginComponentLauncher mPluginComponentLauncher;
  Resources mPluginResources;
  private ShadowRemoteViewCreatorProvider mRemoteViewCreatorProvider;
  ShadowApplication mShadowApplication;
  protected HashMap<View, SkinItem> mSkinMap = new HashMap();
  
  public ShadowContext() {}
  
  public ShadowContext(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    if (paramIntent.getComponent() == null) {
      return super.bindService(paramIntent, paramServiceConnection, paramInt);
    }
    Pair localPair = this.mPluginComponentLauncher.bindService(this, paramIntent, paramServiceConnection, paramInt);
    if (!((Boolean)localPair.first).booleanValue()) {
      return super.bindService(paramIntent, paramServiceConnection, paramInt);
    }
    return ((Boolean)localPair.second).booleanValue();
  }
  
  public Context getApplicationContext()
  {
    return this.mShadowApplication;
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    return this.mApplicationInfo;
  }
  
  public AssetManager getAssets()
  {
    return this.mPluginResources.getAssets();
  }
  
  public ClassLoader getClassLoader()
  {
    return this.mPluginClassLoader;
  }
  
  public ShadowContext.PluginComponentLauncher getPendingIntentConverter()
  {
    return this.mPluginComponentLauncher;
  }
  
  public final ShadowRemoteViewCreatorProvider getRemoteViewCreatorProvider()
  {
    return this.mRemoteViewCreatorProvider;
  }
  
  public Resources getResources()
  {
    if (this.mMixResources == null)
    {
      Object localObject = getBaseContext();
      if ((localObject instanceof HostActivityDelegator)) {
        localObject = ((HostActivityDelegator)localObject).superGetResources();
      } else {
        localObject = ((Context)localObject).getResources();
      }
      this.mMixResources = new MixResources((Resources)localObject, this.mPluginResources);
    }
    return this.mMixResources;
  }
  
  String getSubDirName()
  {
    if (this.mBusinessName == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShadowPlugin_");
    localStringBuilder.append(this.mBusinessName);
    return localStringBuilder.toString();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mLayoutInflater == null) {
        this.mLayoutInflater = ShadowLayoutInflater.build((LayoutInflater)super.getSystemService(paramString), this, this.mPartKey, this.mSkinMap);
      }
      return this.mLayoutInflater;
    }
    return super.getSystemService(paramString);
  }
  
  public void setApplicationInfo(ApplicationInfo paramApplicationInfo)
  {
    paramApplicationInfo = new ApplicationInfo(paramApplicationInfo);
    paramApplicationInfo.metaData = null;
    this.mApplicationInfo = paramApplicationInfo;
  }
  
  public void setBusinessName(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    this.mBusinessName = str;
  }
  
  public final void setPluginClassLoader(ClassLoader paramClassLoader)
  {
    this.mPluginClassLoader = paramClassLoader;
  }
  
  public void setPluginComponentLauncher(ShadowContext.PluginComponentLauncher paramPluginComponentLauncher)
  {
    this.mPluginComponentLauncher = paramPluginComponentLauncher;
  }
  
  public void setPluginPartKey(String paramString)
  {
    this.mPartKey = paramString;
  }
  
  public final void setPluginResources(Resources paramResources)
  {
    this.mPluginResources = paramResources;
  }
  
  public final void setRemoteViewCreatorProvider(ShadowRemoteViewCreatorProvider paramShadowRemoteViewCreatorProvider)
  {
    this.mRemoteViewCreatorProvider = paramShadowRemoteViewCreatorProvider;
  }
  
  public void setShadowApplication(ShadowApplication paramShadowApplication)
  {
    this.mShadowApplication = paramShadowApplication;
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramIntent);
    localIntent.setExtrasClassLoader(this.mPluginClassLoader);
    if (!this.mPluginComponentLauncher.startActivity(this, localIntent, paramBundle)) {
      super.startActivity(paramIntent, paramBundle);
    }
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {
      return super.startService(paramIntent);
    }
    Pair localPair = this.mPluginComponentLauncher.startService(this, paramIntent);
    if (!((Boolean)localPair.first).booleanValue()) {
      return super.startService(paramIntent);
    }
    return (ComponentName)localPair.second;
  }
  
  public boolean stopService(Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {
      return super.stopService(paramIntent);
    }
    Pair localPair = this.mPluginComponentLauncher.stopService(this, paramIntent);
    if (!((Boolean)localPair.first).booleanValue()) {
      return super.stopService(paramIntent);
    }
    return ((Boolean)localPair.second).booleanValue();
  }
  
  public void superStartActivity(Intent paramIntent, Bundle paramBundle)
  {
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    if (!((Boolean)this.mPluginComponentLauncher.unbindService(this, paramServiceConnection).first).booleanValue()) {
      super.unbindService(paramServiceConnection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ShadowContext
 * JD-Core Version:    0.7.0.1
 */