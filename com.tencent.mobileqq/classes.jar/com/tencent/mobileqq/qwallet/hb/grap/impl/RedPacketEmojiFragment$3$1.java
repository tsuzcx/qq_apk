package com.tencent.mobileqq.qwallet.hb.grap.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class RedPacketEmojiFragment$3$1
  implements Runnable
{
  RedPacketEmojiFragment$3$1(RedPacketEmojiFragment.3 param3, int paramInt, IPreloadService.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("face config doLoading result:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(",pathres=");
      localStringBuilder.append(this.b);
      QLog.i("RedPacketEmojiFragment", 2, localStringBuilder.toString());
    }
    if (this.a == 0)
    {
      this.c.a.n = this.b.filePath;
      this.c.a.d();
      return;
    }
    this.c.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.impl.RedPacketEmojiFragment.3.1
 * JD-Core Version:    0.7.0.1
 */