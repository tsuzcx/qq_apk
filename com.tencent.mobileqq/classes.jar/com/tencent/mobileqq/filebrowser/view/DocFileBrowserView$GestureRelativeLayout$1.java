package com.tencent.mobileqq.filebrowser.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;

class DocFileBrowserView$GestureRelativeLayout$1
  extends GestureDetector.SimpleOnGestureListener
{
  DocFileBrowserView$GestureRelativeLayout$1(DocFileBrowserView.GestureRelativeLayout paramGestureRelativeLayout, DocFileBrowserView paramDocFileBrowserView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.a();
      if (paramFloat2 > 0.0F)
      {
        if (paramMotionEvent1 != null) {
          paramMotionEvent1.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner.b(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner.b(true);
          return true;
        }
      }
      else
      {
        if (paramMotionEvent1 != null) {
          paramMotionEvent1.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCooperationBanner.a(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView$GestureRelativeLayout.jdField_a_of_type_ComTencentMobileqqFilebrowserViewDocFileBrowserView.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocCollectFormBanner.a(true);
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.GestureRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */