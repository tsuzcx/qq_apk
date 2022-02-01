package com.tencent.mobileqq.emosm.web;

import com.tencent.av.VideoController;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class MessengerService$12
  extends QidianBusinessObserver
{
  MessengerService$12(MessengerService paramMessengerService) {}
  
  public void h(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MessengerService.j(this.a);
      if (localQQAppInterface != null)
      {
        localQQAppInterface.removeObserver(this);
        if ((paramBoolean) && (paramHashMap != null) && (!paramHashMap.isEmpty()) && (paramHashMap.containsKey("sigmsg")) && (paramHashMap.containsKey("request_type")) && (paramHashMap.containsKey("uin")))
        {
          Object localObject = (byte[])paramHashMap.get("sigmsg");
          String str1 = String.valueOf(paramHashMap.get("request_type"));
          String str2 = String.valueOf(paramHashMap.get("uin"));
          if (localObject != null) {
            localQQAppInterface.getMsgCache().c(str2, (byte[])localObject);
          }
          int j = CrmUtils.b(localQQAppInterface, str2);
          localObject = "";
          if (j == 0) {
            localObject = ContactUtils.i(localQQAppInterface, str2);
          }
          for (;;)
          {
            int i = j;
            if (j != 1024)
            {
              i = j;
              if (j != 1025) {
                i = VideoController.a(j, false, 1);
              }
            }
            paramBoolean = str1.equals("audio");
            ChatActivityUtils.a(localQQAppInterface, localQQAppInterface.getApp(), i, str2, (String)localObject, "", paramBoolean, null, true, true, null, "from_internal", null);
            return;
            if (paramHashMap.containsKey("nickname")) {
              localObject = String.valueOf(paramHashMap.get("nickname"));
            }
          }
        }
      }
      return;
    }
    catch (Exception paramHashMap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessengerService", 2, "onGetSigmsg ", paramHashMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.12
 * JD-Core Version:    0.7.0.1
 */