package dov.com.qq.im.ae.cmshow.config;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AECMShowConfig$RequestConfig
  implements Serializable
{
  @SerializedName("img_max_length")
  public int imgMaxLength;
  @SerializedName("img_quality")
  public float imgQuality;
  
  @NonNull
  public String toString()
  {
    return "{imgMaxLength=" + this.imgMaxLength + ", imgQuality=" + this.imgQuality + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.config.AECMShowConfig.RequestConfig
 * JD-Core Version:    0.7.0.1
 */