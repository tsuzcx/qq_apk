package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$ReadyResource
{
  public String oneSound = this.prefix + "one.mp3";
  private String prefix = ResourceManager.access$000(this.this$0) + "ready/";
  public String ready = this.prefix + "ready.png";
  public List<String> readyNums = new ArrayList();
  public String readySound = this.prefix + "ready.mp3";
  public String threeSound = this.prefix + "three.mp3";
  public String twoSound = this.prefix + "two.mp3";
  
  public ResourceManager$ReadyResource(ResourceManager paramResourceManager)
  {
    int i = 1;
    while (i <= 3)
    {
      this.readyNums.add(this.prefix + "ready" + i + ".png");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource
 * JD-Core Version:    0.7.0.1
 */