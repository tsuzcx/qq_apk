package com.tencent.mobileqq.qrscan.activity;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class QRCardActivity$8
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QRCardActivity.8.2(this);
  View jdField_a_of_type_AndroidViewView;
  
  QRCardActivity$8(QRCardActivity paramQRCardActivity) {}
  
  @SuppressLint({"ServiceCast", "NewApi"})
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        ((android.text.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqQrscanActivityQRCardActivity.getSystemService("clipboard")).setText(paramString);
        return;
      }
      android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqQrscanActivityQRCardActivity.getSystemService("clipboard");
      ClipboardMonitor.setText(localClipboardManager, paramString);
      localClipboardManager.setText(paramString);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131365311, this.jdField_a_of_type_ComTencentMobileqqQrscanActivityQRCardActivity.getString(2131691294), 2130838903);
    QRCardActivity.a(paramView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener, new QRCardActivity.8.1(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.8
 * JD-Core Version:    0.7.0.1
 */