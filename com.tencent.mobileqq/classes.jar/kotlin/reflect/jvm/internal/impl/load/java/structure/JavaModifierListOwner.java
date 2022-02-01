package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaModifierListOwner
  extends JavaElement
{
  @NotNull
  public abstract Visibility getVisibility();
  
  public abstract boolean isAbstract();
  
  public abstract boolean isFinal();
  
  public abstract boolean isStatic();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
 * JD-Core Version:    0.7.0.1
 */