package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public abstract interface JavaNamedElement
  extends JavaElement
{
  @NotNull
  public abstract Name getName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
 * JD-Core Version:    0.7.0.1
 */