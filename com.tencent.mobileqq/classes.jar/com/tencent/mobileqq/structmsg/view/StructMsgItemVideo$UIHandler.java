package com.tencent.mobileqq.structmsg.view;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.lang.ref.WeakReference;

class StructMsgItemVideo$UIHandler
  extends Handler
{
  private WeakReference<StructMsgItemVideo> a = null;
  
  public StructMsgItemVideo$UIHandler(StructMsgItemVideo paramStructMsgItemVideo)
  {
    this.a = new WeakReference(paramStructMsgItemVideo);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((StructMsgItemVideo)this.a.get() != null) {
      ((AnyScaleTypeImageView)paramMessage.obj).setImageResource(2130845585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemVideo.UIHandler
 * JD-Core Version:    0.7.0.1
 */