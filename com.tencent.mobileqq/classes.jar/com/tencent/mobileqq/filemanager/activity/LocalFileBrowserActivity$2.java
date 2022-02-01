package com.tencent.mobileqq.filemanager.activity;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.widget.BubblePopupWindow;

class LocalFileBrowserActivity$2
  implements SlideDetectListView.OnSlideListener
{
  LocalFileBrowserActivity$2(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      paramView.setPressed(false);
    }
    do
    {
      return;
      paramSlideDetectListView = paramView.findViewById(2131377928);
      paramView = (FileInfo)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.getItem(paramInt);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(paramView);
    } while (paramSlideDetectListView == null);
    paramView = (Button)paramSlideDetectListView.findViewById(2131365625);
    paramView.setTag(Integer.valueOf(paramInt));
    paramView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ShaderAnimLayout)paramSlideDetectListView).a();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDeleteAreaDim(paramSlideDetectListView.getLayoutParams().width, paramSlideDetectListView.getLayoutParams().height);
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = paramView.findViewById(2131377928);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
    if (paramSlideDetectListView != null)
    {
      ((ShaderAnimLayout)paramSlideDetectListView).e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131365625);
      paramSlideDetectListView.setTag(null);
      paramSlideDetectListView.setOnClickListener(null);
    }
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */