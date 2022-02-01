package com.tencent.mobileqq.guild.mainframe.container.empty;

import android.content.Intent;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.mobileqq.guild.util.GuildFragmentUtil;
import com.tencent.mobileqq.utils.ViewUtils;

public class GuildEmptyController
  extends GuildBaseContainer
{
  private static final int d = ViewUtils.dpToPx(0.0F);
  GuildEmptyFragment b;
  private ViewGroup c = null;
  
  public GuildEmptyController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.c = paramViewGroup;
  }
  
  public void a(Object paramObject)
  {
    k();
    paramObject = this.b;
    if (paramObject != null)
    {
      paramObject.a();
      this.a.a(false, d);
    }
  }
  
  public void e()
  {
    if (this.b != null)
    {
      GuildFragmentUtil.a(this.a.g(), this.b);
      this.b = null;
    }
  }
  
  public int i()
  {
    return 4;
  }
  
  public void j()
  {
    GuildEmptyFragment localGuildEmptyFragment = this.b;
    if (localGuildEmptyFragment != null) {
      localGuildEmptyFragment.b();
    }
  }
  
  protected void k()
  {
    FragmentManager localFragmentManager = a().g();
    if (this.b == null)
    {
      this.b = GuildEmptyFragment.a(new Intent());
      localFragmentManager.beginTransaction().add(this.c.getId(), this.b, "GuildEmptyController").commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.empty.GuildEmptyController
 * JD-Core Version:    0.7.0.1
 */