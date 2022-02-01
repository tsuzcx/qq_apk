package com.tencent.mobileqq.cuckoo;

import android.os.Build.VERSION;
import android.os.Debug;
import com.tencent.mobileqq.warbler.Warbler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cuckoo
{
  private static Map<Integer, MethodCopyOnWriteSet> a = new ConcurrentHashMap();
  private static ClassLoadCallback b = new Cuckoo.1();
  private static Map<Integer, String> c = new ConcurrentHashMap();
  private static String d = "";
  private static boolean e = false;
  private static final Map<String, String> f = new HashMap();
  
  static
  {
    f.put("boolean", "Z");
    f.put("byte", "B");
    f.put("char", "C");
    f.put("short", "S");
    f.put("int", "I");
    f.put("long", "J");
    f.put("float", "F");
    f.put("double", "D");
  }
  
  private static void a(int paramInt, Callback paramCallback)
  {
    MethodCopyOnWriteSet localMethodCopyOnWriteSet;
    if (a.containsKey(Integer.valueOf(paramInt)))
    {
      localMethodCopyOnWriteSet = (MethodCopyOnWriteSet)a.get(Integer.valueOf(paramInt));
      if (localMethodCopyOnWriteSet.a(paramCallback) != -1) {
        throw new IllegalArgumentException("Callback has been registered");
      }
    }
    else
    {
      localMethodCopyOnWriteSet = new MethodCopyOnWriteSet();
    }
    localMethodCopyOnWriteSet.a((MethodCallback)paramCallback);
    a.put(Integer.valueOf(paramInt), localMethodCopyOnWriteSet);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    int i = registMethodByClassNameJNI(paramString1, paramString2, paramString3);
    if (i != -1)
    {
      c.put(Integer.valueOf(i), paramString1);
      a(i, paramCallback);
      return;
    }
    throw new IllegalArgumentException("not find method");
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      boolean bool = e;
      if (bool == true) {
        return;
      }
      if (paramBoolean) {
        Warbler.a();
      }
      System.loadLibrary("cuckoo");
      try
      {
        if (Build.VERSION.SDK_INT >= 28) {
          Debug.attachJvmtiAgent("libcuckoo.so", "", Cuckoo.class.getClassLoader());
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      startCuckoo();
      e = true;
      return;
    }
    finally {}
  }
  
  private static native void destoryClassJNI();
  
  private static native int[] destoryMethodAllByClassNameJNI(String paramString1, String paramString2);
  
  private static native int[] destoryMethodAllJNI(Class paramClass, String paramString);
  
  private static native int destoryMethodByClassNameJNI(String paramString1, String paramString2, String paramString3);
  
  private static native int destoryMethodJNI(Class paramClass, String paramString1, String paramString2);
  
  private static native void registClassJNI();
  
  private static native int[] registMethodAllByClassNameJNI(String paramString1, String paramString2);
  
  private static native int[] registMethodAllJNI(Class paramClass, String paramString);
  
  private static native int registMethodByClassNameJNI(String paramString1, String paramString2, String paramString3);
  
  private static native int registMethodJNI(Class paramClass, String paramString1, String paramString2);
  
  private static native void startCuckoo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.Cuckoo
 * JD-Core Version:    0.7.0.1
 */