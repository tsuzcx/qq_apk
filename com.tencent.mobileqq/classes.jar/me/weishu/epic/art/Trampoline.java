package me.weishu.epic.art;

import com.qq.android.dexposed.utility.Debug;
import com.qq.android.dexposed.utility.Logger;
import com.qq.android.dexposed.utility.Runtime;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import me.weishu.epic.art.arch.ShellCode;
import me.weishu.epic.art.entry.Entry;
import me.weishu.epic.art.entry.Entry64_2;
import me.weishu.epic.art.method.ArtMethod;

class Trampoline
{
  private static final String TAG = "Trampoline";
  private boolean active;
  private final long jumpToAddress;
  private final byte[] originalCode;
  private Set<ArtMethod> segments = new HashSet();
  private final ShellCode shellCode;
  private long trampolineAddress;
  private int trampolineSize;
  
  Trampoline(ShellCode paramShellCode, long paramLong)
  {
    this.shellCode = paramShellCode;
    this.jumpToAddress = paramShellCode.toMem(paramLong);
    this.originalCode = EpicNative.get(this.jumpToAddress, paramShellCode.sizeOfDirectJump());
  }
  
  private boolean activate()
  {
    long l = getTrampolinePc();
    StringBuilder localStringBuilder = new StringBuilder("Writing direct jump entry ");
    localStringBuilder.append(Debug.addrHex(l));
    localStringBuilder.append(" to origin entry: 0x");
    localStringBuilder.append(Debug.addrHex(this.jumpToAddress));
    Logger.d("Trampoline", localStringBuilder.toString());
    try
    {
      boolean bool = EpicNative.activateNative(this.jumpToAddress, l, this.shellCode.sizeOfDirectJump(), this.shellCode.sizeOfBridgeJump(), this.shellCode.createDirectJump(l));
      return bool;
    }
    finally {}
  }
  
  private void alloc()
  {
    if (this.trampolineAddress != 0L) {
      free();
    }
    this.trampolineSize = getSize();
    this.trampolineAddress = EpicNative.map(this.trampolineSize);
    StringBuilder localStringBuilder = new StringBuilder("Trampoline alloc:");
    localStringBuilder.append(this.trampolineSize);
    localStringBuilder.append(", addr: 0x");
    localStringBuilder.append(Long.toHexString(this.trampolineAddress));
    Logger.d("Trampoline", localStringBuilder.toString());
  }
  
  private byte[] create()
  {
    Object localObject1 = new StringBuilder("create trampoline.");
    ((StringBuilder)localObject1).append(this.segments);
    Logger.d("Trampoline", ((StringBuilder)localObject1).toString());
    localObject1 = new byte[getSize()];
    Object localObject2 = this.segments.iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        localObject2 = this.shellCode.createCallOrigin(this.jumpToAddress, this.originalCode);
        System.arraycopy(localObject2, 0, localObject1, i, localObject2.length);
        return localObject1;
      }
      byte[] arrayOfByte = createTrampoline((ArtMethod)((Iterator)localObject2).next());
      int j = arrayOfByte.length;
      System.arraycopy(arrayOfByte, 0, localObject1, i, j);
      i += j;
    }
  }
  
  private byte[] createTrampoline(ArtMethod paramArtMethod)
  {
    Object localObject = Epic.getMethodInfo(paramArtMethod.getAddress());
    Class localClass = ((Epic.MethodInfo)localObject).returnType;
    if (Runtime.is64Bit()) {
      localObject = Entry64_2.getBridgeMethod((Epic.MethodInfo)localObject);
    } else {
      localObject = Entry.getBridgeMethod(localClass);
    }
    localObject = ArtMethod.of((Method)localObject);
    long l1 = ((ArtMethod)localObject).getAddress();
    long l2 = ((ArtMethod)localObject).getEntryPointFromQuickCompiledCode();
    long l3 = paramArtMethod.getAddress();
    long l4 = EpicNative.malloc(4);
    paramArtMethod = new StringBuilder("targetAddress:");
    paramArtMethod.append(Debug.longHex(l1));
    Logger.d("Trampoline", paramArtMethod.toString());
    paramArtMethod = new StringBuilder("sourceAddress:");
    paramArtMethod.append(Debug.longHex(l3));
    Logger.d("Trampoline", paramArtMethod.toString());
    paramArtMethod = new StringBuilder("targetEntry:");
    paramArtMethod.append(Debug.longHex(l2));
    Logger.d("Trampoline", paramArtMethod.toString());
    paramArtMethod = new StringBuilder("structAddress:");
    paramArtMethod.append(Debug.longHex(l4));
    Logger.d("Trampoline", paramArtMethod.toString());
    return this.shellCode.createBridgeJump(l1, l2, l3, l4);
  }
  
  private void free()
  {
    long l = this.trampolineAddress;
    if (l != 0L)
    {
      EpicNative.unmap(l, this.trampolineSize);
      this.trampolineAddress = 0L;
      this.trampolineSize = 0;
    }
    if (this.active) {
      EpicNative.put(this.originalCode, this.jumpToAddress);
    }
  }
  
  private int getSize()
  {
    return this.shellCode.sizeOfBridgeJump() * this.segments.size() + 0 + this.shellCode.sizeOfCallOrigin();
  }
  
  private long getTrampolineAddress()
  {
    if (getSize() != this.trampolineSize) {
      alloc();
    }
    return this.trampolineAddress;
  }
  
  private long getTrampolinePc()
  {
    return this.shellCode.toPC(getTrampolineAddress());
  }
  
  protected void finalize()
  {
    free();
    super.finalize();
  }
  
  public boolean install(ArtMethod paramArtMethod)
  {
    StringBuilder localStringBuilder;
    if (!this.segments.add(paramArtMethod))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArtMethod);
      localStringBuilder.append(" is already hooked, return.");
      Logger.d("Trampoline", localStringBuilder.toString());
      return true;
    }
    EpicNative.put(create(), getTrampolineAddress());
    int i = Epic.getQuickCompiledCodeSize(paramArtMethod);
    if (i < this.shellCode.sizeOfDirectJump())
    {
      localStringBuilder = new StringBuilder(String.valueOf(paramArtMethod.toGenericString()));
      localStringBuilder.append(" quickCompiledCodeSize: ");
      localStringBuilder.append(i);
      Logger.w("Trampoline", localStringBuilder.toString());
      paramArtMethod.setEntryPointFromQuickCompiledCode(getTrampolinePc());
      return true;
    }
    return activate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.Trampoline
 * JD-Core Version:    0.7.0.1
 */