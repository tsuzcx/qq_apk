package com.tencent.mobileqq.qrscan.view;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class ScannerMultiResultSelectView$3
  implements Runnable
{
  ScannerMultiResultSelectView$3(ScannerMultiResultSelectView paramScannerMultiResultSelectView) {}
  
  public void run()
  {
    int j = ScannerMultiResultSelectView.a(this.this$0).getChildCount();
    if ((ScannerMultiResultSelectView.a(this.this$0)) && (ScannerMultiResultSelectView.b(this.this$0) > 0) && (ScannerMultiResultSelectView.c(this.this$0) > 0))
    {
      if (j <= 0) {
        return;
      }
      int i = 0;
      while (i < j)
      {
        View localView = ScannerMultiResultSelectView.a(this.this$0).getChildAt(i);
        if ((localView != null) && (localView.getTag() != null))
        {
          Object localObject1 = localView.getTag();
          RectF localRectF = null;
          if ((localObject1 instanceof QBarResult)) {
            localRectF = ((QBarResult)localObject1).a;
          } else if ((localObject1 instanceof QMiniResult)) {
            localRectF = ((QMiniResult)localObject1).a;
          }
          if (localRectF != null)
          {
            Object localObject2 = (FrameLayout.LayoutParams)localView.getLayoutParams();
            localObject1 = ScannerMultiResultSelectView.a(this.this$0, localRectF);
            ((FrameLayout.LayoutParams)localObject2).topMargin = (((Rect)localObject1).centerY() - ViewUtils.a(27.0F));
            ((FrameLayout.LayoutParams)localObject2).leftMargin = (((Rect)localObject1).centerX() - ViewUtils.a(27.0F));
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("mUpdatePointPositionRunnable location：");
              ((StringBuilder)localObject2).append(localRectF);
              ((StringBuilder)localObject2).append(" locInView:");
              ((StringBuilder)localObject2).append(localObject1);
              QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, ((StringBuilder)localObject2).toString());
            }
            localView.setVisibility(0);
          }
        }
        i += 1;
      }
      ScannerMultiResultSelectView.a(this.this$0).requestLayout();
      ScannerMultiResultSelectView.a(this.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.3
 * JD-Core Version:    0.7.0.1
 */