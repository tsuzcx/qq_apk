package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface JavaClass
  extends JavaClassifier, JavaModifierListOwner, JavaTypeParameterListOwner
{
  @NotNull
  public abstract Collection<JavaConstructor> getConstructors();
  
  @NotNull
  public abstract Collection<JavaField> getFields();
  
  @Nullable
  public abstract FqName getFqName();
  
  @NotNull
  public abstract Collection<Name> getInnerClassNames();
  
  @Nullable
  public abstract LightClassOriginKind getLightClassOriginKind();
  
  @NotNull
  public abstract Collection<JavaMethod> getMethods();
  
  @Nullable
  public abstract JavaClass getOuterClass();
  
  @NotNull
  public abstract Collection<JavaClassifierType> getSupertypes();
  
  public abstract boolean hasDefaultConstructor();
  
  public abstract boolean isAnnotationType();
  
  public abstract boolean isEnum();
  
  public abstract boolean isInterface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
 * JD-Core Version:    0.7.0.1
 */