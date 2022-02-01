package me.weishu.epic.art.entry;

import com.qq.android.dexposed.DexposedBridge;
import com.qq.android.dexposed.XposedHelpers;
import com.qq.android.dexposed.utility.Logger;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.Epic.MethodInfo;
import me.weishu.epic.art.EpicNative;

public class Entry64
{
  private static final String TAG = "Entry64";
  private static Map<Class<?>, String> bridgeMethodMap = new HashMap();
  
  static
  {
    Class[] arrayOfClass = new Class[8];
    Class localClass = Boolean.TYPE;
    int i = 0;
    arrayOfClass[0] = localClass;
    arrayOfClass[1] = Byte.TYPE;
    arrayOfClass[2] = Character.TYPE;
    arrayOfClass[3] = Short.TYPE;
    arrayOfClass[4] = Integer.TYPE;
    arrayOfClass[5] = Long.TYPE;
    arrayOfClass[6] = Float.TYPE;
    arrayOfClass[7] = Double.TYPE;
    int j = arrayOfClass.length;
    for (;;)
    {
      if (i >= j)
      {
        bridgeMethodMap.put(Void.TYPE, "voidBridge");
        bridgeMethodMap.put(Object.class, "referenceBridge");
        return;
      }
      localClass = arrayOfClass[i];
      Map localMap = bridgeMethodMap;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localClass.getName()));
      localStringBuilder.append("Bridge");
      localMap.put(localClass, localStringBuilder.toString());
      i += 1;
    }
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).booleanValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).byteValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).charValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).doubleValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).floatValue();
  }
  
  public static Method getBridgeMethod(Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        Object localObject = bridgeMethodMap;
        if (paramClass.isPrimitive())
        {
          paramClass = (String)((Map)localObject).get(paramClass);
          localObject = new StringBuilder("bridge method:");
          ((StringBuilder)localObject).append(paramClass);
          ((StringBuilder)localObject).append(", map:");
          ((StringBuilder)localObject).append(bridgeMethodMap);
          Logger.d("Entry64", ((StringBuilder)localObject).toString());
          paramClass = Entry64.class.getDeclaredMethod(paramClass, new Class[] { Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE, Long.TYPE });
          paramClass.setAccessible(true);
          return paramClass;
        }
      }
      catch (Throwable paramClass)
      {
        throw new RuntimeException("error", paramClass);
      }
      paramClass = Object.class;
    }
  }
  
  private static int intBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).intValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).longValue();
  }
  
  private static boolean onHookBoolean(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Boolean)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).booleanValue();
  }
  
  private static byte onHookByte(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Byte)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).byteValue();
  }
  
  private static char onHookChar(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Character)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).charValue();
  }
  
  private static double onHookDouble(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Double)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).doubleValue();
  }
  
  private static float onHookFloat(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Float)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).floatValue();
  }
  
  private static int onHookInt(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Integer)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).intValue();
  }
  
  private static long onHookLong(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Long)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).longValue();
  }
  
  private static Object onHookObject(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
  }
  
  private static short onHookShort(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return ((Short)DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject)).shortValue();
  }
  
  private static void onHookVoid(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    Logger.i("Entry64", "enter bridge function.");
    Object localObject1 = new StringBuilder("self:");
    ((StringBuilder)localObject1).append(Long.toHexString(paramLong2));
    Logger.d("Entry64", ((StringBuilder)localObject1).toString());
    paramLong2 = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
    localObject1 = new StringBuilder("java thread native peer:");
    ((StringBuilder)localObject1).append(Long.toHexString(paramLong2));
    Logger.d("Entry64", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder("struct:");
    ((StringBuilder)localObject1).append(Long.toHexString(paramLong3));
    Logger.d("Entry64", ((StringBuilder)localObject1).toString());
    long l = ByteBuffer.wrap(EpicNative.get(paramLong3, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    localObject1 = new StringBuilder("stack:");
    ((StringBuilder)localObject1).append(l);
    Logger.d("Entry64", ((StringBuilder)localObject1).toString());
    localObject1 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong1).array();
    Object localObject4 = EpicNative.get(paramLong3 + 8L, 8);
    byte[] arrayOfByte = EpicNative.get(paramLong3 + 16L, 8);
    paramLong3 = ByteBuffer.wrap(EpicNative.get(paramLong3 + 24L, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    Object localObject2 = new StringBuilder("sourceMethod:");
    ((StringBuilder)localObject2).append(Long.toHexString(paramLong3));
    Logger.d("Entry64", ((StringBuilder)localObject2).toString());
    localObject2 = Epic.getMethodInfo(paramLong3);
    Object localObject3 = new StringBuilder("originMethodInfo :");
    ((StringBuilder)localObject3).append(localObject2);
    Logger.d("Entry64", ((StringBuilder)localObject3).toString());
    boolean bool = ((Epic.MethodInfo)localObject2).isStatic;
    int j = ((Epic.MethodInfo)localObject2).paramNumber;
    Class[] arrayOfClass = ((Epic.MethodInfo)localObject2).paramTypes;
    localObject3 = new Object[j];
    int i;
    if (bool)
    {
      if (j != 0)
      {
        localObject3[0] = wrapArgument(arrayOfClass[0], paramLong2, (byte[])localObject1);
        if (j != 1)
        {
          localObject3[1] = wrapArgument(arrayOfClass[1], paramLong2, (byte[])localObject4);
          if (j != 2)
          {
            localObject3[2] = wrapArgument(arrayOfClass[2], paramLong2, arrayOfByte);
            if (j != 3)
            {
              localObject3[3] = wrapArgument(arrayOfClass[3], paramLong2, paramLong4);
              if (j != 4)
              {
                localObject3[4] = wrapArgument(arrayOfClass[4], paramLong2, paramLong5);
                if (j != 5)
                {
                  localObject3[5] = wrapArgument(arrayOfClass[5], paramLong2, paramLong6);
                  if (j != 6)
                  {
                    localObject3[6] = wrapArgument(arrayOfClass[6], paramLong2, paramLong7);
                    i = 7;
                    if (j == 7) {}
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (i >= j)
        {
          localObject1 = null;
          break;
        }
        localObject1 = EpicNative.get(l + i * 8 + 8L, 8);
        localObject3[i] = wrapArgument(arrayOfClass[i], paramLong2, (byte[])localObject1);
        i += 1;
      }
    }
    localObject1 = EpicNative.getObject(paramLong2, paramLong1);
    StringBuilder localStringBuilder = new StringBuilder("this :");
    localStringBuilder.append(localObject1);
    Logger.i("Entry64", localStringBuilder.toString());
    if (j != 0)
    {
      localObject3[0] = wrapArgument(arrayOfClass[0], paramLong2, (byte[])localObject4);
      if (j != 1)
      {
        localObject3[1] = wrapArgument(arrayOfClass[1], paramLong2, arrayOfByte);
        if (j != 2)
        {
          localObject3[2] = wrapArgument(arrayOfClass[2], paramLong2, paramLong4);
          if (j != 3)
          {
            localObject3[3] = wrapArgument(arrayOfClass[3], paramLong2, paramLong5);
            if (j != 4)
            {
              localObject3[4] = wrapArgument(arrayOfClass[4], paramLong2, paramLong6);
              if (j != 5)
              {
                localObject3[5] = wrapArgument(arrayOfClass[5], paramLong2, paramLong7);
                i = 6;
                if (j == 6) {}
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i >= j)
      {
        localObject4 = new StringBuilder("arguments:");
        ((StringBuilder)localObject4).append(Arrays.toString((Object[])localObject3));
        Logger.i("Entry64", ((StringBuilder)localObject4).toString());
        localObject4 = ((Epic.MethodInfo)localObject2).returnType;
        localObject2 = ((Epic.MethodInfo)localObject2).method;
        Logger.d("Entry64", "leave bridge function");
        if (localObject4 == Void.TYPE)
        {
          onHookVoid(localObject2, localObject1, (Object[])localObject3);
          return Integer.valueOf(0);
        }
        if (localObject4 == Character.TYPE) {
          return Character.valueOf(onHookChar(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Byte.TYPE) {
          return Byte.valueOf(onHookByte(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Short.TYPE) {
          return Short.valueOf(onHookShort(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Integer.TYPE) {
          return Integer.valueOf(onHookInt(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Long.TYPE) {
          return Long.valueOf(onHookLong(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Float.TYPE) {
          return Float.valueOf(onHookFloat(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Double.TYPE) {
          return Double.valueOf(onHookDouble(localObject2, localObject1, (Object[])localObject3));
        }
        if (localObject4 == Boolean.TYPE) {
          return Boolean.valueOf(onHookBoolean(localObject2, localObject1, (Object[])localObject3));
        }
        return onHookObject(localObject2, localObject1, (Object[])localObject3);
      }
      localObject4 = EpicNative.get(l + i * 8 + 16L, 8);
      localObject3[i] = wrapArgument(arrayOfClass[i], paramLong2, (byte[])localObject4);
      i += 1;
    }
  }
  
  private static short shortBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).shortValue();
  }
  
  private static void voidBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7);
  }
  
  private static Object wrapArgument(Class<?> paramClass, long paramLong1, long paramLong2)
  {
    return wrapArgument(paramClass, paramLong1, ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong2).array());
  }
  
  private static Object wrapArgument(Class<?> paramClass, long paramLong, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    if (paramClass.isPrimitive())
    {
      if (paramClass == Integer.TYPE) {
        return Integer.valueOf(paramArrayOfByte.getInt());
      }
      if (paramClass == Long.TYPE) {
        return Long.valueOf(paramArrayOfByte.getLong());
      }
      if (paramClass == Float.TYPE) {
        return Float.valueOf(paramArrayOfByte.getFloat());
      }
      if (paramClass == Short.TYPE) {
        return Short.valueOf(paramArrayOfByte.getShort());
      }
      if (paramClass == Byte.TYPE) {
        return Byte.valueOf(paramArrayOfByte.get());
      }
      if (paramClass == Character.TYPE) {
        return Character.valueOf(paramArrayOfByte.getChar());
      }
      if (paramClass == Double.TYPE) {
        return Double.valueOf(paramArrayOfByte.getDouble());
      }
      if (paramClass == Boolean.TYPE)
      {
        if (paramArrayOfByte.getInt() == 0) {
          return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
      }
      paramArrayOfByte = new StringBuilder("unknown type:");
      paramArrayOfByte.append(paramClass);
      throw new RuntimeException(paramArrayOfByte.toString());
    }
    return EpicNative.getObject(paramLong, paramArrayOfByte.getLong());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry64
 * JD-Core Version:    0.7.0.1
 */