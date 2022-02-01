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
import java.lang.reflect.Member;
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
    if (paramConstructor != null)
    {
      this.constructor = paramConstructor;
      init();
      return;
    }
    throw new IllegalArgumentException("constructor can not be null");
  }
  
  private ArtMethod(Method paramMethod)
  {
    if (paramMethod != null)
    {
      this.method = paramMethod;
      init();
      return;
    }
    throw new IllegalArgumentException("method can not be null");
  }
  
  public static int getArtMethodSize()
  {
    int i = artMethodSize;
    if (i > 0) {
      return i;
    }
    Object localObject = XposedHelpers.findMethodExact(ArtMethod.class, "rule1", new Class[0]);
    long l = Math.abs(EpicNative.getMethodAddress(XposedHelpers.findMethodExact(ArtMethod.class, "rule2", new Class[0])) - EpicNative.getMethodAddress((Member)localObject));
    artMethodSize = (int)l;
    localObject = new StringBuilder("art Method size: ");
    ((StringBuilder)localObject).append(l);
    Logger.d("ArtMethod", ((StringBuilder)localObject).toString());
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
    Constructor localConstructor = this.constructor;
    if (localConstructor != null)
    {
      this.address = EpicNative.getMethodAddress(localConstructor);
      this.objectAddress = Unsafe.getObjectAddress(this.constructor);
      return;
    }
    this.address = EpicNative.getMethodAddress(this.method);
    this.objectAddress = Unsafe.getObjectAddress(this.method);
  }
  
  private Object invokeInternal(Object paramObject, Object... paramVarArgs)
  {
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.newInstance(paramVarArgs);
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
    long l1 = paramLong2 / 4L;
    for (paramLong2 = 0L;; paramLong2 += 1L)
    {
      if (paramLong2 >= l1) {
        return -1L;
      }
      Long.signum(paramLong2);
      long l2 = paramLong2 * 4L;
      byte[] arrayOfByte = EpicNative.memget(paramLong1 + l2, 4);
      if (ByteBuffer.allocate(4).put(arrayOfByte).getInt() == paramInt) {
        return l2;
      }
    }
  }
  
  public static long searchOffset(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong2 / 4L;
    for (paramLong2 = 0L;; paramLong2 += 1L)
    {
      if (paramLong2 >= l1) {
        return -1L;
      }
      Long.signum(paramLong2);
      long l2 = paramLong2 * 4L;
      byte[] arrayOfByte = EpicNative.memget(paramLong1 + l2, 4);
      if (ByteBuffer.allocate(8).put(arrayOfByte).getLong() == paramLong3) {
        return l2;
      }
    }
  }
  
  public ArtMethod backup()
  {
    try
    {
      localObject4 = Method.class.getSuperclass();
      localObject3 = getExecutable();
      j = Build.VERSION.SDK_INT;
      i = 0;
      if (j < 23)
      {
        localObject1 = Class.forName("java.lang.reflect.ArtMethod");
        localObject4 = ((Class)localObject4).getDeclaredField("artMethod");
        if (!((Field)localObject4).isAccessible()) {
          ((Field)localObject4).setAccessible(true);
        }
        localObject3 = ((Field)localObject4).get(localObject3);
        localObject4 = ((Class)localObject1).getDeclaredConstructor(new Class[0]);
        ((Constructor)localObject4).setAccessible(true);
        localObject4 = ((Constructor)localObject4).newInstance(new Object[0]);
        localObject5 = ((Class)localObject1).getDeclaredFields();
        j = localObject5.length;
        i = 0;
        for (;;)
        {
          if (i >= j)
          {
            localObject1 = (Method)Method.class.getConstructor(new Class[] { localObject1 }).newInstance(new Object[] { localObject4 });
            ((Method)localObject1).setAccessible(true);
            localObject1 = of((Method)localObject1);
            ((ArtMethod)localObject1).setEntryPointFromQuickCompiledCode(getEntryPointFromQuickCompiledCode());
            ((ArtMethod)localObject1).setEntryPointFromJni(getEntryPointFromJni());
            break;
          }
          localObject6 = localObject5[i];
          if (!localObject6.isAccessible()) {
            localObject6.setAccessible(true);
          }
          localObject6.set(localObject4, localObject6.get(localObject3));
          i += 1;
        }
      }
      localObject5 = Method.class.getDeclaredConstructor(new Class[0]);
      if (Build.VERSION.SDK_INT != 23) {
        break label471;
      }
      localObject1 = "flag";
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject4;
        int j;
        int i;
        Object localObject1;
        Object localObject5;
        Object localObject6;
        Log.e("ArtMethod", "backup method error:", localThrowable);
        Object localObject3 = new StringBuilder("Cannot create backup method from :: ");
        ((StringBuilder)localObject3).append(getExecutable());
        Object localObject2 = new IllegalStateException(((StringBuilder)localObject3).toString(), localThrowable);
        for (;;)
        {
          throw ((Throwable)localObject2);
        }
        label471:
        localObject2 = "override";
      }
    }
    localObject1 = AccessibleObject.class.getDeclaredField((String)localObject1);
    ((Field)localObject1).setAccessible(true);
    ((Field)localObject1).set(localObject5, Boolean.valueOf(true));
    localObject1 = (Method)((Constructor)localObject5).newInstance(new Object[0]);
    ((Method)localObject1).setAccessible(true);
    localObject5 = ((Class)localObject4).getDeclaredFields();
    j = localObject5.length;
    for (;;)
    {
      if (i >= j)
      {
        localObject3 = ((Class)localObject4).getDeclaredField("artMethod");
        ((Field)localObject3).setAccessible(true);
        i = getArtMethodSize();
        long l = EpicNative.map(i);
        EpicNative.put(EpicNative.get(this.address, i), l);
        ((Field)localObject3).set(localObject1, Long.valueOf(l));
        localObject1 = of((Method)localObject1);
        ((ArtMethod)localObject1).makePrivate();
        ((ArtMethod)localObject1).setAccessible(true);
        ((ArtMethod)localObject1).origin = this;
        return localObject1;
      }
      localObject6 = localObject5[i];
      localObject6.setAccessible(true);
      localObject6.set(localObject1, localObject6.get(localObject3));
      i += 1;
    }
  }
  
  public boolean compile()
  {
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return EpicNative.compileMethod(localConstructor);
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
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.getDeclaringClass();
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
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.getExceptionTypes();
    }
    return this.method.getExceptionTypes();
  }
  
  public Object getExecutable()
  {
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor;
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
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.getModifiers();
    }
    return this.method.getModifiers();
  }
  
  public String getName()
  {
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.getName();
    }
    return this.method.getName();
  }
  
  public Class<?>[] getParameterTypes()
  {
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.getParameterTypes();
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
        StringBuilder localStringBuilder = new StringBuilder("the address of java method was moved by gc, backup it now! origin address: 0x");
        localStringBuilder.append(Long.toHexString(this.objectAddress));
        localStringBuilder.append(" , currentAddress: 0x");
        localStringBuilder.append(Long.toHexString(l));
        Logger.i("ArtMethod", localStringBuilder.toString());
        Epic.setBackMethod(this.origin, localArtMethod);
        return localArtMethod.invokeInternal(paramObject, paramVarArgs);
      }
      Logger.i("ArtMethod", "the address is same with last invoke, not moved by gc");
    }
    return invokeInternal(paramObject, paramVarArgs);
  }
  
  public boolean isAccessible()
  {
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.isAccessible();
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
    Constructor localConstructor = this.constructor;
    if (localConstructor != null)
    {
      localConstructor.setAccessible(paramBoolean);
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
    Constructor localConstructor = this.constructor;
    if (localConstructor != null) {
      return localConstructor.toGenericString();
    }
    return this.method.toGenericString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.method.ArtMethod
 * JD-Core Version:    0.7.0.1
 */