package com.tencent.mobileqq.data;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
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
  public static final int FROM_HB_AIO = 0;
  public static final int FROM_HB_LIST = 1;
  public static final int MSG_TYPE_AA_PAY = 16;
  public static final int MSG_TYPE_BIRTHDAY = 30;
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
  public static final int MSG_TYPE_SHENGPIZI = 29;
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
  public static int[] mMsgType = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 2002, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
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
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((IQWalletTemp)QRoute.api(IQWalletTemp.class)).MessageRecordFactory$createMsgRecordByMsgType(-2025);
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
    if (paramJSONObject != null) {}
    try
    {
      QQWalletBaseMsgElem localQQWalletBaseMsgElem = new QQWalletBaseMsgElem();
      paramJSONObject = paramJSONObject.getJSONObject("receiver");
      if (paramJSONObject == null) {
        return null;
      }
      localQQWalletBaseMsgElem.m = paramJSONObject.getString("nativeAndroid");
      if (localQQWalletBaseMsgElem.m.equals("")) {
        return null;
      }
      localQQWalletBaseMsgElem.a = paramJSONObject.getInt("background");
      localQQWalletBaseMsgElem.b = paramJSONObject.getInt("icon");
      localQQWalletBaseMsgElem.c = paramJSONObject.getString("title");
      localQQWalletBaseMsgElem.d = paramJSONObject.getString("subtitle");
      localQQWalletBaseMsgElem.e = paramJSONObject.getString("content");
      localQQWalletBaseMsgElem.f = paramJSONObject.getString("linkurl");
      localQQWalletBaseMsgElem.g = paramJSONObject.getString("blackstripe");
      localQQWalletBaseMsgElem.h = paramJSONObject.getString("notice");
      localQQWalletBaseMsgElem.i = paramJSONObject.getInt("titleColor");
      localQQWalletBaseMsgElem.j = paramJSONObject.getInt("subtitleColor");
      localQQWalletBaseMsgElem.k = paramJSONObject.getString("actionsPriority");
      localQQWalletBaseMsgElem.l = paramJSONObject.getString("jumpUrl");
      localQQWalletBaseMsgElem.n = paramJSONObject.getString("iconurl");
      localQQWalletBaseMsgElem.o = -1;
      localQQWalletBaseMsgElem.p = -1;
      localQQWalletBaseMsgElem.q = "";
      localQQWalletBaseMsgElem.r = "";
      localQQWalletBaseMsgElem.s = "";
      return localQQWalletBaseMsgElem;
    }
    catch (Exception paramJSONObject) {}
    return null;
    return null;
  }
  
  private static QQWalletRedPacketMsg createRedPacketMsg(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {}
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
      if (paramJSONObject == null) {
        return null;
      }
      return paramString;
    }
    catch (Exception paramJSONObject) {}
    return null;
    return null;
  }
  
  private static void decodePBMsgElemRedPacket(BaseQQAppInterface paramBaseQQAppInterface, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, @NonNull MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    paramMessageForQQWalletMsg.mQQWalletTransferMsg = null;
    paramMessageForQQWalletMsg.mQQWalletRedPacketMsg = new QQWalletRedPacketMsg(paramQQWalletMsg.aio_body, paramBaseQQAppInterface.getCurrentAccountUin());
    if ((paramInt == 4) || (paramInt == 5))
    {
      int i = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramMessageForQQWalletMsg.isBlessMsg = bool;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode msgFrom=");
        localStringBuilder.append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.msgFrom);
        QLog.d("BlessManagerHB", 2, localStringBuilder.toString());
      }
    }
    decodePBMsgElemSpecify(paramBaseQQAppInterface, paramMsg, paramMessageInfo, paramQQWalletMsg, paramInt, paramMessageForQQWalletMsg);
    saveRedPacketFromNet(paramBaseQQAppInterface, paramMsg, paramQQWalletMsg, paramInt, paramMessageForQQWalletMsg);
  }
  
  private static void decodePBMsgElemSpecify(BaseQQAppInterface paramBaseQQAppInterface, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramInt == 7) || (paramInt == 8))
    {
      int i = 0;
      paramBaseQQAppInterface = paramBaseQQAppInterface.getCurrentAccountUin();
      if (!TextUtils.isEmpty(paramBaseQQAppInterface))
      {
        paramQQWalletMsg = paramQQWalletMsg.aio_body.uint64_grap_uin.get().iterator();
        do
        {
          paramInt = i;
          if (!paramQQWalletMsg.hasNext()) {
            break;
          }
        } while (!paramBaseQQAppInterface.equals(String.valueOf((Long)paramQQWalletMsg.next())));
        paramInt = 1;
        if ((paramInt != 0) && (paramMessageInfo != null))
        {
          paramMessageInfo.c.a(17, paramMsg.msg_head.msg_seq.get(), paramMessageForQQWalletMsg.msgseq);
          paramMessageForQQWalletMsg.mMessageInfo = paramMessageInfo;
        }
      }
    }
  }
  
  private static void decodePBMsgElemTransfer(BaseQQAppInterface paramBaseQQAppInterface, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    paramMessageForQQWalletMsg.mQQWalletRedPacketMsg = null;
    paramMessageForQQWalletMsg.mQQWalletTransferMsg = new QQWalletTransferMsg(paramQQWalletMsg.aio_body, paramBaseQQAppInterface.getCurrentAccountUin());
    long l;
    String str;
    if (paramQQWalletMsg.aio_body.uint64_senduin.has())
    {
      l = paramQQWalletMsg.aio_body.uint64_senduin.get();
      str = paramBaseQQAppInterface.getCurrentAccountUin();
    }
    else
    {
      str = "";
      l = 0L;
    }
    if ((paramInt == 10) && (paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem != null) && (!TextUtils.isEmpty(paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem.m)))
    {
      String[] arrayOfString = paramMessageForQQWalletMsg.mQQWalletTransferMsg.elem.m.split("\\?");
      if (arrayOfString.length > 1) {
        paramMessageForQQWalletMsg = paramMessageForQQWalletMsg.parseUrlParams(arrayOfString[1]);
      } else {
        paramMessageForQQWalletMsg = new HashMap();
      }
      ((IToPayManager)QRoute.api(IToPayManager.class)).onReceivePayerNotify(paramBaseQQAppInterface, (String)paramMessageForQQWalletMsg.get("tokenid"), paramQQWalletMsg.aio_body.uint64_senduin.get());
      if ((l != 0L) && (!TextUtils.isEmpty(str)))
      {
        paramQQWalletMsg = new StringBuilder();
        paramQQWalletMsg.append("");
        paramQQWalletMsg.append(l);
        if (str.compareTo(paramQQWalletMsg.toString()) != 0) {
          ReportController.b(paramBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.payaio.buyershow", 0, 0, "", "", "", "");
        }
      }
    }
    else if ((paramInt == 9) && (l != 0L) && (!TextUtils.isEmpty(str)))
    {
      paramQQWalletMsg = new StringBuilder();
      paramQQWalletMsg.append("");
      paramQQWalletMsg.append(l);
      if (str.compareTo(paramQQWalletMsg.toString()) != 0) {
        ReportController.b(paramBaseQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.askaio.payershow", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void decodePBMsgElemWalletMsg(Object paramObject, BaseQQAppInterface paramBaseQQAppInterface, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (((im_msg_body.Elem)localObject2).qqwallet_msg.has())
      {
        localObject1 = (im_msg_body.QQWalletMsg)((im_msg_body.Elem)localObject2).qqwallet_msg.get();
        break label60;
      }
    }
    localObject1 = null;
    label60:
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:QQWalletMsg;\n");
    }
    if (!((im_msg_body.QQWalletMsg)localObject1).aio_body.has()) {
      return;
    }
    int i = ((im_msg_body.QQWalletMsg)localObject1).aio_body.sint32_msgtype.get();
    int j = getProcessMsgType(i);
    if (j == 1) {
      return;
    }
    Object localObject2 = (IQWalletTemp)QRoute.api(IQWalletTemp.class);
    if (j == 2)
    {
      MessageForQQWalletMsg localMessageForQQWalletMsg = (MessageForQQWalletMsg)((IQWalletTemp)QRoute.api(IQWalletTemp.class)).MessageRecordFactory$createMsgRecordByMsgType(-2025);
      if (localMessageForQQWalletMsg == null)
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
        }
        return;
      }
      localMessageForQQWalletMsg.msgtype = -2025;
      localMessageForQQWalletMsg.messageType = i;
      if (((im_msg_body.QQWalletAioBody)((im_msg_body.QQWalletMsg)localObject1).aio_body.get()).sint32_redtype.has()) {
        decodePBMsgElemRedPacket(paramBaseQQAppInterface, paramMsg, paramMessageInfo, (im_msg_body.QQWalletMsg)localObject1, i, localMessageForQQWalletMsg);
      } else {
        decodePBMsgElemTransfer(paramBaseQQAppInterface, (im_msg_body.QQWalletMsg)localObject1, i, localMessageForQQWalletMsg);
      }
      localMessageForQQWalletMsg.msg = localMessageForQQWalletMsg.getMsgSummary();
      localMessageForQQWalletMsg.msgData = localMessageForQQWalletMsg.getBytes();
      localMessageForQQWalletMsg.onDecodeFinish(paramBaseQQAppInterface, paramMsg);
      if (localMessageForQQWalletMsg.isMsgEmpty())
      {
        if (QLog.isColorLevel()) {
          paramStringBuilder.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
        }
        return;
      }
      if (((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.has()) {
        i = ((im_msg_body.QQWalletMsg)localObject1).aio_body.uint32_msg_priority.get();
      } else {
        i = 10;
      }
      if (i >= 3)
      {
        paramList1.add(localMessageForQQWalletMsg);
        return;
      }
      if (i >= 2)
      {
        ((IQWalletTemp)localObject2).MessagePBElemDecoder$decodePBMsgElems_RichMsg(paramObject, paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
        if (paramList1.isEmpty()) {
          paramList1.add(localMessageForQQWalletMsg);
        }
      }
      else if (i >= 1)
      {
        ((IQWalletTemp)localObject2).MessagePBElemDecoder$decodePBMsgElems_RichMsg(paramObject, paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
        if (paramList1.isEmpty())
        {
          ((IQWalletTemp)localObject2).MessagePBElemDecoder$decodePBMsgElems_Text(paramObject, paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
          return;
        }
        paramList1.add(localMessageForQQWalletMsg);
      }
    }
    else
    {
      if (sNeverSupportType.contains(Integer.valueOf(i)))
      {
        paramBaseQQAppInterface = paramList.iterator();
        while (paramBaseQQAppInterface.hasNext())
        {
          localObject1 = (im_msg_body.Elem)paramBaseQQAppInterface.next();
          if (((im_msg_body.Elem)localObject1).text.has())
          {
            localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
            if (((im_msg_body.Text)localObject1).str.has()) {
              ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8("[QQ红包]当前平台版本暂不支持该类型红包"));
            }
          }
        }
      }
      ((IQWalletTemp)localObject2).MessagePBElemDecoder$decodePBMsgElems_Text(paramObject, paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    }
  }
  
  private static int getProcessMsgType(int paramInt)
  {
    int i = 1;
    int j = 1;
    Object localObject;
    if (paramInt <= 3000)
    {
      if (paramInt <= 1000)
      {
        localObject = mMsgType;
        int k = localObject.length;
        i = 0;
        while (i < k)
        {
          if (localObject[i] == paramInt)
          {
            i = j;
            break label59;
          }
          i += 1;
        }
        i = 0;
        label59:
        if (i == 0)
        {
          i = 3;
          break label70;
        }
      }
      i = 2;
    }
    label70:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--msgType: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",processType:");
      ((StringBuilder)localObject).append(i);
      QLog.i("MessageForQQWalletMsg", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public static boolean isCommandRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (((MessageForQQWalletMsg)paramMessageRecord).messageType == 6);
  }
  
  public static boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(paramMessageRecord);
  }
  
  private static void saveRedPacketFromNet(BaseQQAppInterface paramBaseQQAppInterface, msg_comm.Msg paramMsg, im_msg_body.QQWalletMsg paramQQWalletMsg, int paramInt, @NonNull MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    int i;
    Object localObject1;
    long l;
    if (sMsgType2RedType.containsKey(Integer.valueOf(paramInt)))
    {
      i = paramMsg.msg_head.msg_type.get();
      if ((i != 82) && (i != 43))
      {
        if ((i != 83) && (i != 42))
        {
          if (paramBaseQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {
            localObject1 = paramMsg.msg_head.from_uin;
          } else {
            localObject1 = paramMsg.msg_head.to_uin;
          }
          l = ((PBUInt64Field)localObject1).get();
          i = 3;
        }
        else
        {
          l = paramMsg.msg_head.discuss_info.discuss_uin.get();
          i = 2;
        }
      }
      else
      {
        l = paramMsg.msg_head.group_info.group_code.get();
        i = 1;
      }
    }
    for (;;)
    {
      try
      {
        paramInt = ((Integer)sMsgType2RedType.get(Integer.valueOf(paramInt))).intValue();
        JSONObject localJSONObject = new JSONObject();
        if ((paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null) && (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null))
        {
          localJSONObject.put("hb_from", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.A);
          if (paramInt == 8) {
            localJSONObject.put("shengpizi_title", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c);
          }
          if (paramInt != 4) {
            break label531;
          }
          if (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem == null) {
            break label520;
          }
          localObject1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.c;
          localObject2 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.D;
          if ((StringUtil.isEmpty((String)localObject1)) || (StringUtil.isEmpty((String)localObject2))) {
            break label531;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("_");
          localStringBuilder.append((String)localObject2);
          localObject1 = localStringBuilder.toString();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("--subChannel: ");
            ((StringBuilder)localObject2).append(paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
            QLog.i("MessageForQQWalletMsg", 2, ((StringBuilder)localObject2).toString());
          }
          paramBaseQQAppInterface = (IPasswdRedBagService)paramBaseQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
          try
          {
            localJSONObject.put("key_sub_channel", paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.subChannel);
            PasswdRedBagInfo.a(localJSONObject, paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.poemRule);
          }
          catch (JSONException paramMessageForQQWalletMsg)
          {
            paramMessageForQQWalletMsg.printStackTrace();
          }
          paramBaseQQAppInterface.savePasswdRedBagFromNet((im_msg_body.QQWalletAioBody)paramQQWalletMsg.aio_body.get(), i, l, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_time.get(), paramInt, (String)localObject1, localJSONObject.toString());
          return;
        }
      }
      catch (JSONException paramBaseQQAppInterface)
      {
        paramBaseQQAppInterface.printStackTrace();
      }
      return;
      label520:
      localObject1 = "";
      Object localObject2 = localObject1;
      continue;
      label531:
      localObject1 = "";
    }
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 749	com/tencent/mobileqq/data/QwSafeInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 186	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   8: invokespecial 752	com/tencent/mobileqq/data/QwSafeInputStream:<init>	([B)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: invokevirtual 755	com/tencent/mobileqq/data/QwSafeInputStream:readInt	()I
    //   18: istore_1
    //   19: iload_1
    //   20: iconst_1
    //   21: if_icmpeq +135 -> 156
    //   24: iload_1
    //   25: iconst_2
    //   26: if_icmpne +6 -> 32
    //   29: goto +127 -> 156
    //   32: iload_1
    //   33: bipush 17
    //   35: if_icmpne +29 -> 64
    //   38: aload_3
    //   39: astore_2
    //   40: aload_0
    //   41: new 333	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   44: dup
    //   45: invokespecial 756	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   48: putfield 171	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   51: aload_3
    //   52: astore_2
    //   53: aload_0
    //   54: getfield 171	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   57: aload_3
    //   58: invokevirtual 760	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Lcom/tencent/mobileqq/data/QwSafeInputStream;)V
    //   61: goto +128 -> 189
    //   64: iload_1
    //   65: bipush 32
    //   67: if_icmplt +122 -> 189
    //   70: aload_3
    //   71: astore_2
    //   72: aload_3
    //   73: invokevirtual 755	com/tencent/mobileqq/data/QwSafeInputStream:readInt	()I
    //   76: istore_1
    //   77: aload_3
    //   78: astore_2
    //   79: aload_3
    //   80: invokevirtual 755	com/tencent/mobileqq/data/QwSafeInputStream:readInt	()I
    //   83: pop
    //   84: aload_3
    //   85: astore_2
    //   86: aload_0
    //   87: aload_3
    //   88: invokevirtual 755	com/tencent/mobileqq/data/QwSafeInputStream:readInt	()I
    //   91: putfield 163	com/tencent/mobileqq/data/MessageForQQWalletMsg:messageType	I
    //   94: iload_1
    //   95: iconst_1
    //   96: if_icmpne +29 -> 125
    //   99: aload_3
    //   100: astore_2
    //   101: aload_0
    //   102: new 478	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   105: dup
    //   106: invokespecial 761	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   109: putfield 165	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   112: aload_3
    //   113: astore_2
    //   114: aload_0
    //   115: getfield 165	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   118: aload_3
    //   119: invokevirtual 762	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(Lcom/tencent/mobileqq/data/QwSafeInputStream;)V
    //   122: goto +67 -> 189
    //   125: iload_1
    //   126: iconst_2
    //   127: if_icmpne +62 -> 189
    //   130: aload_3
    //   131: astore_2
    //   132: aload_0
    //   133: new 333	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   136: dup
    //   137: invokespecial 756	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	()V
    //   140: putfield 171	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   143: aload_3
    //   144: astore_2
    //   145: aload_0
    //   146: getfield 171	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   149: aload_3
    //   150: invokevirtual 760	com/tencent/mobileqq/data/QQWalletRedPacketMsg:readExternal	(Lcom/tencent/mobileqq/data/QwSafeInputStream;)V
    //   153: goto +36 -> 189
    //   156: aload_3
    //   157: astore_2
    //   158: aload_3
    //   159: invokevirtual 755	com/tencent/mobileqq/data/QwSafeInputStream:readInt	()I
    //   162: iconst_1
    //   163: if_icmpne +26 -> 189
    //   166: aload_3
    //   167: astore_2
    //   168: aload_0
    //   169: new 478	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   172: dup
    //   173: invokespecial 761	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	()V
    //   176: putfield 165	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   179: aload_3
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 165	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   185: aload_3
    //   186: invokevirtual 762	com/tencent/mobileqq/data/QQWalletTransferMsg:readExternal	(Lcom/tencent/mobileqq/data/QwSafeInputStream;)V
    //   189: aload_3
    //   190: invokevirtual 765	com/tencent/mobileqq/data/QwSafeInputStream:close	()V
    //   193: return
    //   194: astore 4
    //   196: goto +13 -> 209
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_3
    //   202: goto +65 -> 267
    //   205: astore 4
    //   207: aconst_null
    //   208: astore_3
    //   209: aload_3
    //   210: astore_2
    //   211: invokestatic 377	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   214: ifeq +17 -> 231
    //   217: aload_3
    //   218: astore_2
    //   219: ldc_w 767
    //   222: iconst_2
    //   223: ldc_w 769
    //   226: aload 4
    //   228: invokestatic 772	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_3
    //   232: astore_2
    //   233: aload_0
    //   234: aconst_null
    //   235: putfield 165	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   238: aload_3
    //   239: astore_2
    //   240: aload_0
    //   241: aconst_null
    //   242: putfield 171	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   245: aload_3
    //   246: ifnull +13 -> 259
    //   249: aload_3
    //   250: invokevirtual 765	com/tencent/mobileqq/data/QwSafeInputStream:close	()V
    //   253: return
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 773	java/lang/Exception:printStackTrace	()V
    //   259: return
    //   260: astore 4
    //   262: aload_2
    //   263: astore_3
    //   264: aload 4
    //   266: astore_2
    //   267: aload_3
    //   268: ifnull +15 -> 283
    //   271: aload_3
    //   272: invokevirtual 765	com/tencent/mobileqq/data/QwSafeInputStream:close	()V
    //   275: goto +8 -> 283
    //   278: astore_3
    //   279: aload_3
    //   280: invokevirtual 773	java/lang/Exception:printStackTrace	()V
    //   283: aload_2
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	MessageForQQWalletMsg
    //   18	110	1	i	int
    //   13	168	2	localObject1	Object
    //   199	1	2	localObject2	Object
    //   210	30	2	localObject3	Object
    //   254	9	2	localException1	Exception
    //   266	18	2	localObject4	Object
    //   11	261	3	localObject5	Object
    //   278	2	3	localException2	Exception
    //   194	1	4	localException3	Exception
    //   205	22	4	localException4	Exception
    //   260	5	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	194	java/lang/Exception
    //   40	51	194	java/lang/Exception
    //   53	61	194	java/lang/Exception
    //   72	77	194	java/lang/Exception
    //   79	84	194	java/lang/Exception
    //   86	94	194	java/lang/Exception
    //   101	112	194	java/lang/Exception
    //   114	122	194	java/lang/Exception
    //   132	143	194	java/lang/Exception
    //   145	153	194	java/lang/Exception
    //   158	166	194	java/lang/Exception
    //   168	179	194	java/lang/Exception
    //   181	189	194	java/lang/Exception
    //   0	12	199	finally
    //   0	12	205	java/lang/Exception
    //   189	193	254	java/lang/Exception
    //   249	253	254	java/lang/Exception
    //   14	19	260	finally
    //   40	51	260	finally
    //   53	61	260	finally
    //   72	77	260	finally
    //   79	84	260	finally
    //   86	94	260	finally
    //   101	112	260	finally
    //   114	122	260	finally
    //   132	143	260	finally
    //   145	153	260	finally
    //   158	166	260	finally
    //   168	179	260	finally
    //   181	189	260	finally
    //   211	217	260	finally
    //   219	231	260	finally
    //   233	238	260	finally
    //   240	245	260	finally
    //   271	275	278	java/lang/Exception
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public int getIsHideTitleDefault()
  {
    QQWalletRedPacketMsg localQQWalletRedPacketMsg = this.mQQWalletRedPacketMsg;
    if ((localQQWalletRedPacketMsg != null) && (localQQWalletRedPacketMsg.elem != null) && (this.mQQWalletRedPacketMsg.elem.v > 0))
    {
      int i = this.messageType;
      if ((i != 18) && (i != 17) && (i != 19) && (i != 21) && (i != 22) && (i != 26) && (i != 23) && (i != 24) && (i != 25) && (i != 27) && (i != 28) && (i != 29))
      {
        if (i == 30) {
          return 0;
        }
        return 1;
      }
    }
    return 0;
  }
  
  public String getMsgSummary()
  {
    Object localObject = this.mQQWalletTransferMsg;
    if ((localObject != null) && (((QQWalletTransferMsg)localObject).elem != null)) {
      return this.mQQWalletTransferMsg.elem.h;
    }
    localObject = this.mQQWalletRedPacketMsg;
    if ((localObject != null) && (((QQWalletRedPacketMsg)localObject).elem != null)) {
      return this.mQQWalletRedPacketMsg.elem.h;
    }
    return "";
  }
  
  public String getSummaryMsg()
  {
    return getMsgSummary();
  }
  
  public boolean isMsgEmpty()
  {
    if ((this.mQQWalletTransferMsg == null) && (this.mQQWalletRedPacketMsg == null)) {
      return true;
    }
    return this.msgData == null;
  }
  
  public boolean isRedPackExpired()
  {
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    return this.time + 90000L < l;
  }
  
  public boolean isSender()
  {
    return (this.senderuin != null) && (this.senderuin.equalsIgnoreCase(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime().getAccount()));
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public boolean needVipBubble()
  {
    return false;
  }
  
  public void onDecodeFinish(BaseQQAppInterface paramBaseQQAppInterface, msg_comm.Msg paramMsg)
  {
    int i = paramMsg.msg_head.msg_type.get();
    long l;
    if ((i != 82) && (i != 43))
    {
      if ((i != 83) && (i != 42))
      {
        PBUInt64Field localPBUInt64Field;
        if (paramBaseQQAppInterface.getCurrentAccountUin().equals(String.valueOf(paramMsg.msg_head.to_uin.get()))) {
          localPBUInt64Field = paramMsg.msg_head.from_uin;
        } else {
          localPBUInt64Field = paramMsg.msg_head.to_uin;
        }
        l = localPBUInt64Field.get();
      }
      else
      {
        l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      }
    }
    else {
      l = paramMsg.msg_head.group_info.group_code.get();
    }
    this.frienduin = String.valueOf(l);
    this.time = paramMsg.msg_head.msg_time.get();
    paramMsg = (IQWalletHbApi)QRoute.api(IQWalletHbApi.class);
    paramMsg.tryScheduleSpecifyAnim(paramBaseQQAppInterface, this);
    paramMsg.tryPreDownEmojiRes(paramBaseQQAppInterface, this);
    paramMsg.tryPreDownLoadModel(this);
  }
  
  public HashMap<String, String> parseUrlParams(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int i = 0;
      while (i < paramString.length)
      {
        if (!TextUtils.isEmpty(paramString[i]))
        {
          String[] arrayOfString = paramString[i].split("=");
          if (arrayOfString.length == 2) {
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
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:");
                localStringBuilder.append(arrayOfString[0]);
                localStringBuilder.append(",tmps[1] is:");
                localStringBuilder.append(arrayOfString[1]);
                QLog.d("Q.msg.qqwalletmsg", 2, localStringBuilder.toString(), localException);
              }
            }
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  protected void postRead()
  {
    parse();
    try
    {
      ((IPasswdRedBagService)((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getRuntime().getAppRuntime(this.selfuin).getRuntimeService(IPasswdRedBagService.class, "")).loadRedBagInfoToCache(true);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.qqwalletmsg", 2, "postRead init read status");
    }
  }
  
  protected void prewrite()
  {
    Object localObject = this.mQQWalletTransferMsg;
    if (localObject == null)
    {
      localObject = this.mQQWalletRedPacketMsg;
      if (localObject == null) {
        localObject = null;
      }
    }
    if (localObject != null)
    {
      localObject = ((ISafeStream)localObject).flushMsgData(this.messageType);
      if (localObject != null) {
        this.msgData = ((byte[])localObject);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.qqwalletmsg", 2, "prewrite... ssp is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletMsg
 * JD-Core Version:    0.7.0.1
 */