package com.tencent.mobileqq.tablequery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class TableQueryController$2
  extends BroadcastReceiver
{
  TableQueryController$2(TableQueryController paramTableQueryController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("action.query.data.viewer" == paramContext)
    {
      paramIntent = (TReportData)paramIntent.getSerializableExtra("queryData");
      if (paramIntent != null) {}
    }
    int i;
    do
    {
      do
      {
        return;
        QueryData localQueryData = new QueryData();
        localQueryData.k = "";
        localQueryData.b = (paramIntent.actionName + "\n" + paramIntent.subAction + "\n" + paramIntent.mainAction + "\n");
        if (paramIntent.actionName == null) {}
        for (paramContext = paramIntent.mainAction;; paramContext = paramIntent.subAction)
        {
          localQueryData.a = paramContext;
          if ((TableQueryController.a) && (!TableQueryController.b) && (TableQueryController.a(this.a) != null)) {
            TableQueryController.a(this.a).a(localQueryData);
          }
          if ((TableQueryController.a) && ((TableQueryController.c) || (TableQueryController.a()))) {
            TableQueryController.a(this.a).a((QQAppInterface)TableQueryController.a(this.a).get(), paramIntent.table, 2, paramIntent.mainAction, paramIntent.actionName, paramIntent.subAction);
          }
          QLog.d("TableQueryController", 1, paramIntent.actionName + "\n" + paramIntent.mainAction + "\n" + paramIntent.subAction + "\n" + paramIntent.table + "\n");
          return;
        }
      } while ("com.tencent.plugin.state.change" != paramContext);
      i = paramIntent.getIntExtra("key_plugin_state", -1);
      if (1 == i)
      {
        this.a.b();
        paramContext = new TableQueryController.2.1(this);
        ThreadManager.getSubThreadHandler().postDelayed(paramContext, 2000L);
        return;
      }
    } while (i != 0);
    this.a.c();
    TableQueryController.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryController.2
 * JD-Core Version:    0.7.0.1
 */