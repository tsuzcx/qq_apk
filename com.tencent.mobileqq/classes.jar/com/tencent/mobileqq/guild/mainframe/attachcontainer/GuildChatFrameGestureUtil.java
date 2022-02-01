package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.utils.ViewUtils;

public class GuildChatFrameGestureUtil
{
  public static float a()
  {
    return 0.0F;
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(0.0F);
  }
  
  public static float b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildChatFrameGestureUtil
 * JD-Core Version:    0.7.0.1
 */