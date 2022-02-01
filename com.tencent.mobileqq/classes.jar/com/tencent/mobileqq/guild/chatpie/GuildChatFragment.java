package com.tencent.mobileqq.guild.chatpie;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.ChatPieCache;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardOptionUtils;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class GuildChatFragment
  extends ChatFragment
{
  public static GuildChatFragment s()
  {
    GuildChatFragment localGuildChatFragment = new GuildChatFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGuildChatFragment.setArguments(localBundle);
    return localGuildChatFragment;
  }
  
  private boolean t()
  {
    if (u()) {
      try
      {
        if (!v())
        {
          localObject1 = getActivity().getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
          String str = ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getSelectedGuild((MainFragment)localObject1);
          localObject1 = ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getSelectedChannel((MainFragment)localObject1, str);
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Object localObject2 = new LaunchGuildChatPieParam().a(str).b((String)localObject1).a(null).a(true).b(2).b();
            ((ILaunchGuildChatPieApi)QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(getActivity(), (LaunchGuildChatPieParam)localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("canStartGuildChatPieState selGuildId = ");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append(", selChannelId = ");
              ((StringBuilder)localObject2).append((String)localObject1);
              QLog.i("Q.aio.GuildChatFragment", 2, ((StringBuilder)localObject2).toString());
            }
            return false;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("canStartGuildChatPieState Exception! ");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.e("Q.aio.GuildChatFragment", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return true;
  }
  
  private boolean u()
  {
    return ((this.c instanceof GuildChatPie)) && (this.c.aY);
  }
  
  private boolean v()
  {
    Intent localIntent = getActivity().getIntent();
    return (localIntent != null) && (localIntent.getIntExtra("uintype", -1) == 10014);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyHiddenChanged hidden = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" from:");
    localStringBuilder.append(paramInt);
    QLog.i("Q.aio.GuildChatFragment", 1, localStringBuilder.toString());
    if ((paramInt == GuildMainFrameConstants.y) && (!paramBoolean) && (!t())) {
      return;
    }
    if (!u())
    {
      if (this.c == null) {
        return;
      }
      boolean bool;
      if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("forceStartActivityTemp")))
      {
        bool = getActivity().getIntent().getBooleanExtra("forceStartActivityTemp", false);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyHiddenChanged openActivity = ");
        localStringBuilder.append(bool);
        QLog.i("Q.aio.GuildChatFragment", 1, localStringBuilder.toString());
      }
      else
      {
        bool = false;
      }
      if (paramBoolean)
      {
        if ((paramInt == GuildMainFrameConstants.z) && (this.b != null)) {
          this.b.b();
        }
        if (this.c.bb() != 5)
        {
          if (this.c.bb() == 6) {
            return;
          }
          this.m = true;
          if (!bool) {
            onPause();
          }
          onStop();
          this.m = false;
          return;
        }
        return;
      }
      if (this.c.bb() != 3)
      {
        if (this.c.bb() == 4) {
          return;
        }
        this.m = true;
        onStart();
        if (!bool) {
          onResume();
        }
        this.m = false;
      }
    }
  }
  
  public boolean a(Intent paramIntent)
  {
    Object localObject = this.c;
    boolean bool2 = false;
    boolean bool1;
    if (localObject == null)
    {
      bool1 = bool2;
    }
    else if (this.c.aY)
    {
      bool1 = bool2;
    }
    else
    {
      localObject = paramIntent.getStringExtra("uin");
      String str = this.c.aE().b;
      boolean bool3 = paramIntent.getBooleanExtra("openGuildAioDisableReuse", false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canReuseChatPie, targetUin = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", currentUin = ");
      localStringBuilder.append(str);
      localStringBuilder.append(", disableReuse = ");
      localStringBuilder.append(bool3);
      QLog.d("Q.aio.GuildChatFragment", 2, localStringBuilder.toString());
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        bool1 = bool2;
        if (((String)localObject).equals(str)) {
          if (bool3)
          {
            bool1 = bool2;
          }
          else
          {
            int i = paramIntent.getIntExtra("uintype", -1);
            if (this.c.aE().a != i) {
              bool1 = bool2;
            } else {
              bool1 = true;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("canReuseChatPie: ");
      paramIntent.append(bool1);
      QLog.i("Q.aio.GuildChatFragment", 2, paramIntent.toString());
    }
    return bool1;
  }
  
  public boolean b(Intent paramIntent)
  {
    if (a(paramIntent))
    {
      boolean bool1 = paramIntent.getBooleanExtra("open_chatfragment_fromphoto", false);
      boolean bool2 = ForwardOptionUtils.a(paramIntent);
      if ((bool1) || (bool2)) {
        ((PhotoListHelper)this.c.q(7)).c();
      }
      ((GuildChatPie)this.c).a();
      return true;
    }
    return false;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public void d()
  {
    this.f.setChatFragmentType(BaseActivity.GUILDCHAT_FRAGMENT_TYPE);
  }
  
  public void e() {}
  
  public boolean f()
  {
    int i = ((SplashActivity)this.f).getCurrentTab();
    int j = FrameControllerUtil.k;
    boolean bool3 = false;
    boolean bool1;
    if (i == j) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((isAdded()) && (!isHidden()) && (getView() != null) && (getView().getVisibility() == 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((!(this.f instanceof SplashActivity)) || (SplashActivity.currentFragment != 1) || (!bool1) || (!bool2) || (u())) {
      bool3 = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("filterFragmentState isCurrentGuildTab = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", isVisible = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", filter = ");
      localStringBuilder.append(bool3);
      QLog.i("Q.aio.GuildChatFragment", 2, localStringBuilder.toString());
    }
    return bool3;
  }
  
  public void flingLToR() {}
  
  public void flingRToL() {}
  
  public void g() {}
  
  public boolean i()
  {
    return super.i();
  }
  
  public void l()
  {
    if (this.b == null) {
      return;
    }
    this.b.a();
    super.l();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNewIntent mAIORootView:");
    localStringBuilder.append(this.h);
    QLog.i("Q.aio.GuildChatFragment", 1, localStringBuilder.toString());
  }
  
  protected boolean m()
  {
    return false;
  }
  
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.b.a();
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildChatFragment
 * JD-Core Version:    0.7.0.1
 */