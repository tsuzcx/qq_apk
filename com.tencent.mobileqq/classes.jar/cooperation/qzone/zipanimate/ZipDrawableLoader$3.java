package cooperation.qzone.zipanimate;

import android.graphics.drawable.BitmapDrawable;
import bjxa;
import bjxd;
import bjxf;
import bjxg;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZipDrawableLoader$3
  implements Runnable
{
  public ZipDrawableLoader$3(bjxa parambjxa, int paramInt, bjxg parambjxg) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < bjxa.a(this.this$0)) {
      i = j + bjxa.a(this.this$0).size();
    }
    if (i - bjxa.a(this.this$0) > bjxa.b(this.this$0)) {}
    while (this.jdField_a_of_type_Int >= bjxa.a(this.this$0).size()) {
      return;
    }
    bjxd localbjxd = null;
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (this.jdField_a_of_type_Int < bjxa.a(this.this$0).size()) {
          localbjxd = (bjxd)bjxa.a(this.this$0).get(this.jdField_a_of_type_Int);
        }
        if (localbjxd == null) {
          break;
        }
        if (localbjxd.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null)
        {
          ??? = bjxa.a(this.this$0, localbjxd.jdField_a_of_type_JavaLangString);
          if (??? != null)
          {
            j = ((BitmapDrawable)???).getIntrinsicWidth();
            i = ((BitmapDrawable)???).getIntrinsicHeight();
            j = (int)(j * bjxa.a(this.this$0));
            i = (int)(i * bjxa.a(this.this$0));
            if (bjxa.a(this.this$0) == null) {
              break label285;
            }
            ((BitmapDrawable)???).setBounds(bjxa.a(this.this$0));
            localbjxd.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = ((BitmapDrawable)???);
          }
        }
        if (!this.this$0.a)
        {
          this.this$0.a = true;
          if (bjxa.a(this.this$0) != null) {
            bjxa.a(this.this$0).a(localbjxd.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
          }
        }
        if (this.jdField_a_of_type_Bjxg == null) {
          break;
        }
        this.jdField_a_of_type_Bjxg.a(this.jdField_a_of_type_Int, localbjxd.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable);
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