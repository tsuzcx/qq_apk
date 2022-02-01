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
  private static ClassLoadCallback jdField_a_of_type_ComTencentMobileqqCuckooClassLoadCallback;
  private static String jdField_a_of_type_JavaLangString;
  private static Map<Integer, MethodCopyOnWriteSet> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private static Map<Integer, String> b;
  private static final Map<String, String> c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCuckooClassLoadCallback = new Cuckoo.1();
    b = new ConcurrentHashMap();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_Boolean = false;
    c = new HashMap();
    c.put("boolean", "Z");
    c.put("byte", "B");
    c.put("char", "C");
    c.put("short", "S");
    c.put("int", "I");
    c.put("long", "J");
    c.put("float", "F");
    c.put("double", "D");
  }
  
  private static void a(int paramInt, Callback paramCallback)
  {
    MethodCopyOnWriteSet localMethodCopyOnWriteSet;
    if (jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt)))
    {
      localMethodCopyOnWriteSet = (MethodCopyOnWriteSet)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localMethodCopyOnWriteSet.a(paramCallback) != -1) {
        throw new IllegalArgumentException("Callback has been registered");
      }
    }
    else
    {
      localMethodCopyOnWriteSet = new MethodCopyOnWriteSet();
    }
    localMethodCopyOnWriteSet.a((MethodCallback)paramCallback);
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localMethodCopyOnWriteSet);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, Callback paramCallback)
  {
    int i = registMethodByClassNameJNI(paramString1, paramString2, paramString3);
    if (i != -1)
    {
      b.put(Integer.valueOf(i), paramString1);
      a(i, paramCallback);
      return;
    }
    throw new IllegalArgumentException("not find method");
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      boolean bool = jdField_a_of_type_Boolean;
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
      jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.Cuckoo
 * JD-Core Version:    0.7.0.1
 */