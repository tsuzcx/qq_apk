package com.tencent.xaction.api.util;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/Weak;", "T", "", "()V", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "weakReference", "Ljava/lang/ref/WeakReference;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class Weak<T>
{
  private WeakReference<T> a;
  
  public Weak()
  {
    this((Function0)Weak.1.INSTANCE);
  }
  
  public Weak(@NotNull Function0<? extends T> paramFunction0)
  {
    this.a = new WeakReference(paramFunction0.invoke());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.util.Weak
 * JD-Core Version:    0.7.0.1
 */