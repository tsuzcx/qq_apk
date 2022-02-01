package com.tencent.open.agent;

import android.content.res.Resources;
import android.widget.Button;
import bhpt;
import bhwf;

public class AuthorityActivity$5
  implements Runnable
{
  AuthorityActivity$5(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    this.this$0.j();
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setText(2131694259);
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      String str = this.this$0.getResources().getString(2131694255);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      bhwf.a(this.this$0, this.this$0.getResources().getString(2131694263), new bhpt(this));
      return;
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setTag(this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.5
 * JD-Core Version:    0.7.0.1
 */