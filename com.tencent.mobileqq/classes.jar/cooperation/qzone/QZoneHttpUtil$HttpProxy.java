package cooperation.qzone;

public abstract class QZoneHttpUtil$HttpProxy
{
  public static HttpProxy Default = new QZoneHttpUtil.HttpProxy.1();
  
  public abstract String getHost();
  
  public abstract int getPort();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getHost());
    localStringBuilder.append(':');
    localStringBuilder.append(getPort());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil.HttpProxy
 * JD-Core Version:    0.7.0.1
 */