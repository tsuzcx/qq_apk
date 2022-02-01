package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class EditVideoStoryButton$5
  implements ProgressPieDrawable.OnProgressListener
{
  EditVideoStoryButton$5(EditVideoStoryButton paramEditVideoStoryButton) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditVideoStoryButton", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoStoryButton.5
 * JD-Core Version:    0.7.0.1
 */