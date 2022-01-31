package com.tencent.open.agent;

import bcpw;
import com.tencent.qphone.base.util.QLog;

class OpenSelectPermissionFragment$2
  implements Runnable
{
  OpenSelectPermissionFragment$2(OpenSelectPermissionFragment paramOpenSelectPermissionFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.this$0.getActivity() == null)
    {
      QLog.e("OpenSelectPermissionFragment", 1, "showToast activity is null");
      return;
    }
    bcpw localbcpw = new bcpw(this.this$0.getActivity());
    if (this.jdField_a_of_type_Boolean)
    {
      localbcpw.a(bcpw.a(2));
      localbcpw.b(2);
    }
    for (;;)
    {
      localbcpw.d(2000);
      localbcpw.a(this.jdField_a_of_type_JavaLangString);
      localbcpw.a();
      return;
      localbcpw.a(bcpw.a(1));
      localbcpw.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.2
 * JD-Core Version:    0.7.0.1
 */