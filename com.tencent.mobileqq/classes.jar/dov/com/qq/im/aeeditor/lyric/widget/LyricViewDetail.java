package dov.com.qq.im.aeeditor.lyric.widget;

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
    paramContext = LayoutInflater.from(paramContext).inflate(2131558556, this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll = ((LyricViewScroll)paramContext.findViewById(2131381376));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewInternalBase = ((LyricViewInternalDetail)paramContext.findViewById(2131381375));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewInternalBase.a(this.jdField_a_of_type_Bpcy);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.setScrollEnable(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewDetail
 * JD-Core Version:    0.7.0.1
 */