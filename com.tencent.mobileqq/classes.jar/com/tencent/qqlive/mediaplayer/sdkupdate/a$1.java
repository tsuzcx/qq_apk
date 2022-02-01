package com.tencent.qqlive.mediaplayer.sdkupdate;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    try
    {
      SDKLocalConfig localSDKLocalConfig = a.a(this.a).a(false);
      if (localSDKLocalConfig == null)
      {
        d.a(5, "SDKUpdate.java", "MediaPlayerMgr", "startWithForceAndSilent, config == null ");
        return;
      }
      a.a(this.a).a(localSDKLocalConfig, false);
      return;
    }
    catch (Exception localException)
    {
      d.a(5, "SDKUpdate.java", "MediaPlayerMgr", "startWithForceAndSilent, exception: " + localException.toString());
      localException.printStackTrace();
      return;
    }
    finally
    {
      a.a(this.a).f();
      a.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.a.1
 * JD-Core Version:    0.7.0.1
 */