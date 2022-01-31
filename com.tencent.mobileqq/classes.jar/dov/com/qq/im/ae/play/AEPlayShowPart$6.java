package dov.com.qq.im.ae.play;

import biqj;
import biwr;
import java.util.List;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(biwr parambiwr, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.jdField_a_of_type_JavaLangString)) {
      biwr.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = biwr.a(this.this$0).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          biqj localbiqj = (biqj)localList.get(i);
          if ((localbiqj != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbiqj.b)))
          {
            biwr.a(this.this$0, i);
            if (biwr.a(this.this$0).a() != null) {
              biwr.a(this.this$0).a().b(this.jdField_a_of_type_Int);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */