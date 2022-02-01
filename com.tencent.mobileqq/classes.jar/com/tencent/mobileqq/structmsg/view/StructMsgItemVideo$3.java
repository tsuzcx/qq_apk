package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import bcvw;
import bdaz;
import bdbh;

public class StructMsgItemVideo$3
  implements Runnable
{
  public StructMsgItemVideo$3(bdaz parambdaz, Context paramContext, View paramView) {}
  
  public void run()
  {
    String str = bcvw.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.Z, bdaz.a(this.this$0));
    this.this$0.a.obtainMessage().obj = this.jdField_a_of_type_AndroidViewView;
    if (!TextUtils.isEmpty(str))
    {
      bdaz.a(this.this$0, this.jdField_a_of_type_AndroidContentContext, str);
      return;
    }
    bdaz.a(this.this$0, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3
 * JD-Core Version:    0.7.0.1
 */