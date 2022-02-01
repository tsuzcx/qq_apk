package com.tencent.mtt.supportui.utils.struct;

import java.util.Iterator;

final class MapCollections$ArrayIterator<T>
  implements Iterator<T>
{
  final int a;
  int b;
  int c;
  boolean d = false;
  
  MapCollections$ArrayIterator(MapCollections paramMapCollections, int paramInt)
  {
    this.a = paramInt;
    this.b = paramMapCollections.colGetSize();
  }
  
  public boolean hasNext()
  {
    return this.c < this.b;
  }
  
  public T next()
  {
    Object localObject = this.e.colGetEntry(this.c, this.a);
    this.c += 1;
    this.d = true;
    return localObject;
  }
  
  public void remove()
  {
    if (this.d)
    {
      this.c -= 1;
      this.b -= 1;
      this.d = false;
      this.e.colRemoveAt(this.c);
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.MapCollections.ArrayIterator
 * JD-Core Version:    0.7.0.1
 */