package org.light;

public class PhotoClip
  extends ClipAsset
{
  public byte[] bytes;
  public String photoEffectPath = "";
  
  public int type()
  {
    return VideoClip.PHOTO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.PhotoClip
 * JD-Core Version:    0.7.0.1
 */