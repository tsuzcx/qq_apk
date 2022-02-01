package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$GameNumberResource
{
  public List<String> gameNums;
  private String prefix;
  public String scoreSound;
  
  public ResourceManager$GameNumberResource(ResourceManager paramResourceManager)
  {
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(ResourceManager.access$000(this.this$0));
    paramResourceManager.append("number/");
    this.prefix = paramResourceManager.toString();
    this.gameNums = new ArrayList();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("score.mp3");
    this.scoreSound = paramResourceManager.toString();
    int i = 0;
    while (i < 10)
    {
      paramResourceManager = this.gameNums;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.prefix);
      localStringBuilder.append("gamenum_");
      localStringBuilder.append(i);
      localStringBuilder.append(".png");
      paramResourceManager.add(localStringBuilder.toString());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource
 * JD-Core Version:    0.7.0.1
 */