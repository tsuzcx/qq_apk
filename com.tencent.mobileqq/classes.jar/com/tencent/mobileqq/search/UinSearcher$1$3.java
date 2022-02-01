package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.search.UinSearchConfProcessor.UinSearchConfigBean;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;

class UinSearcher$1$3
  implements Runnable
{
  UinSearcher$1$3(UinSearcher.1 param1, ActionSheet paramActionSheet, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem2, UinSearchConfProcessor.UinSearchConfigBean paramUinSearchConfigBean, QQAppInterface paramQQAppInterface, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem3) {}
  
  public void run()
  {
    this.a.show();
    if (this.b[0] == null)
    {
      if (this.c[0] == null) {
        localObject1 = "0X800A923";
      } else {
        localObject1 = "0X800A921";
      }
    }
    else if (this.c[0] == null) {
      localObject1 = "0X800A920";
    } else {
      localObject1 = "0X800A922";
    }
    Object localObject2 = this.b[0];
    String str = "";
    if ((localObject2 == null) && (this.c[0] == null))
    {
      localObject2 = "";
    }
    else
    {
      int i;
      if (this.d.a())
      {
        localObject2 = new StringBuilder();
        i = UinSearchConfProcessor.UinSearchConfigBean.a;
      }
      else
      {
        localObject2 = new StringBuilder();
        i = UinSearchConfProcessor.UinSearchConfigBean.b;
      }
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject3 = this.e;
    ReportController.b((AppRuntime)localObject3, "dc00898", "", "", (String)localObject1, (String)localObject1, UinSearcher.a((QQAppInterface)localObject3, UinSearcher.f(this.g.a), UinSearcher.l(this.g.a)), 0, (String)localObject2, "", "", "");
    Object localObject1 = this.f;
    if ((localObject1[0] != null) && (!TextUtils.isEmpty(localObject1[0].E)))
    {
      if (this.f[0].D.equals("#808080")) {
        localObject1 = "0X800B0BD";
      } else {
        localObject1 = "0X800B0BE";
      }
    }
    else {
      localObject1 = "0X800B0BF";
    }
    if (((String)localObject1).equals("0X800B0BD")) {
      localObject2 = this.f[0].A;
    } else {
      localObject2 = "";
    }
    if (!((String)localObject2).equals("")) {
      str = this.f[0].B;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("baoguang TValue r4 r5: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(str);
      QLog.d("UinSearcher", 2, ((StringBuilder)localObject3).toString());
    }
    ReportController.b(this.e, "dc00898", "", "", (String)localObject1, (String)localObject1, UinSearcher.a(UinSearcher.f(this.g.a)), 0, "", "", (String)localObject2, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */