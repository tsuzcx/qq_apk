package dov.com.qq.im.ae.play;

import bkzx;
import blgj;
import java.util.List;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(blgj paramblgj, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.jdField_a_of_type_JavaLangString)) {
      blgj.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = blgj.a(this.this$0).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          bkzx localbkzx = (bkzx)localList.get(i);
          if ((localbkzx != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbkzx.b)))
          {
            blgj.a(this.this$0, i);
            if (blgj.a(this.this$0).a() != null) {
              blgj.a(this.this$0).a().b(this.jdField_a_of_type_Int);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */