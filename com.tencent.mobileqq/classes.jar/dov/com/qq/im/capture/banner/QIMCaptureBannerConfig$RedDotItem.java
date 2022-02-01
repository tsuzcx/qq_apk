package dov.com.qq.im.capture.banner;

import java.io.Serializable;

public class QIMCaptureBannerConfig$RedDotItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean hasShow;
  public boolean needShow;
  public long showTime;
  public long startShow;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("RedDotItem{");
    localStringBuilder.append("version=").append(this.version);
    localStringBuilder.append(", needShow=").append(this.needShow);
    localStringBuilder.append(", startShow=").append(this.startShow);
    localStringBuilder.append(", showTime=").append(this.showTime);
    localStringBuilder.append(", hasShow=").append(this.hasShow);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.RedDotItem
 * JD-Core Version:    0.7.0.1
 */