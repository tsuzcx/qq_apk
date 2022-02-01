package com.tencent.mobileqq.database.corrupt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.Builder;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.DBBuildUtil;
import java.io.File;
import java.util.List;

class DBFixConfigActivity$9
  implements View.OnClickListener
{
  DBFixConfigActivity$9(DBFixConfigActivity paramDBFixConfigActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getText().toString();
    if (TextUtils.isEmpty(str))
    {
      QQToast.makeText(this.b, "请输入需要加载的DB名字", 0).show();
    }
    else
    {
      Object localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(".db");
      if (!((DBFixConfigActivity)localObject).getDatabasePath(localStringBuilder.toString()).exists())
      {
        localObject = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("目标DB ");
        localStringBuilder.append(str);
        localStringBuilder.append(".db 不存在，请输入正确的DB名字");
        QQToast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
      }
      else
      {
        localObject = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(str).build().createEntityManager().query(ExtensionInfo.class);
        int i;
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          i = ((List)localObject).size();
        } else {
          i = 0;
        }
        localObject = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("目标DB ");
        localStringBuilder.append(str);
        localStringBuilder.append(".db 有");
        localStringBuilder.append(i);
        localStringBuilder.append("条记录");
        QQToast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity.9
 * JD-Core Version:    0.7.0.1
 */