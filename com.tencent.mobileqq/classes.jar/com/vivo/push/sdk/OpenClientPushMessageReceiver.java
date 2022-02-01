package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import java.util.List;

public abstract class OpenClientPushMessageReceiver
  extends BasePushMessageReceiver
{
  public final boolean isAllowNet(Context paramContext)
  {
    return super.isAllowNet(paramContext);
  }
  
  public final void onBind(Context paramContext, int paramInt, String paramString)
  {
    super.onBind(paramContext, paramInt, paramString);
  }
  
  public final void onDelAlias(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public final void onDelTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public final void onListTags(Context paramContext, int paramInt, List<String> paramList, String paramString)
  {
    super.onListTags(paramContext, paramInt, paramList, paramString);
  }
  
  public final void onLog(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    super.onLog(paramContext, paramString, paramInt, paramBoolean);
  }
  
  public final boolean onNotificationMessageArrived(Context paramContext, UPSNotificationMessage paramUPSNotificationMessage)
  {
    return false;
  }
  
  public final void onPublish(Context paramContext, int paramInt, String paramString)
  {
    super.onPublish(paramContext, paramInt, paramString);
  }
  
  public void onReceiveRegId(Context paramContext, String paramString) {}
  
  public final void onSetAlias(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public final void onSetTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public void onTransmissionMessage(Context paramContext, UnvarnishedMessage paramUnvarnishedMessage) {}
  
  public final void onUnBind(Context paramContext, int paramInt, String paramString)
  {
    super.onUnBind(paramContext, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.OpenClientPushMessageReceiver
 * JD-Core Version:    0.7.0.1
 */