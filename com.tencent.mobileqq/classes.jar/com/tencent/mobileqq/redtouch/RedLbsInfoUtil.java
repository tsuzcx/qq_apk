package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RedLbsInfoUtil
{
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  
  public RedLbsInfoUtil(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager = ((WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone"));
    }
  }
  
  public LbsCellInfo a()
  {
    int m = -1;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
          return null;
        }
        LbsCellInfo localLbsCellInfo = new LbsCellInfo();
        Object localObject = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getNetworkOperator();
        if ((localObject == null) || ("".equals(localObject)) || ("null".equals(localObject))) {
          break label302;
        }
        if (!TextUtils.isDigitsOnly((CharSequence)localObject)) {
          break label304;
        }
        int i1 = Integer.parseInt(((String)localObject).substring(0, 3));
        int i2 = Integer.parseInt(((String)localObject).substring(3));
        localObject = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCellLocation();
        if (localObject == null) {
          return null;
        }
        if ((localObject instanceof CdmaCellLocation))
        {
          localObject = (CdmaCellLocation)this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCellLocation();
          if (localObject == null) {
            break label293;
          }
          k = ((CdmaCellLocation)localObject).getNetworkId();
          j = ((CdmaCellLocation)localObject).getBaseStationId();
          m = ((CdmaCellLocation)localObject).getBaseStationLatitude();
          i = ((CdmaCellLocation)localObject).getBaseStationLongitude();
          break label306;
          localLbsCellInfo.d = j;
          localLbsCellInfo.c = k;
          localLbsCellInfo.jdField_a_of_type_Int = i1;
          localLbsCellInfo.b = i2;
          localLbsCellInfo.f = i;
          localLbsCellInfo.g = m;
          localLbsCellInfo.e = this.jdField_a_of_type_Int;
          return localLbsCellInfo;
        }
        if ((localObject instanceof GsmCellLocation))
        {
          localObject = (GsmCellLocation)this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCellLocation();
          if (localObject != null)
          {
            k = ((GsmCellLocation)localObject).getLac();
            j = ((GsmCellLocation)localObject).getCid();
            i = -1;
            continue;
          }
        }
        i = -1;
      }
      catch (Exception localException)
      {
        QLog.e("RedLbsInfoUtil", 1, "getCellInfo exception : e = " + localException.getMessage());
        return null;
      }
      int j = -1;
      int k = -1;
      continue;
      label293:
      int i = -1;
      j = -1;
      k = -1;
      break label306;
      label302:
      return null;
      label304:
      return null;
      label306:
      int n = i;
      i = m;
      m = n;
    }
  }
  
  public LbsWLanInfo a()
  {
    LbsWLanInfo localLbsWLanInfo;
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return null;
      }
      localLbsWLanInfo = new LbsWLanInfo();
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
        if (localObject != null)
        {
          String str2 = ((WifiInfo)localObject).getMacAddress();
          String str1 = ((WifiInfo)localObject).getSSID();
          int i = ((WifiInfo)localObject).getRssi();
          if (str1 != null)
          {
            localObject = str1;
            if (str1.startsWith("\""))
            {
              localObject = str1;
              if (!str1.endsWith("\"")) {}
            }
          }
          for (localObject = str1.substring(1, str1.length() - 1);; localObject = "")
          {
            localLbsWLanInfo.jdField_a_of_type_JavaLangString = str2;
            localLbsWLanInfo.b = ((String)localObject);
            localLbsWLanInfo.jdField_a_of_type_Int = i;
            break;
          }
        }
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException)
    {
      QLog.e("RedLbsInfoUtil", 1, "getWLanInfo exception : e = " + localException.getMessage());
    }
    return localLbsWLanInfo;
  }
  
  public List a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager == null) {
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_AndroidNetWifiWifiManager.getScanResults();
      if (localArrayList2 != null)
      {
        int i = 0;
        while (i < localArrayList2.size())
        {
          ScanResult localScanResult = (ScanResult)localArrayList2.get(i);
          LbsWLanInfo localLbsWLanInfo1 = new LbsWLanInfo();
          if (localLbsWLanInfo1 != null)
          {
            LbsWLanInfo localLbsWLanInfo2 = a();
            if (localLbsWLanInfo2 != null)
            {
              localLbsWLanInfo1.jdField_a_of_type_JavaLangString = localLbsWLanInfo2.jdField_a_of_type_JavaLangString;
              localLbsWLanInfo1.b = localScanResult.SSID;
              localLbsWLanInfo1.jdField_a_of_type_Int = localScanResult.level;
              localArrayList1.add(localLbsWLanInfo1);
            }
          }
          i += 1;
        }
      }
      return localArrayList1;
    }
    catch (Exception localException)
    {
      QLog.e("RedLbsInfoUtil", 1, "getWifiScanResult exception : e = " + localException.getMessage());
    }
    return null;
  }
  
  public List b()
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        List localList = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getNeighboringCellInfo();
        if (localList != null)
        {
          int k = 0;
          if (k < localList.size())
          {
            Object localObject = (NeighboringCellInfo)localList.get(k);
            LbsCellInfo localLbsCellInfo = new LbsCellInfo();
            localLbsCellInfo.d = ((NeighboringCellInfo)localObject).getCid();
            localLbsCellInfo.c = ((NeighboringCellInfo)localObject).getLac();
            localLbsCellInfo.e = (((NeighboringCellInfo)localObject).getRssi() * 2 - 113);
            localObject = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getNetworkOperator();
            if ((localObject == null) || ("".equals(localObject))) {
              break label218;
            }
            if ("null".equals(localObject))
            {
              i = 0;
              j = 0;
              localLbsCellInfo.jdField_a_of_type_Int = j;
              localLbsCellInfo.b = i;
              k += 1;
              continue;
            }
            if (!TextUtils.isDigitsOnly((CharSequence)localObject)) {
              break label218;
            }
            j = Integer.parseInt(((String)localObject).substring(0, 3));
            i = Integer.parseInt(((String)localObject).substring(3));
            continue;
          }
        }
        return localArrayList;
      }
      catch (Exception localException)
      {
        QLog.e("RedLbsInfoUtil", 1, "getNearbyCellInfo exception : e = " + localException.getMessage());
        return null;
      }
      label218:
      int i = 0;
      int j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedLbsInfoUtil
 * JD-Core Version:    0.7.0.1
 */