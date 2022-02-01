package com.tencent.mobileqq.shortvideo.dancemachine;

public class ResourceManager$StartResource
{
  private String prefix;
  public String startPic;
  public String startSound;
  
  public ResourceManager$StartResource(ResourceManager paramResourceManager)
  {
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(ResourceManager.access$000(this.this$0));
    paramResourceManager.append("start/");
    this.prefix = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("start.png");
    this.startPic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("start.mp3");
    this.startSound = paramResourceManager.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.StartResource
 * JD-Core Version:    0.7.0.1
 */