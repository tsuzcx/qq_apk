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
    return ((paramObject instanceof Pair)) && (equalsImp(this.fst, ((Pair)paramObject).fst)) && (equalsImp(this.snd, ((Pair)paramObject).snd));
  }
  
  public int hashCode()
  {
    if (this.fst == null)
    {
      if (this.snd == null) {
        return 0;
      }
      return this.snd.hashCode() + 1;
    }
    if (this.snd == null) {
      return this.fst.hashCode() + 2;
    }
    return this.fst.hashCode() * 17 + this.snd.hashCode();
  }
  
  public String toString()
  {
    return "Pair[" + this.fst + "," + this.snd + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.utils.Pair
 * JD-Core Version:    0.7.0.1
 */