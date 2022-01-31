package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ToolProcReceiver
  extends BroadcastReceiver
{
  AppRuntime mRt;
  boolean registered;
  
  public String[] getModularReceiveActions()
  {
    return new String[] { "mqq.intent.action.ACCOUNT_KICKED", "mqq.intent.action.EXIT_" + MobileQQ.getContext().getPackageName(), "mqq.intent.action.ACCOUNT_CHANGED", "mqq.intent.action.ACCOUNT_EXPIRED", "mqq.intent.action.LOGOUT", "com.tencent.process.exit" };
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    boolean bool2;
    boolean bool1;
    Object localObject;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      bool2 = false;
      bool1 = false;
      if (!"com.tencent.process.exit".equals(str)) {
        break label240;
      }
      localObject = paramIntent.getExtras();
      if (localObject != null) {
        break label37;
      }
    }
    label37:
    label240:
    do
    {
      return;
      ArrayList localArrayList = ((Bundle)localObject).getStringArrayList("procNameList");
      if ((AppProcHelper.isLegalBroadcast(((Bundle)localObject).getString("verify"), localArrayList)) && (AppProcHelper.isContainsProc(paramContext, localArrayList)))
      {
        paramContext = this.mRt.subRuntimeMap.values().iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!paramContext.hasNext()) {
            break;
          }
          localObject = (AppRuntime)paramContext.next();
          if (((localObject instanceof IToolProcEventListener)) && (((IToolProcEventListener)localObject).onReceiveLegalExitProcAction(paramIntent)))
          {
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("mqq", 2, "notKillBy(LegalExit) " + ((AppRuntime)localObject).getModuleId());
              bool1 = bool2;
            }
          }
        }
      }
      bool2 = true;
      if (!bool2)
      {
        paramContext = this.mRt.subRuntimeMap.values().iterator();
        while (paramContext.hasNext())
        {
          paramIntent = (AppRuntime)paramContext.next();
          if ((paramIntent instanceof IToolProcEventListener))
          {
            ((IToolProcEventListener)paramIntent).onBeforeExitProc();
            continue;
            paramContext = this.mRt.subRuntimeMap.values().iterator();
            bool1 = bool2;
            for (;;)
            {
              bool2 = bool1;
              if (!paramContext.hasNext()) {
                break;
              }
              localObject = (AppRuntime)paramContext.next();
              if (((localObject instanceof IToolProcEventListener)) && (((IToolProcEventListener)localObject).onReceiveAccountAction(str, paramIntent)))
              {
                bool2 = true;
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.d("mqq", 2, "notKillBy(Account) " + ((AppRuntime)localObject).getModuleId());
                  bool1 = bool2;
                }
              }
            }
          }
        }
        this.mRt.exitToolProc();
      }
    } while (!QLog.isColorLevel());
    QLog.d("mqq", 2, "ToolProcReceiver " + str + "." + bool2);
  }
  
  void register()
  {
    if (this.registered) {}
    do
    {
      return;
      try
      {
        IntentFilter localIntentFilter = new IntentFilter();
        String[] arrayOfString = getModularReceiveActions();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localIntentFilter.addAction(arrayOfString[i]);
          i += 1;
        }
        MobileQQ.getContext().registerReceiver(this, localIntentFilter);
        this.registered = true;
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    localThrowable.printStackTrace();
  }
  
  void unRegister()
  {
    try
    {
      if (this.registered) {
        MobileQQ.getContext().unregisterReceiver(this);
      }
      this.registered = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.ToolProcReceiver
 * JD-Core Version:    0.7.0.1
 */