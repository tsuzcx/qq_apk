package dov.com.qq.im.aeeditor.lyric.widget;

import bnrh;
import bntu;
import bnub;

public class LyricViewController$6
  implements Runnable
{
  public LyricViewController$6(bnub parambnub, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bntu != null) {
      this.this$0.jdField_a_of_type_Bntu.a(this.a, this.b);
    }
    if ((this.this$0.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll != null) && (this.this$0.jdField_a_of_type_Bntu != null))
    {
      if (!bnub.a(this.this$0)) {
        break label68;
      }
      bnrh.a("ModuleController", "current is selecting lyric. not auto scroll.");
    }
    label68:
    int i;
    do
    {
      return;
      i = this.this$0.jdField_a_of_type_Bntu.a();
    } while (bnub.a(this.this$0) == i);
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