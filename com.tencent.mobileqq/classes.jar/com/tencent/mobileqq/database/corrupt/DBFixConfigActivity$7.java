package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import mqq.app.AppRuntime;

class DBFixConfigActivity$7
  implements View.OnClickListener
{
  DBFixConfigActivity$7(DBFixConfigActivity paramDBFixConfigActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a.getText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QQToast.makeText(this.b, "请输入需要加载的DB名字", 0).show();
    }
    else
    {
      Object localObject2 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(".db");
      localObject2 = ((DBFixConfigActivity)localObject2).getDatabasePath(localStringBuilder.toString());
      if (!((File)localObject2).exists())
      {
        localObject2 = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("目标DB ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(".db 不存在，请输入正确的DB名字");
        QQToast.makeText((Context)localObject2, localStringBuilder.toString(), 0).show();
      }
      else
      {
        localObject1 = this.b.getAppRuntime();
        if ((localObject1 instanceof QQAppInterface)) {
          if (!((DBFixManager)((AppRuntime)localObject1).getManager(QQManagerFactory.DB_FIX_MANAGER)).b()) {
            QQToast.makeText(this.b.getApplicationContext(), "DBFix so 加载失败", 1).show();
          } else {
            ThreadManagerV2.excute(new DBFixConfigActivity.7.1(this, (File)localObject2), 32, null, true);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.7
 * JD-Core Version:    0.7.0.1
 */