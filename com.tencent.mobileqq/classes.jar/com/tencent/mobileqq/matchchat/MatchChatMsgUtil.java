package com.tencent.mobileqq.matchchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.QProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.utils.DateUtils;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MatchChatMsgUtil
{
  public static int a(AppInterface paramAppInterface)
  {
    int i = 0;
    if (paramAppInterface == null) {
      return 0;
    }
    if (!a(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MatchChatMsgUtil", 2, "isMatchChatRedPointSwitchOn false");
      }
      return 0;
    }
    IConversationFacade localIConversationFacade = (IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "");
    paramAppInterface = ((MsgProxyContainer)((QProxyManager)paramAppInterface.getProxyManagerInner()).getProxy(0)).a(1044).a(AppConstants.MATCH_CHAT_UIN, 1044);
    if (paramAppInterface == null)
    {
      QLog.i("MatchChatMsgUtil", 1, "getMatchChatRedPointNum null");
      return 0;
    }
    paramAppInterface = paramAppInterface.iterator();
    while (paramAppInterface.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramAppInterface.next();
      i += localIConversationFacade.getUnreadCount(localMessageRecord.senderuin, localMessageRecord.istroop);
    }
    return i;
  }
  
  public static Intent a(Context paramContext)
  {
    paramContext = new Intent(paramContext, PublicFragmentActivity.class);
    paramContext.putExtra("uintype", 1044);
    paramContext.putExtra("uin", AppConstants.MATCH_CHAT_UIN);
    paramContext.putExtra("public_fragment_class", MatchChatMsgListFragment.class.getName());
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.putExtra("uin", paramString);
    paramContext.putExtra("uintype", 1044);
    paramContext.putExtra("entrance", paramInt);
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public static BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = a(paramQQAppInterface);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("getMatchChatRedPointAppInfo num = ");
    paramQQAppInterface.append(i);
    QLog.i("MatchChatMsgUtil", 1, paramQQAppInterface.toString());
    paramQQAppInterface = new BusinessInfoCheckUpdate.AppInfo();
    paramQQAppInterface.path.set(paramString);
    paramQQAppInterface.num.set(i);
    paramQQAppInterface.type.set(2);
    paramQQAppInterface.iNewFlag.set(1);
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject1 = paramQQAppInterface.getMessageProxy(1044).a(AppConstants.MATCH_CHAT_UIN, 1044);
    if (localObject1 == null)
    {
      QLog.i("MatchChatMsgUtil", 1, "clearMatchChatMessageBox null");
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("clearMatchChatMessageBox, delete uin = ");
        ((StringBuilder)localObject2).append(localMessageRecord.senderuin);
        QLog.i("MatchChatMsgUtil", 1, ((StringBuilder)localObject2).toString());
      }
      Object localObject2 = localMessageRecord.senderuin;
      int i = localMessageRecord.istroop;
      paramQQAppInterface.getMessageFacade().a((String)localObject2, i);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentMatchChatListItem paramRecentMatchChatListItem, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramRecentMatchChatListItem == null) {
        return;
      }
      int i = paramQQAppInterface.getConversationFacade().a(paramRecentMatchChatListItem.getRecentUserUin(), paramRecentMatchChatListItem.getRecentUserType());
      if (paramBoolean) {
        paramQQAppInterface.getMessageFacade().a(AppConstants.MATCH_CHAT_UIN, 1044, paramRecentMatchChatListItem.getRecentUserUin(), paramQQAppInterface.getCurrentAccountUin());
      }
      if (i > 0) {
        paramQQAppInterface.getMessageFacade().a(paramRecentMatchChatListItem.getRecentUserUin(), paramRecentMatchChatListItem.getRecentUserType(), true, false);
      }
    }
  }
  
  public static void a(RedTouch paramRedTouch, BaseQQAppInterface paramBaseQQAppInterface)
  {
    ThreadManagerV2.excute(new MatchChatMsgUtil.1(paramBaseQQAppInterface, paramRedTouch), 16, null, false);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return true;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    long l = SharedPreUtils.g(paramQQAppInterface.getAccount()).getLong("expandinfo_banner_close_time", 0L);
    return DateUtils.a.a(7, l);
  }
  
  static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreUtils.g(paramQQAppInterface.getAccount()).edit().putLong("expandinfo_banner_close_time", System.currentTimeMillis()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgUtil
 * JD-Core Version:    0.7.0.1
 */