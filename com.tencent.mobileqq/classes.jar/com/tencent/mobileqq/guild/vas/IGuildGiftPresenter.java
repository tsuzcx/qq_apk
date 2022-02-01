package com.tencent.mobileqq.guild.vas;

import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.List;

public abstract interface IGuildGiftPresenter
{
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(List<giftList.GroupGiftItem> paramList);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract IGiftPanelAction d();
  
  public abstract void e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.IGuildGiftPresenter
 * JD-Core Version:    0.7.0.1
 */