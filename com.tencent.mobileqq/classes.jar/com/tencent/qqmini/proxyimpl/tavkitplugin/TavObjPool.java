package com.tencent.qqmini.proxyimpl.tavkitplugin;

import android.util.Log;
import com.tencent.tav.decoder.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class TavObjPool
{
  private Map<String, Object> a = new HashMap();
  
  public static TavObjPool a()
  {
    return TavObjPool.Instance.a();
  }
  
  public Object a(String paramString)
  {
    return this.a.get(paramString);
  }
  
  public String a(@NotNull Object paramObject)
  {
    String str = "" + System.identityHashCode(paramObject);
    if (this.a.containsKey(str)) {
      return str;
    }
    Logger.d("TavObjPool", "put() called with: obj = [" + paramObject + "]");
    this.a.put(str, paramObject);
    return str;
  }
  
  public void a(String paramString)
  {
    Log.v("TavObjPool", "release() called with: identifier = [" + paramString + "]");
    this.a.remove(paramString);
  }
  
  public String toString()
  {
    return "ObjPool{objectMap.size=" + this.a.size() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool
 * JD-Core Version:    0.7.0.1
 */