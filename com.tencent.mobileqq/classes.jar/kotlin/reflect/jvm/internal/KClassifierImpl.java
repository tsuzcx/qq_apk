package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KClassifierImpl;", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassifierDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassifierDescriptor;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract interface KClassifierImpl
{
  @NotNull
  public abstract ClassifierDescriptor getDescriptor();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassifierImpl
 * JD-Core Version:    0.7.0.1
 */