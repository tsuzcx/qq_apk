package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class BlockAdView$BlockAdapter
  extends BaseAdapter
{
  private List<GdtAd> mGdtAdList;
  private List<MiniAppInfo> miniAppInfoItems;
  
  BlockAdView$BlockAdapter(BlockAdView paramBlockAdView) {}
  
  public int getCount()
  {
    if (this.miniAppInfoItems != null) {
      return this.miniAppInfoItems.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.miniAppInfoItems != null) {
      return (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    if ((this.miniAppInfoItems == null) || (this.miniAppInfoItems.size() < 1))
    {
      localObject1 = paramView;
      localObject2 = paramView;
      paramView = (View)localObject1;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    Object localObject1 = (GdtAd)this.mGdtAdList.get(paramInt);
    Object localObject2 = (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
    if (paramView == null)
    {
      paramView = this.this$0;
      Context localContext = BlockAdView.access$100(this.this$0);
      if (getCount() < 3) {
        label105:
        paramView = new BlockAdView.SingleBlockAdView(paramView, localContext, bool);
      }
    }
    for (;;)
    {
      ((BlockAdView.SingleBlockAdView)paramView).setData((MiniAppInfo)localObject2, (GdtAd)localObject1, this.miniAppInfoItems.size());
      localObject1 = paramView;
      localObject2 = localObject1;
      break;
      bool = false;
      break label105;
    }
  }
  
  public void setData(BlockAdInfo paramBlockAdInfo)
  {
    int i = BlockAdView.access$000(this.this$0);
    this.mGdtAdList = paramBlockAdInfo.getGdtAdInfoList().subList(0, i);
    this.miniAppInfoItems = paramBlockAdInfo.getBlockAdInfo().subList(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView.BlockAdapter
 * JD-Core Version:    0.7.0.1
 */