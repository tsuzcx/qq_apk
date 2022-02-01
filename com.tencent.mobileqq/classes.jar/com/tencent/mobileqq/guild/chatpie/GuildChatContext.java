package com.tencent.mobileqq.guild.chatpie;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildPieClickProcessor;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;

public class GuildChatContext
  extends AIOContext
{
  private GuildFragmentUnreadTask e = new GuildFragmentUnreadTask(this);
  
  public GuildFragmentUnreadTask P()
  {
    return this.e;
  }
  
  public XEditTextEx Q()
  {
    return this.c.Y;
  }
  
  public GuildPieClickProcessor R()
  {
    return ((GuildChatPie)this.c).bD();
  }
  
  public String S()
  {
    return this.d.c;
  }
  
  public String T()
  {
    return this.d.b;
  }
  
  public IGProChannelInfo U()
  {
    IGPSService localIGPSService = (IGPSService)this.a.getRuntimeService(IGPSService.class, "");
    if (Y()) {
      return localIGPSService.getChannelInfoForGuest(S(), T());
    }
    return localIGPSService.getChannelInfo(T());
  }
  
  public int V()
  {
    IGProChannelInfo localIGProChannelInfo = U();
    int i;
    if (localIGProChannelInfo != null) {
      i = localIGProChannelInfo.getType();
    } else {
      i = 0;
    }
    int j = i;
    if (i == 0) {
      j = ((GuildChatPie)this.c).bA();
    }
    return j;
  }
  
  public boolean W()
  {
    return false;
  }
  
  public boolean X()
  {
    return V() == 5;
  }
  
  public boolean Y()
  {
    Object localObject = S();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      IGProGuildInfo localIGProGuildInfo = ((IGPSService)this.a.getRuntimeService(IGPSService.class, "")).getGuildInfoForGuest((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("guildInfo is ");
      if (localIGProGuildInfo == null) {
        localObject = "null";
      } else {
        localObject = "not null";
      }
      localStringBuilder.append((String)localObject);
      QLog.d("GuildChatContext", 2, localStringBuilder.toString());
      if ((localIGProGuildInfo != null) && (!localIGProGuildInfo.isMember()))
      {
        bool = true;
        break label101;
      }
    }
    boolean bool = false;
    label101:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isGuest = ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("GuildChatContext", 2, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public boolean Z()
  {
    if (!(b() instanceof SplashActivity)) {
      return true;
    }
    Fragment localFragment = b().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
    if ((localFragment instanceof MainFragment)) {
      return ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).isAioFullyOpen((MainFragment)localFragment);
    }
    return false;
  }
  
  public View aa()
  {
    return this.c.aP;
  }
  
  public View ab()
  {
    return this.c.aQ;
  }
  
  public int ac()
  {
    return this.c.aR;
  }
  
  public int ad()
  {
    return this.c.aS;
  }
  
  public ListView ae()
  {
    return this.c.U;
  }
  
  public boolean af()
  {
    return this.c.aX() instanceof SplashActivity;
  }
  
  public void d(boolean paramBoolean)
  {
    ((GuildChatPie)this.c).q(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatContext
 * JD-Core Version:    0.7.0.1
 */