package com.tencent.mobileqq.ocr;

import android.view.View;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class OCRResultFragmentNew$9
  implements ActionSheet.OnButtonClickListener
{
  OCRResultFragmentNew$9(OCRResultFragmentNew paramOCRResultFragmentNew, List paramList, OCRPerformUtil.OCRLanHolder paramOCRLanHolder) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt < this.a.size())
    {
      paramView = (String)this.a.get(paramInt);
      StringBuilder localStringBuilder;
      if (paramView.equalsIgnoreCase(this.b.a))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("lanCode equals, return, selectedLan:");
        localStringBuilder.append(paramView);
        QLog.i("OCRResultFragmentNew", 2, localStringBuilder.toString());
      }
      else
      {
        QQToast.makeText(OCRResultFragmentNew.a(this.c), 0, 2131897086, 0).show();
        OCRPerformUtil.b.a(paramView);
        try
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("requestOcr lan:");
            localStringBuilder.append(paramView);
            localStringBuilder.append(", ctx:");
            localStringBuilder.append(OCRPerformUtil.b.b());
            QLog.i("OCRResultFragmentNew", 2, localStringBuilder.toString());
          }
          OCRResultFragmentNew.a(this.c, OCRPerformUtil.b);
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
      }
    }
    if ((this.c.m != null) && (this.c.m.isShowing())) {
      this.c.m.dismiss();
    }
    this.c.m = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.9
 * JD-Core Version:    0.7.0.1
 */