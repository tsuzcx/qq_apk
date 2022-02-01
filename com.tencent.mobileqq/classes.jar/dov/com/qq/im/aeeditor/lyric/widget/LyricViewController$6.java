package dov.com.qq.im.aeeditor.lyric.widget;

import bpam;
import bpcs;
import bpcz;

public class LyricViewController$6
  implements Runnable
{
  public LyricViewController$6(bpcz parambpcz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bpcs != null) {
      this.this$0.jdField_a_of_type_Bpcs.a(this.a, this.b);
    }
    if ((this.this$0.jdField_a_of_type_DovComQqImAeeditorLyricWidgetLyricViewScroll != null) && (this.this$0.jdField_a_of_type_Bpcs != null))
    {
      if (!bpcz.a(this.this$0)) {
        break label68;
      }
      bpam.a("ModuleController", "current is selecting lyric. not auto scroll.");
    }
    label68:
    int i;
    do
    {
      return;
      i = this.this$0.jdField_a_of_type_Bpcs.a();
    } while (bpcz.a(this.this$0) == i);
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