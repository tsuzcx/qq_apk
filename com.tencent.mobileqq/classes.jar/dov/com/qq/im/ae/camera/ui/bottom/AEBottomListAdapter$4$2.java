package dov.com.qq.im.ae.camera.ui.bottom;

import bncv;
import bncx;
import bncz;
import bnke;
import java.util.Map;

public class AEBottomListAdapter$4$2
  implements Runnable
{
  public AEBottomListAdapter$4$2(bncx parambncx, bnke parambnke) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bncx.a.notifyDataSetChanged();
    if (bncv.a(this.jdField_a_of_type_Bncx.a).get(this.jdField_a_of_type_Bnke.a) != null) {
      ((bncz)bncv.a(this.jdField_a_of_type_Bncx.a).get(this.jdField_a_of_type_Bnke.a)).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.4.2
 * JD-Core Version:    0.7.0.1
 */