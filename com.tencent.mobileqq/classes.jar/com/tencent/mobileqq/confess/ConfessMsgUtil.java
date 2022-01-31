package com.tencent.mobileqq.confess;

import abkt;
import abkx;
import abky;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.util.Utils;
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
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class ConfessMsgUtil
{
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
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramMessageRecord.senderuin, i, paramMessageRecord.getConfessTopicId());
      MessageRecord localMessageRecord = paramMessageRecord;
      if (localMessage != null) {
        localMessageRecord = paramQQAppInterface.a().a(paramMessageRecord.senderuin, i, localMessage.uniseq);
      }
      return localMessageRecord;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ConfessInfo paramConfessInfo, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if ((paramConfessInfo.isSysMsg == 1) && (!TextUtils.equals(paramConfessInfo.confessorUinStr, str))) {
      return "有人对你说";
    }
    if (!TextUtils.equals(paramConfessInfo.confessorUinStr, str)) {
      return paramConfessInfo.confessorNick;
    }
    return ContactUtils.b(paramQQAppInterface, paramString, true);
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString + "&" + paramInt1 + "&" + paramInt2;
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
        localObject2 = abkt.a(str);
      } while (localObject2 == null);
      localElem = new im_msg_body.Elem();
      localObject1 = new hummer_commelem.MsgElemInfo_servtype21();
      hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext localC2CConfessContext = new hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext();
      localC2CConfessContext.uint64_confessor_uin.set(Long.parseLong(((abkt)localObject2).jdField_c_of_type_JavaLangString));
      localC2CConfessContext.uint64_confess_to_uin.set(Long.parseLong(((abkt)localObject2).jdField_b_of_type_JavaLangString));
      localC2CConfessContext.uint64_send_uin.set(Long.parseLong(paramMessageRecord.senderuin));
      localC2CConfessContext.bytes_confess.set(ByteStringMicro.copyFromUtf8(((abkt)localObject2).d));
      localC2CConfessContext.bytes_confessor_nick.set(ByteStringMicro.copyFromUtf8(((abkt)localObject2).e));
      localC2CConfessContext.uint64_confess_time.set(((abkt)localObject2).jdField_a_of_type_Long);
      localC2CConfessContext.uint32_bg_type.set(((abkt)localObject2).jdField_b_of_type_Int);
      localC2CConfessContext.uint32_topic_id.set(((abkt)localObject2).jdField_a_of_type_Int);
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
      QLog.i("ConfessMsgUtil", 2, "clearContactBannerUnread");
    }
    if ((paramQQAppInterface != null) && (ConfessConfig.a(paramQQAppInterface, "redpoint_contact_show")))
    {
      ConfessConfig.a(paramQQAppInterface, "redpoint_contact_show", 0L);
      ((ConfessHandler)paramQQAppInterface.a(125)).a(7, true, null);
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
    paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(268);
    if (paramQQAppInterface == null)
    {
      paramQQAppInterface = null;
      if (paramQQAppInterface != null) {
        break label187;
      }
    }
    label187:
    for (paramQQAppInterface = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";; paramQQAppInterface = paramQQAppInterface.f)
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
      if ((paramRecentItemConfessMsg.j == 1032) && (TextUtils.equals(paramRecentItemConfessMsg.jdField_a_of_type_JavaLangString, AppConstants.aF))) {
        b(paramQQAppInterface, paramBoolean);
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "clearConfessUnread");
        return;
        int i = paramQQAppInterface.a().a(paramRecentItemConfessMsg.a(), paramRecentItemConfessMsg.a(), paramRecentItemConfessMsg.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topicId);
        if (paramBoolean) {
          paramQQAppInterface.a().a(AppConstants.aE, 1032, paramRecentItemConfessMsg.a(), paramQQAppInterface.getCurrentAccountUin(), paramRecentItemConfessMsg.j, paramRecentItemConfessMsg.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topicId);
        }
        if (i > 0) {
          paramQQAppInterface.a().a(paramRecentItemConfessMsg.a(), paramRecentItemConfessMsg.a(), paramRecentItemConfessMsg.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topicId, true, false);
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
        paramQQAppInterface = (ConfessManager)paramQQAppInterface.getManager(268);
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
    if ((paramInt2 <= 0) || (MsgProxyUtils.a(paramInt1) != 1032)) {
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("bindConfessInfo return. frdUin:%s uinType:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    }
    ConfessInfo localConfessInfo;
    boolean bool;
    do
    {
      return;
      localConfessInfo = ((ConfessManager)paramQQAppInterface.getManager(268)).a().a(paramString, paramInt1, paramInt2);
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
    Object localObject1 = ((ConfessManager)paramQQAppInterface.getManager(268)).b();
    int i;
    long l;
    if (localObject1 == null)
    {
      i = 24;
      Object localObject2 = String.format("屏蔽成功，%d小时内将不再接收对方的坦白说消息。点击可永久屏蔽。", new Object[] { Integer.valueOf(i) });
      i = ((String)localObject2).indexOf("永久屏蔽");
      int j = "永久屏蔽".length();
      localObject1 = new UniteGrayTipParam(paramString, paramString, (String)localObject2, paramInt1, -5020, 655369, MessageCache.a());
      ((UniteGrayTipParam)localObject1).jdField_c_of_type_JavaLangString = ((String)localObject2);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("key_action", 31);
      ((UniteGrayTipParam)localObject1).a(i, j + i, (Bundle)localObject2);
      paramString = paramQQAppInterface.a().a(paramString, paramInt1);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label330;
      }
      l = ((ChatMessage)paramString.get(paramString.size() - 1)).shmsgseq;
      label238:
      paramString = new MessageForUniteGrayTip();
      paramString.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject1);
      paramString.isread = true;
      paramString.shmsgseq = l;
      paramString.mNeedTimeStamp = true;
      paramString.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramString.setConfessTopicId(paramInt2);
      if (paramInt1 != 1033) {
        break label349;
      }
    }
    label330:
    label349:
    for (bool = true;; bool = false)
    {
      paramString.setSelfIsConfessor(bool);
      paramString.saveExtInfoToExtStr("ext_key_confess_info", paramConfessInfo.toJsonStr());
      paramQQAppInterface.a().a(paramString, paramQQAppInterface.getCurrentAccountUin());
      return;
      i = ((ConfessConfig)localObject1).i;
      break;
      l = Math.abs(new Random().nextInt());
      break label238;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, String.format("setReadedSafely uin:%s type:%d topicId:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new abky(paramQQAppInterface, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2), 8, null, false);
      return;
    }
    paramQQAppInterface.a().a(paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, ConfessInfo paramConfessInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = Utils.a(paramString2);
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
    paramString1 = paramQQAppInterface.a().a(paramString1, paramInt1);
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
      paramQQAppInterface.a().a(paramString1, paramQQAppInterface.getCurrentAccountUin());
      return;
      l = Math.abs(new Random().nextInt());
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList)
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
      if ((localMessageRecord.isSend()) || (MsgProxyUtils.a(localMessageRecord.istroop) != 1032) || (!a(localMessageRecord))) {
        break label427;
      }
      Object localObject1 = new ConfessInfo();
      ((ConfessInfo)localObject1).parseFromJsonStr(localMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
      if ((localMessageRecord.istroop != 1033) || (localHashSet.contains(Integer.valueOf(localMessageRecord.getConfessTopicId())))) {
        break label427;
      }
      localHashSet.add(Integer.valueOf(localMessageRecord.getConfessTopicId()));
      Object localObject2 = paramQQAppInterface.a(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.getConfessTopicId());
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
            localObject2 = MessageRecordFactory.a(paramQQAppInterface, paramQQAppInterface.c(), localMessageRecord.senderuin, null, localMessageRecord.istroop, (byte)0, (byte)0, (short)0, (String)localObject1);
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
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1032) && (AppConstants.aE.equals(paramMessageRecord.frienduin)))
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
  
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, List paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramElem == null) || (paramList == null) || (paramQQAppInterface == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem app:" + paramQQAppInterface);
    }
    for (;;)
    {
      int j;
      long l2;
      int i;
      boolean bool;
      try
      {
        if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 1)) {
          break label601;
        }
        localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
        ((hummer_commelem.MsgElemInfo_servtype21)localObject2).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
        if ((!((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_topic_id.has()) || (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confessor_uin.has()) || (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_confessor_nick.has()) || (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint32_confessor_sex.has())) {
          break;
        }
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
            continue;
          }
          paramMsg = ((hummer_commelem.MsgElemInfo_servtype21)localObject2).bytes_topic.get().toStringUtf8();
          bool = Long.toString(l2).equals(paramElem);
          if (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).uint64_confess_time.has()) {
            break label1179;
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
            continue;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          paramElem = Long.toString(l2);
          paramMsg = paramQQAppInterface;
          if (paramQQAppInterface == null) {
            paramMsg = "null";
          }
          QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem data err confessorUin:%s topicId:%d nick:%s", new Object[] { paramElem, Integer.valueOf(j), paramMsg }));
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        int k;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
        return;
        i = 0;
        continue;
        paramMsg = "";
        continue;
        paramMsg = paramList.iterator();
        if (!paramMsg.hasNext()) {
          break label553;
        }
        paramList = (MessageRecord)paramMsg.next();
        paramList.saveExtInfoToExtStr("ext_key_confess_info", ConfessInfo.toJsonStr(j, l2, k, paramQQAppInterface, i, paramElem, l1));
        paramList.setConfessTopicId(j);
        paramList.setSelfIsConfessor(bool);
        continue;
      }
      catch (Exception paramMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ConfessMsgUtil", 2, paramMsg.getMessage(), paramMsg);
      return;
      label553:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confessorUin:%s topicId:%d frdUin:%s topic:%s", new Object[] { Long.toString(l2), Integer.valueOf(j), localObject1, paramElem }));
      return;
      label601:
      if ((21 != paramElem.common_elem.uint32_service_type.get()) || (!paramElem.common_elem.bytes_pb_elem.has()) || (paramElem.common_elem.uint32_business_type.get() != 2) || (paramQQAppInterface == null)) {
        break;
      }
      Object localObject2 = new hummer_commelem.MsgElemInfo_servtype21();
      ((hummer_commelem.MsgElemInfo_servtype21)localObject2).mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
      if (!((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.has()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfessMsgUtil", 2, String.format("decodeConfessMsgElem confess: %s", new Object[] { ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get()).bytes_confess.get().toStringUtf8() }));
      }
      paramElem = "";
      String str1 = paramQQAppInterface.getCurrentAccountUin();
      paramList = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
      Object localObject1 = String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
      if (TextUtils.equals(str1, paramList))
      {
        paramElem = (im_msg_body.Elem)localObject1;
        label794:
        localObject2 = (hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)((hummer_commelem.MsgElemInfo_servtype21)localObject2).c2c_confess_ctx.get();
        str1 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_to_uin.get());
        String str2 = String.valueOf(((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confessor_uin.get());
        i = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_topic_id.get();
        l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_send_uin.get();
        if ((TextUtils.isEmpty(paramElem)) || (!TextUtils.equals(paramList, String.valueOf(l1))) || (!TextUtils.equals((CharSequence)localObject1, str1))) {
          break;
        }
        paramList = (ConfessManager)paramQQAppInterface.getManager(268);
        if (paramList.a(paramElem, str1, str2, i) != 1) {
          break;
        }
        localObject1 = new abkt();
        ((abkt)localObject1).jdField_a_of_type_Int = i;
        ((abkt)localObject1).jdField_b_of_type_Int = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint32_bg_type.get();
        ((abkt)localObject1).jdField_b_of_type_JavaLangString = str1;
        ((abkt)localObject1).jdField_c_of_type_JavaLangString = str2;
        ((abkt)localObject1).d = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).bytes_confess.get().toStringUtf8();
        ((abkt)localObject1).e = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).bytes_confessor_nick.get().toStringUtf8();
        ((abkt)localObject1).jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
        ((abkt)localObject1).jdField_c_of_type_Int = -1;
        if (!((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_time.has()) {
          break label1173;
        }
      }
      label1173:
      for (long l1 = ((hummer_commelem.MsgElemInfo_servtype21.C2CConfessContext)localObject2).uint64_confess_time.get();; l1 = 0L)
      {
        ((abkt)localObject1).jdField_a_of_type_Long = l1;
        l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get() - 1L;
        l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get() - 1L;
        paramList.a(paramElem, (abkt)localObject1, l1, l2);
        if (!QLog.isColorLevel()) {
          break;
        }
        long l3 = MessageCache.a();
        QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem strConfessorDesc:" + ((abkt)localObject1).d + " msgTime:" + l1 + " msgSeq:" + l2 + " nowTime" + l3);
        return;
        bool = TextUtils.equals(str1, (CharSequence)localObject1);
        if (!bool) {
          break label794;
        }
        paramElem = paramList;
        break label794;
      }
      label1179:
      l1 = 0L;
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
    if ((MsgProxyUtils.a(paramInt1) == 1032) || (MsgProxyUtils.a(paramInt3) == 1032)) {}
    for (int i = 1; (i == 0) || ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)); i = 0) {
      return true;
    }
    return false;
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
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (LocalRedTouchManager)paramQQAppInterface.getManager(159);
      RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(10018);
      if ((paramBoolean) && (localRedTouchItem != null)) {
        localRedTouchItem.extMsgs = null;
      }
      ((LocalRedTouchManager)localObject).a(10018);
      localObject = ((ConfessManager)paramQQAppInterface.getManager(268)).a();
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
        ThreadManager.post(new abkx((FrdConfessInfo)localObject), 8, null, false);
      }
    }
    for (;;)
    {
      if (bool2) {
        ((ConfessHandler)paramQQAppInterface.a(125)).a((FrdConfessInfo)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil
 * JD-Core Version:    0.7.0.1
 */