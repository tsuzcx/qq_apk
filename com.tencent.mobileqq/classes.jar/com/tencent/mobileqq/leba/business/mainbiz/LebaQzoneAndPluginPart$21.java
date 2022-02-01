package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$21
  extends QZoneObserver
{
  LebaQzoneAndPluginPart$21(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void onGetQZoneFeedCountFin(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    QLog.i("UndealCount.QZoneObserver", 1, "QZoneObserver onGetQZoneFeedCountFin, isSuc=" + paramBoolean1 + ",hasNew=" + paramBoolean2 + ",type=" + paramLong);
    if (QLog.isColorLevel())
    {
      if ((paramLong >>> 17 & 1L) != 0L) {
        QLog.d("UndealCount.ZebraAlbum.", 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      QLog.d("UndealCount.", 2, "Leba onGetQZoneFeedCountFin type: " + paramLong + " and then call Leba freshEntryItemUI");
    }
    if (paramBoolean1) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.21
 * JD-Core Version:    0.7.0.1
 */