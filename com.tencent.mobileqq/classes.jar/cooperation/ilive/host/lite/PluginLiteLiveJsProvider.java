package cooperation.ilive.host.lite;

import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import cooperation.ilive.host.lite.white.IJsAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class PluginLiteLiveJsProvider
  extends LiteLiveJsProvider
{
  private Method mCallFunctionMethod;
  private IJsAdapter mIJsAdapter;
  
  public PluginLiteLiveJsProvider(IJsAdapter paramIJsAdapter)
  {
    this.mIJsAdapter = paramIJsAdapter;
  }
  
  public boolean callFunction(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    try
    {
      if (this.mIJsAdapter != null)
      {
        if (this.mCallFunctionMethod == null) {
          this.mCallFunctionMethod = this.mIJsAdapter.getClass().getMethod("callFunction", new Class[] { String.class, String.class, Map.class });
        }
        boolean bool = ((Boolean)this.mCallFunctionMethod.invoke(this.mIJsAdapter, new Object[] { paramString1, paramString2, paramMap })).booleanValue();
        return bool;
      }
    }
    catch (InvocationTargetException paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    catch (NoSuchMethodException paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void registerJsModule(BaseLiteJSModule paramBaseLiteJSModule) {}
  
  public void removeAllJsModule() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.host.lite.PluginLiteLiveJsProvider
 * JD-Core Version:    0.7.0.1
 */