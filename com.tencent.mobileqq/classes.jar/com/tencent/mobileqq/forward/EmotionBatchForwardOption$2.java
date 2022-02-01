package com.tencent.mobileqq.forward;

import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class EmotionBatchForwardOption$2
  implements Runnable
{
  EmotionBatchForwardOption$2(EmotionBatchForwardOption paramEmotionBatchForwardOption) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.t.getString("uin");
    Object localObject2 = this.this$0.t.getString("troop_uin");
    int i = this.this$0.t.getInt("uintype");
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = i;
    localSessionInfo.b = ((String)localObject1);
    localSessionInfo.c = ((String)localObject2);
    if ((this.this$0.A instanceof QQCustomDialogWtihEmoticonInput)) {
      localObject1 = ((QQCustomDialogWtihEmoticonInput)this.this$0.A).getInputValue();
    } else if ((this.this$0.A instanceof ForwardNewVersionDialog)) {
      localObject1 = ((ForwardNewVersionDialog)this.this$0.A).getInputValue();
    } else {
      localObject1 = "";
    }
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      ChatActivityFacade.a(this.this$0.q, this.this$0.I, localSessionInfo, (String)localObject1, null);
    }
    localObject1 = this.this$0.a.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Object localObject3 = EmotionBatchForwardOption.a((String)localObject2);
      if ("MARK_EMOTION:".equals(localObject3))
      {
        localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(":") + 1).split("_&_");
        if (localObject2.length >= 2)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("forwardOnConfirm epId:");
            ((StringBuilder)localObject3).append(localObject2[0]);
            ((StringBuilder)localObject3).append(",eId:");
            ((StringBuilder)localObject3).append(localObject2[1]);
            QLog.d("EmotionBatchForwardOption", 2, ((StringBuilder)localObject3).toString());
          }
          ((IEmoticonManagerService)this.this$0.q.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticon(String.valueOf(localObject2[0]), localObject2[1], new EmotionBatchForwardOption.2.1(this, localSessionInfo));
        }
      }
      else if ("PIC_EMOTION:".equals(localObject3))
      {
        localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf(":") + 1);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("forwardOnConfirm  path：");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("EmotionBatchForwardOption", 2, ((StringBuilder)localObject3).toString());
        }
        ChatActivityFacade.a(this.this$0.q, this.this$0.I, localSessionInfo, (String)localObject2, false, "", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.EmotionBatchForwardOption.2
 * JD-Core Version:    0.7.0.1
 */