package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;

@QAPI(process={"all"})
public abstract interface IQZoneVideoCommonUtilsProxy
  extends QRouteApi
{
  public abstract void forwardToQCircleEdit(Activity paramActivity, Bundle paramBundle);
  
  public abstract QZoneVideoCommonUtils.VideoSupport getTrimHWSupport();
  
  public abstract void gotoRecordPreview(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle);
  
  public abstract void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public abstract void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Intent paramIntent);
  
  public abstract void installVideoActivity(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, String paramString2, String paramString3, Intent paramIntent);
  
  public abstract void installVideoActivityForOther(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy
 * JD-Core Version:    0.7.0.1
 */