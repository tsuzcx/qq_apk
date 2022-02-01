package com.tencent.tmdownloader.internal.storage;

import android.text.TextUtils;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ab;
import java.util.Map;

class c
  implements Runnable
{
  c(b paramb, String paramString, byte[] paramArrayOfByte, Class paramClass) {}
  
  public void run()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.a))
    {
      localObject = this.b;
      if (localObject == null) {}
    }
    try
    {
      localObject = ProtocolPackage.bytes2JceObj((byte[])localObject, this.c);
      if (localObject != null)
      {
        b.a(this.d).put(this.a, localObject);
        Settings.getInstance().setBlob(this.a, this.b);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<save> ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" success!");
        ab.c("JceCacheManager", ((StringBuilder)localObject).toString());
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<save> value of ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" is null !");
      ab.c("JceCacheManager", ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      label146:
      break label146;
    }
    ab.e("JceCacheManager", "<save> type cast error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.c
 * JD-Core Version:    0.7.0.1
 */