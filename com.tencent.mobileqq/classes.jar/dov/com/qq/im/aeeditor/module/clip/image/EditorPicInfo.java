package dov.com.qq.im.aeeditor.module.clip.image;

import android.support.annotation.NonNull;
import java.io.Serializable;

public class EditorPicInfo
  implements Serializable
{
  public double h;
  public double originPicHeight;
  public double originPicWidth;
  public String picPath;
  public double rotate;
  public double w;
  public double x;
  public double y;
  
  @NonNull
  public String toString()
  {
    return "EditorPicInfo{picPath=" + this.picPath + ", x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ", rotate=" + this.rotate + ", originPicWidth=" + this.originPicWidth + ", originPicHeight=" + this.originPicHeight + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo
 * JD-Core Version:    0.7.0.1
 */