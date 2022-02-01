package common.config.service;

public class QzoneLbsConfig
{
  private static volatile QzoneLbsConfig mInstance = null;
  private static final Object mLock = new Object();
  
  public static QzoneLbsConfig getInstance()
  {
    if (mInstance == null) {}
    synchronized (mLock)
    {
      if (mInstance == null) {
        mInstance = new QzoneLbsConfig();
      }
      return mInstance;
    }
  }
  
  public int getValidRadiusGeo()
  {
    return QzoneConfig.getInstance().getConfig("QZoneSetting", "POICacheDistance", 1000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.config.service.QzoneLbsConfig
 * JD-Core Version:    0.7.0.1
 */