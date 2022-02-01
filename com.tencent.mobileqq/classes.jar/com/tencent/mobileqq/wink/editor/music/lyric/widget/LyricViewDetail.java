package com.tencent.mobileqq.wink.editor.music.lyric.widget;

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
    paramContext = LayoutInflater.from(paramContext).inflate(2131629701, this);
    this.b = ((LyricViewScroll)paramContext.findViewById(2131450136));
    this.a = ((LyricViewInternalDetail)paramContext.findViewById(2131450135));
    this.a.a(this.c);
    this.b.setScrollEnable(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.widget.LyricViewDetail
 * JD-Core Version:    0.7.0.1
 */