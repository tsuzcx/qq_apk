package com.tencent.ttpic.face;

import android.graphics.PointF;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.List;

public class MouthRangeDetector
  implements RangeDetector
{
  private static MouthRangeDetector detector = new MouthRangeDetector();
  
  public static MouthRangeDetector getInstance()
  {
    return detector;
  }
  
  public float detectRange(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 90)) {
      return 0.0F;
    }
    float f = AlgoUtils.getDistance((PointF)paramList.get(69), (PointF)paramList.get(73));
    if (f > 0.0F) {}
    for (f = AlgoUtils.getDistance((PointF)paramList.get(81), (PointF)paramList.get(73)) / (f / 2.0F);; f = 5.0F) {
      return Math.min(f / 5.0F, 1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.face.MouthRangeDetector
 * JD-Core Version:    0.7.0.1
 */