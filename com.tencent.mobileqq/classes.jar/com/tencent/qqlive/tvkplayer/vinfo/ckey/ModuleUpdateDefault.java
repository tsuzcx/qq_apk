package com.tencent.qqlive.tvkplayer.vinfo.ckey;

public class ModuleUpdateDefault
  implements ModuleUpdateInterface
{
  public boolean loadLibrary(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.ModuleUpdateDefault
 * JD-Core Version:    0.7.0.1
 */