import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.biz.AuthorizeConfig.2;
import com.tencent.biz.AuthorizeConfig.2.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListResponse.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class nja
  implements BusinessObserver
{
  public nja(AuthorizeConfig.2 param2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AuthorizeConfig", 2, "onReceive whitelist:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_mp.WebviewWhiteListResponse localWebviewWhiteListResponse = new mobileqq_mp.WebviewWhiteListResponse();
        try
        {
          localWebviewWhiteListResponse.mergeFrom(paramBundle);
          paramInt = localWebviewWhiteListResponse.ret_info.ret_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "sso status code: " + String.valueOf(paramInt));
          }
          if (paramInt == 0)
          {
            ThreadManager.getSubThreadHandler().post(new AuthorizeConfig.2.1.1(this, localWebviewWhiteListResponse));
            bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_success", 0, 1, 0, "", "", "", "");
            return;
          }
          if (paramInt == 304)
          {
            this.a.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
            this.a.this$0.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("lastUpdate", System.currentTimeMillis()).commit();
            this.a.this$0.g();
            this.a.this$0.i();
            bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_not_modify", 0, 1, 0, "", "", "", "");
            return;
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AuthorizeConfig", 2, "update error: " + paramBundle);
          }
        }
      }
    }
    this.a.this$0.g();
    this.a.this$0.i();
    this.a.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "webview_whitelist", "update_failed", 0, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nja
 * JD-Core Version:    0.7.0.1
 */