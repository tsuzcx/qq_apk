package com.tencent.open.agent;

import bbmy;
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
    bbmy localbbmy = new bbmy(this.this$0.getActivity());
    if (this.jdField_a_of_type_Boolean)
    {
      localbbmy.a(bbmy.a(2));
      localbbmy.b(2);
    }
    for (;;)
    {
      localbbmy.d(2000);
      localbbmy.a(this.jdField_a_of_type_JavaLangString);
      localbbmy.a();
      return;
      localbbmy.a(bbmy.a(1));
      localbbmy.b(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.2
 * JD-Core Version:    0.7.0.1
 */