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

class MessengerService$11
  extends QidianBusinessObserver
{
  MessengerService$11(MessengerService paramMessengerService) {}
  
  protected void h(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    try
    {
      localQQAppInterface = (QQAppInterface)MessengerService.l(this.a);
      if (localQQAppInterface == null) {
        break label237;
      }
      localQQAppInterface.removeObserver(this);
      if ((!paramBoolean) || (paramHashMap == null) || (paramHashMap.isEmpty()) || (!paramHashMap.containsKey("sigmsg")) || (!paramHashMap.containsKey("request_type")) || (!paramHashMap.containsKey("uin"))) {
        break label237;
      }
      byte[] arrayOfByte = (byte[])paramHashMap.get("sigmsg");
      str1 = String.valueOf(paramHashMap.get("request_type"));
      str2 = String.valueOf(paramHashMap.get("uin"));
      if (arrayOfByte != null) {
        localQQAppInterface.getMsgCache().c(str2, arrayOfByte);
      }
      i = CrmUtils.f(localQQAppInterface, str2);
      if (i == 0)
      {
        paramHashMap = ContactUtils.c(localQQAppInterface, str2);
      }
      else
      {
        if (!paramHashMap.containsKey("nickname")) {
          break label241;
        }
        paramHashMap = String.valueOf(paramHashMap.get("nickname"));
      }
    }
    catch (Exception paramHashMap)
    {
      QQAppInterface localQQAppInterface;
      String str1;
      String str2;
      int i;
      if (!QLog.isColorLevel()) {
        break label237;
      }
      QLog.d("MessengerService", 2, "onGetSigmsg ", paramHashMap);
    }
    if ((i != 1024) && (i != 1025)) {
      i = VideoController.a(i, false, 1);
    }
    for (;;)
    {
      paramBoolean = str1.equals("audio");
      ChatActivityUtils.a(localQQAppInterface, localQQAppInterface.getApp(), i, str2, paramHashMap, "", paramBoolean, null, true, true, null, "from_internal", null);
      return;
      label237:
      return;
      break;
      label241:
      paramHashMap = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.11
 * JD-Core Version:    0.7.0.1
 */