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
    if ((VideoEnvironment64BitUtils.checkIs64bit()) && (check64BitReady())) {
      return this.arm64v8a_md5 + '_' + this.versionCode;
    }
    return this.armv7a_md5 + '_' + this.versionCode;
  }
  
  public String toString()
  {
    return "SVConfigItem{name='" + this.name + '\'' + ", arm_url='" + this.arm_url + '\'' + ", armv7a_url='" + this.armv7a_url + '\'' + ", x86_url='" + this.x86_url + '\'' + ", arm64v8a_url='" + this.arm64v8a_url + '\'' + ", arm_md5='" + this.arm_md5 + '\'' + ", armv7a_md5='" + this.armv7a_md5 + '\'' + ", x86_md5='" + this.x86_md5 + '\'' + ", arm64v8a_md5='" + this.arm64v8a_md5 + '\'' + ", versionCode=" + this.versionCode + ", predownload=" + this.predownload + ", extend1='" + this.extend1 + '\'' + ", extend2='" + this.extend2 + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.SVConfigItem
 * JD-Core Version:    0.7.0.1
 */