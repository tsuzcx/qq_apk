package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import android.util.Log;
import atmo;
import atoc;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

public class DesktopCardEntity
  extends atmo
{
  public static final String TAG = "MiniAppCardEntity";
  public byte[] data;
  @atoc
  public int moduleType;
  public String title;
  
  public DesktopCardEntity() {}
  
  public DesktopCardEntity(INTERFACE.StModuleInfo paramStModuleInfo)
  {
    this.moduleType = paramStModuleInfo.moduleType.get();
    this.title = paramStModuleInfo.title.get();
    this.data = ((INTERFACE.StModuleInfo)paramStModuleInfo.get()).toByteArray();
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
        QLog.e("MiniAppCardEntity", 1, "createStmoduleInfo, exception: " + Log.getStackTraceString(localException));
        return null;
      }
    }
    return null;
  }
  
  public String toString()
  {
    return "moduleType: " + this.moduleType + ", title: " + this.title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopCardEntity
 * JD-Core Version:    0.7.0.1
 */