package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.os.Bundle;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import mqq.observer.BusinessObserver;
import tencent.im.qqwallet.GetRecommendWords.GetDefaultCopywriterRsp;

final class GetRecommendWordUtils$1
  implements BusinessObserver
{
  GetRecommendWordUtils$1(int paramInt, long paramLong, GetRecommendWordUtils.GetRandomWordsListener paramGetRandomWordsListener) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    GetRecommendWordUtils.c().remove(Integer.valueOf(this.a));
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive:type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",bundle:");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(",cost:");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTimeMillis() - this.b);
      QLog.d("GetRandomRecommendWordUtils", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = paramBundle.getByteArray("data");
      if ((localObject != null) && (localObject.length > 0) && (paramBoolean))
      {
        paramBundle = new GetRecommendWords.GetDefaultCopywriterRsp();
        paramBundle.mergeFrom((byte[])localObject);
        paramInt = paramBundle.code.get();
        localObject = paramBundle.message.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("retCode:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(",message:");
          localStringBuilder.append((String)localObject);
          QLog.d("GetRandomRecommendWordUtils", 2, localStringBuilder.toString());
        }
        if (paramInt == 0)
        {
          localObject = new GetRecommendWordUtils.RspRecommendInfo();
          ((GetRecommendWordUtils.RspRecommendInfo)localObject).a = paramBundle.copywriter.get();
          ((GetRecommendWordUtils.RspRecommendInfo)localObject).b = NetConnInfoCenter.getServerTimeMillis();
          if (this.c != null) {
            this.c.a(true, this.a, (GetRecommendWordUtils.RspRecommendInfo)localObject);
          }
        }
        else if (this.c != null)
        {
          this.c.a(false, 0, null);
          return;
        }
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive fail exception:");
      ((StringBuilder)localObject).append(paramBundle.getMessage());
      QLog.e("GetRandomRecommendWordUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.GetRecommendWordUtils.1
 * JD-Core Version:    0.7.0.1
 */