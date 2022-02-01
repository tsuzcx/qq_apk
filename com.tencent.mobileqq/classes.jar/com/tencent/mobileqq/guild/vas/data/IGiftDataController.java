package com.tencent.mobileqq.guild.vas.data;

import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.List;

public abstract interface IGiftDataController
{
  public abstract long a();
  
  public abstract List<giftList.GroupGiftItem> a(String paramString);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.data.IGiftDataController
 * JD-Core Version:    0.7.0.1
 */