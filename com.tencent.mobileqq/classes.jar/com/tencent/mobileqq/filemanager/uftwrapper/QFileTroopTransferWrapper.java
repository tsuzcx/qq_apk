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
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QFileTroopTransferWrapper.ITransferWrapperCallback jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITransferWrapperCallback = new QFileTroopTransferWrapper.1(this);
  private final Map<UUID, QFileTroopTransferWrapper.TroopBaseUploadWrapper> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public QFileTroopTransferWrapper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private QFileTroopTransferWrapper.TroopBaseUploadWrapper a(UUID paramUUID)
  {
    try
    {
      paramUUID = (QFileTroopTransferWrapper.TroopBaseUploadWrapper)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
      return paramUUID;
    }
    finally {}
  }
  
  private void a(UUID paramUUID, QFileTroopTransferWrapper.TroopBaseUploadWrapper paramTroopBaseUploadWrapper)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramUUID, paramTroopBaseUploadWrapper);
      return;
    }
    finally {}
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    paramBundle = new QFileTroopTransferWrapper.TroopUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramItem, paramBundle, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITransferWrapperCallback);
    a(paramItem.Id, paramBundle);
    paramBundle.a();
    return 0;
  }
  
  public UUID a(long paramLong, String paramString, QFileTroopTransferWrapper.ITroopMultiFwdCallback paramITroopMultiFwdCallback)
  {
    UUID localUUID = UUID.randomUUID();
    paramString = new QFileTroopTransferWrapper.TroopMultiFwdUploadWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localUUID, paramLong, paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerUftwrapperQFileTroopTransferWrapper$ITransferWrapperCallback, paramITroopMultiFwdCallback);
    a(localUUID, paramString);
    paramString.a();
    return localUUID;
  }
  
  public void a()
  {
    Object localObject1 = new HashMap();
    try
    {
      ((Map)localObject1).putAll(this.jdField_a_of_type_JavaUtilMap);
      this.jdField_a_of_type_JavaUtilMap.clear();
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
    paramUUID = a(paramUUID);
    if (paramUUID != null)
    {
      paramUUID.a(0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper
 * JD-Core Version:    0.7.0.1
 */