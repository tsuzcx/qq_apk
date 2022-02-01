package cooperation.ilive;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import arnz;
import aroa;
import bdll;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.IToolProcEventListener;

public class IliveAppInterface
  extends AppInterface
  implements IToolProcEventListener
{
  private static long jdField_a_of_type_Long = -1L;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  
  public IliveAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("IliveAppInterface", 2, "onReceiveExitAction");
    }
    long l = System.currentTimeMillis();
    int i = aroa.c().b();
    return (jdField_a_of_type_Long != -1L) && (l - jdField_a_of_type_Long < i * 60 * 1000);
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
          if ((paramContext != null) && (paramContext.length() > 0) && (paramContext.contains("cooperation.ilive.activity"))) {
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
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
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
  
  public void reportClickEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    bdll.b(null, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramString6, paramString7, paramString8, paramString9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.IliveAppInterface
 * JD-Core Version:    0.7.0.1
 */