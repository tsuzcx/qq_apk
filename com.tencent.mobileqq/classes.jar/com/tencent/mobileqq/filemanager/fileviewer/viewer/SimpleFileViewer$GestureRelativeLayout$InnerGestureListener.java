package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;

class SimpleFileViewer$GestureRelativeLayout$InnerGestureListener
  implements GestureDetector.OnGestureListener
{
  private SimpleFileViewer$GestureRelativeLayout$InnerGestureListener(SimpleFileViewer.GestureRelativeLayout paramGestureRelativeLayout) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = this.a.a.b();
      if (paramFloat2 <= 0.0F) {
        break label97;
      }
      if (paramMotionEvent1 != null) {
        paramMotionEvent1.setVisibility(8);
      }
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner != null) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner.b(true);
      }
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner != null) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner.b(true);
      }
    }
    label97:
    do
    {
      do
      {
        return false;
      } while (paramFloat2 >= 0.0F);
      if (paramMotionEvent1 != null) {
        paramMotionEvent1.setVisibility(0);
      }
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner != null) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner.a(true);
      }
    } while (this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner == null);
    this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner.a(true);
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.GestureRelativeLayout.InnerGestureListener
 * JD-Core Version:    0.7.0.1
 */