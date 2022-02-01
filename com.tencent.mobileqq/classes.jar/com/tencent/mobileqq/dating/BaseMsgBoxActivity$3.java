package com.tencent.mobileqq.dating;

import android.content.Intent;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;

class BaseMsgBoxActivity$3
  implements TabBarView.OnTabChangeListener
{
  BaseMsgBoxActivity$3(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BaseMsgBoxActivity, onTabSelected: old=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", cur=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", msgTabIdx=");
      ((StringBuilder)localObject).append(this.a.mMsgBoxTabIndex);
      ((StringBuilder)localObject).append(", unReadMsgNum=");
      ((StringBuilder)localObject).append(this.a.mUnReadMsgNum);
      QLog.d("nearby.msgbox.tab", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == this.a.mMsgBoxTabIndex) && (paramInt2 != this.a.mMsgBoxTabIndex))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("curIndex", paramInt2);
      if (this.a.mIsNeedShowRedDot) {
        paramInt1 = this.a.mUnReadMsgNum;
      } else {
        paramInt1 = 0;
      }
      ((Intent)localObject).putExtra("unReadMsgNum", paramInt1);
      this.a.setResult(-1, (Intent)localObject);
      this.a.finish();
      this.a.overridePendingTransition(2130772275, 2130772275);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.msgbox.tab", 2, "finish");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.3
 * JD-Core Version:    0.7.0.1
 */