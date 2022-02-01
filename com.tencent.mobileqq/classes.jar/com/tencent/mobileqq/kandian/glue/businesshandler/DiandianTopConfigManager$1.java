package com.tencent.mobileqq.kandian.glue.businesshandler;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.oidb_0xb7e.RspBody;

class DiandianTopConfigManager$1
  extends ProtoUtils.AppProtocolObserver
{
  DiandianTopConfigManager$1(DiandianTopConfigManager paramDiandianTopConfigManager, boolean paramBoolean) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    try
    {
      paramBundle = new oidb_0xb7e.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      boolean bool = paramBundle.rpt_top_item.has();
      if (bool)
      {
        List localList = paramBundle.rpt_top_item.get();
        if ((localList != null) && (localList.size() > 0))
        {
          DiandianTopConfigManager.a(this.c, paramArrayOfByte, System.currentTimeMillis());
          if (!this.b) {
            break label208;
          }
          DiandianTopConfigManager.a(this.c, paramBundle);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig rpt_top_item is empty");
        }
        ReadInJoyLogicEngineEventDispatcher.a().a(true, null);
        DiandianTopConfigManager.a(this.c, paramArrayOfByte, 0L);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig rpt_top_item is empty");
      }
      DiandianTopConfigManager.a(this.c, paramArrayOfByte, 0L);
      ReadInJoyLogicEngineEventDispatcher.a().a(true, null);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label152:
      label208:
      break label152;
    }
    if (QLog.isColorLevel())
    {
      QLog.e(DiandianTopConfigManager.a, 2, "requestDiandianTopConfig parser failed");
      return;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = DiandianTopConfigManager.a;
        paramBundle = new StringBuilder();
        paramBundle.append("requestDiandianTopConfig failed errorCode = ");
        paramBundle.append(paramInt);
        QLog.e(paramArrayOfByte, 2, paramBundle.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.DiandianTopConfigManager.1
 * JD-Core Version:    0.7.0.1
 */