package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ForwardMixedMsgOption$1
  implements View.OnClickListener
{
  ForwardMixedMsgOption$1(ForwardMixedMsgOption paramForwardMixedMsgOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      if (this.a.A != null)
      {
        this.a.A.hideSoftInputFromWindow();
        Object localObject;
        if (this.a.a.hasReplyText())
        {
          ((ForwardMsgManager)this.a.q.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(this.a.a);
          localObject = this.a;
          ForwardReplyMsgOption.a((ForwardBaseOption)localObject, ((ForwardMixedMsgOption)localObject).a.uniseq);
        }
        else
        {
          localObject = new ForwardPreviewMixedMsgController(this.a.A, this.a.q);
          ((ForwardPreviewMixedMsgController)localObject).a(this.a.s.getString(2131889672), this.a.a);
          this.a.A.addPreviewView(((ForwardPreviewMixedMsgController)localObject).f());
        }
        this.a.aq();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e("ForwardOption.ForwardMixedMsgOption", 2, "no msg not enter preview");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMixedMsgOption.1
 * JD-Core Version:    0.7.0.1
 */