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
    if ((paramInt2 <= 0) || (paramInt1 <= 0) || (paramInt3 <= 0) || (paramInt4 <= 0))
    {
      QLog.e("SurfaceViewUtil", 2, "SurfaceViewUtil resetLayoutParams error: width height <= 0");
      return;
    }
    if (paramInt2 / paramInt1 > paramInt4 / paramInt3)
    {
      paramInt1 = (int)(paramInt1 * paramInt4 / paramInt3);
      paramInt1 = (int)((paramInt2 - paramInt1) / 2.0F);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(0, paramInt1, 0, paramInt1);
      paramSurfaceView.setLayoutParams(localLayoutParams);
      return;
    }
    paramInt2 = (int)(paramInt2 * paramInt3 / paramInt4);
    paramInt1 = (int)((paramInt1 - paramInt2) / 2.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(paramInt1, 0, paramInt1, 0);
    paramSurfaceView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.util.SurfaceViewUtil
 * JD-Core Version:    0.7.0.1
 */