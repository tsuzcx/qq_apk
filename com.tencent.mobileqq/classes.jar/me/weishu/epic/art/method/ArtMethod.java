package me.weishu.epic.art.method;

import android.os.Build.VERSION;
import android.util.Log;
import com.qq.android.dexposed.XposedHelpers;
import com.qq.android.dexposed.utility.Logger;
import com.qq.android.dexposed.utility.NeverCalled;
import com.qq.android.dexposed.utility.Unsafe;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import me.weishu.epic.art.Epic;
import me.weishu.epic.art.EpicNative;

public class ArtMethod
{
  private static final String TAG = "ArtMethod";
  private static int artMethodSize = -1;
  private long address;
  private Constructor constructor;
  private Method method;
  private long objectAddress;
  private ArtMethod origin;
  
  private ArtMethod(Constructor paramConstructor)
  {
    if (paramConstructor == null) {
      throw new IllegalArgumentException("constructor can not be null");
    }
    this.constructor = paramConstructor;
    init();
  }
  
  private ArtMethod(Method paramMethod)
  {
    if (paramMethod == null) {
      throw new IllegalArgumentException("method can not be null");
    }
    this.method = paramMethod;
    init();
  }
  
  public static int getArtMethodSize()
  {
    if (artMethodSize > 0) {
      return artMethodSize;
    }
    Method localMethod = XposedHelpers.findMethodExact(ArtMethod.class, "rule1", new Class[0]);
    long l = Math.abs(EpicNative.getMethodAddress(XposedHelpers.findMethodExact(ArtMethod.class, "rule2", new Class[0])) - EpicNative.getMethodAddress(localMethod));
    artMethodSize = (int)l;
    Logger.d("ArtMethod", "art Method size: " + l);
    return artMethodSize;
  }
  
