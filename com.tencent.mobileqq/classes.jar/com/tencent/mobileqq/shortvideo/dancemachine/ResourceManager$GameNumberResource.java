package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;

public class ResourceManager$GameNumberResource
{
  public String a;
  public List a;
  private String b = ResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager) + "number/";
  
  public ResourceManager$GameNumberResource(ResourceManager paramResourceManager)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = (this.b + "score.mp3");
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(this.b + "gamenum_" + i + ".png");
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager.GameNumberResource
 * JD-Core Version:    0.7.0.1
 */