package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.flashshow.adapter.FSMultiTabFragmentAdapter;
import com.tencent.mobileqq.flashshow.fragment.FSBaseFragment;
import com.tencent.mobileqq.flashshow.fragment.FSMainFragment;
import com.tencent.mobileqq.flashshow.ioc.IFSFolderIoc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class FSFolderFragmentPart
  extends FSBasePart
  implements SimpleEventReceiver, IFSFolderIoc
{
  private ViewPagerCompat a;
  private FSMultiTabFragmentAdapter b;
  private final ArrayList<FSBaseFragment> c = new ArrayList();
  private int d = 0;
  
  private void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof Boolean)) {
        return;
      }
      ViewPagerCompat localViewPagerCompat = this.a;
      if (localViewPagerCompat != null) {
        localViewPagerCompat.setScrollable(((Boolean)paramVarArgs[0]).booleanValue());
      }
    }
  }
  
  private void d()
  {
    FSMainFragment localFSMainFragment = new FSMainFragment();
    localFSMainFragment.a(this);
    this.c.add(localFSMainFragment);
  }
  
  private void f()
  {
    this.a.addOnPageChangeListener(new FSFolderFragmentPart.1(this));
  }
  
  public String a()
  {
    return "FSFolderFragmentPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b = new FSMultiTabFragmentAdapter(j().getChildFragmentManager());
    this.a = ((ViewPagerCompat)paramView.findViewById(2131433851));
    this.a.setAdapter(this.b);
    this.a.setOffscreenPageLimit(3);
    f();
    d();
    this.b.a(this.c);
    this.b.notifyDataSetChanged();
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    if (TextUtils.equals(paramString, "event_set_viewpager_enable")) {
      a(paramVarArgs);
    }
  }
  
  public boolean ah_()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    if (((ViewPagerCompat)localObject).getCurrentItem() != 0)
    {
      this.a.setCurrentItem(0);
      return true;
    }
    localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      FSBaseFragment localFSBaseFragment = (FSBaseFragment)((Iterator)localObject).next();
      if ((localFSBaseFragment != null) && (localFSBaseFragment.onBackEvent())) {
        return true;
      }
    }
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return super.b(paramString, paramObject);
  }
  
  public int e()
  {
    ViewPagerCompat localViewPagerCompat = this.a;
    if (localViewPagerCompat != null) {
      return localViewPagerCompat.getCurrentItem();
    }
    return -1;
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public void k()
  {
    super.k();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      FSBaseFragment localFSBaseFragment = (FSBaseFragment)localIterator.next();
      if (localFSBaseFragment != null) {
        localFSBaseFragment.beforeFinish();
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if (this.c == null) {
      return;
    }
    QLog.d("FSFolderFragmentPart", 1, "fs_lifecycle onActivityDestroyed");
    paramActivity = this.c.iterator();
    while (paramActivity.hasNext()) {
      ((FSBaseFragment)paramActivity.next()).onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.a != null)
    {
      if (this.c == null) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityPaused  mFolderViewPagerIndex = ");
      paramActivity.append(this.a.getCurrentItem());
      QLog.d("FSFolderFragmentPart", 1, paramActivity.toString());
      if (this.c.size() > this.a.getCurrentItem()) {
        ((FSBaseFragment)this.c.get(this.a.getCurrentItem())).onPause();
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.a != null)
    {
      if (this.c == null) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityResumed  mFolderViewPagerIndex = ");
      paramActivity.append(this.a.getCurrentItem());
      QLog.d("FSFolderFragmentPart", 1, paramActivity.toString());
      if (this.c.size() > this.a.getCurrentItem()) {
        ((FSBaseFragment)this.c.get(this.a.getCurrentItem())).onResume();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    if (this.a != null)
    {
      if (this.c == null) {
        return;
      }
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityStopped  mFolderViewPagerIndex = ");
      paramActivity.append(this.a.getCurrentItem());
      QLog.d("FSFolderFragmentPart", 1, paramActivity.toString());
      if (this.c.size() > this.a.getCurrentItem()) {
        ((FSBaseFragment)this.c.get(this.a.getCurrentItem())).onStop();
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSFolderFragmentPart
 * JD-Core Version:    0.7.0.1
 */