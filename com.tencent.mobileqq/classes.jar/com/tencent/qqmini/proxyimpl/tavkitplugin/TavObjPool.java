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
    if (paramObject == null) {
      return "-1";
    }
    String str = b(paramObject);
    if (this.a.containsKey(str)) {
      return str;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("put() called with: obj = [");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("]");
    Logger.d("TavObjPool", localStringBuilder.toString());
    this.a.put(str, paramObject);
    return str;
  }
  
  @NotNull
  public String b(@NotNull Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(System.identityHashCode(paramObject));
    return localStringBuilder.toString();
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release() called with: identifier = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    Log.v("TavObjPool", localStringBuilder.toString());
    paramString = this.a.remove(paramString);
    if ((paramString instanceof ITAVReleaseAble)) {
      ((ITAVReleaseAble)paramString).a();
    }
    paramString = new StringBuilder();
    paramString.append("release: objMap = ");
    paramString.append(this.a);
    Logger.d("TavObjPool", paramString.toString());
  }
  
  public void c(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    b(b(paramObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.TavObjPool
 * JD-Core Version:    0.7.0.1
 */