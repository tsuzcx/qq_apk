package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x829.oidb_0x829.AddFrdInfo;
import tencent.im.oidb.cmd0x829.oidb_0x829.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class AddBatchPhoneFriendReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public AddBatchPhoneFriendReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, paramFriendHandler);
  }
  
  public static oidb_sso.OIDBSSOPkg c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        return null;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AddBatchPhoneFriendReceiver", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
    }
    if ((paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
      return paramToServiceMsg;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() ");
      paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
      QLog.d("AddBatchPhoneFriendReceiver", 2, paramFromServiceMsg.toString());
    }
    return null;
  }
  
  @NotNull
  public String a()
  {
    return "OidbSvc.0x829_1";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.handleBatchAddPhoneFriend sso resp: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", data: ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("AddBatchPhoneFriendReceiver", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject = new oidb_0x829.RspBody();
    ArrayList localArrayList1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("phones");
    int j = Integer.valueOf(paramToServiceMsg.extraData.getInt("package", -1)).intValue();
    ArrayList localArrayList2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("resultList");
    String str = paramToServiceMsg.extraData.getString("verifyMsg");
    int k = Integer.valueOf(paramToServiceMsg.extraData.getInt("sourceId")).intValue();
    int m = j * 30;
    boolean bool2;
    if (bool1)
    {
      paramToServiceMsg = c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (paramToServiceMsg != null)
      {
        int n = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("FriendListHandler.handleBatchAddPhoneFriend oidb result code: ");
          paramFromServiceMsg.append(n);
          QLog.d("AddBatchPhoneFriendReceiver", 2, paramFromServiceMsg.toString());
        }
        if (n == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if (bool1) {
          try
          {
            ((oidb_0x829.RspBody)localObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            bool2 = bool1;
          }
          catch (Exception paramToServiceMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AddBatchPhoneFriendReceiver", 2, "FriendListHandler.handleBatchAddPhoneFriend RspBody mergeFrom failed.");
            }
            paramToServiceMsg.printStackTrace();
          }
        }
      }
      else
      {
        bool2 = false;
      }
    }
    else
    {
      bool2 = bool1;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("FriendListHandler.handleBatchAddPhoneFriend isSuccess: ");
      paramToServiceMsg.append(bool2);
      QLog.d("AddBatchPhoneFriendReceiver", 2, paramToServiceMsg.toString());
    }
    if (bool2)
    {
      if (((oidb_0x829.RspBody)localObject).rpt_add_frd_info.has()) {
        while (i < ((oidb_0x829.RspBody)localObject).rpt_add_frd_info.size())
        {
          paramToServiceMsg = (oidb_0x829.AddFrdInfo)((oidb_0x829.RspBody)localObject).rpt_add_frd_info.get(i);
          paramFromServiceMsg = new AddBatchPhoneFriendResult();
          paramFromServiceMsg.mobile = paramToServiceMsg.bytes_mobile.get().toStringUtf8();
          paramFromServiceMsg.remark = paramToServiceMsg.bytes_remark.get().toStringUtf8();
          paramFromServiceMsg.allowType = paramToServiceMsg.uint32_allow_type.get();
          paramFromServiceMsg.sendReqFlag = paramToServiceMsg.uint32_send_req_flag.get();
          paramFromServiceMsg.sendResult = paramToServiceMsg.uint32_send_result.get();
          localArrayList2.add(paramFromServiceMsg);
          i += 1;
        }
      }
      if ((j != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (m < localArrayList1.size()))
      {
        b().runOnUiThread(new AddBatchPhoneFriendReceiver.1(this, localArrayList1, str, j, k, localArrayList2));
        return;
      }
      ((FriendHandler)c()).notifyUI(107, true, localArrayList2);
      return;
    }
    if ((j != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (m < localArrayList1.size()))
    {
      b().runOnUiThread(new AddBatchPhoneFriendReceiver.2(this, localArrayList1, str, j, k, localArrayList2));
      return;
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      ((FriendHandler)c()).notifyUI(107, true, localArrayList2);
      return;
    }
    ((FriendHandler)c()).notifyUI(107, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.AddBatchPhoneFriendReceiver
 * JD-Core Version:    0.7.0.1
 */