package kotlin.reflect.jvm.internal.impl.types;

public abstract class TypeProjectionBase
  implements TypeProjection
{
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TypeProjection)) {
      return false;
    }
    paramObject = (TypeProjection)paramObject;
    if (isStarProjection() != paramObject.isStarProjection()) {
      return false;
    }
    if (getProjectionKind() != paramObject.getProjectionKind()) {
      return false;
    }
    return getType().equals(paramObject.getType());
  }
  
  public int hashCode()
  {
    int j = getProjectionKind().hashCode();
    if (TypeUtils.noExpectedType(getType())) {
      return j * 31 + 19;
    }
    int i;
    if (isStarProjection()) {
      i = 17;
    } else {
      i = getType().hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    if (isStarProjection()) {
      return "*";
    }
    if (getProjectionKind() == Variance.INVARIANT) {
      return getType().toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getProjectionKind());
    localStringBuilder.append(" ");
    localStringBuilder.append(getType());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase
 * JD-Core Version:    0.7.0.1
 */