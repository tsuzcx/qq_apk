package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GroupTeamWordkMoreView
  extends RelativeLayout
{
  RelativeLayout a = null;
  TextView b;
  Context c;
  Drawable d;
  
  public GroupTeamWordkMoreView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GroupTeamWordkMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GroupTeamWordkMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131626697, this);
    this.a = ((RelativeLayout)findViewById(2131441536));
    this.b = ((TextView)findViewById(2131441537));
    this.c = paramContext;
  }
  
  public void a()
  {
    Drawable localDrawable = this.d;
    if (localDrawable == null) {
      return;
    }
    ((Animatable)localDrawable).stop();
    this.d = null;
    this.b.setCompoundDrawables(null, null, null, null);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.a.setBackgroundResource(paramInt);
  }
  
  public void setGone()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(int paramInt)
  {
    this.b.setText(paramInt);
  }
  
  public void setTextColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }
  
  public void setTextLeftDrawable(int paramInt)
  {
    this.d = this.c.getResources().getDrawable(paramInt);
    Drawable localDrawable = this.d;
    localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), this.d.getMinimumHeight());
    this.b.setCompoundDrawables(this.d, null, null, null);
    ((Animatable)this.d).start();
  }
  
  public void setVisible()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWordkMoreView
 * JD-Core Version:    0.7.0.1
 */