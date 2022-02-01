package cooperation.troop_homework.jsp;

import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;

class TroopHWJsPlugin$UploadMediaEntry$2
  implements Runnable
{
  TroopHWJsPlugin$UploadMediaEntry$2(TroopHWJsPlugin.UploadMediaEntry paramUploadMediaEntry) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHWJsPlugin", 2, "start upload!id = " + this.a.jdField_a_of_type_Int + " type = " + this.a.b);
    }
    this.a.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2
 * JD-Core Version:    0.7.0.1
 */