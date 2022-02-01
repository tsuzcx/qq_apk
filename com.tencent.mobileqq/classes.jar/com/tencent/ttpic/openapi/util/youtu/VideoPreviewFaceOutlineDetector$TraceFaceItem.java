package com.tencent.ttpic.openapi.util.youtu;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import java.util.HashMap;
import java.util.List;

class VideoPreviewFaceOutlineDetector$TraceFaceItem
{
  private final int SFACE_CENTER_POINT = 64;
  private PointF centerPoint;
  private FaceInfo curFace;
  private long idFace;
  
  public VideoPreviewFaceOutlineDetector$TraceFaceItem(VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector, long paramLong, FaceInfo paramFaceInfo)
  {
    this.idFace = paramLong;
    updatePoints(paramFaceInfo);
  }
  
  public double distanceTwoFaces(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 64)) {
      return VideoPreviewFaceOutlineDetector.access$400(this.this$0, this.centerPoint, (PointF)paramFaceInfo.points.get(64));
    }
    return VideoPreviewFaceOutlineDetector.access$500(this.this$0);
  }
  
  public FaceInfo getFaceInfo()
  {
    return this.curFace;
  }
  
  public void updatePoints(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (paramFaceInfo.points == null) || (paramFaceInfo.points.size() <= 53))
    {
      if ((VideoPreviewFaceOutlineDetector.access$300(this.this$0) != null) && (this.curFace != null)) {
        VideoPreviewFaceOutlineDetector.access$300(this.this$0).remove(Integer.valueOf(this.curFace.hashCode()));
      }
      this.curFace = null;
      return;
    }
    if (VideoPreviewFaceOutlineDetector.access$300(this.this$0) == null) {
      VideoPreviewFaceOutlineDetector.access$302(this.this$0, new HashMap());
    }
    if (this.curFace != null) {
      VideoPreviewFaceOutlineDetector.access$300(this.this$0).remove(Integer.valueOf(this.curFace.hashCode()));
    }
    this.curFace = paramFaceInfo;
    VideoPreviewFaceOutlineDetector.access$300(this.this$0).put(Integer.valueOf(this.curFace.hashCode()), Long.valueOf(this.idFace));
    this.centerPoint = ((PointF)paramFaceInfo.points.get(64));
    this.centerPoint = new PointF(this.centerPoint.x, this.centerPoint.y);
    paramFaceInfo.faceId = this.idFace;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector.TraceFaceItem
 * JD-Core Version:    0.7.0.1
 */