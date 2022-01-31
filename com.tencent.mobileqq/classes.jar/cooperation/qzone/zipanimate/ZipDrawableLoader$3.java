package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bgmh;
import bgmk;
import bgmm;
import bgmn;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bgmh parambgmh, int paramInt, bgmn parambgmn) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bgmh.a(this.this$0)) {
      i = j + bgmh.a(this.this$0).size();
    }
    if (i - bgmh.a(this.this$0) > bgmh.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bgmh.a(this.this$0).size()) {
      return;
    }
    bgmk localbgmk = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bgmh.a(this.this$0).size()) {
          localbgmk = (bgmk)bgmh.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbgmk == null) {
          break;
        }
        if (localbgmk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bgmh.a(this.this$0, localbgmk.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bgmh.a(this.this$0));
            i = (int)(i * bgmh.a(this.this$0));
            if (bgmh.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bgmh.a(this.this$0));
            localbgmk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bgmh.a(this.this$0) != null) {
            bgmh.a(this.this$0).a(localbgmk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bgmn == null) {
          break;
        }
        this.jdField_a_of_type_Bgmn.a(this.jdField_a_of_type_Int, localbgmk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      label285:
      ((BitmapDrawable)???).setBounds(0, 0, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.3
 * JD-Core Version:    0.7.0.1
 */