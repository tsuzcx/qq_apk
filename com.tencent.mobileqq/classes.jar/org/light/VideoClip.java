package org.light;

import java.util.HashMap;

public class VideoClip
  extends ClipAsset
{
  HashMap<String, long[]> events = new HashMap();
  public float speed = 1.0F;
  public long startOffset;
  public float volume = 1.0F;
  
  public int type()
  {
    return VIDEO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.VideoClip
 * JD-Core Version:    0.7.0.1
 */