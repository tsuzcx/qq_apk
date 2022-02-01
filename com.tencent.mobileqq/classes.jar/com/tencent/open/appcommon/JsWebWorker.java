package com.tencent.open.appcommon;

import android.content.Context;
import android.os.Handler;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JsWebWorker
{
  protected static Map<String, JsWebWorker.ReflectClass> a;
  protected static ExecutorService a;
  protected Context a;
  protected Handler a;
  protected WebView a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newCachedThreadPool();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  protected JsWebWorker.ReflectClass a(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initClass ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" | ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" | ");
        ((StringBuilder)localObject1).append(paramString3);
        LogUtility.c("JsWebWorker", ((StringBuilder)localObject1).toString());
        localObject1 = new File(paramString2);
        if (!((File)localObject1).exists())
        {
          paramString1 = new StringBuilder();
          paramString1.append("cant find file ");
          paramString1.append(paramString2);
          LogUtility.c("JsWebWorker", paramString1.toString());
          return null;
        }
        paramString1 = new DexClassLoader(((File)localObject1).toString(), paramString1, null, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
        LogUtility.c("JsWebWorker", "classLoader start ");
        paramString1 = paramString1.loadClass(paramString3);
        LogUtility.c("JsWebWorker", "classLoader successed ");
        paramString2 = new JsWebWorker.ReflectClass(this);
        localObject1 = paramString1.getDeclaredMethods();
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if (Modifier.isPublic(localObject2.getModifiers())) {
            paramString2.b.put(localObject2.getName(), localObject2);
          }
        }
        else
        {
          paramString2.jdField_a_of_type_JavaLangString = paramString3;
          paramString2.jdField_a_of_type_JavaLangClass = paramString1;
          jdField_a_of_type_JavaUtilMap.put(paramString3, paramString2);
          return paramString2;
        }
      }
      catch (Exception paramString1)
      {
        LogUtility.c("JsWebWorker", "initClass error", paramString1);
        return null;
      }
      i += 1;
    }
  }
  
  protected Object a(JsWebWorker.ReflectClass paramReflectClass, Context paramContext, WebView paramWebView)
  {
    int i = -1000;
    if (paramWebView != null) {}
    try
    {
      i = paramWebView.hashCode();
      Object localObject2 = paramReflectClass.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Constructor localConstructor = paramReflectClass.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class, WebView.class, Handler.class });
        localObject1 = localObject2;
        if (localConstructor != null)
        {
          localObject1 = localConstructor.newInstance(new Object[] { paramContext, paramWebView, this.jdField_a_of_type_AndroidOsHandler });
          paramReflectClass.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject1);
        }
      }
      return localObject1;
    }
    catch (Exception paramReflectClass)
    {
      label123:
      break label123;
    }
    return null;
  }
  
  protected String a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invoke>>");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(">>>");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(">>>");
      ((StringBuilder)localObject).append(paramString3);
      LogUtility.c("JsWebWorker", ((StringBuilder)localObject).toString());
      JsWebWorker.ReflectClass localReflectClass = (JsWebWorker.ReflectClass)jdField_a_of_type_JavaUtilMap.get(paramString2);
      localObject = localReflectClass;
      if (localReflectClass == null) {
        localObject = a(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath(), paramString1, paramString2);
      }
      if (localObject == null)
      {
        LogUtility.c("JsWebWorker", "refC == NULL return");
        return null;
      }
      LogUtility.c("JsWebWorker", "got refC");
      if ((Method)((JsWebWorker.ReflectClass)localObject).b.get(paramString3) == null)
      {
        ((JsWebWorker.ReflectClass)localObject).a();
        if (a(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath(), paramString1, paramString2) == null)
        {
          LogUtility.c("JsWebWorker", "cant find method and refC == NULL return");
          return null;
        }
      }
      else
      {
        LogUtility.c("JsWebWorker", "get method");
        paramString1 = (Method)((JsWebWorker.ReflectClass)localObject).b.get(paramString3);
        if (paramString1 == null) {
          return null;
        }
        LogUtility.c("JsWebWorker", "got method");
        paramString2 = a((JsWebWorker.ReflectClass)localObject, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView);
        if (paramString2 == null) {
          return null;
        }
        LogUtility.c("JsWebWorker", "method invoke");
        paramString1 = (String)paramString1.invoke(paramString2, new Object[] { paramArrayOfString });
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      LogUtility.c("JsWebWorker", "invoke error", paramString1);
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.JsWebWorker
 * JD-Core Version:    0.7.0.1
 */