package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;

public abstract interface PushMessageCallback
{
  public abstract boolean isAllowNet(Context paramContext);
  
  public abstract void onBind(Context paramContext, int paramInt, String paramString);
  
  public abstract void onDelAlias(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString);
  
  public abstract void onDelTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString);
  
  public abstract void onListTags(Context paramContext, int paramInt, List<String> paramList, String paramString);
  
  public abstract void onLog(Context paramContext, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract boolean onNotificationMessageArrived(Context paramContext, UPSNotificationMessage paramUPSNotificationMessage);
  
  public abstract void onPublish(Context paramContext, int paramInt, String paramString);
  
  public abstract void onReceiveRegId(Context paramContext, String paramString);
  
  public abstract void onSetAlias(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString);
  
  public abstract void onSetTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString);
  
  public abstract void onTransmissionMessage(Context paramContext, UnvarnishedMessage paramUnvarnishedMessage);
  
  public abstract void onUnBind(Context paramContext, int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.PushMessageCallback
 * JD-Core Version:    0.7.0.1
 */