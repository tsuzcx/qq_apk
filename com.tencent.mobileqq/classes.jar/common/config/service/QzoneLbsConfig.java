package common.config.service;

public class QzoneLbsConfig
{
  private static final Object a = new Object();
  private static volatile QzoneLbsConfig b = null;
  
  public static QzoneLbsConfig a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new QzoneLbsConfig();
        }
      }
    }
    return b;
  }
  
  public int b()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.config.service.QzoneLbsConfig
 * JD-Core Version:    0.7.0.1
 */