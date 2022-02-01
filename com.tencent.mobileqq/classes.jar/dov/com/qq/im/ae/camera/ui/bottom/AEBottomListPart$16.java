package dov.com.qq.im.ae.camera.ui.bottom;

import bolg;
import boll;
import boqr;
import boqu;
import java.util.List;

public class AEBottomListPart$16
  implements Runnable
{
  public AEBottomListPart$16(boll paramboll) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Boqr.b(this.this$0.a());
    this.this$0.jdField_a_of_type_Bolg.a((List)localObject);
    localObject = boqr.a();
    if ((localObject == null) || (((boqu)localObject).equals(boqu.a)))
    {
      boll.a(this.this$0, 0);
      return;
    }
    boll.a(this.this$0, (boqu)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.16
 * JD-Core Version:    0.7.0.1
 */