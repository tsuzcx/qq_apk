package cooperation.qzone.statistic.access;

public abstract class HttpDeliverer$IProxy
{
  public static IProxy Default = new HttpDeliverer.IProxy.1();
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.HttpDeliverer.IProxy
 * JD-Core Version:    0.7.0.1
 */