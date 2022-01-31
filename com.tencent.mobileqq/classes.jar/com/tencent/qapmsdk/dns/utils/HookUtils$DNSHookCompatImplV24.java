package com.tencent.qapmsdk.dns.utils;

import com.tencent.qapmsdk.dns.logic.DnsCacheWrapper;
import java.lang.reflect.Field;

class HookUtils$DNSHookCompatImplV24
  implements HookUtils.DnsHookCompatImpl
{
  public void hook()
  {
    Object localObject = Class.forName("java.net.Inet6AddressImpl").getDeclaredField("addressCache");
    ((Field)localObject).setAccessible(true);
    localObject = ((Field)localObject).get(null);
    Field localField = Class.forName("java.net.AddressCache").getDeclaredField("cache");
    localField.setAccessible(true);
    localObject = localField.get(localObject);
    localField = Class.forName("libcore.util.BasicLruCache").getDeclaredField("map");
    localField.setAccessible(true);
    localField.set(localObject, new DnsCacheWrapper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.utils.HookUtils.DNSHookCompatImplV24
 * JD-Core Version:    0.7.0.1
 */