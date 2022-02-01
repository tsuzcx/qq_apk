package com.tencent.open.agent;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class OpenSelectPermissionFragment$2
  implements Runnable
{
  OpenSelectPermissionFragment$2(OpenSelectPermissionFragment paramOpenSelectPermissionFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("SDK_LOGIN.OpenSelectPermissionFragment", 1, "showToast activity is null");
      return;
    }
    QQToast localQQToast = new QQToast(this.this$0.getActivity());
    if (this.jdField_a_of_type_Boolean)
    {
      localQQToast.a(QQToast.a(2));
      localQQToast.b(2);
    }
    for (;;)
    {
      localQQToast.d(2000);
      localQQToast.a(this.jdField_a_of_type_JavaLangString);
      localQQToast.a();
      return;
      localQQToast.a(QQToast.a(1));
      localQQToast.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.2
 * JD-Core Version:    0.7.0.1
 */