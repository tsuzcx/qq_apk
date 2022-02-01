package cooperation.qzone.statistic.access.concept;

public class Key
{
  protected int index = -1;
  protected String name;
  
  public Key(String paramString)
  {
    setName(paramString);
  }
  
  public static void initializeOrders(Key[] paramArrayOfKey)
  {
    int i = 0;
    while (i < paramArrayOfKey.length)
    {
      paramArrayOfKey[i].index = i;
      i += 1;
    }
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Key
 * JD-Core Version:    0.7.0.1
 */