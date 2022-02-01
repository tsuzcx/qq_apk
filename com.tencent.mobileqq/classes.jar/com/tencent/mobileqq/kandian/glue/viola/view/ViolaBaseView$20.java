package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class ViolaBaseView$20
  implements ViolaBaseView.LoadAsyBack
{
  ViolaBaseView$20(ViolaBaseView paramViolaBaseView, boolean paramBoolean) {}
  
  public void a()
  {
    if (ViolaBaseView.h(this.b) != null) {
      ViolaBaseView.h(this.b).c();
    }
    ViolaBaseView.a(this.b, 2, this.a);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.s(this.b)))
    {
      ViolaBaseView.a(this.b, paramString, this.a);
    }
    else
    {
      boolean bool = this.a;
      if (!bool) {
        ViolaBaseView.a(this.b, paramString, bool);
      }
    }
    if (QLog.isColorLevel()) {
      ThreadManager.post(new ViolaBaseView.20.1(this, paramString), 8, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.20
 * JD-Core Version:    0.7.0.1
 */