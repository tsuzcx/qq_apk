package kotlin.script.dependencies;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/ScriptContents$Position;", "", "line", "", "col", "(II)V", "getCol", "()I", "getLine", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class ScriptContents$Position
{
  private final int col;
  private final int line;
  
  public ScriptContents$Position(int paramInt1, int paramInt2)
  {
    this.line = paramInt1;
    this.col = paramInt2;
  }
  
  public final int component1()
  {
    return this.line;
  }
  
  public final int component2()
  {
    return this.col;
  }
  
  @NotNull
  public final Position copy(int paramInt1, int paramInt2)
  {
    return new Position(paramInt1, paramInt2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Position))
      {
        paramObject = (Position)paramObject;
        if ((this.line == paramObject.line) && (this.col == paramObject.col)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getCol()
  {
    return this.col;
  }
  
  public final int getLine()
  {
    return this.line;
  }
  
  public int hashCode()
  {
    return this.line * 31 + this.col;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Position(line=");
    localStringBuilder.append(this.line);
    localStringBuilder.append(", col=");
    localStringBuilder.append(this.col);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.ScriptContents.Position
 * JD-Core Version:    0.7.0.1
 */