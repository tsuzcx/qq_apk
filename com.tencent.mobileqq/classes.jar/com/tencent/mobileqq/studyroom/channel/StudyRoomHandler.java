package com.tencent.mobileqq.studyroom.channel;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.jungle.videohub.proto.CommProtocolProto.commRequest;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.TicketManager;
import tencent.im.troop.studyroom.self_study_room_troop.StudyRoomMemberInfoReq;

public class StudyRoomHandler
  extends BusinessHandler
{
  private Map<Integer, CommProtocolProto.commRequest> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(100);
  
  public StudyRoomHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private CommProtocolProto.commRequest a(int paramInt)
  {
    CommProtocolProto.commRequest localcommRequest = new CommProtocolProto.commRequest();
    localcommRequest.seq.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    localcommRequest.cmd.set(paramInt);
    paramInt = NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication());
    localcommRequest.network.set(paramInt);
    String str = ((TicketManager)this.appRuntime.getManager(2)).getA2(this.appRuntime.getAccount());
    localcommRequest.auth_type.set(8);
    localcommRequest.auth_key.set(ByteStringMicro.copyFromUtf8(str));
    localcommRequest.microtime.set(System.currentTimeMillis());
    return localcommRequest;
  }
  
  private void a(CommProtocolProto.commRequest paramcommRequest, String paramString)
  {
    if (paramcommRequest == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("studyroom.proto", 2, "sendPbRequest. request is null.");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendPbRequest. cmd=");
      localStringBuilder.append(paramcommRequest.cmd.get());
      QLog.d("studyroom.proto", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf((int)paramcommRequest.seq.get()), paramcommRequest);
    paramString = createToServiceMsg(paramString);
    paramString.putWupBuffer(paramcommRequest.toByteArray());
    paramString.extraData.putInt("extra_seq", (int)paramcommRequest.seq.get());
    paramString.extraData.putLong("extra_start_time", System.currentTimeMillis());
    super.sendPbReq(paramString);
  }
  
  public void a(String paramString)
  {
    self_study_room_troop.StudyRoomMemberInfoReq localStudyRoomMemberInfoReq = new self_study_room_troop.StudyRoomMemberInfoReq();
    localStudyRoomMemberInfoReq.troop_uin.set(paramString);
    paramString = a(17101);
    paramString.body.set(ByteStringMicro.copyFrom(localStudyRoomMemberInfoReq.toByteArray()));
    a(paramString, "SelfStudyRoomForQQ.17101");
  }
  
  public Set<String> getCommandList()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(Integer.toString(17101));
    return localHashSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return StudyRoomObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = paramFromServiceMsg.getServiceCmd();
    int i = paramToServiceMsg.extraData.getInt("extra_seq");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("StudyRoomHandler onReceive. cmd=");
      paramToServiceMsg.append(paramObject);
      paramToServiceMsg.append(" seq:");
      paramToServiceMsg.append(i);
      QLog.d("studyroom.proto", 2, paramToServiceMsg.toString());
    }
    paramToServiceMsg = (CommProtocolProto.commRequest)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
    if (paramToServiceMsg == null)
    {
      QLog.w("studyroom.proto", 1, "can't find request");
      return;
    }
    if ("SelfStudyRoomForQQ.17101".equals(paramObject)) {
      notifyUI(1, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.channel.StudyRoomHandler
 * JD-Core Version:    0.7.0.1
 */