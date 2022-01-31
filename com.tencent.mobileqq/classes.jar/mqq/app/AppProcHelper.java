package mqq.app;

import android.content.Context;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;

public class AppProcHelper
{
  public static final String ACTION_PROCESS_EXIT = "com.tencent.process.exit";
  
  public static String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
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
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public static boolean isContainsProc(Context paramContext, ArrayList<String> paramArrayList)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayList.size()) {
        break;
      }
      if ((MobileQQ.processName != null) && (MobileQQ.processName.equals(paramArrayList.get(i)))) {
        return true;
      }
      i += 1;
    }
  }
  
  public static boolean isLegalBroadcast(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(getLocalVerify(paramArrayList, false))) && (!paramString.equals(getLocalVerify(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AppProcHelper
 * JD-Core Version:    0.7.0.1
 */