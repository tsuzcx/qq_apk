package com.tencent.mobileqq.ocr;

import android.app.Dialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.textpreview.ParticipleObserver;
import com.tencent.mobileqq.widget.ParticipleView;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class OCRResultFragmentNew$6
  extends ParticipleObserver
{
  OCRResultFragmentNew$6(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  public void a(boolean paramBoolean, List<String> paramList)
  {
    super.a(paramBoolean, paramList);
    if (OCRResultFragmentNew.a(this.a) != null)
    {
      OCRResultFragmentNew.a(this.a).setOnCancelListener(null);
      OCRResultFragmentNew.a(this.a).dismiss();
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.a.setParticipleItems(paramList);
      this.a.a.a();
      OCRResultFragmentNew.a(this.a, 2);
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131707803), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.6
 * JD-Core Version:    0.7.0.1
 */