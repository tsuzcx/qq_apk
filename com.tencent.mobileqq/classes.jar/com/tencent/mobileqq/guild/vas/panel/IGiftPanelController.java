package com.tencent.mobileqq.guild.vas.panel;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.List;

public abstract interface IGiftPanelController
{
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(Activity paramActivity, List<giftList.GroupGiftItem> paramList, IGiftPanelController.OnSelectLastPageListener paramOnSelectLastPageListener, long paramLong);
  
  public abstract void a(String paramString1, String paramString2, Drawable paramDrawable);
  
  public abstract void a(List<giftList.GroupGiftItem> paramList);
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.panel.IGiftPanelController
 * JD-Core Version:    0.7.0.1
 */