package com.tencent.mobileqq.highway.iplearning;

import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.Comparator;

class IpLearningImpl$IpListCompartor
  implements Comparator<EndPoint>
{
  public int compare(EndPoint paramEndPoint1, EndPoint paramEndPoint2)
  {
    if ((paramEndPoint1.isSameIsp) && (!paramEndPoint2.isSameIsp)) {
      return -1;
    }
    if ((!paramEndPoint1.isSameIsp) && (paramEndPoint2.isSameIsp)) {
      return 1;
    }
    return paramEndPoint1.failCount - paramEndPoint2.failCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.iplearning.IpLearningImpl.IpListCompartor
 * JD-Core Version:    0.7.0.1
 */