package com.tencent.mobileqq.service.message;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageRecordFactoryService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.Text;

public class QMessagePBElemDecoder
{
  protected AppRuntime c = MobileQQ.sMobileQQ.waitAppRuntime(null);
  
  private long a(msg_comm.Msg paramMsg, long paramLong, int paramInt)
  {
    long l;
    if (paramInt != 82)
    {
      l = paramLong;
      if (paramInt != 43) {}
    }
    else
    {
      l = paramLong;
      if (paramMsg.msg_head.group_info != null)
      {
        l = paramLong;
        if (paramMsg.msg_head.group_info.group_code.has()) {
          l = paramMsg.msg_head.group_info.group_code.get();
        }
      }
    }
    return l;
  }
  
  @NonNull
  private StringBuilder a(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder != null) {
      return new StringBuilder(paramStringBuilder);
    }
    return new StringBuilder();
  }
  
  private im_msg_body.Text a(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.text.has()) {
        paramList = (im_msg_body.Text)localElem.text.get();
      }
    }
    return paramList;
  }
  
  private void a(ResultBox paramResultBox, AtTroopMemberInfo paramAtTroopMemberInfo, byte[] paramArrayOfByte)
  {
    paramResultBox = paramResultBox.a;
    if (paramResultBox != null)
    {
      if ((paramAtTroopMemberInfo == null) && (paramArrayOfByte == null)) {
        return;
      }
      if (paramResultBox.isEmpty())
      {
        paramResultBox.add(paramAtTroopMemberInfo);
        paramResultBox.add(paramArrayOfByte);
        return;
      }
      if (paramResultBox.size() != 2) {
        return;
      }
      if ((paramResultBox.get(0) != null) && (paramResultBox.get(1) != null)) {
        return;
      }
      if (paramResultBox.get(0) != null) {
        paramAtTroopMemberInfo = paramResultBox.get(0);
      }
      if (paramResultBox.get(1) != null) {
        paramArrayOfByte = paramResultBox.get(1);
      }
      paramResultBox.clear();
      paramResultBox.add(paramAtTroopMemberInfo);
      paramResultBox.add(paramArrayOfByte);
    }
  }
  
  private boolean a(im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool = true;
    if ((paramGeneralFlags != null) && (paramGeneralFlags.long_text_flag.get() == 1))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("QMessagePBElemDecoder", 2, "decodePBMsgElems_RichMsg, longTextFlag: true");
        return true;
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
        if (str.length() < 2) {
          localStringBuilder.append(0);
        }
        localStringBuilder.append(str);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private im_msg_body.GeneralFlags c(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.general_flags.has()) {
        paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      }
    }
    return paramList;
  }
  
  private im_msg_body.RichMsg d(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.rich_msg.has()) {
        paramList = (im_msg_body.RichMsg)localElem.rich_msg.get();
      }
    }
    return paramList;
  }
  
  protected ChatMessage a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, ArrayList<Object> paramArrayList, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList1)
  {
    paramList = (ChatMessage)((IMessageRecordFactoryService)QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
    if (paramArrayList.size() > 0)
    {
      paramMsg = new ArrayList(paramArrayList.size());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramMessageInfo = paramArrayList.next();
        if ((paramMessageInfo instanceof AtTroopMemberInfo)) {
          paramMsg.add((AtTroopMemberInfo)paramMessageInfo);
        }
      }
      paramList.atInfoTempList = paramMsg;
    }
    return paramList;
  }
  
  protected MsgDecoderWrapper a(im_msg_body.RichMsg paramRichMsg, List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return MsgDecoderWrapper.a();
  }
  
  protected QParsePBMsgElemsDefaultTextElem a(StringBuilder paramStringBuilder1, long paramLong, MessageInfo paramMessageInfo, ArrayList<AtTroopMemberInfo> paramArrayList, AtTroopMemberInfo paramAtTroopMemberInfo1, AtTroopMemberInfo paramAtTroopMemberInfo2, byte[] paramArrayOfByte, StringBuilder paramStringBuilder2, boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    return new QParsePBMsgElemsDefaultTextElem(this.c, paramStringBuilder1, paramLong, paramMessageInfo, paramArrayList, paramAtTroopMemberInfo1, paramAtTroopMemberInfo2, paramArrayOfByte, paramStringBuilder2, paramBoolean, paramElem);
  }
  
  protected String a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, boolean paramBoolean)
  {
    Object localObject = paramList.iterator();
    String str = null;
    paramList = null;
    while (((Iterator)localObject).hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)((Iterator)localObject).next();
      if (localElem.text.has()) {
        paramList = (im_msg_body.Text)localElem.text.get();
      }
    }
    localObject = str;
    if (paramList != null)
    {
      localObject = str;
      if (paramList.str.has())
      {
        paramList = paramList.str.get().toStringUtf8();
        localObject = paramList;
        if (paramBoolean)
        {
          str = MessageUtils.a(paramList, false);
          localObject = paramList;
          if (str.length() > 0)
          {
            localObject = ((IMessageRecordFactoryService)QRoute.api(IMessageRecordFactoryService.class)).createMsgRecordByMsgType(-1000);
            ((MessageRecord)localObject).msgtype = -1000;
            ((MessageRecord)localObject).msg = str;
            paramList1.add(localObject);
            localObject = paramList;
          }
        }
      }
    }
    return localObject;
  }
  
  protected StringBuilder a(StringBuilder paramStringBuilder1, List<im_msg_body.Elem> paramList, StringBuilder paramStringBuilder2, long paramLong, MessageInfo paramMessageInfo, ResultBox paramResultBox, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (paramResultBox == null) {
      paramResultBox = new ResultBox();
    }
    Object localObject = paramResultBox.b;
    StringBuilder localStringBuilder = a(paramStringBuilder1);
    Iterator localIterator = paramList.iterator();
    paramList = (List<im_msg_body.Elem>)localObject;
    paramStringBuilder1 = null;
    localObject = paramStringBuilder1;
    QParsePBMsgElemsDefaultTextElem localQParsePBMsgElemsDefaultTextElem;
    for (boolean bool = false; localIterator.hasNext(); bool = localQParsePBMsgElemsDefaultTextElem.e())
    {
      localQParsePBMsgElemsDefaultTextElem = a(paramStringBuilder2, paramLong, paramMessageInfo, paramArrayList, paramStringBuilder1, paramList, (byte[])localObject, localStringBuilder, bool, (im_msg_body.Elem)localIterator.next()).f();
      paramStringBuilder1 = localQParsePBMsgElemsDefaultTextElem.b();
      paramList = localQParsePBMsgElemsDefaultTextElem.c();
      localObject = localQParsePBMsgElemsDefaultTextElem.d();
    }
    paramResultBox.b = paramList;
    a(paramResultBox, paramStringBuilder1, (byte[])localObject);
    return localStringBuilder;
  }
  
  protected void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, im_msg_body.GeneralFlags paramGeneralFlags, boolean paramBoolean, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("c2cMsgContent.data:null;\n");
    }
    h(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
  }
  
  protected void a(msg_comm.Msg paramMsg, byte[] paramArrayOfByte, MessageRecord paramMessageRecord)
  {
    if (paramMsg.msg_head.from_uin.has())
    {
      long l = paramMsg.msg_head.from_uin.get();
      if (TextUtils.equals(this.c.getCurrentAccountUin(), Long.toString(l)))
      {
        i = 1;
        break label52;
      }
    }
    int i = 0;
    label52:
    if ((paramArrayOfByte != null) && (i == 0)) {
      paramMessageRecord.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramArrayOfByte));
    }
  }
  
  protected boolean a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, msg_comm.Msg paramMsg, im_msg_body.GeneralFlags paramGeneralFlags, im_msg_body.Text paramText, byte[] paramArrayOfByte, long paramLong1, MessageRecord paramMessageRecord, long paramLong2, int paramInt)
  {
    return false;
  }
  
  @Nullable
  protected im_msg_body.GeneralFlags b(List<im_msg_body.Elem> paramList)
  {
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)localIterator.next();
      if (localElem.general_flags.has()) {
        paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
      }
    }
    return paramList;
  }
  
  public void h(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    ResultBox localResultBox = new ResultBox();
    ArrayList localArrayList1 = localResultBox.a;
    ArrayList localArrayList2 = new ArrayList(2);
    paramStringBuilder = a(null, paramList, paramStringBuilder, paramMsg.msg_head.msg_seq.get(), paramMessageInfo, localResultBox, localArrayList2);
    if (paramStringBuilder.length() == 0) {
      return;
    }
    paramList = a(paramList, paramMsg, localArrayList1, paramMessageInfo, localArrayList2);
    paramList.msg = paramStringBuilder.toString();
    paramList1.add(paramList);
  }
  
  public void i(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QMessagePBElemDecoder", 2, "begin decodePBMsgElems_RichMsg");
    }
    Object localObject = d(paramList);
    im_msg_body.GeneralFlags localGeneralFlags = c(paramList);
    im_msg_body.Text localText = a(paramList);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QMessagePBElemDecoder", 2, "richMsg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:RichMsg;\n");
    }
    boolean bool = a(localGeneralFlags);
    long l1;
    if (paramMsg.msg_head.from_uin.has()) {
      l1 = paramMsg.msg_head.from_uin.get();
    } else {
      l1 = 0L;
    }
    long l2 = paramMsg.msg_head.to_uin.get();
    int i = paramMsg.msg_head.msg_type.get();
    l2 = a(paramMsg, l2, i);
    localObject = a((im_msg_body.RichMsg)localObject, paramList, paramMsg, localGeneralFlags);
    if (a(paramList, paramList1, paramMsg, localGeneralFlags, localText, ((MsgDecoderWrapper)localObject).b, l1, ((MsgDecoderWrapper)localObject).a, l2, i)) {
      return;
    }
    ((MsgDecoderWrapper)localObject).a.msg = "richMsg";
    a(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo, localGeneralFlags, bool, ((MsgDecoderWrapper)localObject).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessagePBElemDecoder
 * JD-Core Version:    0.7.0.1
 */