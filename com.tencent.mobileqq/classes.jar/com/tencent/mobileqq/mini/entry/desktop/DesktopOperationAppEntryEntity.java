package com.tencent.mobileqq.mini.entry.desktop;

import NS_MINI_INTERFACE.INTERFACE.StOperationApp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class DesktopOperationAppEntryEntity
  extends Entity
{
  public static final String TAG = "DesktopOperationAppEntryEntity";
  public byte[] data;
  @unique
  public String name;
  
  public DesktopOperationAppEntryEntity(INTERFACE.StOperationApp paramStOperationApp)
  {
    this.name = paramStOperationApp.name.get();
    this.data = ((INTERFACE.StOperationApp)paramStOperationApp.get()).toByteArray();
  }
  
  public DesktopOperationAppEntryEntity(String paramString)
  {
    this.name = paramString;
  }
  
  public INTERFACE.StOperationApp createStOperationApp()
  {
    if (this.data == null) {
      return null;
    }
    try
    {
      INTERFACE.StOperationApp localStOperationApp = new INTERFACE.StOperationApp();
      localStOperationApp.mergeFrom(this.data);
      return localStOperationApp;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      QLog.e("DesktopOperationAppEntryEntity", 1, "createStOperationApp, error! ", localInvalidProtocolBufferMicroException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.DesktopOperationAppEntryEntity
 * JD-Core Version:    0.7.0.1
 */