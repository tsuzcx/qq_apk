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
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      StringBuilder localStringBuilder;
      if (paramView.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("lanCode equals, return, selectedLan:");
        localStringBuilder.append(paramView);
        QLog.i("OCRResultFragmentNew", 2, localStringBuilder.toString());
      }
      else
      {
        QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), 0, 2131699077, 0).a();
        OCRPerformUtil.a.a(paramView);
        try
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("requestOcr lan:");
            localStringBuilder.append(paramView);
            localStringBuilder.append(", ctx:");
            localStringBuilder.append(OCRPerformUtil.a.a());
            QLog.i("OCRResultFragmentNew", 2, localStringBuilder.toString());
          }
          OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, OCRPerformUtil.a);
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.9
 * JD-Core Version:    0.7.0.1
 */