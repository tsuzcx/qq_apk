package cooperation.qqcircle.picload;

public class RFWImageInfo
{
  public String key;
  public String local;
  public long maxage = 259200L;
  public long modified;
  public int state;
  public long updatetime;
  public String url;
  
  public boolean equals(Object paramObject)
  {
    paramObject = (RFWImageInfo)paramObject;
    if (paramObject != null) {
      return paramObject.key.equals(this.key);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.key.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.RFWImageInfo
 * JD-Core Version:    0.7.0.1
 */