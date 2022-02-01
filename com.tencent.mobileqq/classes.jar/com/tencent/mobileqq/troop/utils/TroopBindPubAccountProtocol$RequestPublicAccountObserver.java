package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public abstract class TroopBindPubAccountProtocol$RequestPublicAccountObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected abstract void a(boolean paramBoolean, long paramLong, IPublicAccountDetail paramIPublicAccountDetail);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject = null;
    boolean bool2;
    long l1;
    if ((paramInt == 0) && (paramBundle != null))
    {
      long l2 = paramBundle.getLong("uin");
      bool2 = bool4;
      paramBundle = localObject;
      l1 = l2;
      if (paramArrayOfByte != null)
      {
        mobileqq_mp.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        boolean bool1 = bool3;
        try
        {
          localGetPublicAccountDetailInfoResponse.mergeFrom(paramArrayOfByte);
          bool1 = bool3;
          bool2 = bool4;
          paramBundle = localObject;
          l1 = l2;
          if (!((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.has()) {
            break label248;
          }
          bool1 = bool3;
          bool2 = bool4;
          paramBundle = localObject;
          l1 = l2;
          if (((mobileqq_mp.RetInfo)localGetPublicAccountDetailInfoResponse.ret_info.get()).ret_code.get() != 0) {
            break label248;
          }
          bool2 = true;
          bool1 = true;
          paramBundle = ((IPublicAccountDetail)QRoute.api(IPublicAccountDetail.class)).init(localGetPublicAccountDetailInfoResponse);
          l1 = l2;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          bool2 = bool1;
          paramBundle = localObject;
          l1 = l2;
          if (!QLog.isColorLevel()) {
            break label248;
          }
        }
        QLog.i("TroopBindPubAccountProtocol", 2, paramArrayOfByte.toString());
        bool2 = bool1;
        paramBundle = localObject;
        l1 = l2;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("get pubAccountInfo failed, errorCode=");
        paramArrayOfByte.append(paramInt);
        QLog.i("TroopBindPubAccountProtocol", 2, paramArrayOfByte.toString());
      }
      l1 = 0L;
      paramBundle = localObject;
      bool2 = bool4;
    }
    label248:
    a(bool2, l1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */