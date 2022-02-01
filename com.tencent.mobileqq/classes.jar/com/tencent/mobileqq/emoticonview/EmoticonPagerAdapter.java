package com.tencent.mobileqq.emoticonview;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonPagerAdapter
  extends PagerAdapter
{
  private static final String LOG_TAG = "EmoticonPagerAdapter";
  private List<EmoticonViewBinder> viewBinderList;
  private boolean viewRecycleable = true;
  
  public void destroy()
  {
    if (this.viewBinderList != null)
    {
      Iterator localIterator = this.viewBinderList.iterator();
      while (localIterator.hasNext()) {
        ((EmoticonViewBinder)localIterator.next()).destroy();
      }
      this.viewBinderList = null;
    }
    EmoticonPanelViewBinder.destroyViewPool();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPagerAdapter", 2, "[RecycleView] destroyItem, position=" + paramInt + ", viewRecycleable=" + this.viewRecycleable);
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    if (!this.viewRecycleable) {}
    for (;;)
    {
      return;
      paramView = this.viewBinderList.iterator();
      int i;
      for (int j = 0; paramView.hasNext(); j = i)
      {
        paramObject = (EmoticonViewBinder)paramView.next();
        i = j;
        if (paramObject != null)
        {
          i = j;
          if ((paramObject instanceof EmoticonPanelViewBinder))
          {
            paramObject = (EmoticonPanelViewBinder)paramObject;
            int k = paramObject.getPanelPageCount();
            j += k;
            i = j;
            if (paramInt + 1 <= j)
            {
              i = k - (j - paramInt);
              if (QLog.isColorLevel()) {
                QLog.d("EmoticonPagerAdapter", 2, "[RecycleView] destroyItem, position=" + paramInt + ", viewBinder=" + paramObject + ", innerIndex=" + i);
              }
              paramObject.destroyEmoticonPanelView(i);
              return;
            }
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    int j;
    if ((this.viewBinderList == null) || (this.viewBinderList.size() == 0)) {
      j = 0;
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.viewBinderList.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    EmoticonViewBinder localEmoticonViewBinder = (EmoticonViewBinder)localIterator.next();
    if ((localEmoticonViewBinder != null) && ((localEmoticonViewBinder instanceof EmoticonPanelViewBinder))) {
      i += ((EmoticonPanelViewBinder)localEmoticonViewBinder).getPanelPageCount();
    }
    for (;;)
    {
      break;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.viewBinderList.iterator();
    int j = 0;
    Object localObject2;
    int i;
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonViewBinder)((Iterator)localObject1).next();
      i = j;
      if (localObject2 != null)
      {
        i = j;
        if ((localObject2 instanceof EmoticonPanelViewBinder))
        {
          localObject2 = (EmoticonPanelViewBinder)localObject2;
          k = ((EmoticonPanelViewBinder)localObject2).getPanelPageCount();
          j += k;
          i = j;
          if (paramInt + 1 > j) {}
        }
      }
    }
    for (localObject1 = ((EmoticonPanelViewBinder)localObject2).getEmoticonPanelView(k - (j - paramInt));; localObject1 = null)
    {
      if ((localObject1 != null) && (((View)localObject1).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPagerAdapter", 2, "[Performance] instantiateItem, position=" + paramInt + ", duration=" + (System.currentTimeMillis() - l));
      }
      return localObject1;
      j = i;
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setViewBinderList(List<EmoticonViewBinder> paramList)
  {
    setViewBinderList(paramList, true);
  }
  
  public void setViewBinderList(List<EmoticonViewBinder> paramList, boolean paramBoolean)
  {
    this.viewRecycleable = false;
    this.viewBinderList = paramList;
    if (paramBoolean) {
      super.notifyDataSetChanged();
    }
  }
  
  public void setViewRecycleable(boolean paramBoolean)
  {
    this.viewRecycleable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerAdapter
 * JD-Core Version:    0.7.0.1
 */