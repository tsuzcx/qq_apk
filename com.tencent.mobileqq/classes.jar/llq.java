import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyMsgManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.observer.BusinessObserver;

public class llq
  implements BusinessObserver
{
  public llq(KandianMergeManager paramKandianMergeManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    mobileqq_mp.GetMessageConfigurationResponse localGetMessageConfigurationResponse;
    if (paramBoolean) {
      localGetMessageConfigurationResponse = new mobileqq_mp.GetMessageConfigurationResponse();
    }
    label263:
    label295:
    label310:
    label324:
    label325:
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label310;
        }
        localGetMessageConfigurationResponse.mergeFrom(paramBundle);
        if ((!localGetMessageConfigurationResponse.ret_info.has()) || (!localGetMessageConfigurationResponse.ret_info.ret_code.has())) {
          break label295;
        }
        paramInt = localGetMessageConfigurationResponse.ret_info.ret_code.get();
        if (paramInt != 0) {
          break label263;
        }
        if (!localGetMessageConfigurationResponse.type.has()) {
          break label324;
        }
        paramInt = localGetMessageConfigurationResponse.type.get();
        if (paramInt != 1) {
          break label325;
        }
        paramBoolean = true;
        paramBundle = BaseActivity.sTopActivity;
        if (ReadInJoyHelper.f(KandianMergeManager.a(this.a))) {
          break label206;
        }
        if ((paramBundle instanceof ReadInJoySettingActivity))
        {
          paramBundle = (ReadInJoySettingActivity)paramBundle;
          if (paramBundle.a())
          {
            QLog.d("KandianMergeManager", 1, "setting: has set kandian status");
            QLog.d("KandianMergeManager", 1, "result:" + paramInt);
            return;
          }
          this.a.a(paramBoolean);
          paramBundle.a(paramBoolean);
          continue;
        }
        this.a.a(paramBoolean);
      }
      catch (Exception paramBundle)
      {
        QLog.d("KandianMergeManager", 1, "failed to handle request Kandian status configuration");
        return;
      }
      continue;
      label206:
      if ((paramBundle instanceof ReadinjoyMsgManagerActivity))
      {
        paramBundle = (ReadinjoyMsgManagerActivity)paramBundle;
        if (paramBundle.a())
        {
          QLog.d("KandianMergeManager", 1, "msg manage: has set kandian status");
        }
        else
        {
          this.a.a(paramBoolean);
          paramBundle.a(paramBoolean);
        }
      }
      else
      {
        this.a.a(paramBoolean);
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("KandianMergeManager", 2, "request Kandian status fail code:" + paramInt);
          return;
          if (QLog.isColorLevel())
          {
            QLog.d("KandianMergeManager", 2, "request Kandian status wrong resp");
            return;
            if (QLog.isColorLevel()) {
              QLog.d("KandianMergeManager", 2, "request Kandian status fail data null");
            }
          }
        }
        return;
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llq
 * JD-Core Version:    0.7.0.1
 */