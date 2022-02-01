package com.tencent.qphone.base.util;

import LBS.Attr;
import LBS.Cell;
import LBS.GPS;
import LBS.LBSInfo;
import LBS.Wifi;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static final String a = "LocationUtil";
  private static TelephonyManager b;
  private static GPS c;
  private static ArrayList d;
  private static PhoneStateListener e;
  
  public static LBSInfo a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = (WifiManager)paramContext.getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getScanResults();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ScanResult localScanResult = (ScanResult)((Iterator)localObject).next();
            if (localScanResult.level > -70)
            {
              if (localArrayList.size() > 20) {
                break;
              }
              long l = 0L;
              if (!TextUtils.isEmpty(localScanResult.BSSID)) {
                l = Long.parseLong(localScanResult.BSSID.replace(":", ""), 16);
              }
              localArrayList.add(new Wifi(l, (short)localScanResult.level));
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("LocationUtil", 2, localArrayList.toString());
          }
        }
      }
      b = (TelephonyManager)paramContext.getSystemService("phone");
      c();
      b = (TelephonyManager)paramContext.getSystemService("phone");
      b.listen(e, 256);
      b.listen(e, 16);
      if (PhoneInfoMonitor.getCellLocation(b) != null) {
        e.onCellLocationChanged(PhoneInfoMonitor.getCellLocation(b));
      }
      paramContext = new Attr(PhoneInfoMonitor.getDeviceId(b), PhoneInfoMonitor.getSubscriberId(b), "");
      if (QLog.isColorLevel()) {
        QLog.i("LocationUtil", 2, paramContext.toString());
      }
      c = new GPS();
      paramContext = new LBSInfo(c, localArrayList, d, paramContext);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationUtil", 2, paramContext.getMessage());
      }
    }
    return new LBSInfo(new GPS(), localArrayList, d, null);
  }
  
  private static void a(Cell paramCell)
  {
    if (paramCell != null)
    {
      ArrayList localArrayList = d;
      if (localArrayList == null) {
        return;
      }
      if (localArrayList.size() >= 3) {
        return;
      }
      int i = 0;
      while (i < d.size())
      {
        if (paramCell.iCellId == ((Cell)d.get(i)).iCellId) {
          return;
        }
        i += 1;
      }
      d.add(paramCell);
    }
  }
  
  private static void c()
  {
    e = new f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.e
 * JD-Core Version:    0.7.0.1
 */