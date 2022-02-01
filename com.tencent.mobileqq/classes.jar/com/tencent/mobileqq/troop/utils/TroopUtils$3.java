package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

final class TroopUtils$3
  implements Runnable
{
  TroopUtils$3(Context paramContext) {}
  
  public void run()
  {
    Context localContext = this.a;
    DialogUtil.a(localContext, 230, null, localContext.getString(2131691876), this.a.getString(2131694583), null, null, new TroopUtils.3.1(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUtils.3
 * JD-Core Version:    0.7.0.1
 */