package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IQQFileSelector
  extends QRouteApi
{
  public abstract void enterCloudFileBrowser(Activity paramActivity);
  
  public abstract void enterLocalFileBrowserByDevice(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void enterQlinkFromQfav(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void enterQlinkLocalFileBrowser(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void enterQlinkRecentFileBrowser(Activity paramActivity, boolean paramBoolean);
  
  public abstract void fileChooseLaunchForResult(Activity paramActivity, int paramInt1, int paramInt2, ArrayList<String> paramArrayList);
  
  public abstract void free();
  
  public abstract void openFileClear(Activity paramActivity, int paramInt);
  
  public abstract void openFileSelectorByAIO(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public abstract void openFileSelectorByColorNoteHistory(Context paramContext);
  
  public abstract void openFileSelectorByDeviceMsg(Activity paramActivity, int paramInt1, String paramString, int paramInt2, long paramLong);
  
  public abstract void openFileSelectorByDocApiPlugin(Activity paramActivity, String paramString);
  
  public abstract void openFileSelectorByLiteActivity(Activity paramActivity, int paramInt);
  
  public abstract void openFileSelectorByLiteAdvance(Activity paramActivity);
  
  public abstract void openFileSelectorByPrinter(Activity paramActivity, String[] paramArrayOfString, int paramInt);
  
  public abstract void openFileSelectorByPulsPanel(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public abstract void openFileSelectorByQRLogin(Activity paramActivity, String paramString, long paramLong, int paramInt);
  
  public abstract void openFileSelectorByWeiyunBoroadcast(Context paramContext, Bundle paramBundle);
  
  public abstract void openFileSelectorForTroopFileBrowser(Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void openLocalFileBrowserActivity(Context paramContext, String paramString);
  
  public abstract void openMyFile(Activity paramActivity);
  
  public abstract void openMyFileBySchema(Activity paramActivity);
  
  public abstract void startFM(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQQFileSelector
 * JD-Core Version:    0.7.0.1
 */