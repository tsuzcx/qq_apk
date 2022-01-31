package dov.com.qq.im.ae.play;

import bkvq;
import blcc;
import java.util.List;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(blcc paramblcc, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.jdField_a_of_type_JavaLangString)) {
      blcc.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = blcc.a(this.this$0).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          bkvq localbkvq = (bkvq)localList.get(i);
          if ((localbkvq != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbkvq.b)))
          {
            blcc.a(this.this$0, i);
            if (blcc.a(this.this$0).a() != null) {
              blcc.a(this.this$0).a().b(this.jdField_a_of_type_Int);
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