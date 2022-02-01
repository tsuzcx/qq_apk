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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" WS:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
    localStringBuilder.append(" QS:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append(" RS:");
    localStringBuilder.append(this.b.size());
    return localStringBuilder.toString();
  }
  
  public static String a(UUID paramUUID, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUUID.toString());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    if (this.b.size() >= 10) {
      return;
    }
    while (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
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
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    if ((paramLong != 0L) && (paramItem != null))
    {
      if (paramItem.Id == null) {
        return -2;
      }
      if (paramInt == 0) {
        return -5;
      }
      String str = a(paramItem.Id, paramInt);
      if (a(str))
      {
        paramInt = TroopFileTransferUtil.Log.a;
        paramItem = new StringBuilder();
        paramItem.append("[");
        paramItem.append(str);
        paramItem.append("] fetchFileThumbnail worker exsited. ");
        TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", paramInt, paramItem.toString());
        return -4;
      }
      Object localObject = TroopFileThumbnailFetchWorker.a(paramLong, paramItem, paramInt, this);
      if (localObject == null) {
        return -3;
      }
      TroopFileThumbnailMgr.a(paramItem, paramInt);
      this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
      this.jdField_a_of_type_JavaUtilLinkedList.add(str);
      paramInt = TroopFileTransferUtil.Log.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("] fetchFileThumbnail fileName. ");
      ((StringBuilder)localObject).append(paramItem.FileName);
      ((StringBuilder)localObject).append(a());
      TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", paramInt, ((StringBuilder)localObject).toString());
      d();
      return 0;
    }
    return -1;
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
        paramInt = 1;
        break label77;
      }
    }
    paramInt = 0;
    label77:
    int i = paramInt;
    boolean bool;
    if (paramInt == 0)
    {
      localObject = (TroopFileThumbnailFetchWorker)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      i = paramInt;
      if (localObject != null)
      {
        ((TroopFileThumbnailFetchWorker)localObject).a();
        i = paramInt | 0x1;
      }
      i |= this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID);
    }
    if (bool)
    {
      paramInt = TroopFileTransferUtil.Log.a;
      paramUUID = new StringBuilder();
      paramUUID.append("[");
      paramUUID.append(str);
      paramUUID.append("] stopFetch. ");
      paramUUID.append(a());
      TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", paramInt, paramUUID.toString());
    }
    d();
    return 0;
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
    int i = TroopFileTransferUtil.Log.a;
    paramTroopFileThumbnailFetchWorker = new StringBuilder();
    paramTroopFileThumbnailFetchWorker.append("[");
    paramTroopFileThumbnailFetchWorker.append(paramString);
    paramTroopFileThumbnailFetchWorker.append("] onWorkDoneInter. bSuc:");
    paramTroopFileThumbnailFetchWorker.append(paramBoolean);
    paramTroopFileThumbnailFetchWorker.append(" errCode:");
    paramTroopFileThumbnailFetchWorker.append(paramInt);
    paramTroopFileThumbnailFetchWorker.append(a());
    TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", i, paramTroopFileThumbnailFetchWorker.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr
 * JD-Core Version:    0.7.0.1
 */