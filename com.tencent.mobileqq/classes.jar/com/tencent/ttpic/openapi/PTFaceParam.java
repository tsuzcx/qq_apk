package com.tencent.ttpic.openapi;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PTFaceParam
{
  public static final String ALL_FRAME_DETECT = "allFrameDetect";
  public static final String ENABLE_AGE_DETECT = "enableAgeDetect";
  public static final String ENABLE_GENDER_DETECT = "enableGenderDetect";
  public static final String EXPRESSION_DETECT_FOR_EVERY_FACE = "expressionDetectForEveryFace";
  public static final String FACEKIT = "FaceKit";
  public static final String MODULE_PIC_DETECT = "picFaceDetect";
  public static final String MODULE_VIDEO_DETECT = "videoFaceDetect";
  public static final String NEED_DETECT_AND_TRACK_FIRST_FRAME = "needDetectAndTrackFirstFrame";
  public static final String PHONE_ROLL = "phoneRoll";
  public static final String RESET = "reset";
  public static final String SCALE = "scale";
  public static final String STAR_PARAM = "starParam";
  public static final String SYNC_AGE_DETECT = "syncAgeDetect";
  public static final int YOUTU_FACE_FEATURE_POINT_NUM = 67;
  public static final int YOUTU_FACE_POINT_NUM = 94;
  public static final int YOUTU_FACE_PROFILE_POINT_NUM = 21;
  public static final int YOUTU_FACE_PUPIL_POINT_NUM = 6;
  
  public static PointF calcfacePoint2DCenter(List<List<PointF>> paramList)
  {
    PointF localPointF = new PointF();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localPointF;
    }
    localPointF.x = ((PointF)((List)paramList.get(0)).get(63)).x;
    localPointF.y = ((PointF)((List)paramList.get(0)).get(63)).y;
    return localPointF;
  }
  
  public static List<Float[]> createPointVis(List<List<PointF>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = (List)paramList.next();
      Float[] arrayOfFloat = new Float[localList.size()];
      int i = 0;
      while (i < localList.size())
      {
        arrayOfFloat[i] = Float.valueOf(1.0F);
        i += 1;
      }
      localArrayList.add(arrayOfFloat);
    }
    return localArrayList;
  }
  
  public static PTFaceAttr getEmptyFaceAttr(List<List<PointF>> paramList, List<float[]> paramList1, Set<Integer> paramSet)
  {
    return new PTFaceAttr(new PTFaceAttr.Builder().facePoints(paramList).irisPoints(new ArrayList()).faceAngles(paramList1).triggeredExpression(paramSet).faceDetectScale(1.0D).timeStamp(System.currentTimeMillis()).pointsVis(createPointVis(paramList)).facePiont2DCenter(calcfacePoint2DCenter(paramList)).rotation(0).faceDetector(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceParam
 * JD-Core Version:    0.7.0.1
 */