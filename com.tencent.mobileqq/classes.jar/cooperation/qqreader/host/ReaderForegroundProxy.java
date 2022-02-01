package cooperation.qqreader.host;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.utils.Log;
import mqq.app.AppRuntime;

public class ReaderForegroundProxy
{
  protected AppRuntime mRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  
  public void onCreate() {}
  
  public void onDestroy(Context paramContext) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart(Context paramContext)
  {
    Log.e("ReaderForegroundProxy", "onStart context = " + paramContext);
  }
  
  public void onStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderForegroundProxy
 * JD-Core Version:    0.7.0.1
 */