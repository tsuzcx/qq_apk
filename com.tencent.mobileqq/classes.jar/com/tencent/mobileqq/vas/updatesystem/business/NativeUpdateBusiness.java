package com.tencent.mobileqq.vas.updatesystem.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.quickupdate.UpdateCallbackSelector;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback;
import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;

public class NativeUpdateBusiness
  extends BaseUpdateBusiness
{
  private void a(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = paramUpdateListenerParams.mBusinessUpdateParams;
    if (localObject == null) {}
    long l;
    String str;
    int i;
    int j;
    do
    {
      return;
      l = ((BusinessUpdateParams)localObject).mBid;
      str = ((BusinessUpdateParams)localObject).mScid;
      localObject = ((BusinessUpdateParams)localObject).mFrom;
      i = paramUpdateListenerParams.mErrorCode;
      j = paramUpdateListenerParams.mHttpCode;
      paramUpdateListenerParams = paramUpdateListenerParams.mErrorMessage;
      QLog.d("VasUpdate_NativeUpdateBusiness", 1, "onCompleted bid = " + l + " scid = " + str + " from = " + (String)localObject + " message = " + paramUpdateListenerParams + " errorCode = " + i + " httpCode = " + j);
      paramUpdateListenerParams = UpdateCallbackSelector.getCallback(l);
    } while (paramUpdateListenerParams == null);
    paramUpdateListenerParams.onCompleted(l, str, "", (String)localObject, i, j);
  }
  
  public void deleteFile(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    long l = paramBusinessUpdateParams.mBid;
    paramBusinessUpdateParams = paramBusinessUpdateParams.mScid;
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, "deleteFiles bid = " + l + " scid = " + paramBusinessUpdateParams);
    }
    paramBusinessItemInfo = UpdateCallbackSelector.getCallback(l);
    if (paramBusinessItemInfo != null) {
      paramBusinessItemInfo.deleteFiles(l, paramBusinessUpdateParams);
    }
  }
  
  public long getBid()
  {
    return 0L;
  }
  
  public BusinessItemInfo getBusinessItemInfo(long paramLong, String paramString)
  {
    Object localObject = UpdateCallbackSelector.getCallback(paramLong);
    if (localObject == null) {}
    BusinessItemInfo localBusinessItemInfo;
    do
    {
      return null;
      localBusinessItemInfo = new BusinessItemInfo();
      localBusinessItemInfo.mIsCanUpdate = ((QuickUpdateBusinessCallback)localObject).canUpdate(paramLong, paramString, "");
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_NativeUpdateBusiness", 2, "canUpdate bid = " + paramLong + " scid = " + paramString + " mIsCanUpdate = " + localBusinessItemInfo.mIsCanUpdate);
      }
      localObject = ((QuickUpdateBusinessCallback)localObject).getItemInfo(paramLong, paramString);
    } while (localObject == null);
    localBusinessItemInfo.mSavePath = ((TagItemInfo)localObject).a;
    localBusinessItemInfo.mSaveInDir = ((TagItemInfo)localObject).b;
    if (TextUtils.isEmpty(localBusinessItemInfo.mSavePath))
    {
      QLog.e("VasUpdate_NativeUpdateBusiness", 1, "getBusinessItemInfo doesn't set savePath , bid = " + paramLong + " , scid = " + paramString);
      return null;
    }
    return localBusinessItemInfo;
  }
  
  public String getFrom()
  {
    return "NativeUpdateBusiness";
  }
  
  public boolean isFileExist(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    long l = paramBusinessUpdateParams.mBid;
    paramBusinessUpdateParams = paramBusinessUpdateParams.mScid;
    if (QLog.isColorLevel()) {
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, "isFileExists bid = " + l + " scid = " + paramBusinessUpdateParams);
    }
    paramBusinessItemInfo = UpdateCallbackSelector.getCallback(l);
    return (paramBusinessItemInfo != null) && (paramBusinessItemInfo.isFileExists(l, paramBusinessUpdateParams));
  }
  
  public void onLoadFail(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    super.onLoadFail(paramUpdateListenerParams);
    a(paramUpdateListenerParams);
  }
  
  public void onLoadSuccess(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    super.onLoadSuccess(paramUpdateListenerParams);
    a(paramUpdateListenerParams);
  }
  
  public void onProgress(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    super.onProgress(paramUpdateListenerParams);
    Object localObject = paramUpdateListenerParams.mBusinessUpdateParams;
    if (localObject == null) {}
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      l1 = ((BusinessUpdateParams)localObject).mBid;
      localObject = ((BusinessUpdateParams)localObject).mScid;
      l2 = paramUpdateListenerParams.mProgress;
      l3 = paramUpdateListenerParams.mProgressMax;
      if (QLog.isColorLevel()) {
        QLog.d("VasUpdate_NativeUpdateBusiness", 2, "onProgress bid = " + l1 + " scid = " + (String)localObject + " dwProgress = " + l2 + " dwProgressMax = " + l3);
      }
      paramUpdateListenerParams = UpdateCallbackSelector.getCallback(l1);
    } while (paramUpdateListenerParams == null);
    paramUpdateListenerParams.onProgress(l1, (String)localObject, "", l2, l3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.NativeUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */