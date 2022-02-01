package com.tencent.mobileqq.guild.mainframe.container.discover;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.container.facade.FacadeJoinInfo;
import com.tencent.mobileqq.troop.widget.RoundRectUrlImageView;
import java.util.HashMap;

public class GuildDiscoverAnimationManager
{
  public static volatile boolean a = true;
  public static volatile boolean b = false;
  public static volatile boolean c = false;
  public static volatile boolean d = false;
  public static HashMap<String, Bundle> e = new HashMap();
  
  public static String a(FacadeArgsData paramFacadeArgsData)
  {
    if ((paramFacadeArgsData != null) && (paramFacadeArgsData.c != null) && (paramFacadeArgsData.c.d != null) && (paramFacadeArgsData.c.d.getBoolean("share_element_info_from"))) {
      return paramFacadeArgsData.c.d.getString("share_element_info_view_url");
    }
    return "";
  }
  
  public static void a(RoundRectUrlImageView paramRoundRectUrlImageView, ViewGroup paramViewGroup)
  {
    if ((paramRoundRectUrlImageView != null) && (paramViewGroup != null))
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramViewGroup, "alpha", new float[] { 1.0F, 0.0F });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.addListener(new GuildDiscoverAnimationManager.5(paramViewGroup, paramRoundRectUrlImageView));
      localObjectAnimator.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.GuildDiscoverAnimationManager
 * JD-Core Version:    0.7.0.1
 */