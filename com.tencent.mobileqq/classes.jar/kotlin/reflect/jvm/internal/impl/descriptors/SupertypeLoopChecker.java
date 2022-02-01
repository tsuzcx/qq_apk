package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public abstract interface SupertypeLoopChecker
{
  @NotNull
  public abstract Collection<KotlinType> findLoopsInSupertypesAndDisconnect(@NotNull TypeConstructor paramTypeConstructor, @NotNull Collection<? extends KotlinType> paramCollection, @NotNull Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> paramFunction1, @NotNull Function1<? super KotlinType, Unit> paramFunction11);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
 * JD-Core Version:    0.7.0.1
 */