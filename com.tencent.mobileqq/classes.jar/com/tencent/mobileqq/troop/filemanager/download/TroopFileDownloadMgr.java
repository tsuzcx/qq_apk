package com.tencent.mobileqq.troop.filemanager.download;

import ajli;
import ajlj;
import ajlk;
import ajll;
import ajlm;
import ajln;
import ajlo;
import ajlp;
import ajlq;
import ajlr;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.UUID;
import mqq.os.MqqHandler;

public class TroopFileDownloadMgr
  extends Observable
  implements INetInfoHandler, TroopFileDownloadWorker.ITroopFileDownloadWorkerListener
{
  private static TroopFileDownloadMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList b = new LinkedList();
  
  public static TroopFileDownloadMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr == null) {
        jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr = new TroopFileDownloadMgr();
      }
      TroopFileDownloadMgr localTroopFileDownloadMgr = jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloadMgr;
      return localTroopFileDownloadMgr;
    }
    finally {}
  }
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " RS:" + this.b.size();
  }
  
  private final void a(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.b.iterator();
    while (paramBundle.hasNext())
    {
      TroopFileDownloadWorker localTroopFileDownloadWorker = (TroopFileDownloadWorker)paramBundle.next();
      if (paramUUID.equals(localTroopFileDownloadWorker.a()))
      {
        localTroopFileDownloadWorker.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (TroopFileDownloadWorker)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label153;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label153:
      for (;;)
      {
        bool2 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | bool1;
        if (bool2) {
          TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] stopDownload." + a());
        }
        c();
        return 0;
      }
    }
  }
  
  private int c(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    paramBundle = TroopFileDownloadWorker.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.a();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
    c();
    return 0;
  }
  
  private void c()
  {
    if (this.b.size() >= 2) {}
    label78:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label78;
        }
        Object localObject = (UUID)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (TroopFileDownloadWorker)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((TroopFileDownloadWorker)localObject).a()) {
            break;
          }
          this.b.remove(localObject);
        }
      }
    }
  }
  
  private int d(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = TroopZipInnerFileDownloadWorker.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.a();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
    c();
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    paramItem = TroopFilePreviewWorker.a(paramLong, paramItem);
    if (paramItem == null) {
      return -3;
    }
    if (!paramItem.a()) {
      return -5;
    }
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new ajlm(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "stopUpload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new ajlo(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "init");
    ThreadManager.getSubThreadHandler().post(new ajli(this));
  }
  
  protected void a(int paramInt)
  {
    TroopFileTransferUtil.Log.b("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "failAll. reason:" + paramInt);
    TroopFileTransferMgr.a(new ajlq(this, paramInt), false);
  }
  
  public void a(int paramInt, Set paramSet)
  {
    Iterator localIterator = this.b.iterator();
    TroopFileDownloadWorker localTroopFileDownloadWorker;
    while (localIterator.hasNext())
    {
      localTroopFileDownloadWorker = (TroopFileDownloadWorker)localIterator.next();
      localTroopFileDownloadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileDownloadWorker.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localTroopFileDownloadWorker = (TroopFileDownloadWorker)localIterator.next();
      localTroopFileDownloadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileDownloadWorker.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "stopAllInter");
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileDownloadWorker paramTroopFileDownloadWorker)
  {
    TroopFileTransferMgr.a(new ajlp(this, paramUUID, paramBoolean, paramInt, paramTroopFileDownloadWorker), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((TroopFileDownloadWorker)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new ajln(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "release");
    ThreadManager.getSubThreadHandler().post(new ajlk(this));
    TroopFileTransferMgr.a(new ajll(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileDownloadWorker paramTroopFileDownloadWorker)
  {
    this.b.remove(paramTroopFileDownloadWorker);
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetNone2Mobile");
    TroopFileTransferMgr.a(new ajlr(this), false);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    TroopFileTransferMgr.a(new ajlj(this), false);
  }
  
  public void onNetWifi2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileDownloadMgr", TroopFileTransferUtil.Log.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr
 * JD-Core Version:    0.7.0.1
 */