package dov.com.qq.im.ae.camera.ui.bottom;

import blpm;
import blpo;
import blpq;
import blvb;
import java.util.Map;

public class AEBottomListAdapter$4$3
  implements Runnable
{
  public AEBottomListAdapter$4$3(blpo paramblpo, blvb paramblvb, int paramInt) {}
  
  public void run()
  {
    if (blpm.a(this.jdField_a_of_type_Blpo.a).get(this.jdField_a_of_type_Blvb.a) != null)
    {
      if ((this.jdField_a_of_type_Int < 100) && (!this.jdField_a_of_type_Blvb.e) && (this.jdField_a_of_type_Blvb.f)) {
        ((blpq)blpm.a(this.jdField_a_of_type_Blpo.a).get(this.jdField_a_of_type_Blvb.a)).a(1);
      }
    }
    else {
      return;
    }
    ((blpq)blpm.a(this.jdField_a_of_type_Blpo.a).get(this.jdField_a_of_type_Blvb.a)).a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.3
 * JD-Core Version:    0.7.0.1
 */