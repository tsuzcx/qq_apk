package com.tencent.mobileqq.vas.config.business.qvip;

import java.io.Serializable;

public class QVipBigClubSVIP9Config
  implements Serializable
{
  public String mAPngIconUrl = "https://imgcache.qq.com/club/mobile/privilege/clubicons2019v4/icon/%d/%d/%d.png";
  public String mAPngIconUrlNewGray = "https://imgcache.qq.com/club/mobile/privilege/clubicons2019v4/icon/%d/%d/%d_grey.png";
  public boolean mIsEnable = true;
  String mVipIconSettingsUrl = "https://h5.qzone.qq.com/bigVip/vipset?_proxy=1";
  
  public String getVipIconSettingsUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mVipIconSettingsUrl);
    localStringBuilder.append("&from=");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipBigClubSVIP9Config
 * JD-Core Version:    0.7.0.1
 */