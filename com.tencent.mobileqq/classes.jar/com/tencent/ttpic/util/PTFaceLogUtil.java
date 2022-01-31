package com.tencent.ttpic.util;

public class PTFaceLogUtil
{
  private static PTFaceLogUtil.PTFaceLogInterface mPtFaceLog = null;
  
  public static void e(String paramString1, String paramString2)
  {
    if (mPtFaceLog != null) {
      mPtFaceLog.e(paramString1, paramString2, true);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (mPtFaceLog != null) {
      mPtFaceLog.i(paramString1, paramString2, true);
    }
  }
  
  public static void setPtFaceLog(PTFaceLogUtil.PTFaceLogInterface paramPTFaceLogInterface)
  {
    mPtFaceLog = paramPTFaceLogInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.PTFaceLogUtil
 * JD-Core Version:    0.7.0.1
 */