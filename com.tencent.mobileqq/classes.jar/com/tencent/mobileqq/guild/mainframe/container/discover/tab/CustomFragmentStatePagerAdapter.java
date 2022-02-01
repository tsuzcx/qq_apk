package com.tencent.mobileqq.guild.mainframe.container.discover.tab;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomFragmentStatePagerAdapter
  extends PagerAdapter
{
  private final FragmentManager a;
  private FragmentTransaction b = null;
  private ArrayList<Fragment.SavedState> c = new ArrayList();
  private ArrayList<Fragment> d = new ArrayList();
  private Fragment e = null;
  
  public CustomFragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.a = paramFragmentManager;
  }
  
  public void a()
  {
    this.c.clear();
    this.d.clear();
  }
  
  public abstract Fragment b(int paramInt);
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.b == null) {
      this.b = this.a.beginTransaction();
    }
    if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("Removing item #");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(": f=");
      paramViewGroup.append(paramObject);
      paramViewGroup.append(" v=");
      paramViewGroup.append(localFragment.getView());
      QLog.d("FragmentStatePagerAdapter", 2, paramViewGroup.toString());
    }
    while (this.c.size() <= paramInt) {
      this.c.add(null);
    }
    paramObject = this.c;
    if (localFragment.isAdded()) {
      paramViewGroup = this.a.saveFragmentInstanceState(localFragment);
    } else {
      paramViewGroup = null;
    }
    paramObject.set(paramInt, paramViewGroup);
    if ((paramInt >= 0) && (paramInt < this.d.size())) {
      this.d.set(paramInt, null);
    }
    this.b.remove(localFragment);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.b;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitAllowingStateLoss();
      this.b = null;
    }
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.d.size() > paramInt)
    {
      localFragment = (Fragment)this.d.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (this.b == null) {
      this.b = this.a.beginTransaction();
    }
    Fragment localFragment = b(paramInt);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Adding item #");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(": f=");
      ((StringBuilder)localObject).append(localFragment);
      QLog.d("FragmentStatePagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (localFragment != null)
    {
      if (this.c.size() > paramInt)
      {
        localObject = (Fragment.SavedState)this.c.get(paramInt);
        if (localObject != null) {
          localFragment.setInitialSavedState((Fragment.SavedState)localObject);
        }
      }
      while (this.d.size() <= paramInt) {
        this.d.add(null);
      }
      localFragment.setMenuVisibility(false);
      localFragment.setUserVisibleHint(false);
      this.d.set(paramInt, localFragment);
      if (!localFragment.isAdded()) {
        this.b.add(paramViewGroup.getId(), localFragment);
      }
    }
    return localFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      QLog.d("FragmentStatePagerAdapter", 2, "restoreState");
      Bundle localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      paramParcelable = localBundle.getParcelableArray("states");
      this.c.clear();
      this.d.clear();
      int i;
      if (paramParcelable != null)
      {
        i = 0;
        while (i < paramParcelable.length)
        {
          this.c.add((Fragment.SavedState)paramParcelable[i]);
          i += 1;
        }
      }
      paramClassLoader = localBundle.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        String str = (String)paramClassLoader.next();
        if (str.startsWith("guild_f"))
        {
          i = Integer.parseInt(str.substring(1));
          StringBuilder localStringBuilder;
          try
          {
            if (this.a.getFragments() != null) {
              paramParcelable = this.a.getFragment(localBundle, str);
            }
          }
          catch (Exception paramParcelable)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreState error: ");
            localStringBuilder.append(paramParcelable.getMessage());
            QLog.e("FragmentStatePagerAdapter", 1, localStringBuilder.toString());
            paramParcelable = null;
          }
          if (paramParcelable != null)
          {
            while (this.d.size() <= i) {
              this.d.add(null);
            }
            paramParcelable.setMenuVisibility(false);
            this.d.set(i, paramParcelable);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreState key: ");
            localStringBuilder.append(str);
            localStringBuilder.append("  ");
            localStringBuilder.append(paramParcelable);
            QLog.d("FragmentStatePagerAdapter", 2, localStringBuilder.toString());
          }
          else
          {
            paramParcelable = new StringBuilder();
            paramParcelable.append("Bad fragment at key ");
            paramParcelable.append(str);
            QLog.d("FragmentStatePagerAdapter", 2, paramParcelable.toString());
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject2;
    Object localObject1;
    if (this.c.size() > 0)
    {
      localObject2 = new Bundle();
      localObject1 = new Fragment.SavedState[this.c.size()];
      this.c.toArray((Object[])localObject1);
      ((Bundle)localObject2).putParcelableArray("states", (Parcelable[])localObject1);
    }
    else
    {
      localObject2 = null;
    }
    int i = 0;
    Object localObject3;
    while (i < this.d.size())
    {
      Object localObject4 = (Fragment)this.d.get(i);
      localObject1 = localObject2;
      if (localObject4 != null)
      {
        localObject1 = localObject2;
        if (((Fragment)localObject4).isAdded())
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("guild_f");
          ((StringBuilder)localObject2).append(i);
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("saveState key: ");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("  ");
          localStringBuilder.append(localObject4);
          QLog.d("FragmentStatePagerAdapter", 2, localStringBuilder.toString());
          try
          {
            this.a.putFragment((Bundle)localObject1, (String)localObject2, (Fragment)localObject4);
          }
          catch (Exception localException)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("saveState error: ");
            ((StringBuilder)localObject4).append(localException.getMessage());
            QLog.e("FragmentStatePagerAdapter", 1, ((StringBuilder)localObject4).toString());
          }
        }
      }
      i += 1;
      localObject3 = localObject1;
    }
    return localObject3;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramObject = this.e;
    if (paramViewGroup != paramObject)
    {
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(false);
        this.e.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.e = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("ViewPager with adapter ");
    paramViewGroup.append(this);
    paramViewGroup.append(" requires a view id");
    throw new IllegalStateException(paramViewGroup.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.tab.CustomFragmentStatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */