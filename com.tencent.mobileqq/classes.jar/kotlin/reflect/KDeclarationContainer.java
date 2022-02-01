package kotlin.reflect;

import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KDeclarationContainer;", "", "members", "", "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KDeclarationContainer
{
  @NotNull
  public abstract Collection<KCallable<?>> getMembers();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KDeclarationContainer
 * JD-Core Version:    0.7.0.1
 */