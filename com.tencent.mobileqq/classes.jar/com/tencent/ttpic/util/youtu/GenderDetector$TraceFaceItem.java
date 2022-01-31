package com.tencent.ttpic.util.youtu;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import java.util.HashMap;
import java.util.List;

class GenderDetector$TraceFaceItem
{
  private final int SFACE_CENTER_POINT = 64;
  private PointF centerPoint;
  private FaceInfo curFace;
  private long idFace;
  
  public GenderDetector$TraceFaceItem(GenderDetector paramGenderDetector, long paramLong, FaceInfo paramFaceInfo)
  {
    this.idFace = paramLong;
    updatePoints(paramFaceInfo);
  }
  
  public double distanceTwoFaces(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 64)) {
      return GenderDetector.access$700(this.this$0, this.centerPoint, (PointF)paramFaceInfo.points.get(64));
    }
    return GenderDetector.access$800(this.this$0);
  }
  
  public FaceInfo getFaceInfo()
  {
    return this.curFace;
  }
  
  public void updatePoints(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (paramFaceInfo.points == null) || (paramFaceInfo.points.size() <= 53))
    {
      if ((GenderDetector.access$600(this.this$0) != null) && (this.curFace != null)) {
        GenderDetector.access$600(this.this$0).remove(Integer.valueOf(this.curFace.hashCode()));
      }
      this.curFace = null;
      return;
    }
    if (GenderDetector.access$600(this.this$0) == null) {
      GenderDetector.access$602(this.this$0, new HashMap());
    }
    if (this.curFace != null) {
      GenderDetector.access$600(this.this$0).remove(Integer.valueOf(this.curFace.hashCode()));
    }
    this.curFace = paramFaceInfo;
    GenderDetector.access$600(this.this$0).put(Integer.valueOf(this.curFace.hashCode()), Long.valueOf(this.idFace));
    this.centerPoint = ((PointF)paramFaceInfo.points.get(64));
    this.centerPoint = new PointF(this.centerPoint.x, this.centerPoint.y);
    paramFaceInfo.faceId = this.idFace;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.GenderDetector.TraceFaceItem
 * JD-Core Version:    0.7.0.1
 */