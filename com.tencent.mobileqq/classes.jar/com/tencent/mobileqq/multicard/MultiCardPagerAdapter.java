package com.tencent.mobileqq.multicard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import axgc;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MultiCardPagerAdapter
  extends MultiAIOPagerAdapter
{
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private axgc jdField_a_of_type_Axgc;
  
  public MultiCardPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentManager == null) || (this.jdField_a_of_type_Axgc == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.getFragments();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Fragment)((Iterator)localObject1).next();
          if ((localObject2 instanceof MultiCardItemFragment))
          {
            localObject2 = (MultiCardItemFragment)localObject2;
            int i = ((MultiCardItemFragment)localObject2).a();
            if (i < getCount()) {
              ((MultiCardItemFragment)localObject2).a(this.jdField_a_of_type_Axgc.a(i));
            }
          }
        }
      }
    }
  }
  
  public void a(axgc paramaxgc)
  {
    this.jdField_a_of_type_Axgc = paramaxgc;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardPagerAdapter", 2, "destroyItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "], object = [" + paramObject + "]");
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Axgc == null) {
      return 0;
    }
    return this.jdField_a_of_type_Axgc.a();
  }
  
  public Fragment getItem(int paramInt)
  {
    MultiCardItemFragment localMultiCardItemFragment = new MultiCardItemFragment();
    if (this.jdField_a_of_type_Axgc != null) {
      localMultiCardItemFragment.a(this.jdField_a_of_type_Axgc.a, paramInt, this.jdField_a_of_type_Axgc.a(paramInt), this.jdField_a_of_type_Axgc.a());
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("KEY_POSITION", paramInt);
    localMultiCardItemFragment.setArguments(localBundle);
    return localMultiCardItemFragment;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (((paramObject instanceof MultiCardItemFragment)) && (((MultiCardItemFragment)paramObject).a() < getCount())) {
      return -1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardPagerAdapter", 2, "instantiateItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "]");
    }
    return super.instantiateItem(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPagerAdapter
 * JD-Core Version:    0.7.0.1
 */