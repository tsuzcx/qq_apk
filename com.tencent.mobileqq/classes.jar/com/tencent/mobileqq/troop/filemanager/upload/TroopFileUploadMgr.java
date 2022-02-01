package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtfGroupSendWorker;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
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
  implements INetInfoHandler
{
  private static TroopFileUploadMgr jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr;
  TroopFileUploadMgr.ITroopFileUploadWorkerListener jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener = new TroopFileUploadMgr.6(this);
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, TroopFileUploadMgr.ITroopFileUploadWorker> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected boolean a;
  private LinkedList<UUID> b = new LinkedList();
  private LinkedList<UUID> c = new LinkedList();
  private LinkedList<TroopFileUploadMgr.ITroopFileUploadWorker> d = new LinkedList();
  
  private TroopFileUploadMgr()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
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
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " PS:" + this.b.size() + " PPS:" + this.c.size() + " RS:" + this.d.size();
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
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileUploadMgr.ITroopFileUploadWorker)localIterator.next()).b())) {
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
    long l = FileManagerUtil.a(paramItem.LocalFile);
    if ((l > 0L) && (ExcitingTransferAdapter.a().c()) && (l > ExcitingTransferAdapter.a().c())) {}
    for (paramBundle = ExtfGroupSendWorker.a(paramLong, paramItem, paramBundle, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener); paramBundle == null; paramBundle = TroopFileUploadWorker.b(paramLong, paramItem, paramBundle, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.k();
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramItem.Id.toString() + "] startUpload filePath. " + paramItem.LocalFile + a());
    c();
    return 0;
  }
  
  private int b(UUID paramUUID, long paramLong, String paramString1, String paramString2, TroopFileUploadMgr.ITroopFileUploadWorkerListener paramITroopFileUploadWorkerListener)
  {
    if (a(paramUUID))
    {
      TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] startUpload worker exsited. ");
      return -4;
    }
    paramString1 = new TroopFileUploadSimpleWorker(paramUUID, paramLong, paramString1, paramString2);
    paramString1.a(paramITroopFileUploadWorkerListener);
    paramString1.a(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadTroopFileUploadMgr$ITroopFileUploadWorkerListener);
    this.jdField_a_of_type_JavaUtilMap.put(paramUUID, paramString1);
    this.b.add(paramUUID);
    paramString1.a();
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] startUpload filePath. " + paramString2 + a());
    c();
    return 0;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.d.iterator();
    while (paramBundle.hasNext())
    {
      TroopFileUploadMgr.ITroopFileUploadWorker localITroopFileUploadWorker = (TroopFileUploadMgr.ITroopFileUploadWorker)paramBundle.next();
      if (paramUUID.equals(localITroopFileUploadWorker.a()))
      {
        localITroopFileUploadWorker.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (TroopFileUploadMgr.ITroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label185;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label185:
      for (;;)
      {
        boolean bool3 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID);
        boolean bool4 = this.b.remove(paramUUID);
        bool2 = this.c.remove(paramUUID) | bool1 | bool3 | bool4;
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
    if (this.d.size() >= 4) {}
    label592:
    label594:
    label597:
    for (;;)
    {
      return;
      Object localObject1 = this.c.iterator();
      Object localObject2;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label594;
        }
        localObject2 = (UUID)((Iterator)localObject1).next();
        TroopFileUploadMgr.ITroopFileUploadWorker localITroopFileUploadWorker = (TroopFileUploadMgr.ITroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if (localITroopFileUploadWorker == null)
        {
          ((Iterator)localObject1).remove();
          this.jdField_a_of_type_JavaUtilMap.remove(localObject2);
          TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject2).toString() + "] runNextWorker worker not find." + a());
        }
        else if (!a(localITroopFileUploadWorker.b()))
        {
          ((Iterator)localObject1).remove();
          this.jdField_a_of_type_JavaUtilMap.remove(localObject2);
          this.d.add(localITroopFileUploadWorker);
          if (localITroopFileUploadWorker.a()) {
            break;
          }
          this.d.remove(localITroopFileUploadWorker);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label597;
        }
        while (this.b.size() > 0)
        {
          localObject1 = (UUID)this.b.remove(0);
          localObject2 = (TroopFileUploadMgr.ITroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.remove(localObject1);
          if (localObject2 != null)
          {
            if (a(((TroopFileUploadMgr.ITroopFileUploadWorker)localObject2).b()))
            {
              this.c.add(localObject1);
              this.jdField_a_of_type_JavaUtilMap.put(localObject1, localObject2);
              TroopFileTransferUtil.Log.b("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + a());
            }
            else
            {
              this.d.add(localObject2);
              if (((TroopFileUploadMgr.ITroopFileUploadWorker)localObject2).a()) {
                break;
              }
              this.d.remove(localObject2);
            }
          }
          else {
            TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 2." + a());
          }
        }
        if (this.d.size() >= 2) {
          break;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
            break label592;
          }
          localObject1 = (UUID)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
          localObject2 = (TroopFileUploadMgr.ITroopFileUploadWorker)this.jdField_a_of_type_JavaUtilMap.remove(localObject1);
          if (localObject2 != null)
          {
            if (a(((TroopFileUploadMgr.ITroopFileUploadWorker)localObject2).b()))
            {
              this.c.add(localObject1);
              this.jdField_a_of_type_JavaUtilMap.put(localObject1, localObject2);
              TroopFileTransferUtil.Log.b("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + a());
              continue;
            }
            this.d.add(localObject2);
            if (((TroopFileUploadMgr.ITroopFileUploadWorker)localObject2).a()) {
              break;
            }
            this.d.remove(localObject2);
            continue;
          }
          TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 3." + a());
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
    TroopFileTransferMgr.a(new TroopFileUploadMgr.4(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public int a(UUID paramUUID, long paramLong, String paramString1, String paramString2, TroopFileUploadMgr.ITroopFileUploadWorkerListener paramITroopFileUploadWorkerListener)
  {
    TroopFileTransferMgr.a(new TroopFileUploadMgr.5(this, paramUUID, paramLong, paramString1, paramString2, paramITroopFileUploadWorkerListener), false);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "stopUpload item.id null.");
      return -2;
    }
    TroopFileTransferMgr.a(new TroopFileUploadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileUploadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    TroopFileTransferUtil.Log.b("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "failAll. reason:" + paramInt);
    TroopFileTransferMgr.a(new TroopFileUploadMgr.8(this, paramInt), false);
  }
  
  protected void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.d.iterator();
    TroopFileUploadMgr.ITroopFileUploadWorker localITroopFileUploadWorker;
    while (localIterator.hasNext())
    {
      localITroopFileUploadWorker = (TroopFileUploadMgr.ITroopFileUploadWorker)localIterator.next();
      localITroopFileUploadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localITroopFileUploadWorker.a()));
      }
    }
    this.d.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localITroopFileUploadWorker = (TroopFileUploadMgr.ITroopFileUploadWorker)localIterator.next();
      localITroopFileUploadWorker.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localITroopFileUploadWorker.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.c.clear();
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "stopAllInter. reason:" + paramInt);
  }
  
  protected void a(UUID paramUUID, boolean paramBoolean, int paramInt, TroopFileUploadMgr.ITroopFileUploadWorker paramITroopFileUploadWorker)
  {
    this.d.remove(paramITroopFileUploadWorker);
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((TroopFileUploadMgr.ITroopFileUploadWorker)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public void b()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "release");
    try
    {
      ThreadManager.getSubThreadHandler().post(new TroopFileUploadMgr.2(this));
      if (Build.VERSION.SDK_INT == 19)
      {
        a(2, null);
        return;
      }
      TroopFileTransferMgr.a(new TroopFileUploadMgr.3(this), true);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
    TroopFileTransferMgr.a(new TroopFileUploadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    TroopFileTransferMgr.a(new TroopFileUploadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadMgr", TroopFileTransferUtil.Log.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr
 * JD-Core Version:    0.7.0.1
 */