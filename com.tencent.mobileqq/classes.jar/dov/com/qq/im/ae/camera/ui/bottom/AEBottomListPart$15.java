package dov.com.qq.im.ae.camera.ui.bottom;

import bncv;
import bnda;
import bnkb;
import bnke;
import java.util.List;

public class AEBottomListPart$15
  implements Runnable
{
  public AEBottomListPart$15(bnda parambnda) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Bnkb.b(this.this$0.a());
    this.this$0.jdField_a_of_type_Bncv.a((List)localObject);
    localObject = bnkb.a();
    if ((localObject == null) || (((bnke)localObject).equals(bnke.a)))
    {
      this.this$0.c(0);
      return;
    }
    bnda.a(this.this$0, (bnke)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.15
 * JD-Core Version:    0.7.0.1
 */