package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import bejb;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$7
  implements bejb
{
  ThemeDIYActivity$7(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "mSaveStyleCallback: operateType:" + paramInt1 + ", stateCode:" + paramInt2);
    }
    if (paramInt2 == 8) {
      ThemeDIYActivity.access$400(this.this$0, paramInt1);
    }
    if ((13 == paramInt1) && (paramBundle != null))
    {
      if (!ThemeDIYActivity.access$500(this.this$0, paramInt2, paramBundle)) {}
    }
    else {
      do
      {
        return 0;
        if ((14 != paramInt1) || (paramBundle == null)) {
          break;
        }
      } while (ThemeDIYActivity.access$600(this.this$0, paramInt2, paramBundle));
    }
    for (;;)
    {
      if ((paramBundle != null) && (paramBundle.getInt("nextOperate") == 10))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "StyleCallBack next task: save.");
        }
        this.this$0.mHandler.removeMessages(22);
        this.this$0.mHandler.sendMessageDelayed(Message.obtain(this.this$0.mHandler, 22, null), 50L);
      }
      return 1;
      if (16 == paramInt1) {
        ThemeDIYActivity.access$700(this.this$0, paramInt2, paramBundle);
      } else if (15 == paramInt1) {
        ThemeDIYActivity.access$800(this.this$0, paramInt2);
      } else if (18 == paramInt1) {
        ThemeDIYActivity.access$900(this.this$0, paramInt2, paramBundle, paramResData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.7
 * JD-Core Version:    0.7.0.1
 */