package com.tencent.open.agent;

import android.content.res.Resources;
import android.widget.Button;
import com.tencent.open.agent.util.AuthorityUtil;

class AuthorityActivity$5
  implements Runnable
{
  AuthorityActivity$5(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    this.this$0.j();
    this.this$0.jdField_a_of_type_AndroidWidgetButton.setText(2131694674);
    if (this.this$0.jdField_a_of_type_Int == 0)
    {
      String str = this.this$0.getResources().getString(2131694670);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      AuthorityUtil.a(this.this$0, this.this$0.getResources().getString(2131694678), new AuthorityActivity.5.1(this));
      return;
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setTag(this.this$0.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.5
 * JD-Core Version:    0.7.0.1
 */