package cooperation.troop_homework.jsp;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopHWJsPlugin$UploadMediaEntry
{
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  TroopHomeworkHelper.UploadCallback jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback = new TroopHWJsPlugin.UploadMediaEntry.1(this);
  TroopHomeworkHelper.UploadFileTask jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask;
  TroopHWJsPlugin.RequestSource jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource;
  String jdField_a_of_type_JavaLangString;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  public TroopHWJsPlugin$UploadMediaEntry(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void a()
  {
    ThreadManager.postImmediately(new TroopHWJsPlugin.UploadMediaEntry.2(this), null, false);
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new TroopHWJsPlugin.UploadMediaEntry.3(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry
 * JD-Core Version:    0.7.0.1
 */