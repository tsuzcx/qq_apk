package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bhvp;
import bhvs;
import bhvu;
import bhvv;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bhvp parambhvp, int paramInt, bhvv parambhvv) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bhvp.a(this.this$0)) {
      i = j + bhvp.a(this.this$0).size();
    }
    if (i - bhvp.a(this.this$0) > bhvp.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bhvp.a(this.this$0).size()) {
      return;
    }
    bhvs localbhvs = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bhvp.a(this.this$0).size()) {
          localbhvs = (bhvs)bhvp.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbhvs == null) {
          break;
        }
        if (localbhvs.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bhvp.a(this.this$0, localbhvs.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bhvp.a(this.this$0));
            i = (int)(i * bhvp.a(this.this$0));
            if (bhvp.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bhvp.a(this.this$0));
            localbhvs.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bhvp.a(this.this$0) != null) {
            bhvp.a(this.this$0).a(localbhvs.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bhvv == null) {
          break;
        }
        this.jdField_a_of_type_Bhvv.a(this.jdField_a_of_type_Int, localbhvs.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
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