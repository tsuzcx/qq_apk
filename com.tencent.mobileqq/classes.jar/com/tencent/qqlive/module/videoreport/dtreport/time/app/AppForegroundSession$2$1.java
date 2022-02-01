package com.tencent.qqlive.module.videoreport.dtreport.time.app;

class AppForegroundSession$2$1
  implements Runnable
{
  AppForegroundSession$2$1(AppForegroundSession.2 param2, String paramString) {}
  
  public void run()
  {
    AppHeartBeatSpUtils.removeSessionHeartBeat(this.val$sessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.time.app.AppForegroundSession.2.1
 * JD-Core Version:    0.7.0.1
 */