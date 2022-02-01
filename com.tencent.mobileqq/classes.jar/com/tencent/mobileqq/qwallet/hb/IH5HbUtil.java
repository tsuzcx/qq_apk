package com.tencent.mobileqq.qwallet.hb;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IH5HbUtil
  extends QRouteApi
{
  public abstract JSONObject getExtraDataForGrapH5CommonHbResult(AppInterface paramAppInterface, JSONObject paramJSONObject);
  
  public abstract void getGrapH5CommonHbResult(AppInterface paramAppInterface, String paramString, ResultReceiver paramResultReceiver);
  
  public abstract JSONObject getGrapHbResult(int paramInt, Bundle paramBundle, Activity paramActivity);
  
  public abstract void getHbDetailInfo(AppInterface paramAppInterface, JSONObject paramJSONObject, String paramString, ResultReceiver paramResultReceiver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.IH5HbUtil
 * JD-Core Version:    0.7.0.1
 */