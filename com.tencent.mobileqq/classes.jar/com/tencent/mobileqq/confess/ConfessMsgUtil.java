package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
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
  public static final String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131702457);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1033) {
      paramInt2 = (0x200000 | paramInt2 << 3) >>> 3;
    }
    while (paramInt1 == 1034) {
      return paramInt2;
    }
    return 0;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.isSelfConfessor()) {}
    for (int i = 1033;; i = 1034)
    {
      Message localMessage = paramQQAppInterface.getMessageFacade().a(paramMessageRecord.senderuin, i, paramMessageRecord.getConfessTopicId());
      MessageRecord localMessageRecord = paramMessageRecord;
      if (localMessage != null) {
        localMessageRecord = paramQQAppInterface.getMessageFacade().a(paramMessageRecord.senderuin, i, localMessage.uniseq);
      }
      return localMessageRecord;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ConfessInfo paramConfessInfo, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if ((paramConfessInfo.isSysMsg == 1) && (!TextUtils.equals(paramConfessInfo.confessorUinStr, str))) {
      return HardCodeUtil.a(2131702454);
    }
    if (!TextUtils.equals(paramConfessInfo.confessorUinStr, str)) {
      return paramConfessInfo.confessorNick;
    }
    return ContactUtils.c(paramQQAppInterface, paramString, true);
  }
  
  public static im_msg_body.Elem a(MessageRecord paramMessageRecord)
  {
    Object localObject1 = null;
    String str = paramMessageRecord.getExtInfoFromExtStr("ext_key_frd_chat_confess_info");
    if (TextUtils.isEmpty(str)) {}
    im_msg_body.Elem localElem;
    do
    {
      do
      {
        return localObject1;
        localObject2 = ConfessManager.FrdChatExtra.a(str);
      } while (localObject2 == null);
      localElem = new im_msg_body.Elem();
      localObject1 = new hummer_commelem.MsgElemInfo_servtype21();
      hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext localC2CConfessContext = new hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext();
      localC2CConfessContext.uint64_confessor_uin.set(Long.parseLong(((ConfessManager.FrdChatExtra)localObject2).jdField_c_of_type_JavaLangString));
      localC2CConfessContext.uint64_confess_to_uin.set(Long.parseLong(((ConfessManager.FrdChatExtra)localObject2).jdField_b_of_type_JavaLangString));
      localC2CConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
      localC2CConfessContext.bytes_confess.set(ByteStringMicro.copyFromUtf8(((ConfessManager.FrdChatExtra)localObject2).jdField_d_of_type_JavaLangString));
      localC2CConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((ConfessManager.FrdChatExtra)localObject2).jdField_e_of_type_JavaLangString));
      localC2CConfessContext.uint64_confess_time.set(((ConfessManager.FrdChatExtra)localObject2).jdField_a_of_type_Long);
      localC2CConfessContext.uint32_bg_type.set(((ConfessManager.FrdChatExtra)localObject2).jdField_b_of_type_Int);
      localC2CConfessContext.uint32_topic_id.set(((ConfessManager.FrdChatExtra)localObject2).jdField_a_of_type_Int);
      localC2CConfessContext.uint32_confessor_sex.set(((ConfessManager.FrdChatExtra)localObject2).jdField_c_of_type_Int);
      localC2CConfessContext.uint32_confess_num.set(((ConfessManager.FrdChatExtra)localObject2).jdField_d_of_type_Int);
      localC2CConfessContext.uint32_biz_type.set(((ConfessManager.FrdChatExtra)localObject2).f);
      localC2CConfessContext.uint32_confess_to_sex.set(((ConfessManager.FrdChatExtra)localObject2).jdField_e_of_type_Int);
      ((hummer_commelem.MsgElemInfo_servtype21)localObject1).c2c_confess_ctx.set(localC2CConfessContext);
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(21);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject1).toByteArray()));
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(2);
      localElem.common_elem.set((MessageMicro)localObject2);
      paramMessageRecord.removeExtInfoToExtStr("ext_key_frd_chat_confess_info");
      localObject1 = localElem;
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfoElem frdChatConfessJson:%s  frienduin:%s senderuin:%s", new Object[] { str, paramMessageRecord.frienduin, paramMessageRecord.senderuin }));
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
    if ((paramInt1 <= 0) || (!ChatActivityUtils.a(paramString1)) || (!ChatActivityUtils.a(paramString2))) {
      return;
    }
    paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      if (paramQQAppInterface != null) {
        break label187;
      }
    }
    label187:
    for (paramQQAppInterface = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";; paramQQAppInterface = paramQQAppInterface.n)
    {
      paramString1 = String.format("&topicId=%d&fromEncodeUin=%s&fromGender=%d&toUin=%s", new Object[] { Integer.valueOf(paramInt1), NearbyURLSafeUtil.a(paramString1), Integer.valueOf(paramInt2), NearbyURLSafeUtil.a(paramString2) });
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      paramString2.putExtra("url", paramQQAppInterface + paramString1);
      paramContext.startActivity(paramString2);
      return;
      paramQQAppInterface = paramQQAppInterface.b();
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentItemConfessMsg paramRecentItemConfessMsg, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramRecentItemConfessMsg == null)) {}
    for (;;)
    {
      return;
      if ((paramRecentItemConfessMsg.mType == 1032) && (TextUtils.equals(paramRecentItemConfessMsg.mUin, AppConstants.CONFESS_FRD_REC_UIN))) {
        b(paramQQAppInterface, paramBoolean);
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "clearConfessUnread");
        return;
        int i = paramQQAppInterface.getConversationFacade().a(paramRecentItemConfessMsg.getRecentUserUin(), paramRecentItemConfessMsg.getRecentUserType(), paramRecentItemConfessMsg.mConfessInfo.topicId);
        if (paramBoolean) {
          paramQQAppInterface.getMessageFacade().a(AppConstants.CONFESS_UIN, 1032, paramRecentItemConfessMsg.getRecentUserUin(), paramQQAppInterface.getCurrentAccountUin(), paramRecentItemConfessMsg.mType, paramRecentItemConfessMsg.mConfessInfo.topicId);
        }
        if (i > 0) {
          paramQQAppInterface.getMessageFacade().a(paramRecentItemConfessMsg.getRecentUserUin(), paramRecentItemConfessMsg.getRecentUserType(), paramRecentItemConfessMsg.mConfessInfo.topicId, true, false);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.a(paramString)));
      paramString = paramQQAppInterface.a();
      if (paramString != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_frd_chat_confess_info", paramString.a());
        paramQQAppInterface.a(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_c_of_type_JavaLangString, paramString.jdField_a_of_type_Int);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindC2CFirstMsgConfessInfo ExtStr: %s", new Object[] { paramMessageRecord.extStr }));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (UinTypeUtil.a(paramInt1) != 1032)) {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo return. frdUin:%s uinType:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    ConfessInfo localConfessInfo;
    boolean bool;
    do
    {
      return;
      localConfessInfo = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a().a(paramString, paramInt1, paramInt2);
      if (localConfessInfo != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_confess_info", localConfessInfo.toJsonStr());
        if (paramInt1 != 1033) {
          break;
        }
        bool = true;
        paramMessageRecord.setSelfIsConfessor(bool);
        paramMessageRecord.setConfessTopicId(paramInt2);
      }
    } while (!QLog.isColorLevel());
    if (localConfessInfo == null)
    {
      paramQQAppInterface = "null";
      label133:
      if (localConfessInfo != null) {
        break label204;
      }
    }
    label204:
    for (int i = -1;; i = localConfessInfo.confessorSex)
    {
      QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo friendUin:%s uinType:%d topicId:%d confessorNick:%s confessorSex:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramQQAppInterface, Integer.valueOf(i) }));
      return;
      bool = false;
      break;
      paramQQAppInterface = localConfessInfo.confessorNick;
      break label133;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    if (QLog.isColorLevel()) {
      if (paramConfessInfo != null) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ConfessMsgUtil", 2, String.format("addShieldSucTipsMessage frdUin:%s uinType:%d topicId:%d confessInfo==null:%b", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) }));
      if (paramConfessInfo != null) {
        break;
      }
      return;
    }
    Object localObject1 = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
    int i;
    long l;
    if (localObject1 == null)
    {
      i = 24;
      Object localObject2 = String.format(ConfessConfig.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(i) });
      localObject1 = HardCodeUtil.a(2131702455);
      i = ((String)localObject2).indexOf((String)localObject1);
      int j = ((String)localObject1).length();
      localObject1 = new UniteGrayTipParam(paramString, paramString, (String)localObject2, paramInt1, -5020, 655369, MessageCache.a());
      ((UniteGrayTipParam)localObject1).jdField_c_of_type_JavaLangString = ((String)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 31);
      ((UniteGrayTipParam)localObject1).a(i, j + i, (Bundle)localObject2);
      paramString = paramQQAppInterface.getMessageFacade().a(paramString, paramInt1);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label336;
      }
      l = ((ChatMessage)paramString.get(paramString.size() - 1)).shmsgseq;
      label244:
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      paramString.isread = true;
      paramString.shmsgseq = l;
      paramString.mNeedTimeStamp = true;
      paramString.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label355;
      }
    }
    label336:
    label355:
    for (bool = true;; bool = false)
    {
      paramString.setSelfIsConfessor(bool);
      paramString.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
      paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin());
      return;
      i = ((ConfessConfig)localObject1).j;
      break;
      l = Math.abs(new Random().nextInt());
      break label244;
    }
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
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "addHolmesGrayTipsMessage " + paramString1 + " " + paramString2);
    }
    UniteGrayTipParam localUniteGrayTipParam = new UniteGrayTipParam(paramString1, paramString1, paramString2, paramInt1, -5040, 655377, MessageCache.a());
    localUniteGrayTipParam.jdField_c_of_type_JavaLangString = paramString2;
    String str = HardCodeUtil.a(2131702452);
    int i = paramString2.indexOf(str);
    int j = str.length();
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 34);
    localUniteGrayTipParam.a(i, j + i, paramString2);
    paramString1 = paramQQAppInterface.getMessageFacade().a(paramString1, paramInt1);
    long l;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      l = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
      paramString1 = new MessageForUniteGrayTip();
      paramString1.initGrayTipMsg(paramQQAppInterface, localUniteGrayTipParam);
      paramString1.isread = true;
      paramString1.shmsgseq = l;
      paramString1.mNeedTimeStamp = true;
      paramString1.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString1.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label258;
      }
    }
    label258:
    for (boolean bool = true;; bool = false)
    {
      paramString1.setSelfIsConfessor(bool);
      paramQQAppInterface.getMessageFacade().a(paramString1, paramQQAppInterface.getCurrentAccountUin());
      return;
      l = Math.abs(new Random().nextInt());
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = MessageRecordUtil.a(paramString2);
      if (paramConfessInfo != null) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ConfessMsgUtil", 2, String.format("addGrayTipsMessage frdUin:%s uinType:%d topicId:%d msg:%s confessInfo==null:%b", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), localObject, Boolean.valueOf(bool) }));
      if (paramConfessInfo != null) {
        break;
      }
      return;
    }
    Object localObject = new UniteGrayTipParam(paramString1, paramString1, paramString2, paramInt1, -5020, 655376, MessageCache.a());
    ((UniteGrayTipParam)localObject).jdField_c_of_type_JavaLangString = paramString2;
    paramString1 = paramQQAppInterface.getMessageFacade().a(paramString1, paramInt1);
    long l;
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      l = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
      paramString1 = new MessageForUniteGrayTip();
      paramString1.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
      paramString1.isread = true;
      paramString1.shmsgseq = l;
      paramString1.mNeedTimeStamp = true;
      paramString1.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString1.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label255;
      }
    }
    label255:
    for (bool = true;; bool = false)
    {
      paramString1.setSelfIsConfessor(bool);
      paramString1.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
      paramQQAppInterface.getMessageFacade().a(paramString1, paramQQAppInterface.getCurrentAccountUin());
      return;
      l = Math.abs(new Random().nextInt());
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "checkInsertConfessCardMsg " + paramList.size());
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.isSend()) || (UinTypeUtil.a(localMessageRecord.istroop) != 1032) || (!a(localMessageRecord))) {
        break label427;
      }
      Object localObject1 = new ConfessInfo();
      ((ConfessInfo)localObject1).parseFromJsonStr(localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
      if ((localMessageRecord.istroop != 1033) || (localHashSet.contains(Integer.valueOf(localMessageRecord.getConfessTopicId())))) {
        break label427;
      }
      localHashSet.add(Integer.valueOf(localMessageRecord.getConfessTopicId()));
      Object localObject2 = paramQQAppInterface.getMessageProxy(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId());
      if (localObject2 == null) {
        break label424;
      }
      j = 0;
      label220:
      if (j >= ((List)localObject2).size()) {
        break label424;
      }
      if (((MessageRecord)((List)localObject2).get(j)).getConfessTopicId() == localMessageRecord.getConfessTopicId())
      {
        i = 1;
        label255:
        if (i == 0)
        {
          localObject1 = ((ConfessInfo)localObject1).topic;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.getCurrentUin(), localMessageRecord.senderuin, null, localMessageRecord.istroop, (byte)0, (byte)0, (short)0, (String)localObject1);
            ((MessageRecord)localObject2).setConfessTopicId(localMessageRecord.getConfessTopicId());
            ((MessageRecord)localObject2).setSelfIsConfessor(localMessageRecord.isSelfConfessor());
            ((MessageRecord)localObject2).saveExtInfoToExtStr("ext_key_confess_info", localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
            ((MessageRecord)localObject2).time = (localMessageRecord.time - 1L);
            localArrayList.add(0, localObject2);
            if (QLog.isColorLevel()) {
              QLog.i("ConfessMsgUtil", 2, String.format("checkInsertConfessCardMsg B:%s topic:%s", new Object[] { localMessageRecord.frienduin, localObject1 }));
            }
          }
        }
      }
    }
    label424:
    label427:
    for (;;)
    {
      break;
      j += 1;
      break label220;
      if (localArrayList.size() > 0) {
        paramList.addAll(0, localArrayList);
      }
      return;
      break label255;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    ConfessConfig.a(paramQQAppInterface, "redpoint_box_show", 0L);
    ConfessConfig.a(paramQQAppInterface, "redpoint_clear_time", MessageCache.a());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "setClearConfessBoxUnreadFlag:" + paramBoolean1 + " isRed:" + paramBoolean2);
    }
    if (paramBoolean2) {}
    for (String str = "red_unread_clear_flag";; str = "blue_unread_clear_flag")
    {
      paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("confess_unread_file" + paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface.getBoolean(str, false) != paramBoolean1) {
        paramQQAppInterface.edit().putBoolean(str, paramBoolean1).apply();
      }
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1032) && (AppConstants.CONFESS_UIN.equals(paramMessageRecord.frienduin)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("invalidMsgOnDel senderUin:%s frdUin:%s", new Object[] { paramMessageRecord.senderuin, paramMessageRecord.frienduin }));
      }
      paramMessageRecord.saveExtInfoToExtStr("ext_key_confess_info", "");
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    label8:
    Object localObject2;
    StringBuilder localStringBuilder;
    if ((paramMessageRecord == null) || (paramQQAppInterface == null))
    {
      return;
    }
    else
    {
      localObject2 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("<---decodePttConfessElem: elems: ");
        if (localObject2 != null) {
          break label175;
        }
      }
    }
    label175:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(((List)localObject2).size()))
    {
      QLog.d("ConfessMsgUtil", 2, localObject1);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label8;
      }
      localObject2 = ((List)localObject2).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label8;
      }
      localObject1 = (im_msg_body.Elem)((Iterator)localObject2).next();
      if ((!((im_msg_body.Elem)localObject1).common_elem.has()) || (21 != ((im_msg_body.Elem)localObject1).common_elem.uint32_service_type.get())) {
        break;
      }
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(paramMessageRecord);
      a(paramMsg, (im_msg_body.Elem)localObject1, (List)localObject2, paramQQAppInterface);
      return;
    }
  }
  
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramElem == null) || (paramList == null) || (paramQQAppInterface == null) || (paramList.size() <= 0)) {}
    Object localObject2;
    long l2;
    long l1;
    label311:
    label464:
    label471:
    label601:
    Object localObject3;
    String str1;
    label1033:
    label1061:
    label1089:
    label1117:
    label1145:
    long l3;
    label1550:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem app:" + paramQQAppInterface);
                  }
                  try
                  {
                    if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 1)) {
                      break label601;
                    }
                    localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
                    ((hummer_commelem.MsgElemInfo_servtype21)localObject2).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
                    if ((((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.has()) && (((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.has()) && (((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.has()) && (((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.has()))
                    {
                      paramElem = BaseApplicationImpl.sApplication.getRuntime().getAccount();
                      localObject1 = ((MessageRecord)paramList.get(0)).frienduin;
                      j = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.get();
                      l2 = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.get();
                      paramQQAppInterface = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.get().toStringUtf8();
                      k = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.get();
                      if (((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_sysmsg_flag.has())
                      {
                        i = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_sysmsg_flag.get();
                        if (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.has()) {
                          break label464;
                        }
                        paramMsg = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.get().toStringUtf8();
                        bool = Long.toString(l2).equals(paramElem);
                        if (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.has()) {
                          break label2293;
                        }
                        l1 = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.get();
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
                        if ((j > 0) && (l2 > 0L) && (!TextUtils.isEmpty(paramQQAppInterface)) && (!TextUtils.isEmpty(paramElem))) {
                          break label471;
                        }
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        paramElem = Long.toString(l2);
                        paramMsg = paramQQAppInterface;
                        if (paramQQAppInterface == null) {
                          paramMsg = "null";
                        }
                        QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem data err confessorUin:%s topicId:%d nick:%s", new Object[] { paramElem, Integer.valueOf(j), paramMsg }));
                      }
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMsg)
                  {
                    boolean bool;
                    while (QLog.isColorLevel())
                    {
                      QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
                      return;
                      i = 0;
                      continue;
                      paramMsg = "";
                    }
                    paramMsg = paramList.iterator();
                    while (paramMsg.hasNext())
                    {
                      paramList = (MessageRecord)paramMsg.next();
                      paramList.saveExtInfoToExtStr("ext_key_confess_info", ConfessInfo.toJsonStr(j, l2, k, paramQQAppInterface, i, paramElem, l1));
                      paramList.setConfessTopicId(j);
                      paramList.setSelfIsConfessor(bool);
                    }
                  }
                  catch (Exception paramMsg) {}
                }
              } while (!QLog.isColorLevel());
              QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
              return;
            } while (!QLog.isColorLevel());
            QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confessorUin:%s topicId:%d frdUin:%s topic:%s", new Object[] { Long.toString(l2), Integer.valueOf(j), localObject1, paramElem }));
            return;
            if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 2) || (paramQQAppInterface == null)) {
              break;
            }
            localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
            ((hummer_commelem.MsgElemInfo_servtype21)localObject2).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
          } while (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.has());
          if ((QLog.isColorLevel()) && (((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get()).bytes_confess.has())) {
            QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get()).bytes_confess.get().toStringUtf8() }));
          }
          paramElem = "";
          localObject3 = paramQQAppInterface.getCurrentAccountUin();
          paramList = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
          localObject1 = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
          if (TextUtils.equals((CharSequence)localObject3, paramList)) {
            paramElem = (im_msg_body.Elem)localObject1;
          }
          for (;;)
          {
            localObject2 = (hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get();
            localObject3 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_to_uin.get());
            str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confessor_uin.get());
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_topic_id.get();
            l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_send_uin.get();
            if ((TextUtils.isEmpty(paramElem)) || (!TextUtils.equals(paramList, String.valueOf(l1))) || (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject3))) {
              break;
            }
            paramList = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
            if (paramList.a(paramElem, (String)localObject3, str1, i) != 1) {
              break;
            }
            localObject1 = new ConfessManager.FrdChatExtra();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_a_of_type_Int = i;
            ((ConfessManager.FrdChatExtra)localObject1).jdField_b_of_type_Int = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_bg_type.get();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject3);
            ((ConfessManager.FrdChatExtra)localObject1).jdField_c_of_type_JavaLangString = str1;
            ((ConfessManager.FrdChatExtra)localObject1).jdField_d_of_type_JavaLangString = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).bytes_confess.get().toStringUtf8();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_e_of_type_JavaLangString = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).bytes_confessor_nick.get().toStringUtf8();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confessor_sex.has()) {
              break label2299;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confessor_sex.get();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_c_of_type_Int = i;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_time.has()) {
              break label2305;
            }
            l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_time.get();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_a_of_type_Long = l1;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_num.has()) {
              break label2311;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_num.get();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_d_of_type_Int = i;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_biz_type.has()) {
              break label2317;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_biz_type.get();
            ((ConfessManager.FrdChatExtra)localObject1).f = i;
            if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_to_sex.has()) {
              break label2323;
            }
            i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_confess_to_sex.get();
            ((ConfessManager.FrdChatExtra)localObject1).jdField_e_of_type_Int = i;
            l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
            l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get() - 1L;
            paramList.a(paramElem, (ConfessManager.FrdChatExtra)localObject1, l1, l2);
            if (!QLog.isColorLevel()) {
              break;
            }
            l3 = MessageCache.a();
            QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem strConfessorDesc:" + ((ConfessManager.FrdChatExtra)localObject1).jdField_d_of_type_JavaLangString + " msgTime:" + l1 + " msgSeq:" + l2 + " nowTime" + l3);
            return;
            if (TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject1)) {
              paramElem = paramList;
            }
          }
        } while ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 4) || (paramQQAppInterface == null));
        paramList = new hummer_commelem.MsgElemInfo_servtype21();
        paramList.mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
      } while (!paramList.group_confess_ctx.has());
      if ((QLog.isColorLevel()) && (((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)paramList.group_confess_ctx.get()).bytes_topic.has())) {
        QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)paramList.group_confess_ctx.get()).bytes_topic.get().toStringUtf8() }));
      }
      if ((!paramMsg.msg_head.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.has()) || (!((msg_comm.GroupInfo)((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.get()).group_code.has())) {
        break;
      }
      paramElem = String.valueOf(((msg_comm.GroupInfo)((msg_comm.MsgHead)paramMsg.msg_head.get()).group_info.get()).group_code.get());
      if (paramMsg.msg_head.group_info.group_type.get() != 127) {
        break label2332;
      }
      i = 1;
      break label2329;
      if (TextUtils.isEmpty(paramElem)) {
        break label2330;
      }
      localObject3 = (hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)paramList.group_confess_ctx.get();
      str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_send_uin.get());
    } while (!TextUtils.equals(str1, String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get())));
    paramList = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_to_uin.get());
    String str2 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confessor_uin.get());
    int j = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_topic_id.get();
    Object localObject1 = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
    int k = ((ConfessManager)localObject1).a(paramElem, paramList, str1, str2, j);
    if ((i == 0) && (k == 1))
    {
      localObject2 = new ConfessManager.GroupChatExtra();
      ((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_JavaLangString = paramElem;
      ((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Int = j;
      ((ConfessManager.GroupChatExtra)localObject2).jdField_b_of_type_Int = (j % 4);
      ((ConfessManager.GroupChatExtra)localObject2).jdField_d_of_type_JavaLangString = paramList;
      ((ConfessManager.GroupChatExtra)localObject2).jdField_e_of_type_JavaLangString = str2;
      if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_topic.has()) {
        break label2338;
      }
      paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_topic.get().toStringUtf8();
      label1749:
      ((ConfessManager.GroupChatExtra)localObject2).f = paramList;
      if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confessor_sex.has()) {
        break label2345;
      }
      i = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confessor_sex.get();
      label1776:
      ((ConfessManager.GroupChatExtra)localObject2).jdField_c_of_type_Int = i;
      if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confessor_nick.has()) {
        break label2351;
      }
      paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confessor_nick.get().toStringUtf8();
      label1806:
      if (TextUtils.isEmpty(paramList)) {
        if (((ConfessManager.GroupChatExtra)localObject2).jdField_c_of_type_Int == 1)
        {
          paramList = HardCodeUtil.a(2131702453);
          label1829:
          ((ConfessManager.GroupChatExtra)localObject2).g = paramList;
          label1835:
          if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confess_to_nick.has()) {
            break label2358;
          }
          paramList = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).bytes_confess_to_nick.get().toStringUtf8();
          label1858:
          ((ConfessManager.GroupChatExtra)localObject2).jdField_c_of_type_JavaLangString = paramList;
          if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_time.has()) {
            break label2365;
          }
          l1 = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint64_confess_time.get();
          label1885:
          ((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Long = l1;
          if (!((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confess_to_nick_type.has()) {
            break label2371;
          }
        }
      }
    }
    label2305:
    label2311:
    label2317:
    label2323:
    label2329:
    label2330:
    label2332:
    label2338:
    label2345:
    label2351:
    label2358:
    label2365:
    label2371:
    for (int i = ((hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext)localObject3).uint32_confess_to_nick_type.get();; i = 0)
    {
      ((ConfessManager.GroupChatExtra)localObject2).jdField_d_of_type_Int = i;
      ((ConfessManager.GroupChatExtra)localObject2).jdField_b_of_type_JavaLangString = str1;
      l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
      long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      paramMsg = paramQQAppInterface.getMessageFacade().a(paramElem, 1);
      l2 = -1L;
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
        if (QLog.isColorLevel()) {
          QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 in if lastseq:" + l1 + "  msgSeq:" + l4);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new ConfessMsgUtil.1((ConfessManager)localObject1, paramElem, (ConfessManager.GroupChatExtra)localObject2, l3, l4), 250L);
        return;
        paramList = HardCodeUtil.a(2131702456);
        break label1829;
        ((ConfessManager.GroupChatExtra)localObject2).g = paramList;
        break label1835;
      }
      ((ConfessManager)localObject1).a(paramElem, (ConfessManager.GroupChatExtra)localObject2, l3, l3, l4);
      if (!QLog.isColorLevel()) {
        break;
      }
      l1 = MessageCache.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 2 strConfessorDesc:" + ((ConfessManager.GroupChatExtra)localObject2).f + " msgTime:" + l3 + " msgSeq:" + l4 + " nowTime" + l1);
      return;
      if ((!paramMsg.msg_head.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.has())) {
        break;
      }
      ((ConfessManager)localObject1).a(paramElem, paramList, str1, str2, j, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
      return;
      i = 0;
      paramElem = "";
      break label1550;
      label2293:
      l1 = 0L;
      break label311;
      label2299:
      i = 0;
      break label1033;
      l1 = 0L;
      break label1061;
      i = 0;
      break label1089;
      i = 0;
      break label1117;
      i = 0;
      break label1145;
      for (;;)
      {
        break label1550;
        break;
        i = 0;
      }
      paramList = "";
      break label1749;
      i = 0;
      break label1776;
      paramList = "";
      break label1806;
      paramList = "";
      break label1858;
      l1 = 0L;
      break label1885;
    }
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034)) {}
    for (int i = 1; i == 0; i = 0) {
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
    if (!TextUtils.isEmpty(((ConfessInfo)localObject1).topic)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.set(ByteStringMicro.copyFromUtf8(((ConfessInfo)localObject1).topic));
      }
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(21);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject2).toByteArray()));
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(1);
      paramElem.common_elem.set((MessageMicro)localObject1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfoElem frdUin:%s type:%d topicId:%d needBindTopic:%b", new Object[] { paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop), Integer.valueOf(paramMessageRecord.getConfessTopicId()), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((UinTypeUtil.a(paramInt1) == 1032) || (UinTypeUtil.a(paramInt3) == 1032)) {}
    for (int i = 1; (i == 0) || ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {}
    while ((paramSessionInfo.jdField_a_of_type_Int != 1033) && (paramSessionInfo.jdField_a_of_type_Int != 1034)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "red_unread_clear_flag";; str = "blue_unread_clear_flag")
    {
      boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("confess_unread_file" + paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean(str, false);
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, "isConfessBoxUnreadCleared:" + bool + " isRed:" + paramBoolean);
      }
      return bool;
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramChatMessage.istroop != 1033) || (!paramChatMessage.isSend()))
    {
      bool1 = bool2;
      if (paramChatMessage.istroop == 1034)
      {
        bool1 = bool2;
        if (paramChatMessage.isSend()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"))) {
      return false;
    }
    return true;
  }
  
  public static im_msg_body.Elem b(MessageRecord paramMessageRecord)
  {
    Object localObject1 = null;
    String str = paramMessageRecord.getExtInfoFromExtStr("ext_key_group_chat_confess_info");
    if (TextUtils.isEmpty(str)) {}
    im_msg_body.Elem localElem;
    do
    {
      do
      {
        return localObject1;
        localObject2 = ConfessManager.GroupChatExtra.a(str);
      } while (localObject2 == null);
      localElem = new im_msg_body.Elem();
      localObject1 = new hummer_commelem.MsgElemInfo_servtype21();
      hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext localGroupConfessContext = new hummer_commelem.MsgElemInfo_servtype21.GroupConfessContext();
      localGroupConfessContext.uint64_confessor_uin.set(Long.parseLong(((ConfessManager.GroupChatExtra)localObject2).jdField_e_of_type_JavaLangString));
      localGroupConfessContext.uint64_confess_to_uin.set(Long.parseLong(((ConfessManager.GroupChatExtra)localObject2).jdField_d_of_type_JavaLangString));
      localGroupConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
      localGroupConfessContext.bytes_topic.set(ByteStringMicro.copyFromUtf8(((ConfessManager.GroupChatExtra)localObject2).f));
      localGroupConfessContext.bytes_confess_to_nick.set(ByteStringMicro.copyFromUtf8(((ConfessManager.GroupChatExtra)localObject2).jdField_c_of_type_JavaLangString));
      localGroupConfessContext.uint64_confess_time.set(((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Long);
      localGroupConfessContext.uint32_topic_id.set(((ConfessManager.GroupChatExtra)localObject2).jdField_a_of_type_Int);
      localGroupConfessContext.uint32_confessor_sex.set(((ConfessManager.GroupChatExtra)localObject2).jdField_c_of_type_Int);
      localGroupConfessContext.uint32_confess_to_nick_type.set(((ConfessManager.GroupChatExtra)localObject2).jdField_d_of_type_Int);
      localGroupConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((ConfessManager.GroupChatExtra)localObject2).g));
      ((hummer_commelem.MsgElemInfo_servtype21)localObject1).group_confess_ctx.set(localGroupConfessContext);
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(21);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype21)localObject1).toByteArray()));
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(4);
      localElem.common_elem.set((MessageMicro)localObject2);
      paramMessageRecord.removeExtInfoToExtStr("ext_key_group_chat_confess_info");
      localObject1 = localElem;
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfoElem groupChatConfessJson:%s  frienduin:%s senderuin:%s", new Object[] { str, paramMessageRecord.frienduin, paramMessageRecord.senderuin }));
    return localElem;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER);
      } while ((paramQQAppInterface == null) || (!paramQQAppInterface.b(paramString)));
      ConfessManager.GroupChatExtra localGroupChatExtra = paramQQAppInterface.a();
      if (localGroupChatExtra != null)
      {
        paramMessageRecord.saveExtInfoToExtStr("ext_key_group_chat_confess_info", localGroupChatExtra.a());
        paramQQAppInterface.a(paramString, localGroupChatExtra.jdField_d_of_type_JavaLangString, localGroupChatExtra.jdField_b_of_type_JavaLangString, localGroupChatExtra.jdField_e_of_type_JavaLangString, localGroupChatExtra.jdField_a_of_type_Int);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ConfessMsgUtil", 2, String.format("bindGroupFirstMsgConfessInfo ExtStr: %s", new Object[] { paramMessageRecord.extStr }));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (LocalRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(10018);
      if ((paramBoolean) && (localRedTouchItem != null)) {
        localRedTouchItem.extMsgs = null;
      }
      ((LocalRedTouchManager)localObject).a(10018);
      localObject = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
      if ((localObject != null) && (((FrdConfessInfo)localObject).jdField_a_of_type_Int > 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread no need to deal ! [toDelItem: %s]", new Object[] { Boolean.valueOf(paramBoolean) }));
    return;
    boolean bool1;
    label126:
    boolean bool2;
    if (localObject != null) {
      if (((FrdConfessInfo)localObject).jdField_a_of_type_Int != 0)
      {
        bool1 = true;
        ((FrdConfessInfo)localObject).jdField_a_of_type_Int = 0;
        bool2 = bool1;
        if (paramBoolean)
        {
          bool2 = bool1 | ((FrdConfessInfo)localObject).a();
          ((FrdConfessInfo)localObject).jdField_a_of_type_JavaLangString = "";
          ((FrdConfessInfo)localObject).jdField_c_of_type_JavaLangString = "";
          ((FrdConfessInfo)localObject).jdField_b_of_type_JavaLangString = "";
          ((FrdConfessInfo)localObject).jdField_b_of_type_Int = 0;
        }
        ThreadManager.post(new ConfessMsgUtil.2((FrdConfessInfo)localObject), 8, null, false);
      }
    }
    for (;;)
    {
      if (bool2) {
        ((ConfessHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).a((FrdConfessInfo)localObject);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("ConfessMsgUtil", 4, String.format(Locale.getDefault(), "clearConfessFrdRecUnread toDelItem: %s, needUpdate: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2) }));
      return;
      bool1 = false;
      break label126;
      bool2 = false;
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.getConfessTopicId() > 0) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil
 * JD-Core Version:    0.7.0.1
 */