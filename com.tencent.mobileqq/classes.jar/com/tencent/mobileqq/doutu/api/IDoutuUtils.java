package com.tencent.mobileqq.doutu.api;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import java.io.File;

@QAPI(process={"all"})
public abstract interface IDoutuUtils
  extends QRouteApi
{
  public static final String DOUTU_ANIMA_RES_PATH;
  public static final String DUI_ICONS_RES_PATH = "dui_icon";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("DoutuRes");
    localStringBuilder.append(File.separator);
    DOUTU_ANIMA_RES_PATH = RmVFSUtils.getVFSPath(localStringBuilder.toString());
  }
  
  public abstract void markResDamaged(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.IDoutuUtils
 * JD-Core Version:    0.7.0.1
 */