package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.mobileqq.guild.mainframe.helper.ChannelSelectHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildChatFrameController
  extends GuildBaseContainer
{
  private int b = 0;
  private FrameLayout c;
  private QBaseFragment d;
  
  public GuildChatFrameController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  private void c(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Intent))) {
      paramObject = (Intent)paramObject;
    } else {
      paramObject = null;
    }
    Object localObject1 = paramObject;
    if (paramObject == null) {
      localObject1 = this.a.b().getIntent();
    }
    if (localObject1 != null)
    {
      Object localObject2 = ((Intent)localObject1).getStringExtra("uin");
      paramObject = ((Intent)localObject1).getStringExtra("guild_id");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("selGuildAndChannel guildId:");
        ((StringBuilder)localObject1).append(paramObject);
        ((StringBuilder)localObject1).append(" channelId:");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.i("GuildChatFrameController", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!TextUtils.isEmpty(paramObject)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = ((IGPSService)this.a.a().getRuntimeService(IGPSService.class, "")).getGuildInfo(paramObject);
        ((ChannelSelectHelper)this.a.a(GuildMainFrameConstants.f)).a(paramObject, (String)localObject2);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("guild_jumpleftbar_from", GuildMainFrameConstants.D);
        GuildMainViewContext localGuildMainViewContext = this.a;
        int i;
        if (localObject1 != null) {
          i = 1;
        } else {
          i = 0;
        }
        localGuildMainViewContext.a(i, paramObject, (Bundle)localObject2);
      }
    }
  }
  
  private boolean k()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGuildChatFragmentBack chatFragment is null ? ");
      localStringBuilder.append(this.d);
      if (localStringBuilder.toString() != null) {
        bool = false;
      }
      QLog.d("GuildChatFrameController", 2, new Object[] { Boolean.valueOf(bool) });
    }
    if (this.d != null) {
      return ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).onGuildChatFragmentBackEvent(this.d);
    }
    return false;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.c = ((FrameLayout)paramViewGroup);
    this.b = this.c.getId();
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show chatFragment is null ? ");
      boolean bool;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("GuildChatFrameController", 2, ((StringBuilder)localObject).toString());
    }
    c(paramObject);
    if (this.d == null)
    {
      if ((paramObject != null) && ((paramObject instanceof Intent))) {
        this.a.b().setIntent((Intent)paramObject);
      }
      this.d = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).createGuildChatFragment(this.a.g(), this.b);
      return;
    }
    Object localObject = this.a.g().beginTransaction();
    ((FragmentTransaction)localObject).show(this.d);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
    if (!this.d.isAdded())
    {
      if ((paramObject != null) && ((paramObject instanceof Intent))) {
        this.a.b().setIntent((Intent)paramObject);
      }
    }
    else
    {
      localObject = (IGuildTempApi)QRoute.api(IGuildTempApi.class);
      QBaseFragment localQBaseFragment = this.d;
      if ((paramObject != null) && ((paramObject instanceof Intent))) {
        paramObject = (Intent)paramObject;
      } else {
        paramObject = null;
      }
      ((IGuildTempApi)localObject).onGuildChatNewIntent(localQBaseFragment, paramObject);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramBoolean = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterAccountChanged chatFragment is null ? ");
      localStringBuilder.append(this.d);
      if (localStringBuilder.toString() != null) {
        paramBoolean = false;
      }
      QLog.d("GuildChatFrameController", 2, new Object[] { Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy chatFragment is null ? ");
      localStringBuilder.append(this.d);
      if (localStringBuilder.toString() != null) {
        bool = false;
      }
      QLog.d("GuildChatFrameController", 2, new Object[] { Boolean.valueOf(bool) });
    }
    if (this.d != null)
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).removeGuildChatFragment(this.a.g(), this.d);
      this.d = null;
    }
  }
  
  public void f() {}
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeAccountChanged chatFragment is null ? ");
      localStringBuilder.append(this.d);
      boolean bool;
      if (localStringBuilder.toString() == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("GuildChatFrameController", 2, new Object[] { Boolean.valueOf(bool) });
    }
    if (this.d != null)
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).removeGuildChatFragment(this.a.g(), this.d);
      this.d = null;
      if (this.a.e().l() == GuildAttachContainerController.c)
      {
        this.a.e().d(true);
        this.a.e().a(GuildAttachContainerController.b, null);
      }
    }
  }
  
  public boolean h()
  {
    if (QLog.isColorLevel())
    {
      boolean bool = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBackPressed chatFragment is null ? ");
      localStringBuilder.append(this.d);
      if (localStringBuilder.toString() != null) {
        bool = false;
      }
      QLog.d("GuildChatFrameController", 2, new Object[] { Boolean.valueOf(bool) });
    }
    if ((this.c != null) && (this.a.e().i()) && (this.a.e().l() == GuildAttachContainerController.c)) {
      return k();
    }
    return false;
  }
  
  public int i()
  {
    return GuildAttachContainerController.c;
  }
  
  public void j()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide chatFragment is null ? ");
      boolean bool;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("GuildChatFrameController", 2, localStringBuilder.toString());
    }
    if (this.d != null)
    {
      this.a.g().beginTransaction().hide(this.d).commitAllowingStateLoss();
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).notifyGuildHiddenChanged(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameController
 * JD-Core Version:    0.7.0.1
 */