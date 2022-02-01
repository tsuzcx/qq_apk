package com.tencent.weiyun.poi;

import com.tencent.weiyun.data.PoiItem;
import java.util.Comparator;

class PoiManager$1
  implements Comparator<PoiItem>
{
  PoiManager$1(PoiManager paramPoiManager) {}
  
  public int compare(PoiItem paramPoiItem1, PoiItem paramPoiItem2)
  {
    if (paramPoiItem1.longitude < paramPoiItem2.longitude) {}
    do
    {
      return -1;
      if (paramPoiItem1.longitude > paramPoiItem2.longitude) {
        return 1;
      }
    } while (paramPoiItem1.latitude < paramPoiItem2.latitude);
    if (paramPoiItem1.latitude > paramPoiItem2.latitude) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiManager.1
 * JD-Core Version:    0.7.0.1
 */