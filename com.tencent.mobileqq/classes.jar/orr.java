import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.GetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class orr
  implements BusinessObserver
{
  public orr(KandianMergeManager paramKandianMergeManager) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    mobileqq_mp.GetMessageConfigurationResponse localGetMessageConfigurationResponse;
    if (paramBoolean) {
      localGetMessageConfigurationResponse = new mobileqq_mp.GetMessageConfigurationResponse();
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label253;
        }
        localGetMessageConfigurationResponse.mergeFrom(paramBundle);
        if ((!localGetMessageConfigurationResponse.ret_info.has()) || (!localGetMessageConfigurationResponse.ret_info.ret_code.has())) {
          break label238;
        }
        paramInt = localGetMessageConfigurationResponse.ret_info.ret_code.get();
        if (paramInt != 0) {
          break label206;
        }
        if (!localGetMessageConfigurationResponse.type.has()) {
          break label267;
        }
        paramInt = localGetMessageConfigurationResponse.type.get();
        if (paramInt != 1) {
          break label268;
        }
        paramBoolean = true;
        paramBundle = BaseActivity.sTopActivity;
        if (!bhvy.e(KandianMergeManager.a(this.a)))
        {
          if (!(paramBundle instanceof ReadInJoySettingActivity)) {
            break label195;
          }
          paramBundle = (ReadInJoySettingActivity)paramBundle;
          if (paramBundle.a()) {
            QLog.d("KandianMergeManager", 1, "setting: has set kandian status");
          }
        }
        else
        {
          QLog.d("KandianMergeManager", 1, "result:" + paramInt);
          return;
        }
        this.a.a(paramBoolean);
        paramBundle.a(paramBoolean);
        continue;
        this.a.a(paramBoolean);
      }
      catch (Exception paramBundle)
      {
        QLog.d("KandianMergeManager", 1, "failed to handle request Kandian status configuration");
        return;
      }
      label195:
      continue;
      label206:
      if (QLog.isColorLevel())
      {
        QLog.d("KandianMergeManager", 2, "request Kandian status fail code:" + paramInt);
        return;
        label238:
        if (QLog.isColorLevel())
        {
          QLog.d("KandianMergeManager", 2, "request Kandian status wrong resp");
          return;
          label253:
          if (QLog.isColorLevel()) {
            QLog.d("KandianMergeManager", 2, "request Kandian status fail data null");
          }
        }
      }
      label267:
      return;
      label268:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orr
 * JD-Core Version:    0.7.0.1
 */