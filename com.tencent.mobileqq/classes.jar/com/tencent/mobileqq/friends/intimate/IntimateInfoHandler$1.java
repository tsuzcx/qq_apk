package com.tencent.mobileqq.friends.intimate;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class IntimateInfoHandler$1
  extends ProtoUtils.TroopProtocolObserver
{
  IntimateInfoHandler$1(IntimateInfoHandler paramIntimateInfoHandler) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("sendFriendRelationRedpointClickEvent, errorCode: %d", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimateInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */