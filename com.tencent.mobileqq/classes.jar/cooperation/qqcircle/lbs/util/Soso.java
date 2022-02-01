package cooperation.qqcircle.lbs.util;

import LBS_V2_PROTOCOL.Cell_V2;
import LBS_V2_PROTOCOL.GPS_V2;
import LBS_V2_PROTOCOL.Wifi_V2;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import java.util.ArrayList;
import java.util.Iterator;

public class Soso
{
  public static Cell_V2 from(SosoInterface.SosoCell paramSosoCell)
  {
    if (paramSosoCell == null) {
      return null;
    }
    Cell_V2 localCell_V2 = new Cell_V2();
    localCell_V2.iLac = paramSosoCell.mLac;
    localCell_V2.iRssi = paramSosoCell.mRss;
    localCell_V2.iCellId = paramSosoCell.mCellId;
    localCell_V2.shMcc = ((short)paramSosoCell.mMcc);
    localCell_V2.shMnc = ((short)paramSosoCell.mMnc);
    return localCell_V2;
  }
  
  public static GPS_V2 from(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    GPS_V2 localGPS_V2 = new GPS_V2();
    localGPS_V2.iAlt = ((int)paramSosoLocation.altitude);
    if ((paramSosoLocation.mLon84 == 0.0D) && (paramSosoLocation.mLat84 == 0.0D))
    {
      localGPS_V2.eType = 1;
      localGPS_V2.iLat = ((int)(paramSosoLocation.mLat02 * 1000000.0D));
      localGPS_V2.iLon = ((int)(paramSosoLocation.mLon02 * 1000000.0D));
      return localGPS_V2;
    }
    localGPS_V2.eType = 0;
    localGPS_V2.iLat = ((int)(paramSosoLocation.mLat84 * 1000000.0D));
    localGPS_V2.iLon = ((int)(paramSosoLocation.mLon84 * 1000000.0D));
    return localGPS_V2;
  }
  
  public static Wifi_V2 from(SosoInterface.SosoWifi paramSosoWifi)
  {
    if (paramSosoWifi == null) {
      return null;
    }
    Wifi_V2 localWifi_V2 = new Wifi_V2();
    localWifi_V2.iRssi = paramSosoWifi.mRssi;
    localWifi_V2.strMac = paramSosoWifi.mMacStr;
    return localWifi_V2;
  }
  
  public static ArrayList<Cell_V2> fromCellList(ArrayList<SosoInterface.SosoCell> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      SosoInterface.SosoCell localSosoCell = (SosoInterface.SosoCell)paramArrayList.next();
      if (localSosoCell != null) {
        localArrayList.add(from(localSosoCell));
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<Wifi_V2> fromWifiList(ArrayList<SosoInterface.SosoWifi> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      SosoInterface.SosoWifi localSosoWifi = (SosoInterface.SosoWifi)paramArrayList.next();
      if (localSosoWifi != null) {
        localArrayList.add(from(localSosoWifi));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.lbs.util.Soso
 * JD-Core Version:    0.7.0.1
 */