package com.tencent.open.agent;

import bcql;
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
    bcql localbcql = new bcql(this.this$0.getActivity());
    if (this.jdField_a_of_type_Boolean)
    {
      localbcql.a(bcql.a(2));
      localbcql.b(2);
    }
    for (;;)
    {
      localbcql.d(2000);
      localbcql.a(this.jdField_a_of_type_JavaLangString);
      localbcql.a();
      return;
      localbcql.a(bcql.a(1));
      localbcql.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.2
 * JD-Core Version:    0.7.0.1
 */