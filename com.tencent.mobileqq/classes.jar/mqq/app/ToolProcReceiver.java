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
    Object localObject;
    if (paramIntent != null)
    {
      str = paramIntent.getAction();
      if (!"com.tencent.process.exit".equals(str)) {
        break label230;
      }
      localObject = paramIntent.getExtras();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    ArrayList localArrayList = ((Bundle)localObject).getStringArrayList("procNameList");
    boolean bool1;
    label83:
    boolean bool2;
    if ((AppProcHelper.isLegalBroadcast(((Bundle)localObject).getString("verify"), localArrayList)) && (AppProcHelper.isContainsProc(paramContext, localArrayList)))
    {
      paramContext = this.mRt.subRuntimeMap.values().iterator();
      bool1 = false;
      bool2 = bool1;
      if (!paramContext.hasNext()) {
        break label171;
      }
      localObject = (AppRuntime)paramContext.next();
      if ((!(localObject instanceof IToolProcEventListener)) || (!((IToolProcEventListener)localObject).onReceiveLegalExitProcAction(paramIntent))) {
        break label388;
      }
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "notKillBy(LegalExit) " + ((AppRuntime)localObject).getModuleId());
      }
      bool1 = true;
    }
    label385:
    label388:
    for (;;)
    {
      break label83;
      bool2 = true;
      for (;;)
      {
        label171:
        if (!bool2)
        {
          paramContext = this.mRt.subRuntimeMap.values().iterator();
          for (;;)
          {
            if (paramContext.hasNext())
            {
              paramIntent = (AppRuntime)paramContext.next();
              if ((paramIntent instanceof IToolProcEventListener))
              {
                ((IToolProcEventListener)paramIntent).onBeforeExitProc();
                continue;
                label230:
                paramContext = this.mRt.subRuntimeMap.values().iterator();
                bool1 = false;
                label248:
                bool2 = bool1;
                if (!paramContext.hasNext()) {
                  break;
                }
                localObject = (AppRuntime)paramContext.next();
                if ((!(localObject instanceof IToolProcEventListener)) || (!((IToolProcEventListener)localObject).onReceiveAccountAction(str, paramIntent))) {
                  break label385;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("mqq", 2, "notKillBy(Account) " + ((AppRuntime)localObject).getModuleId());
                }
                bool1 = true;
              }
            }
          }
        }
      }
      for (;;)
      {
        break label248;
        this.mRt.exitToolProc();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("mqq", 2, "ToolProcReceiver " + str + "." + bool2);
        return;
      }
    }
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