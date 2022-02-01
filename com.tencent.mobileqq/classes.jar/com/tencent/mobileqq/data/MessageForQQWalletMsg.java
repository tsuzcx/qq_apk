package com.tencent.mobileqq.data;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonManager;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.safestream.ISafeStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletMsg;
import tencent.im.msg.im_msg_body.Text;

public class MessageForQQWalletMsg
  extends ChatMessage
{
  public static final int MSG_TYPE_AA_PAY = 16;
  public static final int MSG_TYPE_COMMAND_REDPACKET = 6;
  public static final int MSG_TYPE_COMMON_REDPACKET = 2;
  public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY = 7;
  public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY_OVER_3 = 11;
  public static final int MSG_TYPE_COMMON_THEME_REDPACKET = 4;
  public static final int MSG_TYPE_CONTINUE = 27;
  public static final int MSG_TYPE_DRAW_REDPACKET = 22;
  public static final int MSG_TYPE_DRAW_REDPACKET_MULTI_MODEL = 26;
  public static final int MSG_TYPE_EMOJI_REDPACKET = 19;
  public static final int MSG_TYPE_GOLD_REDPACKET = 23;
  public static final int MSG_TYPE_H5_COMMON_REDPACKET = 20;
  public static final int MSG_TYPE_H5_REDPACKET = 17;
  public static final int MSG_TYPE_IDIOM_SOLITAIRE = 21;
  public static final int MSG_TYPE_INDIVIDUAL_REDPACKET = 2001;
  public static final int MSG_TYPE_KEYWORD = 25;
  public static final int MSG_TYPE_KSONG_REDPACKET = 18;
  public static final int MSG_TYPE_KUAKUA = 28;
  public static final int MSG_TYPE_LOOK_REDPACKET = 14;
  public static final int MSG_TYPE_LUCY_REDPACKET = 3;
  public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY = 8;
  public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY_OVER_3 = 12;
  public static final int MSG_TYPE_LUCY_THEME_REDPACKET = 5;
  public static final int MSG_TYPE_PAYER = 9;
  public static final int MSG_TYPE_PAYER_NOTIFY = 10;
  public static final int MSG_TYPE_PUBLIC_ACCOUNT_REDPACKET = 2002;
  public static final int MSG_TYPE_TRANSFER = 1;
  public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET = 13;
  public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET_C2C = 15;
  public static final int MSG_TYPE_WORDCHAIN = 24;
  private static final int PROCESS_MSG_TYPE_ABORT = 1;
  private static final int PROCESS_MSG_TYPE_NORMAL = 2;
  private static final int PROCESS_MSG_TYPE_TEXT = 3;
  public static final int QQWALLET_TYPE_REDPACKET = 2;
  public static final int QQWALLET_TYPE_TRANSFER = 1;
  public static final int SUBVERSION_REDPACKET = 2;
  public static final int SUBVERSION_TRANSFER = 4;
  private static final String TAG = "MessageForQQWalletMsg";
  public static final int VERSION1 = 1;
  public static final int VERSION17 = 17;
  public static final int VERSION2 = 2;
  public static final int VERSION32 = 32;
  public static int[] mMsgType = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 2002, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 28 };
  private static Map<Integer, Integer> sMsgType2RedType = new MessageForQQWalletMsg.2();
  private static Set<Integer> sNeverSupportType = new MessageForQQWalletMsg.1();
  public int fromHBList;
  public boolean isLoadFinish;
  public QQWalletRedPacketMsg mQQWalletRedPacketMsg;
  public QQWalletTransferMsg mQQWalletTransferMsg;
  public int messageType;
  public Bitmap specifyIcon;
  
  public MessageForQQWalletMsg() {}
  
  public MessageForQQWalletMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    init(paramLong1, paramLong2, paramLong3, "[QQWallet Msg]", paramLong4, -2025, paramInt, paramLong5);
  }
  
  public static MessageForQQWalletMsg createQQWalletMsg(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)MessageRecordFactory.a(-2025);
      localMessageForQQWalletMsg.msgtype = -2025;
      localMessageForQQWalletMsg.messageType = paramString1.getInt("msgType");
      localMessageForQQWalletMsg.mQQWalletTransferMsg = null;
      localMessageForQQWalletMsg.mQQWalletRedPacketMsg = createRedPacketMsg(paramString1, paramString2);
      if (localMessageForQQWalletMsg.mQQWalletRedPacketMsg == null) {
        return null;
      }
      localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
      localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
      return localMessageForQQWalletMsg;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  private static QQWalletBaseMsgElem createQWalletBaseMsgElem(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        QQWalletBaseMsgElem localQQWalletBaseMsgElem = new QQWalletBaseMsgElem();
        paramJSONObject = paramJSONObject.getJSONObject("receiver");
        if (paramJSONObject == null) {
          return null;
        }
        localQQWalletBaseMsgElem.nativeAndroid = paramJSONObject.getString("nativeAndroid");
        if (!localQQWalletBaseMsgElem.nativeAndroid.equals(""))
        {
          localQQWalletBaseMsgElem.background = paramJSONObject.getInt("background");
          localQQWalletBaseMsgElem.icon = paramJSONObject.getInt("icon");
          localQQWalletBaseMsgElem.title = paramJSONObject.getString("title");
          localQQWalletBaseMsgElem.subTitle = paramJSONObject.getString("subtitle");
          localQQWalletBaseMsgElem.content = paramJSONObject.getString("content");
          localQQWalletBaseMsgElem.linkUrl = paramJSONObject.getString("linkurl");
          localQQWalletBaseMsgElem.blackStripe = paramJSONObject.getString("blackstripe");
          localQQWalletBaseMsgElem.notice = paramJSONObject.getString("notice");
          localQQWalletBaseMsgElem.titleColor = paramJSONObject.getInt("titleColor");
          localQQWalletBaseMsgElem.subtitleColor = paramJSONObject.getInt("subtitleColor");
          localQQWalletBaseMsgElem.actionsPriority = paramJSONObject.getString("actionsPriority");
          localQQWalletBaseMsgElem.jumpUrl = paramJSONObject.getString("jumpUrl");
          localQQWalletBaseMsgElem.iconUrl = paramJSONObject.getString("iconurl");
          localQQWalletBaseMsgElem.contentColor = -1;
          localQQWalletBaseMsgElem.contentBgColor = -1;
          localQQWalletBaseMsgElem.aioImageLeft = "";
          localQQWalletBaseMsgElem.aioImageRight = "";
          localQQWalletBaseMsgElem.cftImage = "";
          return localQQWalletBaseMsgElem;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  private static QQWalletRedPacketMsg createRedPacketMsg(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      try
      {
        im_msg_body.QQWalletAioBody localQQWalletAioBody = new im_msg_body.QQWalletAioBody();
        localQQWalletAioBody.sint32_channelid.set(paramJSONObject.getInt("channelid"));
        localQQWalletAioBody.sint32_templateid.set(paramJSONObject.getInt("templateid"));
        localQQWalletAioBody.uint32_resend.set(paramJSONObject.getInt("resend"));
        localQQWalletAioBody.sint32_redtype.set(paramJSONObject.getInt("redtype"));
        localQQWalletAioBody.sint32_envelopeid.set(-1);
        paramString = new QQWalletRedPacketMsg(localQQWalletAioBody, paramString);
        paramString.redPacketId = paramJSONObject.getString("billno");
        paramString.authkey = paramJSONObject.getString("authkey");
        if (paramString.redPacketId.equals("")) {
          return null;
        }
        paramString.elem = createQWalletBaseMsgElem(paramJSONObject);
        paramJSONObject = paramString.elem;
        if (paramJSONObject != null) {
          return paramString;
        }
      }
      catch (Exception paramJSONObject) {}
    }
    return null;
  }
  
  private static void decodePBMsgElemRedPacket(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    boolean bool = true;
    paramMessageForQQWalletMsg.mQQWalletTransferMsg = null;
    paramMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg(paramQQWalletMsg.aio_body, paramMessageHandler.a.getCurrentAccountUin());
    if ((paramInt == 4) || (paramInt == 5)) {
      if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom != 1) {
        break label128;
      }
    }
    for (;;)
    {
      paramMessageForQQWalletMsg.isBlessMsg = bool;
      if (QLog.isColorLevel()) {
        QLog.d("BlessManagerHB", 2, "decode msgFrom=" + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom);
      }
      decodePBMsgElemSpecify(paramQQAppInterface, paramMsg, paramMessageInfo, paramQQWalletMsg, paramInt, paramMessageForQQWalletMsg);
      saveRedPacketFromNet(paramMessageHandler, paramMsg, paramQQWalletMsg, paramInt, paramMessageForQQWalletMsg);
      return;
      label128:
      bool = false;
    }
  }
  
  private static void decodePBMsgElemSpecify(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramInt == 7) || (paramInt == 8))
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQWalletMsg = paramQQWalletMsg.aio_body.uint64_grap_uin.get().iterator();
        do
        {
          if (!paramQQWalletMsg.hasNext()) {
            break;
          }
        } while (!paramQQAppInterface.equals(String.valueOf((Long)paramQQWalletMsg.next())));
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      if ((paramInt != 0) && (paramMessageInfo != null))
      {
        paramMessageInfo.a.a(17, paramMsg.msg_head.msg_seq.get(), paramMessageForQQWalletMsg.msgseq);
        paramMessageForQQWalletMsg.mMessageInfo = paramMessageInfo;
      }
      return;
    }
  }
  
  private static void decodePBMsgElemTransfer(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    paramMessageForQQWalletMsg.mQQWalletRedPacketMsg = null;
    paramMessageForQQWalletMsg.mQQWalletTransferMsg = new QQWalletTransferMsg(paramQQWalletMsg.aio_body, paramMessageHandler.a.getCurrentAccountUin());
    long l = 0L;
    if (paramQQWalletMsg.aio_body.uint64_senduin.has()) {
      l = paramQQWalletMsg.aio_body.uint64_senduin.get();
    }
    for (paramMessageHandler = paramMessageHandler.a.getCurrentAccountUin();; paramMessageHandler = "")
    {
      if ((paramInt == 10) && (paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null) && (!TextUtils.isEmpty(paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid)))
      {
        arrayOfString = paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem.nativeAndroid.split("\\?");
        if (arrayOfString.length > 1)
        {
          paramMessageForQQWalletMsg = paramMessageForQQWalletMsg.parseUrlParams(arrayOfString[1]);
          QWalletCommonManager.a(paramQQAppInterface, (String)paramMessageForQQWalletMsg.get("tokenid"), paramQQWalletMsg.aio_body.uint64_senduin.get());
          if ((l != 0L) && (!TextUtils.isEmpty(paramMessageHandler)) && (paramMessageHandler.compareTo("" + l) != 0)) {
            ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.payaio.buyershow", 0, 0, "", "", "", "");
          }
        }
      }
      while ((paramInt != 9) || (l == 0L) || (TextUtils.isEmpty(paramMessageHandler)) || (paramMessageHandler.compareTo("" + l) == 0)) {
        for (;;)
        {
          String[] arrayOfString;
          return;
          paramMessageForQQWalletMsg = new HashMap();
        }
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershow", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void decodePBMsgElemWalletMsg(MessagePBElemDecoder paramMessagePBElemDecoder, QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    MessageForQQWalletMsg localMessageForQQWalletMsg = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      localObject = localMessageForQQWalletMsg;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)localIterator.next();
    } while (!((im_msg_body.Elem)localObject).qqwallet_msg.has());
    Object localObject = (im_msg_body.QQWalletMsg)((im_msg_body.Elem)localObject).qqwallet_msg.get();
    if (localObject == null) {}
    int i;
    label257:
    do
    {
      do
      {
        int j;
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              paramStringBuilder.append("elemType:QQWalletMsg;\n");
            }
          } while (!((im_msg_body.QQWalletMsg)localObject).aio_body.has());
          i = ((im_msg_body.QQWalletMsg)localObject).aio_body.sint32_msgtype.get();
          j = getProcessMsgType(i);
        } while (j == 1);
        if (j != 2) {
          break label402;
        }
        localMessageForQQWalletMsg = (MessageForQQWalletMsg)MessageRecordFactory.a(-2025);
        localMessageForQQWalletMsg.msgtype = -2025;
        localMessageForQQWalletMsg.messageType = i;
        if (((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject).aio_body.get()).sint32_redtype.has()) {
          decodePBMsgElemRedPacket(paramQQAppInterface, paramMessageHandler, paramMsg, paramMessageInfo, (im_msg_body.QQWalletMsg)localObject, i, localMessageForQQWalletMsg);
        }
        for (;;)
        {
          localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
          localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
          localMessageForQQWalletMsg.onDecodeFinish(paramQQAppInterface, paramMsg);
          if ((localMessageForQQWalletMsg != null) && (!localMessageForQQWalletMsg.isMsgEmpty())) {
            break label257;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
          return;
          decodePBMsgElemTransfer(paramQQAppInterface, paramMessageHandler, (im_msg_body.QQWalletMsg)localObject, i, localMessageForQQWalletMsg);
        }
        if (((im_msg_body.QQWalletMsg)localObject).aio_body.uint32_msg_priority.has()) {}
        for (i = ((im_msg_body.QQWalletMsg)localObject).aio_body.uint32_msg_priority.get(); i >= 3; i = 10)
        {
          paramList1.add(localMessageForQQWalletMsg);
          return;
        }
        if (i < 2) {
          break;
        }
        paramMessagePBElemDecoder.f(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
      } while (!paramList1.isEmpty());
      paramList1.add(localMessageForQQWalletMsg);
      return;
    } while (i < 1);
    paramMessagePBElemDecoder.f(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    if (paramList1.isEmpty())
    {
      paramMessagePBElemDecoder.i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
      return;
    }
    paramList1.add(localMessageForQQWalletMsg);
    return;
    label402:
    if (sNeverSupportType.contains(Integer.valueOf(i)))
    {
      paramQQAppInterface = paramList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramMessageHandler = (im_msg_body.Elem)paramQQAppInterface.next();
        if (paramMessageHandler.text.has())
        {
          paramMessageHandler = (im_msg_body.Text)paramMessageHandler.text.get();
          if (paramMessageHandler.str.has()) {
            paramMessageHandler.str.set(ByteStringMicro.copyFromUtf8("[QQ红包]当前平台版本暂不支持该类型红包"));
          }
        }
      }
    }
    paramMessagePBElemDecoder.i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
  }
  
  private static int getProcessMsgType(int paramInt)
  {
    int j = 1;
    int i = 1;
    if (paramInt > 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MessageForQQWalletMsg", 2, "--msgType: " + paramInt + ",processType:" + i);
      }
      return i;
    }
    if (paramInt <= 1000)
    {
      int[] arrayOfInt = mMsgType;
      int k = arrayOfInt.length;
      i = 0;
      label73:
      if (i >= k) {
        break label109;
      }
      if (arrayOfInt[i] != paramInt) {}
    }
    label109:
    for (i = j;; i = 0)
    {
      if (i == 0)
      {
        i = 3;
        break;
        i += 1;
        break label73;
      }
      i = 2;
      break;
    }
  }
  
  public static boolean isCommandRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (((MessageForQQWalletMsg)paramMessageRecord).messageType == 6);
  }
  
  public static boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return QWalletRedPkgUtils.a(paramMessageRecord);
  }
  
  private static void saveRedPacketFromNet(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i;
    long l;
    if (sMsgType2RedType.containsKey(Integer.valueOf(paramInt)))
    {
      i = paramMsg.msg_head.msg_type.get();
      if ((i != 82) && (i != 43)) {
        break label352;
      }
      i = 1;
      l = paramMsg.msg_head.group_info.group_code.get();
    }
    for (;;)
    {
      paramInt = ((Integer)sMsgType2RedType.get(Integer.valueOf(paramInt))).intValue();
      String str3 = "";
      String str1 = str3;
      Object localObject;
      if (paramInt == 4)
      {
        localObject = "";
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
          localObject = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title;
        }
        String str2 = "";
        if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null) {
          str2 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.lastPinyin;
        }
        str1 = str3;
        if (!StringUtil.a((String)localObject))
        {
          str1 = str3;
          if (!StringUtil.a(str2)) {
            str1 = (String)localObject + "_" + str2;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("MessageForQQWalletMsg", 2, "--subChannel: " + paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
      }
      paramMessageHandler = (PasswdRedBagManager)paramMessageHandler.a.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      if (paramMessageHandler != null) {
        localObject = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject).put("key_sub_channel", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
        PasswdRedBagInfo.a((JSONObject)localObject, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.poemRule);
        paramMessageHandler.a((im_msg_body.QQWalletAioBody)paramQQWalletMsg.aio_body.get(), i, l, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_time.get(), paramInt, str1, ((JSONObject)localObject).toString());
        return;
        label352:
        if ((i == 83) || (i == 42))
        {
          i = 2;
          l = paramMsg.msg_head.discuss_info.discuss_uin.get();
          continue;
        }
        i = 3;
        if (paramMessageHandler.a.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {}
        for (l = paramMsg.msg_head.from_uin.get();; l = paramMsg.msg_head.to_uin.get()) {
          break;
        }
      }
      catch (JSONException paramMessageForQQWalletMsg)
      {
        for (;;)
        {
          paramMessageForQQWalletMsg.printStackTrace();
        }
      }
    }
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 727	cooperation/qwallet/safestream/QwSafeInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 173	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   8: invokespecial 730	cooperation/qwallet/safestream/QwSafeInputStream:<init>	([B)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: invokevirtual 732	cooperation/qwallet/safestream/QwSafeInputStream:a	()I
    //   18: istore_1
    //   19: iload_1
    //   20: iconst_1
    //   21: if_icmpeq +8 -> 29
    //   24: iload_1
    //   25: iconst_2
    //   26: if_icmpne +45 -> 71
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 732	cooperation/qwallet/safestream/QwSafeInputStream:a	()I
    //   35: iconst_1
    //   36: if_icmpne +26 -> 62
    //   39: aload_3
    //   40: astore_2
    //   41: aload_0
    //   42: new 460	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   45: dup
    //   46: invokespecial 733	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   49: putfield 152	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   52: aload_3
    //   53: astore_2
    //   54: aload_0
    //   55: getfield 152	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   58: aload_3
    //   59: invokevirtual 737	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(Lcooperation/qwallet/safestream/QwSafeInputStream;)V
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 739	cooperation/qwallet/safestream/QwSafeInputStream:a	()V
    //   70: return
    //   71: iload_1
    //   72: bipush 17
    //   74: if_icmpne +82 -> 156
    //   77: aload_3
    //   78: astore_2
    //   79: aload_0
    //   80: new 310	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   83: dup
    //   84: invokespecial 740	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   87: putfield 158	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   90: aload_3
    //   91: astore_2
    //   92: aload_0
    //   93: getfield 158	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   96: aload_3
    //   97: invokevirtual 741	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Lcooperation/qwallet/safestream/QwSafeInputStream;)V
    //   100: goto -38 -> 62
    //   103: astore 4
    //   105: aload_3
    //   106: astore_2
    //   107: invokestatic 358	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   110: ifeq +17 -> 127
    //   113: aload_3
    //   114: astore_2
    //   115: ldc_w 743
    //   118: iconst_2
    //   119: ldc_w 745
    //   122: aload 4
    //   124: invokestatic 748	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_3
    //   128: astore_2
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 152	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   134: aload_3
    //   135: astore_2
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield 158	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   141: aload_3
    //   142: ifnull -72 -> 70
    //   145: aload_3
    //   146: invokevirtual 739	cooperation/qwallet/safestream/QwSafeInputStream:a	()V
    //   149: return
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   155: return
    //   156: iload_1
    //   157: bipush 32
    //   159: if_icmplt -97 -> 62
    //   162: aload_3
    //   163: astore_2
    //   164: aload_3
    //   165: invokevirtual 732	cooperation/qwallet/safestream/QwSafeInputStream:a	()I
    //   168: istore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload_3
    //   172: invokevirtual 732	cooperation/qwallet/safestream/QwSafeInputStream:a	()I
    //   175: pop
    //   176: aload_3
    //   177: astore_2
    //   178: aload_0
    //   179: aload_3
    //   180: invokevirtual 732	cooperation/qwallet/safestream/QwSafeInputStream:a	()I
    //   183: putfield 150	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   186: iload_1
    //   187: iconst_1
    //   188: if_icmpne +46 -> 234
    //   191: aload_3
    //   192: astore_2
    //   193: aload_0
    //   194: new 460	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   197: dup
    //   198: invokespecial 733	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   201: putfield 152	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   204: aload_3
    //   205: astore_2
    //   206: aload_0
    //   207: getfield 152	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   210: aload_3
    //   211: invokevirtual 737	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(Lcooperation/qwallet/safestream/QwSafeInputStream;)V
    //   214: goto -152 -> 62
    //   217: astore 4
    //   219: aload_2
    //   220: astore_3
    //   221: aload 4
    //   223: astore_2
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 739	cooperation/qwallet/safestream/QwSafeInputStream:a	()V
    //   232: aload_2
    //   233: athrow
    //   234: iload_1
    //   235: iconst_2
    //   236: if_icmpne -174 -> 62
    //   239: aload_3
    //   240: astore_2
    //   241: aload_0
    //   242: new 310	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   245: dup
    //   246: invokespecial 740	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   249: putfield 158	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   252: aload_3
    //   253: astore_2
    //   254: aload_0
    //   255: getfield 158	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   258: aload_3
    //   259: invokevirtual 741	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Lcooperation/qwallet/safestream/QwSafeInputStream;)V
    //   262: goto -200 -> 62
    //   265: astore_2
    //   266: aload_2
    //   267: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   270: return
    //   271: astore_3
    //   272: aload_3
    //   273: invokevirtual 749	java/lang/Exception:printStackTrace	()V
    //   276: goto -44 -> 232
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_3
    //   282: goto -58 -> 224
    //   285: astore 4
    //   287: aconst_null
    //   288: astore_3
    //   289: goto -184 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	MessageForQQWalletMsg
    //   18	219	1	i	int
    //   13	123	2	localObject1	Object
    //   150	2	2	localException1	Exception
    //   163	91	2	localObject2	Object
    //   265	2	2	localException2	Exception
    //   279	1	2	localObject3	Object
    //   11	248	3	localObject4	Object
    //   271	2	3	localException3	Exception
    //   281	8	3	localObject5	Object
    //   103	20	4	localException4	Exception
    //   217	5	4	localObject6	Object
    //   285	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   14	19	103	java/lang/Exception
    //   31	39	103	java/lang/Exception
    //   41	52	103	java/lang/Exception
    //   54	62	103	java/lang/Exception
    //   79	90	103	java/lang/Exception
    //   92	100	103	java/lang/Exception
    //   164	169	103	java/lang/Exception
    //   171	176	103	java/lang/Exception
    //   178	186	103	java/lang/Exception
    //   193	204	103	java/lang/Exception
    //   206	214	103	java/lang/Exception
    //   241	252	103	java/lang/Exception
    //   254	262	103	java/lang/Exception
    //   145	149	150	java/lang/Exception
    //   14	19	217	finally
    //   31	39	217	finally
    //   41	52	217	finally
    //   54	62	217	finally
    //   79	90	217	finally
    //   92	100	217	finally
    //   107	113	217	finally
    //   115	127	217	finally
    //   129	134	217	finally
    //   136	141	217	finally
    //   164	169	217	finally
    //   171	176	217	finally
    //   178	186	217	finally
    //   193	204	217	finally
    //   206	214	217	finally
    //   241	252	217	finally
    //   254	262	217	finally
    //   66	70	265	java/lang/Exception
    //   228	232	271	java/lang/Exception
    //   0	12	279	finally
    //   0	12	285	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public int getIsHideTitleDefault()
  {
    if ((this.mQQWalletRedPacketMsg == null) || (this.mQQWalletRedPacketMsg.elem == null) || (this.mQQWalletRedPacketMsg.elem.skinId <= 0) || (this.messageType == 18) || (this.messageType == 17) || (this.messageType == 19) || (this.messageType == 21) || (this.messageType == 22) || (this.messageType == 26) || (this.messageType == 23) || (this.messageType == 24) || (this.messageType == 25) || (this.messageType == 27) || (this.messageType == 28)) {
      return 0;
    }
    return 1;
  }
  
  public String getMsgSummary()
  {
    if ((this.mQQWalletTransferMsg != null) && (this.mQQWalletTransferMsg.elem != null)) {
      return this.mQQWalletTransferMsg.elem.notice;
    }
    if ((this.mQQWalletRedPacketMsg != null) && (this.mQQWalletRedPacketMsg.elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.notice;
    }
    return "";
  }
  
  public String getSummaryMsg()
  {
    return getMsgSummary();
  }
  
  public boolean isMsgEmpty()
  {
    if ((this.mQQWalletTransferMsg == null) && (this.mQQWalletRedPacketMsg == null)) {}
    while (this.msgData == null) {
      return true;
    }
    return false;
  }
  
  public boolean isRedPackExpired()
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    return this.time + 90000L < l;
  }
  
  public boolean isSender()
  {
    return (this.senderuin != null) && (this.senderuin.equalsIgnoreCase(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void onDecodeFinish(QQAppInterface paramQQAppInterface, msg_comm.Msg paramMsg)
  {
    int i = paramMsg.msg_head.msg_type.get();
    long l;
    if ((i == 82) || (i == 43)) {
      l = paramMsg.msg_head.group_info.group_code.get();
    }
    for (;;)
    {
      this.frienduin = String.valueOf(l);
      this.time = paramMsg.msg_head.msg_time.get();
      SpecifyRedPacketAnimMsg.a(paramQQAppInterface, this);
      RedPacketEmojiFragment.a(paramQQAppInterface, this);
      DrawClassifier.a(this);
      return;
      if ((i == 83) || (i == 42)) {
        l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      } else if (paramQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {
        l = paramMsg.msg_head.from_uin.get();
      } else {
        l = paramMsg.msg_head.to_uin.get();
      }
    }
  }
  
  public HashMap<String, String> parseUrlParams(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int i = 0;
      if (i < paramString.length)
      {
        if (TextUtils.isEmpty(paramString[i])) {}
        for (;;)
        {
          i += 1;
          break;
          String[] arrayOfString = paramString[i].split("=");
          if (arrayOfString.length == 2)
          {
            try
            {
              arrayOfString[1] = URLDecoder.decode(arrayOfString[1], "UTF-8");
              localHashMap.put(arrayOfString[0], arrayOfString[1]);
            }
            catch (Exception localException)
            {
              if (QLog.isDevelopLevel()) {
                localException.printStackTrace();
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:" + arrayOfString[0] + ",tmps[1] is:" + arrayOfString[1], localException);
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public void postRead()
  {
    parse();
    try
    {
      ((PasswdRedBagManager)BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin).getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER)).a(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.qqwalletmsg", 2, "postRead init read status");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void prewrite()
  {
    Object localObject = null;
    if (this.mQQWalletTransferMsg != null) {}
    do
    {
      localObject = this.mQQWalletTransferMsg;
      while (localObject != null)
      {
        localObject = ((ISafeStream)localObject).flushMsgData(this.messageType);
        if (localObject != null) {
          this.msgData = ((byte[])localObject);
        }
        return;
        if (this.mQQWalletRedPacketMsg != null) {
          localObject = this.mQQWalletRedPacketMsg;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.qqwalletmsg", 2, "prewrite... ssp is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletMsg
 * JD-Core Version:    0.7.0.1
 */