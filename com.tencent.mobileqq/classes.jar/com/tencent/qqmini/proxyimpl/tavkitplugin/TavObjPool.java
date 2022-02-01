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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(System.identityHashCode(paramObject));
    localObject = ((StringBuilder)localObject).toString();
    if (this.a.containsKey(localObject)) {
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("put() called with: obj = [");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("]");
    Logger.d("TavObjPool", localStringBuilder.toString());
    this.a.put(localObject, paramObject);
    return localObject;
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release() called with: identifier = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.v("TavObjPool", localStringBuilder.toString());
    this.a.remove(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ObjPool{objectMap.size=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool
 * JD-Core Version:    0.7.0.1
 */