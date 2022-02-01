package com.tencent.mobileqq.now;

public class NowQQLiveConstant
{
  public static final String a = String.valueOf(1816533856L);
  
  public static final String a()
  {
    if (NowQQLiveHelper.b()) {
      return "https://fastest.now.qq.com/qq/mp-v2/notify-manager.html?asyncMode=3&_wv=3&from=60014";
    }
    return "https://now.qq.com/qq/mp-v2/notify-manager.html?asyncMode=3&_wv=3&from=60014";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveConstant
 * JD-Core Version:    0.7.0.1
 */