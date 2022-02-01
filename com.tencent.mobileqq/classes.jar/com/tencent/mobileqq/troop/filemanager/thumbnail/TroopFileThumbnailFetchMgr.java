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
  private Map<String, TroopFileThumbnailFetchWorker> a = new HashMap();
  private LinkedList<String> b = new LinkedList();
  private LinkedList<TroopFileThumbnailFetchWorker> c = new LinkedList();
  
  public static String b(UUID paramUUID, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUUID.toString());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    if (this.c.size() >= 10) {
      return;
    }
    while (this.b.size() > 0)
    {
      Object localObject = (String)this.b.remove(0);
      localObject = (TroopFileThumbnailFetchWorker)this.a.remove(localObject);
      if (localObject != null)
      {
        this.c.add(localObject);
        if (((TroopFileThumbnailFetchWorker)localObject).c()) {
          break;
        }
        this.c.remove(localObject);
      }
    }
  }
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" WS:");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(" QS:");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append(" RS:");
    localStringBuilder.append(this.c.size());
    return localStringBuilder.toString();
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
      String str = b(paramItem.Id, paramInt);
      if (a(str))
      {
        paramInt = TroopFileTransferUtil.Log.b;
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
      this.a.put(str, localObject);
      this.b.add(str);
      paramInt = TroopFileTransferUtil.Log.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("] fetchFileThumbnail fileName. ");
      ((StringBuilder)localObject).append(paramItem.FileName);
      ((StringBuilder)localObject).append(e());
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
    String str = b(paramUUID, paramInt);
    Object localObject = this.c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopFileThumbnailFetchWorker localTroopFileThumbnailFetchWorker = (TroopFileThumbnailFetchWorker)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localTroopFileThumbnailFetchWorker.b()))
      {
        localTroopFileThumbnailFetchWorker.d();
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
      localObject = (TroopFileThumbnailFetchWorker)this.a.remove(paramUUID);
      i = paramInt;
      if (localObject != null)
      {
        ((TroopFileThumbnailFetchWorker)localObject).d();
        i = paramInt | 0x1;
      }
      i |= this.b.remove(paramUUID);
    }
    if (bool)
    {
      paramInt = TroopFileTransferUtil.Log.b;
      paramUUID = new StringBuilder();
      paramUUID.append("[");
      paramUUID.append(str);
      paramUUID.append("] stopFetch. ");
      paramUUID.append(e());
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
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailFetchWorker)localIterator.next()).b())) {
        return true;
      }
    }
    return this.a.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  protected void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailFetchWorker paramTroopFileThumbnailFetchWorker)
  {
    this.c.remove(paramTroopFileThumbnailFetchWorker);
    int i = TroopFileTransferUtil.Log.b;
    paramTroopFileThumbnailFetchWorker = new StringBuilder();
    paramTroopFileThumbnailFetchWorker.append("[");
    paramTroopFileThumbnailFetchWorker.append(paramString);
    paramTroopFileThumbnailFetchWorker.append("] onWorkDoneInter. bSuc:");
    paramTroopFileThumbnailFetchWorker.append(paramBoolean);
    paramTroopFileThumbnailFetchWorker.append(" errCode:");
    paramTroopFileThumbnailFetchWorker.append(paramInt);
    paramTroopFileThumbnailFetchWorker.append(e());
    TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", i, paramTroopFileThumbnailFetchWorker.toString());
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailFetchWorker)localIterator.next()).d();
    }
    this.c.clear();
    localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailFetchWorker)localIterator.next()).d();
    }
    this.a.clear();
    this.b.clear();
    TroopFileTransferUtil.Log.c("TroopFileThumbnailFetchMgr", TroopFileTransferUtil.Log.b, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr
 * JD-Core Version:    0.7.0.1
 */