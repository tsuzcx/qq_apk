package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$GamingResource
{
  public String a;
  public List a;
  public String b;
  public List b;
  public String c = this.t + "great_mongolian.png";
  public String d = this.t + "perfect_mongolian.png";
  public String e = this.t + "miss_background.png";
  public String f = this.t + "good_background.png";
  public String g = this.t + "great_background.png";
  public String h = this.t + "perfect_background.png";
  public String i = this.t + "miss.png";
  public String j = this.t + "good.png";
  public String k = this.t + "great.png";
  public String l = this.t + "perfect.png";
  public String m = this.t + "timeBackGround.png";
  public String n = this.t + "volume/sound.png";
  public String o = this.t + "volume/sound_single.png";
  public String p = this.t + "good.mp3";
  public String q = this.t + "great.mp3";
  public String r = this.t + "miss.mp3";
  public String s = this.t + "perfect.mp3";
  private String t = ResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager) + "gaming/";
  private String u = "timeFront";
  private String v = "recogrect";
  
  public ResourceManager$GamingResource(ResourceManager paramResourceManager)
  {
    this.jdField_a_of_type_JavaLangString = (this.t + "miss_mongolian.png");
    this.jdField_b_of_type_JavaLangString = (this.t + "good_mongolian.png");
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    int i1 = 0;
    while (i1 < 4)
    {
      this.jdField_b_of_type_JavaUtilList.add(this.t + this.v + (i1 + 1) + ".png");
      i1 += 1;
    }
    this.jdField_a_of_type_JavaUtilList.add(this.t + this.u + ".png");
    i1 = i2;
    while (i1 < 3)
    {
      this.jdField_a_of_type_JavaUtilList.add(this.t + this.u + (i1 + 1) + ".png");
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GamingResource
 * JD-Core Version:    0.7.0.1
 */