package cooperation.troop_homework;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HomeworkDpcCfg
{
  private static final String a = DPCNames.homeworkCfg.name();
  private static HomeworkDpcCfg c;
  private int b = 22;
  private DPCObserver d = new HomeworkDpcCfg.1(this);
  
  private HomeworkDpcCfg()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.d);
    b();
  }
  
  public static HomeworkDpcCfg a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new HomeworkDpcCfg();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void b()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(a);
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = str.split("\\|");
      if (arrayOfString.length >= 1) {
        try
        {
          this.b = Integer.valueOf(arrayOfString[0]).intValue();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadConfig exception :");
          localStringBuilder.append(localException.getMessage());
          QLog.d("HomeworkDpcCfg", 1, localStringBuilder.toString());
          this.b = 22;
        }
      }
    }
    else
    {
      this.b = 22;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkDpcCfg", 2, String.format("loadConfig, mUseNewApiLevel: %s, dpc=%s", new Object[] { Integer.valueOf(this.b), str }));
    }
  }
  
  public boolean c()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    QLog.d("HomeworkDpcCfg", 1, String.format("hwUseNewAPI thisVer=%d cfgVer=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.b) }));
    if (Build.VERSION.SDK_INT <= this.b) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.HomeworkDpcCfg
 * JD-Core Version:    0.7.0.1
 */