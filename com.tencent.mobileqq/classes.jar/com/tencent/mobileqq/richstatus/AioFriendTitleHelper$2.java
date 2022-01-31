package com.tencent.mobileqq.richstatus;

import android.widget.TextView;
import awbu;

public class AioFriendTitleHelper$2
  implements Runnable
{
  public AioFriendTitleHelper$2(awbu paramawbu, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    awbu.a(this.this$0, this.jdField_a_of_type_Boolean);
    if ((!this.this$0.b()) || (!this.jdField_a_of_type_Boolean))
    {
      awbu.a(this.this$0).setText(this.jdField_a_of_type_JavaLangString);
      this.this$0.b(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.AioFriendTitleHelper.2
 * JD-Core Version:    0.7.0.1
 */