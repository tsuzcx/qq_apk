package dov.com.qq.im.aeeditor.lyric.widget;

import bmbx;
import bmec;
import bmej;

public class LyricViewController$6
  implements Runnable
{
  public LyricViewController$6(bmej parambmej, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bmec != null) {
      this.this$0.jdField_a_of_type_Bmec.a(this.a, this.b);
    }
    if ((this.this$0.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll != null) && (this.this$0.jdField_a_of_type_Bmec != null))
    {
      if (!bmej.a(this.this$0)) {
        break label68;
      }
      bmbx.a("ModuleController", "current is selecting lyric. not auto scroll.");
    }
    label68:
    int i;
    do
    {
      return;
      i = this.this$0.jdField_a_of_type_Bmec.a();
    } while (bmej.a(this.this$0) == i);
    if (i == 0)
    {
      this.this$0.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.b(i);
      return;
    }
    this.this$0.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.lyric.widget.LyricViewController.6
 * JD-Core Version:    0.7.0.1
 */