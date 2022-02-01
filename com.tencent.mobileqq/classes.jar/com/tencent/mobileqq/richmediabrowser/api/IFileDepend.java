package com.tencent.mobileqq.richmediabrowser.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.IFileWifiCheckCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFileDepend
  extends QRouteApi
{
  public abstract boolean checkFileThumbOverSize(int paramInt1, int paramInt2, long paramLong);
  
  public abstract boolean doWithWifiChecked(Context paramContext, boolean paramBoolean, IFileWifiCheckCallback paramIFileWifiCheckCallback);
  
  public abstract void forwardToTargetFriend(Activity paramActivity, Intent paramIntent, boolean paramBoolean, String paramString, int paramInt);
  
  public abstract SparseArray<Object> getDetectCode(Bitmap paramBitmap);
  
  public abstract boolean isVideoFileError(long paramLong);
  
  public abstract void openWithOtherApp(Activity paramActivity, String paramString);
  
  public abstract void saveToAlbum(Context paramContext, String paramString);
  
  public abstract void showFlowDialog(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface);
  
  public abstract void startEditPicActivity(Activity paramActivity, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString, int paramInt3, ForwardFileInfo paramForwardFileInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.IFileDepend
 * JD-Core Version:    0.7.0.1
 */