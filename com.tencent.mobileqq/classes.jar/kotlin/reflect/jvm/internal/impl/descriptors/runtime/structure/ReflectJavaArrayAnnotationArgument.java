package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaArrayAnnotationArgument
  extends ReflectJavaAnnotationArgument
  implements JavaArrayAnnotationArgument
{
  private final Object[] values;
  
  public ReflectJavaArrayAnnotationArgument(@Nullable Name paramName, @NotNull Object[] paramArrayOfObject)
  {
    super(paramName);
    this.values = paramArrayOfObject;
  }
  
  @NotNull
  public List<ReflectJavaAnnotationArgument> getElements()
  {
    Object[] arrayOfObject = this.values;
    Collection localCollection = (Collection)new ArrayList(arrayOfObject.length);
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      ReflectJavaAnnotationArgument.Factory localFactory = ReflectJavaAnnotationArgument.Factory;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localCollection.add(localFactory.create(localObject, null));
      i += 1;
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaArrayAnnotationArgument
 * JD-Core Version:    0.7.0.1
 */