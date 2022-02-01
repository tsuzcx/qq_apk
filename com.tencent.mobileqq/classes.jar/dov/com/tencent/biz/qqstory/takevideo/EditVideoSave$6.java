package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class EditVideoSave$6
  implements ProgressPieDrawable.OnProgressListener
{
  EditVideoSave$6(EditVideoSave paramEditVideoSave) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditVideoSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.6
 * JD-Core Version:    0.7.0.1
 */