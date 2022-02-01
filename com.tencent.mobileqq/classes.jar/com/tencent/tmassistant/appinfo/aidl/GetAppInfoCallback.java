package com.tencent.tmassistant.appinfo.aidl;

import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.List;

public abstract class GetAppInfoCallback
  extends IGetAppInfoCallback.Stub
{
  public abstract void onGetAppInfoResponse(int paramInt1, int paramInt2, List<AppDetail> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback
 * JD-Core Version:    0.7.0.1
 */