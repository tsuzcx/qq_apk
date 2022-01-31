package dov.com.qq.im.capture.banner;

import java.io.Serializable;

public class QIMCaptureBannerConfig$BannerItem
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean hasShow;
  public String imgMd5;
  public String imgUrl;
  public String jumpUrl;
  public String mBannerId;
  public long mBeginTime;
  public long mEndTime;
  public String mWording;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("BannerItem{");
    localStringBuilder.append("mBannerId='").append(this.mBannerId).append('\'');
    localStringBuilder.append(", version=").append(this.version);
    localStringBuilder.append(", mBeginTime=").append(this.mBeginTime);
    localStringBuilder.append(", mEndTime=").append(this.mEndTime);
    localStringBuilder.append(", mWording=").append(this.mWording);
    localStringBuilder.append(", imgUrl='").append(this.imgUrl).append('\'');
    localStringBuilder.append(", imgMd5='").append(this.imgMd5).append('\'');
    localStringBuilder.append(", jumpUrl='").append(this.jumpUrl).append('\'');
    localStringBuilder.append(", hasShow=").append(this.hasShow);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.banner.QIMCaptureBannerConfig.BannerItem
 * JD-Core Version:    0.7.0.1
 */