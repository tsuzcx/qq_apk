package com.tencent.mobileqq.ocr.ui;

import android.widget.EditText;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo.SearchResult;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class OCRTextSearchActivity$1
  extends OCRObserver
{
  OCRTextSearchActivity$1(OCRTextSearchActivity paramOCRTextSearchActivity) {}
  
  public void a(int paramInt, String paramString, OCRTextSearchInfo.SearchResult paramSearchResult)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTextSearchResult, errorCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", sessionID=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mSessionId=");
      localStringBuilder.append(this.a.c);
      QLog.d("Q.ocr.OCRTextSearchActivity", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (this.a.c != null) && (this.a.c.equals(paramString)))
    {
      this.a.a(false);
      if (this.a.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment == null) {
        this.a.b(1);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqOcrUiSearchResultFragment.a(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), paramInt, paramSearchResult);
      this.a.a(1);
      if ((paramInt == 0) && (paramSearchResult.a != null) && (paramSearchResult.a.size() > 0))
      {
        ReportController.b(null, "dc00898", "", "", "0X80082E8", "0X80082E8", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X80082E7", "0X80082E7", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRTextSearchActivity", 2, "onGetTextSearchResult, session error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.1
 * JD-Core Version:    0.7.0.1
 */