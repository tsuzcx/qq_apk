package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.core.page.widget.MiniAppTextArea;
import com.tencent.qqmini.miniapp.core.page.widget.WebInputHandler;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.miniapp.widget.CanvasView.DrawActionCommand;
import com.tencent.qqmini.miniapp.widget.CoverCameraView;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener;
import com.tencent.qqmini.sdk.widget.NavigationBar;
import com.tencent.qqmini.sdk.widget.media.CoverVideoView;
import com.tencent.smtt.sdk.CookieManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeViewContainer
  extends FrameLayout
{
  private static final String CONFIG_SPLIT = ",";
  private static final String TAG = "NativeViewContainer";
  private static String mCurWhiteListConfig;
  private static String mWhiteHostConfig;
  private static ArrayList<String> needCookieAppIdList;
  private static ArrayList<String> needCookieHostList;
  private SparseArray<MiniAppTextArea> appTextAreaSparseArray = new SparseArray();
  protected float density;
  private InnerWebView innerWebView;
  private View keyBoardConfirmView;
  private long lastShowInputTime = 0L;
  private final List<NativeViewContainer.IConfirmListerner> mConfirmListeners = new ArrayList();
  private SparseArray<CoverView> mCoverViewSparseArray = new SparseArray();
  private int mCurInput = -1;
  private WebInputHandler mInputHandler;
  private IMiniAppContext mMiniAppContext;
  private PageWebviewContainer mWebviewContainer;
  
  @Deprecated
  public NativeViewContainer(IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
  }
  
  public NativeViewContainer(IMiniAppContext paramIMiniAppContext, PageWebviewContainer paramPageWebviewContainer)
  {
    super(paramIMiniAppContext.getContext());
    this.density = DisplayUtil.getDensity(paramIMiniAppContext.getContext());
    this.mMiniAppContext = paramIMiniAppContext;
    this.mWebviewContainer = paramPageWebviewContainer;
    this.mInputHandler = new WebInputHandler(this);
    initKeyBoardConfirmView();
  }
  
  private boolean doInsertHTMLWebView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject;
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertHTMLWebView htmlId=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",innerWebView=");
      ((StringBuilder)localObject).append(this.innerWebView);
      QMLog.d("NativeViewContainer", ((StringBuilder)localObject).toString());
    }
    if (this.innerWebView == null)
    {
      localObject = this.mWebviewContainer;
      if ((localObject != null) && (((PageWebviewContainer)localObject).getAttachActivity() != null))
      {
        float f = DisplayUtil.getDensity(this.mMiniAppContext.getContext());
        int i = (int)(paramInt4 * f + 0.5F);
        paramInt4 = (int)(paramInt5 * f + 0.5F);
        paramInt5 = (int)(paramInt2 * f + 0.5F);
        int j = (int)(f * paramInt3 + 0.5F);
        if (QMLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("insertHTMLWebView htmlId=");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(",left=");
          ((StringBuilder)localObject).append(paramInt5);
          ((StringBuilder)localObject).append(",top=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",w=");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(",h=");
          ((StringBuilder)localObject).append(paramInt4);
          QMLog.d("NativeViewContainer", ((StringBuilder)localObject).toString());
        }
        paramInt2 = paramInt4;
        if (this.mWebviewContainer.isCustomNavibar())
        {
          paramInt3 = paramInt4 - (ViewUtils.dpToPx(44.0F) + DisplayUtil.getStatusBarHeight(this.mMiniAppContext.getContext()));
          if (this.mWebviewContainer.getBrandPage() != null) {
            this.mWebviewContainer.getBrandPage().updateViewStyle("default");
          }
          paramInt2 = paramInt3;
          if (this.mWebviewContainer.getNaviBar() != null)
          {
            this.mWebviewContainer.getNaviBar().setBarStyle("default");
            paramInt2 = paramInt3;
          }
        }
        this.innerWebView = new InnerWebView(this.mWebviewContainer.getAttachActivity());
        this.innerWebView.htmlId = paramInt1;
        localObject = new FrameLayout.LayoutParams(i, paramInt2);
        ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt5;
        ((FrameLayout.LayoutParams)localObject).topMargin = j;
        this.innerWebView.setVisibility(8);
        addView(this.innerWebView, (ViewGroup.LayoutParams)localObject);
        return true;
      }
    }
    return false;
  }
  
  private boolean doRemoveHTMLWebView(int paramInt)
  {
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeHTMLWebView htmlId=");
      ((StringBuilder)localObject).append(paramInt);
      QMLog.d("NativeViewContainer", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.innerWebView;
    if ((localObject != null) && (((InnerWebView)localObject).htmlId == paramInt))
    {
      this.innerWebView.loadUrl("about:blank");
      this.innerWebView.clearView();
      this.innerWebView.destroy();
      removeView(this.innerWebView);
      this.innerWebView = null;
      return true;
    }
    return false;
  }
  
  private ArrayList<String> getNeedCookieAppIdList()
  {
    try
    {
      if (needCookieAppIdList == null)
      {
        String str = WnsConfig.getConfig("qqminiapp", "MiniAppCookieWhiteAppIdList", "1108164955,1108291530,1109544007");
        if ((str != null) && (!str.equals(mCurWhiteListConfig)))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Default white appid:");
          ((StringBuilder)localObject2).append(str);
          QMLog.i("NativeViewContainer", ((StringBuilder)localObject2).toString());
          needCookieAppIdList = new ArrayList();
          try
          {
            localObject2 = str.split(",");
            if (localObject2 != null)
            {
              int j = localObject2.length;
              int i = 0;
              while (i < j)
              {
                CharSequence localCharSequence = localObject2[i];
                if (!TextUtils.isEmpty(localCharSequence)) {
                  needCookieAppIdList.add(localCharSequence);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            mCurWhiteListConfig = str;
          }
        }
      }
      return needCookieAppIdList;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  private void getNeedCookieHostList()
  {
    if (needCookieHostList == null)
    {
      String str = WnsConfig.getConfig("qqminiapp", "MiniAppCookieWhiteHostList", "https://open.mp.qq.com");
      if ((str != null) && (!str.equals(mWhiteHostConfig)))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Default white host:");
        ((StringBuilder)localObject).append(str);
        QMLog.i("NativeViewContainer", ((StringBuilder)localObject).toString());
        needCookieHostList = new ArrayList();
        try
        {
          localObject = str.split(",");
          if (localObject != null)
          {
            int j = localObject.length;
            int i = 0;
            while (i < j)
            {
              CharSequence localCharSequence = localObject[i];
              if (!TextUtils.isEmpty(localCharSequence)) {
                needCookieHostList.add(localCharSequence);
              }
              i += 1;
            }
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          mWhiteHostConfig = str;
        }
      }
    }
  }
  
  private void handleCanvasGetImageData(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject.optInt("canvasId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        paramNativeViewRequestEvent.fail();
        return;
      }
      ((CanvasView)localCoverView).getImageData(localJSONObject, paramNativeViewRequestEvent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramNativeViewRequestEvent.fail();
    }
  }
  
  private void handleCanvasPutImageData(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("canvasId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        this.mWebviewContainer.callbackJsEventFail(paramNativeViewRequestEvent.event, null, paramNativeViewRequestEvent.callbackId);
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("method", paramNativeViewRequestEvent.event);
        localJSONObject.put("data", localObject);
        localJSONObject.put("callbackId", paramNativeViewRequestEvent.callbackId);
        localJSONArray.put(localJSONObject);
        localObject = new CanvasView.DrawActionCommand(true, localJSONArray, false);
        ((CanvasView)localCoverView).addDrawActionCommand((CanvasView.DrawActionCommand)localObject);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.mWebviewContainer.callbackJsEventFail(paramNativeViewRequestEvent.event, null, paramNativeViewRequestEvent.callbackId);
    }
  }
  
  private void handleCanvasToTempFilePath(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject.optInt("canvasId");
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
      if (!(localCoverView instanceof CanvasView))
      {
        paramNativeViewRequestEvent.fail();
        return;
      }
      ((CanvasView)localCoverView).saveBitmap(this, paramNativeViewRequestEvent, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramNativeViewRequestEvent.fail();
    }
  }
  
  private void handleDrawCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      drawCanvas(localJSONObject.optInt("canvasId"), localJSONObject.optBoolean("reserve", false), localJSONObject.optBoolean("useHardwareAccelerate"), localJSONObject.optJSONArray("actions"), paramNativeViewRequestEvent);
      paramNativeViewRequestEvent.ok();
      return;
    }
    catch (JSONException paramNativeViewRequestEvent)
    {
      paramNativeViewRequestEvent.printStackTrace();
    }
  }
  
  private void handleHideKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.3(this, paramNativeViewRequestEvent));
  }
  
  private void handleInsertCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject1.optInt("canvasId");
      int j = localJSONObject1.optInt("parentId");
      localObject = localJSONObject1.optJSONObject("position");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.10(this, localJSONObject1, i, j, (JSONObject)localObject, localJSONObject1.optString("data"), paramNativeViewRequestEvent, localJSONObject2));
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramNativeViewRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("NativeViewContainer", ((StringBuilder)localObject).toString(), localJSONException);
    }
  }
  
  private void handleInsertTextArea(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject.optInt("inputId");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", i);
      String str = localJSONObject.optString("data");
      if (!TextUtils.isEmpty(str)) {
        ((JSONObject)localObject).put("data", str);
      }
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.6(this, i, localJSONObject, paramNativeViewRequestEvent, (JSONObject)localObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramNativeViewRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("NativeViewContainer", ((StringBuilder)localObject).toString(), localJSONException);
    }
  }
  
  private void handleRemoveCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.12(this, new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("canvasId"), paramNativeViewRequestEvent));
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramNativeViewRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("NativeViewContainer", localStringBuilder.toString(), localJSONException);
    }
  }
  
  private void handleRemoveTextArea(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      int i = new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("inputId");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("inputId", i);
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.8(this, i, paramNativeViewRequestEvent, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramNativeViewRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("NativeViewContainer", localStringBuilder.toString(), localJSONException);
    }
  }
  
  private void handleSetInputValue(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.5(this, paramNativeViewRequestEvent));
  }
  
  private void handleUpdateCanvas(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("canvasId");
      JSONObject localJSONObject = ((JSONObject)localObject).optJSONObject("position");
      boolean bool = ((JSONObject)localObject).optBoolean("hide", false);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("containerId", i);
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.11(this, i, localJSONObject, bool, paramNativeViewRequestEvent, (JSONObject)localObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramNativeViewRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("NativeViewContainer", ((StringBuilder)localObject).toString(), localJSONException);
    }
  }
  
  private void handleUpdateInput(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.4(this, paramNativeViewRequestEvent));
  }
  
  private void handleUpdateTextArea(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramNativeViewRequestEvent.jsonParams);
      int i = localJSONObject.optInt("inputId");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("inputId", i);
      String str = localJSONObject.optString("data");
      if (!TextUtils.isEmpty(str)) {
        ((JSONObject)localObject).put("data", str);
      }
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.7(this, localJSONObject, paramNativeViewRequestEvent, (JSONObject)localObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramNativeViewRequestEvent.event);
      ((StringBuilder)localObject).append(" error.");
      QMLog.e("NativeViewContainer", ((StringBuilder)localObject).toString(), localJSONException);
    }
  }
  
  private void initKeyBoardConfirmView()
  {
    this.keyBoardConfirmView = LayoutInflater.from(getContext().getApplicationContext()).inflate(R.layout.mini_sdk_keyboard_confirm, null);
    this.keyBoardConfirmView.setVisibility(8);
    ((TextView)this.keyBoardConfirmView.findViewById(R.id.mini_app_keyboard_confirm_botton)).setOnClickListener(new NativeViewContainer.9(this));
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      localPageWebviewContainer.addViewOnPage(this.keyBoardConfirmView);
    }
  }
  
  private void inputShowKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent, long paramLong)
  {
    if (System.currentTimeMillis() - paramLong > 1000L)
    {
      this.lastShowInputTime = System.currentTimeMillis();
      AppBrandTask.runTaskOnUiThreadDelay(new NativeViewContainer.1(this, paramNativeViewRequestEvent), 200L);
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.getParentId() == paramInt)) {
        if (localCoverView1.getParentId() == 0)
        {
          removeView(localCoverView1);
        }
        else
        {
          CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.getParentId());
          if (localCoverView2 != null) {
            localCoverView2.removeView(localCoverView1);
          }
        }
      }
      i += 1;
    }
  }
  
  private void setWebviewCookie(String paramString)
  {
    Object localObject1;
    if ((this.mWebviewContainer.getMiniAppContext() != null) && (this.mWebviewContainer.getMiniAppContext().getMiniAppInfo() != null)) {
      localObject1 = this.mWebviewContainer.getMiniAppContext().getMiniAppInfo();
    } else {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = needCookieAppIdList;
      if ((localObject2 != null) && (((ArrayList)localObject2).contains(((MiniAppInfo)localObject1).appId)))
      {
        localObject1 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        if (localObject1 != null) {
          ((ChannelProxy)localObject1).setWebviewCookie(this.mWebviewContainer.getAttachActivity(), paramString);
        }
      }
    }
    paramString = needCookieHostList;
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("setCookie : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QMLog.i("NativeViewContainer", ((StringBuilder)localObject2).toString());
        localObject2 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
        if (localObject2 != null) {
          ((ChannelProxy)localObject2).setWebviewCookie(this.mWebviewContainer.getAttachActivity(), (String)localObject1);
        }
      }
    }
  }
  
  private void showErrorPage(int paramInt, String paramString, MiniAppInfo paramMiniAppInfo, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    String str2 = WnsConfig.getConfig("qqminiapp", "https://m.q.qq.com/webview/error?url={url}&appid={appid}", "https://m.q.qq.com/webview/error?url={url}&appid={appid}");
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str2 = str2.replace("{url}", paramString);
      str1 = str2;
      if (paramMiniAppInfo != null) {
        str1 = str2.replace("{appid}", paramMiniAppInfo.appId);
      }
    }
    doUpdateHTMLWebView(paramInt, str1);
    paramMiniAppInfo = new StringBuilder();
    paramMiniAppInfo.append("updateHTMLWebView domain valid : ");
    paramMiniAppInfo.append(paramString);
    QMLog.e("NativeViewContainer", paramMiniAppInfo.toString());
    paramNativeViewRequestEvent.fail("domain valid");
  }
  
  private void textareaShowKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent, int paramInt)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.2(this, paramInt, paramNativeViewRequestEvent));
  }
  
  public boolean addConfirmListener(NativeViewContainer.IConfirmListerner paramIConfirmListerner)
  {
    synchronized (this.mConfirmListeners)
    {
      if (!this.mConfirmListeners.contains(paramIConfirmListerner))
      {
        boolean bool = this.mConfirmListeners.add(paramIConfirmListerner);
        return bool;
      }
      return false;
    }
  }
  
  public boolean addCoverView(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addCoverView(). parentViewId = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", coverViewId = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", coverView = ");
    ((StringBuilder)localObject).append(paramCoverView);
    QMLog.d("NativeViewContainer", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder("addCoverView(). ");
    ((StringBuilder)localObject).append("parentViewId = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("coverViewId = ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("coverView = ");
    ((StringBuilder)localObject).append(paramCoverView);
    ((StringBuilder)localObject).append("fixed = ");
    ((StringBuilder)localObject).append(paramBoolean);
    if (paramCoverView == null)
    {
      QMLog.w("NativeViewContainer", "Failed to add coverView, coverView is null");
      return false;
    }
    this.mCoverViewSparseArray.put(paramInt2, paramCoverView);
    if (paramInt1 == 0)
    {
      if (paramBoolean) {
        this.mWebviewContainer.addView(paramCoverView);
      } else {
        addView(paramCoverView);
      }
    }
    else
    {
      localObject = getCoverView(paramInt1);
      if (localObject != null) {
        ((CoverView)localObject).addView(paramCoverView);
      }
    }
    return true;
  }
  
  public void addViewOnPage(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      localPageWebviewContainer.addViewOnPage(paramView, paramLayoutParams);
    }
  }
  
  public void callbackLineChange(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = getTextArea(paramInt);
    if (localMiniAppTextArea != null) {
      localMiniAppTextArea.callbackLineChange();
    }
  }
  
  public void destroy()
  {
    Object localObject = this.innerWebView;
    if (localObject != null)
    {
      removeView((View)localObject);
      this.innerWebView.loadUrl("about:blank");
      this.innerWebView.clearView();
      this.innerWebView.destroy();
      this.innerWebView = null;
    }
    localObject = this.appTextAreaSparseArray;
    int j = 0;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      i = 0;
      while (i < this.appTextAreaSparseArray.size())
      {
        localObject = (MiniAppTextArea)this.appTextAreaSparseArray.valueAt(i);
        if (localObject != null)
        {
          ((MiniAppTextArea)localObject).removeKeyboardListener();
          ((MiniAppTextArea)localObject).removeGlobalLayoutListener();
        }
        i += 1;
      }
    }
    this.appTextAreaSparseArray.clear();
    int i = j;
    while (i < this.mCoverViewSparseArray.size())
    {
      localObject = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localObject instanceof CoverVideoView))
      {
        CoverVideoView localCoverVideoView = (CoverVideoView)localObject;
        localCoverVideoView.stop();
        localCoverVideoView.release();
        removeView((View)localObject);
      }
      else if ((localObject instanceof CoverLiveView))
      {
        ((CoverLiveView)localObject).release();
        removeView((View)localObject);
      }
      else if ((localObject instanceof CoverPusherView))
      {
        ((CoverPusherView)localObject).release();
        removeView((View)localObject);
      }
      else if ((localObject instanceof CoverCameraView))
      {
        ((CoverCameraView)localObject).closeCamera();
      }
      i += 1;
    }
    this.mCoverViewSparseArray.clear();
  }
  
  public boolean doUpdateHTMLWebView(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateHTMLWebView htmlId=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",innerWebView=");
    ((StringBuilder)localObject).append(this.innerWebView);
    ((StringBuilder)localObject).append(",src=");
    ((StringBuilder)localObject).append(paramString);
    QMLog.d("NativeViewContainer", ((StringBuilder)localObject).toString());
    localObject = this.innerWebView;
    if ((localObject != null) && (((InnerWebView)localObject).htmlId == paramInt))
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.mWebviewContainer == null)
      {
        QMLog.d("NativeViewContainer", "container is null");
        return false;
      }
      setWebviewCookie(paramString);
      this.innerWebView.init(this.mWebviewContainer.getMiniAppContext());
      this.innerWebView.setVisibility(0);
      localObject = CookieManager.getInstance().getCookie(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cookie : ");
      localStringBuilder.append((String)localObject);
      QMLog.e("NativeViewContainer", localStringBuilder.toString());
      this.innerWebView.loadUrl(paramString);
      try
      {
        paramString = new StringBuilder();
        paramString.append("innerWebView.hasFocus() : ");
        paramString.append(this.innerWebView.hasFocus());
        QMLog.e("NativeViewContainer", paramString.toString());
        if (!this.innerWebView.hasFocus()) {
          this.innerWebView.requestFocus();
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("NativeViewContainer", "innerWebView requestFocuserror,", paramString);
      }
      return true;
    }
    return false;
  }
  
  public boolean doUpdateHTMLWebView(int paramInt, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateHTMLWebView htmlId=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",innerWebView=");
      ((StringBuilder)localObject).append(this.innerWebView);
      ((StringBuilder)localObject).append(",position=");
      ((StringBuilder)localObject).append(paramJSONObject);
      QMLog.d("NativeViewContainer", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.innerWebView;
    if ((localObject != null) && (((InnerWebView)localObject).htmlId == paramInt) && (paramJSONObject != null))
    {
      float f = DisplayUtil.getDensity(getContext());
      paramInt = (int)(paramJSONObject.optInt("width") * f + 0.5F);
      int i = (int)(paramJSONObject.optInt("height") * f + 0.5F);
      int j = (int)(paramJSONObject.optInt("left") * f + 0.5F);
      int k = (int)(f * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = k;
      this.innerWebView.setLayoutParams(paramJSONObject);
      return true;
    }
    return false;
  }
  
  public void drawCanvas(int paramInt, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView))
    {
      paramJSONArray = new StringBuilder();
      paramJSONArray.append("updateCanvas failed! appCanvas return null! canvasId: ");
      paramJSONArray.append(paramInt);
      QMLog.e("NativeViewContainer", paramJSONArray.toString());
      paramNativeViewRequestEvent.fail();
      return;
    }
    paramJSONArray = new CanvasView.DrawActionCommand(paramBoolean1, paramJSONArray, paramBoolean2);
    ((CanvasView)localCoverView).addDrawActionCommand(paramJSONArray);
  }
  
  public CoverView getCoverView(int paramInt)
  {
    return (CoverView)this.mCoverViewSparseArray.get(paramInt);
  }
  
  public int getCurInputId()
  {
    return this.mCurInput;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.getCurrentPageWebview();
    }
    return null;
  }
  
  public String getInnerWebViewUrl()
  {
    InnerWebView localInnerWebView = this.innerWebView;
    if (localInnerWebView != null) {
      return localInnerWebView.getOriginalUrl();
    }
    return null;
  }
  
  public int getNaviBarHeight()
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.getNaviBarHeight();
    }
    return 0;
  }
  
  public PageWebviewContainer getPageWebviewContainer()
  {
    return this.mWebviewContainer;
  }
  
  public MiniAppTextArea getTextArea(int paramInt)
  {
    Object localObject = this.appTextAreaSparseArray;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      localObject = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  public int getWebviewId()
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.getWebViewId();
    }
    return 0;
  }
  
  public boolean handleBackPressed()
  {
    Object localObject = this.innerWebView;
    if ((localObject != null) && (((InnerWebView)localObject).canGoBack()))
    {
      this.innerWebView.goBack();
      return true;
    }
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      localObject = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localObject instanceof CoverVideoView))
      {
        localObject = (CoverVideoView)localObject;
        if (((CoverVideoView)localObject).isFullScreen())
        {
          ((CoverVideoView)localObject).smallScreen();
          return true;
        }
      }
      else if ((localObject instanceof CoverLiveView))
      {
        localObject = (CoverLiveView)localObject;
        if (((CoverLiveView)localObject).isFullScreen())
        {
          ((CoverLiveView)localObject).smallScreen();
          return true;
        }
      }
      i += 1;
    }
    localObject = getCurrentPageWebview();
    return (localObject != null) && (((PageWebview)localObject).handleBackPressed());
  }
  
  public void handleInsertHtmlWebview(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.14(this, paramNativeViewRequestEvent));
  }
  
  public String handleNativeUIEvent(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event = ");
    localStringBuilder.append(paramNativeViewRequestEvent.event);
    localStringBuilder.append(", params = ");
    localStringBuilder.append(paramNativeViewRequestEvent.jsonParams);
    QMLog.d("NativeViewContainer", localStringBuilder.toString());
    if ("showKeyboard".equals(paramNativeViewRequestEvent.event)) {
      handleShowKeyboard(paramNativeViewRequestEvent);
    } else if ("hideKeyboard".equals(paramNativeViewRequestEvent.event)) {
      handleHideKeyboard(paramNativeViewRequestEvent);
    } else if ("updateInput".equals(paramNativeViewRequestEvent.event)) {
      handleUpdateInput(paramNativeViewRequestEvent);
    } else if ("setKeyboardValue".equals(paramNativeViewRequestEvent.event)) {
      handleSetInputValue(paramNativeViewRequestEvent);
    } else if ("insertTextArea".equals(paramNativeViewRequestEvent.event)) {
      handleInsertTextArea(paramNativeViewRequestEvent);
    } else if ("updateTextArea".equals(paramNativeViewRequestEvent.event)) {
      handleUpdateTextArea(paramNativeViewRequestEvent);
    } else if ("removeTextArea".equals(paramNativeViewRequestEvent.event)) {
      handleRemoveTextArea(paramNativeViewRequestEvent);
    } else if ("insertCanvas".equals(paramNativeViewRequestEvent.event)) {
      handleInsertCanvas(paramNativeViewRequestEvent);
    } else if ("updateCanvas".equals(paramNativeViewRequestEvent.event)) {
      handleUpdateCanvas(paramNativeViewRequestEvent);
    } else if ("removeCanvas".equals(paramNativeViewRequestEvent.event)) {
      handleRemoveCanvas(paramNativeViewRequestEvent);
    } else if ("drawCanvas".equals(paramNativeViewRequestEvent.event)) {
      handleDrawCanvas(paramNativeViewRequestEvent);
    } else if ("canvasToTempFilePath".equals(paramNativeViewRequestEvent.event)) {
      handleCanvasToTempFilePath(paramNativeViewRequestEvent);
    } else if ("canvasPutImageData".equals(paramNativeViewRequestEvent.event)) {
      handleCanvasPutImageData(paramNativeViewRequestEvent);
    } else if ("canvasGetImageData".equals(paramNativeViewRequestEvent.event)) {
      handleCanvasGetImageData(paramNativeViewRequestEvent);
    } else if ("insertHTMLWebView".equals(paramNativeViewRequestEvent.event)) {
      handleInsertHtmlWebview(paramNativeViewRequestEvent);
    } else if ("updateHTMLWebView".equals(paramNativeViewRequestEvent.event)) {
      handleUpdateHtmlWebview(paramNativeViewRequestEvent);
    } else if ("removeHTMLWebView".equals(paramNativeViewRequestEvent.event)) {
      handleRemoveHtmlWebview(paramNativeViewRequestEvent);
    }
    return null;
  }
  
  public void handleRemoveHtmlWebview(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.16(this, paramNativeViewRequestEvent));
  }
  
  void handleShowKeyboard(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      int i = new JSONObject(paramNativeViewRequestEvent.jsonParams).optInt("inputId");
      if (i > 0)
      {
        textareaShowKeyboard(paramNativeViewRequestEvent, i);
        return;
      }
      inputShowKeyboard(paramNativeViewRequestEvent, this.lastShowInputTime);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramNativeViewRequestEvent.event);
      localStringBuilder.append(" error.");
      QMLog.e("NativeViewContainer", localStringBuilder.toString(), localException);
    }
  }
  
  public void handleUpdateHtmlWebview(NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    getNeedCookieAppIdList();
    getNeedCookieHostList();
    AppBrandTask.runTaskOnUiThread(new NativeViewContainer.15(this, paramNativeViewRequestEvent));
  }
  
  public void hideKeyBoardConfirmView()
  {
    View localView = this.keyBoardConfirmView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      this.keyBoardConfirmView.setVisibility(8);
    }
  }
  
  public void insertCanvas(int paramInt1, int paramInt2, JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3, IJsService paramIJsService)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a23 = a20\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
  }
  
  public void insertTextArea(int paramInt, JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    MiniAppTextArea localMiniAppTextArea2 = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    int i = paramJSONObject.optInt("parentId");
    boolean bool = paramJSONObject.optBoolean("fixed", false);
    MiniAppTextArea localMiniAppTextArea1 = localMiniAppTextArea2;
    if (localMiniAppTextArea2 == null)
    {
      localMiniAppTextArea2 = new MiniAppTextArea(getContext(), paramInt, this);
      localMiniAppTextArea2.setFixed(bool);
      this.appTextAreaSparseArray.put(paramInt, localMiniAppTextArea2);
      if (i != 0)
      {
        FrameLayout localFrameLayout = (FrameLayout)this.mCoverViewSparseArray.get(i);
        localMiniAppTextArea1 = localMiniAppTextArea2;
        if (localFrameLayout != null)
        {
          localFrameLayout.addView(localMiniAppTextArea2);
          localMiniAppTextArea2.setParentId(i);
          localMiniAppTextArea1 = localMiniAppTextArea2;
        }
      }
      else if (bool)
      {
        getPageWebviewContainer().addView(localMiniAppTextArea2);
        localMiniAppTextArea1 = localMiniAppTextArea2;
      }
      else
      {
        addView(localMiniAppTextArea2);
        localMiniAppTextArea1 = localMiniAppTextArea2;
      }
    }
    localMiniAppTextArea1.setAttributes(paramJSONObject, false, paramNativeViewRequestEvent);
  }
  
  public boolean isCustomNavibar()
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      return localPageWebviewContainer.isCustomNavibar();
    }
    return false;
  }
  
  public boolean isTextAreaFocused()
  {
    int i = 0;
    while (i < this.appTextAreaSparseArray.size())
    {
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.valueAt(i);
      if ((localMiniAppTextArea != null) && (localMiniAppTextArea.isTextAreaFocused())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isVideoFullScreen()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverVideoView))
      {
        if (((CoverVideoView)localCoverView).isFullScreen()) {
          return true;
        }
      }
      else if (((localCoverView instanceof CoverLiveView)) && (((CoverLiveView)localCoverView).isFullScreen())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void notifyOnColorNoteAnimStart()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onAddColorNote();
      }
      i += 1;
    }
  }
  
  public void notifyOnPageWebViewDestory()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageWebViewDestory();
      }
      i += 1;
    }
  }
  
  public void notifyOnPageWebViewPause()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageWebViewPause();
      }
      i += 1;
    }
    if (this.innerWebView != null)
    {
      QMLog.d("NativeViewContainer", "innerWebView pause");
      this.innerWebView.onPause();
    }
  }
  
  public void notifyOnPageWebViewResume()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageWebViewResume();
      }
      i += 1;
    }
    if (this.innerWebView != null)
    {
      QMLog.d("NativeViewContainer", "innerWebView resume & requestFocus");
      this.innerWebView.onResume();
      AppBrandTask.runTaskOnUiThread(new NativeViewContainer.13(this));
    }
  }
  
  public void notifyPageBackground()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageBackground();
      }
      i += 1;
    }
  }
  
  public void notifyPageForeground()
  {
    int i = 0;
    while (i < this.mCoverViewSparseArray.size())
    {
      CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
      if ((localCoverView instanceof CoverView.OnPageChangeListener)) {
        ((CoverView.OnPageChangeListener)localCoverView).onPageForeground();
      }
      i += 1;
    }
  }
  
  public void onPause()
  {
    notifyPageBackground();
  }
  
  public void onResume()
  {
    notifyPageForeground();
  }
  
  public void removeCanvas(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0)
    {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    else if (localCoverView.isFixed()) {
      this.mWebviewContainer.removeView(localCoverView);
    } else {
      removeView(localCoverView);
    }
    this.mCoverViewSparseArray.remove(paramInt);
  }
  
  public boolean removeConfirmListener(NativeViewContainer.IConfirmListerner paramIConfirmListerner)
  {
    synchronized (this.mConfirmListeners)
    {
      if (this.mConfirmListeners.contains(paramIConfirmListerner))
      {
        boolean bool = this.mConfirmListeners.remove(paramIConfirmListerner);
        return bool;
      }
      return false;
    }
  }
  
  public boolean removeCoverView(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (localCoverView == null) {
      return false;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0)
    {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    else if (localCoverView.isFixed()) {
      this.mWebviewContainer.removeView(localCoverView);
    } else {
      removeView(localCoverView);
    }
    this.mCoverViewSparseArray.remove(paramInt);
    if ((localCoverView instanceof CoverLiveView)) {
      ((CoverLiveView)localCoverView).release();
    } else if ((localCoverView instanceof CoverPusherView)) {
      ((CoverPusherView)localCoverView).release();
    }
    return true;
  }
  
  public void removeSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      localPageWebviewContainer.removeSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void removeTextArea(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    if (localMiniAppTextArea == null) {
      return;
    }
    this.appTextAreaSparseArray.remove(paramInt);
    int i = localMiniAppTextArea.getParentId();
    if (i != 0)
    {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localMiniAppTextArea);
      }
    }
    else if (localMiniAppTextArea.isFixed()) {
      getPageWebviewContainer().removeView(localMiniAppTextArea);
    } else {
      removeView(localMiniAppTextArea);
    }
    this.appTextAreaSparseArray.remove(paramInt);
  }
  
  public void setCurInputId(int paramInt)
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      localPageWebviewContainer.setCurInputId(paramInt);
    }
  }
  
  public void setSoftKeyboardStateListener(SoftKeyboardStateHelper.SoftKeyboardStateListener paramSoftKeyboardStateListener)
  {
    PageWebviewContainer localPageWebviewContainer = this.mWebviewContainer;
    if (localPageWebviewContainer != null) {
      localPageWebviewContainer.setSoftKeyboardStateListener(paramSoftKeyboardStateListener);
    }
  }
  
  public void showKeyBoardConfirmView(int paramInt)
  {
    Object localObject = this.keyBoardConfirmView;
    if (localObject != null)
    {
      if (((View)localObject).getVisibility() == 8) {
        this.keyBoardConfirmView.setVisibility(0);
      }
      localObject = new FrameLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 50.0F));
      ((FrameLayout.LayoutParams)localObject).leftMargin = 0;
      ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
      this.keyBoardConfirmView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void updateCanvas(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView))
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("updateCanvas failed! appCanvas return null! canvasId: ");
      paramJSONObject.append(paramInt);
      QMLog.e("NativeViewContainer", paramJSONObject.toString());
      return;
    }
    if (paramBoolean) {
      localCoverView.setVisibility(8);
    } else {
      localCoverView.setVisibility(0);
    }
    if (paramJSONObject != null)
    {
      paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = k;
      localCoverView.setLayoutParams(paramJSONObject);
    }
  }
  
  public void updateTextArea(JSONObject paramJSONObject, NativeViewRequestEvent paramNativeViewRequestEvent)
  {
    try
    {
      int i = paramJSONObject.optInt("inputId");
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(i);
      if (localMiniAppTextArea == null) {
        return;
      }
      localMiniAppTextArea.setAttributes(paramJSONObject, true, paramNativeViewRequestEvent);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QMLog.e("NativeViewContainer", "updateTextArea error.", paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer
 * JD-Core Version:    0.7.0.1
 */