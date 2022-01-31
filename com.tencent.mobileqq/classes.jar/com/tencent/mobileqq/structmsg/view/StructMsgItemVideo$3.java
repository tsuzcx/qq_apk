package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import axut;
import axzs;
import ayaa;

public class StructMsgItemVideo$3
  implements Runnable
{
  public StructMsgItemVideo$3(axzs paramaxzs, Context paramContext, View paramView) {}
  
  public void run()
  {
    String str = axut.a(this.jdField_a_of_type_AndroidContentContext, this.this$0.R, axzs.a(this.this$0));
    this.this$0.a.obtainMessage().obj = this.jdField_a_of_type_AndroidViewView;
    if (!TextUtils.isEmpty(str))
    {
      axzs.a(this.this$0, this.jdField_a_of_type_AndroidContentContext, str);
      return;
    }
    axzs.a(this.this$0, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.3
 * JD-Core Version:    0.7.0.1
 */