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
    for (;;)
    {
      Object localObject = this.mMethodNames;
      if (i >= localObject.length) {
        break;
      }
      if ((paramString2.equals(localObject[i])) && (this.mSigs[i].equals(paramString3)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("L");
        ((StringBuilder)localObject).append(this.mClassNames[i]);
        ((StringBuilder)localObject).append(";");
        if (((StringBuilder)localObject).toString().equals(paramString1)) {
          localArrayList.add(this.mListeners[i]);
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private Class[] getClasses(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    int j = 0;
    int k;
    for (int m = 0; j < paramString.length(); m = k)
    {
      int i1 = paramString.charAt(j);
      i = j;
      k = m;
      if (i1 != 40) {
        if (i1 != 41)
        {
          if (i1 != 70) {
            if (i1 != 76) {
              if (i1 != 83) {
                if (i1 != 73) {
                  if (i1 != 74) {
                    if (i1 != 90) {
                      if (i1 != 91) {
                        switch (i1)
                        {
                        default: 
                          i = j;
                          k = m;
                          break;
                        case 68: 
                          if (m != 0)
                          {
                            localArrayList.add([D.class);
                          }
                          else
                          {
                            localArrayList.add(Double.TYPE);
                            i = j;
                            k = m;
                          }
                          break;
                        case 67: 
                          if (m != 0)
                          {
                            localArrayList.add([C.class);
                          }
                          else
                          {
                            localArrayList.add(Character.TYPE);
                            i = j;
                            k = m;
                          }
                          break;
                        case 66: 
                          if (m != 0) {
                            localArrayList.add([B.class);
                          }
                          break;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            k = 0;
            i = j;
            break label548;
            localArrayList.add(Byte.TYPE);
            i = j;
            k = m;
            break label548;
            k = 1;
            i = j;
            break label548;
            if (m != 0)
            {
              localArrayList.add([Z.class);
            }
            else
            {
              localArrayList.add(Boolean.TYPE);
              i = j;
              k = m;
              break label548;
              if (m != 0)
              {
                localArrayList.add([J.class);
              }
              else
              {
                localArrayList.add(Long.TYPE);
                i = j;
                k = m;
                break label548;
                if (m != 0)
                {
                  localArrayList.add([I.class);
                }
                else
                {
                  localArrayList.add(Integer.TYPE);
                  i = j;
                  k = m;
                  break label548;
                  if (m != 0)
                  {
                    localArrayList.add([S.class);
                  }
                  else
                  {
                    localArrayList.add(Short.TYPE);
                    i = j;
                    k = m;
                    break label548;
                    if (m != 0)
                    {
                      i = paramString.indexOf(';', j);
                      localArrayList.add([Ljava.lang.Object.class);
                      k = m;
                      break label548;
                    }
                    i = paramString.indexOf(';', j);
                    String str = paramString.substring(j + 1, i);
                    try
                    {
                      localArrayList.add(Class.forName(str.replace('/', '.')));
                    }
                    catch (ClassNotFoundException localClassNotFoundException)
                    {
                      localClassNotFoundException.printStackTrace();
                    }
                    k = m;
                    break label548;
                    if (m == 0) {
                      break;
                    }
                    localArrayList.add([F.class);
                  }
                }
              }
            }
          }
          localArrayList.add(Float.TYPE);
          i = j;
          k = m;
        }
        else
        {
          i = paramString.length();
          k = m;
        }
      }
      label548:
      j = i + 1;
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
      this.mListeners = paramArrayOfListener;
      this.mClassNames = paramArrayOfString1;
      this.mMethodNames = paramArrayOfString2;
      this.mSigs = paramArrayOfString3;
      return this;
    }
    finally
    {
      paramArrayOfListener = finally;
      throw paramArrayOfListener;
    }
  }
  
  public void start()
  {
    try
    {
      System.loadLibrary("permission-monitor");
      try
      {
        Debug.attachJvmtiAgent("libpermission-monitor.so", "", getClass().getClassLoader());
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      this.mMethods = new Method[this.mMethodNames.length];
      int i = 0;
      while (i < this.mMethods.length)
      {
        Method localMethod = getMethod(this.mClassNames[i], this.mMethodNames[i], this.mSigs[i]);
        this.mMethods[i] = localMethod;
        i += 1;
      }
      nStart(this.mClassNames, this.mMethodNames, this.mSigs, this.mMethods);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.permissionmonitorcore.PermissionMonitor
 * JD-Core Version:    0.7.0.1
 */