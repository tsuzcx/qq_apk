package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class DBFixConfigActivity$10
  implements View.OnClickListener
{
  DBFixConfigActivity$10(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a.getAppRuntime();
    if ((localObject instanceof QQAppInterface)) {
      if (!((DBFixManager)((AppRuntime)localObject).getManager(QQManagerFactory.DB_FIX_MANAGER)).b())
      {
        QQToast.makeText(this.a.getApplicationContext(), "DBFix so 加载失败", 1).show();
      }
      else
      {
        localObject = this.a;
        new DBFixDialogUI((Context)localObject, (QQAppInterface)((DBFixConfigActivity)localObject).getAppRuntime()).a(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.10
 * JD-Core Version:    0.7.0.1
 */