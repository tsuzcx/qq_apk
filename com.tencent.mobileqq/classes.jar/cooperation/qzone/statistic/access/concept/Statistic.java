package cooperation.qzone.statistic.access.concept;

public class Statistic
{
  protected Key[] keys = null;
  protected Object[] values = null;
  
  public Statistic(Key[] paramArrayOfKey)
  {
    setKeys(paramArrayOfKey);
  }
  
  public Key[] getKeys()
  {
    return this.keys;
  }
  
  public Object getValue(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.keys.length - 1)) {
      return this.values[paramInt];
    }
    return null;
  }
  
  public Object getValue(Key paramKey)
  {
    if ((paramKey != null) && (paramKey.index >= 0) && (paramKey.index <= this.keys.length - 1)) {
      return this.values[paramKey.index];
    }
    return null;
  }
  
  public Object[] getValues()
  {
    return this.values;
  }
  
  public void setKeys(Key[] paramArrayOfKey)
  {
    this.keys = paramArrayOfKey;
    this.values = new Object[this.keys.length];
  }
  
  public Statistic setValue(Key paramKey, Object paramObject)
  {
    if ((paramKey != null) && (paramKey.index >= 0) && (paramKey.index <= this.keys.length - 1))
    {
      this.values[paramKey.index] = paramObject;
      return this;
    }
    return null;
  }
  
  public void setValues(Object[] paramArrayOfObject)
  {
    this.values = paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Statistic
 * JD-Core Version:    0.7.0.1
 */