package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class ConfessMsgUtil
{
  public static boolean a = false;
  public static final String b = HardCodeUtil.a(2131900582);
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1033) {
      return (0x200000 | paramInt2 << 3) >>> 3;
    }
    if (paramInt1 == 1034) {
      return paramInt2;
    }
    return 0;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    int i;
    if (paramMessageRecord.isSelfConfessor()) {
      i = 1033;
    } else {
      i = 1034;
    }
    Message localMessage = paramQQAppInterface.getMessageFacade().b(paramMessageRecord.senderuin, i, paramMessageRecord.getConfessTopicId());
    if (localMessage != null) {
      return paramQQAppInterface.getMessageFacade().a(paramMessageRecord.senderuin, i, localMessage.uniseq);
    }
    return paramMessageRecord;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ConfessInfo paramConfessInfo, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if ((paramConfessInfo.isSysMsg == 1) && (!TextUtils.equals(paramConfessInfo.confessorUinStr, str))) {
      return HardCodeUtil.a(2131900579);
    }
    if (!TextUtils.equals(paramConfessInfo.confessorUinStr, str)) {
      return paramConfessInfo.confessorNick;
    }
    return ContactUtils.a(paramQQAppInterface, paramString, true);
  }
  
  public static im_msg_body.Elem a(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("ext_key_frd_chat_confess_info");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject = ConfessManager.FrdChatExtra.a(str);
    if (localObject == null) {
      return null;
    }
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    hummer_commelem.MsgElemInfo_servtype21 localMsgElemInfo_servtype21 = new hummer_commelem.MsgElemInfo_servtype21();
    hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext localC2CConfessContext = new hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext();
    localC2CConfessContext.uint64_confessor_uin.set(Long.parseLong(((ConfessManager.FrdChatExtra)localObject).i));
    localC2CConfessContext.uint64_confess_to_uin.set(Long.parseLong(((ConfessManager.FrdChatExtra)localObject).h));
    localC2CConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
    localC2CConfessContext.bytes_confess.set(ByteStringMicro.copyFromUtf8(((ConfessManager.FrdChatExtra)localObject).j));
    localC2CConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((ConfessManager.FrdChatExtra)localObject).k));
    localC2CConfessContext.uint64_confess_time.set(((ConfessManager.FrdChatExtra)localObject).l);
    localC2CConfessContext.uint32_bg_type.set(((ConfessManager.FrdChatExtra)localObject).b);
    localC2CConfessContext.uint32_topic_id.set(((ConfessManager.FrdChatExtra)localObject).a);
    localC2CConfessContext.uint32_confessor_sex.set(((ConfessManager.FrdChatExtra)localObject).c);
    localC2CConfessContext.uint32_confess_num.set(((ConfessManager.FrdChatExtra)localObject).d);
    localC2CConfessContext.uint32_biz_type.set(((ConfessManager.FrdChatExtra)localObject).f);
    localC2CConfessContext.uint32_confess_to_sex.set(((ConfessManager.FrdChatExtra)localObject).e);
    localMsgElemInfo_servtype21.c2c_confess_ctx.set(localC2CConfessContext);
    localObject = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject).uint32_service_type.set(21);
    ((im_msg_body.CommonElem)localObject).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype21.toByteArray()));
    ((im_msg_body.CommonElem)localObject).uint32_business_type.set(2);
    localElem.common_elem.set((MessageMicro)localObject);
    paramMessageRecord.removeExtInfoToExtStr("ext_key_frd_chat_confess_info");
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfoElem frdChatConfessJson:%s  frienduin:%s senderuin:%s", new Object[] { str, paramMessageRecord.frienduin, paramMessageRecord.senderuin }));
    }
    return localElem;
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_confess_topicid", paramInt2);
    localIntent.putExtra("entrance", 1);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(AppInterface paramAppInterface, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkInsertConfessCardMsg ");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.i("ConfessMsgUtil", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new HashSet();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((!localMessageRecord.isSend()) && (UinTypeUtil.e(localMessageRecord.istroop) == 1032) && (b(localMessageRecord)))
      {
        Object localObject2 = new ConfessInfo();
        ((ConfessInfo)localObject2).parseFromJsonStr(localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
        if ((localMessageRecord.istroop == 1033) && (!((Set)localObject1).contains(Integer.valueOf(localMessageRecord.getConfessTopicId()))))
        {
          ((Set)localObject1).add(Integer.valueOf(localMessageRecord.getConfessTopicId()));
          Object localObject3 = ((QQAppInterface)paramAppInterface).getMessageProxy(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId());
          int k = i;
          if (localObject3 != null)
          {
            int j = 0;
            for (;;)
            {
              k = i;
              if (j >= ((List)localObject3).size()) {
                break;
              }
              if (((MessageRecord)((List)localObject3).get(j)).getConfessTopicId() == localMessageRecord.getConfessTopicId())
              {
                k = 1;
                break;
              }
              j += 1;
            }
          }
          i = k;
          if (k == 0)
          {
            localObject2 = ((ConfessInfo)localObject2).topic;
            i = k;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = MessageRecordFactory.a(paramAppInterface, paramAppInterface.getCurrentUin(), localMessageRecord.senderuin, null, localMessageRecord.istroop, (byte)0, (byte)0, (short)0, (String)localObject2);
              ((MessageRecord)localObject3).setConfessTopicId(localMessageRecord.getConfessTopicId());
              ((MessageRecord)localObject3).setSelfIsConfessor(localMessageRecord.isSelfConfessor());
              ((MessageRecord)localObject3).saveExtInfoToExtStr("ext_key_confess_info", localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
              ((MessageRecord)localObject3).time = (localMessageRecord.time - 1L);
              localArrayList.add(0, localObject3);
              i = k;
              if (QLog.isColorLevel())
              {
                QLog.i("ConfessMsgUtil", 2, String.format("checkInsertConfessCardMsg B:%s topic:%s", new Object[] { localMessageRecord.frienduin, localObject2 }));
                i = k;
              }
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      paramList.addAll(0, localArrayList);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "clearLebaBannerUnread");
    }
    if ((paramQQAppInterface != null) && (ConfessConfig.a(paramQQAppInterface, "redpoint_leba_show"))) {
      ConfessConfig.a(paramQQAppInterface, "redpoint_leba_show", 0L);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("enterConfessDetail topicId:%d confessUin:%s confessGender:%d recUin:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2 }));
    }
    if ((paramInt1 > 0) && (ChatActivityUtils.a(paramString1)))
    {
      if (!ChatActivityUtils.a(paramString2)) {
        return;
      }
      paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
      if (paramQQAppInterface == null) {
        paramQQAppInterface = null;
      } else {
        paramQQAppInterface = paramQQAppInterface.d();
      }
      if (paramQQAppInterface == null) {
        paramQQAppInterface = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
      } else {
        paramQQAppInterface = paramQQAppInterface.u;
      }
      paramString1 = String.format("&topicId=%d&fromEncodeUin=%s&fromGender=%d&toUin=%s", new Object[] { Integer.valueOf(paramInt1), NearbyURLSafeUtil.b(paramString1), Integer.valueOf(paramInt2), NearbyURLSafeUtil.b(paramString2) });
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(paramString1);
      paramString2.putExtra("url", localStringBuilder.toString());
      paramContext.startActivity(paramString2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentItemConfessMsg paramRecentItemConfessMsg, boolean paramBoolean)
  {
    if (paramQQAppInterface != null)
    {
      if (paramRecentItemConfessMsg == null) {
        return;
      }
      if ((paramRecentItemConfessMsg.mType == 1032) && (TextUtils.equals(paramRecentItemConfessMsg.mUin, AppConstants.CONFESS_FRD_REC_UIN)))
      {
        b(paramQQAppInterface, paramBoolean);
      }
      else
      {
        int i = paramQQAppInterface.getConversationFacade().a(paramRecentItemConfessMsg.getRecentUserUin(), paramRecentItemConfessMsg.getRecentUserType(), paramRecentItemConfessMsg.mConfessInfo.topicId);
        if (paramBoolean) {
          paramQQAppInterface.getMessageFacade().a(AppConstants.CONFESS_UIN, 1032, paramRecentItemConfessMsg.getRecentUserUin(), paramQQAppInterface.getCurrentAccountUin(), paramRecentItemConfessMsg.mType, paramRecentItemConfessMsg.mConfessInfo.topicId);
        }
        if (i > 0) {
          paramQQAppInterface.getMessageFacade().a(paramRecentItemConfessMsg.getRecentUserUin(), paramRecentItemConfessMsg.getRecentUserType(), paramRecentItemConfessMsg.mConfessInfo.topicId, true, false);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "clearConfessUnread");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramMessageRecord != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramString)))
      {
        paramString = paramQQAppInterface.e();
        if (paramString != null)
        {
          paramMessageRecord.saveExtInfoToExtStr("ext_key_frd_chat_confess_info", paramString.a());
          paramQQAppInterface.a(paramString.h, paramString.i, paramString.a);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfo ExtStr: %s", new Object[] { paramMessageRecord.extStr }));
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 > 0) && (UinTypeUtil.e(paramInt1) == 1032))
    {
      ConfessInfo localConfessInfo = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).c().a(paramString, paramInt1, paramInt2);
      if (localConfessInfo != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_confess_info", localConfessInfo.toJsonStr());
        boolean bool;
        if (paramInt1 == 1033) {
          bool = true;
        } else {
          bool = false;
        }
        paramMessageRecord.setSelfIsConfessor(bool);
        paramMessageRecord.setConfessTopicId(paramInt2);
      }
      if (QLog.isColorLevel())
      {
        if (localConfessInfo == null) {
          paramQQAppInterface = "null";
        } else {
          paramQQAppInterface = localConfessInfo.confessorNick;
        }
        int i;
        if (localConfessInfo == null) {
          i = -1;
        } else {
          i = localConfessInfo.confessorSex;
        }
        QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo friendUin:%s uinType:%d topicId:%d confessorNick:%s confessorSex:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramQQAppInterface, Integer.valueOf(i) }));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo return. frdUin:%s uinType:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    if (QLog.isColorLevel())
    {
      if (paramConfessInfo == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.i("ConfessMsgUtil", 2, String.format("addShieldSucTipsMessage frdUin:%s uinType:%d topicId:%d confessInfo==null:%b", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
    }
    if (paramConfessInfo == null) {
      return;
    }
    Object localObject1 = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).d();
    if (localObject1 == null) {
      i = 24;
    } else {
      i = ((ConfessConfig)localObject1).C;
    }
    Object localObject2 = String.format(ConfessConfig.d, new Object[] { Integer.valueOf(i) });
    localObject1 = HardCodeUtil.a(2131900580);
    int i = ((String)localObject2).indexOf((String)localObject1);
    int j = ((String)localObject1).length();
    localObject1 = new UniteGrayTipParam(paramString, paramString, (String)localObject2, paramInt1, -5020, 655369, MessageCache.c());
    ((UniteGrayTipParam)localObject1).g = ((String)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 31);
    ((UniteGrayTipParam)localObject1).a(i, i + j, (Bundle)localObject2);
    paramString = paramQQAppInterface.getMessageFacade().o(paramString, paramInt1);
    long l;
    if ((paramString != null) && (!paramString.isEmpty())) {
      l = ((ChatMessage)paramString.get(paramString.size() - 1)).shmsgseq;
    } else {
      l = Math.abs(new Random().nextInt());
    }
    paramString = new MessageForUniteGrayTip();
    paramString.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
    boolean bool = true;
    paramString.isread = true;
    paramString.shmsgseq = l;
    paramString.mNeedTimeStamp = true;
    paramString.updateUniteGrayTipMsgData(paramQQAppInterface);
    paramString.setConfessTopicId(paramInt2);
    if (paramInt1 != 1033) {
      bool = false;
    }
    paramString.setSelfIsConfessor(bool);
    paramString.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
    paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("setReadedSafely uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new ConfessMsgUtil.3(paramQQAppInterface, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2), 8, null, false);
      return;
    }
    paramQQAppInterface.getMessageFacade().a(paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addHolmesGrayTipsMessage ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("ConfessMsgUtil", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new UniteGrayTipParam(paramString1, paramString1, paramString2, paramInt1, -5040, 655377, MessageCache.c());
    ((UniteGrayTipParam)localObject).g = paramString2;
    String str = HardCodeUtil.a(2131900577);
    int i = paramString2.indexOf(str);
    int j = str.length();
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 34);
    ((UniteGrayTipParam)localObject).a(i, j + i, paramString2);
    paramString1 = paramQQAppInterface.getMessageFacade().o(paramString1, paramInt1);
    boolean bool = true;
    long l;
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      l = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
    } else {
      l = Math.abs(new Random().nextInt());
    }
    paramString1 = new MessageForUniteGrayTip();
    paramString1.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    paramString1.isread = true;
    paramString1.shmsgseq = l;
    paramString1.mNeedTimeStamp = true;
    paramString1.updateUniteGrayTipMsgData(paramQQAppInterface);
    paramString1.setConfessTopicId(paramInt2);
    if (paramInt1 != 1033) {
      bool = false;
    }
    paramString1.setSelfIsConfessor(bool);
    paramQQAppInterface.getMessageFacade().a(paramString1, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      localObject = MessageRecordUtil.a(paramString2);
      if (paramConfessInfo == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QLog.i("ConfessMsgUtil", 2, String.format("addGrayTipsMessage frdUin:%s uinType:%d topicId:%d msg:%s confessInfo==null:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, Boolean.valueOf(bool1) }));
    }
    if (paramConfessInfo == null) {
      return;
    }
    Object localObject = new UniteGrayTipParam(paramString1, paramString1, paramString2, paramInt1, -5020, 655376, MessageCache.c());
    ((UniteGrayTipParam)localObject).g = paramString2;
    paramString1 = paramQQAppInterface.getMessageFacade().o(paramString1, paramInt1);
    long l;
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      l = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
    } else {
      l = Math.abs(new Random().nextInt());
    }
    paramString1 = new MessageForUniteGrayTip();
    paramString1.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    paramString1.isread = true;
    paramString1.shmsgseq = l;
    paramString1.mNeedTimeStamp = true;
    paramString1.updateUniteGrayTipMsgData(paramQQAppInterface);
    paramString1.setConfessTopicId(paramInt2);
    bool1 = bool2;
    if (paramInt1 == 1033) {
      bool1 = true;
    }
    paramString1.setSelfIsConfessor(bool1);
    paramString1.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
    paramQQAppInterface.getMessageFacade().a(paramString1, paramQQAppInterface.getCurrentAccountUin());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ConfessConfig.a(paramQQAppInterface, "redpoint_box_show", 0L);
    ConfessConfig.a(paramQQAppInterface, "redpoint_clear_time", MessageCache.c());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setClearConfessBoxUnreadFlag:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" isRed:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("ConfessMsgUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean2) {
      localObject = "red_unread_clear_flag";
    } else {
      localObject = "blue_unread_clear_flag";
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("confess_unread_file");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramQQAppInterface.getBoolean((String)localObject, false) != paramBoolean1) {
      paramQQAppInterface.edit().putBoolean((String)localObject, paramBoolean1).apply();
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if (paramMessageRecord != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      Object localObject2 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      Object localObject1;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---decodePttConfessElem: elems: ");
        if (localObject2 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(((List)localObject2).size());
        }
        localStringBuilder.append(localObject1);
        QLog.d("ConfessMsgUtil", 2, localStringBuilder.toString());
      }
      if (localObject2 != null)
      {
        if (((List)localObject2).size() <= 0) {
          return;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (im_msg_body.Elem)((Iterator)localObject2).next();
          if ((((im_msg_body.Elem)localObject1).common_elem.has()) && (21 == ((im_msg_body.Elem)localObject1).common_elem.uint32_service_type.get()))
          {
            localObject2 = new ArrayList(1);
            ((ArrayList)localObject2).add(paramMessageRecord);
            a(paramMsg, (im_msg_body.Elem)localObject1, (List)localObject2, paramAppInterface);
          }
        }
      }
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, List<MessageRecord> paramList, AppInterface paramAppInterface)
  {
    Object localObject1;
    if ((paramElem != null) && (paramList != null) && (paramAppInterface != null))
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decodeConfessMsgElem app:");
        ((StringBuilder)localObject1).append(paramAppInterface);
        QLog.i("ConfessMsgUtil", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = paramElem.common_elem;
        try
        {
          i = ((im_msg_body.CommonElem)localObject1).uint32_service_type.get();
          localObject1 = "";
          Object localObject3;
          Object localObject2;
          int j;
          long l2;
          int k;
          if ((21 == i) && (paramElem.common_elem.bytes_pb_elem.has()) && (paramElem.common_elem.uint32_business_type.get() == 1))
          {
            localObject3 = new hummer_commelem.MsgElemInfo_servtype21();
            ((hummer_commelem.MsgElemInfo_servtype21)localObject3).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
            if ((!((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint32_topic_id.has()) || (!((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint64_confessor_uin.has()) || (!((hummer_commelem.MsgElemInfo_servtype21)localObject3).bytes_confessor_nick.has()) || (!((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint32_confessor_sex.has())) {
              break label2415;
            }
            paramElem = BaseApplicationImpl.sApplication.getRuntime().getAccount();
            localObject2 = ((MessageRecord)paramList.get(0)).frienduin;
            j = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint32_topic_id.get();
            l2 = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint64_confessor_uin.get();
            paramAppInterface = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).bytes_confessor_nick.get().toStringUtf8();
            k = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint32_confessor_sex.get();
            if (!((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint32_sysmsg_flag.has()) {
              break label2416;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint32_sysmsg_flag.get();
            paramMsg = (msg_comm.Msg)localObject1;
            if (((hummer_commelem.MsgElemInfo_servtype21)localObject3).bytes_topic.has()) {
              paramMsg = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).bytes_topic.get().toStringUtf8();
            }
            boolean bool = Long.toString(l2).equals(paramElem);
            if (!((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint64_confess_time.has()) {
              break label2422;
            }
            l1 = ((hummer_commelem.MsgElemInfo_servtype21)localObject3).uint64_confess_time.get();
            paramElem = paramMsg;
            if (i == 1)
            {
              paramElem = paramMsg;
              if (!bool)
              {
                paramElem = paramMsg;
                if ((paramList.get(0) instanceof MessageForText)) {
                  paramElem = ((MessageForText)paramList.get(0)).msg;
                }
              }
            }
            if ((j > 0) && (l2 > 0L) && (!TextUtils.isEmpty(paramAppInterface)) && (!TextUtils.isEmpty(paramElem)))
            {
              paramMsg = paramList.iterator();
              if (paramMsg.hasNext())
              {
                paramList = (MessageRecord)paramMsg.next();
                paramList.saveExtInfoToExtStr("ext_key_confess_info", ConfessInfo.toJsonStr(j, l2, k, paramAppInterface, i, paramElem, l1));
                paramList.setConfessTopicId(j);
                paramList.setSelfIsConfessor(bool);
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label2415;
              }
              QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confessorUin:%s topicId:%d frdUin:%s topic:%s", new Object[] { Long.toString(l2), Integer.valueOf(j), localObject2, paramElem }));
              return;
            }
            if (QLog.isColorLevel())
            {
              paramElem = Long.toString(l2);
              paramMsg = paramAppInterface;
              if (paramAppInterface == null) {
                paramMsg = "null";
              }
              try
              {
                QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem data err confessorUin:%s topicId:%d nick:%s", new Object[] { paramElem, Integer.valueOf(j), paramMsg }));
                return;
              }
              catch (InvalidProtocolBufferMicroException paramMsg) {}
            }
          }
          else
          {
            i = paramElem.common_elem.uint32_service_type.get();
            long l3;
            if ((21 == i) && (paramElem.common_elem.bytes_pb_elem.has()) && (paramElem.common_elem.uint32_business_type.get() == 2) && (paramAppInterface != null))
            {
              localObject3 = new hummer_commelem.MsgElemInfo_servtype21();
              ((hummer_commelem.MsgElemInfo_servtype21)localObject3).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
              if (!((hummer_commelem.MsgElemInfo_servtype21)localObject3).c2c_confess_ctx.has()) {
                break label2415;
              }
              if ((QLog.isColorLevel()) && (((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject3).c2c_confess_ctx.get()).bytes_confess.has())) {
                QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject3).c2c_confess_ctx.get()).bytes_confess.get().toStringUtf8() }));
              }
              str1 = paramAppInterface.getCurrentAccountUin();
              paramList = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
              localObject2 = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
              if (TextUtils.equals(str1, paramList))
              {
                paramElem = (im_msg_body.Elem)localObject2;
              }
              else
              {
                paramElem = (im_msg_body.Elem)localObject1;
                if (TextUtils.equals(str1, (CharSequence)localObject2)) {
                  paramElem = paramList;
                }
              }
              localObject1 = (hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject3).c2c_confess_ctx.get();
              localObject3 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint64_confess_to_uin.get());
              str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint64_confessor_uin.get());
              i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_topic_id.get();
              l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint64_send_uin.get();
              if ((TextUtils.isEmpty(paramElem)) || (!TextUtils.equals(paramList, String.valueOf(l1))) || (!TextUtils.equals((CharSequence)localObject2, (CharSequence)localObject3))) {
                break label2415;
              }
              localObject2 = (ConfessManager)paramAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
              if (((ConfessManager)localObject2).a(paramElem, (String)localObject3, str1, i) != 1) {
                break label2415;
              }
              paramList = new ConfessManager.FrdChatExtra();
              paramList.a = i;
              paramList.b = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_bg_type.get();
              paramList.h = ((String)localObject3);
              paramList.i = str1;
              paramList.j = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).bytes_confess.get().toStringUtf8();
              paramList.k = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).bytes_confessor_nick.get().toStringUtf8();
              paramList.g = paramAppInterface.getCurrentNickname();
              if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_confessor_sex.has()) {
                break label2428;
              }
              i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_confessor_sex.get();
              paramList.c = i;
              if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint64_confess_time.has()) {
                break label2434;
              }
              l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint64_confess_time.get();
              paramList.l = l1;
              if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_confess_num.has()) {
                break label2440;
              }
              i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_confess_num.get();
              paramList.d = i;
              if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_biz_type.has()) {
                break label2446;
              }
              i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_biz_type.get();
              paramList.f = i;
              if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_confess_to_sex.has()) {
                break label2452;
              }
              i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject1).uint32_confess_to_sex.get();
              paramList.e = i;
              l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
              l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get() - 1L;
              ((ConfessManager)localObject2).a(paramElem, paramList, l1, l2);
              if (!QLog.isColorLevel()) {
                break label2415;
              }
              l3 = MessageCache.c();
              paramMsg = new StringBuilder();
              paramMsg.append("decodeConfessMsgElem strConfessorDesc:");
              paramMsg.append(paramList.j);
              paramMsg.append(" msgTime:");
              paramMsg.append(l1);
              paramMsg.append(" msgSeq:");
              paramMsg.append(l2);
              paramMsg.append(" nowTime");
              paramMsg.append(l3);
              QLog.i("ConfessMsgUtil", 2, paramMsg.toString());
              return;
            }
            if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 4) || (paramAppInterface == null)) {
              break label2415;
            }
            localObject1 = new hummer_commelem.MsgElemInfo_servtype21();
            ((hummer_commelem.MsgElemInfo_servtype21)localObject1).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
            if (!((hummer_commelem.MsgElemInfo_servtype21)localObject1).group_confess_ctx.has()) {
              break label2415;
            }
            if ((!QLog.isColorLevel()) || (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject1).group_confess_ctx.get()).bytes_topic.has())) {
              break label2458;
            }
            QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject1).group_confess_ctx.get()).bytes_topic.get().toStringUtf8() }));
            if ((!paramMsg.msg_head.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.has()) || (!((msg_comm.GroupInfo)((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.get()).group_code.has())) {
              break label2461;
            }
            paramList = String.valueOf(((msg_comm.GroupInfo)((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.get()).group_code.get());
            paramElem = paramList;
            if (paramMsg.msg_head.group_info.group_type.get() != 127) {
              break label2465;
            }
            i = 1;
            paramElem = paramList;
            if (TextUtils.isEmpty(paramElem)) {
              break label2415;
            }
            localObject3 = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject1).group_confess_ctx.get();
            String str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_send_uin.get());
            if (!TextUtils.equals(str1, String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
              return;
            }
            paramList = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_to_uin.get());
            String str2 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confessor_uin.get());
            j = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_topic_id.get();
            localObject2 = (ConfessManager)paramAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
            k = ((ConfessManager)localObject2).b(paramElem, paramList, str1, str2, j);
            if ((i == 0) && (k == 1))
            {
              localObject1 = new ConfessManager.GroupChatExtra();
              ((ConfessManager.GroupChatExtra)localObject1).a = paramElem;
              ((ConfessManager.GroupChatExtra)localObject1).c = j;
              ((ConfessManager.GroupChatExtra)localObject1).d = (j % 4);
              ((ConfessManager.GroupChatExtra)localObject1).h = paramList;
              ((ConfessManager.GroupChatExtra)localObject1).i = str2;
              if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_topic.has()) {
                break label2471;
              }
              paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_topic.get().toStringUtf8();
              ((ConfessManager.GroupChatExtra)localObject1).j = paramList;
              if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confessor_sex.has()) {
                break label2478;
              }
              i = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confessor_sex.get();
              ((ConfessManager.GroupChatExtra)localObject1).e = i;
              if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confessor_nick.has()) {
                break label2484;
              }
              paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confessor_nick.get().toStringUtf8();
              if (TextUtils.isEmpty(paramList))
              {
                if (((ConfessManager.GroupChatExtra)localObject1).e == 1) {
                  paramList = HardCodeUtil.a(2131900578);
                } else {
                  paramList = HardCodeUtil.a(2131900581);
                }
                ((ConfessManager.GroupChatExtra)localObject1).k = paramList;
              }
              else
              {
                ((ConfessManager.GroupChatExtra)localObject1).k = paramList;
              }
              if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confess_to_nick.has()) {
                break label2491;
              }
              paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confess_to_nick.get().toStringUtf8();
              ((ConfessManager.GroupChatExtra)localObject1).f = paramList;
              if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_time.has()) {
                break label2498;
              }
              l1 = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_time.get();
              ((ConfessManager.GroupChatExtra)localObject1).l = l1;
              if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confess_to_nick_type.has()) {
                break label2504;
              }
              i = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confess_to_nick_type.get();
              ((ConfessManager.GroupChatExtra)localObject1).g = i;
              ((ConfessManager.GroupChatExtra)localObject1).b = str1;
              l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
              long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
              paramMsg = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "");
              l2 = -1L;
              paramMsg = paramMsg.getAIOList(paramElem, 1, -1L);
              l1 = l2;
              if (paramMsg != null)
              {
                l1 = l2;
                if (!paramMsg.isEmpty()) {
                  l1 = ((ChatMessage)paramMsg.get(paramMsg.size() - 1)).shmsgseq;
                }
              }
              if ((l4 < l1 - 5L) && (l1 >= 0L))
              {
                if (QLog.isColorLevel())
                {
                  paramMsg = new StringBuilder();
                  paramMsg.append("decodeConfessMsgElem 1 in if lastseq:");
                  paramMsg.append(l1);
                  paramMsg.append("  msgSeq:");
                  paramMsg.append(l4);
                  paramMsg = paramMsg.toString();
                  QLog.i("ConfessMsgUtil", 2, paramMsg);
                }
                ThreadManager.getSubThreadHandler().postDelayed(new ConfessMsgUtil.1((ConfessManager)localObject2, paramElem, (ConfessManager.GroupChatExtra)localObject1, l3, l4), 250L);
                return;
              }
              ((ConfessManager)localObject2).a(paramElem, (ConfessManager.GroupChatExtra)localObject1, l3, l3, l4);
              if (!QLog.isColorLevel()) {
                break label2415;
              }
              l1 = MessageCache.c();
              paramMsg = new StringBuilder();
              paramMsg.append("decodeConfessMsgElem 2 strConfessorDesc:");
              paramMsg.append(((ConfessManager.GroupChatExtra)localObject1).j);
              paramMsg.append(" msgTime:");
              paramMsg.append(l3);
              paramMsg.append(" msgSeq:");
              paramMsg.append(l4);
              paramMsg.append(" nowTime");
              paramMsg.append(l1);
              QLog.i("ConfessMsgUtil", 2, paramMsg.toString());
              return;
            }
            if ((!paramMsg.msg_head.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.has())) {
              break label2415;
            }
            ((ConfessManager)localObject2).a(paramElem, paramList, str1, str2, j, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
        if (!QLog.isColorLevel()) {
          break label2415;
        }
      }
      catch (Exception paramMsg)
      {
        if (!QLog.isColorLevel()) {
          break label2415;
        }
        QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMsg) {}
      QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
      label2415:
      return;
      label2416:
      int i = 0;
      continue;
      label2422:
      long l1 = 0L;
      continue;
      label2428:
      i = 0;
      continue;
      label2434:
      l1 = 0L;
      continue;
      label2440:
      i = 0;
      continue;
      label2446:
      i = 0;
      continue;
      label2452:
      i = 0;
      continue;
      label2458:
      continue;
      label2461:
      paramElem = "";
      label2465:
      i = 0;
      continue;
      label2471:
      paramList = "";
      continue;
      label2478:
      i = 0;
      continue;
      label2484:
      paramList = "";
      continue;
      label2491:
      paramList = "";
      continue;
      label2498:
      l1 = 0L;
      continue;
      label2504:
      i = 0;
    }
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    int i;
    if ((paramMessageRecord.istroop != 1033) && (paramMessageRecord.istroop != 1034)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return;
    }
    Object localObject2 = paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    Object localObject1 = new ConfessInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((ConfessInfo)localObject1).parseFromJsonStr((String)localObject2);
    }
    localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.set(((ConfessInfo)localObject1).topicId);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.set(((ConfessInfo)localObject1).confessorUin);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.set(((ConfessInfo)localObject1).confessTime);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((ConfessInfo)localObject1).confessorNick));
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.set(((ConfessInfo)localObject1).confessorSex);
    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_sysmsg_flag.set(0);
    boolean bool = TextUtils.isEmpty(((ConfessInfo)localObject1).topic) ^ true;
    if (bool) {
      ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.set(ByteStringMicro.copyFromUtf8(((ConfessInfo)localObject1).topic));
    }
    localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(21);
    ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject2).toByteArray()));
    ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
    paramElem.common_elem.set((MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfoElem frdUin:%s type:%d topicId:%d needBindTopic:%b", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.getConfessTopicId()), Boolean.valueOf(bool) }));
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = UinTypeUtil.e(paramInt1);
    boolean bool2 = false;
    if ((i != 1032) && (UinTypeUtil.e(paramInt3) != 1032)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      boolean bool1 = bool2;
      if (paramInt1 == paramInt3)
      {
        bool1 = bool2;
        if (paramInt2 == paramInt4) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return true;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    boolean bool = false;
    if (paramSessionInfo == null) {
      return false;
    }
    if ((paramSessionInfo.a == 1033) || (paramSessionInfo.a == 1034)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    return ((paramChatMessage.istroop == 1033) && (paramChatMessage.isSend())) || ((paramChatMessage.istroop == 1034) && (!paramChatMessage.isSend()));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramMessageRecord != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.d(paramString)))
      {
        ConfessManager.GroupChatExtra localGroupChatExtra = paramQQAppInterface.f();
        if (localGroupChatExtra != null)
        {
          paramMessageRecord.saveExtInfoToExtStr("ext_key_group_chat_confess_info", localGroupChatExtra.a());
          paramQQAppInterface.a(paramString, localGroupChatExtra.h, localGroupChatExtra.b, localGroupChatExtra.i, localGroupChatExtra.c);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfo ExtStr: %s", new Object[] { paramMessageRecord.extStr }));
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(10018);
    if ((paramBoolean) && (localRedTouchItem != null)) {
      localRedTouchItem.extMsgs = null;
    }
    ((LocalRedTouchManager)localObject).b(10018);
    localObject = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
    if ((localObject != null) && (((FrdConfessInfo)localObject).b > 0))
    {
      boolean bool2;
      if (localObject != null)
      {
        boolean bool1;
        if (((FrdConfessInfo)localObject).b != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((FrdConfessInfo)localObject).b = 0;
        bool2 = bool1;
        if (paramBoolean)
        {
          bool2 = bool1 | ((FrdConfessInfo)localObject).c();
          ((FrdConfessInfo)localObject).e = "";
          ((FrdConfessInfo)localObject).g = "";
          ((FrdConfessInfo)localObject).f = "";
          ((FrdConfessInfo)localObject).d = 0;
        }
        ThreadManager.post(new ConfessMsgUtil.2((FrdConfessInfo)localObject), 8, null, false);
      }
      else
      {
        bool2 = false;
      }
      if (bool2) {
        ((ConfessHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a((FrdConfessInfo)localObject);
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread toDelItem: %s, needUpdate: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2) }));
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread no need to deal ! [toDelItem: %s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return !TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "red_unread_clear_flag";
    } else {
      str = "blue_unread_clear_flag";
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("confess_unread_file");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    boolean bool = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean(str, false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isConfessBoxUnreadCleared:");
      paramQQAppInterface.append(bool);
      paramQQAppInterface.append(" isRed:");
      paramQQAppInterface.append(paramBoolean);
      QLog.i("ConfessMsgUtil", 2, paramQQAppInterface.toString());
    }
    return bool;
  }
  
  public static boolean c(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.getConfessTopicId() > 0) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info")));
  }
  
  public static void d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1032) && (AppConstants.CONFESS_UIN.equals(paramMessageRecord.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("invalidMsgOnDel senderUin:%s frdUin:%s", new Object[] { paramMessageRecord.senderuin, paramMessageRecord.frienduin }));
      }
      paramMessageRecord.saveExtInfoToExtStr("ext_key_confess_info", "");
    }
  }
  
  public static im_msg_body.Elem e(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.getExtInfoFromExtStr("ext_key_group_chat_confess_info");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Object localObject = ConfessManager.GroupChatExtra.a(str);
    if (localObject == null) {
      return null;
    }
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    hummer_commelem.MsgElemInfo_servtype21 localMsgElemInfo_servtype21 = new hummer_commelem.MsgElemInfo_servtype21();
    hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext localGroupConfessContext = new hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext();
    localGroupConfessContext.uint64_confessor_uin.set(Long.parseLong(((ConfessManager.GroupChatExtra)localObject).i));
    localGroupConfessContext.uint64_confess_to_uin.set(Long.parseLong(((ConfessManager.GroupChatExtra)localObject).h));
    localGroupConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
    localGroupConfessContext.bytes_topic.set(ByteStringMicro.copyFromUtf8(((ConfessManager.GroupChatExtra)localObject).j));
    localGroupConfessContext.bytes_confess_to_nick.set(ByteStringMicro.copyFromUtf8(((ConfessManager.GroupChatExtra)localObject).f));
    localGroupConfessContext.uint64_confess_time.set(((ConfessManager.GroupChatExtra)localObject).l);
    localGroupConfessContext.uint32_topic_id.set(((ConfessManager.GroupChatExtra)localObject).c);
    localGroupConfessContext.uint32_confessor_sex.set(((ConfessManager.GroupChatExtra)localObject).e);
    localGroupConfessContext.uint32_confess_to_nick_type.set(((ConfessManager.GroupChatExtra)localObject).g);
    localGroupConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((ConfessManager.GroupChatExtra)localObject).k));
    localMsgElemInfo_servtype21.group_confess_ctx.set(localGroupConfessContext);
    localObject = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject).uint32_service_type.set(21);
    ((im_msg_body.CommonElem)localObject).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype21.toByteArray()));
    ((im_msg_body.CommonElem)localObject).uint32_business_type.set(4);
    localElem.common_elem.set((MessageMicro)localObject);
    paramMessageRecord.removeExtInfoToExtStr("ext_key_group_chat_confess_info");
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfoElem groupChatConfessJson:%s  frienduin:%s senderuin:%s", new Object[] { str, paramMessageRecord.frienduin, paramMessageRecord.senderuin }));
    }
    return localElem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil
 * JD-Core Version:    0.7.0.1
 */