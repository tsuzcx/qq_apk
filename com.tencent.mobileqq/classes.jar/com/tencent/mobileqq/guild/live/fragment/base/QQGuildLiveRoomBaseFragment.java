package com.tencent.mobileqq.guild.live.fragment.base;

import android.content.Context;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveRootControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;
import java.util.Iterator;
import java.util.List;

public abstract class QQGuildLiveRoomBaseFragment
  extends QQGuildLiveModuleBaseFragment
  implements IGuildLiveRootControl
{
  protected final QQGuildLiveModuleControl a = new QQGuildLiveModuleControl();
  
  protected void a(@IdRes int paramInt, @NonNull QQGuildLiveModuleBaseFragment paramQQGuildLiveModuleBaseFragment)
  {
    paramQQGuildLiveModuleBaseFragment.a(this);
    paramQQGuildLiveModuleBaseFragment.a(this.a);
    Fragment localFragment = getChildFragmentManager().findFragmentById(paramInt);
    if (localFragment != null) {
      getChildFragmentManager().beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    getChildFragmentManager().beginTransaction().replace(paramInt, paramQQGuildLiveModuleBaseFragment).commitAllowingStateLoss();
  }
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    this.a.a(this);
  }
  
  public boolean onBackEvent()
  {
    Iterator localIterator = getChildFragmentManager().getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (((localFragment instanceof QQGuildLiveModuleBaseFragment)) && (((QQGuildLiveModuleBaseFragment)localFragment).onBackEvent())) {
        return true;
      }
    }
    return super.onBackEvent();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveRoomBaseFragment
 * JD-Core Version:    0.7.0.1
 */