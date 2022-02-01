package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class EditVideoPartManager$7
  implements ProgressPieDrawable.OnProgressListener
{
  EditVideoPartManager$7(EditVideoPartManager paramEditVideoPartManager) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.publish.edit.EditVideoPartManager", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager.7
 * JD-Core Version:    0.7.0.1
 */