package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.shortvideo.VideoEnvironment64BitUtils;
import com.tencent.mobileqq.utils.StringUtil;

public class AEOldShortVideoResManager$SVConfigItem
{
  public String arm64v8a_md5;
  public String arm64v8a_url;
  public String arm_md5;
  public String arm_url;
  public String armv7a_md5;
  public String armv7a_url;
  public String extend1;
  public String extend2;
  public String name;
  public boolean predownload;
  public int versionCode;
  public String x86_md5;
  public String x86_url;
  
  public boolean check64BitReady()
  {
    return (!StringUtil.a(this.arm64v8a_md5)) && (!StringUtil.a(this.arm64v8a_url));
  }
  
  public String getSignature()
  {
    if ((VideoEnvironment64BitUtils.checkIs64bit()) && (check64BitReady()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.arm64v8a_md5);
      localStringBuilder.append('_');
      localStringBuilder.append(this.versionCode);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.armv7a_md5);
    localStringBuilder.append('_');
    localStringBuilder.append(this.versionCode);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SVConfigItem{name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arm_url='");
    localStringBuilder.append(this.arm_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", armv7a_url='");
    localStringBuilder.append(this.armv7a_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", x86_url='");
    localStringBuilder.append(this.x86_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arm64v8a_url='");
    localStringBuilder.append(this.arm64v8a_url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arm_md5='");
    localStringBuilder.append(this.arm_md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", armv7a_md5='");
    localStringBuilder.append(this.armv7a_md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", x86_md5='");
    localStringBuilder.append(this.x86_md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", arm64v8a_md5='");
    localStringBuilder.append(this.arm64v8a_md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append(", predownload=");
    localStringBuilder.append(this.predownload);
    localStringBuilder.append(", extend1='");
    localStringBuilder.append(this.extend1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extend2='");
    localStringBuilder.append(this.extend2);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem
 * JD-Core Version:    0.7.0.1
 */