package com.tencent.mobileqq.filemanager.uftwrapper;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class QFileTroopTransferWrapper
{
  private final QQAppInterface a;
  private final Map<UUID, QFileTroopTransferWrapper.TroopBaseUploadWrapper> b = new HashMap();
  private QFileTroopTransferWrapper.ITransferWrapperCallback c = new QFileTroopTransferWrapper.1(this);
  
  public QFileTroopTransferWrapper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(UUID paramUUID, QFileTroopTransferWrapper.TroopBaseUploadWrapper paramTroopBaseUploadWrapper)
  {
    try
    {
      this.b.put(paramUUID, paramTroopBaseUploadWrapper);
      return;
    }
    finally {}
  }
  
  private QFileTroopTransferWrapper.TroopBaseUploadWrapper b(UUID paramUUID)
  {
    try
    {
      paramUUID = (QFileTroopTransferWrapper.TroopBaseUploadWrapper)this.b.remove(paramUUID);
      return paramUUID;
    }
    finally {}
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    paramBundle = new QFileTroopTransferWrapper.TroopUploadWrapper(this.a, paramLong, paramItem, paramBundle, this.c);
    a(paramItem.Id, paramBundle);
    paramBundle.c();
    return 0;
  }
  
  public UUID a(long paramLong, String paramString, QFileTroopTransferWrapper.ITroopMultiFwdCallback paramITroopMultiFwdCallback)
  {
    UUID localUUID = UUID.randomUUID();
    paramString = new QFileTroopTransferWrapper.TroopMultiFwdUploadWrapper(this.a, localUUID, paramLong, paramString, this.c, paramITroopMultiFwdCallback);
    a(localUUID, paramString);
    paramString.c();
    return localUUID;
  }
  
  public void a()
  {
    Object localObject1 = new HashMap();
    try
    {
      ((Map)localObject1).putAll(this.b);
      this.b.clear();
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((QFileTroopTransferWrapper.TroopBaseUploadWrapper)((Iterator)localObject1).next()).a(3);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean a(UUID paramUUID)
  {
    paramUUID = b(paramUUID);
    if (paramUUID != null)
    {
      paramUUID.a(0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper
 * JD-Core Version:    0.7.0.1
 */