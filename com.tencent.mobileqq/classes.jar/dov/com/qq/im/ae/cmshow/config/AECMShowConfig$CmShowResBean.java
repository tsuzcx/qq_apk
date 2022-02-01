package dov.com.qq.im.ae.cmshow.config;

import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AECMShowConfig$CmShowResBean
  implements Serializable
{
  @SerializedName("and_md5")
  public String androidMd5;
  @SerializedName("and_url")
  public String androidUrl;
  @SerializedName("ios_md5")
  public String iOSMd5;
  @SerializedName("ios_url")
  public String iOSUrl;
  public String id;
  
  @NonNull
  public String toString()
  {
    return "{id=" + this.id + ", iOSUrl=" + this.iOSUrl + ", iOSMd5=" + this.iOSMd5 + ", androidUrl=" + this.androidUrl + ", androidMd5=" + this.androidMd5 + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.cmshow.config.AECMShowConfig.CmShowResBean
 * JD-Core Version:    0.7.0.1
 */