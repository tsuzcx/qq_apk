package com.tencent.mobileqq.cmshow.brickengine.apollo.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SavaNativeMethodUtil
{
  private static List<Class> a(String paramString, StringBuilder paramStringBuilder)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = paramString.length();
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      int k = paramString.charAt(j);
      if (41 == k) {
        return localArrayList;
      }
      if (k != 70) {
        if (k != 76) {
          if (k != 83) {
            if (k != 86) {
              if (k != 73) {
                if (k != 74) {
                  if (k != 90) {
                    if (k != 91) {
                      switch (k)
                      {
                      default: 
                        break;
                      case 68: 
                        if (i != 0) {
                          localArrayList.add([D.class);
                        } else {
                          localArrayList.add(Double.TYPE);
                        }
                        break;
                      case 67: 
                        if (i != 0) {
                          localArrayList.add([C.class);
                        } else {
                          localArrayList.add(Character.TYPE);
                        }
                        break;
                      case 66: 
                        if (i != 0) {
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
      }
      for (;;)
      {
        i = 0;
        break label570;
        localArrayList.add(Byte.TYPE);
        break label570;
        i = 1;
        break label570;
        if (i != 0)
        {
          localArrayList.add([Z.class);
        }
        else
        {
          localArrayList.add(Boolean.TYPE);
          break label570;
          if (i != 0)
          {
            localArrayList.add([J.class);
          }
          else
          {
            localArrayList.add(Long.TYPE);
            break label570;
            if (i != 0)
            {
              localArrayList.add([I.class);
            }
            else
            {
              localArrayList.add(Integer.TYPE);
              break label570;
              localArrayList.add(Void.TYPE);
              break label570;
              if (i != 0)
              {
                localArrayList.add([S.class);
              }
              else
              {
                localArrayList.add(Short.TYPE);
                break label570;
                int n = j + 1;
                j = k;
                k = n;
                while ((k < i1) && (j != 59))
                {
                  k += 1;
                  j = paramString.charAt(k);
                }
                int m = i;
                try
                {
                  Object localObject = paramString.substring(n, k);
                  m = i;
                  paramStringBuilder.append("clsName:");
                  m = i;
                  paramStringBuilder.append((String)localObject);
                  m = i;
                  paramStringBuilder.append(",");
                  m = i;
                  String str = ((String)localObject).replace('/', '.');
                  localObject = str;
                  j = i;
                  if (i != 0)
                  {
                    m = i;
                    localObject = new StringBuilder();
                    m = i;
                    ((StringBuilder)localObject).append("[L");
                    m = i;
                    ((StringBuilder)localObject).append(str);
                    m = i;
                    ((StringBuilder)localObject).append(";");
                    m = i;
                    localObject = ((StringBuilder)localObject).toString();
                    j = 0;
                  }
                  m = j;
                  localArrayList.add(Class.forName((String)localObject));
                  i = j;
                }
                catch (Throwable localThrowable)
                {
                  QLog.e("[cmshow]SavaNativeMethodUtil", 1, localThrowable, new Object[0]);
                  i = m;
                }
                j = k;
                break label570;
                if (i == 0) {
                  break;
                }
                localArrayList.add([F.class);
              }
            }
          }
        }
      }
      localArrayList.add(Float.TYPE);
      label570:
      j += 1;
    }
    return localArrayList;
  }
  
  public static boolean a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]SavaNativeMethodUtil", 2, new Object[] { "[isJavaMethodExist], name:", paramString1, ",classType:", Integer.valueOf(paramInt), "paramType:", paramString2 });
    }
    long l = System.currentTimeMillis();
    Object localObject;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      localObject = null;
      if (1 != paramInt) {
        break label245;
      }
      localObject = ApolloRender.class;
    }
    for (;;)
    {
      if (localObject == null) {}
      try
      {
        QLog.w("[cmshow]SavaNativeMethodUtil", 2, "unknown class type.");
        return false;
      }
      catch (Throwable localThrowable)
      {
        break label193;
      }
      localObject = ((Class)localObject).getDeclaredMethod(paramString1, a(paramString2)).getReturnType();
      paramString2 = b(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]SavaNativeMethodUtil", 2, new Object[] { "reflect cost:", Long.valueOf(System.currentTimeMillis() - l) });
      }
      if ((localObject != null) && (paramString2 != null) && (((Class)localObject).getName() != null) && (((Class)localObject).getName().equals(paramString2.getName()))) {
        return true;
      }
      QLog.w("[cmshow]SavaNativeMethodUtil", 1, "method NOT exists, different return type");
      return false;
      label193:
      paramString2 = new StringBuilder();
      paramString2.append("method NOT exists, name:");
      paramString2.append(paramString1);
      paramString2.append(",");
      paramString2.append(localObject);
      QLog.e("[cmshow]SavaNativeMethodUtil", 1, paramString2.toString());
      return false;
      label245:
      if (2 == paramInt) {
        ApolloCmdChannel localApolloCmdChannel = ApolloCmdChannel.class;
      }
    }
  }
  
  public static Class[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (TextUtils.isEmpty(paramString.trim())) {
      return null;
    }
    Object localObject = new StringBuilder();
    paramString = a(paramString, (StringBuilder)localObject);
    int j = ((StringBuilder)localObject).length();
    int i = 0;
    if ((j > 0) && (QLog.isColorLevel())) {
      QLog.d("[cmshow]SavaNativeMethodUtil", 2, new Object[] { "paramList clsList:", ((StringBuilder)localObject).toString() });
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new Class[paramString.size()];
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      localObject[i] = ((Class)paramString.next());
      i += 1;
    }
    return localObject;
  }
  
  private static Class b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      int i = paramString.indexOf(')');
      if (-1 == i) {
        return null;
      }
      paramString = a(paramString.substring(i + 1));
      if ((paramString != null) && (paramString.length != 0))
      {
        paramString = paramString[0];
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("[cmshow]SavaNativeMethodUtil", 1, paramString, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.utils.SavaNativeMethodUtil
 * JD-Core Version:    0.7.0.1
 */