package com.tencent.mobileqq.onlinestatus;

import android.widget.TextView;
import awcx;
import bdsp;
import com.tencent.qphone.base.util.QLog;

public class AccountPanel$17
  implements Runnable
{
  public AccountPanel$17(awcx paramawcx, TextView paramTextView) {}
  
  public void run()
  {
    this.a.setText(bdsp.a().a());
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "panel -> updateCustomOnlineStatus text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.17
 * JD-Core Version:    0.7.0.1
 */