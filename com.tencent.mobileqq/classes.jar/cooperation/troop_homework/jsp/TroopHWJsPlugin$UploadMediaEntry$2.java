package cooperation.troop_homework.jsp;

import bkdb;
import bkdl;
import com.tencent.qphone.base.util.QLog;

public class TroopHWJsPlugin$UploadMediaEntry$2
  implements Runnable
{
  public TroopHWJsPlugin$UploadMediaEntry$2(bkdl parambkdl) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "start upload!id = " + this.a.jdField_a_of_type_Int + " type = " + this.a.b);
    }
    this.a.jdField_a_of_type_Bkdb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2
 * JD-Core Version:    0.7.0.1
 */