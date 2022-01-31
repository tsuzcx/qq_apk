package com.tencent.mobileqq.troop.filemanager.upload;

import ajms;
import ajmt;
import ajmu;
import ajmv;
import ajmw;
import ajmx;
import ajmy;
import ajmz;
import ajna;
import android.os.Bundle;
import android.text.TextUtils;
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

public class TroopFileUploadMgr
  extends Observable
  implements INetInfoHandler, TroopFileUploadWorker.ITroopFileUploadWorkerListener
{
  private static TroopFileUploadMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList b = new LinkedList();
  private LinkedList c = new LinkedList();
  
  public static TroopFileUploadMgr a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr == null) {
        jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr = new TroopFileUploadMgr();
      }
      TroopFileUploadMgr localTroopFileUploadMgr = jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr;
      return localTroopFileUploadMgr;
    }
    finally {}
  }
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " PS:" + this.b.size() + " RS:" + this.c.size();
  }
  
  private final void a(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileUploadWorker)localIterator.next()).a())) {
        return true;
      }
    }
    return false;
  }
  
  private int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startUpload worker exsited. ");
      return -4;
    }
    paramBundle = TroopFileUploadWorker.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.b();
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startUpload filePath. " + paramItem.LocalFile + a());
    c();
    return 0;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.c.iterator();
    while (paramBundle.hasNext())
    {
      TroopFileUploadWorker localTroopFileUploadWorker = (TroopFileUploadWorker)paramBundle.next();
      if (paramUUID.equals(localTroopFileUploadWorker.a()))
      {
        localTroopFileUploadWorker.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (TroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label166;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label166:
      for (;;)
      {
        boolean bool3 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID);
        bool2 = this.b.remove(paramUUID) | bool1 | bool3;
        if (bool2) {
          TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] stopUpload." + a());
        }
        c();
        return 0;
      }
    }
  }
  
  private void c()
  {
    if (this.c.size() >= 2) {}
    label375:
    label377:
    label380:
    for (;;)
    {
      return;
      Object localObject1 = this.b.iterator();
      Object localObject2;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label377;
        }
        localObject2 = (UUID)((Iterator)localObject1).next();
        TroopFileUploadWorker localTroopFileUploadWorker = (TroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if (localTroopFileUploadWorker == null)
        {
          ((Iterator)localObject1).remove();
          this.jdField_a_of_type_JavaUtilMap.remove(localObject2);
          TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject2).toString() + "] runNextWorker worker not find." + a());
        }
        else if (!a(localTroopFileUploadWorker.a()))
        {
          ((Iterator)localObject1).remove();
          this.jdField_a_of_type_JavaUtilMap.remove(localObject2);
          this.c.add(localTroopFileUploadWorker);
          if (localTroopFileUploadWorker.a()) {
            break;
          }
          this.c.remove(localTroopFileUploadWorker);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label380;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
            break label375;
          }
          localObject1 = (UUID)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
          localObject2 = (TroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.remove(localObject1);
          if (localObject2 != null)
          {
            if (a(((TroopFileUploadWorker)localObject2).a()))
            {
              this.b.add(localObject1);
              this.jdField_a_of_type_JavaUtilMap.put(localObject1, localObject2);
              TroopFileTransferUtil.Log.b("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + a());
              continue;
            }
            this.c.add(localObject2);
            if (((TroopFileUploadWorker)localObject2).a()) {
              break;
            }
            this.c.remove(localObject2);
            continue;
          }
          TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 2." + a());
        }
        break;
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "startUpload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "startUpload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new ajmv(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "stopUpload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new ajmw(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "init");
    ThreadManager.getSubThreadHandler().post(new ajms(this));
  }
  
  protected void a(int paramInt)
  {
    TroopFileTransferUtil.Log.b("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "failAll. reason:" + paramInt);
    TroopFileTransferMgr.a(new ajmy(this, paramInt), false);
  }
  
  public void a(int paramInt, Set paramSet)
  {
    Iterator localIterator = this.c.iterator();
    TroopFileUploadWorker localTroopFileUploadWorker;
    while (localIterator.hasNext())
    {
      localTroopFileUploadWorker = (TroopFileUploadWorker)localIterator.next();
      localTroopFileUploadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileUploadWorker.a()));
      }
    }
    this.c.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localTroopFileUploadWorker = (TroopFileUploadWorker)localIterator.next();
      localTroopFileUploadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localTroopFileUploadWorker.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.b.clear();
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "stopAllInter. reason:" + paramInt);
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileUploadWorker paramTroopFileUploadWorker)
  {
    TroopFileTransferMgr.a(new ajmx(this, paramUUID, paramBoolean, paramInt, paramTroopFileUploadWorker), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((TroopFileUploadWorker)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "release");
    ThreadManager.getSubThreadHandler().post(new ajmt(this));
    TroopFileTransferMgr.a(new ajmu(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileUploadWorker paramTroopFileUploadWorker)
  {
    this.c.remove(paramTroopFileUploadWorker);
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "onNetNone2Mobile");
    TroopFileTransferMgr.a(new ajmz(this), false);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    TroopFileTransferMgr.a(new ajna(this), false);
  }
  
  public void onNetWifi2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr
 * JD-Core Version:    0.7.0.1
 */