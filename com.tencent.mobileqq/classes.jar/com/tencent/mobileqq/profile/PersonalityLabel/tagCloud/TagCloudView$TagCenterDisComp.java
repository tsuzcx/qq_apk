package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Point;
import java.util.Comparator;

class TagCloudView$TagCenterDisComp
  implements Comparator<Tag>
{
  Point a;
  
  public TagCloudView$TagCenterDisComp(TagCloudView paramTagCloudView, Point paramPoint)
  {
    this.a = paramPoint;
  }
  
  public int a(Tag paramTag1, Tag paramTag2)
  {
    return TagCloudView.a(paramTag1.f(), this.a) - TagCloudView.a(paramTag2.f(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.TagCenterDisComp
 * JD-Core Version:    0.7.0.1
 */