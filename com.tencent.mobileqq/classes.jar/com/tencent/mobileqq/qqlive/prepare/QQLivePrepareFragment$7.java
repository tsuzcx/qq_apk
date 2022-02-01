package com.tencent.mobileqq.qqlive.prepare;

import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QQLivePrepareFragment$7
  extends QQPermission.BasePermissionsListener
{
  QQLivePrepareFragment$7(QQLivePrepareFragment paramQQLivePrepareFragment) {}
  
  public void a()
  {
    super.a();
    QQLivePrepareFragment.n(this.a);
  }
  
  public void a(List<String> paramList, List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    QLog.d("QQLivePrepareFragment", 1, "the initial permission was been denied ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.7
 * JD-Core Version:    0.7.0.1
 */