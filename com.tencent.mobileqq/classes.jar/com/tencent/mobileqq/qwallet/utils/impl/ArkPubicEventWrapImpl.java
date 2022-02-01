package com.tencent.mobileqq.qwallet.utils.impl;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.media.AudioManager;
import android.view.View;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qqpay.ui.R.dimen;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArkPubicEventWrapImpl
  extends Observable
  implements IArkPubicEventWrap
{
  public static final String APP_EVENT_CALLBACK_GET_DSL_CONTENT = "gc_ark_get_dsl_content_callback";
  public static final String APP_EVENT_CALLBACK_GET_VIEW_LOCATION = "get_view_location_callback";
  public static final String APP_POST_MUTE = "ad_query_mute_callback";
  public static final String APP_POST_PACKAGE = "event_query_package_callback";
  public static final String ARK_BEACON_REPORT = "beacon_report";
  public static final String ARK_FULL_SCREEN_PLAY = "event_fullscreen_play";
  public static final String ARK_GET_DSL_CONTENT = "gc_ark_get_dsl_content";
  public static final String ARK_GET_VIEW_LOCATION = "get_view_location";
  public static final String ARK_OPEN_HIPPY = "gc_ark_open_hippy";
  public static final String ARK_QUERY_MUTE = "ad_query_mute";
  public static final String ARK_QUERY_PACKAGE = "event_query_package";
  public static final String ARK_REVERSE_FEEDBACK = "gc_ark_msg_delete";
  private static final String TAG = "ArkPubicEventWrap";
  private static ArkPubicEventWrapImpl.VolumeReceiver receiver;
  private List<String> volumnArkAppNameList = new ArrayList();
  
  private void callbackMuteStatus(String paramString)
  {
    try
    {
      if (((AudioManager)MobileQQ.getContext().getApplicationContext().getSystemService("audio")).getRingerMode() == 2) {
        break label140;
      }
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        StringBuilder localStringBuilder;
        continue;
        label140:
        boolean bool = false;
      }
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("is_muted", bool);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ad_query_mute: ");
      localStringBuilder.append(localJSONObject.toString());
      QLog.i("ArkPubicEventWrap", 2, localStringBuilder.toString());
    }
    ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject.toString(), "json");
    return;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("is_muted", false);
      ark.arkNotify(paramString, "ad_query_mute_callback", localJSONObject.toString(), "json");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
  }
  
  public static Rect getVisibilityRect(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    return localRect;
  }
  
  private void notifyViewLocation(String paramString1, String paramString2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      if (StringUtil.isEmpty(paramString2)) {
        return;
      }
      localObject1 = QBaseActivity.sTopActivity;
      localObject2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).getChatXListViewFromChatFragment((QBaseActivity)localObject1);
      if (localObject2 == null) {
        break label573;
      }
      localJSONArray = new JSONArray();
      localJSONObject1.put("results", localJSONArray);
      f1 = DisplayUtil.b((Context)localObject1, ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ));
      f2 = ((QBaseActivity)localObject1).getResources().getDimension(R.dimen.b);
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("width", DisplayUtil.b((Context)localObject1, ImmersiveUtils.getScreenWidth()));
      ((JSONObject)localObject3).put("height", DisplayUtil.b((Context)localObject1, f1 + f2));
      ((JSONObject)localObject3).put("x", 0);
      ((JSONObject)localObject3).put("y", 0);
      localJSONObject1.put("navigationBarRect", localObject3);
      localObject1 = new JSONObject(paramString2).optJSONArray("arkViewIDs");
      i = 0;
      paramString2 = (String)localObject2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        JSONArray localJSONArray;
        float f1;
        float f2;
        Object localObject3;
        int i;
        Object localObject4;
        JSONObject localJSONObject2;
        float f3;
        label573:
        continue;
        i += 1;
      }
    }
    if (i < ((JSONArray)localObject1).length())
    {
      localObject3 = ((JSONArray)localObject1).optString(i);
      localObject4 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ArkAioContainerWrapper$getMessageByMID((String)localObject3);
      if (localObject4 != null)
      {
        localJSONObject2 = new JSONObject();
        localJSONArray.put(localJSONObject2);
        localObject2 = new JSONObject();
        localJSONObject2.put("viewID", localObject3);
        localJSONObject2.put("rect", localObject2);
        localObject3 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).UIViewUtils$getViewByPosition(paramString2, (ChatMessage)localObject4);
        if (localObject3 != null)
        {
          localObject3 = ((View)localObject3).findViewById(R.id.g);
          if (localObject3 != null)
          {
            localObject4 = getVisibilityRect((View)localObject3);
            if (localObject4 != null)
            {
              f1 = DisplayUtil.b(((View)localObject3).getContext(), ((Rect)localObject4).top);
              f3 = DisplayUtil.b(((View)localObject3).getContext(), ((Rect)localObject4).bottom);
              f2 = DisplayUtil.b(((View)localObject3).getContext(), ((View)localObject3).getMeasuredHeight());
              if (f3 <= f2) {
                f1 = f3 - f2;
              }
              ((JSONObject)localObject2).put("x", DisplayUtil.b(((View)localObject3).getContext(), ((Rect)localObject4).left));
              ((JSONObject)localObject2).put("y", f1);
              ((JSONObject)localObject2).put("width", DisplayUtil.b(((View)localObject3).getContext(), ((Rect)localObject4).width()));
              ((JSONObject)localObject2).put("height", f2);
            }
            else
            {
              ((JSONObject)localObject2).put("x", 0);
              ((JSONObject)localObject2).put("y", 0);
              ((JSONObject)localObject2).put("width", 0);
              ((JSONObject)localObject2).put("height", 0);
            }
          }
          else
          {
            ((JSONObject)localObject2).put("x", 0);
            ((JSONObject)localObject2).put("y", 0);
            ((JSONObject)localObject2).put("width", 0);
            ((JSONObject)localObject2).put("height", 0);
          }
        }
        else
        {
          ((JSONObject)localObject2).put("x", 0);
          ((JSONObject)localObject2).put("y", 0);
          ((JSONObject)localObject2).put("width", 0);
          ((JSONObject)localObject2).put("height", 0);
          break label621;
          ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
        }
      }
    }
    else
    {
      ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
      return;
      ark.arkNotify(paramString1, "get_view_location_callback", localJSONObject1.toString(), "json");
      return;
    }
  }
  
  public void addNotify(String paramString)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification(paramString, ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).newQWalletArkNotifyTemp(new ArkPubicEventWrapImpl.1(this)));
  }
  
  public void callbackMuteStatus()
  {
    try
    {
      if (((AudioManager)MobileQQ.getContext().getApplicationContext().getSystemService("audio")).getRingerMode() == 2) {
        break label194;
      }
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Object localObject;
        continue;
        label194:
        boolean bool = false;
      }
    }
    localJSONObject = new JSONObject();
    localJSONObject.put("is_muted", bool);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ad_query_mute: ");
      ((StringBuilder)localObject).append(localJSONObject.toString());
      QLog.i("ArkPubicEventWrap", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.volumnArkAppNameList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ark.arkNotify((String)((Iterator)localObject).next(), "ad_query_mute_callback", localJSONObject.toString(), "json");
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("is_muted", false);
      localObject = this.volumnArkAppNameList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ark.arkNotify((String)((Iterator)localObject).next(), "ad_query_mute_callback", localJSONObject.toString(), "json");
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void registVolumnReceiver(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.volumnArkAppNameList.addAll(paramList);
      if (receiver == null) {
        receiver = new ArkPubicEventWrapImpl.VolumeReceiver(null);
      }
      paramList = new IntentFilter();
      paramList.addAction("android.media.VOLUME_CHANGED_ACTION");
      paramList.addAction("android.intent.action.HEADSET_PLUG");
      paramList.addAction("android.media.AUDIO_BECOMING_NOISY");
      paramList.addAction("android.media.RINGER_MODE_CHANGED");
      MobileQQ.getContext().getBaseContext().registerReceiver(receiver, paramList);
    }
  }
  
  public void registVolumnReceiver(String... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.volumnArkAppNameList.add(str);
        i += 1;
      }
      if (receiver == null) {
        receiver = new ArkPubicEventWrapImpl.VolumeReceiver(null);
      }
      paramVarArgs = new IntentFilter();
      paramVarArgs.addAction("android.media.VOLUME_CHANGED_ACTION");
      paramVarArgs.addAction("android.intent.action.HEADSET_PLUG");
      paramVarArgs.addAction("android.media.AUDIO_BECOMING_NOISY");
      paramVarArgs.addAction("android.media.RINGER_MODE_CHANGED");
      MobileQQ.getContext().getBaseContext().registerReceiver(receiver, paramVarArgs);
    }
  }
  
  public void removeNotify(String paramString)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerAppNotification(paramString, null);
  }
  
  public void unRegistVolumnReceiver(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.volumnArkAppNameList.removeAll(paramList);
      if (receiver != null)
      {
        MobileQQ.getContext().getBaseContext().unregisterReceiver(receiver);
        receiver = null;
      }
    }
  }
  
  public void unRegistVolumnReceiver(String... paramVarArgs)
  {
    if (paramVarArgs.length > 0)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.volumnArkAppNameList.remove(str);
        i += 1;
      }
    }
    if (receiver != null)
    {
      MobileQQ.getContext().getBaseContext().unregisterReceiver(receiver);
      receiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.ArkPubicEventWrapImpl
 * JD-Core Version:    0.7.0.1
 */