package com.tencent.mobileqq.mini.appbrand.utils;

import Wallet.GetMiniAppRsp;
import android.os.Bundle;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.observer.BusinessObserver;

final class MiniLogManager$6
  implements BusinessObserver
{
  MiniLogManager$6(String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetMiniAppRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle != null) && (!StringUtil.a(paramBundle.extra)))
    {
      paramBundle = paramBundle.extra;
      MiniLogManager.access$800(paramBundle, this.val$filePath);
      if (QLog.isDebugVersion())
      {
        String str = MiniLogManager.access$100();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" action:");
        localStringBuilder.append(this.val$action);
        localStringBuilder.append(" logUrl:");
        localStringBuilder.append(paramBundle);
        localStringBuilder.append(" filePath:");
        localStringBuilder.append(this.val$filePath);
        QLog.d(str, 4, localStringBuilder.toString());
      }
    }
    else
    {
      new File(this.val$filePath).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.6
 * JD-Core Version:    0.7.0.1
 */