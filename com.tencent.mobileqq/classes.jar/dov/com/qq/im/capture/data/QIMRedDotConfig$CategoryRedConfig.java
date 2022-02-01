package dov.com.qq.im.capture.data;

import java.io.Serializable;

public class QIMRedDotConfig$CategoryRedConfig
  implements Serializable
{
  public int categoryId;
  public long firstShowTime;
  public boolean hasShow;
  public transient boolean isShowing = false;
  public boolean showRedDot;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("categoryId=").append(this.categoryId);
    localStringBuilder.append(", version=").append(this.version);
    localStringBuilder.append(", showRedDot=").append(this.showRedDot);
    localStringBuilder.append(", hasShow=").append(this.hasShow);
    localStringBuilder.append(", firstShowTime=").append(this.firstShowTime);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.data.QIMRedDotConfig.CategoryRedConfig
 * JD-Core Version:    0.7.0.1
 */