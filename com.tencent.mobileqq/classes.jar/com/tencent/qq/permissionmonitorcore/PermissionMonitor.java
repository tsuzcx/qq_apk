package com.tencent.qq.permissionmonitorcore;

import android.os.Debug;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionMonitor
{
  private static final String TAG = "PermissionMonitor";
  private String[] mClassNames;
  private PermissionMonitor.Listener[] mListeners;
  private String[] mMethodNames;
  private Method[] mMethods;
  private String[] mSigs;
  
  static
  {
    if (!PermissionMonitor.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private void dispatchMethodEntry(List<PermissionMonitor.Listener> paramList, String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((PermissionMonitor.Listener)paramList.next()).onMethodEntry(paramString1, paramString2, paramString3, paramArrayOfObject);
    }
  }
  
  private List<PermissionMonitor.Listener> findReceivers(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.mMethodNames.length)
    {
      if ((paramString2.equals(this.mMethodNames[i])) && (this.mSigs[i].equals(paramString3)) && (("L" + this.mClassNames[i] + ";").equals(paramString1))) {
        localArrayList.add(this.mListeners[i]);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private Class[] getClasses(String paramString)
  {
    int n = 0;
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    int m = 0;
    if (k < paramString.length())
    {
      int j = k;
      i = m;
      switch (paramString.charAt(k))
      {
      default: 
        i = m;
        j = k;
      }
      for (;;)
      {
        k = j + 1;
        m = i;
        break;
        if (m != 0)
        {
          localArrayList.add([B.class);
          i = 0;
          j = k;
        }
        else
        {
          localArrayList.add(Byte.TYPE);
          j = k;
          i = m;
          continue;
          if (m != 0)
          {
            localArrayList.add([C.class);
            i = 0;
            j = k;
          }
          else
          {
            localArrayList.add(Character.TYPE);
            j = k;
            i = m;
            continue;
            if (m != 0)
            {
              localArrayList.add([Z.class);
              i = 0;
              j = k;
            }
            else
            {
              localArrayList.add(Boolean.TYPE);
              j = k;
              i = m;
              continue;
              if (m != 0)
              {
                localArrayList.add([S.class);
                i = 0;
                j = k;
              }
              else
              {
                localArrayList.add(Short.TYPE);
                j = k;
                i = m;
                continue;
                if (m != 0)
                {
                  localArrayList.add([I.class);
                  i = 0;
                  j = k;
                }
                else
                {
                  localArrayList.add(Integer.TYPE);
                  j = k;
                  i = m;
                  continue;
                  if (m != 0)
                  {
                    localArrayList.add([J.class);
                    i = 0;
                    j = k;
                  }
                  else
                  {
                    localArrayList.add(Long.TYPE);
                    j = k;
                    i = m;
                    continue;
                    if (m != 0)
                    {
                      localArrayList.add([F.class);
                      i = 0;
                      j = k;
                    }
                    else
                    {
                      localArrayList.add(Float.TYPE);
                      j = k;
                      i = m;
                      continue;
                      if (m != 0)
                      {
                        localArrayList.add([D.class);
                        i = 0;
                        j = k;
                      }
                      else
                      {
                        localArrayList.add(Double.TYPE);
                        j = k;
                        i = m;
                        continue;
                        if (m != 0)
                        {
                          j = paramString.indexOf(';', k);
                          localArrayList.add([Ljava.lang.Object.class);
                          i = m;
                        }
                        else
                        {
                          j = paramString.indexOf(';', k);
                          String str = paramString.substring(k + 1, j);
                          try
                          {
                            localArrayList.add(Class.forName(str.replace('/', '.')));
                            i = m;
                          }
                          catch (ClassNotFoundException localClassNotFoundException)
                          {
                            for (;;)
                            {
                              localClassNotFoundException.printStackTrace();
                            }
                          }
                          i = 1;
                          j = k;
                          continue;
                          j = paramString.length();
                          i = m;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    paramString = new Class[localArrayList.size()];
    int i = n;
    while (i < paramString.length)
    {
      paramString[i] = ((Class)localArrayList.get(i));
      i += 1;
    }
    return paramString;
  }
  
  public static PermissionMonitor getInstance()
  {
    return PermissionMonitor.Holder.access$000();
  }
  
  private Method getMethod(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
      localMethod.setAccessible(true);
      paramString3 = getClasses(paramString3);
      paramString1 = (Method)localMethod.invoke(Class.forName(paramString1.replace('/', '.')), new Object[] { paramString2, paramString3 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private native void nStart(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, Method[] paramArrayOfMethod);
  
  public static void onMethodEntry(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    getInstance().onMethodEntryInternal(paramString1, paramString2, paramString3, paramArrayOfObject);
  }
  
  private void onMethodEntryInternal(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
  {
    try
    {
      dispatchMethodEntry(findReceivers(paramString1, paramString2, paramString3), paramString1, paramString2, paramString3, paramArrayOfObject);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public PermissionMonitor config(PermissionMonitor.Listener[] paramArrayOfListener, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
  {
    try
    {
      if ((!$assertionsDisabled) && (paramArrayOfListener.length != paramArrayOfString1.length)) {
        throw new AssertionError();
      }
    }
    finally {}
    assert (paramArrayOfString1.length == paramArrayOfString2.length);
    assert (paramArrayOfString2.length == paramArrayOfString3.length);
    this.mListeners = paramArrayOfListener;
    this.mClassNames = paramArrayOfString1;
    this.mMethodNames = paramArrayOfString2;
    this.mSigs = paramArrayOfString3;
    return this;
  }
  
  public void start()
  {
    try
    {
      System.loadLibrary("permission-monitor");
      try
      {
        Debug.attachJvmtiAgent("libpermission-monitor.so", "", getClass().getClassLoader());
        this.mMethods = new Method[this.mMethodNames.length];
        int i = 0;
        while (i < this.mMethods.length)
        {
          Method localMethod = getMethod(this.mClassNames[i], this.mMethodNames[i], this.mSigs[i]);
          this.mMethods[i] = localMethod;
          i += 1;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
      nStart(this.mClassNames, this.mMethodNames, this.mSigs, this.mMethods);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.permissionmonitorcore.PermissionMonitor
 * JD-Core Version:    0.7.0.1
 */