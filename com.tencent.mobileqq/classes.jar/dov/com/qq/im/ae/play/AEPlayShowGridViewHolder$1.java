package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class AEPlayShowGridViewHolder$1
  implements Runnable
{
  AEPlayShowGridViewHolder$1(AEPlayShowGridViewHolder paramAEPlayShowGridViewHolder, View paramView) {}
  
  public void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.val$itemView.getLayoutParams();
    ViewGroup localViewGroup = (ViewGroup)this.val$itemView.getParent();
    int k = ViewUtils.dip2px(10.0F);
    int j = ViewUtils.getScreenWidth() - k * 2;
    int i = localViewGroup.getHeight() - k;
    if (j * 16 / 9 > i) {
      j = i * 9 / 16;
    }
    for (;;)
    {
      localMarginLayoutParams.width = j;
      localMarginLayoutParams.height = i;
      k += (localViewGroup.getWidth() - j - k * 2) / 2;
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowGridViewHolder", 4, "one itemHeight " + i + " itemWidth: " + j + " screenWidth: " + ViewUtils.getScreenWidth() + " viewWidth: " + localViewGroup.getWidth() + " padding: " + k);
      }
      this.val$itemView.setLayoutParams(localMarginLayoutParams);
      localViewGroup.setPadding(k, 0, 0, 0);
      return;
      i = j * 16 / 9;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder.1
 * JD-Core Version:    0.7.0.1
 */