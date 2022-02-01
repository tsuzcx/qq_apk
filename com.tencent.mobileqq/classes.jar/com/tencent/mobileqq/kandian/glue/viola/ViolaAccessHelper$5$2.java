package com.tencent.mobileqq.kandian.glue.viola;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.LoadAsyBack;

class ViolaAccessHelper$5$2
  implements ViolaBaseView.LoadAsyBack
{
  ViolaAccessHelper$5$2(ViolaAccessHelper.5 param5) {}
  
  public void a()
  {
    ViolaAccessHelper.a(this.a.a, this.a.d, this.a.c, this.a.b);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ViolaAccessHelper.a(this.a.a, paramString, this.a.c, this.a.b);
      ThreadManager.post(new ViolaAccessHelper.5.2.1(this, paramString), 8, null, true);
      return;
    }
    ViolaAccessHelper.a(this.a.a, this.a.d, this.a.c, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.5.2
 * JD-Core Version:    0.7.0.1
 */