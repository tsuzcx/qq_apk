package com.tencent.mobileqq.filebrowser;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase;

class FileBrowserActivity$4
  extends GestureDetector.SimpleOnGestureListener
{
  FileBrowserActivity$4(FileBrowserActivity paramFileBrowserActivity, int paramInt) {}
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent1 != null)
    {
      if (paramMotionEvent2 == null) {
        return false;
      }
      paramFloat1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      paramFloat2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / paramFloat1);
      if ((paramFloat1 <= -this.jdField_a_of_type_Int) && (paramFloat2 < 0.5F) && (FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity) != null) && (FileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity).a())) {
        return this.jdField_a_of_type_ComTencentMobileqqFilebrowserFileBrowserActivity.onBackEvent();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity.4
 * JD-Core Version:    0.7.0.1
 */