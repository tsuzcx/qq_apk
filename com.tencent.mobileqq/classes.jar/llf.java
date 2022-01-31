import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class llf
  implements BusinessObserver
{
  public llf(ThirdVideoManager paramThirdVideoManager, NewIntent paramNewIntent, long paramLong, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback, String paramString1, String paramString2, AppRuntime paramAppRuntime) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    ThreadManager.post(new llg(this, paramBoolean, paramBundle), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llf
 * JD-Core Version:    0.7.0.1
 */