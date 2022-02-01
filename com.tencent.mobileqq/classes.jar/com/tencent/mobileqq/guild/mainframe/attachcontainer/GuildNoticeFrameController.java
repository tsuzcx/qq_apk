package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.mobileqq.guild.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.util.GuildFragmentUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GuildNoticeFrameController
  extends GuildBaseContainer
{
  private FrameLayout b;
  private GuildNoticeFragment c;
  
  public GuildNoticeFrameController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.b = ((FrameLayout)paramViewGroup);
  }
  
  public void a(NotifyData paramNotifyData)
  {
    if ((paramNotifyData.a() == 3) && (paramNotifyData.b() == 0))
    {
      ((IGuildInboxRedService)this.a.a().getRuntimeService(IGuildInboxRedService.class, "")).clearNoticeRedPoint(1);
      if (QLog.isColorLevel()) {
        QLog.d("GuildNoticeFrameController", 1, "clearNoticeRedPoint");
      }
      paramNotifyData = this.c;
      if (paramNotifyData != null) {
        paramNotifyData.a();
      }
    }
  }
  
  public void a(Object paramObject)
  {
    paramObject = this.a.g().beginTransaction();
    GuildNoticeFragment localGuildNoticeFragment = this.c;
    if ((localGuildNoticeFragment != null) && (localGuildNoticeFragment.getActivity() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildNoticeFrameController", 2, "remove noticeFragment !");
      }
      this.c.onDestroyView();
      this.c.onDestroy();
      paramObject.remove(this.c);
    }
    this.c = GuildNoticeFragment.a(new Intent());
    this.c.a(a());
    paramObject.add(this.b.getId(), this.c, "GuildChannelNoticeFrameController_QQGuildChannelNoticeFragment");
    paramObject.commitAllowingStateLoss();
  }
  
  public void e()
  {
    if (this.c != null)
    {
      GuildFragmentUtil.a(this.a.g(), this.c);
      this.c = null;
    }
  }
  
  public void g()
  {
    if (this.c != null)
    {
      GuildFragmentUtil.a(this.a.g(), this.c);
      this.c = null;
      if (this.a.e().l() == 3)
      {
        this.a.e().d(true);
        this.a.e().a(GuildAttachContainerController.b, null);
      }
    }
  }
  
  public int i()
  {
    return GuildAttachContainerController.f;
  }
  
  public void j()
  {
    if (this.c != null)
    {
      FragmentTransaction localFragmentTransaction = this.a.g().beginTransaction();
      localFragmentTransaction.hide(this.c);
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildNoticeFrameController
 * JD-Core Version:    0.7.0.1
 */