package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

class TroopFileUploadingManager$1
  extends BizTroopObserver
{
  TroopFileUploadingManager$1(TroopFileUploadingManager paramTroopFileUploadingManager) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.b == null) {
      return;
    }
    paramObject = (TroopFileStatusInfo)paramObject;
    if (paramObject.e == 12)
    {
      long l = paramObject.d;
      Iterator localIterator = this.a.b.getMessageFacade().o(String.valueOf(l), 1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ChatMessage)localIterator.next();
        if ((((ChatMessage)localObject).msgtype == -2017) && ((((ChatMessage)localObject).extraflag == 32772) || (((ChatMessage)localObject).extraflag == 32768)) && (((ChatMessage)localObject).isSendFromLocal()))
        {
          localObject = (MessageForTroopFile)localObject;
          if ((((MessageForTroopFile)localObject).uuid != null) && (((MessageForTroopFile)localObject).uuid.equals(paramObject.a.toString()))) {
            this.a.b.getMessageFacade().h(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
          } else if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject).url)) && (!TextUtils.isEmpty(paramObject.r)) && (((MessageForTroopFile)localObject).url.equals(paramObject.r))) {
            this.a.b.getMessageFacade().h(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUploadingManager.1
 * JD-Core Version:    0.7.0.1
 */