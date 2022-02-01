package com.tencent.mobileqq.guild.vas.adapter;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.HashMap;
import java.util.Map;

class GiftListPageItemAdapter$ViewHolder$3
  implements IElementDynamicParams
{
  GiftListPageItemAdapter$ViewHolder$3(GiftListPageItemAdapter.ViewHolder paramViewHolder) {}
  
  @Nullable
  public Map<String, Object> getElementDynamicParams()
  {
    if (GiftListPageItemAdapter.ViewHolder.a(this.a) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("yes_gift_id", Integer.valueOf(GiftListPageItemAdapter.ViewHolder.a(this.a).GiftId.get()));
      localHashMap.put("yes_gift_name", GiftListPageItemAdapter.ViewHolder.a(this.a).GiftName.get());
      localHashMap.put("yes_gift_price", Integer.valueOf(GiftListPageItemAdapter.ViewHolder.a(this.a).Price.get()));
      return localHashMap;
    }
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.adapter.GiftListPageItemAdapter.ViewHolder.3
 * JD-Core Version:    0.7.0.1
 */