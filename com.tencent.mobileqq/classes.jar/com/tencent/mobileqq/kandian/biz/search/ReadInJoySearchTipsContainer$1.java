package com.tencent.mobileqq.kandian.biz.search;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.kandian.biz.search.api.OnTipClickListener;

class ReadInJoySearchTipsContainer$1
  extends Handler
{
  ReadInJoySearchTipsContainer$1(ReadInJoySearchTipsContainer paramReadInJoySearchTipsContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.a != null)
    {
      if (paramMessage.obj != null)
      {
        this.a.a.a((String)paramMessage.obj);
        return;
      }
      this.a.a.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.ReadInJoySearchTipsContainer.1
 * JD-Core Version:    0.7.0.1
 */