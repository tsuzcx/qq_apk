package org.jbox2d.dynamics;

public class Filter
{
  public int categoryBits = 1;
  public int groupIndex = 0;
  public int maskBits = 65535;
  
  public void set(Filter paramFilter)
  {
    this.categoryBits = paramFilter.categoryBits;
    this.maskBits = paramFilter.maskBits;
    this.groupIndex = paramFilter.groupIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.dynamics.Filter
 * JD-Core Version:    0.7.0.1
 */