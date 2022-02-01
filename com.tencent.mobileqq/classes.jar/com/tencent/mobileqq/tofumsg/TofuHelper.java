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
    long l2 = -1L;
    long l1 = l2;
    if (i > 0)
    {
      paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(i - 1);
      l1 = l2;
      if (paramQQAppInterface != null) {
        l1 = paramQQAppInterface.time - 1L;
      }
    }
    QLog.d("Tofu_TofuHelper", 1, String.format("fixTofuMsgTimeAtTop insertAtTop old.size=%d msgTime=%d", new Object[] { Integer.valueOf(i), Long.valueOf(l1) }));
    paramBeancurdMsg.msgTime = l1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BeancurdMsg paramBeancurdMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramBeancurdMsg.frienduin);
    QLog.d("Tofu_TofuHelper", 1, String.format("insertTofuMsg prefUpdate=%b [%s,%d] isFrd=%b", new Object[] { Boolean.valueOf(paramBoolean1), MobileQQ.getShortUinStr(paramBeancurdMsg.frienduin), Integer.valueOf(paramBeancurdMsg.busiid), Boolean.valueOf(bool) }));
    if (!bool) {
      return;
    }
    if ((!paramBoolean1) || (!b(paramQQAppInterface, paramBeancurdMsg)))
    {
      BeancurdManager localBeancurdManager = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
      if (paramBoolean2) {
        a(paramQQAppInterface, paramBeancurdMsg);
      }
      localBeancurdManager.a(paramBeancurdMsg);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDelFriend ");
      localStringBuilder.append(paramString);
      QLog.i("Tofu_TofuHelper", 2, localStringBuilder.toString());
    }
    ((TofuManager)paramQQAppInterface.getManager(QQManagerFactory.TOFUMSG_MANAGER)).b(paramString);
    ((BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)).c(paramString);
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, BeancurdMsg paramBeancurdMsg)
  {
    Object localObject = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    int i = BeancurdManager.a(paramBeancurdMsg.busiid);
    localObject = paramQQAppInterface.getMessageFacade().a(paramBeancurdMsg.frienduin, 0, new int[] { i });
    QLog.d("Tofu_TofuHelper", 1, new Object[] { "insertTofuMsg_updateWhenMsgExists old size=", Integer.valueOf(((List)localObject).size()) });
    if (((List)localObject).size() > 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      long l;
      if (localMessageRecord != null) {
        l = localMessageRecord.time;
      } else {
        l = MessageCache.c();
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord != null)
        {
          paramQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgtype, localMessageRecord.uniseq);
          paramQQAppInterface.getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
      if ((paramBeancurdMsg.buffer instanceof String)) {
        localObject = paramBeancurdMsg.buffer;
      } else {
        localObject = "";
      }
      localMessageRecord = MessageRecordFactory.a(i);
      localMessageRecord.init(paramQQAppInterface.getAccount(), paramBeancurdMsg.frienduin, paramBeancurdMsg.frienduin, (String)localObject, l, i, 0, l);
      localMessageRecord.msg = paramBeancurdMsg.buffer;
      localMessageRecord.isread = true;
      if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageRecord, false)) {
        paramQQAppInterface.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuHelper
 * JD-Core Version:    0.7.0.1
 */