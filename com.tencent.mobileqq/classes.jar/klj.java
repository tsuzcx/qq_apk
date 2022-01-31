import android.os.Bundle;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public final class klj
  implements BusinessObserver
{
  public klj(NewIntent paramNewIntent, AsyncBack paramAsyncBack, boolean paramBoolean1, boolean paramBoolean2, AppRuntime paramAppRuntime, boolean paramBoolean3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel()) {
      QLog.d("HtmlCheckUpdate", 2, "-->offline:checkUpdate,onReceive:isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          return;
        }
        OfflinePkg.RspBody localRspBody = new OfflinePkg.RspBody();
        localRspBody.mergeFrom(paramBundle);
        paramBundle = new String(localRspBody.str_offline_pkg.get().toByteArray(), "UTF-8");
        if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
          this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a(paramBundle, 0);
        }
        if (!this.jdField_a_of_type_Boolean) {
          return;
        }
        if (this.b)
        {
          HtmlOffline.c(paramBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.c, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack);
          return;
        }
        HtmlOffline.c(paramBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.c, null);
        return;
      }
      catch (Exception paramBundle)
      {
        this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a("{\"r\":-1}", 2);
        return;
      }
    } else if (this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack != null) {
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncBack.a("{\"r\":-1}", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klj
 * JD-Core Version:    0.7.0.1
 */