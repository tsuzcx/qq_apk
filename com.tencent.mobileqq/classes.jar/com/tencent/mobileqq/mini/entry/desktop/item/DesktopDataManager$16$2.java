package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class DesktopDataManager$16$2
  implements WtTicketPromise
{
  DesktopDataManager$16$2(DesktopDataManager.16 param16) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (!TextUtils.isEmpty(paramTicket.getPSkey("qzone.qq.com")))) {
      QLog.d("DesktopDataManager", 1, "Done success.");
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    QLog.e("DesktopDataManager", 1, "Failed : " + paramErrMsg);
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    QLog.e("DesktopDataManager", 1, "Timeout : " + paramErrMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.16.2
 * JD-Core Version:    0.7.0.1
 */