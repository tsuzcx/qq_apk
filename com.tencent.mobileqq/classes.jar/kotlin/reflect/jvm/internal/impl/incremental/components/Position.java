package kotlin.reflect.jvm.internal.impl.incremental.components;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Position
  implements Serializable
{
  public static final Position.Companion Companion = new Position.Companion(null);
  @NotNull
  private static final Position NO_POSITION = new Position(-1, -1);
  private final int column;
  private final int line;
  
  public Position(int paramInt1, int paramInt2)
  {
    this.line = paramInt1;
    this.column = paramInt2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Position))
      {
        paramObject = (Position)paramObject;
        if ((this.line == paramObject.line) && (this.column == paramObject.column)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    return this.line * 31 + this.column;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Position(line=");
    localStringBuilder.append(this.line);
    localStringBuilder.append(", column=");
    localStringBuilder.append(this.column);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.components.Position
 * JD-Core Version:    0.7.0.1
 */