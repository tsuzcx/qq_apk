package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleImagePreviewUtil;
import com.tencent.mobileqq.utils.BaseDeviceInfoUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;

public class QCircleImagePreviewUtilImpl
  implements IQCircleImagePreviewUtil
{
  private static final long mobileMemoryThreshold = 3500L;
  
  public int[] getTargetWidthAndHeight(int paramInt1, int paramInt2)
  {
    long l = BaseDeviceInfoUtil.a() / 1048576L;
    int i = ImmersiveUtils.getScreenWidth();
    int j = ImmersiveUtils.getScreenHeight();
    if ((j > 0) && (i > 0) && (paramInt2 > 0) && (paramInt1 > 0))
    {
      if (QzoneConfig.isQQCircleShowHighQualityImagePreview())
      {
        if (l > 3500L)
        {
          j *= 2;
          if ((paramInt2 >= j) || (paramInt1 >= i * 2))
          {
            i *= 2;
            if ((paramInt1 >= i) && (paramInt2 < j)) {}
            while (((paramInt2 < j) || (paramInt1 >= i)) && (paramInt2 <= paramInt1))
            {
              paramInt2 = (int)(i / paramInt1 * paramInt2);
              paramInt1 = i;
              break;
            }
            paramInt1 = (int)(j / paramInt2 * paramInt1);
            paramInt2 = j;
          }
        }
        else if ((paramInt2 >= j) || (paramInt1 >= i))
        {
          if ((paramInt1 >= i) && (paramInt2 < j)) {}
          while (((paramInt2 < j) || (paramInt1 >= i)) && (paramInt2 <= paramInt1))
          {
            paramInt2 = (int)(i / paramInt1 * paramInt2);
            paramInt1 = i;
            break;
          }
          paramInt1 = (int)(j / paramInt2 * paramInt1);
          paramInt2 = j;
        }
      }
      else
      {
        i = ImmersiveUtils.getScreenWidth();
        paramInt2 = (int)(i / paramInt1 * paramInt2);
        paramInt1 = i;
      }
      return new int[] { paramInt1, paramInt2 };
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleImagePreviewUtilImpl
 * JD-Core Version:    0.7.0.1
 */