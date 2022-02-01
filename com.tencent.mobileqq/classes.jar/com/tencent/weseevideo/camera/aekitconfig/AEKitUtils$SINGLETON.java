package com.tencent.weseevideo.camera.aekitconfig;

final class AEKitUtils$SINGLETON
{
  public static AEKitUtils instance;
  
  public static AEKitUtils getInstance()
  {
    if (instance == null) {
      instance = new AEKitUtils();
    }
    return instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.camera.aekitconfig.AEKitUtils.SINGLETON
 * JD-Core Version:    0.7.0.1
 */