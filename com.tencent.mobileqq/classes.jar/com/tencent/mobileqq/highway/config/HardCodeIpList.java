package com.tencent.mobileqq.highway.config;

import android.content.Context;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class HardCodeIpList
{
  private CopyOnWriteArrayList<String> mHcIpCandicateListChinaMobile;
  private CopyOnWriteArrayList<String> mHcIpCandicateListChinaTelecom;
  private CopyOnWriteArrayList<String> mHcIpCandicateListChinaUnicom;
  private CopyOnWriteArrayList<String> mHcIpCandicateListOverseas;
  private CopyOnWriteArrayList<String> mHcIpCandicateListWifi;
  private ArrayList<Integer> mPort4HardCode = new ArrayList();
  
  public HardCodeIpList()
  {
    this.mPort4HardCode.add(Integer.valueOf(80));
    this.mPort4HardCode.add(Integer.valueOf(8080));
    this.mPort4HardCode.add(Integer.valueOf(443));
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add("121.51.158.123");
    localArrayList1.add("1121.51.139.184");
    localArrayList1.add("111.13.34.183");
    localArrayList1.add("111.30.144.63");
    localArrayList1.add("183.194.234.190");
    localArrayList1.add("183.194.234.249");
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("157.255.196.94");
    localArrayList2.add("61.241.43.180");
    localArrayList2.add("223.167.252.209");
    localArrayList2.add("111.161.111.177");
    localArrayList2.add("111.161.64.121");
    localArrayList2.add("116.128.163.67");
    ArrayList localArrayList3 = new ArrayList();
    localArrayList3.add("14.18.161.24");
    localArrayList3.add("59.36.121.49");
    localArrayList3.add("61.151.207.107");
    localArrayList3.add("123.151.71.152");
    localArrayList3.add("123.151.137.126");
    localArrayList3.add("101.89.38.28");
    ArrayList localArrayList4 = new ArrayList();
    localArrayList4.add("203.205.234.15");
    localArrayList4.add("203.205.234.144");
    if (this.mHcIpCandicateListWifi == null)
    {
      ArrayList localArrayList5 = new ArrayList();
      ArrayList localArrayList6 = new ArrayList();
      ArrayList localArrayList7 = new ArrayList();
      ArrayList localArrayList8 = new ArrayList();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext()) {
        localArrayList7.add(new HardCodeIpList.Candiate(this, (String)localIterator.next()));
      }
      Collections.sort(localArrayList7, new HardCodeIpList.CustomComparator(this));
      localIterator = localArrayList2.iterator();
      while (localIterator.hasNext()) {
        localArrayList6.add(new HardCodeIpList.Candiate(this, (String)localIterator.next()));
      }
      Collections.sort(localArrayList6, new HardCodeIpList.CustomComparator(this));
      localIterator = localArrayList3.iterator();
      while (localIterator.hasNext()) {
        localArrayList5.add(new HardCodeIpList.Candiate(this, (String)localIterator.next()));
      }
      Collections.sort(localArrayList5, new HardCodeIpList.CustomComparator(this));
      localIterator = localArrayList4.iterator();
      while (localIterator.hasNext()) {
        localArrayList8.add(new HardCodeIpList.Candiate(this, (String)localIterator.next()));
      }
      Collections.sort(localArrayList8, new HardCodeIpList.CustomComparator(this));
      this.mHcIpCandicateListWifi = new CopyOnWriteArrayList();
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList5.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList6.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList7.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList8.get(0)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList5.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList6.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList7.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList8.get(1)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList5.get(2)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList6.get(2)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList7.get(2)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList5.get(3)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList6.get(3)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList7.get(3)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList5.get(4)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList6.get(4)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList7.get(4)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList5.get(5)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList6.get(5)).ip);
      this.mHcIpCandicateListWifi.add(((HardCodeIpList.Candiate)localArrayList7.get(5)).ip);
    }
    if (this.mHcIpCandicateListChinaMobile == null)
    {
      this.mHcIpCandicateListChinaMobile = new CopyOnWriteArrayList();
      this.mHcIpCandicateListChinaMobile.addAll(localArrayList1);
    }
    if (this.mHcIpCandicateListChinaUnicom == null)
    {
      this.mHcIpCandicateListChinaUnicom = new CopyOnWriteArrayList();
      this.mHcIpCandicateListChinaUnicom.addAll(localArrayList2);
    }
    if (this.mHcIpCandicateListChinaTelecom == null)
    {
      this.mHcIpCandicateListChinaTelecom = new CopyOnWriteArrayList();
      this.mHcIpCandicateListChinaTelecom.addAll(localArrayList3);
    }
    if (this.mHcIpCandicateListOverseas == null)
    {
      this.mHcIpCandicateListOverseas = new CopyOnWriteArrayList();
      this.mHcIpCandicateListOverseas.addAll(localArrayList4);
    }
  }
  
  public static boolean foundNRemoveIP(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, String paramString)
  {
    if (paramCopyOnWriteArrayList == null) {
      return false;
    }
    Iterator localIterator = paramCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equalsIgnoreCase(paramString))
      {
        i = 1;
        break label43;
      }
    }
    int i = 0;
    label43:
    if (i != 0)
    {
      paramCopyOnWriteArrayList.remove(paramString);
      return true;
    }
    return false;
  }
  
  private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty()))
    {
      paramCopyOnWriteArrayList = (String)paramCopyOnWriteArrayList.get(0);
      ArrayList localArrayList = this.mPort4HardCode;
      return new EndPoint(paramCopyOnWriteArrayList, ((Integer)localArrayList.get(rand(localArrayList.size() - 1))).intValue());
    }
    return null;
  }
  
  public static int rand(int paramInt)
  {
    double d1 = Math.random();
    double d2 = paramInt + 1;
    Double.isNaN(d2);
    return (int)(d1 * d2);
  }
  
  public boolean foundNRemove(String paramString)
  {
    if (foundNRemoveIP(this.mHcIpCandicateListWifi, paramString)) {
      return true;
    }
    if (foundNRemoveIP(this.mHcIpCandicateListChinaMobile, paramString)) {
      return true;
    }
    if (foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, paramString)) {
      return true;
    }
    return foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, paramString);
  }
  
  public EndPoint getNextIp(Context paramContext)
  {
    if (HwNetworkUtil.isWifiEnabled(paramContext)) {
      return getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
    }
    int i = HwNetworkUtil.getCarrierOperatorType(paramContext);
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          return getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
        }
        return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
      }
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
    }
    return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
  }
  
  public EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty()))
    {
      paramCopyOnWriteArrayList = (String)paramCopyOnWriteArrayList.get(rand(paramCopyOnWriteArrayList.size() - 1));
      ArrayList localArrayList = this.mPort4HardCode;
      return new EndPoint(paramCopyOnWriteArrayList, ((Integer)localArrayList.get(rand(localArrayList.size() - 1))).intValue());
    }
    return null;
  }
  
  public boolean isEmpty(Context paramContext)
  {
    if (HwNetworkUtil.isWifiEnabled(paramContext)) {
      return this.mHcIpCandicateListWifi.isEmpty();
    }
    int i = HwNetworkUtil.getCarrierOperatorType(paramContext);
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4) {
          return this.mHcIpCandicateListOverseas.isEmpty();
        }
        return this.mHcIpCandicateListChinaTelecom.isEmpty();
      }
      return this.mHcIpCandicateListChinaUnicom.isEmpty();
    }
    return this.mHcIpCandicateListChinaMobile.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HardCodeIpList
 * JD-Core Version:    0.7.0.1
 */