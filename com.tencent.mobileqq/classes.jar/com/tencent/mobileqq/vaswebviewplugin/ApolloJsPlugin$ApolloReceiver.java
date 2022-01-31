package com.tencent.mobileqq.vaswebviewplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bbac;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class ApolloJsPlugin$ApolloReceiver
  extends BroadcastReceiver
{
  private List<WeakReference<ApolloJsPlugin>> mJsList = new ArrayList();
  
  public void onApolloJsCreated(ApolloJsPlugin paramApolloJsPlugin)
  {
    Object localObject;
    if (this.mJsList.isEmpty())
    {
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("action_apollo_game_event_notify");
      BaseApplicationImpl.getContext().registerReceiver(this, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      QLog.d("ApolloJsPlugin", 2, "onApolloJsCreated mJsList.isEmpty() registerReceiver");
    }
    int i = 0;
    if (i < this.mJsList.size())
    {
      localObject = (ApolloJsPlugin)((WeakReference)this.mJsList.get(i)).get();
      if ((localObject == null) || (((ApolloJsPlugin)localObject).mRuntime == null) || (paramApolloJsPlugin.mRuntime == null) || (((ApolloJsPlugin)localObject).mRuntime.a() != paramApolloJsPlugin.mRuntime.a())) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        this.mJsList.add(new WeakReference(paramApolloJsPlugin));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "onApolloJsCreated add apolloJsPlugin:", paramApolloJsPlugin });
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void onApolloJsDestroy(ApolloJsPlugin paramApolloJsPlugin)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < this.mJsList.size())
    {
      WeakReference localWeakReference = (WeakReference)this.mJsList.get(i);
      ApolloJsPlugin localApolloJsPlugin = (ApolloJsPlugin)localWeakReference.get();
      if (localApolloJsPlugin == null) {
        localArrayList.add(localWeakReference);
      }
      for (;;)
      {
        i += 1;
        break;
        if (localApolloJsPlugin == paramApolloJsPlugin) {
          localArrayList.add(localWeakReference);
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      this.mJsList.removeAll(localArrayList);
    }
    if (this.mJsList.isEmpty()) {}
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this);
      QLog.d("ApolloJsPlugin", 2, "onApolloJsDestroy mJsList.isEmpty() unregisterReceiver");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "onApolloJsDestroy remove apolloJsPlugin:", paramApolloJsPlugin });
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloJsPlugin", 1, "[onDestroy] exception=", localException);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      QLog.e("ApolloJsPlugin", 1, "[onReceive] intent null");
    }
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloJsPlugin", 2, new Object[] { "[onReceive] action=", paramContext });
      }
      if ("action_apollo_game_event_notify".equals(paramContext)) {
        try
        {
          paramIntent = paramIntent.getStringExtra("data");
          paramContext = new JSONObject(paramIntent);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloJsPlugin", 2, new Object[] { "[onReceive] data=", paramIntent });
          }
          if (!this.mJsList.isEmpty())
          {
            paramIntent = new ArrayList();
            int i = this.mJsList.size() - 1;
            while (i >= 0)
            {
              ApolloJsPlugin localApolloJsPlugin = (ApolloJsPlugin)((WeakReference)this.mJsList.get(i)).get();
              if ((localApolloJsPlugin != null) && (localApolloJsPlugin.mRuntime != null))
              {
                CustomWebView localCustomWebView = localApolloJsPlugin.mRuntime.a();
                if ((localCustomWebView != null) && (!paramIntent.contains(localCustomWebView)))
                {
                  localApolloJsPlugin.dispatchJsEvent("apolloGameWebMessage", paramContext, null);
                  paramIntent.add(localCustomWebView);
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloJsPlugin", 2, new Object[] { "jsPlugin.dispatchJsEvent, jsPlugin:", localApolloJsPlugin, "webview:", localCustomWebView });
                  }
                }
              }
              i -= 1;
            }
            if (!"action_apollo_cmshow_content_update".equals(paramContext)) {}
          }
        }
        catch (Exception paramContext)
        {
          QLog.e("ApolloJsPlugin", 1, "[onReceive] exception=", paramContext);
          return;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ApolloJsPlugin", 2, "rscContent_CmShowRscCacheManager onReceive action:" + paramContext);
    }
    paramContext = paramIntent.getStringExtra("key_content_update_zip_name");
    QLog.i("ApolloJsPlugin", 1, "rscContent_CmShowRscCacheManager onReceive zipName:" + paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.ApolloReceiver
 * JD-Core Version:    0.7.0.1
 */