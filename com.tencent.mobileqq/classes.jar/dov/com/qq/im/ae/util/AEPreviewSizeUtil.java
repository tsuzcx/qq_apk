package dov.com.qq.im.ae.util;

import android.content.res.Resources;
import android.util.TypedValue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.mode.AECaptureMode;

public final class AEPreviewSizeUtil
{
  private static int jdField_a_of_type_Int = -1;
  private static Size jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize = new Size(ViewUtils.a(), ViewUtils.b());
  
  public static int a()
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    int k = ViewUtils.a();
    int j = ViewUtils.b();
    boolean bool = LiuHaiUtils.jdField_a_of_type_Boolean;
    int m = LiuHaiUtils.jdField_a_of_type_Int;
    int i = j;
    if (bool) {
      i = j + m;
    }
    j = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
    int n = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296290);
    int i2 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296284);
    int i3 = BaseApplication.getContext().getResources().getDimensionPixelSize(2131296285);
    int i4 = (int)(1.1735F * AIOUtils.a(98.0F, BaseApplication.getContext().getResources()));
    int i5 = (int)(BaseApplication.getContext().getResources().getDimensionPixelSize(2131296283) + TypedValue.applyDimension(2, 14.0F, BaseApplication.getContext().getResources().getDisplayMetrics()));
    int i1 = (int)(1.333333F * k);
    i2 = i - (i2 + i3) - i4 - i5;
    if (i2 - j - n >= i1) {
      jdField_a_of_type_Int = 1;
    }
    for (;;)
    {
      AEQLog.b("AEPreviewSizeUtil", "[getScreenTypeForCircle]---screen size=" + k + "X" + i + ", sScreenTypeForCircle=" + jdField_a_of_type_Int + ", statusBarHeight=" + j + ", hasNotch=" + bool + ", notchHeight=" + m);
      return jdField_a_of_type_Int;
      if (i2 >= i1) {
        jdField_a_of_type_Int = 2;
      } else {
        jdField_a_of_type_Int = 0;
      }
    }
  }
  
  public static Size a()
  {
    return jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize;
  }
  
  public static Size a(AECaptureMode paramAECaptureMode, Size paramSize, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    return a(paramAECaptureMode, paramSize, true, paramRatio);
  }
  
  public static Size a(AECaptureMode paramAECaptureMode, Size paramSize, boolean paramBoolean, AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    Size localSize;
    if (paramAECaptureMode == AECaptureMode.NORMAL)
    {
      localSize = paramSize;
      if (paramBoolean)
      {
        if (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
          break label50;
        }
        i = Math.min(paramSize.jdField_a_of_type_Int, paramSize.b);
        localSize = new Size(i, i);
      }
    }
    label50:
    do
    {
      do
      {
        do
        {
          return localSize;
          localSize = paramSize;
        } while (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL);
        localSize = paramSize;
      } while (paramRatio != AEVideoStoryTopBarViewModel.Ratio.R_4_3);
      return new Size(paramSize.jdField_a_of_type_Int, (int)(1.333333F * paramSize.jdField_a_of_type_Int));
      localSize = paramSize;
    } while (paramAECaptureMode != AECaptureMode.GIF);
    int j = Math.min(paramSize.jdField_a_of_type_Int, paramSize.b);
    int k = DisplayUtil.a(BaseApplicationImpl.getContext(), 250.0F);
    int i = j;
    if (k > 0) {
      i = Math.min(j, k);
    }
    return new Size(i, i);
  }
  
  public static void a(Size paramSize)
  {
    jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize = paramSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.util.AEPreviewSizeUtil
 * JD-Core Version:    0.7.0.1
 */