package com.tencent.mobileqq.guild.vas.data;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GetGiftListRsp;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.ArrayList;
import java.util.List;

public class GiftListData
{
  private List<giftList.GroupGiftItem> a = new ArrayList();
  private boolean b = true;
  private String c = "";
  private long d = 0L;
  private long e = 0L;
  
  public List<giftList.GroupGiftItem> a()
  {
    return this.a;
  }
  
  public void a(giftList.GetGiftListRsp paramGetGiftListRsp)
  {
    if (paramGetGiftListRsp == null) {
      return;
    }
    this.b = paramGetGiftListRsp.HasMore.get();
    this.a = paramGetGiftListRsp.GiftList.get();
    this.c = paramGetGiftListRsp.AttachInfo.get();
    this.e = paramGetGiftListRsp.Total.get();
    this.d = (System.currentTimeMillis() + paramGetGiftListRsp.duration.get() * 1000);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.data.GiftListData
 * JD-Core Version:    0.7.0.1
 */