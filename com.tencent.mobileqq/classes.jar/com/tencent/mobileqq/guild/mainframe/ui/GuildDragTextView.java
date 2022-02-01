package com.tencent.mobileqq.guild.mainframe.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;

public class GuildDragTextView
  extends DragTextView
{
  public AbsGestureListener a = new GuildDragTextView.1(this);
  
  public GuildDragTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildDragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildDragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AbsGestureListener getGestureListener()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.ui.GuildDragTextView
 * JD-Core Version:    0.7.0.1
 */