package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.QQGuildDiscoverFragment;
import com.tencent.mobileqq.guild.mainframe.container.discover.view.HeaderScrollHelper.ScrollableContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public abstract class QQGuildDiscoverBaseSubTabFragment
  extends QBaseFragment
  implements HeaderScrollHelper.ScrollableContainer, AbsListView.OnScrollListener
{
  public static Rect a;
  protected QQGuildDiscoverBaseSubTabFragment.RefreshDataListener b;
  protected QQGuildDiscoverBaseSubTabFragment.FragmentLifeListener c;
  protected AppInterface d;
  protected View e;
  public boolean f;
  public boolean g;
  protected QBaseActivity h;
  protected boolean i = false;
  protected QQGuildDiscoverFragment j;
  private int k;
  private int l;
  
  protected abstract View a(LayoutInflater paramLayoutInflater, Bundle paramBundle);
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    AppInterface localAppInterface = this.d;
    if ((localAppInterface != null) && (paramAppInterface != localAppInterface)) {
      d();
    }
    this.d = paramAppInterface;
    c();
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    this.h = paramQBaseActivity;
  }
  
  public void a(QQGuildDiscoverFragment paramQQGuildDiscoverFragment)
  {
    this.j = paramQQGuildDiscoverFragment;
  }
  
  public void a(QQGuildDiscoverBaseSubTabFragment.FragmentLifeListener paramFragmentLifeListener)
  {
    this.c = paramFragmentLifeListener;
  }
  
  public void a(QQGuildDiscoverBaseSubTabFragment.RefreshDataListener paramRefreshDataListener)
  {
    this.b = paramRefreshDataListener;
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b();
  
  public void b(int paramInt)
  {
    this.l = paramInt;
  }
  
  public abstract void b(boolean paramBoolean);
  
  protected abstract void c();
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.f = paramBoolean;
    if (this.e != null)
    {
      if (paramBoolean)
      {
        a(true);
        return;
      }
      b(true);
    }
  }
  
  protected abstract void d();
  
  public void e()
  {
    if (this.d != null) {
      d();
    }
  }
  
  public int f()
  {
    return this.k;
  }
  
  public int g()
  {
    return this.l;
  }
  
  public View h()
  {
    return this.e;
  }
  
  public void onAttach(Activity paramActivity)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(g());
      localStringBuilder.append(" onAttach");
      QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, localStringBuilder.toString());
    }
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(g());
      localStringBuilder.append(" onCreate");
      QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, localStringBuilder.toString());
    }
    super.onCreate(paramBundle);
  }
  
  @TargetApi(16)
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("pos:");
      paramViewGroup.append(g());
      paramViewGroup.append(" onCreateView");
      QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, paramViewGroup.toString());
    }
    this.e = a(paramLayoutInflater, paramBundle);
    paramLayoutInflater = h();
    if ((paramLayoutInflater != null) && (Build.VERSION.SDK_INT >= 14)) {
      paramLayoutInflater.setAccessibilityDelegate(new QQGuildDiscoverBaseSubTabFragment.1(this));
    }
    if ((this.e != null) && (this.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, "onCreateView->doOnResume");
      }
      this.f = false;
      a(true);
    }
    if ((this.e != null) && (g() == 0)) {
      a(true);
    }
    paramLayoutInflater = this.e;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pos:");
      ((StringBuilder)localObject).append(g());
      ((StringBuilder)localObject).append(" onDestroy");
      QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, ((StringBuilder)localObject).toString());
    }
    super.onDestroy();
    if (this.d != null) {
      d();
    }
    this.e = null;
    this.f = false;
    Object localObject = this.c;
    if (localObject != null) {
      ((QQGuildDiscoverBaseSubTabFragment.FragmentLifeListener)localObject).a(this.k);
    }
  }
  
  public void onDestroyView()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(g());
      localStringBuilder.append(" onDestroyView");
      QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, localStringBuilder.toString());
    }
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pos:");
      localStringBuilder.append(g());
      localStringBuilder.append(" onDetach");
      QLog.d("GuildDiscover.QQChannelDiscoverBaseSubTabFragment", 2, localStringBuilder.toString());
    }
    super.onDetach();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverBaseSubTabFragment
 * JD-Core Version:    0.7.0.1
 */