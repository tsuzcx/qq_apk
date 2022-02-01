package org.apache.commons.lang;

class Entities$ArrayEntityMap
  implements Entities.EntityMap
{
  protected final int growBy;
  protected String[] names;
  protected int size = 0;
  protected int[] values;
  
  public Entities$ArrayEntityMap()
  {
    this.growBy = 100;
    int i = this.growBy;
    this.names = new String[i];
    this.values = new int[i];
  }
  
  public Entities$ArrayEntityMap(int paramInt)
  {
    this.growBy = paramInt;
    this.names = new String[paramInt];
    this.values = new int[paramInt];
  }
  
  public void add(String paramString, int paramInt)
  {
    ensureCapacity(this.size + 1);
    String[] arrayOfString = this.names;
    int i = this.size;
    arrayOfString[i] = paramString;
    this.values[i] = paramInt;
    this.size = (i + 1);
  }
  
  protected void ensureCapacity(int paramInt)
  {
    if (paramInt > this.names.length)
    {
      paramInt = Math.max(paramInt, this.size + this.growBy);
      Object localObject = new String[paramInt];
      System.arraycopy(this.names, 0, localObject, 0, this.size);
      this.names = ((String[])localObject);
      localObject = new int[paramInt];
      System.arraycopy(this.values, 0, localObject, 0, this.size);
      this.values = ((int[])localObject);
    }
  }
  
  public String name(int paramInt)
  {
    int i = 0;
    while (i < this.size)
    {
      if (this.values[i] == paramInt) {
        return this.names[i];
      }
      i += 1;
    }
    return null;
  }
  
  public int value(String paramString)
  {
    int i = 0;
    while (i < this.size)
    {
      if (this.names[i].equals(paramString)) {
        return this.values[i];
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.Entities.ArrayEntityMap
 * JD-Core Version:    0.7.0.1
 */