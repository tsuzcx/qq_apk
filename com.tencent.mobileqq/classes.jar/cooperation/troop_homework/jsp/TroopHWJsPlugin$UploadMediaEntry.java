package cooperation.troop_homework.jsp;

import android.graphics.Bitmap;
import anfw;
import anfx;
import anfz;
import anga;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopHWJsPlugin$UploadMediaEntry
{
  public int a;
  public Bitmap a;
  public anfw a;
  TroopHomeworkHelper.UploadCallback a;
  public TroopHomeworkHelper.UploadFileTask a;
  public String a;
  public AtomicBoolean a;
  public boolean a;
  public int b;
  String b;
  
  public TroopHWJsPlugin$UploadMediaEntry(TroopHWJsPlugin paramTroopHWJsPlugin)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback = new anfx(this);
  }
  
  public void a()
  {
    ThreadManager.postImmediately(new anfz(this), null, false);
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new anga(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry
 * JD-Core Version:    0.7.0.1
 */