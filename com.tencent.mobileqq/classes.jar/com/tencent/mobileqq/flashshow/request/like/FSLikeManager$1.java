package com.tencent.mobileqq.flashshow.request.like;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;

final class FSLikeManager$1
  implements Call.OnRspCallBack
{
  FSLikeManager$1(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, Object paramObject1, Object paramObject2, Bundle paramBundle)
  {
    if (paramObject2 == null) {
      return;
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.a)
      {
        QLog.d(FSLikeManager.a(), 1, "doLike success");
        return;
      }
      QLog.d(FSLikeManager.a(), 1, "doUnLike success");
      return;
    }
    if (this.a)
    {
      paramObject1 = FSLikeManager.a();
      paramObject2 = new StringBuilder();
      paramObject2.append("doLike failed, retCode:");
      paramObject2.append(paramLong);
      paramObject2.append(", msg:");
      paramObject2.append(paramString);
      QLog.d(paramObject1, 1, paramObject2.toString());
      return;
    }
    paramObject1 = FSLikeManager.a();
    paramObject2 = new StringBuilder();
    paramObject2.append("doUnLike failed, retCode:");
    paramObject2.append(paramLong);
    paramObject2.append(", msg:");
    paramObject2.append(paramString);
    QLog.d(paramObject1, 1, paramObject2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.like.FSLikeManager.1
 * JD-Core Version:    0.7.0.1
 */