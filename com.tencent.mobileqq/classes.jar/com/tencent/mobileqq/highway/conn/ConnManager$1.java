package com.tencent.mobileqq.highway.conn;

class ConnManager$1
  implements Runnable
{
  ConnManager$1(ConnManager paramConnManager, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    ConnManager.access$000(this.this$0, this.val$netType, false, this.val$ipv6First ^ true);
    ConnManager.access$100(this.this$0).mRacingRunnable = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.conn.ConnManager.1
 * JD-Core Version:    0.7.0.1
 */