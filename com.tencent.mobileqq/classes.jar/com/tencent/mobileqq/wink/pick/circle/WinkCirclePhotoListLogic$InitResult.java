package com.tencent.mobileqq.wink.pick.circle;

class WinkCirclePhotoListLogic$InitResult
{
  private int a;
  
  public String toString()
  {
    switch (this.a)
    {
    case -8: 
    default: 
      return "未知错误";
    case 0: 
      return "初始化成功";
    case -1: 
      return "初始化AEKit失败";
    case -2: 
      return "加载YTCommon失败";
    case -3: 
      return "加载PtuTools失败";
    case -4: 
      return "加载PtuAlgo失败";
    case -5: 
      return "加载人脸检测失败";
    case -6: 
      return "加载PAG失败";
    case -7: 
      return "加载ImageAlgo失败";
    }
    return "初始化TAVCut失败";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.InitResult
 * JD-Core Version:    0.7.0.1
 */