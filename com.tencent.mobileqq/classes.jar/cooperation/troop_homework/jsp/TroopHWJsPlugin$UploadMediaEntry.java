package cooperation.troop_homework.jsp;

import ampr;
import amps;
import ampu;
import ampv;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopHWJsPlugin$UploadMediaEntry
{
  public int a;
  public ampr a;
  public Bitmap a;
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
    this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadCallback = new amps(this);
  }
  
  public void a()
  {
    ThreadManager.postImmediately(new ampu(this), null, false);
  }
  
  public void b()
  {
    ThreadManager.postImmediately(new ampv(this), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry
 * JD-Core Version:    0.7.0.1
 */