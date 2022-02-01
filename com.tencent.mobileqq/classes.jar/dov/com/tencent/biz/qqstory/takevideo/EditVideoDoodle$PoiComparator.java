package dov.com.tencent.biz.qqstory.takevideo;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import java.util.Comparator;

final class EditVideoDoodle$PoiComparator
  implements Comparator<FaceLayer.FaceItem>
{
  public int a(FaceLayer.FaceItem paramFaceItem1, FaceLayer.FaceItem paramFaceItem2)
  {
    long l = paramFaceItem1.a - paramFaceItem2.a;
    if (l < 0L) {
      return -1;
    }
    if (l == 0L) {
      return 0;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof PoiComparator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle.PoiComparator
 * JD-Core Version:    0.7.0.1
 */