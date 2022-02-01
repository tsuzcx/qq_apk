package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

class LineLayer$LoadTempFileJob$1
  implements Runnable
{
  LineLayer$LoadTempFileJob$1(LineLayer.LoadTempFileJob paramLoadTempFileJob, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob) != null)
    {
      LoadTempFileJobListener localLoadTempFileJobListener = (LoadTempFileJobListener)LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob).get();
      if (localLoadTempFileJobListener != null) {
        localLoadTempFileJobListener.a(LineLayer.LoadTempFileJob.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob), this.jdField_a_of_type_Int, LineLayer.LoadTempFileJob.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplLineLayer$LoadTempFileJob), this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.LineLayer.LoadTempFileJob.1
 * JD-Core Version:    0.7.0.1
 */