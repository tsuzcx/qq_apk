package com.tencent.mobileqq.ocr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.textpreview.ParticipleObserver;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class OCRResultActivity$8
  extends ParticipleObserver
{
  OCRResultActivity$8(OCRResultActivity paramOCRResultActivity) {}
  
  public void a(boolean paramBoolean, List<String> paramList)
  {
    super.a(paramBoolean, paramList);
    OCRResultActivity.c(this.a);
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.a.setParticipleItems(paramList);
      this.a.a.a();
      OCRResultActivity.d(this.a);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131707803), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultActivity.8
 * JD-Core Version:    0.7.0.1
 */