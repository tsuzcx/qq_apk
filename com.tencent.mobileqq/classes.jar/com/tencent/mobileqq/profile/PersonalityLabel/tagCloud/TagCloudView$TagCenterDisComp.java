package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Point;
import java.util.Comparator;

class TagCloudView$TagCenterDisComp
  implements Comparator<Tag>
{
  Point jdField_a_of_type_AndroidGraphicsPoint;
  
  public TagCloudView$TagCenterDisComp(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public int a(Tag paramTag1, Tag paramTag2)
  {
    return TagCloudView.a(paramTag1.a(), this.jdField_a_of_type_AndroidGraphicsPoint) - TagCloudView.a(paramTag2.a(), this.jdField_a_of_type_AndroidGraphicsPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.TagCenterDisComp
 * JD-Core Version:    0.7.0.1
 */