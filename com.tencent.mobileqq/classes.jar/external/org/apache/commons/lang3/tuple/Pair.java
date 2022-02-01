package external.org.apache.commons.lang3.tuple;

import external.org.apache.commons.lang3.ObjectUtils;
import external.org.apache.commons.lang3.builder.CompareToBuilder;
import java.io.Serializable;
import java.util.Map.Entry;

public abstract class Pair<L, R>
  implements Serializable, Comparable<Pair<L, R>>, Map.Entry<L, R>
{
  private static final long serialVersionUID = 4954918890077093841L;
  
  public static <L, R> Pair<L, R> of(L paramL, R paramR)
  {
    return new ImmutablePair(paramL, paramR);
  }
  
  public int compareTo(Pair<L, R> paramPair)
  {
    return new CompareToBuilder().append(getLeft(), paramPair.getLeft()).append(getRight(), paramPair.getRight()).toComparison();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Map.Entry)) {
        break;
      }
      paramObject = (Map.Entry)paramObject;
    } while ((ObjectUtils.equals(getKey(), paramObject.getKey())) && (ObjectUtils.equals(getValue(), paramObject.getValue())));
    return false;
    return false;
  }
  
  public final L getKey()
  {
    return getLeft();
  }
  
  public abstract L getLeft();
  
  public abstract R getRight();
  
  public R getValue()
  {
    return getRight();
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (getKey() == null)
    {
      i = 0;
      if (getValue() != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = getKey().hashCode();
      break;
      label33:
      j = getValue().hashCode();
    }
  }
  
  public String toString()
  {
    return '(' + getLeft() + ',' + getRight() + ')';
  }
  
  public String toString(String paramString)
  {
    return String.format(paramString, new Object[] { getLeft(), getRight() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.tuple.Pair
 * JD-Core Version:    0.7.0.1
 */