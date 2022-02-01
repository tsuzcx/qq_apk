package com.tencent.mobileqq.wink.pick.circle.part;

import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;

class WinkCirclePhotoListPart$PhotoPagerAdapter
  extends PagerAdapter
{
  private FragmentManager b;
  private FragmentTransaction c = null;
  private Fragment d = null;
  
  public WinkCirclePhotoListPart$PhotoPagerAdapter(WinkCirclePhotoListPart paramWinkCirclePhotoListPart, Fragment paramFragment)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      this.b = paramFragment.getChildFragmentManager();
      return;
    }
    this.b = paramFragment.getFragmentManager();
  }
  
  private String a(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android:switcher:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(":");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public Fragment a(int paramInt)
  {
    return (Fragment)WinkCirclePhotoListPart.g(this.a).get(paramInt);
  }
  
  public long b(int paramInt)
  {
    return paramInt;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.c == null) {
      this.c = this.b.beginTransaction();
    }
    this.c.detach((Fragment)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.c;
    if (paramViewGroup != null)
    {
      paramViewGroup.commitAllowingStateLoss();
      this.c = null;
      this.b.executePendingTransactions();
    }
  }
  
  public int getCount()
  {
    return WinkCirclePhotoListPart.g(this.a).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.c == null) {
      this.c = this.b.beginTransaction();
    }
    long l = b(paramInt);
    Object localObject = a(paramViewGroup.getId(), l);
    localObject = this.b.findFragmentByTag((String)localObject);
    if (localObject != null)
    {
      this.c.attach((Fragment)localObject);
      paramViewGroup = (ViewGroup)localObject;
    }
    else
    {
      localObject = a(paramInt);
      this.c.add(paramViewGroup.getId(), (Fragment)localObject, a(paramViewGroup.getId(), l));
      paramViewGroup = (ViewGroup)localObject;
    }
    if (paramViewGroup != this.d)
    {
      paramViewGroup.setMenuVisibility(false);
      paramViewGroup.setUserVisibleHint(false);
    }
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    paramObject = this.d;
    if (paramViewGroup != paramObject)
    {
      if (paramObject != null)
      {
        paramObject.setMenuVisibility(false);
        this.d.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.d = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.part.WinkCirclePhotoListPart.PhotoPagerAdapter
 * JD-Core Version:    0.7.0.1
 */