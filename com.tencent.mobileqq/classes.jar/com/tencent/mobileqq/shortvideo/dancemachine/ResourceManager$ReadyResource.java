package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$ReadyResource
{
  public String a;
  public List a;
  public String b = this.f + "ready.mp3";
  public String c = this.f + "one.mp3";
  public String d = this.f + "two.mp3";
  public String e = this.f + "three.mp3";
  private String f = ResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager) + "ready/";
  
  public ResourceManager$ReadyResource(ResourceManager paramResourceManager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = (this.f + "ready.png");
    int i = 1;
    while (i <= 3)
    {
      this.jdField_a_of_type_JavaUtilList.add(this.f + "ready" + i + ".png");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.ReadyResource
 * JD-Core Version:    0.7.0.1
 */