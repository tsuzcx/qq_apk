package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QfileEditBottomBar$1
  implements ActionSheet.OnButtonClickListener
{
  QfileEditBottomBar$1(QfileEditBottomBar paramQfileEditBottomBar, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ThreadManager.executeOnFileThread(new QfileEditBottomBar.1.1(this));
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar.1
 * JD-Core Version:    0.7.0.1
 */