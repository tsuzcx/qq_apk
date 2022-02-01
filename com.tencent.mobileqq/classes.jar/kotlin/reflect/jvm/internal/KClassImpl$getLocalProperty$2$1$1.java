package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "T", "", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "Lkotlin/ParameterName;", "name", "proto", "invoke"}, k=3, mv={1, 1, 16})
final class KClassImpl$getLocalProperty$2$1$1
  extends FunctionReference
  implements Function2<MemberDeserializer, ProtoBuf.Property, PropertyDescriptor>
{
  public static final 1 INSTANCE;
  
  public final String getName() {}
  
  public final KDeclarationContainer getOwner() {}
  
  public final String getSignature() {}
  
  @NotNull
  public final PropertyDescriptor invoke(@NotNull MemberDeserializer arg1, @NotNull ProtoBuf.Property arg2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.getLocalProperty.2.1.1
 * JD-Core Version:    0.7.0.1
 */