package com.tencent.mobileqq.ocr;

import android.view.View;
import com.tencent.mobileqq.gallery.picocr.PicOcrManager.OCRReqContext;
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
      if (!paramView.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqOcrOCRPerformUtil$OCRLanHolder.a)) {
        break label108;
      }
      QLog.i("OCRResultFragmentNew", 2, "lanCode equals, return, selectedLan:" + paramView);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a != null) && (this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew.a = null;
      return;
      label108:
      QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), 0, 2131698999, 0).a();
      OCRPerformUtil.a.a(paramView);
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("OCRResultFragmentNew", 2, "requestOcr lan:" + paramView + ", ctx:" + OCRPerformUtil.a.a());
        }
        OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew, OCRPerformUtil.a);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.9
 * JD-Core Version:    0.7.0.1
 */