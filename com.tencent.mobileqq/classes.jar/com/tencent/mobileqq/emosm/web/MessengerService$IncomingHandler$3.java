package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MessengerService$IncomingHandler$3
  implements BusinessObserver
{
  MessengerService$IncomingHandler$3(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle1, MessengerService paramMessengerService, Bundle paramBundle2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {}
    try
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (!paramObject.isEmpty())
        {
          this.a.putString("diyText", ((BubbleDiyEntity)paramObject.get(0)).diyText);
          this.a.putString("isDiy", "1");
          this.a.putString("tl", ((BubbleDiyEntity)paramObject.get(0)).topLeftId);
          this.a.putString("tr", ((BubbleDiyEntity)paramObject.get(0)).topRightId);
          this.a.putString("bl", ((BubbleDiyEntity)paramObject.get(0)).bottomLeftId);
          this.a.putString("br", ((BubbleDiyEntity)paramObject.get(0)).bottomRightId);
        }
      }
      else
      {
        this.a.putString("diyText", "");
      }
      this.b.a(this.c);
      return;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.emoji.web.MessengerService", 2, paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.3
 * JD-Core Version:    0.7.0.1
 */