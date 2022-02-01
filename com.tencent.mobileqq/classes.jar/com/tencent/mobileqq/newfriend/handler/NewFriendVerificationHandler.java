package com.tencent.mobileqq.newfriend.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.observer.NewFriendVerificationObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.im.oidb.cmd0xd7e.oidb_cmd0xd7e.ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.ReqBody;
import tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.RspBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.BlockedInfo;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.ReqBody;
import tencent.im.oidb.cmd0xd83.oidb_cmd0xd83.RspBody;
import tencent.im.oidb.cmd0xd86.oidb_cmd0xd86.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NewFriendVerificationHandler
  extends BusinessHandler
{
  private final NewFriendVerificationServiceImpl a;
  
  public NewFriendVerificationHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.a = ((NewFriendVerificationServiceImpl)paramAppInterface.getRuntimeService(INewFriendVerificationService.class, ""));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedRedPoint");
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      paramToServiceMsg = this.a;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.onClearAddFriendBlockedList(paramFromServiceMsg.isSuccess());
      }
      return;
    }
    paramToServiceMsg = this.a;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onClearAddFriendBlockedList(true);
    }
  }
  
  private static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetAddFriendBlockedRedPoint: req is ");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append("res is ");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append("data is ");
      localStringBuilder.append(paramObject);
      QLog.d("NewFriendVerification.handler", 1, localStringBuilder.toString());
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null) || (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = new oidb_cmd0xd82.RspBody();
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      int i = paramFromServiceMsg.uint32_entrance.get();
      j = paramFromServiceMsg.uint32_redpoint.get();
      paramToServiceMsg = String.valueOf(paramFromServiceMsg.uint64_blocked_uin.get());
      k = paramFromServiceMsg.uint32_unread.get();
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendVerification.handler", 2, String.format("entrance is %s, redPoint is %s, recentBlockFriendUin is %s, unread is %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg, Integer.valueOf(k) }));
      }
      if (this.a == null) {
        break label279;
      }
      paramFromServiceMsg = this.a;
      if (i != 1) {
        break label304;
      }
      bool1 = true;
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        int j;
        int k;
        boolean bool2;
        boolean bool3;
        continue;
        boolean bool1 = false;
        if (j == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        if (k > 0) {
          bool3 = true;
        } else {
          bool3 = false;
        }
      }
    }
    paramFromServiceMsg.onGetAddFriendBlockedRedPoint(true, bool1, bool2, paramToServiceMsg, bool3);
    return;
    paramToServiceMsg = this.a;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onGetAddFriendBlockedRedPoint(true, false, false, "", false);
    }
    label279:
    return;
    paramToServiceMsg = this.a;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onGetAddFriendBlockedRedPoint(true, false, false, "", false);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleGetAddFriendBlockedList");
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      for (;;)
      {
        try
        {
          if (!paramFromServiceMsg.isSuccess()) {
            continue;
          }
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = new oidb_cmd0xd83.RspBody();
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramObject = paramToServiceMsg.rpt_block_list.get();
          paramFromServiceMsg = new ArrayList();
          paramObject = paramObject.iterator();
          if (!paramObject.hasNext()) {
            continue;
          }
          localObject = (oidb_cmd0xd83.BlockedInfo)paramObject.next();
          long l = ((oidb_cmd0xd83.BlockedInfo)localObject).uint64_uin.get();
          localAddFriendBlockedInfo = new AddFriendBlockedInfo();
          localAddFriendBlockedInfo.jdField_a_of_type_JavaLangString = String.valueOf(l);
          localAddFriendBlockedInfo.jdField_b_of_type_JavaLangString = ((oidb_cmd0xd83.BlockedInfo)localObject).bytes_nick.get().toStringUtf8();
          localAddFriendBlockedInfo.jdField_a_of_type_Int = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_age.get();
          localAddFriendBlockedInfo.jdField_b_of_type_Int = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_sex.get();
          if (((oidb_cmd0xd83.BlockedInfo)localObject).uint32_has_read.get() != 1) {
            continue;
          }
          bool = true;
        }
        catch (Exception paramToServiceMsg)
        {
          Object localObject;
          AddFriendBlockedInfo localAddFriendBlockedInfo;
          continue;
          boolean bool = false;
          continue;
        }
        localAddFriendBlockedInfo.jdField_a_of_type_Boolean = bool;
        localAddFriendBlockedInfo.jdField_c_of_type_JavaLangString = ((oidb_cmd0xd83.BlockedInfo)localObject).bytes_source.get().toStringUtf8();
        localAddFriendBlockedInfo.jdField_a_of_type_Long = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_time.get();
        localAddFriendBlockedInfo.jdField_c_of_type_Int = ((oidb_cmd0xd83.BlockedInfo)localObject).uint32_comm_frd.get();
        paramFromServiceMsg.add(localAddFriendBlockedInfo);
        if (QLog.isDebugVersion())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(" handleGetAddFriendBlockedList()--> blockedInfo =  ");
          ((StringBuilder)localObject).append(localAddFriendBlockedInfo.toString());
          QLog.d("NewFriendVerification.handler", 2, ((StringBuilder)localObject).toString());
        }
      }
      paramObject = paramToServiceMsg.bytes_cookies.get().toStringUtf8();
      paramToServiceMsg.uint32_entrance.get();
      if (paramFromServiceMsg.size() > 0) {
        paramToServiceMsg = ((AddFriendBlockedInfo)paramFromServiceMsg.get(0)).jdField_a_of_type_JavaLangString;
      }
      if (this.a != null)
      {
        this.a.onGetAddFriendBlockedList(true, paramFromServiceMsg, paramObject);
        return;
        paramToServiceMsg = this.a;
        if (paramToServiceMsg != null) {
          paramToServiceMsg.onGetAddFriendBlockedList(false, null, "");
        }
      }
      return;
    }
    paramToServiceMsg = this.a;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onGetAddFriendBlockedList(false, null, "");
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.handler", 1, "handleReportAddFriendBlocked");
    }
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      paramToServiceMsg = this.a;
      if (paramToServiceMsg != null) {
        paramToServiceMsg.onReportAddFriendBlocked(paramFromServiceMsg.isSuccess());
      }
      return;
    }
    paramToServiceMsg = this.a;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.onReportAddFriendBlocked(false);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      oidb_cmd0xd7e.ReqBody localReqBody = new oidb_cmd0xd7e.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd7e", 3454, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      label39:
      break label39;
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.onClearAddFriendBlockedList(false);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      oidb_cmd0xd83.ReqBody localReqBody = new oidb_cmd0xd83.ReqBody();
      localReqBody.uint64_uin.set(Long.parseLong(paramString1));
      localReqBody.uint32_req_num.set(paramInt);
      localReqBody.bytes_cookies.set(ByteStringMicro.copyFromUtf8(paramString2));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd83", 3459, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label63:
      break label63;
    }
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.onGetAddFriendBlockedList(false, null, "");
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    try
    {
      oidb_cmd0xd86.ReqBody localReqBody = new oidb_cmd0xd86.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString1));
      localReqBody.blocked_uin.set(Long.parseLong(paramString2));
      localReqBody.source_id.set(paramInt1);
      localReqBody.sub_sourceid.set(paramInt2);
      if (a(paramString3)) {
        localReqBody.group_uin.set(Long.parseLong(paramString3));
      } else {
        localReqBody.group_uin.set(0L);
      }
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd86", 3462, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label106:
      break label106;
    }
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.onReportAddFriendBlocked(false);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      oidb_cmd0xd82.ReqBody localReqBody = new oidb_cmd0xd82.ReqBody();
      localReqBody.uin.set(Long.parseLong(paramString));
      sendPbReq(makeOIDBPkg("OidbSvc.oidb_0xd82", 3458, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString)
    {
      label39:
      break label39;
    }
    paramString = this.a;
    if (paramString != null) {
      paramString.onGetAddFriendBlockedRedPoint(false, false, false, "", false);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.oidb_0xd86");
      this.allowCmdSet.add("OidbSvc.oidb_0xd83");
      this.allowCmdSet.add("OidbSvc.oidb_0xd82");
      this.allowCmdSet.add("OidbSvc.oidb_0xd7e");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return NewFriendVerificationObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.oidb_0xd86".equals(paramFromServiceMsg.getServiceCmd()))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.oidb_0xd83".equals(paramFromServiceMsg.getServiceCmd()))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.oidb_0xd82".equals(paramFromServiceMsg.getServiceCmd()))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.oidb_0xd7e".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.handler.NewFriendVerificationHandler
 * JD-Core Version:    0.7.0.1
 */