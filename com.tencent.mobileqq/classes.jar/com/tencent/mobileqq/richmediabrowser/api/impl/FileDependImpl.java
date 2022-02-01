package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IFileWifiCheckCallback;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.utils.ForwardUtils;

public class FileDependImpl
  implements IFileDepend
{
  public boolean checkFileThumbOverSize(int paramInt1, int paramInt2, long paramLong)
  {
    return QFileUtils.a(paramInt1, paramInt2, paramLong);
  }
  
  public boolean doWithWifiChecked(Context paramContext, boolean paramBoolean, IFileWifiCheckCallback paramIFileWifiCheckCallback)
  {
    return QFileUtils.a(paramContext, paramBoolean, paramIFileWifiCheckCallback);
  }
  
  public void forwardToTargetFriend(Activity paramActivity, Intent paramIntent, boolean paramBoolean, String paramString, int paramInt)
  {
    ForwardUtils.a(paramActivity, paramIntent, paramBoolean, paramString, paramInt);
  }
  
  public Pair<Object, Object> getDetectCode(Bitmap paramBitmap)
  {
    SparseArray localSparseArray = new SparseArray(2);
    int i = ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).decodeQQCodeFromBmp(paramBitmap, 3, localSparseArray);
    boolean bool = QRUtils.a(i);
    Object localObject = null;
    if (bool) {
      paramBitmap = localSparseArray.get(1);
    } else {
      paramBitmap = null;
    }
    if (QRUtils.b(i)) {
      localObject = localSparseArray.get(2);
    }
    return new Pair(paramBitmap, localObject);
  }
  
  public boolean isVideoFileError(long paramLong)
  {
    return paramLong == -134L;
  }
  
  public void openWithOtherApp(Activity paramActivity, String paramString)
  {
    FileManagerUtil.a(paramActivity, paramString);
  }
  
  public void saveToAlbum(Context paramContext, String paramString)
  {
    FileManagerUtil.a(paramContext, paramString);
  }
  
  public void showFlowDialog(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    FileManagerUtil.a(paramBoolean, paramContext, paramFMDialogInterface);
  }
  
  public void startEditPicActivity(Activity paramActivity, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString, int paramInt3, ForwardFileInfo paramForwardFileInfo)
  {
    paramString = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(paramActivity, paramString, true, true, true, true, true, 2, paramInt1, 7);
    paramString.putExtra("uintype", ParamsManager.a().a());
    paramString.putExtra("open_chatfragment", true);
    paramString.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
    paramString.putExtra("key_enable_edit_title_bar", true);
    if (paramBoolean1) {
      paramString.putExtra("key_help_forward_pic", paramBoolean1);
    }
    if (paramBoolean2) {
      paramString.putExtra("key_allow_multiple_forward_from_limit", false);
    }
    if (paramForwardFileInfo != null) {
      paramString.putExtra("fileinfo", paramForwardFileInfo);
    }
    paramString.putExtra("not_forward", true);
    if (paramInt2 != 0)
    {
      paramActivity.startActivityForResult(paramString, paramInt2);
      return;
    }
    paramActivity.startActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.api.impl.FileDependImpl
 * JD-Core Version:    0.7.0.1
 */