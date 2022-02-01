package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.util.Iterator;
import java.util.List;

class OpenCardContainer$VirtualAccountAdapter
  extends BaseAdapter
  implements View.OnClickListener, SwipListView.SwipListListener
{
  SwipRightMenuBuilder a = a(paramContext);
  String b;
  int c = -1;
  private List<VirtualAccountInfo> e;
  
  OpenCardContainer$VirtualAccountAdapter(OpenCardContainer paramOpenCardContainer, Context paramContext) {}
  
  private void a(OpenCardContainer.VirtualAccountViewHolder paramVirtualAccountViewHolder, int paramInt, View paramView)
  {
    paramView = (VirtualAccountInfo)this.e.get(paramInt);
    OpenCardContainer.VirtualAccountViewHolder.b(paramVirtualAccountViewHolder).setText(paramView.b);
    if (paramView.d)
    {
      OpenCardContainer.VirtualAccountViewHolder.c(paramVirtualAccountViewHolder).setVisibility(0);
      this.d.k.setMainAccountSelect(false);
    }
    else
    {
      OpenCardContainer.VirtualAccountViewHolder.c(paramVirtualAccountViewHolder).setVisibility(4);
    }
    if (paramView.a != null) {
      OpenCardContainer.a(this.d, OpenCardContainer.VirtualAccountViewHolder.d(paramVirtualAccountViewHolder), paramView.a);
    }
  }
  
  protected SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299607);
    int j = paramContext.getResources().getDimensionPixelSize(2131299608);
    paramContext = OpenCardContainer.d();
    int[] arrayOfInt1 = OpenCardContainer.e();
    int[] arrayOfInt2 = OpenCardContainer.f();
    return new OpenCardContainer.VirtualAccountAdapter.2(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  void a()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VirtualAccountInfo)((Iterator)localObject).next()).d = false;
      }
      notifyDataSetChanged();
    }
  }
  
  void a(long paramLong)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      VirtualAccountInfo localVirtualAccountInfo = (VirtualAccountInfo)localIterator.next();
      if (localVirtualAccountInfo.c == paramLong) {
        localVirtualAccountInfo.d = true;
      } else {
        localVirtualAccountInfo.d = false;
      }
    }
    notifyDataSetChanged();
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.a;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = paramView.getScrollX();
    if ((paramInt >= 0) && (this.c == paramInt))
    {
      paramView.scrollTo(i, 0);
      return;
    }
    if (j != 0) {
      paramView.scrollTo(0, 0);
    }
  }
  
  void a(List<VirtualAccountInfo> paramList, String paramString)
  {
    if (this.e != null)
    {
      Object localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      if (!((String)localObject).equals(this.b))
      {
        this.b = ((String)localObject);
      }
      else if (paramList != null)
      {
        paramString = paramList.iterator();
        while (paramString.hasNext())
        {
          localObject = (VirtualAccountInfo)paramString.next();
          if (((VirtualAccountInfo)localObject).c == this.d.getSelectVid()) {
            ((VirtualAccountInfo)localObject).d = true;
          } else {
            ((VirtualAccountInfo)localObject).d = false;
          }
        }
      }
    }
    this.e = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.e;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.e;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.e.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new OpenCardContainer.VirtualAccountViewHolder(null);
      localView = OpenCardContainer.b(this.d).inflate(2131625709, paramViewGroup, false);
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (URLImageView)localView.findViewById(2131449945));
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (TextView)localView.findViewById(2131449948));
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (ImageView)localView.findViewById(2131445544));
      OpenCardContainer.VirtualAccountViewHolder.a(paramView, (Button)localView.findViewById(2131431724));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(DisplayUtil.a(this.d.a, 66.0F)));
    }
    else
    {
      OpenCardContainer.VirtualAccountViewHolder localVirtualAccountViewHolder = (OpenCardContainer.VirtualAccountViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localVirtualAccountViewHolder;
    }
    a(paramView, paramInt, localView);
    OpenCardContainer.VirtualAccountViewHolder.a(paramView).setOnClickListener(new OpenCardContainer.VirtualAccountAdapter.1(this, paramInt));
    localView.setTag(-1, Integer.valueOf(paramInt));
    a(this.d.a, localView, paramInt, this.e.get(paramInt), paramView, this);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean) {}
  
  public void notifyDataSetChanged()
  {
    Object localObject = this.d;
    List localList = this.e;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    OpenCardContainer.a((OpenCardContainer)localObject, i);
    localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = this.e.iterator();
      i = 0;
      while (((Iterator)localObject).hasNext()) {
        if (((VirtualAccountInfo)((Iterator)localObject).next()).d)
        {
          this.d.k.setMainAccountSelect(false);
          i = 1;
        }
      }
      if (i == 0) {
        this.d.k.setMainAccountSelect(true);
      }
    }
    else
    {
      this.d.k.setMainAccountSelect(true);
    }
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView) {}
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.c = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.VirtualAccountAdapter
 * JD-Core Version:    0.7.0.1
 */