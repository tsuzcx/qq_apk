package kotlin.reflect.jvm;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class ReflectLambdaKt
{
  @Nullable
  public static final <R> KFunction<R> reflect(@NotNull Function<? extends R> paramFunction)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction, "$this$reflect");
    Object localObject2 = (Metadata)paramFunction.getClass().getAnnotation(Metadata.class);
    if (localObject2 != null)
    {
      Object localObject1 = ((Metadata)localObject2).d1();
      int i = localObject1.length;
      boolean bool = true;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        Object localObject3 = JvmProtoBufUtil.readFunctionDataFrom((String[])localObject1, ((Metadata)localObject2).d2());
        localObject1 = (JvmNameResolver)((Pair)localObject3).component1();
        localObject3 = (ProtoBuf.Function)((Pair)localObject3).component2();
        Object localObject4 = ((Metadata)localObject2).mv();
        if ((((Metadata)localObject2).xi() & 0x8) == 0) {
          bool = false;
        }
        localObject2 = new JvmMetadataVersion((int[])localObject4, bool);
        paramFunction = paramFunction.getClass();
        localObject4 = (MessageLite)localObject3;
        localObject1 = (NameResolver)localObject1;
        localObject3 = ((ProtoBuf.Function)localObject3).getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "proto.typeTable");
        paramFunction = (SimpleFunctionDescriptor)UtilKt.deserializeToDescriptor(paramFunction, (MessageLite)localObject4, (NameResolver)localObject1, new TypeTable((ProtoBuf.TypeTable)localObject3), (BinaryVersion)localObject2, (Function2)ReflectLambdaKt.reflect.descriptor.1.INSTANCE);
        if (paramFunction != null) {
          return (KFunction)new KFunctionImpl((KDeclarationContainerImpl)EmptyContainerForLocal.INSTANCE, (FunctionDescriptor)paramFunction);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.ReflectLambdaKt
 * JD-Core Version:    0.7.0.1
 */