package com.tencent.mobileqq.guild.setting.popup;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class GuildMedalBubbleLayout
  extends FrameLayout
{
  private FrameLayout a = (FrameLayout)inflate(paramContext, 2131625083, this).findViewById(2131445137);
  private TextView b;
  
  public GuildMedalBubbleLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildMedalBubbleLayout(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.b = ((TextView)this.a.findViewById(2131434691));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.popup.GuildMedalBubbleLayout
 * JD-Core Version:    0.7.0.1
 */