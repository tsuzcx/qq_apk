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
  public String a = "";
  public BubblePopupWindow b = null;
  private View.OnClickListener d = new QidianProfileCardActivity.15.1(this);
  
  QidianProfileCardActivity$15(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.a = String.valueOf(paramView.getTag());
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(i, HardCodeUtil.a(2131907433));
    this.b = BubbleContextMenu.a(paramView, localQQCustomMenu, this.d);
    this.b.setOnDismissListener(new QidianProfileCardActivity.15.DissmissListener(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.15
 * JD-Core Version:    0.7.0.1
 */