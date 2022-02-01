package org.jbox2d.collision.broadphase;

public class Pair
  implements Comparable<Pair>
{
  public int proxyIdA;
  public int proxyIdB;
  
  public int compareTo(Pair paramPair)
  {
    int i = this.proxyIdA;
    int j = paramPair.proxyIdA;
    if (i < j) {
      return -1;
    }
    if (i == j)
    {
      i = this.proxyIdB;
      j = paramPair.proxyIdB;
      if (i < j) {
        return -1;
      }
      if (i == j) {
        return 0;
      }
      return 1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.broadphase.Pair
 * JD-Core Version:    0.7.0.1
 */