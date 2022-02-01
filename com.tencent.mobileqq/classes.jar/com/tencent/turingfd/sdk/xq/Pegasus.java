package com.tencent.turingfd.sdk.xq;

public enum Pegasus
{
  public final int value;
  
  static
  {
    Pegasus localPegasus = Ni;
    localPegasus = Oi;
    localPegasus = Pi;
    localPegasus = Qi;
    localPegasus = Ri;
  }
  
  public Pegasus(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(name());
    localStringBuilder.append(":");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Pegasus
 * JD-Core Version:    0.7.0.1
 */