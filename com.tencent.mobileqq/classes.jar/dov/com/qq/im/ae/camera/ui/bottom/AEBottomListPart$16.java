package dov.com.qq.im.ae.camera.ui.bottom;

import blpm;
import blpr;
import bluy;
import blvb;
import java.util.List;

public class AEBottomListPart$16
  implements Runnable
{
  public AEBottomListPart$16(blpr paramblpr) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Bluy.b(this.this$0.a());
    this.this$0.jdField_a_of_type_Blpm.a((List)localObject);
    localObject = bluy.a();
    if ((localObject == null) || (((blvb)localObject).equals(blvb.a)))
    {
      this.this$0.b(0);
      return;
    }
    blpr.a(this.this$0, (blvb)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16
 * JD-Core Version:    0.7.0.1
 */