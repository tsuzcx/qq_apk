package com.tencent.raft.codegenmeta.utils;

public class Pair<A, B>
{
  public final A fst;
  public final B snd;
  
  public Pair(A paramA, B paramB)
  {
    this.fst = paramA;
    this.snd = paramB;
  }
  
  private boolean equalsImp(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static <A, B> Pair<A, B> of(A paramA, B paramB)
  {
    return new Pair(paramA, paramB);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Pair))
    {
      Object localObject = this.fst;
      paramObject = (Pair)paramObject;
      if ((equalsImp(localObject, paramObject.fst)) && (equalsImp(this.snd, paramObject.snd))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.fst;
    if (localObject == null)
    {
      localObject = this.snd;
      if (localObject == null) {
        return 0;
      }
      return localObject.hashCode() + 1;
    }
    if (this.snd == null) {
      return localObject.hashCode() + 2;
    }
    return localObject.hashCode() * 17 + this.snd.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Pair[");
    localStringBuilder.append(this.fst);
    localStringBuilder.append(",");
    localStringBuilder.append(this.snd);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.Pair
 * JD-Core Version:    0.7.0.1
 */