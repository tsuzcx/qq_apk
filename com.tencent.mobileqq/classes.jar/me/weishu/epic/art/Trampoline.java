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
    Logger.d("Trampoline", "Writing direct jump entry " + Debug.addrHex(l) + " to origin entry: 0x" + Debug.addrHex(this.jumpToAddress));
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
    Logger.d("Trampoline", "Trampoline alloc:" + this.trampolineSize + ", addr: 0x" + Long.toHexString(this.trampolineAddress));
  }
  
  private byte[] create()
  {
    Logger.d("Trampoline", "create trampoline." + this.segments);
    byte[] arrayOfByte1 = new byte[getSize()];
    Object localObject = this.segments.iterator();
    int i = 0;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localObject = this.shellCode.createCallOrigin(this.jumpToAddress, this.originalCode);
        System.arraycopy(localObject, 0, arrayOfByte1, i, localObject.length);
        return arrayOfByte1;
      }
      byte[] arrayOfByte2 = createTrampoline((ArtMethod)((Iterator)localObject).next());
      int j = arrayOfByte2.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, j);
      i += j;
    }
  }
  
  private byte[] createTrampoline(ArtMethod paramArtMethod)
  {
    Object localObject = Epic.getMethodInfo(paramArtMethod.getAddress());
    Class localClass = ((Epic.MethodInfo)localObject).returnType;
    if (Runtime.is64Bit()) {}
    for (localObject = Entry64_2.getBridgeMethod((Epic.MethodInfo)localObject);; localObject = Entry.getBridgeMethod(localClass))
    {
      localObject = ArtMethod.of((Method)localObject);
      long l1 = ((ArtMethod)localObject).getAddress();
      long l2 = ((ArtMethod)localObject).getEntryPointFromQuickCompiledCode();
      long l3 = paramArtMethod.getAddress();
      long l4 = EpicNative.malloc(4);
      Logger.d("Trampoline", "targetAddress:" + Debug.longHex(l1));
      Logger.d("Trampoline", "sourceAddress:" + Debug.longHex(l3));
      Logger.d("Trampoline", "targetEntry:" + Debug.longHex(l2));
      Logger.d("Trampoline", "structAddress:" + Debug.longHex(l4));
      return this.shellCode.createBridgeJump(l1, l2, l3, l4);
    }
  }
  
  private void free()
  {
    if (this.trampolineAddress != 0L)
    {
      EpicNative.unmap(this.trampolineAddress, this.trampolineSize);
      this.trampolineAddress = 0L;
      this.trampolineSize = 0;
    }
    if (this.active) {
      EpicNative.put(this.originalCode, this.jumpToAddress);
    }
  }
  
  private int getSize()
  {
    return 0 + this.shellCode.sizeOfBridgeJump() * this.segments.size() + this.shellCode.sizeOfCallOrigin();
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
    if (!this.segments.add(paramArtMethod))
    {
      Logger.d("Trampoline", paramArtMethod + " is already hooked, return.");
      return true;
    }
    EpicNative.put(create(), getTrampolineAddress());
    int i = Epic.getQuickCompiledCodeSize(paramArtMethod);
    if (i < this.shellCode.sizeOfDirectJump())
    {
      Logger.w("Trampoline", paramArtMethod.toGenericString() + " quickCompiledCodeSize: " + i);
      paramArtMethod.setEntryPointFromQuickCompiledCode(getTrampolinePc());
      return true;
    }
    return activate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     me.weishu.epic.art.Trampoline
 * JD-Core Version:    0.7.0.1
 */