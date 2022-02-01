package com.tencent.mobileqq.extendfriend.wiget;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onGlobalLayout"}, k=3, mv={1, 1, 16})
final class CompletePersonalDataDialog$init$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  CompletePersonalDataDialog$init$3(LinearLayout paramLinearLayout) {}
  
  public final void onGlobalLayout()
  {
    Object localObject = new int[2];
    this.a.getLocationOnScreen((int[])localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CompletePersonalDataDialog", 2, "onGlobalLayout x = " + localObject[0] + ",y = " + localObject[1]);
    }
    int i = ViewUtils.b(120.0F);
    if (localObject[1] < i)
    {
      int j = ViewUtils.b();
      localObject = this.a.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (j - i);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.CompletePersonalDataDialog.init.3
 * JD-Core Version:    0.7.0.1
 */