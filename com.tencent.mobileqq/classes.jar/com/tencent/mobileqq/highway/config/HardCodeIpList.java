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
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((String)localIterator.next()).equalsIgnoreCase(paramString));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCopyOnWriteArrayList.remove(paramString);
        return true;
      }
      return false;
    }
  }
  
  private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(0), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  public static int rand(int paramInt)
  {
    return (int)(Math.random() * (paramInt + 1));
  }
  
  public boolean foundNRemove(String paramString)
  {
    if (foundNRemoveIP(this.mHcIpCandicateListWifi, paramString)) {}
    while ((foundNRemoveIP(this.mHcIpCandicateListChinaMobile, paramString)) || (foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, paramString)) || (foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, paramString))) {
      return true;
    }
    return false;
  }
  
  public EndPoint getNextIp(Context paramContext)
  {
    if (HwNetworkUtil.isWifiEnabled(paramContext)) {
      return getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
    }
    switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
    {
    default: 
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
    case 2: 
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
    case 3: 
      return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
    }
    return getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
  }
  
  public EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(rand(paramCopyOnWriteArrayList.size() - 1)), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  public boolean isEmpty(Context paramContext)
  {
    if (HwNetworkUtil.isWifiEnabled(paramContext)) {
      return this.mHcIpCandicateListWifi.isEmpty();
    }
    switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
    {
    default: 
      return this.mHcIpCandicateListOverseas.isEmpty();
    case 2: 
      return this.mHcIpCandicateListChinaMobile.isEmpty();
    case 3: 
      return this.mHcIpCandicateListChinaUnicom.isEmpty();
    }
    return this.mHcIpCandicateListChinaTelecom.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HardCodeIpList
 * JD-Core Version:    0.7.0.1
 */