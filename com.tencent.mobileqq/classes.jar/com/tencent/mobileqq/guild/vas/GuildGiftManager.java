package com.tencent.mobileqq.guild.vas;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.vas.anim.GiftAnimController;
import com.tencent.mobileqq.guild.vas.anim.IGiftAnimController;
import com.tencent.mobileqq.guild.vas.data.GiftDataController;
import com.tencent.mobileqq.guild.vas.data.IGiftDataController;
import com.tencent.mobileqq.guild.vas.panel.GiftPanelController;
import com.tencent.mobileqq.guild.vas.panel.IGiftPanelController;
import com.tencent.trpcprotocol.gift.channel_gift_list.gift_list.giftList.GroupGiftItem;
import java.util.List;

public class GuildGiftManager
  implements IGuildGiftManager, IGuildGiftPresenter
{
  private static volatile IGuildGiftManager e;
  private final IGiftPanelController a = new GiftPanelController(this);
  private final IGiftAnimController b = new GiftAnimController();
  private final IGiftDataController c = new GiftDataController(this);
  private IGiftPanelAction d;
  
  public static IGuildGiftManager a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new GuildGiftManager();
        }
      }
      finally {}
    }
    return e;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.c.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.a.a(paramLong, paramString);
  }
  
  public void a(Activity paramActivity)
  {
    this.c.c("");
    List localList = this.c.a("");
    this.a.a(paramActivity, localList, new GuildGiftManager.1(this), this.c.a());
  }
  
  public void a(IGiftPanelAction paramIGiftPanelAction)
  {
    this.d = paramIGiftPanelAction;
  }
  
  public void a(String paramString)
  {
    this.c.c("");
    this.c.b();
  }
  
  public void a(String paramString1, String paramString2, Drawable paramDrawable)
  {
    this.a.a(paramString1, paramString2, paramDrawable);
  }
  
  public void a(List<giftList.GroupGiftItem> paramList)
  {
    this.a.a(paramList);
  }
  
  public void b()
  {
    this.a.a();
  }
  
  public void c()
  {
    this.a.d();
  }
  
  public IGiftPanelAction d()
  {
    return this.d;
  }
  
  public void e()
  {
    this.c.b();
  }
  
  public void f()
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.GuildGiftManager
 * JD-Core Version:    0.7.0.1
 */