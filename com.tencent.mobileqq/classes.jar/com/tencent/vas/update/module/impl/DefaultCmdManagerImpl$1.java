package com.tencent.vas.update.module.impl;

class DefaultCmdManagerImpl$1
  extends Thread
{
  DefaultCmdManagerImpl$1(DefaultCmdManagerImpl paramDefaultCmdManagerImpl, String paramString) {}
  
  public void run()
  {
    super.run();
    try
    {
      Thread.sleep(2000L);
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
    String str = this.val$cmd;
    if (str == "GetUrlReq")
    {
      DefaultCmdManagerImpl.access$000(this.this$0);
      return;
    }
    if (str == "SyncVCRReq") {
      DefaultCmdManagerImpl.access$100(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultCmdManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */