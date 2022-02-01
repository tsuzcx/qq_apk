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
    if (localObject == null) {
      return;
    }
    long l = ((BusinessUpdateParams)localObject).mBid;
    String str = ((BusinessUpdateParams)localObject).mScid;
    localObject = ((BusinessUpdateParams)localObject).mFrom;
    int i = paramUpdateListenerParams.mErrorCode;
    int j = paramUpdateListenerParams.mHttpCode;
    paramUpdateListenerParams = paramUpdateListenerParams.mErrorMessage;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCompleted bid = ");
    localStringBuilder.append(l);
    localStringBuilder.append(" scid = ");
    localStringBuilder.append(str);
    localStringBuilder.append(" from = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" message = ");
    localStringBuilder.append(paramUpdateListenerParams);
    localStringBuilder.append(" errorCode = ");
    localStringBuilder.append(i);
    localStringBuilder.append(" httpCode = ");
    localStringBuilder.append(j);
    QLog.d("VasUpdate_NativeUpdateBusiness", 1, localStringBuilder.toString());
    paramUpdateListenerParams = UpdateCallbackSelector.getCallback(l);
    if (paramUpdateListenerParams != null) {
      paramUpdateListenerParams.onCompleted(l, str, "", (String)localObject, i, j);
    }
  }
  
  public void deleteFile(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    long l = paramBusinessUpdateParams.mBid;
    paramBusinessUpdateParams = paramBusinessUpdateParams.mScid;
    if (QLog.isColorLevel())
    {
      paramBusinessItemInfo = new StringBuilder();
      paramBusinessItemInfo.append("deleteFiles bid = ");
      paramBusinessItemInfo.append(l);
      paramBusinessItemInfo.append(" scid = ");
      paramBusinessItemInfo.append(paramBusinessUpdateParams);
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, paramBusinessItemInfo.toString());
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
    Object localObject2 = UpdateCallbackSelector.getCallback(paramLong);
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = new BusinessItemInfo();
    ((BusinessItemInfo)localObject1).mIsCanUpdate = ((QuickUpdateBusinessCallback)localObject2).canUpdate(paramLong, paramString, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canUpdate bid = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" scid = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mIsCanUpdate = ");
      localStringBuilder.append(((BusinessItemInfo)localObject1).mIsCanUpdate);
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, localStringBuilder.toString());
    }
    localObject2 = ((QuickUpdateBusinessCallback)localObject2).getItemInfo(paramLong, paramString);
    if (localObject2 != null)
    {
      ((BusinessItemInfo)localObject1).mSavePath = ((TagItemInfo)localObject2).a;
      ((BusinessItemInfo)localObject1).mSaveInDir = ((TagItemInfo)localObject2).b;
      if (TextUtils.isEmpty(((BusinessItemInfo)localObject1).mSavePath))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getBusinessItemInfo doesn't set savePath , bid = ");
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(" , scid = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("VasUpdate_NativeUpdateBusiness", 1, ((StringBuilder)localObject1).toString());
        return null;
      }
      return localObject1;
    }
    return null;
  }
  
  public String getFrom()
  {
    return "NativeUpdateBusiness";
  }
  
  public boolean isFileExist(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    long l = paramBusinessUpdateParams.mBid;
    paramBusinessUpdateParams = paramBusinessUpdateParams.mScid;
    if (QLog.isColorLevel())
    {
      paramBusinessItemInfo = new StringBuilder();
      paramBusinessItemInfo.append("isFileExists bid = ");
      paramBusinessItemInfo.append(l);
      paramBusinessItemInfo.append(" scid = ");
      paramBusinessItemInfo.append(paramBusinessUpdateParams);
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, paramBusinessItemInfo.toString());
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
    if (localObject == null) {
      return;
    }
    long l1 = ((BusinessUpdateParams)localObject).mBid;
    localObject = ((BusinessUpdateParams)localObject).mScid;
    long l2 = paramUpdateListenerParams.mProgress;
    long l3 = paramUpdateListenerParams.mProgressMax;
    if (QLog.isColorLevel())
    {
      paramUpdateListenerParams = new StringBuilder();
      paramUpdateListenerParams.append("onProgress bid = ");
      paramUpdateListenerParams.append(l1);
      paramUpdateListenerParams.append(" scid = ");
      paramUpdateListenerParams.append((String)localObject);
      paramUpdateListenerParams.append(" dwProgress = ");
      paramUpdateListenerParams.append(l2);
      paramUpdateListenerParams.append(" dwProgressMax = ");
      paramUpdateListenerParams.append(l3);
      QLog.d("VasUpdate_NativeUpdateBusiness", 2, paramUpdateListenerParams.toString());
    }
    paramUpdateListenerParams = UpdateCallbackSelector.getCallback(l1);
    if (paramUpdateListenerParams != null) {
      paramUpdateListenerParams.onProgress(l1, (String)localObject, "", l2, l3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.NativeUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */