package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.data.LocalFileAdapter;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.SlideDetectListView;

class LocalFileBrowserActivity$7
  implements View.OnLongClickListener
{
  LocalFileBrowserActivity$7(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileAdapter.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131365630, paramView.getContext().getString(2131691558));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, localQQCustomMenu, new LocalFileBrowserActivity.7.1(this, paramView), new LocalFileBrowserActivity.7.2(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity.7
 * JD-Core Version:    0.7.0.1
 */