package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import java.util.HashMap;
import java.util.List;

class AEGenderDetectorOld$TraceFaceItem
{
  private final int SFACE_CENTER_POINT = 64;
  private PointF centerPoint;
  private FaceInfo curFace;
  private long idFace;
  
  public AEGenderDetectorOld$TraceFaceItem(AEGenderDetectorOld paramAEGenderDetectorOld, long paramLong, FaceInfo paramFaceInfo)
  {
    this.idFace = paramLong;
    updatePoints(paramFaceInfo);
  }
  
  public double distanceTwoFaces(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 64)) {
      return AEGenderDetectorOld.access$700(this.this$0, this.centerPoint, (PointF)paramFaceInfo.points.get(64));
    }
    return AEGenderDetectorOld.access$800(this.this$0);
  }
  
  public FaceInfo getFaceInfo()
  {
    return this.curFace;
  }
  
  public void updatePoints(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (paramFaceInfo.points == null) || (paramFaceInfo.points.size() <= 53))
    {
      if ((AEGenderDetectorOld.access$600(this.this$0) != null) && (this.curFace != null)) {
        AEGenderDetectorOld.access$600(this.this$0).remove(Integer.valueOf(this.curFace.hashCode()));
      }
      this.curFace = null;
      return;
    }
    if (AEGenderDetectorOld.access$600(this.this$0) == null) {
      AEGenderDetectorOld.access$602(this.this$0, new HashMap());
    }
    if (this.curFace != null) {
      AEGenderDetectorOld.access$600(this.this$0).remove(Integer.valueOf(this.curFace.hashCode()));
    }
    this.curFace = paramFaceInfo;
    AEGenderDetectorOld.access$600(this.this$0).put(Integer.valueOf(this.curFace.hashCode()), Long.valueOf(this.idFace));
    this.centerPoint = ((PointF)paramFaceInfo.points.get(64));
    this.centerPoint = new PointF(this.centerPoint.x, this.centerPoint.y);
    paramFaceInfo.faceId = this.idFace;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetectorOld.TraceFaceItem
 * JD-Core Version:    0.7.0.1
 */