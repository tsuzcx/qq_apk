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
  View a;
  private View.OnClickListener c = new QRCardActivity.8.2(this);
  
  QRCardActivity$8(QRCardActivity paramQRCardActivity) {}
  
  @SuppressLint({"ServiceCast", "NewApi"})
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        ((android.text.ClipboardManager)this.b.getSystemService("clipboard")).setText(paramString);
        return;
      }
      android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)this.b.getSystemService("clipboard");
      ClipboardMonitor.setText(localClipboardManager, paramString);
      localClipboardManager.setText(paramString);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    this.a = paramView;
    paramView.setSelected(true);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131431492, this.b.getString(2131888244), 2130839057);
    QRCardActivity.a(paramView, localQQCustomMenu, this.c, new QRCardActivity.8.1(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.activity.QRCardActivity.8
 * JD-Core Version:    0.7.0.1
 */