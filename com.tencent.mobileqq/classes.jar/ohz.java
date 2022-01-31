import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditPicSave;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;

public class ohz
  implements ThreadExcutor.IThreadListener
{
  public ohz(EditPicSave paramEditPicSave) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    int i = 1;
    this.a.a.a().postDelayed(new oia(this), 500L);
    if (CameraControl.a().a == 1) {}
    for (;;)
    {
      CaptureReportUtil.h(i);
      return;
      i = 2;
    }
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohz
 * JD-Core Version:    0.7.0.1
 */