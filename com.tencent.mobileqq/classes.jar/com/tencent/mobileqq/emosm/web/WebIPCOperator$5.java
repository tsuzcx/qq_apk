package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class WebIPCOperator$5
  implements EmojiIPCAlarmer.TimeoutObserver
{
  WebIPCOperator$5(WebIPCOperator paramWebIPCOperator) {}
  
  public void a(int paramInt)
  {
    WebIPCOperator.RequestItem localRequestItem = this.a.a(paramInt);
    if (localRequestItem != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("on req timeout seq: ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new Bundle();
      this.a.a((Bundle)localObject, 1001);
      localRequestItem.b.putBundle("response", (Bundle)localObject);
      this.a.a(new WebIPCOperator.5.1(this, localRequestItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.WebIPCOperator.5
 * JD-Core Version:    0.7.0.1
 */