import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.os.Process;
import com.tencent.av.core.SDKConfigInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class llf
{
  private final SDKConfigInfo a = new SDKConfigInfo(null);
  
  public llf()
  {
    int i = Process.myPid();
    Object localObject = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        SDKConfigInfo.access$102(this.a, localRunningAppProcessInfo.processName);
      }
    }
    if (SDKConfigInfo.access$100(this.a).endsWith("avgame"))
    {
      localObject = this.a;
      SDKConfigInfo.access$202((SDKConfigInfo)localObject, SDKConfigInfo.access$200((SDKConfigInfo)localObject) + "_avgame");
    }
    QLog.i("SDKConfigInfo", 1, "SDKConfigInfo, info[" + this.a.toString() + "]");
  }
  
  public SDKConfigInfo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llf
 * JD-Core Version:    0.7.0.1
 */