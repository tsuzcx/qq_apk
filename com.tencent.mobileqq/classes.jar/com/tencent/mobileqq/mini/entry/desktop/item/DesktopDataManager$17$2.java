package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class DesktopDataManager$17$2
  implements WtTicketPromise
{
  DesktopDataManager$17$2(DesktopDataManager.17 param17) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (!TextUtils.isEmpty(paramTicket.getPSkey("qzone.qq.com")))) {
      QLog.d("DesktopDataManager", 1, "Done success.");
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed : ");
    localStringBuilder.append(paramErrMsg);
    QLog.e("DesktopDataManager", 1, localStringBuilder.toString());
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Timeout : ");
    localStringBuilder.append(paramErrMsg);
    QLog.e("DesktopDataManager", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.17.2
 * JD-Core Version:    0.7.0.1
 */