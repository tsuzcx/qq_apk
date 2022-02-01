package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.base.view.widget.IReadInJoyListItemAutoPlayCallback;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.widget.ListView;
import com.tencent.widget.ListView.OnScrollChangeListener;

public class RIJOnScrollChangeListener
  implements ListView.OnScrollChangeListener
{
  RIJDataManager a;
  
  public RIJOnScrollChangeListener(RIJDataManager paramRIJDataManager)
  {
    this.a = paramRIJDataManager;
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt1 < this.a.a().a().a().getChildCount())
    {
      localObject1 = this.a.a().a().a().getChildAt(paramInt1);
      if ((localObject1 instanceof ProteusItemView))
      {
        localObject1 = ((ProteusItemView)localObject1).a();
        if (localObject1 != null)
        {
          localObject1 = (IReadInJoyListItemAutoPlayCallback)((Container)localObject1).getTag(2131376090);
          if ((localObject1 != null) && (((IReadInJoyListItemAutoPlayCallback)localObject1).a())) {
            break label106;
          }
        }
      }
      paramInt1 += 1;
    }
    Object localObject1 = null;
    label106:
    ReadInJoyXListView localReadInJoyXListView = (ReadInJoyXListView)this.a.a().a().a();
    paramInt1 = paramInt2;
    if (localObject1 != null)
    {
      paramInt1 = paramInt2;
      if (!localReadInJoyXListView.a())
      {
        ((IReadInJoyListItemAutoPlayCallback)localObject1).a();
        paramInt1 = paramInt2;
      }
    }
    while (paramInt1 < localReadInJoyXListView.getChildCount())
    {
      Object localObject2 = localReadInJoyXListView.getChildAt(paramInt1);
      if ((localObject2 instanceof ProteusItemView))
      {
        localObject2 = ((ProteusItemView)localObject2).a();
        if (localObject2 != null)
        {
          localObject2 = (IReadInJoyListItemAutoPlayCallback)((Container)localObject2).getTag(2131376090);
          if ((localObject2 != null) && (localObject2 != localObject1)) {
            ((IReadInJoyListItemAutoPlayCallback)localObject2).b();
          }
        }
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJOnScrollChangeListener
 * JD-Core Version:    0.7.0.1
 */