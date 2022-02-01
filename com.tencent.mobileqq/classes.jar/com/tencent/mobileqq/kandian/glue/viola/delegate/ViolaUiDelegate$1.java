package com.tencent.mobileqq.kandian.glue.viola.delegate;

import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.viola.api.OnTitleChangeListener;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;

class ViolaUiDelegate$1
  implements OnTitleChangeListener
{
  ViolaUiDelegate$1(ViolaUiDelegate paramViolaUiDelegate) {}
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    ViolaUiDelegate.a(this.a).setRightButtonText(paramString, paramOnClickListener);
  }
  
  public void a(boolean paramBoolean)
  {
    ViolaUiDelegate.a(this.a).setTitleTransparent(paramBoolean);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    ViolaUiDelegate.a(this.a).setLeftButtonText(paramString, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.delegate.ViolaUiDelegate.1
 * JD-Core Version:    0.7.0.1
 */