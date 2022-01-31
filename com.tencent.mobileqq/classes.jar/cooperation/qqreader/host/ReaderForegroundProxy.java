package cooperation.qqreader.host;

import android.content.Context;
import bjbl;
import bjbm;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import mqq.app.Foreground;

public class ReaderForegroundProxy
{
  protected AppRuntime mRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
  
  public void onCreate()
  {
    Foreground.updateRuntimeState(this.mRuntime);
  }
  
  public void onDestroy(Context paramContext)
  {
    Foreground.onDestroy(bjbm.a(paramContext));
  }
  
  public void onPause()
  {
    Foreground.onPause(this.mRuntime);
  }
  
  public void onResume()
  {
    Foreground.onResume(this.mRuntime);
  }
  
  public void onStart(Context paramContext)
  {
    bjbl.e("ReaderForegroundProxy", "onStart context = " + paramContext);
    Foreground.onStart(this.mRuntime, bjbm.a(paramContext));
  }
  
  public void onStop()
  {
    Foreground.onStop(this.mRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.ReaderForegroundProxy
 * JD-Core Version:    0.7.0.1
 */