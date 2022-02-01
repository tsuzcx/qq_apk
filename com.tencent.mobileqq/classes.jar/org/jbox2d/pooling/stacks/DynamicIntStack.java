package org.jbox2d.pooling.stacks;

public class DynamicIntStack
{
  private int position;
  private int size;
  private int[] stack;
  
  public DynamicIntStack(int paramInt)
  {
    this.stack = new int[paramInt];
    this.position = 0;
    this.size = paramInt;
  }
  
  public int getCount()
  {
    return this.position;
  }
  
  public int pop()
  {
    int[] arrayOfInt = this.stack;
    int i = this.position - 1;
    this.position = i;
    return arrayOfInt[i];
  }
  
  public void push(int paramInt)
  {
    int i = this.position;
    int j = this.size;
    if (i == j)
    {
      arrayOfInt1 = this.stack;
      this.stack = new int[j * 2];
      int[] arrayOfInt2 = this.stack;
      this.size = arrayOfInt2.length;
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
    }
    int[] arrayOfInt1 = this.stack;
    i = this.position;
    this.position = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  public void reset()
  {
    this.position = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.stacks.DynamicIntStack
 * JD-Core Version:    0.7.0.1
 */