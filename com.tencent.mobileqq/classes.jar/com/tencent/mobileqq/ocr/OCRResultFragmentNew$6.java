package com.tencent.mobileqq.ocr;

import android.app.Dialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.participle.ParticipleObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.participle.ParticipleView;
import java.util.List;

class OCRResultFragmentNew$6
  extends ParticipleObserver
{
  OCRResultFragmentNew$6(OCRResultFragmentNew paramOCRResultFragmentNew) {}
  
  protected void a(boolean paramBoolean, List<String> paramList)
  {
    super.a(paramBoolean, paramList);
    if (OCRResultFragmentNew.c(this.a) != null)
    {
      OCRResultFragmentNew.c(this.a).setOnCancelListener(null);
      OCRResultFragmentNew.c(this.a).dismiss();
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
    {
      this.a.e.setParticipleItems(paramList);
      this.a.e.a();
      OCRResultFragmentNew.b(this.a, 2);
      return;
    }
    QQToast.makeText(OCRResultFragmentNew.a(this.a), 1, HardCodeUtil.a(2131905641), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.6
 * JD-Core Version:    0.7.0.1
 */