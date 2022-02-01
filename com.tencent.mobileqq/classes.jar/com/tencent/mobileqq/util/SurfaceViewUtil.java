package com.tencent.mobileqq.util;

import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

public class SurfaceViewUtil
{
  public static void a(SurfaceView paramSurfaceView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramSurfaceView == null)
    {
      QLog.e("SurfaceViewUtil", 2, "SurfaceViewUtil resetLayoutParams error: surfaceView==null");
      return;
    }
    if ((paramInt2 > 0) && (paramInt1 > 0) && (paramInt3 > 0) && (paramInt4 > 0))
    {
      float f1 = paramInt2;
      float f2 = paramInt1;
      float f3 = f1 / f2;
      float f4 = paramInt4;
      float f5 = paramInt3;
      if (f3 > f4 / f5)
      {
        paramInt1 = (int)((f1 - (int)(f2 * f4 / f5)) / 2.0F);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.setMargins(0, paramInt1, 0, paramInt1);
        paramSurfaceView.setLayoutParams(localLayoutParams);
        return;
      }
      paramInt1 = (int)((f2 - (int)(f1 * f5 / f4)) / 2.0F);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(paramInt1, 0, paramInt1, 0);
      paramSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    QLog.e("SurfaceViewUtil", 2, "SurfaceViewUtil resetLayoutParams error: width height <= 0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SurfaceViewUtil
 * JD-Core Version:    0.7.0.1
 */