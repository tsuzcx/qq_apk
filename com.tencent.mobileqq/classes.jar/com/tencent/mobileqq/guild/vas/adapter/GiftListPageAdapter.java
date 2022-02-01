package com.tencent.mobileqq.guild.vas.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.guild.vas.panel.IGiftPanelController;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.ArrayList;
import java.util.List;

public class GiftListPageAdapter
  extends PagerAdapter
{
  private int a = 8;
  private int b = 4;
  private List<giftList.GroupGiftItem> c = new ArrayList();
  private IGiftPanelController d;
  
  public GiftListPageAdapter(List<giftList.GroupGiftItem> paramList, IGiftPanelController paramIGiftPanelController)
  {
    this.c = paramList;
    this.d = paramIGiftPanelController;
    GiftListPageItemAdapter.a = 0;
  }
  
  public void a(List<giftList.GroupGiftItem> paramList)
  {
    try
    {
      this.c = paramList;
      notifyDataSetChanged();
      return;
    }
    finally {}
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    List localList = this.c;
    int i = 0;
    if (localList != null)
    {
      if (localList.size() == 0) {
        return 0;
      }
      int j = this.c.size() / this.a;
      if (this.c.size() % this.a != 0) {
        i = 1;
      }
      return j + i;
    }
    return 0;
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    GiftListPageAdapter.ViewHolder localViewHolder = new GiftListPageAdapter.ViewHolder(this, paramViewGroup);
    View localView = GiftListPageAdapter.ViewHolder.a(localViewHolder);
    localViewHolder.a(paramInt);
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    return localView;
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageAdapter
 * JD-Core Version:    0.7.0.1
 */