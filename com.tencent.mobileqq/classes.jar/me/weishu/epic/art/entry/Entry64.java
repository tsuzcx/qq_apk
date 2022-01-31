package me.weishu.epic.art.entry;

import com.qq.android.dexposed.DexposedBridge;
import com.qq.android.dexposed.XposedHelpers;
import com.qq.android.dexposed.utility.Logger;
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
  private static Map<Class<?>, String> bridgeMethodMap;
  
  static
  {
    int i = 0;
    bridgeMethodMap = new HashMap();
    Class[] arrayOfClass = new Class[8];
    arrayOfClass[0] = Boolean.TYPE;
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
      Class localClass = arrayOfClass[i];
      bridgeMethodMap.put(localClass, localClass.getName() + "Bridge");
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
  
  /* Error */
  public static java.lang.reflect.Method getBridgeMethod(Class<?> paramClass)
  {
    // Byte code:
    //   0: getstatic 20	me/weishu/epic/art/entry/Entry64:bridgeMethodMap	Ljava/util/Map;
    //   3: astore_1
    //   4: aload_0
    //   5: invokevirtual 128	java/lang/Class:isPrimitive	()Z
    //   8: ifeq +108 -> 116
    //   11: aload_1
    //   12: aload_0
    //   13: invokeinterface 132 2 0
    //   18: checkcast 70	java/lang/String
    //   21: astore_0
    //   22: ldc 8
    //   24: new 64	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 134
    //   30: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 136
    //   39: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: getstatic 20	me/weishu/epic/art/entry/Entry64:bridgeMethodMap	Ljava/util/Map;
    //   45: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 145	com/qq/android/dexposed/utility/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 2
    //   56: aload_0
    //   57: bipush 7
    //   59: anewarray 22	java/lang/Class
    //   62: dup
    //   63: iconst_0
    //   64: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   73: aastore
    //   74: dup
    //   75: iconst_2
    //   76: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   85: aastore
    //   86: dup
    //   87: iconst_4
    //   88: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   91: aastore
    //   92: dup
    //   93: iconst_5
    //   94: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   97: aastore
    //   98: dup
    //   99: bipush 6
    //   101: getstatic 43	java/lang/Long:TYPE	Ljava/lang/Class;
    //   104: aastore
    //   105: invokevirtual 149	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   108: astore_0
    //   109: aload_0
    //   110: iconst_1
    //   111: invokevirtual 155	java/lang/reflect/Method:setAccessible	(Z)V
    //   114: aload_0
    //   115: areturn
    //   116: ldc 4
    //   118: astore_0
    //   119: goto -108 -> 11
    //   122: astore_0
    //   123: new 157	java/lang/RuntimeException
    //   126: dup
    //   127: ldc 159
    //   129: aload_0
    //   130: invokespecial 162	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramClass	Class<?>
    //   3	9	1	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   0	11	122	java/lang/Throwable
    //   11	114	122	java/lang/Throwable
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
    Logger.d("Entry64", "self:" + Long.toHexString(paramLong2));
    paramLong2 = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
    Logger.d("Entry64", "java thread native peer:" + Long.toHexString(paramLong2));
    Logger.d("Entry64", "struct:" + Long.toHexString(paramLong3));
    long l = ByteBuffer.wrap(EpicNative.get(paramLong3, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    Logger.d("Entry64", "stack:" + l);
    Object localObject1 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong1).array();
    byte[] arrayOfByte1 = EpicNative.get(8L + paramLong3, 8);
    byte[] arrayOfByte2 = EpicNative.get(16L + paramLong3, 8);
    paramLong3 = ByteBuffer.wrap(EpicNative.get(24L + paramLong3, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    Logger.d("Entry64", "sourceMethod:" + Long.toHexString(paramLong3));
    Object localObject3 = Epic.getMethodInfo(paramLong3);
    Logger.d("Entry64", "originMethodInfo :" + localObject3);
    boolean bool = ((Epic.MethodInfo)localObject3).isStatic;
    int j = ((Epic.MethodInfo)localObject3).paramNumber;
    Class[] arrayOfClass = ((Epic.MethodInfo)localObject3).paramTypes;
    Object[] arrayOfObject = new Object[j];
    Object localObject2;
    if (bool)
    {
      localObject2 = null;
      if (j == 0) {
        localObject1 = localObject2;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                Logger.i("Entry64", "arguments:" + Arrays.toString(arrayOfObject));
                                localObject2 = ((Epic.MethodInfo)localObject3).returnType;
                                localObject3 = ((Epic.MethodInfo)localObject3).method;
                                Logger.d("Entry64", "leave bridge function");
                                if (localObject2 != Void.TYPE) {
                                  break;
                                }
                                onHookVoid(localObject3, localObject1, arrayOfObject);
                                return Integer.valueOf(0);
                                arrayOfObject[0] = wrapArgument(arrayOfClass[0], paramLong2, (byte[])localObject1);
                                localObject1 = localObject2;
                              } while (j == 1);
                              arrayOfObject[1] = wrapArgument(arrayOfClass[1], paramLong2, arrayOfByte1);
                              localObject1 = localObject2;
                            } while (j == 2);
                            arrayOfObject[2] = wrapArgument(arrayOfClass[2], paramLong2, arrayOfByte2);
                            localObject1 = localObject2;
                          } while (j == 3);
                          arrayOfObject[3] = wrapArgument(arrayOfClass[3], paramLong2, paramLong4);
                          localObject1 = localObject2;
                        } while (j == 4);
                        arrayOfObject[4] = wrapArgument(arrayOfClass[4], paramLong2, paramLong5);
                        localObject1 = localObject2;
                      } while (j == 5);
                      arrayOfObject[5] = wrapArgument(arrayOfClass[5], paramLong2, paramLong6);
                      localObject1 = localObject2;
                    } while (j == 6);
                    arrayOfObject[6] = wrapArgument(arrayOfClass[6], paramLong2, paramLong7);
                    localObject1 = localObject2;
                  } while (j == 7);
                  i = 7;
                  for (;;)
                  {
                    localObject1 = localObject2;
                    if (i >= j) {
                      break;
                    }
                    localObject1 = EpicNative.get(i * 8 + l + 8L, 8);
                    arrayOfObject[i] = wrapArgument(arrayOfClass[i], paramLong2, (byte[])localObject1);
                    i += 1;
                  }
                  localObject2 = EpicNative.getObject(paramLong2, paramLong1);
                  Logger.i("Entry64", "this :" + localObject2);
                  localObject1 = localObject2;
                } while (j == 0);
                arrayOfObject[0] = wrapArgument(arrayOfClass[0], paramLong2, arrayOfByte1);
                localObject1 = localObject2;
              } while (j == 1);
              arrayOfObject[1] = wrapArgument(arrayOfClass[1], paramLong2, arrayOfByte2);
              localObject1 = localObject2;
            } while (j == 2);
            arrayOfObject[2] = wrapArgument(arrayOfClass[2], paramLong2, paramLong4);
            localObject1 = localObject2;
          } while (j == 3);
          arrayOfObject[3] = wrapArgument(arrayOfClass[3], paramLong2, paramLong5);
          localObject1 = localObject2;
        } while (j == 4);
        arrayOfObject[4] = wrapArgument(arrayOfClass[4], paramLong2, paramLong6);
        localObject1 = localObject2;
      } while (j == 5);
      arrayOfObject[5] = wrapArgument(arrayOfClass[5], paramLong2, paramLong7);
      localObject1 = localObject2;
    } while (j == 6);
    int i = 6;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = EpicNative.get(i * 8 + l + 16L, 8);
      arrayOfObject[i] = wrapArgument(arrayOfClass[i], paramLong2, (byte[])localObject1);
      i += 1;
    }
    if (localObject2 == Character.TYPE) {
      return Character.valueOf(onHookChar(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Byte.TYPE) {
      return Byte.valueOf(onHookByte(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Short.TYPE) {
      return Short.valueOf(onHookShort(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Integer.TYPE) {
      return Integer.valueOf(onHookInt(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Long.TYPE) {
      return Long.valueOf(onHookLong(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Float.TYPE) {
      return Float.valueOf(onHookFloat(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Double.TYPE) {
      return Double.valueOf(onHookDouble(localObject3, localObject1, arrayOfObject));
    }
    if (localObject2 == Boolean.TYPE) {
      return Boolean.valueOf(onHookBoolean(localObject3, localObject1, arrayOfObject));
    }
    return onHookObject(localObject3, localObject1, arrayOfObject);
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
      throw new RuntimeException("unknown type:" + paramClass);
    }
    return EpicNative.getObject(paramLong, paramArrayOfByte.getLong());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry64
 * JD-Core Version:    0.7.0.1
 */