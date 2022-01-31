package com.tencent.open.agent;

import android.content.res.Resources;
import android.widget.Button;
import bdcc;
import com.tencent.qphone.base.util.QLog;

public class OpenAuthorityFragment$6
  implements Runnable
{
  OpenAuthorityFragment$6(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void run()
  {
    if (OpenAuthorityFragment.a(this.this$0))
    {
      QLog.e("OpenAuthorityFragment", 1, " activity is isInvalid");
      return;
    }
    this.this$0.i();
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      String str = this.this$0.getResources().getString(2131694897);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.this$0.a(this.this$0.getResources().getString(2131694906), new bdcc(this));
      return;
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setTag(this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.6
 * JD-Core Version:    0.7.0.1
 */