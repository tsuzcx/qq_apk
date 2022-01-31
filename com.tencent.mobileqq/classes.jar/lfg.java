import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

public class lfg
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new lfh(this);
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public lfg(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private String a(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          paramContext = localRunningAppProcessInfo.processName;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label142;
      }
    }
    label142:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(a(paramArrayList, false))) && (!paramString.equals(a(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  private boolean a(ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool1 = true;
    }
    String str;
    do
    {
      return bool1;
      str = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication());
      bool1 = bool2;
    } while (TextUtils.isEmpty(str));
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if (str.equals(paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GKillProcessMonitor", 2, "regist QQ Process Exit Receiver");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfg
 * JD-Core Version:    0.7.0.1
 */