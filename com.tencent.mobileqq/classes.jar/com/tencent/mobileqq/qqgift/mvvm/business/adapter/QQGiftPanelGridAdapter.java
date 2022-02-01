package com.tencent.mobileqq.qqgift.mvvm.business.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelItemView;
import com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPanelItemViewImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQGiftPanelGridAdapter
  extends BaseAdapter
{
  protected static final int e = 2130847985;
  protected final Context a;
  protected List<GiftServiceData> b = new ArrayList();
  protected final QQGiftPanelBaseViewModel c;
  protected int d;
  
  public QQGiftPanelGridAdapter(Context paramContext, QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel)
  {
    this.a = paramContext;
    this.c = paramQQGiftPanelBaseViewModel;
  }
  
  protected IQQGiftPanelItemView a(Context paramContext)
  {
    paramContext = new QQGiftPanelItemViewImpl(paramContext);
    paramContext.setViewModel((QQGiftPanelViewModel)this.c);
    return paramContext;
  }
  
  public void a(List<GiftServiceData> paramList, int paramInt)
  {
    this.b.clear();
    this.b.addAll(paramList);
    this.d = paramInt;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GiftServiceData localGiftServiceData = (GiftServiceData)this.b.get(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = (View)a(this.a);
      localObject = new QQGiftPanelGridAdapter.MyViewHolder(paramView);
      paramView.setTag(localObject);
    }
    else
    {
      localObject = (QQGiftPanelGridAdapter.MyViewHolder)paramView.getTag();
    }
    if ((((QQGiftPanelGridAdapter.MyViewHolder)localObject).a instanceof IQQGiftPanelItemView))
    {
      localObject = (IQQGiftPanelItemView)((QQGiftPanelGridAdapter.MyViewHolder)localObject).a;
      int i = this.d;
      if (i > 0) {
        i = (i - 1) * 8;
      } else {
        i = 0;
      }
      ((IQQGiftPanelItemView)localObject).setIsSelected(localGiftServiceData, i + paramInt);
      ((IQQGiftPanelItemView)localObject).a(localGiftServiceData.g);
      ((IQQGiftPanelItemView)localObject).a(localGiftServiceData.b);
      ((IQQGiftPanelItemView)localObject).b(e);
      ((IQQGiftPanelItemView)localObject).c(localGiftServiceData.c);
    }
    this.c.a(localGiftServiceData, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelGridAdapter
 * JD-Core Version:    0.7.0.1
 */