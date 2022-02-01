package com.tencent.mobileqq.loginwelcome;

public class LoginWelcomeManager$WelcomeIntervalConfig
{
  public String a = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121837_iSfyMAuKAV.png";
  public String b = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121848_eHHesyqska.png";
  public int c = 360;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("popup_url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\nfixed_entrance_url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\nrequest_interval=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.WelcomeIntervalConfig
 * JD-Core Version:    0.7.0.1
 */