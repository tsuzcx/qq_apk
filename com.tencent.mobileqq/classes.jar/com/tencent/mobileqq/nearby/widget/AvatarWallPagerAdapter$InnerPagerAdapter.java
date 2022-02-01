package com.tencent.mobileqq.nearby.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class AvatarWallPagerAdapter$InnerPagerAdapter
  extends PagerAdapter
{
  List<Integer> a = new ArrayList();
  
  protected AvatarWallPagerAdapter$InnerPagerAdapter(AvatarWallPagerAdapter paramAvatarWallPagerAdapter) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    paramViewGroup = this.b;
    paramViewGroup.a(paramViewGroup.a(paramInt), paramObject);
  }
  
  public int getCount()
  {
    return this.b.h.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (AvatarWallPagerAdapter.ViewHolder)((View)paramObject).getTag(2131446791);
    int i = 0;
    while (i < this.b.h.size())
    {
      if ((this.b.a(paramObject.a, this.b.h.get(i))) && (!this.a.contains(Integer.valueOf(i))))
      {
        this.a.add(Integer.valueOf(i));
        return i;
      }
      i += 1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = getCount();
    if (i > 1) {
      if (paramInt == 1)
      {
        if (paramViewGroup == null)
        {
          if ((this.b.f != null) && (this.b.f.get() != null) && (((View)this.b.f.get()).getParent() == null)) {
            return this.b.f.get();
          }
        }
        else
        {
          if ((this.b.f != null) && (this.b.f.get() != null) && (((View)this.b.f.get()).getParent() == null))
          {
            localObject = (View)this.b.f.get();
          }
          else
          {
            localObject = (View)instantiateItem(null, paramInt);
            this.b.f = new SoftReference(localObject);
          }
          paramViewGroup.addView((View)localObject);
          return localObject;
        }
      }
      else if (paramInt == i - 2) {
        if (paramViewGroup == null)
        {
          if ((this.b.g != null) && (this.b.g.get() != null) && (((View)this.b.g.get()).getParent() == null)) {
            return this.b.g;
          }
        }
        else
        {
          if ((this.b.g != null) && (this.b.g.get() != null) && (((View)this.b.g.get()).getParent() == null))
          {
            localObject = (View)this.b.g.get();
          }
          else
          {
            localObject = (View)instantiateItem(null, paramInt);
            this.b.g = new SoftReference(localObject);
          }
          paramViewGroup.addView((View)localObject);
          return localObject;
        }
      }
    }
    Object localObject = this.b;
    localObject = ((AvatarWallPagerAdapter)localObject).a(((AvatarWallPagerAdapter)localObject).a(paramInt), this.b.h.get(paramInt));
    AvatarWallPagerAdapter localAvatarWallPagerAdapter = this.b;
    ((View)localObject).setTag(2131446791, new AvatarWallPagerAdapter.ViewHolder(localAvatarWallPagerAdapter, localAvatarWallPagerAdapter.h.get(paramInt)));
    if (paramViewGroup != null)
    {
      paramViewGroup.addView((View)localObject);
      return localObject;
    }
    if (i > 1)
    {
      if (paramInt == 1)
      {
        this.b.f = new SoftReference(localObject);
        return localObject;
      }
      if (paramInt == i - 2) {
        this.b.g = new SoftReference(localObject);
      }
    }
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.a.clear();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.InnerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */