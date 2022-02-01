package com.tencent.timi.game.teamlist.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.timi.game.ui.widget.TimiRoundImageView;

public class TeamListAvatarStorkRoundImageView
  extends RelativeLayout
{
  private View a;
  private TimiRoundImageView b;
  private ImageView c;
  
  public TeamListAvatarStorkRoundImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TeamListAvatarStorkRoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TeamListAvatarStorkRoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = LayoutInflater.from(getContext()).inflate(2131629495, this, true);
    this.b = ((TimiRoundImageView)findViewById(2131428988));
    this.c = ((ImageView)findViewById(2131437976));
  }
  
  public void setBlueBg()
  {
    this.c.setVisibility(0);
    this.c.setImageResource(2130853050);
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
  }
  
  public void setNormal()
  {
    this.c.setVisibility(4);
  }
  
  public void setPinkBg()
  {
    this.c.setVisibility(0);
    this.c.setImageResource(2130853051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListAvatarStorkRoundImageView
 * JD-Core Version:    0.7.0.1
 */