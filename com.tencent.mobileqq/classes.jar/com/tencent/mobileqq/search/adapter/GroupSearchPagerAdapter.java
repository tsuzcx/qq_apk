package com.tencent.mobileqq.search.adapter;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GroupSearchPagerAdapter
  extends PagerAdapter
{
  List<Fragment> a;
  private final FragmentManager b;
  private FragmentTransaction c;
  private Fragment d;
  
  private static String a(int paramInt, long paramLong)
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
    List localList = this.a;
    if ((localList != null) && (paramInt >= 0) && (localList.size() > paramInt)) {
      return (Fragment)this.a.get(paramInt);
    }
    QLog.e("GroupSearchPagerAdapter", 2, "error! fragments==null || position<0 || fragments.size()<=position !");
    return ActiveEntitySearchFragment.a(0, new long[] { 0L }, "", "");
  }
  
  public long b(int paramInt)
  {
    if ((this.a.get(paramInt) instanceof ActiveEntitySearchFragment)) {
      return ((Fragment)this.a.get(paramInt)).hashCode();
    }
    return paramInt;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.c == null) {
      this.c = this.b.beginTransaction();
    }
    if ((paramObject instanceof ActiveEntitySearchFragment))
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("Detaching item hash = ");
      paramViewGroup.append(paramObject.hashCode());
      paramViewGroup.append("  Detaching item name:");
      paramViewGroup.append(((ActiveEntitySearchFragment)paramObject).N);
      QLog.i("Q.uniteSearch.", 2, paramViewGroup.toString());
    }
    this.c.remove((Fragment)paramObject);
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
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (paramObject == this.a.get(i)) {
        return i;
      }
      i += 1;
    }
    return -2;
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
      if ((localObject instanceof ActiveEntitySearchFragment))
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("Attaching item hash = ");
        paramViewGroup.append(((Fragment)localObject).hashCode());
        paramViewGroup.append("   Attaching item  name:");
        paramViewGroup.append(((ActiveEntitySearchFragment)localObject).N);
        QLog.i("Q.uniteSearch.", 2, paramViewGroup.toString());
      }
      this.c.attach((Fragment)localObject);
      paramViewGroup = (ViewGroup)localObject;
    }
    else
    {
      localObject = a(paramInt);
      if ((localObject instanceof ActiveEntitySearchFragment))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Adding item hash = ");
        localStringBuilder.append(((Fragment)localObject).hashCode());
        localStringBuilder.append("   Adding item  name:");
        localStringBuilder.append(((ActiveEntitySearchFragment)localObject).N);
        QLog.i("Q.uniteSearch.", 2, localStringBuilder.toString());
      }
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
    Object localObject = this.d;
    if (paramViewGroup != localObject)
    {
      if (localObject != null)
      {
        ((Fragment)localObject).setMenuVisibility(false);
        this.d.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      if ((paramObject instanceof ActiveEntitySearchFragment))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setPrimaryItem hash = ");
        ((StringBuilder)localObject).append(paramObject.hashCode());
        ((StringBuilder)localObject).append("  pos=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("  setPrimaryItem name:");
        ((StringBuilder)localObject).append(((ActiveEntitySearchFragment)paramObject).N);
        QLog.i("Q.uniteSearch.", 2, ((StringBuilder)localObject).toString());
      }
      this.d = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchPagerAdapter
 * JD-Core Version:    0.7.0.1
 */