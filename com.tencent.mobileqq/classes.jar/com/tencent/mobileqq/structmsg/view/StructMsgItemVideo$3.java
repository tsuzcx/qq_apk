package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import azqn;
import azvm;
import azvu;

public class StructMsgItemVideo$3
  implements Runnable
{
  public StructMsgItemVideo$3(azvm paramazvm, Context paramContext, View paramView) {}
  
  public void run()
  {
    String str = azqn.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.R, azvm.a(this.this$0));
    this.this$0.a.obtainMessage().obj = this.jdField_a_of_type_AndroidViewView;
    if (!TextUtils.isEmpty(str))
    {
      azvm.a(this.this$0, this.jdField_a_of_type_AndroidContentContext, str);
      return;
    }
    azvm.a(this.this$0, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3
 * JD-Core Version:    0.7.0.1
 */