package com.tencent.mobileqq.flashshow.part;

import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;

class FSPublishStatusBoxPart$4
  extends QCirclePicStateListener
{
  FSPublishStatusBoxPart$4(FSPublishStatusBoxPart paramFSPublishStatusBoxPart) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    if (paramInt == 6)
    {
      paramOption = new BitmapDrawable(paramOption.getResultBitMap());
      RFThreadManager.getUIHandler().post(new FSPublishStatusBoxPart.4.1(this, paramOption));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublishStatusBoxPart.4
 * JD-Core Version:    0.7.0.1
 */