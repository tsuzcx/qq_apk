package com.tencent.mobileqq.guild.util;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseFragment;

public class GuildFragmentUtil
{
  public static void a(FragmentManager paramFragmentManager, QBaseFragment paramQBaseFragment)
  {
    if (paramFragmentManager != null)
    {
      if (paramQBaseFragment == null) {
        return;
      }
      paramFragmentManager.beginTransaction().remove(paramQBaseFragment).commitAllowingStateLoss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildFragmentUtil
 * JD-Core Version:    0.7.0.1
 */