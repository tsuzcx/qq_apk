package kotlin.reflect.jvm.internal.pcollections;

final class IntTreePMap<V>
{
  private static final IntTreePMap<Object> EMPTY = new IntTreePMap(IntTree.EMPTYNODE);
  private final IntTree<V> root;
  
  private IntTreePMap(IntTree<V> paramIntTree)
  {
    this.root = paramIntTree;
  }
  
  public static <V> IntTreePMap<V> empty()
  {
    return EMPTY;
  }
  
  private IntTreePMap<V> withRoot(IntTree<V> paramIntTree)
  {
    if (paramIntTree == this.root) {
      return this;
    }
    return new IntTreePMap(paramIntTree);
  }
  
  public V get(int paramInt)
  {
    return this.root.get(paramInt);
  }
  
  public IntTreePMap<V> minus(int paramInt)
  {
    return withRoot(this.root.minus(paramInt));
  }
  
  public IntTreePMap<V> plus(int paramInt, V paramV)
  {
    return withRoot(this.root.plus(paramInt, paramV));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.pcollections.IntTreePMap
 * JD-Core Version:    0.7.0.1
 */