package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Point;
import java.util.Comparator;
import java.util.Random;

class TagCloudView$RectRandomDescComp
  implements Comparator<Tag>
{
  int jdField_a_of_type_Int;
  Random jdField_a_of_type_JavaUtilRandom;
  int b;
  
  public TagCloudView$RectRandomDescComp(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilRandom = paramRandom;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt1;
  }
  
  public int a(Tag paramTag1, Tag paramTag2)
  {
    if ((paramTag1.b.y <= this.jdField_a_of_type_Int) && (paramTag2.b.y <= this.jdField_a_of_type_Int))
    {
      if ((paramTag1.b.x <= this.b) && (paramTag2.b.x <= this.b)) {
        return this.jdField_a_of_type_JavaUtilRandom.nextInt(3) - 2;
      }
      return -(paramTag1.b.x - paramTag2.b.x);
    }
    return -(paramTag1.b.y - paramTag2.b.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.RectRandomDescComp
 * JD-Core Version:    0.7.0.1
 */