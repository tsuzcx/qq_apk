package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LyricViewDetail
  extends LyricView
{
  public LyricViewDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131624331, this);
    this.b = ((LyricViewScroll)paramContext.findViewById(2131450136));
    this.a = ((LyricViewInternal)paramContext.findViewById(2131450135));
    this.a.a(this.c);
    this.b.setScrollEnable(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewDetail
 * JD-Core Version:    0.7.0.1
 */