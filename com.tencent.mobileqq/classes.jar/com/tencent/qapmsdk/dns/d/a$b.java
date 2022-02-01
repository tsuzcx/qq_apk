package com.tencent.qapmsdk.dns.d;

import com.tencent.qapmsdk.dns.a.b;
import java.lang.reflect.Field;
import java.net.InetAddress;

class a$b
  implements a.a
{
  public void a()
  {
    Object localObject = InetAddress.class.getDeclaredField("addressCache");
    ((Field)localObject).setAccessible(true);
    localObject = ((Field)localObject).get(null);
    Field localField = Class.forName("java.net.AddressCache").getDeclaredField("cache");
    localField.setAccessible(true);
    localObject = localField.get(localObject);
    localField = Class.forName("libcore.util.BasicLruCache").getDeclaredField("map");
    localField.setAccessible(true);
    localField.set(localObject, new b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.dns.d.a.b
 * JD-Core Version:    0.7.0.1
 */