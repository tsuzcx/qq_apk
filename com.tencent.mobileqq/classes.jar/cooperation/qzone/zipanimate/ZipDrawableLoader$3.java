package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bnqv;
import bnqy;
import bnra;
import bnrb;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bnqv parambnqv, int paramInt, bnrb parambnrb) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bnqv.a(this.this$0)) {
      i = j + bnqv.a(this.this$0).size();
    }
    if (i - bnqv.a(this.this$0) > bnqv.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bnqv.a(this.this$0).size()) {
      return;
    }
    bnqy localbnqy = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bnqv.a(this.this$0).size()) {
          localbnqy = (bnqy)bnqv.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbnqy == null) {
          break;
        }
        if (localbnqy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bnqv.a(this.this$0, localbnqy.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bnqv.a(this.this$0));
            i = (int)(i * bnqv.a(this.this$0));
            if (bnqv.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bnqv.a(this.this$0));
            localbnqy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bnqv.a(this.this$0) != null) {
            bnqv.a(this.this$0).a(localbnqy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bnrb == null) {
          break;
        }
        this.jdField_a_of_type_Bnrb.a(this.jdField_a_of_type_Int, localbnqy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
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