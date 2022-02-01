package com.tencent.mobileqq.richmediabrowser.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.widget.immersive.ImmersiveUtils;

class AIOBrowserBaseView$1
  implements DialogInterface.OnDismissListener
{
  AIOBrowserBaseView$1(AIOBrowserBaseView paramAIOBrowserBaseView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.a.a.c != null)) {
      this.a.a.c.updateSystemUIVisablity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOBrowserBaseView.1
 * JD-Core Version:    0.7.0.1
 */