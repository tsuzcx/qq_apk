package com.tencent.mobileqq.guild.mainframe;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle.State;
import com.tencent.mobileqq.app.FrameFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"hideGuildFragment", "", "Lcom/tencent/mobileqq/app/FrameFragment;", "fragment", "Lcom/tencent/mobileqq/guild/mainframe/GuildMainFragment;", "showGuildFragment", "qqguild-impl_release"}, k=2, mv={1, 1, 16})
public final class GuildFragmentDelegateFrameKt
{
  private static final void c(@NotNull FrameFragment paramFrameFragment, GuildMainFragment paramGuildMainFragment)
  {
    paramFrameFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle((Fragment)paramGuildMainFragment, Lifecycle.State.RESUMED).commitNowAllowingStateLoss();
  }
  
  private static final void d(@NotNull FrameFragment paramFrameFragment, GuildMainFragment paramGuildMainFragment)
  {
    paramFrameFragment.getChildFragmentManager().beginTransaction().setMaxLifecycle((Fragment)paramGuildMainFragment, Lifecycle.State.STARTED).commitNowAllowingStateLoss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrameKt
 * JD-Core Version:    0.7.0.1
 */