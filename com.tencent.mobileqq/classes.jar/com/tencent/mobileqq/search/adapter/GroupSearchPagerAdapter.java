package com.tencent.mobileqq.search.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GroupSearchPagerAdapter
  extends PagerAdapter
{
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private final FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private FragmentTransaction jdField_a_of_type_AndroidSupportV4AppFragmentTransaction;
  List jdField_a_of_type_JavaUtilList;
  
  private static String a(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }
  
  public long a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt) instanceof ActiveEntitySearchFragment)) {
      return ((Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt)).hashCode();
    }
    return paramInt;
  }
  
  public Fragment a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (this.jdField_a_of_type_JavaUtilList.size() <= paramInt))
    {
      QLog.e("GroupSearchPagerAdapter", 2, "error! fragments==null || position<0 || fragments.size()<=position !");
      return ActiveEntitySearchFragment.a(0, new long[] { 0L }, "", "");
    }
    return (Fragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    }
    if ((paramObject instanceof ActiveEntitySearchFragment)) {
      QLog.i("Q.uniteSearch.", 2, "Detaching item hash = " + paramObject.hashCode() + "  Detaching item name:" + ((ActiveEntitySearchFragment)paramObject).e);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.remove((Fragment)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = null;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.executePendingTransactions();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (paramObject == this.jdField_a_of_type_JavaUtilList.get(i)) {
        return i;
      }
      i += 1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction == null) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    }
    long l = a(paramInt);
    Object localObject = a(paramViewGroup.getId(), l);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null)
    {
      if ((localObject instanceof ActiveEntitySearchFragment)) {
        QLog.i("Q.uniteSearch.", 2, "Attaching item hash = " + ((Fragment)localObject).hashCode() + "   Attaching item  name:" + ((ActiveEntitySearchFragment)localObject).e);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.attach((Fragment)localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.jdField_a_of_type_AndroidSupportV4AppFragment)
      {
        paramViewGroup.setMenuVisibility(false);
        paramViewGroup.setUserVisibleHint(false);
      }
      return paramViewGroup;
      localObject = a(paramInt);
      if ((localObject instanceof ActiveEntitySearchFragment)) {
        QLog.i("Q.uniteSearch.", 2, "Adding item hash = " + ((Fragment)localObject).hashCode() + "   Adding item  name:" + ((ActiveEntitySearchFragment)localObject).e);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentTransaction.add(paramViewGroup.getId(), (Fragment)localObject, a(paramViewGroup.getId(), l));
    }
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
    if (paramViewGroup != this.jdField_a_of_type_AndroidSupportV4AppFragment)
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragment.setMenuVisibility(false);
        this.jdField_a_of_type_AndroidSupportV4AppFragment.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      if ((paramObject instanceof ActiveEntitySearchFragment)) {
        QLog.i("Q.uniteSearch.", 2, "setPrimaryItem hash = " + paramObject.hashCode() + "  pos=" + paramInt + "  setPrimaryItem name:" + ((ActiveEntitySearchFragment)paramObject).e);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragment = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchPagerAdapter
 * JD-Core Version:    0.7.0.1
 */