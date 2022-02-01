package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bmpr;
import bmpu;
import bmpw;
import bmpx;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bmpr parambmpr, int paramInt, bmpx parambmpx) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bmpr.a(this.this$0)) {
      i = j + bmpr.a(this.this$0).size();
    }
    if (i - bmpr.a(this.this$0) > bmpr.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bmpr.a(this.this$0).size()) {
      return;
    }
    bmpu localbmpu = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bmpr.a(this.this$0).size()) {
          localbmpu = (bmpu)bmpr.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbmpu == null) {
          break;
        }
        if (localbmpu.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bmpr.a(this.this$0, localbmpu.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bmpr.a(this.this$0));
            i = (int)(i * bmpr.a(this.this$0));
            if (bmpr.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bmpr.a(this.this$0));
            localbmpu.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bmpr.a(this.this$0) != null) {
            bmpr.a(this.this$0).a(localbmpu.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bmpx == null) {
          break;
        }
        this.jdField_a_of_type_Bmpx.a(this.jdField_a_of_type_Int, localbmpu.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      label285:
      ((BitmapDrawable)???).setBounds(0, 0, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.3
 * JD-Core Version:    0.7.0.1
 */