  public static long getQuickToInterpreterBridge()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return -1L;
    }
    return of(XposedHelpers.findMethodExact(NeverCalled.class, "fake", new Class[] { Integer.TYPE })).getEntryPointFromQuickCompiledCode();
  }
  
  private void init()
  {
    if (this.constructor != null)
    {
      this.address = EpicNative.getMethodAddress(this.constructor);
      this.objectAddress = Unsafe.getObjectAddress(this.constructor);
      return;
    }
    this.address = EpicNative.getMethodAddress(this.method);
    this.objectAddress = Unsafe.getObjectAddress(this.method);
  }
  
  private Object invokeInternal(Object paramObject, Object... paramVarArgs)
  {
    if (this.constructor != null) {
      return this.constructor.newInstance(paramVarArgs);
    }
    return this.method.invoke(paramObject, paramVarArgs);
  }
  
  public static ArtMethod of(Constructor paramConstructor)
  {
    return new ArtMethod(paramConstructor);
  }
  
  public static ArtMethod of(Method paramMethod)
  {
    return new ArtMethod(paramMethod);
  }
  
  private void rule1()
  {
    Log.i("ArtMethod", "do not inline me!!");
  }
  
  private void rule2()
  {
    Log.i("ArtMethod", "do not inline me!!");
  }
  
  public static long searchOffset(long paramLong1, long paramLong2, int paramInt)
  {
    long l2 = paramLong2 / 4L;
    for (paramLong2 = 0L;; paramLong2 = 1L + paramLong2)
    {
      long l1;
      if (paramLong2 >= l2) {
        l1 = -1L;
      }
      byte[] arrayOfByte;
      do
      {
        return l1;
        l1 = paramLong2 * 4L;
        arrayOfByte = EpicNative.memget(paramLong2 * 4L + paramLong1, 4);
      } while (ByteBuffer.allocate(4).put(arrayOfByte).getInt() == paramInt);
    }
  }
  
  public static long searchOffset(long paramLong1, long paramLong2, long paramLong3)
  {
    long l2 = paramLong2 / 4L;
    for (paramLong2 = 0L;; paramLong2 = 1L + paramLong2)
    {
      long l1;
      if (paramLong2 >= l2) {
        l1 = -1L;
      }
      byte[] arrayOfByte;
      do
      {
        return l1;
        l1 = 4L * paramLong2;
        arrayOfByte = EpicNative.memget(4L * paramLong2 + paramLong1, 4);
      } while (ByteBuffer.allocate(8).put(arrayOfByte).getLong() == paramLong3);
    }
  }
  
  public ArtMethod backup()
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject3 = Method.class.getSuperclass();
        Object localObject2 = getExecutable();
        Object localObject1;
        Object localObject5;
        if (Build.VERSION.SDK_INT < 23)
        {
          localObject1 = Class.forName("java.lang.reflect.ArtMethod");
          localObject3 = ((Class)localObject3).getDeclaredField("artMethod");
          if (!((Field)localObject3).isAccessible()) {
            ((Field)localObject3).setAccessible(true);
          }
          localObject2 = ((Field)localObject3).get(localObject2);
          localObject3 = ((Class)localObject1).getDeclaredConstructor(new Class[0]);
          ((Constructor)localObject3).setAccessible(true);
          localObject3 = ((Constructor)localObject3).newInstance(new Object[0]);
          localObject4 = ((Class)localObject1).getDeclaredFields();
          j = localObject4.length;
          if (i >= j)
          {
            localObject1 = (Method)Method.class.getConstructor(new Class[] { localObject1 }).newInstance(new Object[] { localObject3 });
            ((Method)localObject1).setAccessible(true);
            localObject1 = of((Method)localObject1);
            ((ArtMethod)localObject1).setEntryPointFromQuickCompiledCode(getEntryPointFromQuickCompiledCode());
            ((ArtMethod)localObject1).setEntryPointFromJni(getEntryPointFromJni());
            ((ArtMethod)localObject1).makePrivate();
            ((ArtMethod)localObject1).setAccessible(true);
            ((ArtMethod)localObject1).origin = this;
            return localObject1;
          }
          localObject5 = localObject4[i];
          if (!localObject5.isAccessible()) {
            localObject5.setAccessible(true);
          }
          localObject5.set(localObject3, localObject5.get(localObject2));
          i += 1;
          continue;
        }
        Object localObject4 = Method.class.getDeclaredConstructor(new Class[0]);
        if (Build.VERSION.SDK_INT == 23)
        {
          localObject1 = "flag";
          localObject1 = AccessibleObject.class.getDeclaredField((String)localObject1);
          ((Field)localObject1).setAccessible(true);
          ((Field)localObject1).set(localObject4, Boolean.valueOf(true));
          localObject1 = (Method)((Constructor)localObject4).newInstance(new Object[0]);
          ((Method)localObject1).setAccessible(true);
          localObject4 = ((Class)localObject3).getDeclaredFields();
          int k = localObject4.length;
          i = j;
          if (i >= k)
          {
            localObject2 = ((Class)localObject3).getDeclaredField("artMethod");
            ((Field)localObject2).setAccessible(true);
            i = getArtMethodSize();
            long l = EpicNative.map(i);
            EpicNative.put(EpicNative.get(this.address, i), l);
            ((Field)localObject2).set(localObject1, Long.valueOf(l));
            localObject1 = of((Method)localObject1);
          }
          else
          {
            localObject5 = localObject4[i];
            localObject5.setAccessible(true);
            localObject5.set(localObject1, localObject5.get(localObject2));
            i += 1;
          }
        }
        else
        {
          String str = "override";
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("ArtMethod", "backup method error:", localThrowable);
        throw new IllegalStateException("Cannot create backup method from :: " + getExecutable(), localThrowable);
      }
    }
  }
  
  public boolean compile()
  {
    if (this.constructor != null) {
      return EpicNative.compileMethod(this.constructor);
    }
    return EpicNative.compileMethod(this.method);
  }
  
  public void ensureResolved()
  {
    if (!Modifier.isStatic(getModifiers()))
    {
      Logger.d("ArtMethod", "not static, ignore.");
      return;
    }
    try
    {
      invoke(null, new Object[0]);
      Logger.d("ArtMethod", "ensure resolved");
      return;
    }
    catch (Exception localException) {}
  }
  
  public int getAccessFlags()
  {
    return (int)Offset.read(this.address, Offset.ART_ACCESS_FLAG_OFFSET);
  }
  
  public long getAddress()
  {
    return this.address;
  }
  
  public Class<?> getDeclaringClass()
  {
    if (this.constructor != null) {
      return this.constructor.getDeclaringClass();
    }
    return this.method.getDeclaringClass();
  }
  
  public long getEntryPointFromJni()
  {
    return Offset.read(this.address, Offset.ART_JNI_ENTRY_OFFSET);
  }
  
  public long getEntryPointFromQuickCompiledCode()
  {
    return Offset.read(this.address, Offset.ART_QUICK_CODE_OFFSET);
  }
  
  public Class<?>[] getExceptionTypes()
  {
    if (this.constructor != null) {
      return this.constructor.getExceptionTypes();
    }
    return this.method.getExceptionTypes();
  }
  
  public Object getExecutable()
  {
    if (this.constructor != null) {
      return this.constructor;
    }
    return this.method;
  }
  
  public long getFieldOffset()
  {
    return 0L;
  }
  
  public String getIdentifier()
  {
    return String.valueOf(getAddress());
  }
  
  public int getModifiers()
  {
    if (this.constructor != null) {
      return this.constructor.getModifiers();
    }
    return this.method.getModifiers();
  }
  
  public String getName()
  {
    if (this.constructor != null) {
      return this.constructor.getName();
    }
    return this.method.getName();
  }
  
  public Class<?>[] getParameterTypes()
  {
    if (this.constructor != null) {
      return this.constructor.getParameterTypes();
    }
    return this.method.getParameterTypes();
  }
  
  public Class<?> getReturnType()
  {
    if (this.constructor != null) {
      return Object.class;
    }
    return this.method.getReturnType();
  }
  
  public Object invoke(Object paramObject, Object... paramVarArgs)
  {
    if ((Build.VERSION.SDK_INT >= 24) && (this.origin != null))
    {
      long l = Unsafe.getObjectAddress(getExecutable());
      if (l != this.objectAddress)
      {
        ArtMethod localArtMethod = this.origin.backup();
        Logger.i("ArtMethod", "the address of java method was moved by gc, backup it now! origin address: 0x" + Long.toHexString(this.objectAddress) + " , currentAddress: 0x" + Long.toHexString(l));
        Epic.setBackMethod(this.origin, localArtMethod);
        return localArtMethod.invokeInternal(paramObject, paramVarArgs);
      }
      Logger.i("ArtMethod", "the address is same with last invoke, not moved by gc");
    }
    return invokeInternal(paramObject, paramVarArgs);
  }
  
  public boolean isAccessible()
  {
    if (this.constructor != null) {
      return this.constructor.isAccessible();
    }
    return this.method.isAccessible();
  }
  
  public void makePrivate()
  {
    setAccessFlags(getAccessFlags() & 0xFFFFFFFE | 0x2);
  }
  
  public void setAccessFlags(int paramInt)
  {
    Offset.write(this.address, Offset.ART_ACCESS_FLAG_OFFSET, paramInt);
  }
  
  public void setAccessible(boolean paramBoolean)
  {
    if (this.constructor != null)
    {
      this.constructor.setAccessible(paramBoolean);
      return;
    }
    this.method.setAccessible(paramBoolean);
  }
  
  public void setEntryPointFromJni(long paramLong)
  {
    Offset.write(this.address, Offset.ART_JNI_ENTRY_OFFSET, paramLong);
  }
  
  public void setEntryPointFromQuickCompiledCode(long paramLong)
  {
    Offset.write(this.address, Offset.ART_QUICK_CODE_OFFSET, paramLong);
  }
  
  public String toGenericString()
  {
    if (this.constructor != null) {
      return this.constructor.toGenericString();
    }
    return this.method.toGenericString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.weishu.epic.art.method.ArtMethod
 * JD-Core Version:    0.7.0.1
 */