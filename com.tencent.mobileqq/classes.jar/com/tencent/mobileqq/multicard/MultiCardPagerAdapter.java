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
  private MultiCardContext a;
  private FragmentManager b;
  
  public MultiCardPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.b = paramFragmentManager;
  }
  
  public void a(MultiCardContext paramMultiCardContext)
  {
    this.a = paramMultiCardContext;
  }
  
  public void b()
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      if (this.a == null) {
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
            ((MultiCardItemFragment)localObject2).a(this.a.b(i));
          }
        }
      }
    }
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
    MultiCardContext localMultiCardContext = this.a;
    if (localMultiCardContext == null) {
      return 0;
    }
    return localMultiCardContext.b();
  }
  
  public Fragment getItem(int paramInt)
  {
    MultiCardItemFragment localMultiCardItemFragment = new MultiCardItemFragment();
    Object localObject = this.a;
    if (localObject != null) {
      localMultiCardItemFragment.a(((MultiCardContext)localObject).a, paramInt, this.a.b(paramInt), this.a.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPagerAdapter
 * JD-Core Version:    0.7.0.1
 */