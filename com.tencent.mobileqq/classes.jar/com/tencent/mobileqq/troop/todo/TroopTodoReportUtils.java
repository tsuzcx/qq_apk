package com.tencent.mobileqq.troop.todo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;

public class TroopTodoReportUtils
{
  public static int a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool1 = TroopUtils.a(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin());
    boolean bool2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(paramQQAppInterface, Long.toString(paramLong), paramQQAppInterface.getCurrentUin());
    if (bool1) {
      return 1;
    }
    if (bool2) {
      return 2;
    }
    return 3;
  }
  
  public static int a(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof ChatMessage)) {
      return 10;
    }
    paramMessageRecord = (ChatMessage)paramMessageRecord;
    if ((paramMessageRecord instanceof MessageForText)) {
      return 1;
    }
    if ((paramMessageRecord instanceof MessageForMixedMsg)) {
      return 2;
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return 3;
    }
    if ((!(paramMessageRecord instanceof MessageForFile)) && (!(paramMessageRecord instanceof MessageForTroopFile)) && (!(paramMessageRecord instanceof MessageForDeviceFile)) && (!(paramMessageRecord instanceof MessageForDLFile)))
    {
      String str = b(paramMessageRecord);
      if ("com.tencent.mannounce".equals(str)) {
        return 6;
      }
      if ((!"com.tencent.qzone.albumShare".equals(str)) && (!"com.tencent.groupphoto".equals(str)))
      {
        if ((!str.isEmpty()) && (str.contains("com.tencent.miniapp"))) {
          return 7;
        }
        if ((!TroopEssenceUtil.a(paramMessageRecord)) && (!TroopEssenceUtil.b(paramMessageRecord))) {
          return 10;
        }
        return 9;
      }
      return 5;
    }
    return 4;
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    if (!(paramMessageRecord instanceof MessageForArkApp)) {
      return "";
    }
    paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.appName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.todo.TroopTodoReportUtils
 * JD-Core Version:    0.7.0.1
 */