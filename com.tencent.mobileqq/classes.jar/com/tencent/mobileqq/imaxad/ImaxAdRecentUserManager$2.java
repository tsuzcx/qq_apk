package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class ImaxAdRecentUserManager$2
  implements Runnable
{
  ImaxAdRecentUserManager$2(ImaxAdRecentUserManager paramImaxAdRecentUserManager, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    Object localObject = this.a.getMessageFacade();
    if (localObject != null) {
      localObject = ((QQMessageFacade)localObject).getLastMessage(this.b, this.c);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if ("false".equals(((Message)localObject).getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        ((Message)localObject).saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.a.getMessageFacade().a(((Message)localObject).frienduin, ((Message)localObject).msgtype, ((Message)localObject).uniseq, "extStr", ((Message)localObject).extStr);
        if (this.d.g != null) {
          ReportController.a(this.a, "dc00898", "", this.d.g.a, "0X8008F5E", "0X8008F5E", 0, 0, this.d.g.c, "", PublicAccountAdUtil.c(), this.d.g.b);
        }
      }
      if (this.d.g != null)
      {
        ReportController.a(this.a, "dc00898", "", this.d.g.a, "0X8008F60", "0X8008F60", 0, 0, this.d.g.c, "", "", this.d.g.b);
        if (this.d.g.H == 2) {
          ImaxAdPresenter.a().b(this.d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager.2
 * JD-Core Version:    0.7.0.1
 */