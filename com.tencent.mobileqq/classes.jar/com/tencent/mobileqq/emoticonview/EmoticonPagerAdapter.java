package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
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
    Object localObject = this.viewBinderList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((EmoticonViewBinder)((Iterator)localObject).next()).destroy();
      }
      this.viewBinderList = null;
    }
    EmoticonPanelViewBinder.destroyViewPool();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[RecycleView] destroyItem, position=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", viewRecycleable=");
      localStringBuilder.append(this.viewRecycleable);
      QLog.d("EmoticonPagerAdapter", 2, localStringBuilder.toString());
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    if (!this.viewRecycleable) {
      return;
    }
    int i = 0;
    paramView = this.viewBinderList.iterator();
    while (paramView.hasNext())
    {
      paramObject = (EmoticonViewBinder)paramView.next();
      if ((paramObject != null) && ((paramObject instanceof EmoticonPanelViewBinder)))
      {
        paramObject = (EmoticonPanelViewBinder)paramObject;
        int k = paramObject.getPanelPageCount();
        int j = i + k;
        i = j;
        if (paramInt + 1 <= j)
        {
          i = k - (j - paramInt);
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("[RecycleView] destroyItem, position=");
            paramView.append(paramInt);
            paramView.append(", viewBinder=");
            paramView.append(paramObject);
            paramView.append(", innerIndex=");
            paramView.append(i);
            QLog.d("EmoticonPagerAdapter", 2, paramView.toString());
          }
          paramObject.destroyEmoticonPanelView(i);
        }
      }
    }
  }
  
  public int getCount()
  {
    Object localObject = this.viewBinderList;
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return 0;
      }
      localObject = this.viewBinderList.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        EmoticonViewBinder localEmoticonViewBinder = (EmoticonViewBinder)((Iterator)localObject).next();
        if ((localEmoticonViewBinder != null) && ((localEmoticonViewBinder instanceof EmoticonPanelViewBinder))) {
          i += ((EmoticonPanelViewBinder)localEmoticonViewBinder).getPanelPageCount();
        }
      }
    }
    return j;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.viewBinderList.iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (EmoticonViewBinder)((Iterator)localObject1).next();
      if ((localObject2 != null) && ((localObject2 instanceof EmoticonPanelViewBinder)))
      {
        localObject2 = (EmoticonPanelViewBinder)localObject2;
        int k = ((EmoticonPanelViewBinder)localObject2).getPanelPageCount();
        int j = i + k;
        i = j;
        if (paramInt + 1 <= j)
        {
          localObject1 = ((EmoticonPanelViewBinder)localObject2).getEmoticonPanelView(k - (j - paramInt));
          break label104;
        }
      }
    }
    localObject1 = null;
    label104:
    if ((localObject1 != null) && (((View)localObject1).getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView((View)localObject1);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("[Performance] instantiateItem, position=");
      paramView.append(paramInt);
      paramView.append(", duration=");
      paramView.append(System.currentTimeMillis() - l);
      QLog.d("EmoticonPagerAdapter", 2, paramView.toString());
    }
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerAdapter
 * JD-Core Version:    0.7.0.1
 */