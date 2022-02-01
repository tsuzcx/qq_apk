package com.tencent.tmdatasourcesdk;

import android.content.Context;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdatasourcesdk.internal.a.a;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppDetailParam;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantGetAppDetailTool
  implements ITMAssistantExchangeURLListenner
{
  protected static final String TAG = "TMAssistantDownloadSDKExchangeURL";
  protected static TMAssistantGetAppDetailTool mInstance;
  protected a engine = null;
  protected ITMAssistantExchangeURLListenner mListener = null;
  
  private TMAssistantGetAppDetailTool(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner, Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listener = ");
    localStringBuilder.append(paramITMAssistantExchangeURLListenner);
    localStringBuilder.append(",context = ");
    localStringBuilder.append(paramContext);
    ab.c("TMAssistantDownloadSDKExchangeURL", localStringBuilder.toString());
    if ((paramITMAssistantExchangeURLListenner != null) && (paramContext != null))
    {
      this.mListener = paramITMAssistantExchangeURLListenner;
      this.engine = new a(this);
      GlobalUtil.getInstance().setContext(paramContext);
      return;
    }
    ab.e("TMAssistantDownloadSDKExchangeURL", "ITMAssistantExchangeURLListenner listener shouldn't be null!");
  }
  
  public static TMAssistantGetAppDetailTool getInstance(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner, Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantGetAppDetailTool(paramITMAssistantExchangeURLListenner, paramContext);
      }
      paramITMAssistantExchangeURLListenner = mInstance;
      return paramITMAssistantExchangeURLListenner;
    }
    finally {}
  }
  
  public void exchangeUrlsFromPackageNames(ArrayList<String> paramArrayList)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("paramStrs size = ");
    Object localObject1;
    if (paramArrayList == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramArrayList.size());
    }
    ((StringBuilder)localObject2).append(localObject1);
    ab.c("TMAssistantDownloadSDKExchangeURL", ((StringBuilder)localObject2).toString());
    if (paramArrayList != null)
    {
      localObject1 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = ((String)paramArrayList.next()).split(";");
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          AppDetailParam localAppDetailParam = new AppDetailParam();
          localAppDetailParam.packageName = localObject2[0];
          if (localObject2.length > 1) {
            localAppDetailParam.channelId = localObject2[1];
          }
          ((ArrayList)localObject1).add(localAppDetailParam);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramArrayList = this.engine;
        if (paramArrayList != null) {
          paramArrayList.a((ArrayList)localObject1);
        }
      }
    }
    else
    {
      ab.e("TMAssistantDownloadSDKExchangeURL", "packageNames is null!");
    }
  }
  
  public void onExchangedURLSucceed(ArrayList<AppSimpleDetail> paramArrayList, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appDetails size = ");
    if (paramArrayList == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramArrayList.size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(",isSuccess = ");
    localStringBuilder.append(paramBoolean);
    ab.c("TMAssistantDownloadSDKExchangeURL", localStringBuilder.toString());
    Object localObject = this.mListener;
    if (localObject != null)
    {
      ((ITMAssistantExchangeURLListenner)localObject).onExchangedURLSucceed(paramArrayList, paramBoolean);
      return;
    }
    ab.e("TMAssistantDownloadSDKExchangeURL", "mListener is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool
 * JD-Core Version:    0.7.0.1
 */