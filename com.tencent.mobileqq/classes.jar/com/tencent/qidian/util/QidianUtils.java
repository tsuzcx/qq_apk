package com.tencent.qidian.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile.ResvAttr;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;

public class QidianUtils
{
  public static int a(String paramString)
  {
    int k = 0;
    int i;
    try
    {
      paramString = paramString.split("\\.");
      i = 0;
      int j = 24;
      for (;;)
      {
        m = i;
        try
        {
          if (k >= paramString.length) {
            break label70;
          }
          long l1 = i;
          long l2 = Long.parseLong(paramString[k]);
          i = (int)(l1 | l2 << j);
          j -= 8;
          k += 1;
        }
        catch (Exception paramString) {}
      }
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    int m = i;
    label70:
    return m;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    String str2 = paramChatMessage.getExtInfoFromExtStr("qidian_ext_nick_name");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = QidianManager.c(paramQQAppInterface, paramChatMessage.senderuin);
    }
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.d("QidianUtils", 2, "qidian ext nickname is null");
    }
    return str1;
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString4))
    {
      int i = paramString4.indexOf(paramAppInterface.getApp().getString(2131896245));
      if (i == -1) {
        return;
      }
      paramString4 = new UniteGrayTipParam(paramString1, paramAppInterface.getCurrentAccountUin(), paramString4, paramInt, -5023, 1245186, MessageCache.c());
      paramString4.q = false;
      paramString4.j = paramLong;
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("key_action", 12);
      paramString4.a(i, i + 4, (Bundle)localObject);
      localObject = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramAppInterface, paramString4);
      ((MessageForUniteGrayTip)localObject).masterUin = paramString2;
      ((MessageForUniteGrayTip)localObject).extUin = paramString1;
      ((MessageForUniteGrayTip)localObject).taskId = paramString3;
      UniteGrayTipMsgUtil.a(paramAppInterface, (MessageForUniteGrayTip)localObject);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Crm.CrmCCNotify paramCrmCCNotify, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo)
  {
    long l = paramMsg.msg_head.from_uin.get();
    int i;
    if (paramTempSessionInfo == null) {
      i = 0;
    } else {
      i = paramTempSessionInfo.a;
    }
    a(paramQQAppInterface, String.valueOf(l), i, -2005, paramMsg.msg_head.msg_time.get(), paramCrmCCNotify.str_check_id.get());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      String str1;
      if (paramInt2 == -1000) {
        str1 = "1";
      }
      for (;;)
      {
        break;
        if (paramInt2 == -2000) {
          str1 = "2";
        } else if (paramInt2 == -2005) {
          str1 = "3";
        } else if (paramInt2 == -2011) {
          str1 = "4";
        } else {
          str1 = "0";
        }
      }
      String str2;
      if (paramInt1 == 0) {
        str2 = "0X800980B";
      }
      for (;;)
      {
        break;
        if (paramInt1 == 1024) {
          str2 = "0X8009810";
        } else if (paramInt1 == 1025) {
          str2 = "0X8009811";
        } else if (paramInt1 == 1000) {
          str2 = "0X800980E";
        } else {
          str2 = null;
        }
      }
      if (str2 != null) {
        ReportController.b(paramQQAppInterface, "dc00899", "Qidian", paramString1, str2, "1", 1, 0, str1, "0", String.valueOf(paramInt3), paramString2);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    long l = MessageCache.c();
    paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramInt, -5020, 1245187, l);
    paramString1.q = false;
    paramString1.j = l;
    paramString1.p = paramString3;
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, Crm.CrmCCNotify paramCrmCCNotify)
  {
    if (paramList.isEmpty()) {
      return;
    }
    paramList = (MessageRecord)paramList.get(0);
    if ((paramList != null) && (!paramList.isSend()))
    {
      long l = paramMsg.msg_head.from_uin.get();
      int i;
      if (paramTempSessionInfo == null) {
        i = 0;
      } else {
        i = paramTempSessionInfo.a;
      }
      int j = paramMsg.msg_head.msg_time.get();
      paramMsg = paramCrmCCNotify.str_check_id.get();
      a(paramQQAppInterface, String.valueOf(l), i, paramList.msgtype, j, paramMsg);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, im_msg_body.NotOnlineFile paramNotOnlineFile, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo)
  {
    if (paramNotOnlineFile != null)
    {
      if (!paramNotOnlineFile.bytes_pb_reserve.has()) {
        return;
      }
      Object localObject = paramNotOnlineFile.bytes_pb_reserve.get().toByteArray();
      try
      {
        paramNotOnlineFile = new tencent_im_msg_hummer_resv_notonlinefile.ResvAttr();
        paramNotOnlineFile.mergeFrom((byte[])localObject);
        localObject = new Crm.CrmCCNotify();
        ((Crm.CrmCCNotify)localObject).mergeFrom(paramNotOnlineFile.bytes_crm_buf.get().toByteArray());
        if ((((Crm.CrmCCNotify)localObject).str_ext_nick_name.has()) && (!paramList.isEmpty())) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("qidian_ext_nick_name", ((Crm.CrmCCNotify)localObject).str_ext_nick_name.get());
        }
        a(paramQQAppInterface, (Crm.CrmCCNotify)localObject, paramMsg, paramTempSessionInfo);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public static void a(TempSessionInfo paramTempSessionInfo, msg_comm.Msg paramMsg, MessageRecord paramMessageRecord)
  {
    if ((paramTempSessionInfo != null) && (paramTempSessionInfo.a == 1024) && (paramMsg.msg_body.rich_text.has()) && (paramMsg.msg_body.rich_text.elems.has()))
    {
      paramTempSessionInfo = paramMsg.msg_body.rich_text.elems.get().iterator();
      while (paramTempSessionInfo.hasNext())
      {
        paramMsg = (im_msg_body.Elem)paramTempSessionInfo.next();
        if ((paramMsg.has()) && (paramMsg.crm_elem.has()) && (paramMsg.crm_elem.crm_buf.has()))
        {
          Object localObject = new Crm.CrmCCNotify();
          try
          {
            ((Crm.CrmCCNotify)localObject).mergeFrom(paramMsg.crm_elem.crm_buf.get().toByteArray());
            if (((Crm.CrmCCNotify)localObject).str_ext_nick_name.has()) {
              paramMessageRecord.saveExtInfoToExtStr("qidian_ext_nick_name", ((Crm.CrmCCNotify)localObject).str_ext_nick_name.get());
            }
          }
          catch (InvalidProtocolBufferMicroException paramMsg)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("qidian add ext name in master session ");
            ((StringBuilder)localObject).append(paramMsg);
            QLog.d("QidianUtils", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.util.QidianUtils
 * JD-Core Version:    0.7.0.1
 */