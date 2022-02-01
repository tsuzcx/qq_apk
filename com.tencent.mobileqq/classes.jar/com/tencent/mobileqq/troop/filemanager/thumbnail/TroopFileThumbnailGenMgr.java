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
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, TroopFileThumbnailGenTask> jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList<TroopFileThumbnailGenTask> b = new LinkedList();
  private LinkedList<TroopFileThumbnailGenTask> c = new LinkedList();
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" WS:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
    localStringBuilder.append(" QS:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedList.size());
    localStringBuilder.append(" PRS:");
    localStringBuilder.append(this.c.size());
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
  
  private LinkedList<TroopFileThumbnailGenTask> a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Map.Entry)localIterator.next()).getValue();
      if ((paramInt == localTroopFileThumbnailGenTask.a()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.b())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.a()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.b())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    return localLinkedList;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TroopFileThumbnailGenTask localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.a()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.b()))) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.b.size() >= 4) {
      return;
    }
    while (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = (String)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
      localObject = (TroopFileThumbnailGenTask)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
      if (localObject != null)
      {
        int i;
        StringBuilder localStringBuilder;
        if (a(((TroopFileThumbnailGenTask)localObject).b(), ((TroopFileThumbnailGenTask)localObject).a()))
        {
          i = TroopFileTransferUtil.Log.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(((TroopFileThumbnailGenTask)localObject).a());
          localStringBuilder.append("] has same task gening. add WD task");
          TroopFileTransferUtil.Log.b("TroopFileThumbnailGenMgr", i, localStringBuilder.toString());
          this.c.add(localObject);
          ((TroopFileThumbnailGenTask)localObject).b();
        }
        else
        {
          this.b.add(localObject);
          if (((TroopFileThumbnailGenTask)localObject).a()) {
            break;
          }
          i = TroopFileTransferUtil.Log.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[");
          localStringBuilder.append(((TroopFileThumbnailGenTask)localObject).a());
          localStringBuilder.append("] start failed!!");
          TroopFileTransferUtil.Log.a("TroopFileThumbnailGenMgr", i, localStringBuilder.toString());
          this.b.remove(localObject);
        }
      }
    }
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
      String str = a(paramItem.Id, paramInt);
      if (a(str))
      {
        paramInt = TroopFileTransferUtil.Log.a;
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
      this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
      this.jdField_a_of_type_JavaUtilLinkedList.add(str);
      paramInt = TroopFileTransferUtil.Log.a;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(str);
      paramString.append("] genFileThumbnail filePath:");
      paramString.append(paramItem.LocalFile);
      paramString.append(a());
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
    String str = a(paramUUID, paramInt);
    Object localObject = this.b.iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (((Iterator)localObject).hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localTroopFileThumbnailGenTask.a()))
      {
        localTroopFileThumbnailGenTask.a();
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
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
        if (str.equalsIgnoreCase(localTroopFileThumbnailGenTask.a()))
        {
          localTroopFileThumbnailGenTask.a();
          ((Iterator)localObject).remove();
          paramInt = 1;
        }
      }
      localObject = (TroopFileThumbnailGenTask)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      i = paramInt;
      if (localObject != null)
      {
        ((TroopFileThumbnailGenTask)localObject).a();
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
      paramUUID.append("] stopGen.");
      paramUUID.append(a());
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
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).a())) {
        return true;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  protected void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    this.b.remove(paramTroopFileThumbnailGenTask);
    this.c.remove(paramTroopFileThumbnailGenTask);
    int i = TroopFileTransferUtil.Log.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("] onTaskDoneInter.  bSuc:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(a());
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", i, ((StringBuilder)localObject).toString());
    localObject = a(paramTroopFileThumbnailGenTask.b(), paramTroopFileThumbnailGenTask.a());
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      i = TroopFileTransferUtil.Log.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] onTaskDoneInter. ");
      localStringBuilder.append(((LinkedList)localObject).size());
      localStringBuilder.append(" same task passive complete. ");
      localStringBuilder.append(a());
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenMgr", i, localStringBuilder.toString());
      paramString = ((LinkedList)localObject).iterator();
      while (paramString.hasNext()) {
        ((TroopFileThumbnailGenTask)paramString.next()).a(paramBoolean, paramInt, paramTroopFileThumbnailGenTask.c());
      }
    }
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailGenTask)localIterator.next()).a();
    }
    this.b.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.c.clear();
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenMgr
 * JD-Core Version:    0.7.0.1
 */