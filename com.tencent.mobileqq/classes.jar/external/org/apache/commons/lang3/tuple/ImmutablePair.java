package external.org.apache.commons.lang3.tuple;

public final class ImmutablePair<L, R>
  extends Pair<L, R>
{
  private static final long serialVersionUID = 4954918890077093841L;
  public final L left;
  public final R right;
  
  public ImmutablePair(L paramL, R paramR)
  {
    this.left = paramL;
    this.right = paramR;
  }
  
  public static <L, R> ImmutablePair<L, R> of(L paramL, R paramR)
  {
    return new ImmutablePair(paramL, paramR);
  }
  
  public L getLeft()
  {
    return this.left;
  }
  
  public R getRight()
  {
    return this.right;
  }
  
  public R setValue(R paramR)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.tuple.ImmutablePair
 * JD-Core Version:    0.7.0.1
 */