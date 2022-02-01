package cooperation.troop_homework.jsp;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class TroopHWJsPlugin$UploadMediaEntry
{
  TroopHWJsPlugin.RequestSource a;
  TroopHomeworkHelper.UploadFileTask b;
  int c;
  Bitmap d;
  String e;
  boolean f;
  String g;
  AtomicBoolean h = new AtomicBoolean(false);
  int i;
  TroopHomeworkHelper.UploadCallback j = new TroopHWJsPlugin.UploadMediaEntry.1(this);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry
 * JD-Core Version:    0.7.0.1
 */