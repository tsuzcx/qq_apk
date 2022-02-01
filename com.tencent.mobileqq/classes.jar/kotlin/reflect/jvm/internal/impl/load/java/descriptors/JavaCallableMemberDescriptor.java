package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaCallableMemberDescriptor
  extends CallableMemberDescriptor
{
  @NotNull
  public abstract JavaCallableMemberDescriptor enhance(@Nullable KotlinType paramKotlinType1, @NotNull List<ValueParameterData> paramList, @NotNull KotlinType paramKotlinType2, @Nullable Pair<CallableDescriptor.UserDataKey<?>, ?> paramPair);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor
 * JD-Core Version:    0.7.0.1
 */