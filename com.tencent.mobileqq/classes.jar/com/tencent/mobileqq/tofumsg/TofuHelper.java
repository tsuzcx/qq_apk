package com.tencent.mobileqq.tofumsg;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class TofuHelper
{
  private static void a(QQAppInterface paramQQAppInterface, BeancurdMsg paramBeancurdMsg)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().a(paramBeancurdMsg.frienduin, 0, null);
    int i = paramQQAppInterface.size();
    long l;
    if (i > 0)
    {
      paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(i - 1);
      if (paramQQAppInterface != null) {
        l = paramQQAppInterface.time - 1L;
      }
    }
    for (;;)
    {
      QLog.d("Tofu_TofuHelper", 1, String.format("fixTofuMsgTimeAtTop insertAtTop old.size=%d msgTime=%d", new Object[] { Integer.valueOf(i), Long.valueOf(l) }));
      paramBeancurdMsg.msgTime = l;
      return;
      l = -1L;
      continue;
      l = -1L;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BeancurdMsg paramBeancurdMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramBeancurdMsg.frienduin);
    QLog.d("Tofu_TofuHelper", 1, String.format("insertTofuMsg prefUpdate=%b [%s,%d] isFrd=%b", new Object[] { Boolean.valueOf(paramBoolean1), MobileQQ.getShortUinStr(paramBeancurdMsg.frienduin), Integer.valueOf(paramBeancurdMsg.busiid), Boolean.valueOf(bool) }));
    if (!bool) {}
    while ((paramBoolean1) && (a(paramQQAppInterface, paramBeancurdMsg))) {
      return;
    }
    BeancurdManager localBeancurdManager = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramBoolean2) {
      a(paramQQAppInterface, paramBeancurdMsg);
    }
    localBeancurdManager.a(paramBeancurdMsg);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Tofu_TofuHelper", 2, "onDelFriend " + paramString);
    }
    ((TofuManager)paramQQAppInterface.getManager(QQManagerFactory.TOFUMSG_MANAGER)).a(paramString);
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).b(paramString);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, BeancurdMsg paramBeancurdMsg)
  {
    boolean bool = false;
    int i = ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).a(paramBeancurdMsg.busiid);
    Object localObject = paramQQAppInterface.getMessageFacade().a(paramBeancurdMsg.frienduin, 0, new int[] { i });
    QLog.d("Tofu_TofuHelper", 1, new Object[] { "insertTofuMsg_updateWhenMsgExists old size=", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() > 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      if (localMessageRecord != null) {}
      for (long l = localMessageRecord.time;; l = MessageCache.a())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord != null)
          {
            paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgtype, localMessageRecord.uniseq);
            paramQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
          }
        }
      }
      localObject = "";
      if ((paramBeancurdMsg.buffer instanceof String)) {
        localObject = paramBeancurdMsg.buffer;
      }
      localMessageRecord = MessageRecordFactory.a(i);
      localMessageRecord.init(paramQQAppInterface.getAccount(), paramBeancurdMsg.frienduin, paramBeancurdMsg.frienduin, (String)localObject, l, i, 0, l);
      localMessageRecord.msg = paramBeancurdMsg.buffer;
      localMessageRecord.isread = true;
      if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
        paramQQAppInterface.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuHelper
 * JD-Core Version:    0.7.0.1
 */