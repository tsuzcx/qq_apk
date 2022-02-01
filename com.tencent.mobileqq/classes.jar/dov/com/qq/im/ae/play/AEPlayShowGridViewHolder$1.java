package dov.com.qq.im.ae.play;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import bhtq;
import bowv;
import com.tencent.qphone.base.util.QLog;

public class AEPlayShowGridViewHolder$1
  implements Runnable
{
  public AEPlayShowGridViewHolder$1(bowv parambowv, View paramView) {}
  
  public void run()
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
    ViewGroup localViewGroup = (ViewGroup)this.a.getParent();
    int k = bhtq.a(10.0F);
    int j = bhtq.a() - k * 2;
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
        QLog.d("AEPlayShowGridViewHolder", 4, "one itemHeight " + i + " itemWidth: " + j + " screenWidth: " + bhtq.a() + " viewWidth: " + localViewGroup.getWidth() + " padding: " + k);
      }
      this.a.setLayoutParams(localMarginLayoutParams);
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