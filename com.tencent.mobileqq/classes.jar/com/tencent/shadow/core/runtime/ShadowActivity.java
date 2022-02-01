package com.tencent.shadow.core.runtime;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.SharedElementCallback;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.shadow.core.runtime.qcircle.container.HostActivityDelegator;

public abstract class ShadowActivity
  extends PluginActivity
{
  private int mFragmentManagerHash;
  private PluginFragmentManager mPluginFragmentManager;
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mHostActivityDelegator.superAddContentView(paramView, paramLayoutParams);
  }
  
  public <T extends View> T findViewById(int paramInt)
  {
    return this.mHostActivityDelegator.findViewById(paramInt);
  }
  
  public void finishAffinity()
  {
    this.mHostActivityDelegator.finishAffinity();
  }
  
  public void finishAfterTransition()
  {
    this.mHostActivityDelegator.finishAfterTransition();
  }
  
  public ActionBar getActionBar()
  {
    return this.mHostActivityDelegator.getActionBar();
  }
  
  public final ShadowApplication getApplication()
  {
    return this.mPluginApplication;
  }
  
  public ComponentName getCallingActivity()
  {
    return this.mHostActivityDelegator.getCallingActivity();
  }
  
  public String getCallingPackage()
  {
    return this.mHostActivityDelegator.getCallingPackage();
  }
  
  public ComponentName getComponentName()
  {
    return this.mHostActivityDelegator.getComponentName();
  }
  
  public View getCurrentFocus()
  {
    return this.mHostActivityDelegator.getCurrentFocus();
  }
  
  public PluginFragmentManager getFragmentManager()
  {
    FragmentManager localFragmentManager = this.mHostActivityDelegator.getFragmentManager();
    int i = System.identityHashCode(localFragmentManager);
    if (i != this.mFragmentManagerHash)
    {
      this.mFragmentManagerHash = i;
      this.mPluginFragmentManager = new PluginFragmentManager(localFragmentManager);
    }
    return this.mPluginFragmentManager;
  }
  
  public Intent getIntent()
  {
    return this.mHostActivityDelegator.getIntent();
  }
  
  public Object getLastNonConfigurationInstance()
  {
    return this.mHostActivityDelegator.getLastNonConfigurationInstance();
  }
  
  public String getLocalClassName()
  {
    return getClass().getName();
  }
  
  public final MediaController getMediaController()
  {
    return this.mHostActivityDelegator.getMediaController();
  }
  
  public MenuInflater getMenuInflater()
  {
    return this.mHostActivityDelegator.getMenuInflater();
  }
  
  public final ShadowActivity getParent()
  {
    return null;
  }
  
  public Intent getParentActivityIntent()
  {
    return this.mHostActivityDelegator.getParentActivityIntent();
  }
  
  public SharedPreferences getPreferences(int paramInt)
  {
    return super.getSharedPreferences(getLocalClassName(), paramInt);
  }
  
  public Uri getReferrer()
  {
    return this.mHostActivityDelegator.getReferrer();
  }
  
  public int getRequestedOrientation()
  {
    return this.mHostActivityDelegator.getRequestedOrientation();
  }
  
  public CharSequence getTitle()
  {
    return this.mHostActivityDelegator.getTitle();
  }
  
  public final int getTitleColor()
  {
    return this.mHostActivityDelegator.getTitleColor();
  }
  
  public final int getVolumeControlStream()
  {
    return this.mHostActivityDelegator.getVolumeControlStream();
  }
  
  public Window getWindow()
  {
    return this.mHostActivityDelegator.getWindow();
  }
  
  public WindowManager getWindowManager()
  {
    return this.mHostActivityDelegator.getWindowManager();
  }
  
  public void invalidateOptionsMenu()
  {
    this.mHostActivityDelegator.invalidateOptionsMenu();
  }
  
  public boolean isDestroyed()
  {
    return this.mHostActivityDelegator.isDestroyed();
  }
  
  public boolean isFinishing()
  {
    return this.mHostActivityDelegator.isFinishing();
  }
  
  public boolean isInMultiWindowMode()
  {
    return this.mHostActivityDelegator.isInMultiWindowMode();
  }
  
  @Deprecated
  public final Cursor managedQuery(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return this.mHostActivityDelegator.managedQuery(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public boolean navigateUpTo(Intent paramIntent)
  {
    paramIntent = this.mPluginComponentLauncher.convertPluginActivityIntent(paramIntent);
    return this.mHostActivityDelegator.navigateUpTo(paramIntent);
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if ((paramInt1 & 0xFF000000) != 16777216) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if ((0xFF000000 & paramInt2) != 16777216) {
      paramInt1 = 0;
    }
    this.mHostActivityDelegator.overridePendingTransition(i, paramInt1);
  }
  
  public void postponeEnterTransition()
  {
    this.mHostActivityDelegator.postponeEnterTransition();
  }
  
  public void recreate()
  {
    this.mHostActivityDelegator.recreate();
  }
  
  public void registerActivityLifecycleCallbacks(ShadowActivityLifecycleCallbacks paramShadowActivityLifecycleCallbacks)
  {
    this.mShadowApplication.registerActivityLifecycleCallbacks(paramShadowActivityLifecycleCallbacks);
  }
  
  public DragAndDropPermissions requestDragAndDropPermissions(DragEvent paramDragEvent)
  {
    return this.mHostActivityDelegator.requestDragAndDropPermissions(paramDragEvent);
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    this.mHostActivityDelegator.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public final boolean requestWindowFeature(int paramInt)
  {
    return this.mHostActivityDelegator.requestWindowFeature(paramInt);
  }
  
  public void runOnUiThread(Runnable paramRunnable)
  {
    this.mHostActivityDelegator.runOnUiThread(paramRunnable);
  }
  
  public void setContentView(int paramInt)
  {
    if ("merge".equals(XmlPullParserUtil.getLayoutStartTagName(getResources(), paramInt)))
    {
      localObject = (ViewGroup)this.mHostActivityDelegator.getWindow().getDecorView().findViewById(16908290);
      LayoutInflater.from(this).inflate(paramInt, (ViewGroup)localObject);
      return;
    }
    Object localObject = LayoutInflater.from(this).inflate(paramInt, null);
    this.mHostActivityDelegator.setContentView((View)localObject);
  }
  
  public void setContentView(View paramView)
  {
    this.mHostActivityDelegator.setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mHostActivityDelegator.setContentView(paramView, paramLayoutParams);
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    this.mHostActivityDelegator.setEnterSharedElementCallback(paramSharedElementCallback);
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    this.mHostActivityDelegator.setExitSharedElementCallback(paramSharedElementCallback);
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.mHostActivityDelegator.setIntent(paramIntent);
  }
  
  public final void setMediaController(MediaController paramMediaController)
  {
    this.mHostActivityDelegator.setMediaController(paramMediaController);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.mHostActivityDelegator.setRequestedOrientation(paramInt);
  }
  
  public final void setResult(int paramInt)
  {
    this.mHostActivityDelegator.setResult(paramInt);
  }
  
  public final void setResult(int paramInt, Intent paramIntent)
  {
    this.mHostActivityDelegator.setResult(paramInt, paramIntent);
  }
  
  public void setTheme(int paramInt)
  {
    this.mHostActivityDelegator.setTheme(paramInt);
  }
  
  public void setTitle(int paramInt)
  {
    this.mHostActivityDelegator.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mHostActivityDelegator.setTitle(paramCharSequence);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.mHostActivityDelegator.setTitleColor(paramInt);
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.mHostActivityDelegator.setVisible(paramBoolean);
  }
  
  public final void setVolumeControlStream(int paramInt)
  {
    this.mHostActivityDelegator.setVolumeControlStream(paramInt);
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    return this.mHostActivityDelegator.shouldShowRequestPermissionRationale(paramString);
  }
  
  public boolean shouldUpRecreateTask(Intent paramIntent)
  {
    paramIntent = this.mPluginComponentLauncher.convertPluginActivityIntent(paramIntent);
    return this.mHostActivityDelegator.shouldUpRecreateTask(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramIntent);
    localIntent.setExtrasClassLoader(this.mPluginClassLoader);
    ComponentName localComponentName = new ComponentName(getPackageName(), getClass().getName());
    if (!this.mPluginComponentLauncher.startActivityForResult(this.mHostActivityDelegator, localIntent, paramInt, paramBundle, localComponentName)) {
      this.mHostActivityDelegator.startActivityForResult(paramIntent, paramInt, paramBundle);
    }
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mHostActivityDelegator.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.mHostActivityDelegator.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startPostponedEnterTransition()
  {
    this.mHostActivityDelegator.startPostponedEnterTransition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.ShadowActivity
 * JD-Core Version:    0.7.0.1
 */