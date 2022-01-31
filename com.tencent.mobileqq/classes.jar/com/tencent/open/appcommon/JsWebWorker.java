package com.tencent.open.appcommon;

import android.content.Context;
import android.os.Handler;
import bfem;
import bfhg;
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
  protected static Map<String, bfem> a;
  protected static ExecutorService a;
  protected Context a;
  protected Handler a;
  protected WebView a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newCachedThreadPool();
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  protected bfem a(String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      int i;
      try
      {
        bfhg.c("JsWebWorker", "initClass " + paramString1 + " | " + paramString2 + " | " + paramString3);
        Object localObject1 = new File(paramString2);
        if (!((File)localObject1).exists())
        {
          bfhg.c("JsWebWorker", "cant find file " + paramString2);
          return null;
        }
        paramString1 = new DexClassLoader(((File)localObject1).toString(), paramString1, null, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
        bfhg.c("JsWebWorker", "classLoader start ");
        paramString1 = paramString1.loadClass(paramString3);
        bfhg.c("JsWebWorker", "classLoader successed ");
        paramString2 = new bfem(this);
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
        bfhg.c("JsWebWorker", "initClass error", paramString1);
        return null;
      }
      i += 1;
    }
  }
  
  protected Object a(bfem parambfem, Context paramContext, WebView paramWebView)
  {
    if (paramWebView != null) {}
    for (;;)
    {
      try
      {
        i = paramWebView.hashCode();
        Object localObject2 = parambfem.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          Constructor localConstructor = parambfem.jdField_a_of_type_JavaLangClass.getConstructor(new Class[] { Context.class, WebView.class, Handler.class });
          localObject1 = localObject2;
          if (localConstructor != null)
          {
            localObject1 = localConstructor.newInstance(new Object[] { paramContext, paramWebView, this.jdField_a_of_type_AndroidOsHandler });
            parambfem.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), localObject1);
          }
        }
        return localObject1;
      }
      catch (Exception parambfem)
      {
        return null;
      }
      int i = -1000;
    }
  }
  
  protected String a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        bfhg.c("JsWebWorker", "invoke>>" + paramString1 + ">>>" + paramString2 + ">>>" + paramString3);
        bfem localbfem = (bfem)jdField_a_of_type_JavaUtilMap.get(paramString2);
        if (localbfem == null)
        {
          localbfem = a(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath(), paramString1, paramString2);
          if (localbfem == null)
          {
            bfhg.c("JsWebWorker", "refC == NULL return");
            return null;
          }
          bfhg.c("JsWebWorker", "got refC");
          if ((Method)localbfem.b.get(paramString3) == null)
          {
            localbfem.a();
            if (a(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath(), paramString1, paramString2) != null) {
              break;
            }
            bfhg.c("JsWebWorker", "cant find method and refC == NULL return");
            break;
          }
          bfhg.c("JsWebWorker", "get method");
          paramString1 = (Method)localbfem.b.get(paramString3);
          if (paramString1 == null) {
            return null;
          }
          bfhg.c("JsWebWorker", "got method");
          paramString2 = a(localbfem, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentSmttSdkWebView);
          if (paramString2 == null) {
            return null;
          }
          bfhg.c("JsWebWorker", "method invoke");
          paramString1 = (String)paramString1.invoke(paramString2, new Object[] { paramArrayOfString });
          return paramString1;
        }
      }
      catch (Exception paramString1)
      {
        bfhg.c("JsWebWorker", "invoke error", paramString1);
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.JsWebWorker
 * JD-Core Version:    0.7.0.1
 */