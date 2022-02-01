package com.tencent.mobileqq.troop.filemanager.thumbnail;

import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class TroopFileThumbnailFetchMgr
  implements TroopFileThumbnailFetchWorker.ITroopFileThumbFetchWorkerListener
{
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, TroopFileThumbnailFetchWorker> jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList<TroopFileThumbnailFetchWorker> b = new LinkedList();
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " RS:" + this.b.size();
  }
  
  public static String a(UUID paramUUID, int paramInt)
  {
    return paramUUID.toString() + "_" + paramInt;
  }
  
  private void d()
  {
    if (this.b.size() >= 10) {}
    label79:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label79;
        }
        Object localObject = (String)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (TroopFileThumbnailFetchWorker)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((TroopFileThumbnailFetchWorker)localObject).a()) {
            break;
          }
          this.b.remove(localObject);
        }
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    if (paramInt == 0) {
      return -5;
    }
    String str = a(paramItem.Id, paramInt);
    if (a(str))
    {
      TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", TroopFileTransferUtil.Log.a, "[" + str + "] fetchFileThumbnail worker exsited. ");
      return -4;
    }
    TroopFileThumbnailFetchWorker localTroopFileThumbnailFetchWorker = TroopFileThumbnailFetchWorker.a(paramLong, paramItem, paramInt, this);
    if (localTroopFileThumbnailFetchWorker == null) {
      return -3;
    }
    TroopFileThumbnailMgr.a(paramItem, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, localTroopFileThumbnailFetchWorker);
    this.jdField_a_of_type_JavaUtilLinkedList.add(str);
    TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", TroopFileTransferUtil.Log.a, "[" + str + "] fetchFileThumbnail fileName. " + paramItem.FileName + a());
    d();
    return 0;
  }
  
  public int a(UUID paramUUID, int paramInt)
  {
    if (paramUUID == null) {
      return -2;
    }
    String str = a(paramUUID, paramInt);
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopFileThumbnailFetchWorker localTroopFileThumbnailFetchWorker = (TroopFileThumbnailFetchWorker)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localTroopFileThumbnailFetchWorker.a()))
      {
        localTroopFileThumbnailFetchWorker.a();
        ((Iterator)localObject).remove();
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        localObject = (TroopFileThumbnailFetchWorker)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (localObject == null) {
          break label168;
        }
        ((TroopFileThumbnailFetchWorker)localObject).a();
        paramInt |= 0x1;
      }
      label168:
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | paramInt;
        if (bool) {
          TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", TroopFileTransferUtil.Log.a, "[" + str + "] stopFetch. " + a());
        }
        d();
        return 0;
      }
    }
  }
  
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker)
  {
    TroopFileTransferMgr.a(new TroopFileThumbnailFetchMgr.1(this, paramString, paramBoolean, paramInt, paramTroopFileThumbnailFetchWorker), false);
  }
  
  protected boolean a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailFetchWorker)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  protected void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker)
  {
    this.b.remove(paramTroopFileThumbnailFetchWorker);
    TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", TroopFileTransferUtil.Log.a, "[" + paramString + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailFetchWorker)localIterator.next()).a();
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailFetchWorker)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", TroopFileTransferUtil.Log.a, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr
 * JD-Core Version:    0.7.0.1
 */