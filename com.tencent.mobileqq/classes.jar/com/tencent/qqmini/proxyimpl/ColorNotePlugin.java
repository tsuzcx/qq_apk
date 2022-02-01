package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.ipc.ColorNoteQIPCModule;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class ColorNotePlugin
  extends BaseJsPlugin
{
  private void a(boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo.isLimitedAccessApp())
    {
      paramRequestEvent.fail();
      return;
    }
    Object localObject;
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() == null) || (!(this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))) {
        break label180;
      }
      localObject = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (!((ColorNoteController)localObject).c())
        {
          if (((ColorNoteController)localObject).b())
          {
            if (paramBoolean)
            {
              AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.3(this, (ColorNoteController)localObject, paramRequestEvent));
              return;
              localObject = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
              if ((localObject instanceof PageGestureProxyImpl)) {
                localObject = ((PageGestureProxyImpl)localObject).a();
              }
            }
            else
            {
              AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.4(this, (ColorNoteController)localObject, paramRequestEvent));
            }
          }
          else {
            AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.5(this, (ColorNoteController)localObject, paramRequestEvent));
          }
        }
        else {
          paramRequestEvent.ok();
        }
      }
      else
      {
        paramRequestEvent.fail();
        return;
      }
      label180:
      localObject = null;
    }
  }
  
  @JsEvent({"addColorSign"})
  public void addColorSign(RequestEvent paramRequestEvent)
  {
    a(false, paramRequestEvent);
  }
  
  @JsEvent({"addColorSignDirectly"})
  public void addColorSignDirectly(RequestEvent paramRequestEvent)
  {
    a(true, paramRequestEvent);
  }
  
  @JsEvent({"addRecentColorSign"})
  public void addRecentColorSign(RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo.isLimitedAccessApp())
    {
      paramRequestEvent.fail();
      return;
    }
    Object localObject3;
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() == null) || (!(this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))) {
        break label389;
      }
      localObject3 = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams).optString("query");
        localObject1 = "miniGamePath" + "?" + (String)localObject1;
        ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).setColorNoteQueryPath((String)localObject1);
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label383;
        }
        if (ColorNoteQIPCModule.a().a()) {
          break label333;
        }
        paramRequestEvent.fail("colorNoteSwitcher is turnOff!");
        return;
      }
      catch (JSONException localJSONException1)
      {
        QLog.e("ColorNotePlugin", 1, "minigame addRecentColorSign get a JSONException:" + localJSONException1.toString());
        localObject2 = "miniGamePath";
        continue;
      }
      PageGestureProxy localPageGestureProxy = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      localObject3 = "";
      Object localObject2 = localObject3;
      try
      {
        Object localObject4 = new JSONObject(paramRequestEvent.jsonParams);
        localObject2 = localObject3;
        localObject3 = ((JSONObject)localObject4).optString("path");
        localObject2 = localObject3;
        localObject4 = ((JSONObject)localObject4).optString("query");
        localObject2 = localObject3;
        localObject3 = (String)localObject3 + "?" + (String)localObject4;
        localObject2 = localObject3;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          QLog.e("ColorNotePlugin", 1, "miniapp addRecentColorSign get a JSONException:" + localJSONException2.toString());
        }
      }
      if ((localPageGestureProxy instanceof PageGestureProxyImpl))
      {
        localObject3 = (PageGestureProxyImpl)localPageGestureProxy;
        ((PageGestureProxyImpl)localObject3).updateColorSignPath((String)localObject2);
        localObject2 = ((PageGestureProxyImpl)localObject3).a();
        continue;
        label333:
        if (!((ColorNoteController)localObject2).c())
        {
          if (((ColorNoteController)localObject2).b())
          {
            AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.1(this, (ColorNoteController)localObject2, paramRequestEvent));
            return;
          }
          AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.2(this, (ColorNoteController)localObject2, paramRequestEvent));
          return;
        }
        paramRequestEvent.fail("This page has been added by qq.addColorSign(), which cannot be added by the qq.recentColorSign() again.");
        return;
        label383:
        paramRequestEvent.fail();
      }
      else
      {
        label389:
        localObject2 = null;
      }
    }
  }
  
  @JsEvent({"isColorSignExistSync"})
  public String isColorSignExistSync(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    Object localObject;
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() == null) || (!(this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))) {
        break label131;
      }
      localObject = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
    }
    for (;;)
    {
      if ((localObject != null) && (((ColorNoteController)localObject).c()))
      {
        return ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
        localObject = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
        if ((localObject instanceof PageGestureProxyImpl)) {
          localObject = ((PageGestureProxyImpl)localObject).a();
        }
      }
      else
      {
        return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
      }
      label131:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin
 * JD-Core Version:    0.7.0.1
 */