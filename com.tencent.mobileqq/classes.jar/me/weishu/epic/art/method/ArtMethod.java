package me.weishu.epic.art.method;

import com.qq.android.dexposed.utility.Unsafe;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import me.weishu.epic.art.EpicNative;

public class ArtMethod
{
  private static int e = -1;
  private long a;
  private long b;
  private Constructor c;
  private Method d;
  
  private ArtMethod(Method paramMethod)
  {
    if (paramMethod != null)
    {
      this.d = paramMethod;
      c();
      return;
    }
    throw new IllegalArgumentException("method can not be null");
  }
  
  public static ArtMethod a(Method paramMethod)
  {
    return new ArtMethod(paramMethod);
  }
  
  private void c()
  {
    Constructor localConstructor = this.c;
    if (localConstructor != null)
    {
      this.a = EpicNative.getMethodAddress(localConstructor);
      this.b = Unsafe.a(this.c);
      return;
    }
    this.a = EpicNative.getMethodAddress(this.d);
    this.b = Unsafe.a(this.d);
  }
  
  public String a()
  {
    Constructor localConstructor = this.c;
    if (localConstructor != null) {
      return localConstructor.toGenericString();
    }
    return this.d.toGenericString();
  }
  
  public long b()
  {
    return Offset.a(this.a, Offset.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.method.ArtMethod
 * JD-Core Version:    0.7.0.1
 */