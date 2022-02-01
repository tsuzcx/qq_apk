package com.tencent.mobileqq.onlinestatus.auto.location.cache;

import com.tencent.qphone.base.util.QLog;

class PoiLoader$2$1
  implements Runnable
{
  PoiLoader$2$1(PoiLoader.2 param2, PoiBean paramPoiBean) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[status][poiLoader][");
      localStringBuilder.append(PoiLoader.b(this.b.b));
      localStringBuilder.append("] persist. latLng: ");
      localStringBuilder.append(this.b.a);
      localStringBuilder.append(" poiBean: ");
      localStringBuilder.append(this.a);
      QLog.d("PoiLoader", 2, localStringBuilder.toString());
    }
    if (this.a != null) {
      this.b.b.b.a(this.b.a, PoiLoader.a(this.b.b), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiLoader.2.1
 * JD-Core Version:    0.7.0.1
 */