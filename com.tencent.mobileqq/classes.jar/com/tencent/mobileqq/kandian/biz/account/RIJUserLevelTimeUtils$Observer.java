package com.tencent.mobileqq.kandian.biz.account;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class RIJUserLevelTimeUtils$Observer
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("observer ,errorCode=");
    paramArrayOfByte.append(paramInt);
    paramArrayOfByte.append(" ，bundle=");
    paramArrayOfByte.append(paramBundle);
    QLog.d("RIJUserLevelTimeUtils", 1, paramArrayOfByte.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.RIJUserLevelTimeUtils.Observer
 * JD-Core Version:    0.7.0.1
 */