package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"}, k=1, mv={1, 1, 16})
final class JobSupport$Finishing
  implements Incomplete
{
  private volatile Object _exceptionsHolder;
  private volatile int _isCompleting;
  private volatile Object _rootCause;
  @NotNull
  private final NodeList list;
  
  public JobSupport$Finishing(@NotNull NodeList paramNodeList, boolean paramBoolean, @Nullable Throwable paramThrowable) {}
  
  private final ArrayList<Throwable> allocateList()
  {
    return new ArrayList(4);
  }
  
  private final Object getExceptionsHolder()
  {
    return this._exceptionsHolder;
  }
  
  private final void setExceptionsHolder(Object paramObject)
  {
    this._exceptionsHolder = paramObject;
  }
  
  public final void addExceptionLocked(@NotNull Throwable paramThrowable)
  {
    Object localObject = getRootCause();
    if (localObject == null)
    {
      setRootCause(paramThrowable);
      return;
    }
    if (paramThrowable == localObject) {
      return;
    }
    localObject = getExceptionsHolder();
    if (localObject == null)
    {
      setExceptionsHolder(paramThrowable);
      return;
    }
    if ((localObject instanceof Throwable))
    {
      if (paramThrowable == localObject) {
        return;
      }
      ArrayList localArrayList = allocateList();
      localArrayList.add(localObject);
      localArrayList.add(paramThrowable);
      setExceptionsHolder(localArrayList);
      return;
    }
    if ((localObject instanceof ArrayList))
    {
      ((ArrayList)localObject).add(paramThrowable);
      return;
    }
    paramThrowable = new StringBuilder();
    paramThrowable.append("State is ");
    paramThrowable.append(localObject);
    throw ((Throwable)new IllegalStateException(paramThrowable.toString().toString()));
  }
  
  @NotNull
  public NodeList getList()
  {
    return this.list;
  }
  
  @Nullable
  public final Throwable getRootCause()
  {
    return (Throwable)this._rootCause;
  }
  
  public boolean isActive()
  {
    return getRootCause() == null;
  }
  
  public final boolean isCancelling()
  {
    return getRootCause() != null;
  }
  
  public final boolean isCompleting()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isSealed()
  {
    return getExceptionsHolder() == JobSupportKt.access$getSEALED$p();
  }
  
  @NotNull
  public final List<Throwable> sealLocked(@Nullable Throwable paramThrowable)
  {
    Object localObject = getExceptionsHolder();
    ArrayList localArrayList;
    if (localObject == null)
    {
      localArrayList = allocateList();
    }
    else if ((localObject instanceof Throwable))
    {
      localArrayList = allocateList();
      localArrayList.add(localObject);
    }
    else
    {
      if (!(localObject instanceof ArrayList)) {
        break label97;
      }
      localArrayList = (ArrayList)localObject;
    }
    localObject = getRootCause();
    if (localObject != null) {
      localArrayList.add(0, localObject);
    }
    if ((paramThrowable != null) && ((Intrinsics.areEqual(paramThrowable, localObject) ^ true))) {
      localArrayList.add(paramThrowable);
    }
    setExceptionsHolder(JobSupportKt.access$getSEALED$p());
    return (List)localArrayList;
    label97:
    paramThrowable = new StringBuilder();
    paramThrowable.append("State is ");
    paramThrowable.append(localObject);
    throw ((Throwable)new IllegalStateException(paramThrowable.toString().toString()));
  }
  
  public final void setCompleting(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setRootCause(@Nullable Throwable paramThrowable)
  {
    this._rootCause = paramThrowable;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Finishing[cancelling=");
    localStringBuilder.append(isCancelling());
    localStringBuilder.append(", completing=");
    localStringBuilder.append(isCompleting());
    localStringBuilder.append(", rootCause=");
    localStringBuilder.append(getRootCause());
    localStringBuilder.append(", exceptions=");
    localStringBuilder.append(getExceptionsHolder());
    localStringBuilder.append(", list=");
    localStringBuilder.append(getList());
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.JobSupport.Finishing
 * JD-Core Version:    0.7.0.1
 */