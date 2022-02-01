package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

final class TypeDeserializer$typeConstructor$1
  extends Lambda
  implements Function1<Integer, ClassDescriptor>
{
  TypeDeserializer$typeConstructor$1(TypeDeserializer paramTypeDeserializer, ProtoBuf.Type paramType)
  {
    super(1);
  }
  
  @NotNull
  public final ClassDescriptor invoke(int paramInt)
  {
    ClassId localClassId = NameResolverUtilKt.getClassId(TypeDeserializer.access$getC$p(this.this$0).getNameResolver(), paramInt);
    List localList = SequencesKt.toMutableList(SequencesKt.map(SequencesKt.generateSequence(this.$proto, (Function1)new TypeDeserializer.typeConstructor.1.typeParametersCount.1(this)), (Function1)TypeDeserializer.typeConstructor.1.typeParametersCount.2.INSTANCE));
    paramInt = SequencesKt.count(SequencesKt.generateSequence(localClassId, (Function1)TypeDeserializer.typeConstructor.1.classNestingLevel.1.INSTANCE));
    while (localList.size() < paramInt) {
      localList.add(Integer.valueOf(0));
    }
    return TypeDeserializer.access$getC$p(this.this$0).getComponents().getNotFoundClasses().getClass(localClassId, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.typeConstructor.1
 * JD-Core Version:    0.7.0.1
 */