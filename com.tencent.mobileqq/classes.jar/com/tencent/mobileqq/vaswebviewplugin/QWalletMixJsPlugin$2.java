package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AcsBatchSubNoticeRsp;
import Wallet.AcsMsg;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class QWalletMixJsPlugin$2
  implements BusinessObserver
{
  QWalletMixJsPlugin$2(QWalletMixJsPlugin paramQWalletMixJsPlugin) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2007) && (paramBoolean)) {}
    try
    {
      paramBundle = (AcsBatchSubNoticeRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null)
      {
        localObject = QWalletMixJsPlugin.access$000();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("batchSubscribeNotify#onReceive, rsp retCode:");
        localStringBuilder.append(paramBundle.ret_code);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        localObject = new JSONObject();
        ((JSONObject)localObject).put("retcode", paramBundle.ret_code);
        ((JSONObject)localObject).put("retmsg", paramBundle.err_str);
        ((JSONObject)localObject).put("success_count", paramBundle.succeed_count);
        ((JSONObject)localObject).put("retry_msgs", paramBundle.retry_msgs);
        QWalletMixJsPlugin.access$300(this.this$0, ((JSONObject)localObject).toString());
      }
      Object localObject = paramBundle.msgs;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        paramBundle = (IQQReminderDataService)QWalletMixJsPlugin.access$400(this.this$0).getRuntimeService(IQQReminderDataService.class, "");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramBundle.doNotifyByPush((AcsMsg)((Iterator)localObject).next());
          continue;
          QLog.i(QWalletMixJsPlugin.access$000(), 2, "batchSubscribeNotify#onReceive, not success");
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      QLog.e(QWalletMixJsPlugin.access$000(), 1, "batchSubscribeNotify#onReceive", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */