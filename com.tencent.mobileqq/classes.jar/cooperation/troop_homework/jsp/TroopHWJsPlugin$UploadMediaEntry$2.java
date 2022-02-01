package cooperation.troop_homework.jsp;

import bnsq;
import bnta;
import com.tencent.qphone.base.util.QLog;

public class TroopHWJsPlugin$UploadMediaEntry$2
  implements Runnable
{
  public TroopHWJsPlugin$UploadMediaEntry$2(bnta parambnta) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "start upload!id = " + this.a.jdField_a_of_type_Int + " type = " + this.a.b);
    }
    this.a.jdField_a_of_type_Bnsq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2
 * JD-Core Version:    0.7.0.1
 */