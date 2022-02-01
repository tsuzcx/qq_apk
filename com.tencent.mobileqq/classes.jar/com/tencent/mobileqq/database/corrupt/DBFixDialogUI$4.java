package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

class DBFixDialogUI$4
  implements DialogInterface.OnClickListener
{
  DBFixDialogUI$4(DBFixDialogUI paramDBFixDialogUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.a.b;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.a.a.getCurrentAccountUin());
    ((StringBuilder)localObject1).append(".db");
    paramDialogInterface = paramDialogInterface.getDatabasePath(((StringBuilder)localObject1).toString());
    boolean bool;
    if ((paramDialogInterface.exists()) && ((float)paramDialogInterface.length() * 1.7F > FileUtils.getAvailableInnernalMemorySize()))
    {
      bool = true;
      DBFixDialogUI.b(this.a);
      localObject1 = this.a.a.getApplication().getSharedPreferences(DBFixManager.d, 0);
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append(this.a.c);
      paramDialogInterface.append(DBFixManager.s);
      paramDialogInterface = ((SharedPreferences)localObject1).getString(paramDialogInterface.toString(), "");
      localObject1 = ((SharedPreferences)localObject1).edit();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.c);
      ((StringBuilder)localObject2).append(DBFixManager.s);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDialogInterface);
      localStringBuilder.append("_MemoryAlert");
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, localStringBuilder.toString()).commit();
    }
    else
    {
      DBFixDialogUI.c(this.a);
      bool = false;
    }
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("isMemAlert", String.valueOf(bool));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.y, true, -1L, 0L, paramDialogInterface, null, false);
    ReportController.b(this.a.a, "CliOper", "", this.a.c, DBFixDialogUI.f, DBFixDialogUI.f, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI.4
 * JD-Core Version:    0.7.0.1
 */