package me.weishu.epic.art.entry;

import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.Epic.MethodInfo;
import me.weishu.epic.art.EpicNative;

public class Entry64_2
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
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      bridgeMethodMap.put(localClass, localClass.getName() + "Bridge");
      i += 1;
    }
    bridgeMethodMap.put(Void.TYPE, "voidBridge");
    bridgeMethodMap.put(Object.class, "referenceBridge");
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).booleanValue();
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).booleanValue();
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).booleanValue();
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).booleanValue();
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).booleanValue();
  }
  
  private static boolean booleanBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Boolean)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).booleanValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).byteValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).byteValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).byteValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).byteValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).byteValue();
  }
  
  private static byte byteBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Byte)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).byteValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).charValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).charValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).charValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).charValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).charValue();
  }
  
  private static char charBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Character)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).charValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).doubleValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).doubleValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).doubleValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).doubleValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).doubleValue();
  }
  
  private static double doubleBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Double)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).doubleValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).floatValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).floatValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).floatValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).floatValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).floatValue();
  }
  
  private static float floatBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Float)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).floatValue();
  }
  
  public static Method getBridgeMethod(Epic.MethodInfo paramMethodInfo)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        Class localClass = paramMethodInfo.returnType;
        Class[] arrayOfClass;
        if (paramMethodInfo.isStatic)
        {
          i = paramMethodInfo.paramNumber;
          break label152;
          arrayOfClass = new Class[j];
          i = 0;
          if (i < j)
          {
            arrayOfClass[i] = Long.TYPE;
            i += 1;
            continue;
          }
        }
        else
        {
          i = paramMethodInfo.paramNumber + 1;
          break label152;
        }
        Map localMap = bridgeMethodMap;
        if (localClass.isPrimitive())
        {
          paramMethodInfo = localClass;
          paramMethodInfo = (String)localMap.get(paramMethodInfo);
          Logger.d("Entry64", "bridge method:" + paramMethodInfo + ", map:" + bridgeMethodMap);
          paramMethodInfo = Entry64_2.class.getDeclaredMethod(paramMethodInfo, arrayOfClass);
          paramMethodInfo.setAccessible(true);
          return paramMethodInfo;
        }
        paramMethodInfo = Object.class;
        continue;
        j = i;
      }
      catch (Throwable paramMethodInfo)
      {
        throw new RuntimeException("can not found bridge.", paramMethodInfo);
      }
      label152:
      if (i <= 2) {
        j = 2;
      }
    }
  }
  
  private static int intBridge(long paramLong1, long paramLong2)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).intValue();
  }
  
  private static int intBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).intValue();
  }
  
  private static int intBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).intValue();
  }
  
  private static int intBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).intValue();
  }
  
  private static int intBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).intValue();
  }
  
  private static int intBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Integer)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).intValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).longValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).longValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).longValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).longValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).longValue();
  }
  
  private static long longBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Long)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).longValue();
  }
  
  private static boolean onHookBoolean(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return false;
    }
    return ((Boolean)paramObject1).booleanValue();
  }
  
  private static byte onHookByte(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return 0;
    }
    return ((Byte)paramObject1).byteValue();
  }
  
  private static char onHookChar(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return '\000';
    }
    return ((Character)paramObject1).charValue();
  }
  
  private static double onHookDouble(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return 0.0D;
    }
    return ((Double)paramObject1).doubleValue();
  }
  
  private static float onHookFloat(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return 0.0F;
    }
    return ((Float)paramObject1).floatValue();
  }
  
  private static int onHookInt(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return 0;
    }
    return ((Integer)paramObject1).intValue();
  }
  
  private static long onHookLong(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return 0L;
    }
    return ((Long)paramObject1).longValue();
  }
  
  private static Object onHookObject(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject2 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    paramObject1 = paramObject2;
    if (paramObject2 == null) {
      paramObject1 = new Object();
    }
    return paramObject1;
  }
  
  private static short onHookShort(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    paramObject1 = DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
    if (paramObject1 == null) {
      return 0;
    }
    return ((Short)paramObject1).shortValue();
  }
  
  private static void onHookVoid(Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    DexposedBridge.handleHookedArtMethod(paramObject1, paramObject2, paramArrayOfObject);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2)
  {
    return referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L);
  }
  
  private static Object referenceBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    Logger.i("Entry64", "enter bridge function.");
    long l1 = XposedHelpers.getLongField(Thread.currentThread(), "nativePeer");
    Logger.d("Entry64", "java thread native peer:" + Long.toHexString(l1));
    Logger.d("Entry64", "struct:" + Long.toHexString(paramLong2));
    Logger.d("Entry64", "struct:" + Debug.hexdump(EpicNative.get(paramLong2, 24), paramLong2));
    long l2 = ByteBuffer.wrap(EpicNative.get(paramLong2, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    Logger.d("Entry64", "stack:" + l2);
    Object localObject1 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(paramLong1).array();
    byte[] arrayOfByte = EpicNative.get(8L + paramLong2, 8);
    paramLong2 = ByteBuffer.wrap(EpicNative.get(16L + paramLong2, 8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
    Logger.d("Entry64", "sourceMethod:" + Long.toHexString(paramLong2));
    Object localObject3 = Epic.getMethodInfo(paramLong2);
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
                                arrayOfObject[0] = wrapArgument(arrayOfClass[0], l1, (byte[])localObject1);
                                localObject1 = localObject2;
                              } while (j == 1);
                              arrayOfObject[1] = wrapArgument(arrayOfClass[1], l1, arrayOfByte);
                              localObject1 = localObject2;
                            } while (j == 2);
                            arrayOfObject[2] = wrapArgument(arrayOfClass[2], l1, paramLong3);
                            localObject1 = localObject2;
                          } while (j == 3);
                          arrayOfObject[3] = wrapArgument(arrayOfClass[3], l1, paramLong4);
                          localObject1 = localObject2;
                        } while (j == 4);
                        arrayOfObject[4] = wrapArgument(arrayOfClass[4], l1, paramLong5);
                        localObject1 = localObject2;
                      } while (j == 5);
                      arrayOfObject[5] = wrapArgument(arrayOfClass[5], l1, paramLong6);
                      localObject1 = localObject2;
                    } while (j == 6);
                    arrayOfObject[6] = wrapArgument(arrayOfClass[6], l1, paramLong7);
                    localObject1 = localObject2;
                  } while (j == 7);
                  i = 7;
                  for (;;)
                  {
                    localObject1 = localObject2;
                    if (i >= j) {
                      break;
                    }
                    localObject1 = EpicNative.get(i * 8 + l2 + 8L, 8);
                    arrayOfObject[i] = wrapArgument(arrayOfClass[i], l1, (byte[])localObject1);
                    i += 1;
                  }
                  localObject2 = EpicNative.getObject(l1, paramLong1);
                  Logger.i("Entry64", "this :" + localObject2);
                  localObject1 = localObject2;
                } while (j == 0);
                arrayOfObject[0] = wrapArgument(arrayOfClass[0], l1, arrayOfByte);
                localObject1 = localObject2;
              } while (j == 1);
              arrayOfObject[1] = wrapArgument(arrayOfClass[1], l1, paramLong3);
              localObject1 = localObject2;
            } while (j == 2);
            arrayOfObject[2] = wrapArgument(arrayOfClass[2], l1, paramLong4);
            localObject1 = localObject2;
          } while (j == 3);
          arrayOfObject[3] = wrapArgument(arrayOfClass[3], l1, paramLong5);
          localObject1 = localObject2;
        } while (j == 4);
        arrayOfObject[4] = wrapArgument(arrayOfClass[4], l1, paramLong6);
        localObject1 = localObject2;
      } while (j == 5);
      arrayOfObject[5] = wrapArgument(arrayOfClass[5], l1, paramLong7);
      localObject1 = localObject2;
    } while (j == 6);
    int i = 6;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject1 = EpicNative.get(i * 8 + l2 + 16L, 8);
      arrayOfObject[i] = wrapArgument(arrayOfClass[i], l1, (byte[])localObject1);
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
  
  private static short shortBridge(long paramLong1, long paramLong2)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L)).shortValue();
  }
  
  private static short shortBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L)).shortValue();
  }
  
  private static short shortBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L)).shortValue();
  }
  
  private static short shortBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L)).shortValue();
  }
  
  private static short shortBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L)).shortValue();
  }
  
  private static short shortBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    return ((Short)referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, paramLong7)).shortValue();
  }
  
  private static void voidBridge(long paramLong1, long paramLong2)
  {
    referenceBridge(paramLong1, paramLong2, 0L, 0L, 0L, 0L, 0L);
  }
  
  private static void voidBridge(long paramLong1, long paramLong2, long paramLong3)
  {
    referenceBridge(paramLong1, paramLong2, paramLong3, 0L, 0L, 0L, 0L);
  }
  
  private static void voidBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, 0L, 0L, 0L);
  }
  
  private static void voidBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L);
  }
  
  private static void voidBridge(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    referenceBridge(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, 0L);
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
        if (paramArrayOfByte.getInt() == 0) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
      throw new RuntimeException("unknown type:" + paramClass);
    }
    return EpicNative.getObject(paramLong, paramArrayOfByte.getLong());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry64_2
 * JD-Core Version:    0.7.0.1
 */