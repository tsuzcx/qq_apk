package com.tencent.mobileqq.loginwelcome;

public class LoginWelcomeManager$WelcomeIntervalConfig
{
  public int a;
  public String a;
  public String b = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121848_eHHesyqska.png";
  
  public LoginWelcomeManager$WelcomeIntervalConfig()
  {
    this.jdField_a_of_type_JavaLangString = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121837_iSfyMAuKAV.png";
    this.jdField_a_of_type_Int = 360;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("popup_url=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\nfixed_entrance_url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\nrequest_interval=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager.WelcomeIntervalConfig
 * JD-Core Version:    0.7.0.1
 */