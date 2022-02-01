package com.tencent.mobileqq.database.corrupt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class DBFixConfigActivity$8
  implements View.OnClickListener
{
  DBFixConfigActivity$8(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    localObject = ((DBFixConfigActivity)localObject).getDatabasePath(((DBFixConfigActivity)localObject).getAppRuntime().getAccount()).getParent();
    String str = DBFixConfigActivity.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dbPath: ");
    localStringBuilder.append((String)localObject);
    QLog.d(str, 1, localStringBuilder.toString());
    FileUtils.copyAssetDirsToSdcard(this.a, "dbfix", (String)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.8
 * JD-Core Version:    0.7.0.1
 */