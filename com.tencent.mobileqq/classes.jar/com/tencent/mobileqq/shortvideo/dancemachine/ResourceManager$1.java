package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.Comparator;

class ResourceManager$1
  implements Comparator<ResourceManager.LyricItem>
{
  ResourceManager$1(ResourceManager paramResourceManager) {}
  
  public int compare(ResourceManager.LyricItem paramLyricItem1, ResourceManager.LyricItem paramLyricItem2)
  {
    if (paramLyricItem1.startTime < paramLyricItem2.startTime) {
      return -1;
    }
    if (paramLyricItem1.startTime > paramLyricItem2.startTime) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.1
 * JD-Core Version:    0.7.0.1
 */