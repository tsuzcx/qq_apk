package org.jbox2d.collision;

public class Distance$SimplexCache
{
  public int count = 0;
  public final int[] indexA = new int[3];
  public final int[] indexB = new int[3];
  public float metric = 0.0F;
  
  public Distance$SimplexCache()
  {
    int[] arrayOfInt = this.indexA;
    arrayOfInt[0] = 2147483647;
    arrayOfInt[1] = 2147483647;
    arrayOfInt[2] = 2147483647;
    arrayOfInt = this.indexB;
    arrayOfInt[0] = 2147483647;
    arrayOfInt[1] = 2147483647;
    arrayOfInt[2] = 2147483647;
  }
  
  public void set(SimplexCache paramSimplexCache)
  {
    int[] arrayOfInt1 = paramSimplexCache.indexA;
    int[] arrayOfInt2 = this.indexA;
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt2.length);
    arrayOfInt1 = paramSimplexCache.indexB;
    arrayOfInt2 = this.indexB;
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt2.length);
    this.metric = paramSimplexCache.metric;
    this.count = paramSimplexCache.count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Distance.SimplexCache
 * JD-Core Version:    0.7.0.1
 */