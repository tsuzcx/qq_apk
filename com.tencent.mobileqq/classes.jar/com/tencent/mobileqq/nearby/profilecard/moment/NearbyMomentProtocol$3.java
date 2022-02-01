package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.qphone.base.util.QLog;

final class NearbyMomentProtocol$3
  implements CsTask.OnCsError
{
  NearbyMomentProtocol$3(NearbyMomentProtocol.DeleteFeedCallback paramDeleteFeedCallback, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("deleteMomentFeed error, errorCode =");
    paramArrayOfByte.append(paramInt);
    QLog.i("NearbyMomentProtocol", 1, paramArrayOfByte.toString());
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(false, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.3
 * JD-Core Version:    0.7.0.1
 */