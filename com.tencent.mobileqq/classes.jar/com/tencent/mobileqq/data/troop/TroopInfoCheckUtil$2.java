package com.tencent.mobileqq.data.troop;

import arvr;
import bhdj;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class TroopInfoCheckUtil$2
  implements Runnable
{
  public TroopInfoCheckUtil$2(String paramString) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null) {
      bhdj.a(BaseActivity.sTopActivity, 230, null, this.a, null, "我知道了", new arvr(this), null).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.troop.TroopInfoCheckUtil.2
 * JD-Core Version:    0.7.0.1
 */