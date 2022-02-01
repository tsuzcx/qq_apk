package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import okhttp3.internal.Util;

class JdkWithJettyBootPlatform$JettyNegoProvider
  implements InvocationHandler
{
  private final List<String> protocols;
  String selected;
  boolean unsupported;
  
  JdkWithJettyBootPlatform$JettyNegoProvider(List<String> paramList)
  {
    this.protocols = paramList;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    String str = paramMethod.getName();
    Class localClass = paramMethod.getReturnType();
    paramObject = paramArrayOfObject;
    if (paramArrayOfObject == null) {
      paramObject = Util.EMPTY_STRING_ARRAY;
    }
    if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
      return Boolean.valueOf(true);
    }
    if ((str.equals("unsupported")) && (Void.TYPE == localClass))
    {
      this.unsupported = true;
      return null;
    }
    if ((str.equals("protocols")) && (paramObject.length == 0)) {
      return this.protocols;
    }
    if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
    {
      paramObject = (List)paramObject[0];
      int j = paramObject.size();
      int i = 0;
      while (i < j)
      {
        if (this.protocols.contains(paramObject.get(i)))
        {
          paramObject = (String)paramObject.get(i);
          this.selected = paramObject;
          return paramObject;
        }
        i += 1;
      }
      paramObject = (String)this.protocols.get(0);
      this.selected = paramObject;
      return paramObject;
    }
    if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
    {
      this.selected = ((String)paramObject[0]);
      return null;
    }
    return paramMethod.invoke(this, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.internal.platform.JdkWithJettyBootPlatform.JettyNegoProvider
 * JD-Core Version:    0.7.0.1
 */