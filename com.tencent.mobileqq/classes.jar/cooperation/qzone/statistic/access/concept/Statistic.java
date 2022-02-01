package cooperation.qzone.statistic.access.concept;

public class Statistic
{
  protected Key[] keys;
  protected Object[] values;
  
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
    if ((paramInt < 0) || (paramInt > this.keys.length - 1)) {
      return null;
    }
    return this.values[paramInt];
  }
  
  public Object getValue(Key paramKey)
  {
    if ((paramKey == null) || (paramKey.index < 0) || (paramKey.index > this.keys.length - 1)) {
      return null;
    }
    return this.values[paramKey.index];
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
    if ((paramKey == null) || (paramKey.index < 0) || (paramKey.index > this.keys.length - 1)) {
      return null;
    }
    this.values[paramKey.index] = paramObject;
    return this;
  }
  
  public void setValues(Object[] paramArrayOfObject)
  {
    this.values = paramArrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.concept.Statistic
 * JD-Core Version:    0.7.0.1
 */