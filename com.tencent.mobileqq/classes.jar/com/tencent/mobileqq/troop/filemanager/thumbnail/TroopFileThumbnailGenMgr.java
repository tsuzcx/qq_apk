package com.tencent.mobileqq.troop.filemanager.thumbnail;

import ajmf;
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
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList b = new LinkedList();
  private LinkedList c = new LinkedList();
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " PRS:" + this.c.size() + " RS:" + this.b.size();
  }
  
  public static String a(UUID paramUUID, int paramInt)
  {
    return paramUUID.toString() + "_" + paramInt;
  }
  
  private LinkedList a(String paramString, int paramInt)
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
    if (this.b.size() >= 4) {}
    label179:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label179;
        }
        Object localObject = (String)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (TroopFileThumbnailGenTask)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null) {
          if (a(((TroopFileThumbnailGenTask)localObject).b(), ((TroopFileThumbnailGenTask)localObject).a()))
          {
            TroopFileTransferUtil.Log.b("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "[" + ((TroopFileThumbnailGenTask)localObject).a() + "] has same task gening. add WD task");
            this.c.add(localObject);
            ((TroopFileThumbnailGenTask)localObject).b();
          }
          else
          {
            this.b.add(localObject);
            if (((TroopFileThumbnailGenTask)localObject).a()) {
              break;
            }
            TroopFileTransferUtil.Log.a("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "[" + ((TroopFileThumbnailGenTask)localObject).a() + "] start failed!!");
            this.b.remove(localObject);
          }
        }
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
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
      TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "[" + str + "] genFileThumbnail task exsited. ");
      return -4;
    }
    paramString = TroopFileThumbnailGenTask.a(paramLong, paramItem, paramInt, paramString, this);
    if (paramString == null) {
      return -3;
    }
    TroopFileThumbnailMgr.a(paramItem, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    this.jdField_a_of_type_JavaUtilLinkedList.add(str);
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "[" + str + "] genFileThumbnail filePath:" + paramItem.LocalFile + a());
    d();
    return 0;
  }
  
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    TroopFileTransferMgr.a(new ajmf(this, paramString, paramBoolean, paramInt, paramTroopFileThumbnailGenTask), false);
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
  
  public void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    this.b.remove(paramTroopFileThumbnailGenTask);
    this.c.remove(paramTroopFileThumbnailGenTask);
    TroopFileTransferUtil.Log.c("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "[" + paramString + "] onTaskDoneInter.  bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    LinkedList localLinkedList = a(paramTroopFileThumbnailGenTask.b(), paramTroopFileThumbnailGenTask.a());
    if ((localLinkedList != null) && (localLinkedList.size() > 0))
    {
      TroopFileTransferUtil.Log.b("TroopFileThumbnailGenMgr", TroopFileTransferUtil.Log.a, "[" + paramString + "] onTaskDoneInter. " + localLinkedList.size() + " same task passive complete. " + a());
      paramString = localLinkedList.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenMgr
 * JD-Core Version:    0.7.0.1
 */