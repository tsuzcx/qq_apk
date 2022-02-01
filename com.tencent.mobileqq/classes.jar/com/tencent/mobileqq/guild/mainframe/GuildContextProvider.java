package com.tencent.mobileqq.guild.mainframe;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import com.tencent.mobileqq.guild.mainframe.container.GuildContainerController;
import com.tencent.mobileqq.guild.mainframe.leftbar.GuildLeftBarController;
import mqq.app.AppRuntime;

public abstract interface GuildContextProvider
{
  public abstract Object a(int paramInt);
  
  public abstract Activity e();
  
  public abstract AppRuntime g();
  
  public abstract GuildLeftBarController j();
  
  public abstract GuildContainerController l();
  
  public abstract GuildAttachContainerController m();
  
  public abstract GuildChatFrameGestureManager n();
  
  public abstract DragFrameLayout o();
  
  public abstract FragmentManager p();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildContextProvider
 * JD-Core Version:    0.7.0.1
 */