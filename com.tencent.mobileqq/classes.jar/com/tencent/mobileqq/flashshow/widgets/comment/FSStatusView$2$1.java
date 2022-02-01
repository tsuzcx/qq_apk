package com.tencent.mobileqq.flashshow.widgets.comment;

import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;

class FSStatusView$2$1
  extends QCirclePicStateListener
{
  FSStatusView$2$1(FSStatusView.2 param2) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if (paramInt == 6)
    {
      paramOption = new BitmapDrawable(paramOption.getResultBitMap());
      this.a.b.setImageDrawable(paramOption);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.widgets.comment.FSStatusView.2.1
 * JD-Core Version:    0.7.0.1
 */