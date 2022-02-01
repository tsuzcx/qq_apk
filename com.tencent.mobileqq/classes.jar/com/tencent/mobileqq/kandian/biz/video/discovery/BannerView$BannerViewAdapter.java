package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public abstract class BannerView$BannerViewAdapter<T, V extends View>
  extends PagerAdapter
{
  private SparseArray<V> a;
  protected List<T> a;
  
  public int a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() != 0))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
        return 1;
      }
      return this.jdField_a_of_type_JavaUtilList.size() + 2;
    }
    return 0;
  }
  
  public V a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localView == null) && (b() > 1))
    {
      if (paramInt == 0)
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        localObject = ((List)localObject).get(((List)localObject).size() - 1);
      }
      else if (paramInt == this.jdField_a_of_type_JavaUtilList.size() + 1)
      {
        localObject = this.jdField_a_of_type_JavaUtilList.get(0);
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
      }
      localObject = a(paramInt, localObject);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      return localObject;
    }
    Object localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (b() == 1)
      {
        localObject = a(paramInt, this.jdField_a_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      }
    }
    return localObject;
  }
  
  public abstract V a(int paramInt, T paramT);
  
  public boolean a()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    return (localList == null) || (localList.size() == 0);
  }
  
  public int b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof View)) {
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return a();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = a(paramInt);
    if ((localView != null) && (paramViewGroup != null)) {
      paramViewGroup.addView(localView);
    }
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BannerView.BannerViewAdapter
 * JD-Core Version:    0.7.0.1
 */