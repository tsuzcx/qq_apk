package dov.com.qq.im.ae.play;

import bira;
import bixi;
import java.util.List;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(bixi parambixi, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.jdField_a_of_type_JavaLangString)) {
      bixi.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = bixi.a(this.this$0).a();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          bira localbira = (bira)localList.get(i);
          if ((localbira != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(localbira.b)))
          {
            bixi.a(this.this$0, i);
            if (bixi.a(this.this$0).a() != null) {
              bixi.a(this.this$0).a().b(this.jdField_a_of_type_Int);
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