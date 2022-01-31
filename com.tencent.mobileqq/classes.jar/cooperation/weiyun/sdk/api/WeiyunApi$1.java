package cooperation.weiyun.sdk.api;

import android.content.Context;
import bifi;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class WeiyunApi$1
  implements Runnable
{
  public WeiyunApi$1(Context paramContext) {}
  
  public void run()
  {
    long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    boolean bool1 = bifi.a(this.a, String.valueOf(l), "key_pwd_queried", false);
    boolean bool2 = bifi.a(this.a, String.valueOf(l), "key_pwd_has", false);
    boolean bool3 = bifi.a(this.a, String.valueOf(l), "key_pwd_verified", false);
    bidq.a()[0].set(bool1);
    bidq.a()[1].set(bool2);
    bidq.a()[2].set(bool3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.sdk.api.WeiyunApi.1
 * JD-Core Version:    0.7.0.1
 */