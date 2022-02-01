package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SubtypePathNode
{
  @Nullable
  private final SubtypePathNode previous;
  @NotNull
  private final KotlinType type;
  
  public SubtypePathNode(@NotNull KotlinType paramKotlinType, @Nullable SubtypePathNode paramSubtypePathNode)
  {
    this.type = paramKotlinType;
    this.previous = paramSubtypePathNode;
  }
  
  @Nullable
  public final SubtypePathNode getPrevious()
  {
    return this.previous;
  }
  
  @NotNull
  public final KotlinType getType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.SubtypePathNode
 * JD-Core Version:    0.7.0.1
 */