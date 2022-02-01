package com.tencent.mobileqq.guild.vas.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;

class GiftListPageItemAdapter$ViewHolder$2
  implements View.OnClickListener
{
  GiftListPageItemAdapter$ViewHolder$2(GiftListPageItemAdapter.ViewHolder paramViewHolder, giftList.GroupGiftItem paramGroupGiftItem) {}
  
  public void onClick(View paramView)
  {
    GiftListPageItemAdapter.c(this.b.a).a(paramView, this.a.GiftId.get(), this.a.GiftType.get());
    GiftListPageItemAdapter.ViewHolder.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter.ViewHolder.2
 * JD-Core Version:    0.7.0.1
 */