package com.tencent.mobileqq.structmsg.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

class StructMsgItemPAAudio$3
  implements Runnable
{
  StructMsgItemPAAudio$3(StructMsgItemPAAudio paramStructMsgItemPAAudio, View paramView, StructMsgItemPAAudio.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    for (Object localObject1 = this.a.getParent(); (localObject1 != null) && ((localObject1 instanceof ViewGroup)); localObject1 = ((ViewGroup)localObject2).getParent())
    {
      localObject2 = (ViewGroup)localObject1;
      if (((ViewGroup)localObject2).getId() == 2131446476)
      {
        localObject2 = (StructMsgForGeneralShare)((ViewGroup)localObject2).getTag(2131446476);
        break label62;
      }
    }
    Object localObject2 = null;
    label62:
    if (localObject2 == null) {
      return;
    }
    StructMsgItemPAAudio localStructMsgItemPAAudio = this.this$0;
    localStructMsgItemPAAudio.aF = ((ViewGroup)localObject1);
    if (localStructMsgItemPAAudio.aF == null) {
      return;
    }
    localObject1 = (ChatItemBuilder.BaseHolder)AIOUtils.b(this.this$0.aF);
    if (localObject1 == null) {
      return;
    }
    long l = ((ChatItemBuilder.BaseHolder)localObject1).q.uniseq;
    this.this$0.aM = ((StructMsgForGeneralShare)localObject2).uin;
    localObject1 = this.this$0;
    ((StructMsgItemPAAudio)localObject1).aE = ((StructMsgItemPAAudio)localObject1).a(l);
    if (!this.this$0.aE)
    {
      this.b.d.setBackgroundResource(2130842789);
      return;
    }
    this.b.d.setBackgroundResource(2130772240);
    ((AnimationDrawable)this.b.d.getBackground()).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.3
 * JD-Core Version:    0.7.0.1
 */