package com.tencent.mobileqq.structmsg;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;

class StructMsgForImageShare$2
  implements Runnable
{
  StructMsgForImageShare$2(StructMsgForImageShare paramStructMsgForImageShare, Drawable paramDrawable, Resources paramResources, TextView paramTextView) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(StructMsgItemCover.a(this.a));
    localBitmapDrawable.setBounds(0, 0, AIOUtils.b(14.0F, this.b), AIOUtils.b(14.0F, this.b));
    ThreadManagerV2.getUIHandlerV2().post(new StructMsgForImageShare.2.1(this, localBitmapDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare.2
 * JD-Core Version:    0.7.0.1
 */