package com.tencent.mobileqq.guild.mainframe;

import android.os.Bundle;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;

public abstract interface IGuildMainFrame
{
  public abstract Object a(int paramInt);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void b(int paramInt);
  
  public abstract void c(int paramInt);
  
  public abstract GuildMainViewContext cw_();
  
  public abstract GuildAttachContainerController m();
  
  public abstract GuildChatFrameGestureManager n();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.IGuildMainFrame
 * JD-Core Version:    0.7.0.1
 */