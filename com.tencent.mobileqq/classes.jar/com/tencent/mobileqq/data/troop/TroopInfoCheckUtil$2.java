package com.tencent.mobileqq.data.troop;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class TroopInfoCheckUtil$2
  implements Runnable
{
  TroopInfoCheckUtil$2(String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null) {
      DialogUtil.a(BaseActivity.sTopActivity, 230, null, this.a, null, "我知道了", new TroopInfoCheckUtil.2.1(this), null).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfoCheckUtil.2
 * JD-Core Version:    0.7.0.1
 */