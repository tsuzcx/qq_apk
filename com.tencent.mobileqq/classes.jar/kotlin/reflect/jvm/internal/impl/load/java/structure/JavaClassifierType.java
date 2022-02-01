package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaClassifierType
  extends JavaAnnotationOwner, JavaType
{
  @Nullable
  public abstract JavaClassifier getClassifier();
  
  @NotNull
  public abstract String getClassifierQualifiedName();
  
  @NotNull
  public abstract String getPresentableText();
  
  @NotNull
  public abstract List<JavaType> getTypeArguments();
  
  public abstract boolean isRaw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
 * JD-Core Version:    0.7.0.1
 */