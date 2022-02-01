package com.tencent.qcircle.shadow.core.runtime;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.Fragment.InstantiationException;
import android.app.Fragment.SavedState;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class ShadowFragment
{
  private static Map<String, Constructor<?>> constructorMap = new HashMap();
  private Context mAttachedContext;
  private PluginFragmentManager mChildPluginFragmentManager;
  private int mChildPluginFragmentManagerHash;
  protected IContainerFragment mContainerFragment = instantiateContainerFragment(this);
  protected boolean mIsAppCreateFragment;
  PluginFragmentManager mPluginFragmentManager;
  
  public ShadowFragment()
  {
    this.mContainerFragment.bindPluginFragment(this);
    this.mIsAppCreateFragment = true;
  }
  
  private static IContainerFragment instantiateContainerFragment(ShadowFragment paramShadowFragment)
  {
    Object localObject = paramShadowFragment.getClass().getName();
    String str = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    Constructor localConstructor = (Constructor)constructorMap.get(str);
    localObject = localConstructor;
    if (localConstructor == null)
    {
      paramShadowFragment = paramShadowFragment.getClass().getClassLoader();
      try
      {
        localObject = paramShadowFragment.loadClass(str).getConstructor(new Class[0]);
        constructorMap.put(str, localObject);
      }
      catch (Exception paramShadowFragment)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("无法构造");
        ((StringBuilder)localObject).append(str);
        throw new Fragment.InstantiationException(((StringBuilder)localObject).toString(), paramShadowFragment);
      }
    }
    try
    {
      paramShadowFragment = (IContainerFragment)IContainerFragment.class.cast(((Constructor)localObject).newInstance(new Object[0]));
      return paramShadowFragment;
    }
    catch (Exception paramShadowFragment)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("无法构造");
      ((StringBuilder)localObject).append(str);
      throw new Fragment.InstantiationException(((StringBuilder)localObject).toString(), paramShadowFragment);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {}
  
  public final ShadowActivity getActivity()
  {
    Context localContext = this.mAttachedContext;
    if (localContext == null) {
      return null;
    }
    if ((localContext instanceof ShadowActivity)) {
      return (ShadowActivity)localContext;
    }
    return (ShadowActivity)((PluginContainerActivity)this.mContainerFragment.getActivity()).getPluginActivity();
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    return false;
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    return false;
  }
  
  public final Bundle getArguments()
  {
    return this.mContainerFragment.getArguments();
  }
  
  public PluginFragmentManager getChildFragmentManager()
  {
    FragmentManager localFragmentManager = this.mContainerFragment.getChildFragmentManager();
    int i = System.identityHashCode(localFragmentManager);
    if (i != this.mChildPluginFragmentManagerHash)
    {
      this.mChildPluginFragmentManagerHash = i;
      this.mChildPluginFragmentManager = new PluginFragmentManager(localFragmentManager);
    }
    return this.mChildPluginFragmentManager;
  }
  
  public IContainerFragment getContainerFragment()
  {
    Object localObject = this.mContainerFragment;
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append(" mContainerFragment == null");
    throw new NullPointerException(((StringBuilder)localObject).toString());
  }
  
  public Context getContext()
  {
    return this.mAttachedContext;
  }
  
  public Transition getEnterTransition()
  {
    return null;
  }
  
  public Transition getExitTransition()
  {
    return null;
  }
  
  public PluginFragmentManager getFragmentManager()
  {
    if ((this.mPluginFragmentManager == null) && (getActivity() != null)) {
      this.mPluginFragmentManager = getActivity().getFragmentManager();
    }
    return this.mPluginFragmentManager;
  }
  
  public final int getId()
  {
    return this.mContainerFragment.getId();
  }
  
  public LoaderManager getLoaderManager()
  {
    return null;
  }
  
  public Transition getReenterTransition()
  {
    return null;
  }
  
  public final Resources getResources()
  {
    Object localObject = this.mAttachedContext;
    if (localObject != null) {
      return ((Context)localObject).getResources();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Fragment ");
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append(" not attached to Activity");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public Transition getReturnTransition()
  {
    return null;
  }
  
  public Transition getSharedElementEnterTransition()
  {
    return null;
  }
  
  public Transition getSharedElementReturnTransition()
  {
    return null;
  }
  
  public final String getString(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  public final String getTag()
  {
    return this.mContainerFragment.getTag();
  }
  
  public final CharSequence getText(int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  public boolean getUserVisibleHint()
  {
    return this.mContainerFragment.getUserVisibleHint();
  }
  
  public View getView()
  {
    return this.mContainerFragment.getView();
  }
  
  public final boolean isAdded()
  {
    return this.mContainerFragment.isAdded();
  }
  
  public final boolean isDetached()
  {
    return this.mContainerFragment.isDetached();
  }
  
  public final boolean isHidden()
  {
    return this.mContainerFragment.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return this.mContainerFragment.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return this.mContainerFragment.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return this.mContainerFragment.isResumed();
  }
  
  public final boolean isVisible()
  {
    return this.mContainerFragment.isVisible();
  }
  
  public void onActivityCreated(Bundle paramBundle) {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onAttach(Context paramContext)
  {
    this.mAttachedContext = paramContext;
  }
  
  public void onAttach(ShadowActivity paramShadowActivity)
  {
    this.mAttachedContext = paramShadowActivity;
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo) {}
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return null;
  }
  
  public void onDestroy() {}
  
  public void onDestroyOptionsMenu() {}
  
  public void onDestroyView() {}
  
  public void onDetach() {}
  
  public LayoutInflater onGetLayoutInflater(Bundle paramBundle)
  {
    return null;
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    this.mContainerFragment.superOnHiddenChanged(paramBoolean);
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle) {}
  
  public void onInflate(Context paramContext, AttributeSet paramAttributeSet, Bundle paramBundle) {}
  
  public void onInflate(AttributeSet paramAttributeSet, Bundle paramBundle) {}
  
  public void onLowMemory() {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean, Configuration paramConfiguration) {}
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  public void onOptionsMenuClosed(Menu paramMenu) {}
  
  public void onPause() {}
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  public void onPictureInPictureModeChanged(boolean paramBoolean, Configuration paramConfiguration) {}
  
  public void onPrepareOptionsMenu(Menu paramMenu) {}
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void onTrimMemory(int paramInt) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle) {}
  
  public void onViewStateRestored(Bundle paramBundle) {}
  
  public void postponeEnterTransition() {}
  
  public void registerForContextMenu(View paramView) {}
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt)
  {
    this.mContainerFragment.requestPermissions(paramArrayOfString, paramInt);
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean) {}
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean) {}
  
  public void setArguments(Bundle paramBundle)
  {
    if (this.mIsAppCreateFragment) {
      this.mContainerFragment.setArguments(paramBundle);
    }
  }
  
  public void setContainerFragment(IContainerFragment paramIContainerFragment)
  {
    this.mIsAppCreateFragment = false;
    this.mContainerFragment.unbindPluginFragment();
    this.mContainerFragment = paramIContainerFragment;
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback) {}
  
  public void setEnterTransition(Transition paramTransition) {}
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback) {}
  
  public void setExitTransition(Transition paramTransition) {}
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.mContainerFragment.superSetHasOptionsMenu(paramBoolean);
  }
  
  public void setInitialSavedState(Fragment.SavedState paramSavedState) {}
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.mContainerFragment.superSetMenuVisibility(paramBoolean);
  }
  
  public void setReenterTransition(Transition paramTransition) {}
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.mContainerFragment.superSetRetainInstance(paramBoolean);
  }
  
  public void setReturnTransition(Transition paramTransition) {}
  
  public void setSharedElementEnterTransition(Transition paramTransition) {}
  
  public void setSharedElementReturnTransition(Transition paramTransition) {}
  
  public void setTargetFragment(Fragment paramFragment, int paramInt) {}
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.mContainerFragment.superSetUserVisibleHint(paramBoolean);
  }
  
  public boolean shouldShowRequestPermissionRationale(String paramString)
  {
    return false;
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.mAttachedContext.startActivity(paramIntent);
  }
  
  @TargetApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    this.mAttachedContext.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt) {}
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle) {}
  
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) {}
  
  public void startPostponedEnterTransition() {}
  
  public void unregisterForContextMenu(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowFragment
 * JD-Core Version:    0.7.0.1
 */