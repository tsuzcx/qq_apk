package dov.com.qq.im.capture.banner;

import java.io.Serializable;

public class QIMCaptureBannerConfig$AnimItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean mEnable;
  public long mLifetime;
  public int mVersion;
  
  public String toString()
  {
    return "AnimItem{mVersion=" + this.mVersion + ", mEnable='" + this.mEnable + '\'' + ", mLifetime='" + this.mLifetime + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.AnimItem
 * JD-Core Version:    0.7.0.1
 */