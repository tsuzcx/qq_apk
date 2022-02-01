package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.PointF;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.EmotionInfo;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.List;

public class EmotionUtil
{
  public static List<EmotionInfo> genEmotionInfo(PTFaceAttr paramPTFaceAttr, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramPTFaceAttr == null) {
      return localArrayList;
    }
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < paramPTFaceAttr.getFaceCount())
        {
          List localList = (List)paramPTFaceAttr.getAllFacePoints().get(i);
          float[] arrayOfFloat = (float[])paramPTFaceAttr.getAllFaceAngles().get(i);
          if ((localList == null) || (localList.size() < 90) || (arrayOfFloat == null) || (arrayOfFloat.length < 3)) {
            break label249;
          }
          EmotionInfo localEmotionInfo = new EmotionInfo();
          float f = (float)paramPTFaceAttr.getFaceDetectScale() / paramFloat;
          localEmotionInfo.leftFace = scalePoint((PointF)localList.get(0), f);
          localEmotionInfo.rightFace = scalePoint((PointF)localList.get(18), f);
          localEmotionInfo.leftEye = scalePoint((PointF)localList.get(43), f);
          localEmotionInfo.rightEye = scalePoint((PointF)localList.get(53), f);
          localEmotionInfo.angles[0] = arrayOfFloat[0];
          localEmotionInfo.angles[1] = arrayOfFloat[1];
          localEmotionInfo.angles[2] = arrayOfFloat[2];
          localArrayList.add(localEmotionInfo);
        }
      }
      catch (Exception paramPTFaceAttr)
      {
        LogUtils.e(paramPTFaceAttr);
        return localArrayList;
      }
      finally
      {
        return localArrayList;
      }
      label249:
      i += 1;
    }
  }
  
  public static PTEmotionAttr getDefaultEmotionAttr()
  {
    PTEmotionAttr localPTEmotionAttr = new PTEmotionAttr();
    localPTEmotionAttr.setSmile(false);
    localPTEmotionAttr.setValue(0);
    return localPTEmotionAttr;
  }
  
  private static PointF scalePoint(PointF paramPointF, float paramFloat)
  {
    PointF localPointF = paramPointF;
    if (paramPointF != null)
    {
      localPointF = paramPointF;
      if (paramFloat > 0.0F) {
        localPointF = new PointF(paramPointF.x / paramFloat, paramPointF.y / paramFloat);
      }
    }
    return localPointF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.EmotionUtil
 * JD-Core Version:    0.7.0.1
 */