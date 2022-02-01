package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHuayangOpenHelper
  extends QRouteApi
{
  public abstract void doKillProcess(Context paramContext, String paramString);
  
  public abstract void killProcess(Context paramContext, String paramString);
  
  public abstract void open(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper
 * JD-Core Version:    0.7.0.1
 */