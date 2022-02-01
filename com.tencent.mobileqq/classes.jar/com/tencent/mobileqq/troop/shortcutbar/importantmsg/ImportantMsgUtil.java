package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.codec.decoder.GrpDisPTTDecoder;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class ImportantMsgUtil
{
  public static int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return -1;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr(MessageConstants.F);
    if (!TextUtils.isEmpty(paramMessageRecord)) {
      try
      {
        int i = Integer.parseInt(paramMessageRecord);
        return i;
      }
      catch (NumberFormatException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return -1;
  }
  
  public static ImportantMsgInfo a(ImportantMsgItem.MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo == null) {
      return null;
    }
    if (!paramMsgInfo.msgNeedShow) {
      return null;
    }
    Object localObject = (ImportantMsgEntryConfig)QConfigManager.a().a(658);
    if (localObject == null) {
      return null;
    }
    localObject = ((ImportantMsgEntryConfig)localObject).a(paramMsgInfo.msgEnum);
    if (localObject == null) {
      return null;
    }
    ImportantMsgInfo localImportantMsgInfo = new ImportantMsgInfo();
    localImportantMsgInfo.b(((ImportantMsgEntryConfig.EntryConfig)localObject).jdField_a_of_type_JavaLangString);
    localImportantMsgInfo.b(paramMsgInfo.msgSeq);
    localImportantMsgInfo.a(paramMsgInfo.msgSummary);
    localImportantMsgInfo.c(paramMsgInfo.msgTime);
    localImportantMsgInfo.c(paramMsgInfo.msgSendUin);
    localImportantMsgInfo.a(((ImportantMsgEntryConfig.EntryConfig)localObject).jdField_a_of_type_Long);
    return localImportantMsgInfo;
  }
  
  public static ImportantMsgItem.MsgInfo a(long paramLong)
  {
    return new ImportantMsgItem.MsgInfo(0L, paramLong, "", 0, "", true, 0);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface = "";
    if (paramMessageRecord == null) {
      return "";
    }
    if (paramInt == 1) {
      return a(paramMessageRecord);
    }
    if (paramInt == 3) {
      return b(paramMessageRecord);
    }
    if (paramInt == 2) {
      return c(paramMessageRecord);
    }
    if (paramInt == 4) {
      return d(paramMessageRecord);
    }
    if (paramInt == 5) {
      return a(paramMessageRecord, false);
    }
    if (paramInt == 6) {
      paramQQAppInterface = a(paramMessageRecord, true);
    }
    return paramQQAppInterface;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQAppInterface.getMessageFacade().a(localMessage);
    paramMessageRecord = new MsgSummary();
    MsgUtils.a(paramContext, paramQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, "", false, false);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject = (ImportantMsgEntryConfig)QConfigManager.a().a(658);
    if (localObject == null) {
      return "";
    }
    localObject = ((ImportantMsgEntryConfig)localObject).a(paramInt);
    if (localObject == null) {
      return "";
    }
    if (((ImportantMsgEntryConfig.EntryConfig)localObject).jdField_a_of_type_Int == 0) {
      return a(paramQQAppInterface, paramContext, paramInt, paramMessageRecord);
    }
    if (((ImportantMsgEntryConfig.EntryConfig)localObject).jdField_a_of_type_Int == 1) {
      return ((ImportantMsgEntryConfig.EntryConfig)localObject).b;
    }
    if (((ImportantMsgEntryConfig.EntryConfig)localObject).jdField_a_of_type_Int == 2) {
      return a(paramQQAppInterface, paramContext, paramMessageRecord);
    }
    return "";
  }
  
  private static String a(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131719897);
    if ((paramMessageRecord instanceof MessageForTroopFile))
    {
      paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
      if (!TextUtils.isEmpty(paramMessageRecord.fileName)) {
        return paramMessageRecord.fileName;
      }
    }
    return str;
  }
  
  private static String a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131719896);
    if (paramBoolean) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131719898);
    }
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord != null) && (paramMessageRecord.appName != null)) {
        if (paramMessageRecord.appName.equals("com.tencent.structmsg")) {
          try
          {
            paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("news");
            if (paramMessageRecord == null) {
              return str;
            }
            paramMessageRecord = paramMessageRecord.optString("title", "");
            paramBoolean = paramMessageRecord.isEmpty();
            if (paramBoolean) {
              return str;
            }
            return paramMessageRecord;
          }
          catch (JSONException paramMessageRecord)
          {
            paramMessageRecord.printStackTrace();
            return str;
          }
        } else if (paramMessageRecord.appName.equals("com.tencent.miniapp_01")) {
          try
          {
            paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("detail_1");
            if (paramMessageRecord == null) {
              return str;
            }
            paramMessageRecord = paramMessageRecord.optString("desc", "");
            paramBoolean = paramMessageRecord.isEmpty();
            if (paramBoolean) {
              return str;
            }
            return paramMessageRecord;
          }
          catch (JSONException paramMessageRecord)
          {
            paramMessageRecord.printStackTrace();
            return str;
          }
        }
      }
    }
    else if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = StructMsgFactory.a(paramMessageRecord.msgData);
      if ((paramMessageRecord != null) && ((paramMessageRecord instanceof StructMsgForGeneralShare)))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if (!TextUtils.isEmpty(paramMessageRecord.mContentTitle)) {
          return paramMessageRecord.mContentTitle;
        }
      }
    }
    return str;
  }
  
  public static ArrayList<ImportantMsgItem.MsgInfo> a(QQAppInterface paramQQAppInterface, long paramLong, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      int j = a(paramList);
      if ((paramBoolean) || ((a(paramList)) && (-1 != j)))
      {
        long l1 = paramList.time;
        long l2 = paramList.shmsgseq;
        String str2 = paramList.senderuin;
        boolean bool = b(paramList);
        String str1 = "";
        if (bool)
        {
          paramList = new StringBuilder();
          paramList.append("parseImportantMsg isRevokedMsg troopUin:");
          paramList.append(paramLong);
          paramList.append(" msgSeq:");
          paramList.append(l2);
          QLog.i("ImportantMsgUtil", 1, paramList.toString());
        }
        for (int i = 2;; i = 4)
        {
          bool = false;
          paramList = "";
          break label312;
          if (!c(paramList)) {
            break;
          }
          paramList = new StringBuilder();
          paramList.append("parseImportantMsg isTroopNotificationShowWindow troopUin:");
          paramList.append(paramLong);
          paramList.append(" msgSeq:");
          paramList.append(l2);
          QLog.i("ImportantMsgUtil", 1, paramList.toString());
        }
        paramList = a(paramQQAppInterface, BaseApplicationImpl.getContext(), paramList, j);
        if (TextUtils.isEmpty(paramList))
        {
          paramList = new StringBuilder();
          paramList.append("parseImportantMsg msgSummary == null troopUin:");
          paramList.append(paramLong);
          paramList.append(" msgSeq:");
          paramList.append(l2);
          QLog.i("ImportantMsgUtil", 1, paramList.toString());
          paramList = "";
          bool = false;
          i = 3;
        }
        else
        {
          bool = true;
          i = 0;
        }
        label312:
        if (TextUtils.isEmpty(paramList)) {
          paramList = str1;
        }
        localArrayList.add(new ImportantMsgItem.MsgInfo(l1, l2, str2, j, paramList, bool, i));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<ShortcutBarInfo> a(ArrayList<ImportantMsgItem.MsgInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ImportantMsgItem.MsgInfo localMsgInfo = (ImportantMsgItem.MsgInfo)paramArrayList.next();
      Object localObject = a(localMsgInfo);
      if (localObject != null)
      {
        localArrayList.add(localObject);
      }
      else if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("convToImportantMsgInfo error: ");
        ((StringBuilder)localObject).append(localMsgInfo.toString());
        QLog.i("ImportantMsgUtil", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0xea3.BackMsg paramBackMsg, List<MessageRecord> paramList)
  {
    if ((paramQQAppInterface != null) && (paramBackMsg != null)) {
      if (paramList == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.getMsgHandler();
        if (paramBackMsg.msg.has())
        {
          msg_comm.Msg localMsg = new msg_comm.Msg();
          localMsg.mergeFrom(paramBackMsg.msg.get().toByteArray());
          if (!localMsg.msg_head.has()) {
            break label397;
          }
          paramBackMsg = (msg_comm.MsgHead)localMsg.msg_head.get();
          if ((!paramBackMsg.group_info.has()) || (((msg_comm.GroupInfo)paramBackMsg.group_info.get()).group_type.get() != 127)) {
            break label392;
          }
          i = 1;
          l3 = paramBackMsg.msg_seq.get();
          l2 = paramBackMsg.msg_time.get();
          l1 = paramBackMsg.from_uin.get();
          if (!localMsg.content_head.has()) {
            break label421;
          }
          j = ((msg_comm.ContentHead)localMsg.content_head.get()).pkg_num.get();
          if (localMsg.msg_body.has())
          {
            paramBackMsg = (im_msg_body.MsgBody)localMsg.msg_body.get();
            if (paramBackMsg.rich_text.has()) {
              if (((im_msg_body.RichText)paramBackMsg.rich_text.get()).ptt.has()) {
                new GrpDisPTTDecoder().a(paramQQAppInterface, localMsg, paramList, null);
              } else {
                MessageProtoCodec.a(paramQQAppInterface, paramList, localMsg, false, false, new MessageInfo());
              }
            }
          }
          if ((paramList.size() == 0) && (j > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ImportantMsgUtil", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
            }
            paramQQAppInterface = (MessageForText)MessageRecordFactory.a(-1000);
            paramQQAppInterface.msgtype = -1000;
            paramQQAppInterface.msg = "";
            paramList.add(paramQQAppInterface);
          }
          paramQQAppInterface = paramList.iterator();
          if (paramQQAppInterface.hasNext())
          {
            paramBackMsg = (MessageRecord)paramQQAppInterface.next();
            if (i != 0) {
              paramBackMsg.msgtype = -2006;
            }
            paramBackMsg.time = l2;
            paramBackMsg.shmsgseq = l3;
            paramBackMsg.senderuin = String.valueOf(l1);
            continue;
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      label392:
      int i = 0;
      continue;
      label397:
      long l2 = 0L;
      long l1 = l2;
      long l4 = l1;
      i = 0;
      long l3 = l1;
      l1 = l4;
      continue;
      label421:
      int j = 0;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr(MessageConstants.E);
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return false;
    }
    return paramMessageRecord.equals("1");
  }
  
  private static String b(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131719895);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord != null) {
        try
        {
          Object localObject = new JSONObject(paramMessageRecord.metaList).optJSONObject("albumData");
          if (localObject != null)
          {
            paramMessageRecord = ((JSONObject)localObject).optString("title", "");
            localObject = ((JSONObject)localObject).optString("albumName", "");
            if ((!paramMessageRecord.isEmpty()) && (!((String)localObject).isEmpty()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("《");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("》");
              localObject = localStringBuilder.toString();
              if (paramMessageRecord.startsWith((String)localObject)) {
                return paramMessageRecord.substring(((String)localObject).length());
              }
            }
            else if (((String)localObject).isEmpty())
            {
              boolean bool = paramMessageRecord.isEmpty();
              if (!bool) {
                return paramMessageRecord;
              }
            }
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return str;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if (paramMessageRecord == null) {
      return false;
    }
    if (paramMessageRecord.msgtype == -2006) {
      bool = true;
    }
    return bool;
  }
  
  private static String c(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131719900);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord != null) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("mannounce");
          if (paramMessageRecord != null)
          {
            paramMessageRecord = paramMessageRecord.optString("text", "");
            if (!paramMessageRecord.isEmpty())
            {
              paramMessageRecord = new String(Base64.decode(paramMessageRecord, 2));
              return paramMessageRecord;
            }
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return str;
  }
  
  private static boolean c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      try
      {
        if (paramMessageRecord.ark_app_message != null)
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.ark_app_message.metaList).optJSONObject("mannounce");
          if (paramMessageRecord != null)
          {
            int i = paramMessageRecord.optInt("tw", 1);
            if (i == 0) {
              return true;
            }
          }
        }
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return false;
  }
  
  private static String d(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131719899);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.getSummery()))) {
        return paramMessageRecord.getSummery();
      }
    }
    else if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = StructMsgFactory.a(paramMessageRecord.msgData);
      if ((paramMessageRecord != null) && ((paramMessageRecord instanceof StructMsgForGeneralShare)))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if (!TextUtils.isEmpty(paramMessageRecord.mContentTitle)) {
          return paramMessageRecord.mContentTitle;
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgUtil
 * JD-Core Version:    0.7.0.1
 */