package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IFMSettings
  extends QRouteApi
{
  public abstract void free();
  
  public abstract long getDefalutStorgeFreeSpace();
  
  public abstract String getDefaultRecvPath();
  
  public abstract String getDefaultThumbPath();
  
  public abstract String getDefaultTmpPath();
  
  public abstract String getOtherRecvPath();
  
  public abstract void justDoIt(long paramLong, List<String> paramList, Activity paramActivity, FMSettingInterface.MoveFileCallback paramMoveFileCallback);
  
  public abstract void refreshInfos();
  
  public abstract void remove(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFMSettings
 * JD-Core Version:    0.7.0.1
 */