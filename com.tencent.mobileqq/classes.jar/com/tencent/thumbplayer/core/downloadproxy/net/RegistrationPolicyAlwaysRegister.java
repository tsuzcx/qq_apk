package com.tencent.thumbplayer.core.downloadproxy.net;

public class RegistrationPolicyAlwaysRegister
  extends RegistrationPolicy
{
  protected void destroy() {}
  
  protected void init(NetworkChangeNotifierAutoDetect paramNetworkChangeNotifierAutoDetect)
  {
    super.init(paramNetworkChangeNotifierAutoDetect);
    register();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.net.RegistrationPolicyAlwaysRegister
 * JD-Core Version:    0.7.0.1
 */