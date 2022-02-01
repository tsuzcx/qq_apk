package com.tencent.superplayer.player;

import android.os.HandlerThread;

class SuperPlayerMgr$1
  implements Runnable
{
  SuperPlayerMgr$1(SuperPlayerMgr paramSuperPlayerMgr) {}
  
  public void run()
  {
    if (SuperPlayerMgr.access$000(this.this$0) != null)
    {
      SuperPlayerMgr.access$000(this.this$0).release();
      SuperPlayerMgr.access$002(this.this$0, null);
    }
    if (SuperPlayerMgr.access$100(this.this$0) != null)
    {
      SuperPlayerMgr.access$100(this.this$0).quit();
      SuperPlayerMgr.access$102(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerMgr.1
 * JD-Core Version:    0.7.0.1
 */