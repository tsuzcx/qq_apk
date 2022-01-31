package com.tencent.tmdownloader.internal.storage;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.r;
import java.util.Map;

class c
  implements Runnable
{
  c(b paramb, String paramString, byte[] paramArrayOfByte, Class paramClass) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.b != null)) {
      try
      {
        JceStruct localJceStruct = ProtocolPackage.bytes2JceObj(this.b, this.c);
        if (localJceStruct != null)
        {
          b.a(this.d).put(this.a, localJceStruct);
          Settings.getInstance().setBlob(this.a, this.b);
          r.c("JceCacheManager", "<save> " + this.a + " success!");
          return;
        }
        r.c("JceCacheManager", "<save> value of " + this.a + " is null !");
        return;
      }
      catch (Exception localException)
      {
        r.e("JceCacheManager", "<save> type cast error!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.c
 * JD-Core Version:    0.7.0.1
 */