package com.tencent.mobileqq.winkpublish.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkpublish.model.QCircleResultData;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IPublishLauncher
  extends QRouteApi
{
  public abstract void forwardToMoodSelectLocation(Context paramContext, String paramString, int paramInt, Bundle paramBundle);
  
  public abstract Context getHostContext(Context paramContext);
  
  public abstract ArrayList<QCircleResultData> getResultList(Intent paramIntent);
  
  public abstract void jumpForAECircle(Context paramContext, Intent paramIntent);
  
  public abstract void launchAECameraFromCircle(Context paramContext, Bundle paramBundle);
  
  public abstract void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle);
  
  public abstract void launchAEMutiCameraFromFS(Context paramContext, Bundle paramBundle);
  
  public abstract void launchFSHybirdActivity(Context paramContext, String paramString, Intent paramIntent, int paramInt);
  
  public abstract void launchPublishPage(Context paramContext, Intent paramIntent);
  
  public abstract void launchQCPublishPage(Context paramContext, Intent paramIntent);
  
  public abstract void onAtClick(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onPublishClick(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void startWithPublicFragmentActivityForPeak(Context paramContext, Intent paramIntent);
  
  public abstract void startWithPublicFragmentActivityForPeakForResult(Context paramContext, Intent paramIntent, int paramInt);
  
  public abstract void startWithPublicFragmentActivityForPicPreview(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.IPublishLauncher
 * JD-Core Version:    0.7.0.1
 */