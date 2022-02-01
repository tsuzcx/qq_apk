package com.tencent.qcircle.shadow.core.runtime;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.Fragment.InstantiationException;
import android.app.Fragment.SavedState;
import android.app.LoaderManager;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ContainerDialogFragment
  extends ReportDialogFragment
  implements IContainerDialogFragment
{
  private static Map<String, Constructor<?>> constructorMap = new HashMap();
  private boolean init = false;
  private boolean mDestroyed;
  private boolean mIsAppCreateFragment = false;
  private ContainerDialogFragment.OnInflateParams mOnInflateParams;
  private ShadowDialogFragment mPluginFragment;
  
  private void initPluginFragment(Context paramContext)
  {
    if (this.init) {
      return;
    }
    this.init = true;
    onBindPluginFragment(paramContext);
    paramContext = this.mOnInflateParams;
    if (paramContext != null)
    {
      this.mPluginFragment.onInflate(paramContext.attrs, this.mOnInflateParams.savedInstanceState);
      this.mOnInflateParams = null;
    }
  }
  
  private static ShadowDialogFragment instantiatePluginFragment(ContainerDialogFragment paramContainerDialogFragment, Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContainerDialogFragment.getClass().getName());
    ((StringBuilder)localObject).append("_");
    String str = ((StringBuilder)localObject).toString();
    localObject = (Constructor)constructorMap.get(str);
    paramContainerDialogFragment = (ContainerDialogFragment)localObject;
    if (localObject == null)
    {
      paramContainerDialogFragment = ((PluginActivity)((PluginContainerActivity)paramContext).getPluginActivity()).getClassLoader();
      try
      {
        paramContainerDialogFragment = paramContainerDialogFragment.loadClass(str).getConstructor(new Class[0]);
        constructorMap.put(str, paramContainerDialogFragment);
      }
      catch (Exception paramContainerDialogFragment)
      {
        paramContext = new StringBuilder();
        paramContext.append("无法构造");
        paramContext.append(str);
        throw new Fragment.InstantiationException(paramContext.toString(), paramContainerDialogFragment);
      }
    }
    try
    {
      paramContainerDialogFragment = (ShadowDialogFragment)ShadowDialogFragment.class.cast(paramContainerDialogFragment.newInstance(new Object[0]));
      return paramContainerDialogFragment;
    }
    catch (Exception paramContainerDialogFragment)
    {
      paramContext = new StringBuilder();
      paramContext.append("无法构造");
      paramContext.append(str);
      throw new Fragment.InstantiationException(paramContext.toString(), paramContainerDialogFragment);
    }
  }
  
  private void onBindPluginFragment(Context paramContext)
  {
    this.mPluginFragment = instantiatePluginFragment(this, paramContext);
    this.mPluginFragment.setContainerFragment(this);
  }
  
  private void onUnbindPluginFragment()
  {
    this.mPluginFragment.setContainerFragment(null);
    this.mPluginFragment = null;
  }
  
  public Fragment asFragment()
  {
    return this;
  }
  
  public void bindPluginFragment(ShadowFragment paramShadowFragment)
  {
    this.init = true;
    this.mIsAppCreateFragment = true;
    this.mPluginFragment = ((ShadowDialogFragment)paramShadowFragment);
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.mPluginFragment.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    return this.mPluginFragment.getAllowEnterTransitionOverlap();
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    return this.mPluginFragment.getAllowReturnTransitionOverlap();
  }
  
  public Context getContext()
  {
    return this.mPluginFragment.getContext();
  }
  
  public Transition getEnterTransition()
  {
    return this.mPluginFragment.getEnterTransition();
  }
  
  public Transition getExitTransition()
  {
    return this.mPluginFragment.getExitTransition();
  }
  
  public LoaderManager getLoaderManager()
  {
    return this.mPluginFragment.getLoaderManager();
  }
  
  public ShadowFragment getPluginFragment()
  {
    return this.mPluginFragment;
  }
  
  public Transition getReenterTransition()
  {
    return this.mPluginFragment.getReenterTransition();
  }
  
  public Transition getReturnTransition()
  {
    return this.mPluginFragment.getReturnTransition();
  }
  
  public Transition getSharedElementEnterTransition()
  {
    return this.mPluginFragment.getSharedElementEnterTransition();
  }
  
  public Transition getSharedElementReturnTransition()
  {
    return this.mPluginFragment.getSharedElementReturnTransition();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mPluginFragment.onActivityCreated(paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mPluginFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  @Deprecated
  public void onAttach(Activity paramActivity)
  {
    initPluginFragment(paramActivity);
    super.onAttach(paramActivity);
    if ((paramActivity instanceof PluginContainerActivity))
    {
      paramActivity = (Context)((PluginContainerActivity)paramActivity).getPluginActivity();
      this.mPluginFragment.onAttach((ShadowActivity)paramActivity);
    }
  }
  
  public void onAttach(Context paramContext)
  {
    initPluginFragment(paramContext);
    super.onAttach(paramContext);
    if ((paramContext instanceof PluginContainerActivity))
    {
      paramContext = (Context)((PluginContainerActivity)paramContext).getPluginActivity();
      this.mPluginFragment.onAttach(paramContext);
    }
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    this.mPluginFragment.onAttachFragment(paramFragment);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.mPluginFragment.onCancel(paramDialogInterface);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mPluginFragment.onConfigurationChanged(paramConfiguration);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return this.mPluginFragment.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mPluginFragment.onCreate(paramBundle);
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return this.mPluginFragment.onCreateAnimator(paramInt1, paramBoolean, paramInt2);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    this.mPluginFragment.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return this.mPluginFragment.onCreateDialog(paramBundle);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    this.mPluginFragment.onCreateOptionsMenu(paramMenu, paramMenuInflater);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.mPluginFragment.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mPluginFragment.onDestroy();
    this.mDestroyed = true;
  }
  
  public void onDestroyOptionsMenu()
  {
    this.mPluginFragment.onDestroyOptionsMenu();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.mPluginFragment.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.mPluginFragment.onDetach();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.mPluginFragment.onDismiss(paramDialogInterface);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    this.mPluginFragment.onHiddenChanged(paramBoolean);
  }
  
  @Deprecated
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    this.mPluginFragment.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    initPluginFragment(paramContext);
    super.onInflate(paramContext, paramAttributeSet, paramBundle);
    this.mPluginFragment.onInflate(paramContext, paramAttributeSet, paramBundle);
  }
  
  @Deprecated
  public void onInflate(AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramAttributeSet, paramBundle);
    this.mOnInflateParams = new ContainerDialogFragment.OnInflateParams(paramAttributeSet, paramBundle, null);
    ShadowDialogFragment localShadowDialogFragment = this.mPluginFragment;
    if (localShadowDialogFragment != null) {
      localShadowDialogFragment.onInflate(paramAttributeSet, paramBundle);
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    this.mPluginFragment.onLowMemory();
  }
  
  @Deprecated
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    this.mPluginFragment.onMultiWindowModeChanged(paramBoolean);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    this.mPluginFragment.onMultiWindowModeChanged(paramBoolean, paramConfiguration);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return this.mPluginFragment.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onOptionsMenuClosed(Menu paramMenu)
  {
    this.mPluginFragment.onOptionsMenuClosed(paramMenu);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mPluginFragment.onPause();
  }
  
  @Deprecated
  public void onPictureInPictureModeChanged(boolean paramBoolean)
  {
    this.mPluginFragment.onPictureInPictureModeChanged(paramBoolean);
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean, Configuration paramConfiguration)
  {
    this.mPluginFragment.onPictureInPictureModeChanged(paramBoolean, paramConfiguration);
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    this.mPluginFragment.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.mPluginFragment.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    this.mPluginFragment.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mPluginFragment.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.mPluginFragment.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.mPluginFragment.onStop();
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    this.mPluginFragment.onTrimMemory(paramInt);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.mPluginFragment.onViewCreated(paramView, paramBundle);
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    this.mPluginFragment.onViewStateRestored(paramBundle);
  }
  
  public void postponeEnterTransition()
  {
    this.mPluginFragment.postponeEnterTransition();
  }
  
  public void registerForContextMenu(View paramView)
  {
    this.mPluginFragment.registerForContextMenu(paramView);
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    this.mPluginFragment.setAllowEnterTransitionOverlap(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    this.mPluginFragment.setAllowReturnTransitionOverlap(paramBoolean);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    if (!this.mIsAppCreateFragment)
    {
      this.mPluginFragment.setArguments(paramBundle);
      return;
    }
    super.setArguments(paramBundle);
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    this.mPluginFragment.setEnterSharedElementCallback(paramSharedElementCallback);
  }
  
  public void setEnterTransition(Transition paramTransition)
  {
    this.mPluginFragment.setEnterTransition(paramTransition);
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback)
  {
    this.mPluginFragment.setExitSharedElementCallback(paramSharedElementCallback);
  }
  
  public void setExitTransition(Transition paramTransition)
  {
    this.mPluginFragment.setExitTransition(paramTransition);
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.mPluginFragment.setHasOptionsMenu(paramBoolean);
  }
  
  public void setInitialSavedState(Fragment.SavedState paramSavedState)
  {
    this.mPluginFragment.setInitialSavedState(paramSavedState);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.mPluginFragment.setMenuVisibility(paramBoolean);
  }
  
  public void setReenterTransition(Transition paramTransition)
  {
    this.mPluginFragment.setReenterTransition(paramTransition);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.mPluginFragment.setRetainInstance(paramBoolean);
  }
  
  public void setReturnTransition(Transition paramTransition)
  {
    this.mPluginFragment.setReturnTransition(paramTransition);
  }
  
  public void setSharedElementEnterTransition(Transition paramTransition)
  {
    this.mPluginFragment.setSharedElementEnterTransition(paramTransition);
  }
  
  public void setSharedElementReturnTransition(Transition paramTransition)
  {
    this.mPluginFragment.setSharedElementReturnTransition(paramTransition);
  }
  
  public void setTargetFragment(Fragment paramFragment, int paramInt)
  {
    this.mPluginFragment.setTargetFragment(paramFragment, paramInt);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.mPluginFragment.setUserVisibleHint(paramBoolean);
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    return this.mPluginFragment.shouldShowRequestPermissionRationale(paramString);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.mPluginFragment.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    this.mPluginFragment.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.mPluginFragment.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    this.mPluginFragment.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    this.mPluginFragment.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startPostponedEnterTransition()
  {
    this.mPluginFragment.startPostponedEnterTransition();
  }
  
  public void superOnDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
  }
  
  public void superOnHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void superSetHasOptionsMenu(boolean paramBoolean)
  {
    super.setHasOptionsMenu(paramBoolean);
  }
  
  public void superSetMenuVisibility(boolean paramBoolean)
  {
    super.setMenuVisibility(paramBoolean);
  }
  
  public void superSetRetainInstance(boolean paramBoolean)
  {
    super.setRetainInstance(paramBoolean);
  }
  
  public void superSetUserVisibleHint(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 15) {
      super.setUserVisibleHint(paramBoolean);
    }
  }
  
  public String toString()
  {
    return this.mPluginFragment.toString();
  }
  
  public void unbindPluginFragment()
  {
    this.init = false;
    this.mPluginFragment = null;
  }
  
  public void unregisterForContextMenu(View paramView)
  {
    this.mPluginFragment.unregisterForContextMenu(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ContainerDialogFragment
 * JD-Core Version:    0.7.0.1
 */