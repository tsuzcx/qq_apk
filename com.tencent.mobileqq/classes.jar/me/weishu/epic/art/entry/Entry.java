package me.weishu.epic.art.entry;

import android.os.Build.VERSION;
import android.util.Pair;
import com.qq.android.dexposed.DexposedBridge;
import com.qq.android.dexposed.utility.Debug;
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

public class Entry
{
  private static final Object[] EMPTY_OBJECT_ARRAY;
  private static final String TAG = "Entry";
  private static Map<Class<?>, String> bridgeMethodMap;
  
  static
  {
    int i = 0;
    EMPTY_OBJECT_ARRAY = new Object[0];
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
        bridgeMethodMap.put(Object.class, "referenceBridge");
        bridgeMethodMap.put(Void.TYPE, "voidBridge");
        return;
      }
      Class localClass = arrayOfClass[i];
      Map localMap = bridgeMethodMap;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localClass.getName()));
      localStringBuilder.append("Bridge");
      localMap.put(localClass, localStringBuilder.toString());
      i += 1;
    }
  }
  
  private static boolean booleanBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Boolean)referenceBridge(paramInt1, paramInt2, paramInt3)).booleanValue();
  }
  
  private static byte byteBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Byte)referenceBridge(paramInt1, paramInt2, paramInt3)).byteValue();
  }
  
  private static char charBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Character)referenceBridge(paramInt1, paramInt2, paramInt3)).charValue();
  }
  
  private static Pair<Object, Object[]> constructArguments(Epic.MethodInfo paramMethodInfo, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2)
  {
    boolean bool = paramMethodInfo.isStatic;
    int j;
    if (bool)
    {
      j = paramMethodInfo.paramNumber;
      paramMethodInfo = paramMethodInfo.paramTypes;
    }
    else
    {
      j = paramMethodInfo.paramNumber + 1;
      localObject = new Class[j];
      localObject[0] = Object.class;
      System.arraycopy(paramMethodInfo.paramTypes, 0, localObject, 1, paramMethodInfo.paramTypes.length);
      paramMethodInfo = (Epic.MethodInfo)localObject;
    }
    Object localObject = new Object[j];
    int[] arrayOfInt = new int[j];
    int k = 0;
    int i = 4;
    for (;;)
    {
      if (k >= j)
      {
        byte[] arrayOfByte = new byte[i];
        if (i > 4)
        {
          if ((Build.VERSION.SDK_INT >= 23) && (j > 0) && (getTypeLength(paramMethodInfo[0]) == 8)) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0)
          {
            System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 4, 4);
            System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 8, 4);
            if (i <= 12) {
              break label288;
            }
            System.arraycopy(EpicNative.get(paramInt2 + 12, 4), 0, arrayOfByte, 12, 4);
          }
          else
          {
            System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, 4);
            if (i <= 8) {
              break label288;
            }
            System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 8, 4);
            if (i <= 12) {
              break label288;
            }
            System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 12, 4);
          }
          if (i > 16)
          {
            long l = paramInt2 + 16;
            k = i - 16;
            System.arraycopy(EpicNative.get(l, k), 0, arrayOfByte, 16, k);
          }
        }
        label288:
        if ((Build.VERSION.SDK_INT == 23) && (i > 12)) {
          if (i <= 16)
          {
            if (getTypeLength(paramMethodInfo[0]) == 8) {
              System.arraycopy(EpicNative.get(paramInt2 + 44, 4), 0, arrayOfByte, 12, 4);
            }
          }
          else
          {
            int n;
            if (j >= 2)
            {
              m = getTypeLength(paramMethodInfo[0]);
              n = getTypeLength(paramMethodInfo[1]);
              if ((m == 4) && (n == 8)) {
                k = 0;
              } else {
                k = 1;
              }
              i = k;
              if (j == 2)
              {
                i = k;
                if (m == 8)
                {
                  i = k;
                  if (n == 8)
                  {
                    System.arraycopy(EpicNative.get(paramInt2 + 44, 4), 0, arrayOfByte, 12, 4);
                    i = 0;
                  }
                }
              }
            }
            else
            {
              i = 1;
            }
            m = i;
            if (j >= 3)
            {
              n = getTypeLength(paramMethodInfo[0]);
              int i1 = getTypeLength(paramMethodInfo[1]);
              int i2 = getTypeLength(paramMethodInfo[2]);
              k = i;
              if (n == 4)
              {
                k = i;
                if (i1 == 4)
                {
                  k = i;
                  if (i2 == 4) {
                    k = 0;
                  }
                }
              }
              m = k;
              if (j == 3)
              {
                m = k;
                if (n == 8)
                {
                  m = k;
                  if (i1 == 4)
                  {
                    m = k;
                    if (i2 == 8)
                    {
                      System.arraycopy(EpicNative.get(paramInt2 + 52, 4), 0, arrayOfByte, 12, 4);
                      m = 0;
                    }
                  }
                }
              }
            }
            if (m != 0)
            {
              paramArrayOfByte1 = Arrays.copyOfRange(arrayOfByte, 16, arrayOfByte.length);
              m = paramArrayOfByte1.length;
              i = m + 16;
              k = 0;
              for (;;)
              {
                n = paramInt2 + i;
                paramArrayOfByte2 = EpicNative.get(n, m);
                k += m;
                if (Arrays.equals(paramArrayOfByte2, paramArrayOfByte1))
                {
                  paramArrayOfByte1 = EpicNative.get(n - 4, 4);
                  paramArrayOfByte2 = new StringBuilder("found other arguments in stack, index:");
                  paramArrayOfByte2.append(i);
                  paramArrayOfByte2.append(", origin r3:");
                  paramArrayOfByte2.append(Arrays.toString(paramArrayOfByte1));
                  Logger.d("Entry", paramArrayOfByte2.toString());
                  System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 12, 4);
                  break label731;
                }
                if (k > 1024) {
                  break;
                }
                i += 4;
              }
              throw new RuntimeException("can not found the modify r3 register!!!");
            }
          }
        }
        label731:
        paramArrayOfByte1 = new StringBuilder("argBytes: ");
        paramArrayOfByte1.append(Debug.hexdump(arrayOfByte, 0L));
        Logger.d("Entry", paramArrayOfByte1.toString());
        paramInt2 = 0;
        for (;;)
        {
          if (paramInt2 >= j)
          {
            paramArrayOfByte1 = null;
            paramMethodInfo = EMPTY_OBJECT_ARRAY;
            if (bool)
            {
              paramMethodInfo = (Epic.MethodInfo)localObject;
            }
            else
            {
              paramArrayOfByte1 = localObject[0];
              paramInt1 = localObject.length;
              if (paramInt1 > 1) {
                paramMethodInfo = Arrays.copyOfRange((Object[])localObject, 1, paramInt1);
              }
            }
            return Pair.create(paramArrayOfByte1, paramMethodInfo);
          }
          paramArrayOfByte1 = paramMethodInfo[paramInt2];
          i = arrayOfInt[paramInt2];
          localObject[paramInt2] = wrapArgument(paramArrayOfByte1, paramInt1, Arrays.copyOfRange(arrayOfByte, i, getTypeLength(paramArrayOfByte1) + i));
          paramInt2 += 1;
        }
      }
      int m = getTypeLength(paramMethodInfo[k]);
      arrayOfInt[k] = i;
      i += m;
      k += 1;
    }
  }
  
  private static double doubleBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Double)referenceBridge(paramInt1, paramInt2, paramInt3)).doubleValue();
  }
  
  private static float floatBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Float)referenceBridge(paramInt1, paramInt2, paramInt3)).floatValue();
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
          Logger.i("Entry", ((StringBuilder)localObject).toString());
          paramClass = Entry.class.getDeclaredMethod(paramClass, new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE });
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
  
  private static int getTypeLength(Class<?> paramClass)
  {
    if ((paramClass != Long.TYPE) && (paramClass != Double.TYPE)) {
      return 4;
    }
    return 8;
  }
  
  private static int intBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Integer)referenceBridge(paramInt1, paramInt2, paramInt3)).intValue();
  }
  
  private static long longBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Long)referenceBridge(paramInt1, paramInt2, paramInt3)).longValue();
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
  
  private static Object referenceBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    Logger.i("Entry", "enter bridge function.");
    Object localObject1 = new StringBuilder("struct:");
    long l = paramInt3;
    ((StringBuilder)localObject1).append(Long.toHexString(l));
    Logger.i("Entry", ((StringBuilder)localObject1).toString());
    int i = ByteBuffer.wrap(EpicNative.get(l, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    Object localObject2 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt1).array();
    Object localObject3 = EpicNative.get(paramInt3 + 4, 4);
    Object localObject4 = EpicNative.get(paramInt3 + 8, 4);
    localObject1 = new StringBuilder("r1:");
    ((StringBuilder)localObject1).append(Debug.hexdump((byte[])localObject2, 0L));
    Logger.d("Entry", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder("r2:");
    ((StringBuilder)localObject1).append(Debug.hexdump((byte[])localObject3, 0L));
    Logger.d("Entry", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder("r3:");
    ((StringBuilder)localObject1).append(Debug.hexdump((byte[])localObject4, 0L));
    Logger.d("Entry", ((StringBuilder)localObject1).toString());
    paramInt1 = ByteBuffer.wrap(EpicNative.get(paramInt3 + 12, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    localObject1 = new StringBuilder("sourceMethod:");
    ((StringBuilder)localObject1).append(Integer.toHexString(paramInt1));
    Logger.i("Entry", ((StringBuilder)localObject1).toString());
    localObject1 = Epic.getMethodInfo(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder("originMethodInfo :");
    localStringBuilder.append(localObject1);
    Logger.i("Entry", localStringBuilder.toString());
    localObject3 = constructArguments((Epic.MethodInfo)localObject1, paramInt2, (byte[])localObject2, (byte[])localObject3, (byte[])localObject4, i);
    localObject2 = ((Pair)localObject3).first;
    localObject3 = (Object[])((Pair)localObject3).second;
    localObject4 = new StringBuilder("arguments:");
    ((StringBuilder)localObject4).append(Arrays.toString((Object[])localObject3));
    Logger.i("Entry", ((StringBuilder)localObject4).toString());
    localObject4 = ((Epic.MethodInfo)localObject1).returnType;
    localObject1 = ((Epic.MethodInfo)localObject1).method;
    Logger.i("Entry", "leave bridge function");
    if (localObject4 == Void.TYPE)
    {
      onHookVoid(localObject1, localObject2, (Object[])localObject3);
      return Integer.valueOf(0);
    }
    if (localObject4 == Character.TYPE) {
      return Character.valueOf(onHookChar(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Byte.TYPE) {
      return Byte.valueOf(onHookByte(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Short.TYPE) {
      return Short.valueOf(onHookShort(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Integer.TYPE) {
      return Integer.valueOf(onHookInt(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Long.TYPE) {
      return Long.valueOf(onHookLong(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Float.TYPE) {
      return Float.valueOf(onHookFloat(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Double.TYPE) {
      return Double.valueOf(onHookDouble(localObject1, localObject2, (Object[])localObject3));
    }
    if (localObject4 == Boolean.TYPE) {
      return Boolean.valueOf(onHookBoolean(localObject1, localObject2, (Object[])localObject3));
    }
    return onHookObject(localObject1, localObject2, (Object[])localObject3);
  }
  
  private static short shortBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    return ((Short)referenceBridge(paramInt1, paramInt2, paramInt3)).shortValue();
  }
  
  private static void voidBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    referenceBridge(paramInt1, paramInt2, paramInt3);
  }
  
  private static Object wrapArgument(Class<?> paramClass, int paramInt, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    StringBuilder localStringBuilder = new StringBuilder("wrapArgument: type:");
    localStringBuilder.append(paramClass);
    Logger.d("Entry", localStringBuilder.toString());
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
    int i = paramArrayOfByte.getInt();
    return EpicNative.getObject(paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry
 * JD-Core Version:    0.7.0.1
 */