package dov.com.qq.im.ae.camera.ui.bottom;

import bnjw;
import bnka;
import bnkc;
import bnpf;
import java.util.Map;

public class AEBottomListAdapter$6$2
  implements Runnable
{
  public AEBottomListAdapter$6$2(bnka parambnka, bnpf parambnpf) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bnka.a.notifyDataSetChanged();
    if (bnjw.a(this.jdField_a_of_type_Bnka.a).get(this.jdField_a_of_type_Bnpf.a) != null) {
      ((bnkc)bnjw.a(this.jdField_a_of_type_Bnka.a).get(this.jdField_a_of_type_Bnpf.a)).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.6.2
 * JD-Core Version:    0.7.0.1
 */