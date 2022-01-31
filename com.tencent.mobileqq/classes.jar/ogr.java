import com.tencent.biz.qqstory.takevideo.EditVideoSave;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

public class ogr
  implements ProgressPieDrawable.OnProgressListener
{
  public ogr(EditVideoSave paramEditVideoSave) {}
  
  public void a(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditVideoSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
  }
  
  public void a(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogr
 * JD-Core Version:    0.7.0.1
 */