package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public abstract class TroopBindPubAccountProtocol$FollowPublicAccountObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt == 0)
    {
      mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
      try
      {
        localFollowResponse.mergeFrom(paramArrayOfByte);
        bool1 = bool2;
        if (!((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.has()) {
          break label152;
        }
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        bool1 = bool2;
        if (paramInt != 0) {
          break label152;
        }
        bool1 = true;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break label152;
        }
      }
      QLog.i("TroopBindPubAccountProtocol", 2, paramArrayOfByte.toString());
      bool1 = bool2;
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("follow pubAccount failed, errorCode=");
        paramArrayOfByte.append(paramInt);
        QLog.i("TroopBindPubAccountProtocol", 2, paramArrayOfByte.toString());
        bool1 = bool2;
      }
    }
    label152:
    a(bool1, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.FollowPublicAccountObserver
 * JD-Core Version:    0.7.0.1
 */