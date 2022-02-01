package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JvmDescriptorTypeWriter<T>
{
  @Nullable
  private T jvmCurrentType;
  private int jvmCurrentTypeArrayLevel;
  private final JvmTypeFactory<T> jvmTypeFactory;
  
  public void writeArrayEnd() {}
  
  public void writeArrayType()
  {
    if (this.jvmCurrentType == null)
    {
      this.jvmCurrentTypeArrayLevel += 1;
      int i = this.jvmCurrentTypeArrayLevel;
    }
  }
  
  public void writeClass(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "objectType");
    writeJvmTypeAsIs(paramT);
  }
  
  protected final void writeJvmTypeAsIs(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "type");
    if (this.jvmCurrentType == null)
    {
      Object localObject = paramT;
      if (this.jvmCurrentTypeArrayLevel > 0)
      {
        localObject = this.jvmTypeFactory;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(StringsKt.repeat((CharSequence)"[", this.jvmCurrentTypeArrayLevel));
        localStringBuilder.append(this.jvmTypeFactory.toString(paramT));
        localObject = ((JvmTypeFactory)localObject).createFromString(localStringBuilder.toString());
      }
      this.jvmCurrentType = localObject;
    }
  }
  
  public void writeTypeVariable(@NotNull Name paramName, @NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramT, "type");
    writeJvmTypeAsIs(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmDescriptorTypeWriter
 * JD-Core Version:    0.7.0.1
 */