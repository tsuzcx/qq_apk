package dov.com.qq.im.ae.play;

import boqq;
import boxb;
import java.util.List;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(boxb paramboxb, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.jdField_a_of_type_JavaLangString)) {
      boxb.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = boxb.a(this.this$0).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          boqq localboqq = (boqq)localList.get(i);
          if ((localboqq != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localboqq.b)))
          {
            boxb.a(this.this$0, i);
            if (boxb.a(this.this$0).a() != null) {
              boxb.a(this.this$0).a().b(this.jdField_a_of_type_Int);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */