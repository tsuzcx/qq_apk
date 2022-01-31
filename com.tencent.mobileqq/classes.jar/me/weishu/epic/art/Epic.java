package me.weishu.epic.art;

import android.os.Build.VERSION;
import com.qq.android.dexposed.utility.Debug;
import com.qq.android.dexposed.utility.Logger;
import com.qq.android.dexposed.utility.Runtime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.weishu.epic.art.arch.Arm64_2;
import me.weishu.epic.art.arch.ShellCode;
import me.weishu.epic.art.arch.Thumb2;
import me.weishu.epic.art.method.ArtMethod;

public final class Epic
{
  private static ShellCode ShellCode;
  private static final String TAG = "Epic";
  private static final Map<String, ArtMethod> backupMethodsMapping = new ConcurrentHashMap();
  private static final Map<Long, Epic.MethodInfo> originSigs = new ConcurrentHashMap();
  private static final Map<Long, Trampoline> scripts = new HashMap();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (Runtime.is64Bit()) {
      switch (i)
      {
      }
    }
    while (ShellCode == null)
    {
      throw new RuntimeException("Do not support this ARCH now!! API LEVEL:" + i);
      ShellCode = new Arm64_2();
      continue;
      ShellCode = new Arm64_2();
      continue;
      if (Runtime.isThumb2()) {
        ShellCode = new Thumb2();
      } else {
        Logger.w("Epic", "ARM32, not support now.");
      }
    }
    Logger.i("Epic", "Using: " + ShellCode.getName());
  }
  
  public static ArtMethod getBackMethod(ArtMethod paramArtMethod)
  {
    try
    {
      paramArtMethod = paramArtMethod.getIdentifier();
      paramArtMethod = (ArtMethod)backupMethodsMapping.get(paramArtMethod);
      return paramArtMethod;
    }
    finally
    {
      paramArtMethod = finally;
      throw paramArtMethod;
    }
  }
  
  public static Epic.MethodInfo getMethodInfo(long paramLong)
  {
    return (Epic.MethodInfo)originSigs.get(Long.valueOf(paramLong));
  }
  
  public static int getQuickCompiledCodeSize(ArtMethod paramArtMethod)
  {
    int i = ByteBuffer.wrap(EpicNative.get(ShellCode.toMem(paramArtMethod.getEntryPointFromQuickCompiledCode()) - 4L, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    Logger.d("Epic", "getQuickCompiledCodeSize: " + i);
    return i;
  }
  
  public static boolean hookMethod(Constructor paramConstructor)
  {
    return hookMethod(ArtMethod.of(paramConstructor));
  }
  
  public static boolean hookMethod(Method paramMethod)
  {
    return hookMethod(ArtMethod.of(paramMethod));
  }
  
  private static boolean hookMethod(ArtMethod paramArtMethod)
  {
    ??? = new Epic.MethodInfo();
    ((Epic.MethodInfo)???).isStatic = Modifier.isStatic(paramArtMethod.getModifiers());
    Class[] arrayOfClass = paramArtMethod.getParameterTypes();
    if (arrayOfClass != null)
    {
      ((Epic.MethodInfo)???).paramNumber = arrayOfClass.length;
      ((Epic.MethodInfo)???).paramTypes = arrayOfClass;
    }
    for (;;)
    {
      ((Epic.MethodInfo)???).returnType = paramArtMethod.getReturnType();
      ((Epic.MethodInfo)???).method = paramArtMethod;
      originSigs.put(Long.valueOf(paramArtMethod.getAddress()), ???);
      if (!paramArtMethod.isAccessible()) {
        paramArtMethod.setAccessible(true);
      }
      paramArtMethod.ensureResolved();
      long l2 = paramArtMethod.getEntryPointFromQuickCompiledCode();
      long l1 = l2;
      if (l2 == ArtMethod.getQuickToInterpreterBridge())
      {
        Logger.i("Epic", "this method is not compiled, compile it now. current entry: 0x" + Long.toHexString(l2));
        if (paramArtMethod.compile())
        {
          l1 = paramArtMethod.getEntryPointFromQuickCompiledCode();
          Logger.i("Epic", "compile method success, new entry: 0x" + Long.toHexString(l1));
        }
      }
      else
      {
        ??? = paramArtMethod.backup();
        Logger.i("Epic", "backup method address:" + Debug.addrHex(((ArtMethod)???).getAddress()));
        Logger.i("Epic", "backup method entry :" + Debug.addrHex(((ArtMethod)???).getEntryPointFromQuickCompiledCode()));
        if (getBackMethod(paramArtMethod) == null) {
          setBackMethod(paramArtMethod, (ArtMethod)???);
        }
      }
      synchronized (Epic.EntryLock.obtain(l1))
      {
        if (!scripts.containsKey(Long.valueOf(l1))) {
          scripts.put(Long.valueOf(l1), new Trampoline(ShellCode, l1));
        }
        boolean bool = ((Trampoline)scripts.get(Long.valueOf(l1))).install(paramArtMethod);
        return bool;
        ((Epic.MethodInfo)???).paramNumber = 0;
        ((Epic.MethodInfo)???).paramTypes = new Class[0];
        continue;
        Logger.e("Epic", "compile method failed...");
        return false;
      }
    }
  }
  
  public static void setBackMethod(ArtMethod paramArtMethod1, ArtMethod paramArtMethod2)
  {
    try
    {
      paramArtMethod1 = paramArtMethod1.getIdentifier();
      backupMethodsMapping.put(paramArtMethod1, paramArtMethod2);
      return;
    }
    finally
    {
      paramArtMethod1 = finally;
      throw paramArtMethod1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.weishu.epic.art.Epic
 * JD-Core Version:    0.7.0.1
 */