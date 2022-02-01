package com.tencent.thumbplayer.core.downloadproxy.net;

public abstract class RegistrationPolicy
{
  private NetworkChangeNotifierAutoDetect mNotifier;
  
  protected abstract void destroy();
  
  protected void init(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect)
  {
    this.mNotifier = paramNetworkChangeNotifierAutoDetect;
  }
  
  protected final void register()
  {
    this.mNotifier.register();
  }
  
  protected final void unregister()
  {
    this.mNotifier.unregister();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.RegistrationPolicy
 * JD-Core Version:    0.7.0.1
 */