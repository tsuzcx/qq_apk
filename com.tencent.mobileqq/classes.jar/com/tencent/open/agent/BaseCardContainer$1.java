package com.tencent.open.agent;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLImageView;
import com.tencent.open.agent.util.SSOLog;

class BaseCardContainer$1
  extends Handler
{
  BaseCardContainer$1(BaseCardContainer paramBaseCardContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 10001)
    {
      SSOLog.a("BaseCardContainer", new Object[] { "-->handleMessage MSG_UPDATE" });
      this.a.a();
      this.a.a.setImageDrawable(BaseCardContainer.a(this.a));
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BaseCardContainer.1
 * JD-Core Version:    0.7.0.1
 */