package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$GamingResource
{
  public String good = this.prefix + "good.png";
  public String goodSound = this.prefix + "good.mp3";
  public String good_background = this.prefix + "good_background.png";
  public String good_mongolian = this.prefix + "good_mongolian.png";
  public String great = this.prefix + "great.png";
  public String greatSound = this.prefix + "great.mp3";
  public String great_background = this.prefix + "great_background.png";
  public String great_mongolian = this.prefix + "great_mongolian.png";
  public String miss = this.prefix + "miss.png";
  public String missSound = this.prefix + "miss.mp3";
  public String miss_background = this.prefix + "miss_background.png";
  public String miss_mongolian = this.prefix + "miss_mongolian.png";
  public String perfect = this.prefix + "perfect.png";
  public String perfectSound = this.prefix + "perfect.mp3";
  public String perfect_background = this.prefix + "perfect_background.png";
  public String perfect_mongolian = this.prefix + "perfect_mongolian.png";
  private String prefix = ResourceManager.access$000(this.this$0) + "gaming/";
  private String recogRect = "recogrect";
  public List<String> recogRects = new ArrayList();
  public String timeBackground = this.prefix + "timeBackGround.png";
  private String timeFront = "timeFront";
  public List<String> timeFronts = new ArrayList();
  public String volumSoundPic = this.prefix + "volume/sound.png";
  public String volumSoundPicSingle = this.prefix + "volume/sound_single.png";
  
  public ResourceManager$GamingResource(ResourceManager paramResourceManager)
  {
    int i = 0;
    while (i < 4)
    {
      this.recogRects.add(this.prefix + this.recogRect + (i + 1) + ".png");
      i += 1;
    }
    this.timeFronts.add(this.prefix + this.timeFront + ".png");
    i = j;
    while (i < 3)
    {
      this.timeFronts.add(this.prefix + this.timeFront + (i + 1) + ".png");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GamingResource
 * JD-Core Version:    0.7.0.1
 */