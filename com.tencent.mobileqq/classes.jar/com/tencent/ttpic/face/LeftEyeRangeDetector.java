package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class LeftEyeRangeDetector
  implements RangeDetector
{
  private static LeftEyeRangeDetector detector = new LeftEyeRangeDetector();
  
  public static LeftEyeRangeDetector getInstance()
  {
    return detector;
  }
  
  public float detectRange(List<PointF> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 90) {
        return 0.0F;
      }
      float f = AlgoUtils.getDistance((PointF)paramList.get(47), (PointF)paramList.get(48));
      if (f > 0.0F) {
        f = AlgoUtils.getDistance((PointF)paramList.get(47), (PointF)paramList.get(51)) / (f / 3.0F);
      } else {
        f = 5.0F;
      }
      return Math.min(f / 5.0F, 1.0F);
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.face.LeftEyeRangeDetector
 * JD-Core Version:    0.7.0.1
 */