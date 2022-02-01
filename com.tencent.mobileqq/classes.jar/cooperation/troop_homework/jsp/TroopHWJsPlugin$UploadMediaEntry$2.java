package cooperation.troop_homework.jsp;

import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;

class TroopHWJsPlugin$UploadMediaEntry$2
  implements Runnable
{
  TroopHWJsPlugin$UploadMediaEntry$2(TroopHWJsPlugin.UploadMediaEntry paramUploadMediaEntry) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start upload!id = ");
      localStringBuilder.append(this.a.jdField_a_of_type_Int);
      localStringBuilder.append(" type = ");
      localStringBuilder.append(this.a.b);
      QLog.d("TroopHWJsPlugin", 2, localStringBuilder.toString());
    }
    this.a.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry.2
 * JD-Core Version:    0.7.0.1
 */