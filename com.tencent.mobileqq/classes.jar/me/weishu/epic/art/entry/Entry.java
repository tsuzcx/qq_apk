package me.weishu.epic.art.entry;

import android.os.Build.VERSION;
import android.util.Pair;
import com.qq.android.dexposed.DexposedBridge;
import com.qq.android.dexposed.utility.Debug;
import com.qq.android.dexposed.utility.Logger;
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
      bridgeMethodMap.put(localClass, localClass.getName() + "Bridge");
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
    int m;
    Object localObject;
    int i;
    int[] arrayOfInt;
    int j;
    label41:
    byte[] arrayOfByte;
    if (bool)
    {
      m = paramMethodInfo.paramNumber;
      paramMethodInfo = paramMethodInfo.paramTypes;
      localObject = new Object[m];
      i = 4;
      arrayOfInt = new int[m];
      j = 0;
      if (j < m) {
        break label211;
      }
      arrayOfByte = new byte[i];
      if (i > 4) {
        break label243;
      }
      label60:
      if ((Build.VERSION.SDK_INT == 23) && (i > 12))
      {
        if (i > 16) {
          break label411;
        }
        if (getTypeLength(paramMethodInfo[0]) == 8) {
          System.arraycopy(EpicNative.get(paramInt2 + 44, 4), 0, arrayOfByte, 12, 4);
        }
      }
      label112:
      Logger.d("Entry", "argBytes: " + Debug.hexdump(arrayOfByte, 0L));
      paramInt2 = 0;
      label141:
      if (paramInt2 < m) {
        break label792;
      }
      paramArrayOfByte1 = null;
      paramMethodInfo = EMPTY_OBJECT_ARRAY;
      if (!bool) {
        break label837;
      }
      paramMethodInfo = (Epic.MethodInfo)localObject;
    }
    for (;;)
    {
      return Pair.create(paramArrayOfByte1, paramMethodInfo);
      m = paramMethodInfo.paramNumber + 1;
      localObject = new Class[m];
      localObject[0] = Object.class;
      System.arraycopy(paramMethodInfo.paramTypes, 0, localObject, 1, paramMethodInfo.paramTypes.length);
      paramMethodInfo = (Epic.MethodInfo)localObject;
      break;
      label211:
      int k = getTypeLength(paramMethodInfo[j]);
      arrayOfInt[j] = i;
      i += k;
      j += 1;
      break label41;
      label243:
      if ((Build.VERSION.SDK_INT >= 23) && (m > 0) && (getTypeLength(paramMethodInfo[0]) == 8))
      {
        j = 1;
        if (j == 0) {
          break label364;
        }
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 4, 4);
        System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 8, 4);
        if (i <= 12) {
          break label60;
        }
        System.arraycopy(EpicNative.get(paramInt2 + 12, 4), 0, arrayOfByte, 12, 4);
      }
      for (;;)
      {
        label270:
        if (i <= 16) {
          break label409;
        }
        System.arraycopy(EpicNative.get(paramInt2 + 16, i - 16), 0, arrayOfByte, 16, i - 16);
        break;
        j = 0;
        break label270;
        label364:
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, 4);
        if (i <= 8) {
          break;
        }
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 8, 4);
        if (i <= 12) {
          break;
        }
        System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 12, 4);
      }
      label409:
      break label60;
      label411:
      i = 1;
      k = 1;
      int n;
      int i1;
      if (m >= 2)
      {
        n = getTypeLength(paramMethodInfo[0]);
        i1 = getTypeLength(paramMethodInfo[1]);
        j = k;
        if (n == 4)
        {
          j = k;
          if (i1 == 8) {
            j = 0;
          }
        }
        i = j;
        if (m == 2)
        {
          i = j;
          if (n == 8)
          {
            i = j;
            if (i1 == 8)
            {
              System.arraycopy(EpicNative.get(paramInt2 + 44, 4), 0, arrayOfByte, 12, 4);
              i = 0;
            }
          }
        }
      }
      k = i;
      if (m >= 3)
      {
        n = getTypeLength(paramMethodInfo[0]);
        i1 = getTypeLength(paramMethodInfo[1]);
        int i2 = getTypeLength(paramMethodInfo[2]);
        j = i;
        if (n == 4)
        {
          j = i;
          if (i1 == 4)
          {
            j = i;
            if (i2 == 4) {
              j = 0;
            }
          }
        }
        k = j;
        if (m == 3)
        {
          k = j;
          if (n == 8)
          {
            k = j;
            if (i1 == 4)
            {
              k = j;
              if (i2 == 8)
              {
                System.arraycopy(EpicNative.get(paramInt2 + 52, 4), 0, arrayOfByte, 12, 4);
                k = 0;
              }
            }
          }
        }
      }
      if (k == 0) {
        break label112;
      }
      paramArrayOfByte1 = Arrays.copyOfRange(arrayOfByte, 16, arrayOfByte.length);
      k = paramArrayOfByte1.length;
      j = 0;
      i = k + 16;
      for (;;)
      {
        paramArrayOfByte2 = EpicNative.get(paramInt2 + i, k);
        j += k;
        if (Arrays.equals(paramArrayOfByte2, paramArrayOfByte1))
        {
          paramArrayOfByte1 = EpicNative.get(paramInt2 + i - 4, 4);
          Logger.d("Entry", "found other arguments in stack, index:" + i + ", origin r3:" + Arrays.toString(paramArrayOfByte1));
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 12, 4);
          break;
        }
        if (j > 1024) {
          throw new RuntimeException("can not found the modify r3 register!!!");
        }
        i += 4;
      }
      label792:
      paramArrayOfByte1 = paramMethodInfo[paramInt2];
      i = arrayOfInt[paramInt2];
      localObject[paramInt2] = wrapArgument(paramArrayOfByte1, paramInt1, Arrays.copyOfRange(arrayOfByte, i, getTypeLength(paramArrayOfByte1) + i));
      paramInt2 += 1;
      break label141;
      label837:
      paramArrayOfByte2 = localObject[0];
      paramInt1 = localObject.length;
      paramArrayOfByte1 = paramArrayOfByte2;
      if (paramInt1 > 1)
      {
        paramMethodInfo = Arrays.copyOfRange((Object[])localObject, 1, paramInt1);
        paramArrayOfByte1 = paramArrayOfByte2;
      }
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
  
  /* Error */
  public static java.lang.reflect.Method getBridgeMethod(Class<?> paramClass)
  {
    // Byte code:
    //   0: getstatic 24	me/weishu/epic/art/entry/Entry:bridgeMethodMap	Ljava/util/Map;
    //   3: astore_1
    //   4: aload_0
    //   5: invokevirtual 223	java/lang/Class:isPrimitive	()Z
    //   8: ifeq +82 -> 90
    //   11: aload_1
    //   12: aload_0
    //   13: invokeinterface 226 2 0
    //   18: checkcast 74	java/lang/String
    //   21: astore_0
    //   22: ldc 10
    //   24: new 68	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 228
    //   30: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 230
    //   39: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: getstatic 24	me/weishu/epic/art/entry/Entry:bridgeMethodMap	Ljava/util/Map;
    //   45: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 236	com/qq/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 2
    //   56: aload_0
    //   57: iconst_3
    //   58: anewarray 26	java/lang/Class
    //   61: dup
    //   62: iconst_0
    //   63: getstatic 44	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: getstatic 44	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: getstatic 44	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   78: aastore
    //   79: invokevirtual 240	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   82: astore_0
    //   83: aload_0
    //   84: iconst_1
    //   85: invokevirtual 246	java/lang/reflect/Method:setAccessible	(Z)V
    //   88: aload_0
    //   89: areturn
    //   90: ldc 4
    //   92: astore_0
    //   93: goto -82 -> 11
    //   96: astore_0
    //   97: new 192	java/lang/RuntimeException
    //   100: dup
    //   101: ldc 248
    //   103: aload_0
    //   104: invokespecial 251	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramClass	Class<?>
    //   3	9	1	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   0	11	96	java/lang/Throwable
    //   11	88	96	java/lang/Throwable
  }
  
  private static int getTypeLength(Class<?> paramClass)
  {
    if ((paramClass == Long.TYPE) || (paramClass == Double.TYPE)) {
      return 8;
    }
    return 4;
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
    Logger.i("Entry", "struct:" + Long.toHexString(paramInt3));
    int i = ByteBuffer.wrap(EpicNative.get(paramInt3, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    Object localObject2 = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt1).array();
    Object localObject3 = EpicNative.get(paramInt3 + 4, 4);
    Object localObject4 = EpicNative.get(paramInt3 + 8, 4);
    Logger.d("Entry", "r1:" + Debug.hexdump((byte[])localObject2, 0L));
    Logger.d("Entry", "r2:" + Debug.hexdump((byte[])localObject3, 0L));
    Logger.d("Entry", "r3:" + Debug.hexdump((byte[])localObject4, 0L));
    paramInt1 = ByteBuffer.wrap(EpicNative.get(paramInt3 + 12, 4)).order(ByteOrder.LITTLE_ENDIAN).getInt();
    Logger.i("Entry", "sourceMethod:" + Integer.toHexString(paramInt1));
    Object localObject1 = Epic.getMethodInfo(paramInt1);
    Logger.i("Entry", "originMethodInfo :" + localObject1);
    localObject3 = constructArguments((Epic.MethodInfo)localObject1, paramInt2, (byte[])localObject2, (byte[])localObject3, (byte[])localObject4, i);
    localObject2 = ((Pair)localObject3).first;
    localObject3 = (Object[])((Pair)localObject3).second;
    Logger.i("Entry", "arguments:" + Arrays.toString((Object[])localObject3));
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
    Logger.d("Entry", "wrapArgument: type:" + paramClass);
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
    int i = paramArrayOfByte.getInt();
    return EpicNative.getObject(paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry
 * JD-Core Version:    0.7.0.1
 */