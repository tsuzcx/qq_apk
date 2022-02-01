import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.ipc.AVGameBroadcastReceiver;
import com.tencent.avgame.ipc.AccountReceiver;
import com.tencent.avgame.ipc.ExitReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class nfg
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AccountReceiver jdField_a_of_type_ComTencentAvgameIpcAccountReceiver;
  private ExitReceiver jdField_a_of_type_ComTencentAvgameIpcExitReceiver;
  private final WeakReference<AppRuntime> jdField_a_of_type_MqqUtilWeakReference;
  
  public nfg(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
  }
  
  private void a(nff paramnff, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = new AccountReceiver(paramnff, paramString);
    paramnff = new IntentFilter();
    String[] arrayOfString = this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver.a();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (!TextUtils.isEmpty(str)) {
        paramnff.addAction(str);
      }
      i += 1;
    }
    try
    {
      paramnff = BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver, paramnff, "com.tencent.msg.permission.pushnotify", null);
      if (paramnff == null) {
        this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = null;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BroadcastCenter", 2, "registerAccountReceiver, packageName[" + paramString + "], intent[" + paramnff + "]");
      }
      return;
    }
    catch (Throwable paramnff)
    {
      QLog.i("BroadcastCenter", 1, "register2", paramnff);
    }
  }
  
  public void a()
  {
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    CharSequence localCharSequence = null;
    AVGameBroadcastReceiver localAVGameBroadcastReceiver = new AVGameBroadcastReceiver(localAppRuntime);
    String[] arrayOfString = localAVGameBroadcastReceiver.a();
    Object localObject1 = localCharSequence;
    int j;
    int i;
    if (arrayOfString != null)
    {
      localObject1 = localCharSequence;
      if (arrayOfString.length > 0)
      {
        localObject1 = new IntentFilter();
        j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          localCharSequence = arrayOfString[i];
          if (!TextUtils.isEmpty(localCharSequence)) {
            ((IntentFilter)localObject1).addAction(localCharSequence);
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = localAVGameBroadcastReceiver;
      }
    }
    if ((this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) && (localObject1 != null)) {
      try
      {
        BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder(100);
          ((StringBuilder)localObject1).append("register, actions[");
          j = arrayOfString.length;
          i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject1).append(arrayOfString[i]).append(",");
            i += 1;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          QLog.i("BroadcastCenter", 1, "register", localThrowable1);
        }
        localThrowable1.append("]");
        QLog.i("BroadcastCenter", 2, localThrowable1.toString());
      }
    }
    Object localObject2;
    if ((localAppRuntime instanceof AVGameAppInterface))
    {
      localObject2 = (AVGameAppInterface)localAppRuntime;
      a((nff)localObject2, ((AVGameAppInterface)localObject2).getApp().getPackageName());
    }
    if ((this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver == null) && ((localAppRuntime instanceof AppInterface)))
    {
      this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver = new ExitReceiver((AppInterface)localAppRuntime);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("com.tencent.process.exit");
    }
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver, (IntentFilter)localObject2);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.i("BroadcastCenter", 1, "register", localThrowable2);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver == null) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver);
        this.jdField_a_of_type_ComTencentAvgameIpcAccountReceiver = null;
        if (this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver != null) {}
        try
        {
          BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver);
          this.jdField_a_of_type_ComTencentAvgameIpcExitReceiver = null;
          return;
        }
        catch (Throwable localThrowable3)
        {
          QLog.i("BroadcastCenter", 1, "unregister2", localThrowable3);
        }
        localThrowable1 = localThrowable1;
        QLog.i("BroadcastCenter", 1, "unregister", localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          QLog.i("BroadcastCenter", 1, "unregister2", localThrowable2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nfg
 * JD-Core Version:    0.7.0.1
 */