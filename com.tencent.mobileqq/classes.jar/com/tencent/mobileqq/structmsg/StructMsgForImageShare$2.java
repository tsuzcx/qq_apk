package com.tencent.mobileqq.structmsg;

import agej;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.TextView;
import bdqo;
import com.tencent.mobileqq.app.ThreadManagerV2;

class StructMsgForImageShare$2
  implements Runnable
{
  StructMsgForImageShare$2(StructMsgForImageShare paramStructMsgForImageShare, Drawable paramDrawable, Resources paramResources, TextView paramTextView) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(bdqo.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
    localBitmapDrawable.setBounds(0, 0, agej.a(14.0F, this.jdField_a_of_type_AndroidContentResResources), agej.a(14.0F, this.jdField_a_of_type_AndroidContentResResources));
    ThreadManagerV2.getUIHandlerV2().post(new StructMsgForImageShare.2.1(this, localBitmapDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.2
 * JD-Core Version:    0.7.0.1
 */