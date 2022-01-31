package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class RightEyeRangeDetector
  implements RangeDetector
{
  private static RightEyeRangeDetector detector = new RightEyeRangeDetector();
  
  public static RightEyeRangeDetector getInstance()
  {
    return detector;
  }
  
  public float detectRange(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 90)) {
      return 0.0F;
    }
    float f = AlgoUtils.getDistance((PointF)paramList.get(37), (PointF)paramList.get(38));
    if (f > 0.0F) {}
    for (f = AlgoUtils.getDistance((PointF)paramList.get(37), (PointF)paramList.get(41)) / (f / 3.0F);; f = 5.0F) {
      return Math.min(f / 5.0F, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.face.RightEyeRangeDetector
 * JD-Core Version:    0.7.0.1
 */