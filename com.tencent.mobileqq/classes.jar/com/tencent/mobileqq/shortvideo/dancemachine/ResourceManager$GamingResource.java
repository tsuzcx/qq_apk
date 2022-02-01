package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$GamingResource
{
  public String good;
  public String goodSound;
  public String good_background;
  public String good_mongolian;
  public String great;
  public String greatSound;
  public String great_background;
  public String great_mongolian;
  public String miss;
  public String missSound;
  public String miss_background;
  public String miss_mongolian;
  public String perfect;
  public String perfectSound;
  public String perfect_background;
  public String perfect_mongolian;
  private String prefix;
  private String recogRect;
  public List<String> recogRects;
  public String timeBackground;
  private String timeFront;
  public List<String> timeFronts;
  public String volumSoundPic;
  public String volumSoundPicSingle;
  
  public ResourceManager$GamingResource(ResourceManager paramResourceManager)
  {
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(ResourceManager.access$000(this.this$0));
    paramResourceManager.append("gaming/");
    this.prefix = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("miss_mongolian.png");
    this.miss_mongolian = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("good_mongolian.png");
    this.good_mongolian = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("great_mongolian.png");
    this.great_mongolian = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("perfect_mongolian.png");
    this.perfect_mongolian = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("miss_background.png");
    this.miss_background = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("good_background.png");
    this.good_background = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("great_background.png");
    this.great_background = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("perfect_background.png");
    this.perfect_background = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("miss.png");
    this.miss = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("good.png");
    this.good = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("great.png");
    this.great = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("perfect.png");
    this.perfect = paramResourceManager.toString();
    this.timeFront = "timeFront";
    this.timeFronts = new ArrayList();
    this.recogRect = "recogrect";
    this.recogRects = new ArrayList();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("timeBackGround.png");
    this.timeBackground = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("volume/sound.png");
    this.volumSoundPic = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("volume/sound_single.png");
    this.volumSoundPicSingle = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("good.mp3");
    this.goodSound = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("great.mp3");
    this.greatSound = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("miss.mp3");
    this.missSound = paramResourceManager.toString();
    paramResourceManager = new StringBuilder();
    paramResourceManager.append(this.prefix);
    paramResourceManager.append("perfect.mp3");
    this.perfectSound = paramResourceManager.toString();
    int j = 0;
    int i = 0;
    while (i < 4)
    {
      paramResourceManager = this.recogRects;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.prefix);
      localStringBuilder.append(this.recogRect);
      i += 1;
      localStringBuilder.append(i);
      localStringBuilder.append(".png");
      paramResourceManager.add(localStringBuilder.toString());
    }
    paramResourceManager = this.timeFronts;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.prefix);
    localStringBuilder.append(this.timeFront);
    localStringBuilder.append(".png");
    paramResourceManager.add(localStringBuilder.toString());
    i = j;
    while (i < 3)
    {
      paramResourceManager = this.timeFronts;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.prefix);
      localStringBuilder.append(this.timeFront);
      i += 1;
      localStringBuilder.append(i);
      localStringBuilder.append(".png");
      paramResourceManager.add(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GamingResource
 * JD-Core Version:    0.7.0.1
 */