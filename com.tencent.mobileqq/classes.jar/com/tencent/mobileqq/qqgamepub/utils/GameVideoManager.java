package com.tencent.mobileqq.qqgamepub.utils;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.QGameBusEvent;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.web.view.QQGamePubWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap;
import com.tencent.mobileqq.qwallet.utils.IArkPubicEventWrap.ArkEvent;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class GameVideoManager
  extends Observable
  implements Handler.Callback, SimpleEventReceiver, Observer
{
  public static GameVideoManager a;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(this);
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<GameArkView> jdField_a_of_type_MqqUtilWeakReference;
  private WeakReference<QQGamePubWebView> b;
  private WeakReference<HippyEngine> c;
  
  public static GameVideoManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGameVideoManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGameVideoManager == null) {
          jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGameVideoManager = new GameVideoManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGameVideoManager;
  }
  
  public static void b(int paramInt)
  {
    GamePubAccountHelper.a(paramInt);
  }
  
  private void g()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      b();
      return;
    }
    if (i == 2)
    {
      c();
      return;
    }
    if (i == 2)
    {
      d();
      return;
    }
    QLog.e("QQGamePub_GameVideoManager", 2, "qgame_pub type no set");
  }
  
  private void h()
  {
    QLog.d("QQGamePub_GameVideoManager", 4, "------>resumeFeedVideo");
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--->stopArkVideo viewId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.d("QQGamePub_GameVideoManager", 4, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null)
    {
      localObject = (GameArkView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
        if ((((GameArkView)localObject).a()) && (GamePubAccountHelper.a(((GameArkView)localObject).a()))) {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("viewId", this.jdField_a_of_type_JavaLangString);
            ark.arkNotify("com.tencent.gamecenter.newvideo", "notift_ark_video_stop", ((JSONObject)localObject).toString(), "json");
            return;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    SimpleEventBus.getInstance().registerReceiver(this);
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addNotify("com.tencent.gamecenter.newvideo");
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).addObserver(this);
  }
  
  public void a(GameArkView paramGameArkView)
  {
    if (paramGameArkView != null)
    {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramGameArkView);
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(QQGamePubWebView paramQQGamePubWebView)
  {
    if (paramQQGamePubWebView != null) {
      this.b = new WeakReference(paramQQGamePubWebView);
    }
  }
  
  public void b()
  {
    ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).stopVideo();
  }
  
  public void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (QQGamePubWebView)((WeakReference)localObject).get();
      ((QQGamePubWebView)localObject).getPluginEngine().a(((QQGamePubWebView)localObject).getUrl(), 8589934625L, null);
    }
  }
  
  public void d()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference != null) {
      ((EventDispatcher)((HippyEngine)localWeakReference.get()).getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onGameFeedsPause", null);
    }
  }
  
  public void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--->playArkVideo viewId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.d("QQGamePub_GameVideoManager", 4, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null)
    {
      localObject = (GameArkView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          return;
        }
        if ((((GameArkView)localObject).a()) && (GamePubAccountHelper.a(((GameArkView)localObject).a()))) {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("viewId", this.jdField_a_of_type_JavaLangString);
            ark.arkNotify("com.tencent.gamecenter.newvideo", "notift_ark_video_play", ((JSONObject)localObject).toString(), "json");
            return;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void f()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).removeNotify("com.tencent.gamecenter.newvideo");
    ((IArkPubicEventWrap)QRoute.api(IArkPubicEventWrap.class)).deleteObserver(this);
    this.b = null;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.c = null;
    jdField_a_of_type_ComTencentMobileqqQqgamepubUtilsGameVideoManager = null;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QGameBusEvent.class);
    return localArrayList;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QGameBusEvent))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveEvent() called with: event = [");
      paramSimpleBaseEvent = (QGameBusEvent)paramSimpleBaseEvent;
      localStringBuilder.append(paramSimpleBaseEvent.eventType);
      localStringBuilder.append("]");
      QLog.d("QQGamePub_GameVideoManager", 4, localStringBuilder.toString());
      switch (paramSimpleBaseEvent.eventType)
      {
      default: 
        return;
      case 4: 
        g();
        return;
      case 3: 
        h();
        return;
      case 2: 
      case 6: 
        a();
        return;
      }
      e();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof IArkPubicEventWrap.ArkEvent))
      {
        paramObservable = ((IArkPubicEventWrap.ArkEvent)paramObject).jdField_a_of_type_JavaLangString;
        Object localObject = ((IArkPubicEventWrap.ArkEvent)paramObject).b;
        paramObject = ((IArkPubicEventWrap.ArkEvent)paramObject).c;
        if ((!TextUtils.isEmpty(paramObservable)) && ("com.tencent.gamecenter.newvideo".equals(paramObservable)))
        {
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return;
          }
          if (("gc_ark_video_play".equals(localObject)) && (!TextUtils.isEmpty(paramObject)))
          {
            paramObject = new JSONObject(paramObject);
            paramObservable = paramObject.optString("videoUrl", "");
            paramObject = paramObject.optString("viewId", "");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("update videoUrl: ");
            ((StringBuilder)localObject).append(paramObservable);
            QLog.d("QQGamePub_GameVideoManager", 2, ((StringBuilder)localObject).toString());
            paramObservable = new StringBuilder();
            paramObservable.append("update viewId: ");
            paramObservable.append(paramObject);
            QLog.d("QQGamePub_GameVideoManager", 2, paramObservable.toString());
            this.jdField_a_of_type_JavaLangString = paramObject;
            g();
            return;
          }
        }
      }
    }
    catch (Throwable paramObservable)
    {
      paramObservable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GameVideoManager
 * JD-Core Version:    0.7.0.1
 */