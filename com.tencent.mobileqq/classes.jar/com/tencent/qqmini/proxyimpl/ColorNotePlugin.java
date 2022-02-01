package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.ipc.IColorNoteProcessState;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject2 = null;
    Object localObject1;
    if (this.mIsMiniGame)
    {
      localObject1 = localObject2;
      if (this.mMiniAppContext.getAttachedActivity() != null)
      {
        localObject1 = localObject2;
        if ((this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1)) {
          localObject1 = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
        }
      }
    }
    else
    {
      PageGestureProxy localPageGestureProxy = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      localObject1 = localObject2;
      if ((localPageGestureProxy instanceof PageGestureProxyImpl)) {
        localObject1 = ((PageGestureProxyImpl)localPageGestureProxy).a();
      }
    }
    if (localObject1 != null)
    {
      if (!((IColorNoteController)localObject1).isColorNoteExist())
      {
        if (((IColorNoteController)localObject1).canAddColorNote())
        {
          if (paramBoolean)
          {
            AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.3(this, (IColorNoteController)localObject1, paramRequestEvent));
            return;
          }
          AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.4(this, (IColorNoteController)localObject1, paramRequestEvent));
          return;
        }
        AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.5(this, (IColorNoteController)localObject1, paramRequestEvent));
        return;
      }
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail();
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
    String str = null;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    if (this.mIsMiniGame)
    {
      localObject1 = str;
      if (this.mMiniAppContext.getAttachedActivity() != null)
      {
        localObject1 = str;
        if ((this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))
        {
          localObject2 = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
          localObject1 = "miniGamePath";
          try
          {
            str = new JSONObject(paramRequestEvent.jsonParams).optString("query");
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("miniGamePath");
            ((StringBuilder)localObject4).append("?");
            ((StringBuilder)localObject4).append(str);
            str = ((StringBuilder)localObject4).toString();
            localObject1 = str;
          }
          catch (JSONException localJSONException2)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("minigame addRecentColorSign get a JSONException:");
            ((StringBuilder)localObject4).append(localJSONException2.toString());
            QLog.e("ColorNotePlugin", 1, ((StringBuilder)localObject4).toString());
          }
          ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).setColorNoteQueryPath((String)localObject1);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject4 = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      localObject2 = "";
      localObject1 = localObject2;
      Object localObject3;
      try
      {
        localObject5 = new JSONObject(paramRequestEvent.jsonParams);
        localObject1 = localObject2;
        localObject2 = ((JSONObject)localObject5).optString("path");
        localObject1 = localObject2;
        localObject5 = ((JSONObject)localObject5).optString("query");
        localObject1 = localObject2;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = localObject2;
        localStringBuilder.append((String)localObject2);
        localObject1 = localObject2;
        localStringBuilder.append("?");
        localObject1 = localObject2;
        localStringBuilder.append((String)localObject5);
        localObject1 = localObject2;
        localObject2 = localStringBuilder.toString();
      }
      catch (JSONException localJSONException1)
      {
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("miniapp addRecentColorSign get a JSONException:");
        ((StringBuilder)localObject5).append(localJSONException1.toString());
        QLog.e("ColorNotePlugin", 1, ((StringBuilder)localObject5).toString());
        localObject3 = localObject1;
      }
      localObject1 = localJSONException2;
      if ((localObject4 instanceof PageGestureProxyImpl))
      {
        localObject1 = (PageGestureProxyImpl)localObject4;
        ((PageGestureProxyImpl)localObject1).updateColorSignPath(localObject3);
        localObject1 = ((PageGestureProxyImpl)localObject1).a();
      }
    }
    if (localObject1 != null)
    {
      if (!((IColorNoteProcessState)QRoute.api(IColorNoteProcessState.class)).isRecentColorNoteTurnOn(BaseApplicationImpl.getApplication().getRuntime()))
      {
        paramRequestEvent.fail("colorNoteSwitcher is turnOff!");
        return;
      }
      if (!((IColorNoteController)localObject1).isColorNoteExist())
      {
        if (((IColorNoteController)localObject1).canAddColorNote())
        {
          AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.1(this, (IColorNoteController)localObject1, paramRequestEvent));
          return;
        }
        AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.2(this, (IColorNoteController)localObject1, paramRequestEvent));
        return;
      }
      paramRequestEvent.fail("This page has been added by qq.addColorSign(), which cannot be added by the qq.recentColorSign() again.");
      return;
    }
    paramRequestEvent.fail();
  }
  
  @JsEvent({"isColorSignExistSync"})
  public String isColorSignExistSync(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() != null) && ((this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1)))
      {
        localObject = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
        break label101;
      }
    }
    else
    {
      localObject = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      if ((localObject instanceof PageGestureProxyImpl))
      {
        localObject = ((PageGestureProxyImpl)localObject).a();
        break label101;
      }
    }
    Object localObject = null;
    label101:
    if ((localObject != null) && (((IColorNoteController)localObject).isColorNoteExist())) {
      return ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ColorNotePlugin
 * JD-Core Version:    0.7.0.1
 */