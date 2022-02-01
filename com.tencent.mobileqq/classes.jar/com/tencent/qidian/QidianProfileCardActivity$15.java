package com.tencent.qidian;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.widget.BubblePopupWindow;

class QidianProfileCardActivity$15
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QidianProfileCardActivity.15.1(this);
  public BubblePopupWindow a;
  public String a;
  
  QidianProfileCardActivity$15(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(i, HardCodeUtil.a(2131709720));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new QidianProfileCardActivity.15.DissmissListener(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.15
 * JD-Core Version:    0.7.0.1
 */