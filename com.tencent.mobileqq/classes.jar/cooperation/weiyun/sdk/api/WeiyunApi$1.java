package cooperation.weiyun.sdk.api;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.weiyun.utils.PreferenceUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

final class WeiyunApi$1
  implements Runnable
{
  WeiyunApi$1(Context paramContext) {}
  
  public void run()
  {
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    boolean bool1 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_queried", false);
    boolean bool2 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_has", false);
    boolean bool3 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_verified", false);
    WeiyunApi.a()[0].set(bool1);
    WeiyunApi.a()[1].set(bool2);
    WeiyunApi.a()[2].set(bool3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.api.WeiyunApi.1
 * JD-Core Version:    0.7.0.1
 */