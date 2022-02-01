package com.tencent.mobileqq.relationx.onewayfriend;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0xe8c.oidb_0xe8c.ReqBody;
import tencent.im.oidb.cmd0xe8c.oidb_0xe8c.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class OneWayFriendHandler
  extends BusinessHandler
{
  public OneWayFriendHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    OneWayFriendResult localOneWayFriendResult = new OneWayFriendResult();
    int i;
    int j;
    label119:
    boolean bool;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label212;
        }
        i = 1;
        if (i == 0) {
          break label165;
        }
        paramFromServiceMsg = new oidb_0xe8c.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        l = paramFromServiceMsg.uint64_friend_uin.get();
        j = paramFromServiceMsg.uint32_flag.get();
        if ((j & 0x1) == 0) {
          break label218;
        }
        i = 1;
      }
      catch (Exception paramToServiceMsg)
      {
        long l;
        QLog.e("OneWayFriendHandler", 1, "handleGetOneWayFriendFlag fail.", paramToServiceMsg);
      }
      localOneWayFriendResult.jdField_a_of_type_Long = l;
      if ((i != 0) || (j == 0)) {
        break label240;
      }
      bool = true;
    }
    for (;;)
    {
      localOneWayFriendResult.jdField_a_of_type_Boolean = bool;
      bool = true;
      break label168;
      label165:
      bool = false;
      label168:
      if (QLog.isColorLevel()) {
        QLog.d("OneWayFriendHandler", 0, String.format("handleGetOneWayFriendFlag success=%s result=%s", new Object[] { Boolean.valueOf(bool), localOneWayFriendResult }));
      }
      notifyUI(1, bool, localOneWayFriendResult);
      return;
      label212:
      i = 0;
      break;
      label218:
      i = 0;
      if ((j & 0x2) != 0)
      {
        j = 1;
        break label119;
      }
      j = 0;
      break label119;
      label240:
      bool = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHandler", 0, String.format("getOneWayFriendFlag friendUin=%s", new Object[] { Long.valueOf(paramLong) }));
    }
    oidb_0xe8c.ReqBody localReqBody = new oidb_0xe8c.ReqBody();
    localReqBody.uint64_friend_uin.set(paramLong);
    sendPbReq(makeOIDBPkg("OidbSvc.0xe8c", 3724, 0, localReqBody.toByteArray()));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return OneWayFriendObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0xe8c".equals(paramToServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHandler
 * JD-Core Version:    0.7.0.1
 */