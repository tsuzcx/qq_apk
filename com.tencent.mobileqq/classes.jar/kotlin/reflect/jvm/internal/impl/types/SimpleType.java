package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public abstract class SimpleType
  extends UnwrappedType
  implements SimpleTypeMarker, TypeArgumentListMarker
{
  public SimpleType()
  {
    super(null);
  }
  
  @NotNull
  public abstract SimpleType makeNullableAsSpecified(boolean paramBoolean);
  
  @NotNull
  public abstract SimpleType replaceAnnotations(@NotNull Annotations paramAnnotations);
  
  @NotNull
  public String toString()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = getAnnotations().iterator();
    while (localIterator.hasNext())
    {
      AnnotationDescriptor localAnnotationDescriptor = (AnnotationDescriptor)localIterator.next();
      StringsKt.append((StringBuilder)localObject, new String[] { "[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, localAnnotationDescriptor, null, 2, null), "] " });
    }
    ((StringBuilder)localObject).append(getConstructor());
    if ((((Collection)getArguments()).isEmpty() ^ true)) {
      CollectionsKt.joinTo$default((Iterable)getArguments(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, null, null, 112, null);
    }
    if (isMarkedNullable()) {
      ((StringBuilder)localObject).append("?");
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.SimpleType
 * JD-Core Version:    0.7.0.1
 */