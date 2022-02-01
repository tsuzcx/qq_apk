package com.tencent.mobileqq.pluspanel.loader.c2c;

import android.util.SparseIntArray;
import aptq;
import apub;
import ayfl;
import bbyp;
import bcoo;
import com.tencent.mobileqq.pluspanel.appinfo.AVGameAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.ArkAppManagerAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.ArkSampleAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.AudioCallAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.BusinessCardAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.CMShowAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.DoodleAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.FavoriteAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.FileAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.GiftAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.HotPicAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.ListenTogetherAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.LocationAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.MiniAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.PicAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.PlusPanelAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.PokeAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.ReceiptMsgAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.RedPacketAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.ShootAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.SingTogetherAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.TencentDocsAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.TransferAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.TroopDingYueAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.TroopTouPiaoAppInfo;
import com.tencent.mobileqq.pluspanel.appinfo.VideoCallAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public enum C2CPlusPanelAppConfigHelper
{
  INSTANCE;
  
  private static final String TAG = "PlusPanelHelper";
  public final PlusPanelAppInfo[] entities = { new ArkAppManagerAppInfo(0), new ArkSampleAppInfo(0), new AudioCallAppInfo(0), new VideoCallAppInfo(0), new PokeAppInfo(0), new HotPicAppInfo(0), new LocationAppInfo(0), new FileAppInfo(0), new ListenTogetherAppInfo(0), new SingTogetherAppInfo(0), new FavoriteAppInfo(0), new MiniAppInfo(0), new DoodleAppInfo(0), new TransferAppInfo(0), new BusinessCardAppInfo(0), new GiftAppInfo(0), new TencentDocsAppInfo(0), new CMShowAppInfo(0), new ReceiptMsgAppInfo(0), new PicAppInfo(0), new ShootAppInfo(0), new RedPacketAppInfo(0), new ShareScreenAppInfo(0), new AVGameAppInfo(0), new TroopDingYueAppInfo(0), new TroopTouPiaoAppInfo(0) };
  
  private C2CPlusPanelAppConfigHelper() {}
  
  private static SparseIntArray getAppInfoOrder()
  {
    try
    {
      Object localObject;
      if (bcoo.a())
      {
        localObject = (ayfl)apub.a().a(611);
        if (localObject != null) {
          return ((ayfl)localObject).a;
        }
      }
      else
      {
        boolean bool = bbyp.b();
        localObject = (ayfl)apub.a().a(495);
        if (localObject != null)
        {
          if (bool) {
            return ((ayfl)localObject).b;
          }
          localObject = ((ayfl)localObject).a;
          return localObject;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PlusPanelHelper", 1, localThrowable, new Object[0]);
    }
    return new SparseIntArray();
  }
  
  private List<Integer> getManageConfigIds()
  {
    ArrayList localArrayList = new ArrayList();
    PlusPanelAppInfo[] arrayOfPlusPanelAppInfo = this.entities;
    int j = arrayOfPlusPanelAppInfo.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfPlusPanelAppInfo[i].getManageConfigID();
      if (k > 0) {
        localArrayList.add(Integer.valueOf(k));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private List<PlusPanelAppInfo> sortAndFilterAioAppInfo()
  {
    SparseIntArray localSparseIntArray = getAppInfoOrder();
    ArrayList localArrayList = new ArrayList(Arrays.asList(this.entities));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)localIterator.next();
      if (localPlusPanelAppInfo.appid <= 0)
      {
        localIterator.remove();
      }
      else
      {
        int i = localSparseIntArray.get(localPlusPanelAppInfo.getAppID(), -1);
        if (i > 0) {
          localPlusPanelAppInfo.sort = i;
        } else {
          localIterator.remove();
        }
      }
    }
    Collections.sort(localArrayList);
    return localArrayList;
  }
  
  public boolean containsType(int paramInt)
  {
    boolean bool2 = false;
    PlusPanelAppInfo[] arrayOfPlusPanelAppInfo = this.entities;
    int j = arrayOfPlusPanelAppInfo.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        PlusPanelAppInfo localPlusPanelAppInfo = arrayOfPlusPanelAppInfo[i];
        if ((localPlusPanelAppInfo != null) && (localPlusPanelAppInfo.getManageConfigID() == paramInt)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public aptq genProcess(int paramInt)
  {
    PlusPanelAppInfo[] arrayOfPlusPanelAppInfo = this.entities;
    int j = arrayOfPlusPanelAppInfo.length;
    int i = 0;
    while (i < j)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = arrayOfPlusPanelAppInfo[i];
      if ((localPlusPanelAppInfo != null) && (localPlusPanelAppInfo.getManageConfigID() == paramInt)) {
        return localPlusPanelAppInfo.createConfigProcessor();
      }
      i += 1;
    }
    return null;
  }
  
  public PlusPanelAppInfo getAppInfoByAppID(int paramInt)
  {
    PlusPanelAppInfo[] arrayOfPlusPanelAppInfo = this.entities;
    int j = arrayOfPlusPanelAppInfo.length;
    int i = 0;
    while (i < j)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = arrayOfPlusPanelAppInfo[i];
      if ((localPlusPanelAppInfo != null) && (localPlusPanelAppInfo.getAppID() == paramInt)) {
        return localPlusPanelAppInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public List<PlusPanelAppInfo> getC2CAppInfo()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.entities;
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = localObject1[i];
          if ((localObject2 != null) && (localObject2.getManageConfigID() > 0)) {
            apub.a().a(localObject2.getManageConfigID());
          }
        }
        else
        {
          localObject1 = sortAndFilterAioAppInfo();
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("PlusPanelHelper", 1, localException, new Object[0]);
        return new ArrayList();
      }
      i += 1;
    }
  }
  
  public int[] getConfigTypes()
  {
    List localList = getManageConfigIds();
    int[] arrayOfInt = new int[localList.size()];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = ((Integer)localList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public String getRedDotID(int paramInt)
  {
    PlusPanelAppInfo[] arrayOfPlusPanelAppInfo = this.entities;
    int j = arrayOfPlusPanelAppInfo.length;
    int i = 0;
    while (i < j)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = arrayOfPlusPanelAppInfo[i];
      if ((localPlusPanelAppInfo != null) && (localPlusPanelAppInfo.getAppID() == paramInt)) {
        return String.valueOf(localPlusPanelAppInfo.getRedDotID());
      }
      i += 1;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.loader.c2c.C2CPlusPanelAppConfigHelper
 * JD-Core Version:    0.7.0.1
 */