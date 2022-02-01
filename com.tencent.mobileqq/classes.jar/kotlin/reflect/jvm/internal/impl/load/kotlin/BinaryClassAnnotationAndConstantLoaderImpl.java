package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BinaryClassAnnotationAndConstantLoaderImpl
  extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>>
{
  private final AnnotationDeserializer annotationDeserializer;
  private final ModuleDescriptor module;
  private final NotFoundClasses notFoundClasses;
  
  public BinaryClassAnnotationAndConstantLoaderImpl(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull NotFoundClasses paramNotFoundClasses, @NotNull StorageManager paramStorageManager, @NotNull KotlinClassFinder paramKotlinClassFinder)
  {
    super(paramStorageManager, paramKotlinClassFinder);
    this.module = paramModuleDescriptor;
    this.notFoundClasses = paramNotFoundClasses;
    this.annotationDeserializer = new AnnotationDeserializer(this.module, this.notFoundClasses);
  }
  
  private final ClassDescriptor resolveClass(ClassId paramClassId)
  {
    return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, paramClassId, this.notFoundClasses);
  }
  
  @Nullable
  protected KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(@NotNull ClassId paramClassId, @NotNull SourceElement paramSourceElement, @NotNull List<AnnotationDescriptor> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "annotationClassId");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    Intrinsics.checkParameterIsNotNull(paramList, "result");
    return (KotlinJvmBinaryClass.AnnotationArgumentVisitor)new BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1(this, resolveClass(paramClassId), paramList, paramSourceElement);
  }
  
  @Nullable
  protected ConstantValue<?> loadConstant(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "desc");
    Intrinsics.checkParameterIsNotNull(paramObject, "initializer");
    CharSequence localCharSequence1 = (CharSequence)"ZBCS";
    CharSequence localCharSequence2 = (CharSequence)paramString;
    boolean bool = false;
    Object localObject = paramObject;
    if (StringsKt.contains$default(localCharSequence1, localCharSequence2, false, 2, null))
    {
      int i = ((Integer)paramObject).intValue();
      int j = paramString.hashCode();
      if (j != 66)
      {
        if (j != 67)
        {
          if (j != 83)
          {
            if ((j == 90) && (paramString.equals("Z")))
            {
              if (i != 0) {
                bool = true;
              }
              localObject = Boolean.valueOf(bool);
              break label181;
            }
          }
          else if (paramString.equals("S"))
          {
            localObject = Short.valueOf((short)i);
            break label181;
          }
        }
        else if (paramString.equals("C"))
        {
          localObject = Character.valueOf((char)i);
          break label181;
        }
      }
      else if (paramString.equals("B"))
      {
        localObject = Byte.valueOf((byte)i);
        break label181;
      }
      throw ((Throwable)new AssertionError(paramString));
    }
    label181:
    return ConstantValueFactory.INSTANCE.createConstantValue(localObject);
  }
  
  @NotNull
  protected AnnotationDescriptor loadTypeAnnotation(@NotNull ProtoBuf.Annotation paramAnnotation, @NotNull NameResolver paramNameResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotation, "proto");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    return this.annotationDeserializer.deserializeAnnotation(paramAnnotation, paramNameResolver);
  }
  
  @Nullable
  protected ConstantValue<?> transformToUnsignedConstant(@NotNull ConstantValue<?> paramConstantValue)
  {
    Intrinsics.checkParameterIsNotNull(paramConstantValue, "constant");
    if ((paramConstantValue instanceof ByteValue)) {
      return (ConstantValue)new UByteValue(((Number)((ByteValue)paramConstantValue).getValue()).byteValue());
    }
    if ((paramConstantValue instanceof ShortValue)) {
      return (ConstantValue)new UShortValue(((Number)((ShortValue)paramConstantValue).getValue()).shortValue());
    }
    if ((paramConstantValue instanceof IntValue)) {
      return (ConstantValue)new UIntValue(((Number)((IntValue)paramConstantValue).getValue()).intValue());
    }
    Object localObject = paramConstantValue;
    if ((paramConstantValue instanceof LongValue)) {
      localObject = (ConstantValue)new ULongValue(((Number)((LongValue)paramConstantValue).getValue()).longValue());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl
 * JD-Core Version:    0.7.0.1
 */