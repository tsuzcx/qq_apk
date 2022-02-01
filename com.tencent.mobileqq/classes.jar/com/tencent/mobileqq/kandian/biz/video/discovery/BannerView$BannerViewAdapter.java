package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public abstract class BannerView$BannerViewAdapter<T, V extends View>
  extends PagerAdapter
{
  protected List<T> a;
  private SparseArray<V> b;
  
  public int a()
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() != 0))
    {
      if (this.a.size() == 1) {
        return 1;
      }
      return this.a.size() + 2;
    }
    return 0;
  }
  
  public V a(int paramInt)
  {
    View localView = (View)this.b.get(paramInt);
    if ((localView == null) && (b() > 1))
    {
      if (paramInt == 0)
      {
        localObject = this.a;
        localObject = ((List)localObject).get(((List)localObject).size() - 1);
      }
      else if (paramInt == this.a.size() + 1)
      {
        localObject = this.a.get(0);
      }
      else
      {
        localObject = this.a.get(paramInt - 1);
      }
      localObject = a(paramInt, localObject);
      this.b.put(paramInt, localObject);
      return localObject;
    }
    Object localObject = localView;
    if (localView == null)
    {
      localObject = localView;
      if (b() == 1)
      {
        localObject = a(paramInt, this.a.get(0));
        this.b.put(paramInt, localObject);
      }
    }
    return localObject;
  }
  
  public abstract V a(int paramInt, T paramT);
  
  public int b()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public boolean c()
  {
    List localList = this.a;
    return (localList == null) || (localList.size() == 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.discovery.BannerView.BannerViewAdapter
 * JD-Core Version:    0.7.0.1
 */