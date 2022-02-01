package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;

class ChannelCenter$2
  implements Runnable
{
  ChannelCenter$2(ChannelCenter paramChannelCenter, int paramInt, IChannelListener paramIChannelListener, String paramString) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebServiceSSO--onException final cmd=");
    localStringBuilder.append(this.a);
    Log.d("ChannelCenter", localStringBuilder.toString());
    if (ChannelCenter.a(this.this$0))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    this.b.a(1000002, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.2
 * JD-Core Version:    0.7.0.1
 */