package com.tencent.qcircle.shadow.core.runtime;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ShadowPendingIntent
{
  public static PendingIntent getActivity(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return getActivity(paramContext, paramInt1, paramIntent, paramInt2, null);
  }
  
  @TargetApi(16)
  public static PendingIntent getActivity(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, Bundle paramBundle)
  {
    Context localContext = paramContext;
    Object localObject = paramIntent;
    if ((paramContext instanceof ShadowContext))
    {
      localContext = paramContext;
      localObject = paramIntent;
      if (paramIntent.getComponent() != null)
      {
        localObject = (ShadowContext)paramContext;
        paramContext = paramIntent;
        if (((ShadowContext)localObject).getPendingIntentConverter() != null) {
          paramContext = ((ShadowContext)localObject).getPendingIntentConverter().convertPluginActivityIntent(paramIntent);
        }
        localContext = ((ShadowContext)localObject).getBaseContext();
        localObject = paramContext;
      }
    }
    return PendingIntent.getActivity(localContext, paramInt1, (Intent)localObject, paramInt2, paramBundle);
  }
  
  public static PendingIntent getService(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return PendingIntent.getService(paramContext, paramInt1, paramIntent, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.ShadowPendingIntent
 * JD-Core Version:    0.7.0.1
 */