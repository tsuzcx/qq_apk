import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import com.tencent.av.core.SDKConfigInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

public class llr
{
  private final SDKConfigInfo a = new SDKConfigInfo(null);
  
  public llr()
  {
    int i = Process.myPid();
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if (localRunningAppProcessInfo.pid == i) {
        SDKConfigInfo.access$102(this.a, localRunningAppProcessInfo.processName);
      }
    }
    lcg.a("SDKConfigInfo", this.a.toString());
  }
  
  public SDKConfigInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     llr
 * JD-Core Version:    0.7.0.1
 */