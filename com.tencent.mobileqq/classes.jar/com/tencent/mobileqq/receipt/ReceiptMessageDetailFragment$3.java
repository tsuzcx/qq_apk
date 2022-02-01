package com.tencent.mobileqq.receipt;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;

class ReceiptMessageDetailFragment$3
  implements URLDrawableDownListener
{
  ReceiptMessageDetailFragment$3(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadCancelled: ");
    }
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadFailed: ");
    }
    ReceiptMessageDetailFragment.d(this.a).setVisibility(8);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "URLDrawableDownListener onLoadInterrupted: ");
    }
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("URLDrawableDownListener onLoadProgressed: ");
      paramView.append(paramURLDrawable);
      paramView.append(" / ");
      paramView.append(paramInt);
      QLog.d("ReceiptMessageDetailFragment", 2, paramView.toString());
    }
    ReceiptMessageDetailFragment.f(this.a).setLevel(paramInt);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    ReceiptMessageDetailFragment.d(this.a).setVisibility(8);
    ReceiptMessageDetailFragment.a(this.a, paramURLDrawable);
    ReceiptMessageDetailFragment.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment.3
 * JD-Core Version:    0.7.0.1
 */