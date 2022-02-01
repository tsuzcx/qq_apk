package com.tencent.turingfd.sdk.xq;

public enum Chamaeleon
{
  public final int value;
  
  static
  {
    Chamaeleon localChamaeleon = pj;
    localChamaeleon = qj;
    localChamaeleon = rj;
    localChamaeleon = sj;
    localChamaeleon = tj;
  }
  
  public Chamaeleon(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    return name() + ":" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Chamaeleon
 * JD-Core Version:    0.7.0.1
 */