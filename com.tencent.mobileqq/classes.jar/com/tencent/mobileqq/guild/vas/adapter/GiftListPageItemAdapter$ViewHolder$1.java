package com.tencent.mobileqq.guild.vas.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import mqq.util.WeakReference;

class GiftListPageItemAdapter$ViewHolder$1
  implements View.OnClickListener
{
  GiftListPageItemAdapter$ViewHolder$1(GiftListPageItemAdapter.ViewHolder paramViewHolder, int paramInt, giftList.GroupGiftItem paramGroupGiftItem) {}
  
  public void onClick(View paramView)
  {
    if (GiftListPageItemAdapter.a == this.a) {
      return;
    }
    GiftListPageItemAdapter.c(this.c.a).a(paramView, this.a);
    GiftListPageItemAdapter.a(this.c.a, paramView);
    GiftListPageItemAdapter.a = this.a;
    GiftListPageItemAdapter.a(new WeakReference(this.c.itemView));
    GiftListPageItemAdapter.ViewHolder.a(this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */