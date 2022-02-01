package org.apache.commons.lang;

class Entities$BinaryEntityMap
  extends Entities.ArrayEntityMap
{
  public Entities$BinaryEntityMap() {}
  
  public Entities$BinaryEntityMap(int paramInt)
  {
    super(paramInt);
  }
  
  private int binarySearch(int paramInt)
  {
    int j = this.size - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.values[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return -(i + 1);
  }
  
  public void add(String paramString, int paramInt)
  {
    ensureCapacity(this.size + 1);
    int i = binarySearch(paramInt);
    if (i > 0) {
      return;
    }
    i = -(i + 1);
    int[] arrayOfInt1 = this.values;
    int[] arrayOfInt2 = this.values;
    int j = i + 1;
    System.arraycopy(arrayOfInt1, i, arrayOfInt2, j, this.size - i);
    this.values[i] = paramInt;
    System.arraycopy(this.names, i, this.names, j, this.size - i);
    this.names[i] = paramString;
    this.size += 1;
  }
  
  public String name(int paramInt)
  {
    paramInt = binarySearch(paramInt);
    if (paramInt < 0) {
      return null;
    }
    return this.names[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.Entities.BinaryEntityMap
 * JD-Core Version:    0.7.0.1
 */