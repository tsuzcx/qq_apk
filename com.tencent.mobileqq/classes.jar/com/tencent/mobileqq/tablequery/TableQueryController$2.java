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
      if (paramIntent == null) {
        return;
      }
      QueryData localQueryData = new QueryData();
      localQueryData.k = "";
      paramContext = new StringBuilder();
      paramContext.append(paramIntent.actionName);
      paramContext.append("\n");
      paramContext.append(paramIntent.subAction);
      paramContext.append("\n");
      paramContext.append(paramIntent.mainAction);
      paramContext.append("\n");
      localQueryData.b = paramContext.toString();
      if (paramIntent.actionName == null) {
        paramContext = paramIntent.mainAction;
      } else {
        paramContext = paramIntent.subAction;
      }
      localQueryData.a = paramContext;
      if ((TableQueryController.a) && (!TableQueryController.b) && (TableQueryController.a(this.a) != null)) {
        TableQueryController.a(this.a).a(localQueryData);
      }
      if ((TableQueryController.a) && ((TableQueryController.c) || (TableQueryController.e()))) {
        TableQueryController.c(this.a).a((QQAppInterface)TableQueryController.b(this.a).get(), paramIntent.table, 2, paramIntent.mainAction, paramIntent.actionName, paramIntent.subAction);
      }
      paramContext = new StringBuilder();
      paramContext.append(paramIntent.actionName);
      paramContext.append("\n");
      paramContext.append(paramIntent.mainAction);
      paramContext.append("\n");
      paramContext.append(paramIntent.subAction);
      paramContext.append("\n");
      paramContext.append(paramIntent.table);
      paramContext.append("\n");
      QLog.d("TableQueryController", 1, paramContext.toString());
      return;
    }
    if ("com.tencent.plugin.state.change" == paramContext)
    {
      int i = paramIntent.getIntExtra("key_plugin_state", -1);
      if (1 == i)
      {
        this.a.c();
        paramContext = new TableQueryController.2.1(this);
        ThreadManager.getSubThreadHandler().postDelayed(paramContext, 2000L);
        return;
      }
      if (i == 0)
      {
        this.a.d();
        TableQueryController.a = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryController.2
 * JD-Core Version:    0.7.0.1
 */