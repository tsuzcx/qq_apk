package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaMethod
  extends JavaMember, JavaTypeParameterListOwner
{
  @Nullable
  public abstract JavaAnnotationArgument getAnnotationParameterDefaultValue();
  
  public abstract boolean getHasAnnotationParameterDefaultValue();
  
  @NotNull
  public abstract JavaType getReturnType();
  
  @NotNull
  public abstract List<JavaValueParameter> getValueParameters();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod
 * JD-Core Version:    0.7.0.1
 */