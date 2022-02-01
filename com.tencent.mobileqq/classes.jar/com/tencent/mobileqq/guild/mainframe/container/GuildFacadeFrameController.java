package com.tencent.mobileqq.guild.mainframe.container;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeJoinInfo;
import com.tencent.mobileqq.guild.mainframe.container.facade.QQGuildFacadeFragment;
import com.tencent.mobileqq.guild.mainframe.helper.JoinGuildParam;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildJoinMFData;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildMFData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class GuildFacadeFrameController
  extends GuildBaseContainer
{
  private static final int d = ViewUtils.dpToPx(0.0F);
  private ViewGroup b = null;
  private QQGuildFacadeFragment c;
  
  public GuildFacadeFrameController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  private void a(FacadeArgsData paramFacadeArgsData)
  {
    Object localObject;
    if (this.c == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("showGuildFacadeFrame guildFacadeFrame == null, begin create: guildId = ");
        ((StringBuilder)localObject).append(paramFacadeArgsData.b);
        QLog.d("GuildFacadeFrameController", 2, ((StringBuilder)localObject).toString());
      }
      localObject = a().g();
      this.c = QQGuildFacadeFragment.a(paramFacadeArgsData);
      this.c.a(this.a);
      ((FragmentManager)localObject).beginTransaction().add(this.b.getId(), this.c, "qq_guild_facade_fragment_tag").commitAllowingStateLoss();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showGuildFacadeFrame guildFacadeFrame update: guildId = ");
      ((StringBuilder)localObject).append(paramFacadeArgsData.b);
      QLog.d("GuildFacadeFrameController", 2, ((StringBuilder)localObject).toString());
    }
    this.c.a();
    this.c.b(paramFacadeArgsData);
  }
  
  private FacadeArgsData c(Object paramObject)
  {
    boolean bool = paramObject instanceof GuildJoinMFData;
    FacadeArgsData localFacadeArgsData = null;
    if (bool)
    {
      paramObject = (GuildJoinMFData)paramObject;
      localFacadeArgsData = new FacadeArgsData();
      localFacadeArgsData.a = paramObject.a;
      localFacadeArgsData.b = paramObject.f.guildId;
      localFacadeArgsData.c = new FacadeJoinInfo();
      localFacadeArgsData.c.a = paramObject.f.from;
      localFacadeArgsData.c.b = paramObject.f.joinSignature;
      localFacadeArgsData.c.d = paramObject.f.extras;
      localFacadeArgsData.c.c = paramObject.f.channelId;
      localFacadeArgsData.d = paramObject.e;
      return localFacadeArgsData;
    }
    if ((paramObject instanceof GuildMFData))
    {
      paramObject = (GuildMFData)paramObject;
      localFacadeArgsData = new FacadeArgsData();
      localFacadeArgsData.a = paramObject.a;
      localFacadeArgsData.b = paramObject.b;
      localFacadeArgsData.c = null;
      if (GuildDiscoverAnimationManager.a)
      {
        localFacadeArgsData.c = new FacadeJoinInfo();
        localFacadeArgsData.c.d = ((Bundle)GuildDiscoverAnimationManager.e.get(paramObject.b));
      }
      localFacadeArgsData.d = paramObject.e;
    }
    return localFacadeArgsData;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = paramViewGroup;
  }
  
  public void a(Object paramObject)
  {
    paramObject = c(paramObject);
    if ((this.b != null) && (paramObject != null) && (!TextUtils.isEmpty(paramObject.b)))
    {
      GuildDiscoverAnimationManager.d = true;
      a(paramObject);
      this.a.a(true, d);
      return;
    }
    QLog.e("GuildFacadeFrameController", 1, "show error");
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QQGuildFacadeFragment.b = paramString;
    }
    paramString = this.c;
  }
  
  public void a(boolean paramBoolean)
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null) {
      localQQGuildFacadeFragment.d();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null) {
      localQQGuildFacadeFragment.a(paramBoolean);
    }
  }
  
  public boolean b(Object paramObject)
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null) {
      return localQQGuildFacadeFragment.c(c(paramObject));
    }
    return true;
  }
  
  public void c()
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null) {
      localQQGuildFacadeFragment.c();
    }
  }
  
  public void e()
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null)
    {
      localQQGuildFacadeFragment.e();
      a().g().beginTransaction().remove(this.c).commitAllowingStateLoss();
      this.c = null;
    }
  }
  
  public void g()
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null) {
      localQQGuildFacadeFragment.f();
    }
  }
  
  public boolean h()
  {
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if ((localQQGuildFacadeFragment != null) && (localQQGuildFacadeFragment.onBackEvent())) {
      return true;
    }
    return super.h();
  }
  
  public int i()
  {
    return 1;
  }
  
  public void j()
  {
    GuildDiscoverAnimationManager.d = false;
    QQGuildFacadeFragment localQQGuildFacadeFragment = this.c;
    if (localQQGuildFacadeFragment != null) {
      localQQGuildFacadeFragment.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.GuildFacadeFrameController
 * JD-Core Version:    0.7.0.1
 */