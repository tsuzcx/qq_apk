package dov.com.qq.im.ae.camera.ui.bottom;

import bilv;
import bilx;
import bilz;
import bire;
import java.util.Map;

public class AEBottomListAdapter$4$3
  implements Runnable
{
  public AEBottomListAdapter$4$3(bilx parambilx, bire parambire, int paramInt) {}
  
  public void run()
  {
    if (bilv.a(this.jdField_a_of_type_Bilx.a).get(this.jdField_a_of_type_Bire.a) != null)
    {
      if ((this.jdField_a_of_type_Int < 100) && (!this.jdField_a_of_type_Bire.d) && (this.jdField_a_of_type_Bire.e)) {
        ((bilz)bilv.a(this.jdField_a_of_type_Bilx.a).get(this.jdField_a_of_type_Bire.a)).a(1);
      }
    }
    else {
      return;
    }
    ((bilz)bilv.a(this.jdField_a_of_type_Bilx.a).get(this.jdField_a_of_type_Bire.a)).a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.3
 * JD-Core Version:    0.7.0.1
 */