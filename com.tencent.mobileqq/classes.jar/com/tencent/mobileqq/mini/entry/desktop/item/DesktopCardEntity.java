package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import android.util.Log;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class DesktopCardEntity
  extends Entity
{
  public static final String TAG = "MiniAppCardEntity";
  @unique
  public String cardId;
  public byte[] data;
  public int moduleType;
  public String title;
  
  public DesktopCardEntity() {}
  
  public DesktopCardEntity(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.moduleType = paramStModuleInfo.moduleType.get();
    this.title = paramStModuleInfo.title.get();
    this.data = ((INTERFACE.StModuleInfo)paramStModuleInfo.get()).toByteArray();
    paramStModuleInfo = new StringBuilder();
    paramStModuleInfo.append(this.moduleType);
    paramStModuleInfo.append("_");
    paramStModuleInfo.append(this.title);
    this.cardId = paramStModuleInfo.toString();
  }
  
  public INTERFACE.StModuleInfo createStModuleInfo()
  {
    if (this.data != null)
    {
      INTERFACE.StModuleInfo localStModuleInfo = new INTERFACE.StModuleInfo();
      try
      {
        localStModuleInfo.mergeFrom(this.data);
        return localStModuleInfo;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createStmoduleInfo, exception: ");
        localStringBuilder.append(Log.getStackTraceString(localException));
        QLog.e("MiniAppCardEntity", 1, localStringBuilder.toString());
        return null;
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("moduleType: ");
    localStringBuilder.append(this.moduleType);
    localStringBuilder.append(", title: ");
    localStringBuilder.append(this.title);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopCardEntity
 * JD-Core Version:    0.7.0.1
 */