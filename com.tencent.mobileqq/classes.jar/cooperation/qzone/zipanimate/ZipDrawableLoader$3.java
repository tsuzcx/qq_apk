package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bhuy;
import bhvb;
import bhvd;
import bhve;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bhuy parambhuy, int paramInt, bhve parambhve) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bhuy.a(this.this$0)) {
      i = j + bhuy.a(this.this$0).size();
    }
    if (i - bhuy.a(this.this$0) > bhuy.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bhuy.a(this.this$0).size()) {
      return;
    }
    bhvb localbhvb = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bhuy.a(this.this$0).size()) {
          localbhvb = (bhvb)bhuy.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbhvb == null) {
          break;
        }
        if (localbhvb.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bhuy.a(this.this$0, localbhvb.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bhuy.a(this.this$0));
            i = (int)(i * bhuy.a(this.this$0));
            if (bhuy.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bhuy.a(this.this$0));
            localbhvb.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bhuy.a(this.this$0) != null) {
            bhuy.a(this.this$0).a(localbhvb.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bhve == null) {
          break;
        }
        this.jdField_a_of_type_Bhve.a(this.jdField_a_of_type_Int, localbhvb.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
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