package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$GameNumberResource
{
  public List<String> gameNums = new ArrayList();
  private String prefix = ResourceManager.access$000(this.this$0) + "number/";
  public String scoreSound = this.prefix + "score.mp3";
  
  public ResourceManager$GameNumberResource(ResourceManager paramResourceManager)
  {
    int i = 0;
    while (i < 10)
    {
      this.gameNums.add(this.prefix + "gamenum_" + i + ".png");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource
 * JD-Core Version:    0.7.0.1
 */