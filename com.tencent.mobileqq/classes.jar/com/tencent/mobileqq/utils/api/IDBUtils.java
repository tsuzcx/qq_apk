package com.tencent.mobileqq.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IDBUtils
  extends QRouteApi
{
  public abstract int getSubAccountVersion(Context paramContext);
  
  public abstract void setShowSubAccountInRecentList(Context paramContext, String paramString, boolean paramBoolean);
  
  public abstract void setSubAccountVersion(Context paramContext);
  
  public abstract boolean showSubAccountInRecentList(Context paramContext, String paramString);
  
  public abstract boolean subAccountOldVersionUpdate(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.IDBUtils
 * JD-Core Version:    0.7.0.1
 */