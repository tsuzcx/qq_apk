package com.tencent.thumbplayer.core.downloadproxy.net;

public abstract class RegistrationPolicy
{
  private NetworkChangeNotifierAutoDetect mNotifier;
  
  static
  {
    if (!RegistrationPolicy.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  protected abstract void destroy();
  
  protected void init(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect)
  {
    this.mNotifier = paramNetworkChangeNotifierAutoDetect;
  }
  
  protected final void register()
  {
    assert (this.mNotifier != null);
    this.mNotifier.register();
  }
  
  protected final void unregister()
  {
    assert (this.mNotifier != null);
    this.mNotifier.unregister();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.RegistrationPolicy
 * JD-Core Version:    0.7.0.1
 */