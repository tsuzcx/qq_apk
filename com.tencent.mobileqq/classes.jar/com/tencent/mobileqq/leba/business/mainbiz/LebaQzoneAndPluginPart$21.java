package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$21
  extends QZoneObserver
{
  LebaQzoneAndPluginPart$21(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QZoneObserver onGetQZoneFeedCountFin, isSuc=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(",hasNew=");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(",type=");
    localStringBuilder.append(paramLong);
    QLog.i("UndealCount.QZoneObserver", 1, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      if ((paramLong >>> 17 & 1L) != 0L) {
        QLog.d("UndealCount.ZebraAlbum.", 2, "Leba onGetQZoneFeedCountFin Zebra album and then call Leba freshEntryItemUI");
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Leba onGetQZoneFeedCountFin type: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" and then call Leba freshEntryItemUI");
      QLog.d("UndealCount.", 2, localStringBuilder.toString());
    }
    if (paramBoolean1) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.21
 * JD-Core Version:    0.7.0.1
 */