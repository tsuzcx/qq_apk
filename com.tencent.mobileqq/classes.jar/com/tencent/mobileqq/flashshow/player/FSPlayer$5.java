package com.tencent.mobileqq.flashshow.player;

import com.tencent.mobileqq.flashshow.inject.FSToast;
import com.tencent.mobileqq.flashshow.utils.FSHardCodeUtil;

class FSPlayer$5
  implements Runnable
{
  FSPlayer$5(FSPlayer paramFSPlayer, String paramString) {}
  
  public void run()
  {
    int i = FSToast.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FSHardCodeUtil.a(2131913545));
    localStringBuilder.append(this.a);
    FSToast.a(i, localStringBuilder.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.player.FSPlayer.5
 * JD-Core Version:    0.7.0.1
 */