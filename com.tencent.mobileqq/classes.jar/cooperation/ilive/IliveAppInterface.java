package cooperation.ilive;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
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
    QLog.e("IliveAppInterface", 1, "exitBrowserRunTime: receiveAction: " + paramIntent);
    if (paramIntent.equals("com.tencent.process.exit"))
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      try
      {
        paramContext = paramContext.getRunningTasks(1);
        if ((paramContext != null) && (paramContext.size() >= 1))
        {
          paramContext = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
          if (QLog.isColorLevel()) {
            QLog.d("IliveAppInterface", 2, "runningActivity=" + paramContext);
          }
          if ((paramContext != null) && (paramContext.length() > 0) && ((paramContext.contains("cooperation.ilive.activity")) || (paramContext.contains("com.tencent.ilive.audiencepages.room.AudienceRoomActivity")))) {
            return true;
          }
        }
      }
      catch (SecurityException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = null;
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
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.IliveAppInterface
 * JD-Core Version:    0.7.0.1
 */