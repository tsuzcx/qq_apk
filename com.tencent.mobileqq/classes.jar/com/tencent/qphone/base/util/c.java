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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static final String a = "LocationUtil";
  private static TelephonyManager b;
  private static GPS c;
  private static ArrayList d;
  private static PhoneStateListener e;
  
  public static LBSInfo a(Context paramContext)
  {
    localArrayList = new ArrayList();
    try
    {
      Object localObject = (WifiManager)paramContext.getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getScanResults();
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          localObject = ((List)localObject).iterator();
        }
      }
      for (;;)
      {
        ScanResult localScanResult;
        if (((Iterator)localObject).hasNext())
        {
          localScanResult = (ScanResult)((Iterator)localObject).next();
          if (localScanResult.level <= -70) {
            continue;
          }
          if (localArrayList.size() <= 20) {}
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("LocationUtil", 2, localArrayList.toString());
          }
          b = (TelephonyManager)paramContext.getSystemService("phone");
          c();
          b = (TelephonyManager)paramContext.getSystemService("phone");
          b.listen(e, 256);
          b.listen(e, 16);
          if (b.getCellLocation() != null) {
            e.onCellLocationChanged(b.getCellLocation());
          }
          paramContext = new Attr(b.getDeviceId(), b.getSubscriberId(), b.getLine1Number());
          if (QLog.isColorLevel()) {
            QLog.i("LocationUtil", 2, paramContext.toString());
          }
          c = new GPS();
          return new LBSInfo(c, localArrayList, d, paramContext);
        }
        long l = 0L;
        if (!TextUtils.isEmpty(localScanResult.BSSID)) {
          l = Long.parseLong(localScanResult.BSSID.replace(":", ""), 16);
        }
        localArrayList.add(new Wifi(l, (short)localScanResult.level));
      }
      return new LBSInfo(new GPS(), localArrayList, d, null);
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationUtil", 2, paramContext.getMessage());
      }
    }
  }
  
  private static void a(Cell paramCell)
  {
    if ((paramCell == null) || (d == null)) {
      break label10;
    }
    label10:
    while (d.size() >= 3) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= d.size()) {
        break label60;
      }
      if (paramCell.iCellId == ((Cell)d.get(i)).iCellId) {
        break;
      }
      i += 1;
    }
    label60:
    d.add(paramCell);
  }
  
  private static void c()
  {
    e = new d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.c
 * JD-Core Version:    0.7.0.1
 */