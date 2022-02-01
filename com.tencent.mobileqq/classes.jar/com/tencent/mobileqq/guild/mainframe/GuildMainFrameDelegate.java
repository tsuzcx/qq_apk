package com.tencent.mobileqq.guild.mainframe;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildAttachContainerController;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/mainframe/GuildMainFrameDelegate;", "Lcom/tencent/mobileqq/guild/mainframe/IGuildMainFrame;", "mainFragment", "Lcom/tencent/mobileqq/app/FrameFragment;", "(Lcom/tencent/mobileqq/app/FrameFragment;)V", "childFragmentManager", "Landroidx/fragment/app/FragmentManager;", "delegateFragment", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "getDelegateFragment", "()Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "getGuildAttachContainerController", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/GuildAttachContainerController;", "getGuildChatFrameGestureManager", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/GuildChatFrameGestureManager;", "getHelper", "", "channelSelectHelper", "", "getMainViewContext", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainViewContext;", "guildAttachContainerInOrOut", "", "isIn", "", "isPlayAnim", "handleJumpAction", "extra", "Landroid/os/Bundle;", "onPostThemeChanged", "height", "setTabHeight", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class GuildMainFrameDelegate
  implements IGuildMainFrame
{
  private final FragmentManager a;
  
  public GuildMainFrameDelegate(@NotNull FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.getChildFragmentManager();
    Intrinsics.checkExpressionValueIsNotNull(paramFrameFragment, "mainFragment.childFragmentManager");
    this.a = paramFrameFragment;
  }
  
  private final GuildMainFragment a()
  {
    Fragment localFragment = this.a.findFragmentByTag("GuildMainFragment");
    if (localFragment != null) {
      return (GuildMainFragment)localFragment;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.guild.mainframe.GuildMainFragment");
  }
  
  @Nullable
  public Object a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    a().a(paramBundle);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a().a(paramBoolean1, paramBoolean2);
  }
  
  public void b(int paramInt)
  {
    a().b(paramInt);
  }
  
  public void c(int paramInt)
  {
    a().c(paramInt);
  }
  
  @NotNull
  public GuildMainViewContext cw_()
  {
    return a().cw_();
  }
  
  @NotNull
  public GuildAttachContainerController m()
  {
    return a().m();
  }
  
  @NotNull
  public GuildChatFrameGestureManager n()
  {
    return a().n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildMainFrameDelegate
 * JD-Core Version:    0.7.0.1
 */