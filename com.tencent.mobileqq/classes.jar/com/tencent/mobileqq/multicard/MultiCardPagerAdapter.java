package com.tencent.mobileqq.multicard;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MultiCardPagerAdapter
  extends MultiAIOPagerAdapter
{
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private MultiCardContext jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
  
  public MultiCardPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = paramFragmentManager;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext == null) {
        return;
      }
      localObject1 = ((FragmentManager)localObject1).getFragments();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Fragment)((Iterator)localObject1).next();
        if ((localObject2 instanceof MultiCardItemFragment))
        {
          localObject2 = (MultiCardItemFragment)localObject2;
          int i = ((MultiCardItemFragment)localObject2).a();
          if (i < getCount()) {
            ((MultiCardItemFragment)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a(i));
          }
        }
      }
    }
  }
  
  public void a(MultiCardContext paramMultiCardContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext = paramMultiCardContext;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroyItem() called with: container = [");
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append("], position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], object = [");
      localStringBuilder.append(paramObject);
      localStringBuilder.append("]");
      QLog.d("MultiCardPagerAdapter", 2, localStringBuilder.toString());
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount()
  {
    MultiCardContext localMultiCardContext = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
    if (localMultiCardContext == null) {
      return 0;
    }
    return localMultiCardContext.a();
  }
  
  public Fragment getItem(int paramInt)
  {
    MultiCardItemFragment localMultiCardItemFragment = new MultiCardItemFragment();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext;
    if (localObject != null) {
      localMultiCardItemFragment.a(((MultiCardContext)localObject).a, paramInt, this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a(paramInt), this.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardContext.a());
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("KEY_POSITION", paramInt);
    localMultiCardItemFragment.setArguments((Bundle)localObject);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("instantiateItem() called with: container = [");
      localStringBuilder.append(paramViewGroup);
      localStringBuilder.append("], position = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.d("MultiCardPagerAdapter", 2, localStringBuilder.toString());
    }
    return super.instantiateItem(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPagerAdapter
 * JD-Core Version:    0.7.0.1
 */