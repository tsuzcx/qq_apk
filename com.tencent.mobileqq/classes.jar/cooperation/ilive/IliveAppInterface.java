package cooperation.ilive;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.falco.base.floatwindow.widget.LiveFloatWindowManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.IToolProcEventListener;

public class IliveAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  private static long jdField_a_of_type_Long = -1L;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  
  public IliveAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  private boolean a(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitBrowserRunTime: receiveAction: ");
    localStringBuilder.append(paramIntent);
    QLog.e("IliveAppInterface", 1, localStringBuilder.toString());
    if (paramIntent.equals("com.tencent.process.exit"))
    {
      paramIntent = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = null;
      try
      {
        paramIntent = paramIntent.getRunningTasks(1);
        paramContext = paramIntent;
      }
      catch (SecurityException paramIntent)
      {
        paramIntent.printStackTrace();
      }
      if ((paramContext != null) && (paramContext.size() >= 1))
      {
        paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
        boolean bool = LiveFloatWindowManager.getInstance().appFloatIsShow("FloatWindowComponentImpl");
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("runningActivity = ");
          paramIntent.append(paramContext);
          paramIntent.append(" isFloatWindowShow = ");
          paramIntent.append(bool);
          QLog.d("IliveAppInterface", 2, paramIntent.toString());
        }
        if ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("cooperation.ilive.activity")) || (paramContext.contains("com.tencent.ilive.audiencepages.room.AudienceRoomActivity")) || (paramContext.contains("com.tencent.ilive.audiencepages.room.MultiAudienceRoomActivity")) || (bool))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.a == null) {
      this.a = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.a;
  }
  
  public void onBeforeExitProc()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IliveAppInterface", 2, "onBeforeExitProc");
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IliveAppInterface", 2, "onReceiveAccountAction");
    }
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IliveAppInterface", 2, "onReceiveLegalExitProcAction");
    }
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.IliveAppInterface
 * JD-Core Version:    0.7.0.1
 */