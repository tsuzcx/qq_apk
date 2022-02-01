package kotlin.script.experimental.dependencies;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "", "startLine", "", "startColumn", "endLine", "endColumn", "(IILjava/lang/Integer;Ljava/lang/Integer;)V", "getEndColumn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndLine", "getStartColumn", "()I", "getStartLine", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;)Lkotlin/script/experimental/dependencies/ScriptReport$Position;", "equals", "", "other", "hashCode", "toString", "", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public final class ScriptReport$Position
{
  @Nullable
  private final Integer endColumn;
  @Nullable
  private final Integer endLine;
  private final int startColumn;
  private final int startLine;
  
  public ScriptReport$Position(int paramInt1, int paramInt2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    this.startLine = paramInt1;
    this.startColumn = paramInt2;
    this.endLine = paramInteger1;
    this.endColumn = paramInteger2;
  }
  
  public final int component1()
  {
    return this.startLine;
  }
  
  public final int component2()
  {
    return this.startColumn;
  }
  
  @Nullable
  public final Integer component3()
  {
    return this.endLine;
  }
  
  @Nullable
  public final Integer component4()
  {
    return this.endColumn;
  }
  
  @NotNull
  public final Position copy(int paramInt1, int paramInt2, @Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    return new Position(paramInt1, paramInt2, paramInteger1, paramInteger2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Position))
      {
        paramObject = (Position)paramObject;
        if ((this.startLine == paramObject.startLine) && (this.startColumn == paramObject.startColumn) && (Intrinsics.areEqual(this.endLine, paramObject.endLine)) && (Intrinsics.areEqual(this.endColumn, paramObject.endColumn))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final Integer getEndColumn()
  {
    return this.endColumn;
  }
  
  @Nullable
  public final Integer getEndLine()
  {
    return this.endLine;
  }
  
  public final int getStartColumn()
  {
    return this.startColumn;
  }
  
  public final int getStartLine()
  {
    return this.startLine;
  }
  
  public int hashCode()
  {
    int k = this.startLine;
    int m = this.startColumn;
    Integer localInteger = this.endLine;
    int j = 0;
    int i;
    if (localInteger != null) {
      i = localInteger.hashCode();
    } else {
      i = 0;
    }
    localInteger = this.endColumn;
    if (localInteger != null) {
      j = localInteger.hashCode();
    }
    return ((k * 31 + m) * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Position(startLine=");
    localStringBuilder.append(this.startLine);
    localStringBuilder.append(", startColumn=");
    localStringBuilder.append(this.startColumn);
    localStringBuilder.append(", endLine=");
    localStringBuilder.append(this.endLine);
    localStringBuilder.append(", endColumn=");
    localStringBuilder.append(this.endColumn);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.ScriptReport.Position
 * JD-Core Version:    0.7.0.1
 */