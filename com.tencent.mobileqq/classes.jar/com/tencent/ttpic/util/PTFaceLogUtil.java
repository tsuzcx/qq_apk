package com.tencent.ttpic.util;

public class PTFaceLogUtil
{
  private static PTFaceLogUtil.PTFaceLogInterface mPtFaceLog;
  
  public static void e(String paramString1, String paramString2)
  {
    PTFaceLogUtil.PTFaceLogInterface localPTFaceLogInterface = mPtFaceLog;
    if (localPTFaceLogInterface != null) {
      localPTFaceLogInterface.e(paramString1, paramString2, true);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    PTFaceLogUtil.PTFaceLogInterface localPTFaceLogInterface = mPtFaceLog;
    if (localPTFaceLogInterface != null) {
      localPTFaceLogInterface.i(paramString1, paramString2, true);
    }
  }
  
  public static void setPtFaceLog(PTFaceLogUtil.PTFaceLogInterface paramPTFaceLogInterface)
  {
    mPtFaceLog = paramPTFaceLogInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.util.PTFaceLogUtil
 * JD-Core Version:    0.7.0.1
 */