package com.tencent.mobileqq.multiaio.widget;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MultiAIOPagerAdapter
  extends FragmentStatePagerAdapter
{
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public MultiAIOPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  private ArrayList<Fragment> a()
  {
    try
    {
      Object localObject = FragmentStatePagerAdapter.class.getDeclaredField("mFragments");
      ((Field)localObject).setAccessible(true);
      localObject = (ArrayList)((Field)localObject).get(this);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOPagerAdapter", 1, "getFragments: ", localException);
    }
    return null;
  }
  
  public List<RecentBaseData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = a();
    if (localArrayList == null) {
      QLog.e("MultiAIOPagerAdapter", 1, "updateMsgRead: mFragments == null");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < localArrayList.size())
      {
        Fragment localFragment = (Fragment)localArrayList.get(i);
        if ((localFragment != null) && ((localFragment instanceof MultiAIOItemFragment))) {
          ((MultiAIOItemFragment)localFragment).a(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = a();
    if (localArrayList == null) {
      QLog.e("MultiAIOPagerAdapter", 1, "scrollToNewMsg: mFragments == null");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < localArrayList.size())
      {
        Fragment localFragment = (Fragment)localArrayList.get(i);
        if ((localFragment != null) && ((localFragment instanceof MultiAIOItemFragment))) {
          ((MultiAIOItemFragment)localFragment).b(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOPagerAdapter", 2, "destroyItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "], object = [" + paramObject + "]");
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    MultiAIOItemFragment localMultiAIOItemFragment = new MultiAIOItemFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("KEY_POSITION", paramInt);
    localMultiAIOItemFragment.setArguments(localBundle);
    return localMultiAIOItemFragment;
  }
  
  public float getPageWidth(int paramInt)
  {
    return super.getPageWidth(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOPagerAdapter", 2, "instantiateItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "]");
    }
    return super.instantiateItem(paramViewGroup, paramInt);
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    this.jdField_a_of_type_AndroidSupportV4AppFragment = ((Fragment)paramObject);
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    super.startUpdate(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter
 * JD-Core Version:    0.7.0.1
 */