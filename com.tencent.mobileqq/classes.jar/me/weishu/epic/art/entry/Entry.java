package me.weishu.epic.art.entry;

import android.os.Build.VERSION;
import android.util.Pair;
import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
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
    while (i < j)
    {
      Class localClass = arrayOfClass[i];
      bridgeMethodMap.put(localClass, localClass.getName() + "Bridge");
      i += 1;
    }
    bridgeMethodMap.put(Object.class, "referenceBridge");
    bridgeMethodMap.put(Void.TYPE, "voidBridge");
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
    boolean bool4 = paramMethodInfo.isStatic;
    int i;
    if (bool4) {
      i = paramMethodInfo.paramNumber;
    }
    Object localObject;
    int[] arrayOfInt;
    for (paramMethodInfo = paramMethodInfo.paramTypes;; paramMethodInfo = (Epic.MethodInfo)localObject)
    {
      localObject = new Object[i];
      k = 4;
      arrayOfInt = new int[i];
      j = 0;
      while (j < i)
      {
        m = getTypeLength(paramMethodInfo[j]);
        arrayOfInt[j] = k;
        k += m;
        j += 1;
      }
      i = paramMethodInfo.paramNumber + 1;
      localObject = new Class[i];
      localObject[0] = Object.class;
      System.arraycopy(paramMethodInfo.paramTypes, 0, localObject, 1, paramMethodInfo.paramTypes.length);
    }
    byte[] arrayOfByte = new byte[k];
    Logger.w("Entry", "constructArguments argTotalLength:" + k);
    if (k <= 4) {
      if (Build.VERSION.SDK_INT == 23)
      {
        Logger.w("Entry", "constructArguments for Android 6.0");
        if (k > 12) {
          break label459;
        }
      }
    }
    label293:
    label457:
    label459:
    label499:
    boolean bool3;
    label412:
    do
    {
      for (;;)
      {
        Logger.d("Entry", "argBytes: " + Debug.hexdump(arrayOfByte, 0L));
        paramInt2 = 0;
        while (paramInt2 < i)
        {
          paramArrayOfByte1 = paramMethodInfo[paramInt2];
          j = arrayOfInt[paramInt2];
          localObject[paramInt2] = wrapArgument(paramArrayOfByte1, paramInt1, Arrays.copyOfRange(arrayOfByte, j, getTypeLength(paramArrayOfByte1) + j));
          paramInt2 += 1;
        }
        if ((Build.VERSION.SDK_INT >= 23) && (i > 0) && (getTypeLength(paramMethodInfo[0]) == 8))
        {
          bool1 = true;
          Logger.w("Entry", "constructArguments align:" + bool1);
          if (!bool1) {
            break label412;
          }
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 4, 4);
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 8, 4);
          if (k <= 12) {
            break;
          }
          System.arraycopy(EpicNative.get(paramInt2 + 12, 4), 0, arrayOfByte, 12, 4);
        }
        for (;;)
        {
          if (k <= 16) {
            break label457;
          }
          System.arraycopy(EpicNative.get(paramInt2 + 16, k - 16), 0, arrayOfByte, 16, k - 16);
          break;
          bool1 = false;
          break label293;
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, 4);
          if (k <= 8) {
            break;
          }
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 8, 4);
          if (k <= 12) {
            break;
          }
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 12, 4);
        }
        break;
        if (k > 16) {
          break label499;
        }
        if (getTypeLength(paramMethodInfo[0]) == 8) {
          System.arraycopy(EpicNative.get(paramInt2 + 44, 4), 0, arrayOfByte, 12, 4);
        }
      }
      boolean bool1 = true;
      bool3 = true;
      boolean bool2;
      if (i >= 2)
      {
        j = getTypeLength(paramMethodInfo[0]);
        k = getTypeLength(paramMethodInfo[1]);
        bool2 = bool3;
        if (j == 4)
        {
          bool2 = bool3;
          if (k == 8) {
            bool2 = false;
          }
        }
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j == 8)
          {
            bool1 = bool2;
            if (k == 8)
            {
              System.arraycopy(EpicNative.get(paramInt2 + 44, 4), 0, arrayOfByte, 12, 4);
              bool1 = false;
            }
          }
        }
      }
      bool3 = bool1;
      if (i >= 3)
      {
        j = getTypeLength(paramMethodInfo[0]);
        k = getTypeLength(paramMethodInfo[1]);
        m = getTypeLength(paramMethodInfo[2]);
        bool2 = bool1;
        if (j == 4)
        {
          bool2 = bool1;
          if (k == 4)
          {
            bool2 = bool1;
            if (m == 4) {
              bool2 = false;
            }
          }
        }
        bool3 = bool2;
        if (i == 3)
        {
          bool3 = bool2;
          if (j == 8)
          {
            bool3 = bool2;
            if (k == 4)
            {
              bool3 = bool2;
              if (m == 8)
              {
                System.arraycopy(EpicNative.get(paramInt2 + 52, 4), 0, arrayOfByte, 12, 4);
                bool3 = false;
              }
            }
          }
        }
      }
      Logger.w("Entry", "constructArguments isR3Grabbed:" + bool3);
    } while (!bool3);
    paramArrayOfByte1 = Arrays.copyOfRange(arrayOfByte, 16, arrayOfByte.length);
    int m = paramArrayOfByte1.length;
    int k = 0;
    int j = m + 16;
    for (;;)
    {
      paramArrayOfByte2 = EpicNative.get(paramInt2 + j, m);
      k += m;
      if (Arrays.equals(paramArrayOfByte2, paramArrayOfByte1))
      {
        paramArrayOfByte1 = EpicNative.get(paramInt2 + j - 4, 4);
        Logger.d("Entry", "found other arguments in stack, index:" + j + ", origin r3:" + Arrays.toString(paramArrayOfByte1));
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 12, 4);
        break;
      }
      if (k > 1024) {
        throw new RuntimeException("can not found the modify r3 register!!!");
      }
      j += 4;
    }
    paramArrayOfByte1 = null;
    paramMethodInfo = EMPTY_OBJECT_ARRAY;
    if (bool4) {
      paramMethodInfo = (Epic.MethodInfo)localObject;
    }
    for (;;)
    {
      return Pair.create(paramArrayOfByte1, paramMethodInfo);
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
    //   5: invokevirtual 231	java/lang/Class:isPrimitive	()Z
    //   8: ifeq +85 -> 93
    //   11: aload_1
    //   12: aload_0
    //   13: invokeinterface 234 2 0
    //   18: checkcast 236	java/lang/String
    //   21: astore_0
    //   22: ldc 10
    //   24: new 55	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   31: ldc 238
    //   33: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 240
    //   42: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 24	me/weishu/epic/art/entry/Entry:bridgeMethodMap	Ljava/util/Map;
    //   48: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 246	com/taobao/android/dexposed/utility/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: ldc 2
    //   59: aload_0
    //   60: iconst_3
    //   61: anewarray 26	java/lang/Class
    //   64: dup
    //   65: iconst_0
    //   66: getstatic 44	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: getstatic 44	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: getstatic 44	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   81: aastore
    //   82: invokevirtual 250	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   85: astore_0
    //   86: aload_0
    //   87: iconst_1
    //   88: invokevirtual 256	java/lang/reflect/Method:setAccessible	(Z)V
    //   91: aload_0
    //   92: areturn
    //   93: ldc 4
    //   95: astore_0
    //   96: goto -85 -> 11
    //   99: astore_0
    //   100: new 196	java/lang/RuntimeException
    //   103: dup
    //   104: ldc_w 258
    //   107: aload_0
    //   108: invokespecial 261	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramClass	Class<?>
    //   3	9	1	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   0	11	99	java/lang/Throwable
    //   11	91	99	java/lang/Throwable
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
  
  private static Object referenceBridge(int paramInt1, int paramInt2, int paramInt3)
  {
    Logger.i("Entry", "---------enter bridge function---------.");
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
    boolean bool = true;
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
        paramInt = paramArrayOfByte.getInt();
        Logger.d("Entry", "byteBuffer.getInt():" + paramInt);
        if (paramInt == 1) {}
        for (;;)
        {
          return Boolean.valueOf(bool);
          bool = false;
        }
      }
      throw new RuntimeException("unknown type:" + paramClass);
    }
    int i = paramArrayOfByte.getInt();
    return EpicNative.getObject(paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.entry.Entry
 * JD-Core Version:    0.7.0.1
 */