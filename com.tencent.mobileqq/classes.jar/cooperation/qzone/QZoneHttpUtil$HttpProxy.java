package cooperation.qzone;

public abstract class QZoneHttpUtil$HttpProxy
{
  public static HttpProxy Default = new QZoneHttpUtil.HttpProxy.1();
  
  public abstract String getHost();
  
  public abstract int getPort();
  
  public String toString()
  {
    return getHost() + ':' + getPort();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneHttpUtil.HttpProxy
 * JD-Core Version:    0.7.0.1
 */