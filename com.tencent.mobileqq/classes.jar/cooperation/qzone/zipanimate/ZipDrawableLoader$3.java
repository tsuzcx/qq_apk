package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bkbh;
import bkbk;
import bkbm;
import bkbn;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bkbh parambkbh, int paramInt, bkbn parambkbn) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bkbh.a(this.this$0)) {
      i = j + bkbh.a(this.this$0).size();
    }
    if (i - bkbh.a(this.this$0) > bkbh.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bkbh.a(this.this$0).size()) {
      return;
    }
    bkbk localbkbk = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bkbh.a(this.this$0).size()) {
          localbkbk = (bkbk)bkbh.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbkbk == null) {
          break;
        }
        if (localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bkbh.a(this.this$0, localbkbk.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bkbh.a(this.this$0));
            i = (int)(i * bkbh.a(this.this$0));
            if (bkbh.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bkbh.a(this.this$0));
            localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bkbh.a(this.this$0) != null) {
            bkbh.a(this.this$0).a(localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bkbn == null) {
          break;
        }
        this.jdField_a_of_type_Bkbn.a(this.jdField_a_of_type_Int, localbkbk.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
        return;
      }
      label285:
      ((BitmapDrawable)???).setBounds(0, 0, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoader.3
 * JD-Core Version:    0.7.0.1
 */