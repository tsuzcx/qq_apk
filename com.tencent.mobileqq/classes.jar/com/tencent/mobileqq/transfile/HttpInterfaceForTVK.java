package com.tencent.mobileqq.transfile;

public abstract class HttpInterfaceForTVK
{
  public static int downLoadFileSync(String paramString1, String paramString2)
  {
    return new HttpInterfaceForTVKImp().downLoadSync(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpInterfaceForTVK
 * JD-Core Version:    0.7.0.1
 */