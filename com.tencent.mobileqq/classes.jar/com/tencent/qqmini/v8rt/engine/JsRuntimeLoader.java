package com.tencent.qqmini.v8rt.engine;

import android.text.TextUtils;
import java.io.File;

public class JsRuntimeLoader
{
  public static final String[] BASIC_JS = { "console.js", "timer.js" };
  static final String CLEAN_GLOBAL = "(function () {\nvar tt = global.__ttObjdec__;\n  if (tt && tt.Triton == undefined) {\n    tt.Triton = Triton;//存到__ttObjdec__中去，保证JSSDK可以使用它\n    try {\n      Triton = undefined;//将其从全局作用域干掉，使得业务代码不能访问\n    } catch (error) {\n    }\n  }\n})();";
  public static final String CODE_CACHE_SUFFIX = ".cc";
  static final String GLOBAL_CONFIG = "self = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = self.__ttObjdec__ || {};\nself.wx = self.wx || {};\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {}\n__wxConfig.env.USER_DATA_PATH = \"wxfile://usr\";\n__wxConfig.platform = \"android\";\nwx.env = __wxConfig.env;\n";
  public static final String LOG_TAG = "JsRuntimeLoader";
  private static final String __FILESYSTEM_PREFIX__ = "wxfile://";
  
  static void cleanGlobal(V8JsContext paramV8JsContext)
  {
    if (!TextUtils.isEmpty("(function () {\nvar tt = global.__ttObjdec__;\n  if (tt && tt.Triton == undefined) {\n    tt.Triton = Triton;//存到__ttObjdec__中去，保证JSSDK可以使用它\n    try {\n      Triton = undefined;//将其从全局作用域干掉，使得业务代码不能访问\n    } catch (error) {\n    }\n  }\n})();"))
    {
      paramV8JsContext.evaluateJsSync("(function () {\nvar tt = global.__ttObjdec__;\n  if (tt && tt.Triton == undefined) {\n    tt.Triton = Triton;//存到__ttObjdec__中去，保证JSSDK可以使用它\n    try {\n      Triton = undefined;//将其从全局作用域干掉，使得业务代码不能访问\n    } catch (error) {\n    }\n  }\n})();");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanGlobalEnv ");
      localStringBuilder.append(paramV8JsContext);
      Logger.i("JsRuntimeLoader", localStringBuilder.toString());
    }
  }
  
  static boolean initDefaultContext(EnginePathProvider paramEnginePathProvider, V8JsContext paramV8JsContext)
  {
    injectGlobalConfig(paramV8JsContext);
    injectBasicJsForContext(paramEnginePathProvider, paramV8JsContext);
    return true;
  }
  
  static void injectBasicJs(EnginePathProvider paramEnginePathProvider, String[] paramArrayOfString, V8JsContext paramV8JsContext)
  {
    if (paramArrayOfString == null) {
      return;
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayOfString[i];
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramEnginePathProvider.getEngineJSDir());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("engine_base_");
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(".cc");
      localObject3 = ((StringBuilder)localObject3).toString();
      int k = Engine.loadScriptPathWithCodeCache(paramV8JsContext.getV8JsRuntime().getId(), paramV8JsContext.getContextId(), (String)localObject1, (String)localObject2, (String)localObject3);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("inject ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(paramV8JsContext);
      ((StringBuilder)localObject2).append(",ccstat:");
      ((StringBuilder)localObject2).append(k);
      Logger.i("JsRuntimeLoader", ((StringBuilder)localObject2).toString());
      i += 1;
    }
  }
  
  private static void injectBasicJsForContext(EnginePathProvider paramEnginePathProvider, V8JsContext paramV8JsContext)
  {
    injectBasicJs(paramEnginePathProvider, BASIC_JS, paramV8JsContext);
  }
  
  static void injectGlobalConfig(V8JsContext paramV8JsContext)
  {
    if (!TextUtils.isEmpty("self = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = self.__ttObjdec__ || {};\nself.wx = self.wx || {};\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {}\n__wxConfig.env.USER_DATA_PATH = \"wxfile://usr\";\n__wxConfig.platform = \"android\";\nwx.env = __wxConfig.env;\n"))
    {
      paramV8JsContext.evaluateJsSync("self = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = self.__ttObjdec__ || {};\nself.wx = self.wx || {};\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {}\n__wxConfig.env.USER_DATA_PATH = \"wxfile://usr\";\n__wxConfig.platform = \"android\";\nwx.env = __wxConfig.env;\n");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("injectGlobalConfig ");
      localStringBuilder.append(paramV8JsContext);
      Logger.i("JsRuntimeLoader", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.JsRuntimeLoader
 * JD-Core Version:    0.7.0.1
 */