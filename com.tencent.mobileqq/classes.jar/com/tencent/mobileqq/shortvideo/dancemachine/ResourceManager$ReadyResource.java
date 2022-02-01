package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$ReadyResource
{
  public String oneSound;
  private String prefix;
  public String ready;
  public List<String> readyNums;
  public String readySound;
  public String threeSound;
  public String twoSound;
  
  public ResourceManager$ReadyResource(ResourceManager paramResourceManager)
  {
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(ResourceManager.access$000(this.this$0));
    paramResourceManager.append("ready/");
    this.prefix = paramResourceManager.toString();
    this.readyNums = new ArrayList();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("ready.png");
    this.ready = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("ready.mp3");
    this.readySound = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("one.mp3");
    this.oneSound = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("two.mp3");
    this.twoSound = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("three.mp3");
    this.threeSound = paramResourceManager.toString();
    int i = 1;
    while (i <= 3)
    {
      paramResourceManager = this.readyNums;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.prefix);
      localStringBuilder.append("ready");
      localStringBuilder.append(i);
      localStringBuilder.append(".png");
      paramResourceManager.add(localStringBuilder.toString());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource
 * JD-Core Version:    0.7.0.1
 */