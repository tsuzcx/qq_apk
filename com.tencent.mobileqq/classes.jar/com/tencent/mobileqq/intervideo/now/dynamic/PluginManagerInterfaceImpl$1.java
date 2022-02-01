package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket;
import java.util.concurrent.Future;

class PluginManagerInterfaceImpl$1
  implements CustomizedTicket
{
  PluginManagerInterfaceImpl$1(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl) {}
  
  public Future<Bundle> getA1(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    PluginManagerInterfaceImpl localPluginManagerInterfaceImpl = this.a;
    return localPluginManagerInterfaceImpl.a(localPluginManagerInterfaceImpl.e(), paramString1, paramString2, paramString3, paramString4);
  }
  
  public Future<Bundle> getAccessToken(String paramString1, String paramString2)
  {
    return this.a.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.1
 * JD-Core Version:    0.7.0.1
 */