package dov.com.qq.im.aeeditor.lyric.widget;

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
    paramContext = LayoutInflater.from(paramContext).inflate(2131558555, this);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll = ((LyricViewScroll)paramContext.findViewById(2131381203));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewInternalBase = ((LyricViewInternalSingleLine)paramContext.findViewById(2131381202));
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewInternalBase.a(this.jdField_a_of_type_Bobd);
    this.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.setScrollEnable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewSingleLine
 * JD-Core Version:    0.7.0.1
 */