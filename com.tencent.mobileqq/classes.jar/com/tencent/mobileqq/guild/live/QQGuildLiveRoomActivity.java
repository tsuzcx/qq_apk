package com.tencent.mobileqq.guild.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class QQGuildLiveRoomActivity
  extends BaseActivity
{
  private static ArrayMap<String, QQGuildLiveRoomActivity.IViewCreator> b = new ArrayMap();
  private QPublicBaseFragment a;
  private ClassLoader c = null;
  
  private QPublicBaseFragment a()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    if (QLog.isColorLevel()) {
      QLog.d("QQGuildLiveRoomActivity", 2, new Object[] { "creating fragment ", localObject });
    }
    try
    {
      localObject = (QPublicBaseFragment)Class.forName((String)localObject).newInstance();
      ((QPublicBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mobileqq.activity.CrashReportConstant.a = Log.getStackTraceString(localException);
      QLog.e("QQGuildLiveRoomActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {}
    try
    {
      Object localObject2 = Class.forName("androidx.fragment.app.FragmentManagerState");
      paramBundle = Class.forName("androidx.fragment.app.FragmentState");
      if (!((Class)localObject2).isInstance(localObject1)) {
        break label188;
      }
      localObject2 = ((Class)localObject2).getDeclaredField("mActive");
      if (!((Field)localObject2).isAccessible()) {
        ((Field)localObject2).setAccessible(true);
      }
      if (!((Field)localObject2).getType().isArray()) {
        break label188;
      }
      localObject1 = ((Field)localObject2).get(localObject1);
      int j = Array.getLength(localObject1);
      int i = 0;
      while (i < j)
      {
        localObject2 = Array.get(localObject1, i);
        if ((localObject2 != null) && (paramBundle.isInstance(localObject2)))
        {
          Field localField = paramBundle.getDeclaredField("mArguments");
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          localObject2 = localField.get(localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof Bundle))) {
            ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
          }
        }
        i += 1;
      }
    }
    catch (Exception paramBundle)
    {
      label180:
      label188:
      break label180;
    }
    QLog.d("QQGuildLiveRoomActivity", 2, "Patch error");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if ((localQPublicBaseFragment != null) && (localQPublicBaseFragment.needDispatchTouchEvent()) && (this.a.dispatchTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onActivityResult(paramInt1 & 0xFFFF, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.a = a();
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null)
    {
      this.mNeedStatusTrans = localQPublicBaseFragment.needStatusTrans();
      this.mActNeedImmersive = this.a.needImmersive();
      this.a.initWindowStyleAndAnimation(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGuildLiveRoomActivity", 1, "Activity restored, set classloader.");
      }
      a(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131624037);
    if (this.a == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131433667, this.a);
    paramBundle.commitAllowingStateLoss();
    this.a.initSideFling(this, this.mFlingHandler);
    return true;
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if ((localQPublicBaseFragment != null) && (localQPublicBaseFragment.doOnKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onNewIntent(paramIntent);
    }
  }
  
  public void finish()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if ((localQPublicBaseFragment == null) || (!localQPublicBaseFragment.overrideFinish())) {
      superFinish();
    }
  }
  
  public String getCIOPageName()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      return localQPublicBaseFragment.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject = super.getClassLoader();
    ClassLoader localClassLoader2 = this.c;
    ClassLoader localClassLoader1 = localClassLoader2;
    if (localClassLoader2 == null) {
      localClassLoader1 = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    }
    if (localClassLoader1 != null)
    {
      this.c = localClassLoader1;
      localObject = localClassLoader1;
    }
    return localObject;
  }
  
  public boolean isSupportScreenShot()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    return (localQPublicBaseFragment == null) || (localQPublicBaseFragment.isSupportScreenShot());
  }
  
  protected boolean isWrapContent()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      return localQPublicBaseFragment.isWrapContent();
    }
    return super.isWrapContent();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onAccountChanged();
    }
  }
  
  protected boolean onBackEvent()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return localQPublicBaseFragment.onBackEvent();
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (b.containsKey(paramString))
    {
      View localView = ((QQGuildLiveRoomActivity.IViewCreator)b.get(paramString)).a(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onPreThemeChanged();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null)
    {
      paramBundle.remove("android:viewHierarchyState");
      paramBundle.remove("android:fragments");
      paramBundle.remove("android:support:fragments");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onWindowFocusChanged(paramBoolean);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  public void superFinish()
  {
    QPublicBaseFragment localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.beforeFinish();
    }
    super.finish();
    localQPublicBaseFragment = this.a;
    if (localQPublicBaseFragment != null) {
      localQPublicBaseFragment.onFinish();
    }
  }
  
  public String toString()
  {
    String str = super.toString();
    if (this.a != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(this.a.getClass().getName());
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(Integer.toHexString(this.a.hashCode()));
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (getIntent() != null)
    {
      localObject = str;
      if (getIntent().getStringExtra("public_fragment_class") != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(getIntent().getStringExtra("public_fragment_class"));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.QQGuildLiveRoomActivity
 * JD-Core Version:    0.7.0.1
 */