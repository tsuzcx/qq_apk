package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Point;
import java.util.Comparator;
import java.util.Random;

class TagCloudView$RectRandomDescComp
  implements Comparator<Tag>
{
  Random a;
  int b;
  int c;
  
  public TagCloudView$RectRandomDescComp(TagCloudView paramTagCloudView, Random paramRandom, int paramInt1, int paramInt2)
  {
    this.a = paramRandom;
    this.b = paramInt2;
    this.c = paramInt1;
  }
  
  public int a(Tag paramTag1, Tag paramTag2)
  {
    if ((paramTag1.h.y <= this.b) && (paramTag2.h.y <= this.b))
    {
      if ((paramTag1.h.x <= this.c) && (paramTag2.h.x <= this.c)) {
        return this.a.nextInt(3) - 2;
      }
      return -(paramTag1.h.x - paramTag2.h.x);
    }
    return -(paramTag1.h.y - paramTag2.h.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView.RectRandomDescComp
 * JD-Core Version:    0.7.0.1
 */