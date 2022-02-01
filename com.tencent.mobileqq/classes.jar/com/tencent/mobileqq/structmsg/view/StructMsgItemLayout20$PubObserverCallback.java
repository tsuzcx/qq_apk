package com.tencent.mobileqq.structmsg.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.HardCodeUtil;

class StructMsgItemLayout20$PubObserverCallback
  extends IPublicAccountObserver.OnCallback
{
  StructMsgItemLayout20.Holder a = null;
  
  public StructMsgItemLayout20$PubObserverCallback(StructMsgItemLayout20 paramStructMsgItemLayout20, StructMsgItemLayout20.Holder paramHolder)
  {
    this.a = paramHolder;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    paramString = this.a;
    if (paramString != null)
    {
      paramString.d.setVisibility(8);
      this.a.c.setVisibility(0);
      if (paramBoolean)
      {
        this.a.c.setBackgroundDrawable(null);
        this.a.c.setText(HardCodeUtil.a(2131911913));
        this.a.c.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.PubObserverCallback
 * JD-Core Version:    0.7.0.1
 */