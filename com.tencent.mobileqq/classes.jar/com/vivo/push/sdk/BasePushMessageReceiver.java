package com.vivo.push.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.vivo.push.e;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.o;
import com.vivo.push.util.s;
import java.util.List;

public abstract class BasePushMessageReceiver
  extends BroadcastReceiver
  implements PushMessageCallback
{
  public static final String TAG = "PushMessageReceiver";
  
  public boolean isAllowNet(Context paramContext)
  {
    if (paramContext == null)
    {
      o.a("PushMessageReceiver", "isAllowNet sContext is null");
      return false;
    }
    String str = paramContext.getPackageName();
    if (TextUtils.isEmpty(str))
    {
      o.a("PushMessageReceiver", "isAllowNet pkgName is null");
      return false;
    }
    Object localObject = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
    ((Intent)localObject).setPackage(str);
    localObject = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 576);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      return s.a(paramContext, str);
    }
    o.a("PushMessageReceiver", "this is client sdk");
    return true;
  }
  
  public void onBind(Context paramContext, int paramInt, String paramString) {}
  
  public void onDelAlias(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public void onDelTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public void onListTags(Context paramContext, int paramInt, List<String> paramList, String paramString) {}
  
  public void onLog(Context paramContext, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void onPublish(Context paramContext, int paramInt, String paramString) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = ContextDelegate.getContext(paramContext).getApplicationContext();
    e.a().a(paramContext);
    try
    {
      int i = paramIntent.getIntExtra("method", -1);
      String str = paramIntent.getStringExtra("req_id");
      StringBuilder localStringBuilder = new StringBuilder("PushMessageReceiver ");
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(" ; type = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ; requestId = ");
      localStringBuilder.append(str);
      o.d("PushMessageReceiver", localStringBuilder.toString());
      try
      {
        e.a().a(paramIntent, this);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      o.b("PushMessageReceiver", "get method error", paramContext);
    }
  }
  
  public void onSetAlias(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public void onSetTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString) {}
  
  public void onTransmissionMessage(Context paramContext, UnvarnishedMessage paramUnvarnishedMessage) {}
  
  public void onUnBind(Context paramContext, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.sdk.BasePushMessageReceiver
 * JD-Core Version:    0.7.0.1
 */