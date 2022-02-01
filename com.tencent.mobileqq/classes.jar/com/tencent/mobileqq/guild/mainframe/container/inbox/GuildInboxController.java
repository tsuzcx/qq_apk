package com.tencent.mobileqq.guild.mainframe.container.inbox;

import android.content.Intent;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.mobileqq.guild.util.GuildFragmentUtil;
import com.tencent.mobileqq.utils.ViewUtils;

public class GuildInboxController
  extends GuildBaseContainer
{
  private static final int b = ViewUtils.dpToPx(0.0F);
  private GuildInboxFragment c;
  private ViewGroup d = null;
  
  public GuildInboxController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.d = paramViewGroup;
  }
  
  public void a(Object paramObject)
  {
    k();
    paramObject = this.c;
    if (paramObject != null)
    {
      paramObject.a();
      this.a.a(true, b);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    GuildInboxFragment localGuildInboxFragment = this.c;
    if (localGuildInboxFragment != null) {
      localGuildInboxFragment.c();
    }
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
    super.g();
    GuildInboxFragment localGuildInboxFragment = this.c;
    if (localGuildInboxFragment != null) {
      localGuildInboxFragment.d();
    }
  }
  
  public int i()
  {
    return 3;
  }
  
  public void j()
  {
    GuildInboxFragment localGuildInboxFragment = this.c;
    if (localGuildInboxFragment != null) {
      localGuildInboxFragment.b();
    }
  }
  
  protected void k()
  {
    FragmentManager localFragmentManager = a().g();
    if (this.c == null)
    {
      this.c = GuildInboxFragment.a(new Intent());
      this.c.a(a());
      localFragmentManager.beginTransaction().add(this.d.getId(), this.c, "GuildNoticeController_QQGuildNoticeFragment").commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.inbox.GuildInboxController
 * JD-Core Version:    0.7.0.1
 */