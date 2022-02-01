package com.tencent.mobileqq.paiyipai;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xed3.oidb_cmd0xed3.ReqBody;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51.C2CMsgInfo;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51.CommGrayTipsInfo;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51.GroupMsgInfo;
import tencent.im.oidb.cmd0xf51.oidb_cmd0xf51.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class PaiYiPaiHandler
  extends BusinessHandler
{
  public QQAppInterface a;
  
  protected PaiYiPaiHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected PaiYiPaiHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private oidb_cmd0xf51.ReqBody a(MessageRecord paramMessageRecord)
  {
    if (!PaiYiPaiMsgUtil.a(paramMessageRecord)) {
      return null;
    }
    oidb_cmd0xf51.ReqBody localReqBody = new oidb_cmd0xf51.ReqBody();
    int i = paramMessageRecord.istroop;
    if (i != 0)
    {
      if (i == 1) {
        a(paramMessageRecord, localReqBody);
      }
    }
    else {
      b(paramMessageRecord, localReqBody);
    }
    oidb_cmd0xf51.CommGrayTipsInfo localCommGrayTipsInfo = new oidb_cmd0xf51.CommGrayTipsInfo();
    try
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id");
      localCommGrayTipsInfo.uint64_busi_id.set(Long.parseLong(str));
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("uint64_tips_seq_id");
      localCommGrayTipsInfo.uint64_tips_seq_id.set(Long.parseLong(paramMessageRecord));
    }
    catch (NumberFormatException paramMessageRecord)
    {
      QLog.e("PaiYiPaiHandler", 1, "CommGrayTipsInfo", paramMessageRecord);
    }
    localReqBody.msg_comm_gray_tips_info.set(localCommGrayTipsInfo);
    return localReqBody;
  }
  
  private void a(MessageRecord paramMessageRecord, oidb_cmd0xf51.ReqBody paramReqBody)
  {
    oidb_cmd0xf51.GroupMsgInfo localGroupMsgInfo = new oidb_cmd0xf51.GroupMsgInfo();
    try
    {
      localGroupMsgInfo.uint64_group_code.set(Long.parseLong(paramMessageRecord.frienduin));
      long l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("pai_yi_pai_uint64_msg_type")) & 0xFFFF;
      long l2 = 0xFFFF & Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("pai_yi_pai_uint64_msg_seq"));
      String str = paramMessageRecord.getExtInfoFromExtStr("pai_yi_pai_uint64_msg_id");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildRevokeTroopPaiYiPaiReq() called with: msgType = [");
      localStringBuilder.append(l1);
      localStringBuilder.append("], msgSeq = [");
      localStringBuilder.append(l2);
      localStringBuilder.append("], time = [");
      localStringBuilder.append(paramMessageRecord.time);
      localStringBuilder.append("], msgUid = [");
      localStringBuilder.append(paramMessageRecord.msgUid);
      localStringBuilder.append("], msgId = [");
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiHandler", 1, localStringBuilder.toString());
      localGroupMsgInfo.uint64_msg_type.set(l1);
      localGroupMsgInfo.uint64_msg_seq.set(l2);
      localGroupMsgInfo.uint64_msg_time.set(paramMessageRecord.time);
      localGroupMsgInfo.uint64_msg_uid.set(paramMessageRecord.msgUid);
      localGroupMsgInfo.uint64_msg_id.set(Long.parseLong(str));
    }
    catch (NumberFormatException paramMessageRecord)
    {
      QLog.e("PaiYiPaiHandler", 1, "GroupMsgInfo", paramMessageRecord);
    }
    paramReqBody.msg_group_msg_info.set(localGroupMsgInfo);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveF51() called with: resultCode = [");
      localStringBuilder.append(i);
      localStringBuilder.append("], req = [");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append("], res = [");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiHandler", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.d("PaiYiPaiHandler", 1, "onReceiveF51()  e =", paramFromServiceMsg);
      }
      i = paramToServiceMsg.uint32_result.get();
      if (i == 0)
      {
        notifyUI(i, true, null);
        return;
      }
      notifyUI(9998, false, Integer.valueOf(i));
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onReceiveF51() error, result Code = [");
    paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
    paramToServiceMsg.append("]");
    QLog.e("PaiYiPaiHandler", 1, paramToServiceMsg.toString());
    notifyUI(9998, false, Integer.valueOf(0));
  }
  
  private boolean a(String paramString)
  {
    Object localObject1 = this.appRuntime.getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pai_yi_pai_user_double_tap_timestamp_");
    localStringBuilder.append((String)localObject1);
    localObject1 = ((BaseApplicationImpl)localObject2).getSharedPreferences(localStringBuilder.toString(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong(paramString, 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l2 - l1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("canSendReq() called with: toUin = [");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], lastDoubleTapTimestamp = [");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], now = [");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append("], interval = [");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append("]ms");
      QLog.d("PaiYiPaiHandler", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = true;
    if ((l1 != 0L) && (l3 <= 10000L)) {
      bool = false;
    }
    if (bool) {
      ((SharedPreferences)localObject1).edit().putLong(paramString, l2).apply();
    }
    return bool;
  }
  
  private void b(MessageRecord paramMessageRecord, oidb_cmd0xf51.ReqBody paramReqBody)
  {
    oidb_cmd0xf51.C2CMsgInfo localC2CMsgInfo = new oidb_cmd0xf51.C2CMsgInfo();
    try
    {
      localC2CMsgInfo.uint64_aio_uin.set(Long.parseLong(paramMessageRecord.frienduin));
      long l1 = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("pai_yi_pai_uint64_msg_type")) & 0xFFFF;
      long l2 = 0xFFFF & paramMessageRecord.shmsgseq;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildRevokeFriendPaiYiPaiReq() called with: msgType = [");
      localStringBuilder.append(l1);
      localStringBuilder.append("], msgSeq = [");
      localStringBuilder.append(l2);
      localStringBuilder.append("], time = [");
      localStringBuilder.append(paramMessageRecord.time);
      localStringBuilder.append("], msgUid = [");
      localStringBuilder.append(paramMessageRecord.msgUid);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiHandler", 1, localStringBuilder.toString());
      localC2CMsgInfo.uint64_msg_type.set(l1);
      localC2CMsgInfo.uint64_msg_seq.set(l2);
      localC2CMsgInfo.uint64_msg_time.set(paramMessageRecord.time);
      localC2CMsgInfo.uint64_msg_uid.set(paramMessageRecord.msgUid);
    }
    catch (NumberFormatException paramMessageRecord)
    {
      QLog.e("PaiYiPaiHandler", 1, "C2CMsgInfo", paramMessageRecord);
    }
    paramReqBody.msg_c2c_msg_info.set(localC2CMsgInfo);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveEd3() called with: resultCode = [");
      localStringBuilder.append(i);
      localStringBuilder.append("], req = [");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append("], res = [");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append("]");
      QLog.d("PaiYiPaiHandler", 2, localStringBuilder.toString());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.d("PaiYiPaiHandler", 1, "onReceiveEd3()  e =", paramFromServiceMsg);
      }
      notifyUI(paramToServiceMsg.uint32_result.get(), true, null);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRevokePaiYiPaiReq, timeout: ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("revokePaiYiPai", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.a.getMsgCache().D())
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokePaiYiPai", 2, "sendRevokePaiYiPaiReq error, isPaiYiPaiRevoking: false");
      }
      return;
    }
    Object localObject = a(paramMessageRecord);
    if (localObject == null) {
      QLog.e("revokePaiYiPai", 1, "sendRevokePaiYiPaiReq error, reqBody is null");
    }
    localObject = makeOIDBPkg("OidbSvc.0xf51", 3921, 1, ((oidb_cmd0xf51.ReqBody)localObject).toByteArray());
    if (localObject == null) {
      return;
    }
    ((ToServiceMsg)localObject).setTimeout(paramLong);
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendRevokePaiYiPaiReq() called with: mr = [");
      ((StringBuilder)localObject).append(paramMessageRecord);
      ((StringBuilder)localObject).append("], timeout = [");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.d("PaiYiPaiHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, paramInt, 0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!a(paramString1))
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 0, 2131892372, 0).show();
      return;
    }
    Object localObject = new oidb_cmd0xed3.ReqBody();
    ((oidb_cmd0xed3.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString1).longValue());
    ((oidb_cmd0xed3.ReqBody)localObject).uint32_nudge_type.set(paramInt2);
    if (paramInt1 == 0)
    {
      ((oidb_cmd0xed3.ReqBody)localObject).uint64_aio_uin.set(Long.valueOf(paramString2).longValue());
    }
    else
    {
      if (paramInt1 != 1) {
        return;
      }
      ((oidb_cmd0xed3.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString2).longValue());
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xed3", 3795, 1, ((oidb_cmd0xed3.ReqBody)localObject).toByteArray()));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendDoubleClickReq() called with: toUin = [");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], friendUin = [");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], uinType = [");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("]");
      QLog.d("PaiYiPaiHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return PaiYiPaiObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0xed3".equals(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xf51".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.paiyipai.PaiYiPaiHandler
 * JD-Core Version:    0.7.0.1
 */