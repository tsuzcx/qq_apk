package com.tencent.mobileqq.wink.editor.music.lyric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LyricViewSingleLine
  extends LyricView
{
  public LyricViewSingleLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = LayoutInflater.from(paramContext).inflate(2131629702, this);
    this.b = ((LyricViewScroll)paramContext.findViewById(2131450136));
    this.a = ((LyricViewInternalSingleLine)paramContext.findViewById(2131450135));
    this.a.a(this.c);
    this.b.setScrollEnable(false);
  }
  
  public LyricViewInternalBase getInternal()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewSingleLine
 * JD-Core Version:    0.7.0.1
 */