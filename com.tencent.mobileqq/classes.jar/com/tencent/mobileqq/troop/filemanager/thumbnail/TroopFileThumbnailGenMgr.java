package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class TroopFileThumbnailGenMgr
  implements TroopFileThumbnailGenTask.ITroopFileThumbGenTaskListener
{
  private Map<String, TroopFileThumbnailGenTask> a = new HashMap();
  private LinkedList<String> b = new LinkedList();
  private LinkedList<TroopFileThumbnailGenTask> c = new LinkedList();
  private LinkedList<TroopFileThumbnailGenTask> d = new LinkedList();
  
  private boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TroopFileThumbnailGenTask localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.f()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.d()))) {
        return true;
      }
    }
    return false;
  }
  
  public static String b(UUID paramUUID, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramUUID.toString());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private LinkedList<TroopFileThumbnailGenTask> b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.a.entrySet().iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Map.Entry)localIterator.next()).getValue();
      if ((paramInt == localTroopFileThumbnailGenTask.f()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.d())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.f()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.d())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    return localLinkedList;
  }
  
  private void d()
  {
    if (this.c.size() >= 4) {
      return;
    }
    while (this.b.size() > 0)
    {
      Object localObject = (String)this.b.remove(0);
      localObject = (TroopFileThumbnailGenTask)this.a.remove(localObject);
      if (localObject != null)
      {
        int i;
        StringBuilder localStringBuilder;
        if (a(((TroopFileThumbnailGenTask)localObject).d(), ((TroopFileThumbnailGenTask)localObject).f()))
        {
          i = TroopFileTransferUtil.Log.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(((TroopFileThumbnailGenTask)localObject).a());
          localStringBuilder.append("] has same task gening. add WD task");
          TroopFileTransferUtil.Log.b("TroopFileThumbnailGenMgr", i, localStringBuilder.toString());
          this.d.add(localObject);
          ((TroopFileThumbnailGenTask)localObject).g();
        }
        else
        {
          this.c.add(localObject);
          if (((TroopFileThumbnailGenTask)localObject).b()) {
            break;
          }
          i = TroopFileTransferUtil.Log.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(((TroopFileThumbnailGenTask)localObject).a());
          localStringBuilder.append("] start failed!!");
          TroopFileTransferUtil.Log.a("TroopFileThumbnailGenMgr", i, localStringBuilder.toString());
          this.c.remove(localObject);
        }
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
    localStringBuilder.append(" PRS:");
    localStringBuilder.append(this.d.size());
    localStringBuilder.append(" RS:");
    localStringBuilder.append(this.c.size());
    return localStringBuilder.toString();
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
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
        paramItem.append("] genFileThumbnail task exsited. ");
        TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", paramInt, paramItem.toString());
        return -4;
      }
      paramString = TroopFileThumbnailGenTask.a(paramLong, paramItem, paramInt, paramString, this);
      if (paramString == null) {
        return -3;
      }
      TroopFileThumbnailMgr.a(paramItem, paramInt);
      this.a.put(str, paramString);
      this.b.add(str);
      paramInt = TroopFileTransferUtil.Log.b;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(str);
      paramString.append("] genFileThumbnail filePath:");
      paramString.append(paramItem.LocalFile);
      paramString.append(e());
      TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", paramInt, paramString.toString());
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
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (((Iterator)localObject).hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localTroopFileThumbnailGenTask.a()))
      {
        localTroopFileThumbnailGenTask.c();
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
      localObject = this.d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
        if (str.equalsIgnoreCase(localTroopFileThumbnailGenTask.a()))
        {
          localTroopFileThumbnailGenTask.c();
          ((Iterator)localObject).remove();
          paramInt = 1;
        }
      }
      localObject = (TroopFileThumbnailGenTask)this.a.remove(paramUUID);
      i = paramInt;
      if (localObject != null)
      {
        ((TroopFileThumbnailGenTask)localObject).c();
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
      paramUUID.append("] stopGen.");
      paramUUID.append(e());
      TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", paramInt, paramUUID.toString());
    }
    d();
    return 0;
  }
  
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    TroopFileTransferMgr.a(new TroopFileThumbnailGenMgr.1(this, paramString, paramBoolean, paramInt, paramTroopFileThumbnailGenTask), false);
  }
  
  protected boolean a(String paramString)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).a())) {
        return true;
      }
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).a())) {
        return true;
      }
    }
    return this.a.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  protected void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    this.c.remove(paramTroopFileThumbnailGenTask);
    this.d.remove(paramTroopFileThumbnailGenTask);
    int i = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] onTaskDoneInter.  bSuc:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(e());
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", i, ((StringBuilder)localObject).toString());
    localObject = b(paramTroopFileThumbnailGenTask.d(), paramTroopFileThumbnailGenTask.f());
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      i = TroopFileTransferUtil.Log.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] onTaskDoneInter. ");
      localStringBuilder.append(((LinkedList)localObject).size());
      localStringBuilder.append(" same task passive complete. ");
      localStringBuilder.append(e());
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenMgr", i, localStringBuilder.toString());
      paramString = ((LinkedList)localObject).iterator();
      while (paramString.hasNext()) {
        ((TroopFileThumbnailGenTask)paramString.next()).a(paramBoolean, paramInt, paramTroopFileThumbnailGenTask.e());
      }
    }
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailGenTask)localIterator.next()).c();
    }
    this.c.clear();
    this.a.clear();
    this.b.clear();
    this.d.clear();
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.b, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenMgr
 * JD-Core Version:    0.7.0.1
 */