package com.tencent.mobileqq.dating;

import android.content.Intent;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;

class BaseMsgBoxActivity$3
  implements TabBarView.OnTabChangeListener
{
  BaseMsgBoxActivity$3(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "BaseMsgBoxActivity, onTabSelected: old=" + paramInt1 + ", cur=" + paramInt2 + ", msgTabIdx=" + this.a.b + ", unReadMsgNum=" + this.a.c);
    }
    Intent localIntent;
    if ((paramInt1 == this.a.b) && (paramInt2 != this.a.b))
    {
      localIntent = new Intent();
      localIntent.putExtra("curIndex", paramInt2);
      if (!this.a.e) {
        break label176;
      }
    }
    label176:
    for (paramInt1 = this.a.c;; paramInt1 = 0)
    {
      localIntent.putExtra("unReadMsgNum", paramInt1);
      this.a.setResult(-1, localIntent);
      this.a.finish();
      this.a.overridePendingTransition(2130772247, 2130772247);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "finish");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.3
 * JD-Core Version:    0.7.0.1
 */