package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;

class ChannelCenter$1$1
  implements Runnable
{
  ChannelCenter$1$1(ChannelCenter.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebServiceSSO--onSuccess final cmd=");
    localStringBuilder.append(this.b.a);
    Log.i("ChannelCenter", localStringBuilder.toString());
    this.b.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.1.1
 * JD-Core Version:    0.7.0.1
 */