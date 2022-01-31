package com.tencent.mobileqq.mini.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import baip;
import bajq;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.NavigationBarInfo;
import com.tencent.mobileqq.mini.apkg.PageInfo;
import com.tencent.mobileqq.mini.apkg.WindowInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.ColorUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.util.ImageUtil;
import com.tencent.mobileqq.mini.widget.CanvasView;
import com.tencent.mobileqq.mini.widget.CanvasView.DrawActionCommand;
import com.tencent.mobileqq.mini.widget.CoverImageView;
import com.tencent.mobileqq.mini.widget.CoverMapView;
import com.tencent.mobileqq.mini.widget.CoverScrollView;
import com.tencent.mobileqq.mini.widget.CoverTextView;
import com.tencent.mobileqq.mini.widget.CoverView;
import com.tencent.mobileqq.mini.widget.CoverView.OnPageChangeListener;
import com.tencent.mobileqq.mini.widget.MapContext;
import com.tencent.mobileqq.mini.widget.MiniAppTextArea;
import com.tencent.mobileqq.mini.widget.media.CameraSurfaceView.CameraSurfaceViewCallBack;
import com.tencent.mobileqq.mini.widget.media.CoverCameraView;
import com.tencent.mobileqq.mini.widget.media.CoverLiveView;
import com.tencent.mobileqq.mini.widget.media.CoverPusherView;
import com.tencent.mobileqq.mini.widget.media.CoverVideoView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebviewContainer
  extends FrameLayout
  implements Handler.Callback, SwipeRefreshLayout.OnRefreshListener
{
  private static final int AUDIO_TYPE = 3;
  private static final String CONFIG_SPLIT = ",";
  private static final int MSG_WHAT_HIDE_CTR_VIEW = 942301;
  public static final String TAG = "WebViewContainer";
  private static String mCurWhiteListConfig;
  private static ArrayList<String> needCookieAppIdList;
  protected ApkgInfo apkgInfo;
  public AppBrandRuntime appBrandRuntime;
  private SparseArray<MiniAppTextArea> appTextAreaSparseArray = new SparseArray();
  private FrameLayout componentLayout;
  protected float density;
  private boolean disableScroll;
  private boolean enableRefresh;
  private ProgressWebView innerWebView;
  private SparseArray<CoverView> mCoverViewSparseArray = new SparseArray();
  private SparseArray<MapContext> mapContextArray;
  private boolean needSeetPadding = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappcovertextviewpadding", true);
  protected PageInfo pageInfo;
  private String pageOrientation = WindowInfo.ORIENTATION_PORTRAIT;
  private PageWebview pageWebview;
  public SwipeRefreshLayout swipeRefreshLayout;
  
  public WebviewContainer(Context paramContext)
  {
    super(paramContext);
    this.density = DisplayUtil.getDensity(paramContext);
    this.componentLayout = new FrameLayout(getContext());
    ViewCompat.setImportantForAccessibility(this.componentLayout, 4);
    this.mapContextArray = new SparseArray();
    this.swipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.swipeRefreshLayout.setOnRefreshListener(this);
    addView(this.swipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    getNeedCookieAppIdList();
  }
  
  private String getActualColor(String paramString)
  {
    if (baip.a(paramString)) {
      return "";
    }
    String str = paramString.substring(paramString.length() - 2);
    paramString = paramString.substring(1, paramString.length() - 2);
    return "#" + str + paramString;
  }
  
  private ArrayList<String> getNeedCookieAppIdList()
  {
    try
    {
      if (needCookieAppIdList == null)
      {
        String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppCookieWhiteList", "1108164955,1108291530,1109544007");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QLog.i("WebViewContainer", 1, "Default white appid:" + str1);
          needCookieAppIdList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(",");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  needCookieAppIdList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            mCurWhiteListConfig = str1;
          }
        }
      }
      return needCookieAppIdList;
    }
    finally {}
  }
  
  private boolean isVideoFullScreen()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      CoverView localCoverView;
      if (i < this.mCoverViewSparseArray.size())
      {
        localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
        if ((localCoverView instanceof CoverVideoView))
        {
          if (!((CoverVideoView)localCoverView).isFullScreen()) {
            break label74;
          }
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      if (((localCoverView instanceof CoverLiveView)) && (((CoverLiveView)localCoverView).isFullScreen())) {
        return true;
      }
      label74:
      i += 1;
    }
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int i = 0;
    if (i < this.mCoverViewSparseArray.size())
    {
      int j = this.mCoverViewSparseArray.keyAt(i);
      CoverView localCoverView1 = (CoverView)this.mCoverViewSparseArray.get(j);
      if ((localCoverView1 != null) && (localCoverView1.getParentId() == paramInt))
      {
        if (localCoverView1.getParentId() != 0) {
          break label73;
        }
        this.componentLayout.removeView(localCoverView1);
      }
      for (;;)
      {
        i += 1;
        break;
        label73:
        CoverView localCoverView2 = (CoverView)this.mCoverViewSparseArray.get(localCoverView1.getParentId());
        if (localCoverView2 != null) {
          localCoverView2.removeView(localCoverView1);
        }
      }
    }
  }
  
  private void setCookie(String paramString)
  {
    Object localObject = SwiftBrowserCookieMonster.c(paramString).replace(" ", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (Build.VERSION.SDK_INT < 21) {
        CookieSyncManager.createInstance(this.appBrandRuntime.activity);
      }
      CookieManager localCookieManager = CookieManager.getInstance();
      localCookieManager.setAcceptCookie(true);
      localCookieManager.removeSessionCookie();
      localCookieManager.removeAllCookie();
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        localCookieManager.setCookie(Uri.parse(paramString).getHost(), str);
        i += 1;
      }
      CookieSyncManager.getInstance().sync();
    }
  }
  
  private void updateScrollView(JSONObject paramJSONObject, CoverScrollView paramCoverScrollView)
  {
    Object localObject1 = paramJSONObject.optJSONObject("style");
    int j;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      j = 0;
      i = j;
      if (((JSONObject)localObject1).has("bgColor"))
      {
        localObject2 = getActualColor(((JSONObject)localObject1).optString("bgColor"));
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
    }
    try
    {
      i = Color.parseColor((String)localObject2);
      int k = 0;
      j = k;
      if (((JSONObject)localObject1).has("borderColor"))
      {
        localObject2 = getActualColor(((JSONObject)localObject1).optString("borderColor"));
        j = k;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          j = Color.parseColor((String)localObject2);
        }
      }
      paramCoverScrollView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
      paramCoverScrollView.setBackgroundColor(i);
      paramCoverScrollView.setScaleX((float)((JSONObject)localObject1).optDouble("scaleX", 1.0D));
      paramCoverScrollView.setScaleY((float)((JSONObject)localObject1).optDouble("scaleY", 1.0D));
      localObject2 = ((JSONObject)localObject1).optJSONArray("padding");
      if (localObject2 != null) {
        paramCoverScrollView.setPadding(((JSONArray)localObject2).optInt(3), ((JSONArray)localObject2).optInt(2), ((JSONArray)localObject2).optInt(1), ((JSONArray)localObject2).optInt(0));
      }
      paramCoverScrollView.setBorder(((JSONObject)localObject1).optInt("borderWidth", 0), j, (float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D), i);
      paramCoverScrollView.setBorderRadius((float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D) * this.density);
      paramCoverScrollView.setClickable(paramJSONObject.optBoolean("clickable", false));
      paramCoverScrollView.setHorizontalScrollBarEnabled(paramJSONObject.optBoolean("scrollX", false));
      paramCoverScrollView.setVerticalScrollBarEnabled(paramJSONObject.optBoolean("scrollY", false));
      localObject1 = paramJSONObject.optJSONObject("position");
      float f;
      if (localObject1 != null)
      {
        i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
        j = (int)(this.density * ((JSONObject)localObject1).optInt("height") + 0.5F);
        k = (int)(this.density * ((JSONObject)localObject1).optInt("left") + 0.5F);
        f = this.density;
        int m = (int)(((JSONObject)localObject1).optInt("top") * f + 0.5F);
        localObject1 = new FrameLayout.LayoutParams(i, j);
        ((FrameLayout.LayoutParams)localObject1).leftMargin = k;
        ((FrameLayout.LayoutParams)localObject1).topMargin = m;
        paramCoverScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (paramJSONObject.has("contentSize"))
      {
        localObject1 = paramJSONObject.optJSONObject("contentSize");
        if (localObject1 != null)
        {
          i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
          f = this.density;
          paramCoverScrollView.setContainerSize(i, (int)(((JSONObject)localObject1).optInt("height") * f + 0.5F));
        }
      }
      if (paramJSONObject.has("scrollTop")) {
        paramCoverScrollView.setScrollTop((int)(this.density * paramJSONObject.optInt("scrollTop", 0) + 0.5F));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("WebViewContainer", "insertTextView: failed to parse color " + (String)localObject2, localException);
        i = j;
      }
    }
  }
  
  private void updateTextView(CoverTextView paramCoverTextView, JSONObject paramJSONObject)
  {
    Object localObject1 = paramJSONObject.optJSONObject("style");
    Object localObject2;
    if (localObject1 != null)
    {
      if (!((JSONObject)localObject1).has("bgColor")) {
        break label758;
      }
      localObject2 = getActualColor(((JSONObject)localObject1).optString("bgColor"));
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label758;
      }
    }
    label576:
    label736:
    label744:
    label758:
    for (int i = Color.parseColor((String)localObject2);; i = 0)
    {
      if (((JSONObject)localObject1).has("borderColor"))
      {
        localObject2 = getActualColor(((JSONObject)localObject1).optString("borderColor"));
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      }
      for (int j = Color.parseColor((String)localObject2);; j = 0)
      {
        paramCoverTextView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
        paramCoverTextView.setBackgroundColor(i);
        paramCoverTextView.setScaleX((float)((JSONObject)localObject1).optDouble("scaleX", 1.0D));
        paramCoverTextView.setScaleY((float)((JSONObject)localObject1).optDouble("scaleY", 1.0D));
        localObject2 = ((JSONObject)localObject1).optJSONArray("padding");
        if (localObject2 != null) {
          paramCoverTextView.setPadding(((JSONArray)localObject2).optInt(3), ((JSONArray)localObject2).optInt(0), ((JSONArray)localObject2).optInt(1), ((JSONArray)localObject2).optInt(2));
        }
        paramCoverTextView.setBorder(((JSONObject)localObject1).optInt("borderWidth", 0), j, (float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D), i);
        paramCoverTextView.setAlpha((float)((JSONObject)localObject1).optDouble("opacity", 0.0D));
        paramCoverTextView.setBorderRadius((float)((JSONObject)localObject1).optDouble("borderRadius", 0.0D) * this.density);
        paramCoverTextView.setClickable(paramJSONObject.optBoolean("clickable"));
        paramCoverTextView.setIncludeFontPadding(false);
        localObject1 = paramJSONObject.optJSONObject("position");
        if (localObject1 != null)
        {
          i = (int)(this.density * ((JSONObject)localObject1).optInt("width") + 0.5F);
          j = (int)(this.density * ((JSONObject)localObject1).optInt("height") + 0.5F);
          int k = (int)(this.density * ((JSONObject)localObject1).optInt("left") + 0.5F);
          float f = this.density;
          int m = (int)(((JSONObject)localObject1).optInt("top") * f + 0.5F);
          localObject1 = new FrameLayout.LayoutParams(i, j);
          ((FrameLayout.LayoutParams)localObject1).leftMargin = k;
          ((FrameLayout.LayoutParams)localObject1).topMargin = m;
          paramCoverTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        paramJSONObject = paramJSONObject.optJSONObject("label");
        if (paramJSONObject != null)
        {
          if (!baip.a(paramJSONObject.optString("color")))
          {
            localObject1 = getActualColor(paramJSONObject.optString("color"));
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              paramCoverTextView.setTextColor(Color.parseColor((String)localObject1));
            }
          }
          i = paramJSONObject.optInt("fontSize", 0);
          if (i > 0) {
            paramCoverTextView.setTextSize(0, DisplayUtil.dip2px(getContext(), i));
          }
          localObject1 = paramJSONObject.optString("textAlign");
          if (!"left".equals(localObject1)) {
            break label697;
          }
          paramCoverTextView.setGravity(3);
          localObject1 = paramJSONObject.optString("content");
          if (!baip.a((String)localObject1)) {
            paramCoverTextView.setText((String)localObject1);
          }
          if ("bold".equals(paramJSONObject.optString("fontWeight"))) {
            paramCoverTextView.setTypeface(Typeface.defaultFromStyle(1));
          }
          if (!"nowrap".equals(paramJSONObject.optString("whiteSpace", "nowrap"))) {
            break label736;
          }
          paramCoverTextView.setSingleLine(true);
          if (!"ellipsis".equals(paramJSONObject.optString("lineBreak", "clip"))) {
            break label744;
          }
          paramCoverTextView.setEllipsize(TextUtils.TruncateAt.END);
        }
        for (;;)
        {
          i = paramJSONObject.optInt("lineHeight", 0);
          if (i > 0)
          {
            i = DisplayUtil.dip2px(getContext(), i) - paramCoverTextView.getTextView().getLineHeight();
            if (i != 0)
            {
              paramCoverTextView.setLineSpacing(i, 1.0F);
              if ((this.needSeetPadding) && (Build.MANUFACTURER.equals("Xiaomi")) && (i < 0)) {
                paramCoverTextView.getTextView().setPadding(0, (int)(i / DisplayUtil.getDensity(getContext())), 0, 0);
              }
            }
          }
          return;
          if ("center".equals(localObject1))
          {
            paramCoverTextView.setGravity(17);
            break;
          }
          if (!"right".equals(localObject1)) {
            break;
          }
          paramCoverTextView.setGravity(5);
          break;
          paramCoverTextView.setSingleLine(false);
          break label576;
          paramCoverTextView.setEllipsize(null);
        }
      }
    }
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.pageWebview != null)
    {
      paramString = ApiUtil.wrapCallbackFail(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.pageWebview.evaluateCallbackJs(paramInt, paramString);
      return;
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.pageWebview != null)
    {
      paramString = ApiUtil.wrapCallbackOk(paramString, paramJSONObject);
      if (paramString == null) {
        break label32;
      }
    }
    label32:
    for (paramString = paramString.toString();; paramString = "")
    {
      this.pageWebview.evaluateCallbackJs(paramInt, paramString);
      return;
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
    int j = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("WebViewContainer", 2, "-----destroy----");
    }
    if (this.innerWebView != null)
    {
      this.innerWebView.loadUrl("about:blank");
      this.innerWebView.clearView();
      this.innerWebView.destroy();
      this.innerWebView = null;
    }
    try
    {
      if (this.pageWebview != null)
      {
        this.swipeRefreshLayout.removeView(this.pageWebview);
        this.pageWebview.destroy();
      }
      i = 0;
      for (;;)
      {
        if (i >= this.mCoverViewSparseArray.size()) {
          break label215;
        }
        CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
        if (!(localCoverView instanceof CoverVideoView)) {
          break;
        }
        ((CoverVideoView)localCoverView).stop();
        ((CoverVideoView)localCoverView).release();
        MiniAppStateManager.getInstance().deleteObserver(((CoverVideoView)localCoverView).getVideoPlayerStatusObserver());
        this.componentLayout.removeView(localCoverView);
        i += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("WebViewContainer", 1, "", localThrowable);
        continue;
        if ((localThrowable instanceof CoverLiveView))
        {
          ((CoverLiveView)localThrowable).release();
          this.componentLayout.removeView(localThrowable);
        }
        else if ((localThrowable instanceof CoverPusherView))
        {
          ((CoverPusherView)localThrowable).release();
          this.componentLayout.removeView(localThrowable);
        }
      }
      label215:
      int i = 0;
      Object localObject;
      while (i < this.mCoverViewSparseArray.size())
      {
        localObject = (FrameLayout)this.mCoverViewSparseArray.valueAt(i);
        if ((localObject instanceof CoverCameraView)) {
          ((CoverCameraView)localObject).closeCamera();
        }
        i += 1;
      }
      this.mCoverViewSparseArray.clear();
      i = j;
      while (i < this.mapContextArray.size())
      {
        localObject = (MapContext)this.mapContextArray.valueAt(i);
        if (localObject != null) {
          ((MapContext)localObject).destroy();
        }
        i += 1;
      }
      this.mapContextArray.clear();
      if (this.innerWebView != null)
      {
        this.componentLayout.removeView(this.innerWebView);
        this.appBrandRuntime.webviewPool.recycleWebview(this.innerWebView, getContext());
      }
      this.componentLayout.removeAllViews();
    }
  }
  
  public void drawCanvas(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray, String paramString, int paramInt2)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (!(localCoverView instanceof CanvasView))
    {
      QLog.e("WebViewContainer", 2, "updateCanvas failed! appCanvas return null! canvasId: " + paramInt1);
      callbackJsEventFail(paramString, null, paramInt2);
      return;
    }
    paramJSONArray = new CanvasView.DrawActionCommand(paramBoolean1, paramJSONArray, paramBoolean2);
    ((CanvasView)localCoverView).addDrawActionCommand(paramJSONArray);
  }
  
  public void getImageData(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (!(localCoverView instanceof CanvasView))
    {
      callbackJsEventFail(paramString, null, paramInt2);
      return;
    }
    ((CanvasView)localCoverView).getImageData(paramString, paramJSONObject, paramInt2);
  }
  
  public MapContext getMapContext(int paramInt)
  {
    return (MapContext)this.mapContextArray.get(paramInt);
  }
  
  public FrameLayout getNativeViewLayout()
  {
    return this.componentLayout;
  }
  
  public String getPageOrientation()
  {
    return this.pageOrientation;
  }
  
  public PageWebview getPageWebview()
  {
    return this.pageWebview;
  }
  
  public MiniAppTextArea getTextArea(int paramInt)
  {
    if ((this.appTextAreaSparseArray != null) && (this.appTextAreaSparseArray.size() > 0))
    {
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
      if (localMiniAppTextArea != null) {
        return localMiniAppTextArea;
      }
    }
    return null;
  }
  
  public boolean handleBackPressed()
  {
    boolean bool = false;
    if ((this.innerWebView != null) && (this.innerWebView.canGoBack()))
    {
      this.innerWebView.goBack();
      bool = true;
    }
    do
    {
      return bool;
      int i = 0;
      while (i < this.mCoverViewSparseArray.size())
      {
        CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.valueAt(i);
        if ((localCoverView instanceof CoverVideoView))
        {
          if (((CoverVideoView)localCoverView).isFullScreen())
          {
            ((CoverVideoView)localCoverView).smallScreen();
            return true;
          }
        }
        else if (((localCoverView instanceof CoverLiveView)) && (((CoverLiveView)localCoverView).isFullScreen()))
        {
          ((CoverLiveView)localCoverView).smallScreen();
          return true;
        }
        i += 1;
      }
    } while (!getPageWebview().handleBackPressed());
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void hideLoading()
  {
    AppBrandTask.runTaskOnUiThread(new WebviewContainer.5(this));
  }
  
  public void init(String paramString)
  {
    this.pageInfo = this.apkgInfo.mAppConfigInfo.getPageInfo(paramString);
    paramString = this.pageInfo.windowInfo.enablePullDownRefresh;
    boolean bool;
    label60:
    int i;
    if (paramString == null)
    {
      bool = this.enableRefresh;
      this.enableRefresh = bool;
      paramString = this.pageInfo.windowInfo.disableScroll;
      if (paramString != null) {
        break label241;
      }
      bool = this.disableScroll;
      this.disableScroll = bool;
      paramString = this.pageInfo.windowInfo.pageOrientation;
      if (!TextUtils.isEmpty(paramString)) {
        this.pageOrientation = paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebViewContainer", 2, "init enableRefresh " + this.enableRefresh + "; disableScroll : " + this.disableScroll + "; pageOrientation : " + this.pageOrientation);
      }
      this.swipeRefreshLayout.setEnabled(this.enableRefresh);
      if ((this.appBrandRuntime != null) && (this.appBrandRuntime.activity != null) && (!this.appBrandRuntime.activity.isFinishing()))
      {
        i = 1;
        if (!WindowInfo.ORIENTATION_AUTO.equals(this.pageOrientation)) {
          break label249;
        }
        i = 4;
      }
    }
    for (;;)
    {
      if (this.appBrandRuntime.activity.getRequestedOrientation() != i) {
        this.appBrandRuntime.activity.setRequestedOrientation(i);
      }
      return;
      bool = paramString.booleanValue();
      break;
      label241:
      bool = paramString.booleanValue();
      break label60;
      label249:
      if (WindowInfo.ORIENTATION_LANDSCAPE.equals(this.pageOrientation)) {
        i = 0;
      }
    }
  }
  
  public void insertCamera(int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, CameraSurfaceView.CameraSurfaceViewCallBack paramCameraSurfaceViewCallBack, String paramString2, boolean paramBoolean, String paramString3)
  {
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (localObject == null)
    {
      localObject = new CoverCameraView(getContext(), this);
      ((CoverCameraView)localObject).setParentId(paramInt2);
      ((CoverCameraView)localObject).setFixed(paramBoolean);
      ((CoverCameraView)localObject).setCameraId(paramInt1);
      this.mCoverViewSparseArray.put(paramInt1, localObject);
      if (paramInt2 != 0) {
        ((FrameLayout)this.mCoverViewSparseArray.get(paramInt2)).addView((View)localObject);
      }
    }
    for (;;)
    {
      if ((localObject instanceof CoverCameraView))
      {
        ((CoverCameraView)localObject).setMode(paramString3);
        ((CoverCameraView)localObject).setFlashMode(paramString2);
        ((CoverCameraView)localObject).setCameraSurfaceCallBack(paramCameraSurfaceViewCallBack);
        ((CoverCameraView)localObject).openCamera(paramString1);
        paramInt1 = (int)(this.density * paramInt5 + 0.5F);
        paramInt2 = (int)(this.density * paramInt6 + 0.5F);
        paramInt3 = (int)(this.density * paramInt3 + 0.5F);
        paramInt4 = (int)(this.density * paramInt4 + 0.5F);
        ((CoverCameraView)localObject).setCameraWidth(paramInt1);
        ((CoverCameraView)localObject).setCameraHeight(paramInt2);
        paramString1 = new FrameLayout.LayoutParams(paramInt1, paramInt2);
        paramString1.leftMargin = paramInt3;
        paramString1.topMargin = paramInt4;
        ((CoverCameraView)localObject).setLayoutParams(paramString1);
      }
      return;
      if (paramBoolean) {
        addView((View)localObject);
      } else {
        this.componentLayout.addView((View)localObject);
      }
    }
  }
  
  public void insertCanvas(int paramInt1, int paramInt2, JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2, Boolean paramBoolean, boolean paramBoolean3)
  {
    int i = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
    int j = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
    int k = this.pageWebview.getMeasuredHeight();
    if (QLog.isColorLevel()) {
      QLog.i("WebViewContainer", 2, "insertCanvas currentWebview.getMeasuredHeight: " + k + "---canvas height----" + paramJSONObject.optInt("height") + "---" + j + "---canvasId---" + paramInt1);
    }
    k = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
    int m = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    paramJSONObject = localCoverView;
    if (localCoverView == null)
    {
      paramJSONObject = new CanvasView(getContext(), this, this.appBrandRuntime.apkgInfo, paramString, paramInt1, paramBoolean2, paramBoolean, paramBoolean3);
      this.mCoverViewSparseArray.put(paramInt1, paramJSONObject);
      this.componentLayout.addView(paramJSONObject);
      paramJSONObject.setParentId(paramInt2);
    }
    if ((paramJSONObject instanceof CanvasView))
    {
      paramJSONObject.setContentDescription("CanvasView " + paramInt1);
      if (paramBoolean1) {
        paramJSONObject.setVisibility(8);
      }
      paramString = new FrameLayout.LayoutParams(i, j);
      paramString.leftMargin = k;
      paramString.topMargin = m;
      paramJSONObject.setLayoutParams(paramString);
    }
  }
  
  public boolean insertHTMLWebView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "insertHTMLWebView htmlId=" + paramInt1 + ",innerWebView=" + this.innerWebView);
    }
    if (this.innerWebView != null) {
      return false;
    }
    int i = (int)(this.density * paramInt4 + 0.5F);
    paramInt4 = (int)(this.density * paramInt5 + 0.5F);
    paramInt5 = (int)(this.density * paramInt2 + 0.5F);
    paramInt3 = (int)(this.density * paramInt3 + 0.5F);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "insertHTMLWebView htmlId=" + paramInt1 + ",left=" + paramInt5 + ",top=" + paramInt3 + ",w=" + i + ",h=" + paramInt4);
    }
    paramInt2 = paramInt4;
    if (this.appBrandRuntime != null)
    {
      paramInt2 = paramInt4;
      if (this.appBrandRuntime.pageContainer != null)
      {
        paramInt2 = paramInt4;
        if (this.appBrandRuntime.pageContainer.getCurrentPage() != null)
        {
          paramInt2 = paramInt4;
          if (this.appBrandRuntime.pageContainer.getCurrentPage().getNavBar() != null)
          {
            paramInt2 = paramInt4;
            if (this.appBrandRuntime.pageContainer.getCurrentPage().getNavBar().getNavbarStyle().equals("custom"))
            {
              paramInt2 = paramInt4 - (bajq.b(44.0F) + ImmersiveUtils.getStatusBarHeight(getContext()));
              this.appBrandRuntime.pageContainer.getCurrentPage().updateViewStyle("default");
              this.appBrandRuntime.pageContainer.getCurrentPage().getNavBar().setBarStyle("default");
            }
          }
        }
      }
    }
    if ((this.appBrandRuntime != null) && (this.appBrandRuntime.activity != null))
    {
      QLog.d("WebViewContainer", 1, "create ProgressWebView with activity");
      this.innerWebView = new ProgressWebView(this.appBrandRuntime.activity);
      this.innerWebView.htmlId = paramInt1;
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, paramInt2);
      localLayoutParams.leftMargin = paramInt5;
      localLayoutParams.topMargin = paramInt3;
      this.innerWebView.setVisibility(8);
      this.componentLayout.addView(this.innerWebView, localLayoutParams);
      return true;
    }
    QLog.d("WebViewContainer", 1, "create ProgressWebView fail, no activity");
    return false;
  }
  
  public void insertImageView(JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2, boolean paramBoolean1)
  {
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt2);
    CoverImageView localCoverImageView;
    if (localObject == null)
    {
      localCoverImageView = new CoverImageView(getContext());
      localCoverImageView.setContentDescription(paramInt2 + "_" + paramInt1);
      ((CoverImageView)localCoverImageView).setParentId(paramInt1);
      ((CoverImageView)localCoverImageView).setFixed(paramBoolean1);
      this.mCoverViewSparseArray.put(paramInt2, localCoverImageView);
      if (paramInt1 == 0) {
        if (paramBoolean1)
        {
          addView(localCoverImageView);
          localObject = localCoverImageView;
        }
      }
    }
    for (;;)
    {
      getHeight();
      int i;
      int j;
      if ((localObject instanceof CoverImageView))
      {
        paramInt2 = 0;
        paramInt1 = 0;
        if (paramJSONObject1 != null)
        {
          i = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
          j = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
          paramInt1 = (int)(this.density * paramJSONObject1.optInt("left") + 0.5F);
          paramInt2 = (int)(this.density * paramJSONObject1.optInt("top") + 0.5F);
          paramJSONObject1 = new FrameLayout.LayoutParams(i, j);
          paramJSONObject1.leftMargin = paramInt1;
          paramJSONObject1.topMargin = paramInt2;
          ((CoverView)localObject).setLayoutParams(paramJSONObject1);
          paramInt1 = j;
          paramInt2 = i;
          if (paramJSONObject2 != null)
          {
            int k = paramJSONObject2.optInt("rotate");
            paramInt1 = j;
            paramInt2 = i;
            if (k != 0)
            {
              ((CoverView)localObject).setPivotX(i / 2);
              ((CoverView)localObject).setPivotY(j / 2);
              ((CoverView)localObject).setRotation(k);
              paramInt2 = i;
              paramInt1 = j;
            }
          }
        }
        if (paramJSONObject2 != null)
        {
          j = 0;
          i = j;
          if (paramJSONObject2.has("bgColor"))
          {
            paramJSONObject1 = getActualColor(paramJSONObject2.optString("bgColor"));
            i = j;
            if (TextUtils.isEmpty(paramJSONObject1)) {}
          }
        }
      }
      try
      {
        i = Color.parseColor(paramJSONObject1);
        ((CoverView)localObject).setBackgroundColor(i);
        ((CoverView)localObject).setAlpha((float)paramJSONObject2.optDouble("opacity", 0.0D));
        paramJSONObject1 = paramJSONObject2.optJSONArray("padding");
        if ((paramJSONObject1 != null) && (paramJSONObject1.length() == 4)) {
          ((CoverView)localObject).setPadding(paramJSONObject1.optInt(3, 0), paramJSONObject1.optInt(0, 0), paramJSONObject1.optInt(1, 0), paramJSONObject1.optInt(2, 0));
        }
        ((CoverView)localObject).setBorderRadius((float)paramJSONObject2.optDouble("borderRadius", 0.0D) * this.density);
        if ((baip.a(paramString2)) || ((paramString2.startsWith("http")) || (paramString2.startsWith("https"))))
        {
          try
          {
            paramJSONObject1 = URLDrawable.URLDrawableOptions.obtain();
            paramJSONObject1.mRequestWidth = paramInt2;
            paramJSONObject1.mRequestHeight = paramInt1;
            paramJSONObject1 = URLDrawable.getDrawable(URLDecoder.decode(paramString2), paramJSONObject1);
            if (paramJSONObject1 != null) {
              ((CoverImageView)localObject).setImageDrawable(paramJSONObject1);
            }
          }
          catch (Throwable paramJSONObject1)
          {
            for (;;)
            {
              CoverView localCoverView;
              QLog.e("WebViewContainer", 1, "URLDrawable error.", paramJSONObject1);
            }
          }
          if (paramBoolean != null) {
            ((CoverImageView)localObject).setClickable(paramBoolean.booleanValue());
          }
          ((CoverImageView)localObject).setOnClickListener(new WebviewContainer.3(this, paramString1));
          return;
          this.componentLayout.addView(localCoverImageView);
          localObject = localCoverImageView;
          continue;
          localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
          localObject = localCoverImageView;
          if (localCoverView == null) {
            continue;
          }
          localCoverView.addView(localCoverImageView);
          localObject = localCoverImageView;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("WebViewContainer", "insertImageView: failed to parse color " + paramJSONObject1, localException);
          i = j;
          continue;
          paramJSONObject1 = MiniAppFileManager.getInstance().getAbsolutePath(paramString2);
          if (!baip.a(paramJSONObject1)) {
            try
            {
              paramJSONObject1 = ImageUtil.getLocalBitmap(paramJSONObject1);
              if (paramJSONObject1 != null) {
                ((CoverImageView)localObject).setImageBitmap(paramJSONObject1);
              }
            }
            catch (Throwable paramJSONObject1)
            {
              QLog.e("WebViewContainer", 1, new Object[] { "getLocalBitmap error.", Log.getStackTraceString(paramJSONObject1) });
            }
          }
        }
      }
    }
  }
  
  public void insertLivePlayer(int paramInt, JSONObject paramJSONObject)
  {
    Log.i("WebViewContainer", "insertLivePlayer: " + paramJSONObject);
    Object localObject2 = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverLiveView(getContext());
      ((CoverLiveView)localObject1).setAtyRef(new WeakReference(this.appBrandRuntime.activity));
      ((CoverLiveView)localObject1).setData(paramJSONObject.optString("data"));
      ((CoverLiveView)localObject1).setServiceWebview(this.appBrandRuntime.serviceRuntime);
      ((CoverLiveView)localObject1).setPageWebviewId(this.pageWebview.pageWebviewId);
      ((CoverLiveView)localObject1).setLivePlayerId(paramInt);
      this.mCoverViewSparseArray.put(paramInt, localObject1);
      this.componentLayout.addView((View)localObject1);
    }
    if ((localObject1 instanceof CoverLiveView))
    {
      localObject1 = (CoverLiveView)localObject1;
      ((CoverLiveView)localObject1).initLivePlayerSettings(paramJSONObject);
      ((CoverLiveView)localObject1).setWebviewContainer(this);
      localObject2 = paramJSONObject.optJSONObject("position");
      if (localObject2 != null)
      {
        int j = ((JSONObject)localObject2).optInt("left");
        paramInt = ((JSONObject)localObject2).optInt("top");
        int i = ((JSONObject)localObject2).optInt("width");
        int k = ((JSONObject)localObject2).optInt("height");
        float f = this.density;
        i = (int)(i * f + 0.5F);
        f = this.density;
        k = (int)(k * f + 0.5F);
        f = this.density;
        j = (int)(j * f + 0.5F);
        f = this.density;
        paramInt = (int)(paramInt * f + 0.5F);
        localObject2 = new FrameLayout.LayoutParams(i, k);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt;
        ((CoverLiveView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (paramJSONObject.optBoolean("hide")) {
        ((CoverLiveView)localObject1).setVisibility(8);
      }
    }
  }
  
  public void insertLivePusher(int paramInt, JSONObject paramJSONObject)
  {
    Log.i("WebViewContainer", "insertLivePusher: " + paramJSONObject);
    Object localObject2 = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverPusherView(getContext());
      ((CoverPusherView)localObject1).setAtyRef(new WeakReference(this.appBrandRuntime.activity));
      ((CoverPusherView)localObject1).setData(paramJSONObject.optString("data"));
      ((CoverPusherView)localObject1).setServiceWebview(this.appBrandRuntime.serviceRuntime);
      ((CoverPusherView)localObject1).setPageWebviewId(this.pageWebview.pageWebviewId);
      ((CoverPusherView)localObject1).setLivePusherId(paramInt);
      this.mCoverViewSparseArray.put(paramInt, localObject1);
      this.componentLayout.addView((View)localObject1);
    }
    if ((localObject1 instanceof CoverPusherView))
    {
      localObject1 = (CoverPusherView)localObject1;
      ((CoverPusherView)localObject1).setWebviewContainer(this);
      ((CoverPusherView)localObject1).initLivePusherSettings(paramJSONObject);
      localObject2 = paramJSONObject.optJSONObject("position");
      if (localObject2 != null)
      {
        int j = ((JSONObject)localObject2).optInt("left");
        paramInt = ((JSONObject)localObject2).optInt("top");
        int i = ((JSONObject)localObject2).optInt("width");
        int k = ((JSONObject)localObject2).optInt("height");
        float f = this.density;
        i = (int)(i * f + 0.5F);
        f = this.density;
        k = (int)(k * f + 0.5F);
        f = this.density;
        j = (int)(j * f + 0.5F);
        f = this.density;
        paramInt = (int)(paramInt * f + 0.5F);
        localObject2 = new FrameLayout.LayoutParams(i, k);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject2).topMargin = paramInt;
        ((CoverPusherView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if (paramJSONObject.optBoolean("hide")) {
        ((CoverPusherView)localObject1).setVisibility(8);
      }
    }
  }
  
  public void insertMap(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = (MapContext)this.mapContextArray.get(paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "insertMapView mapId=" + paramInt1 + ",mapContext=" + localObject);
    }
    if (localObject != null) {}
    label280:
    for (;;)
    {
      return;
      localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
      if (localObject == null) {
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          localObject = new TencentMapOptions();
          ((TencentMapOptions)localObject).setSubInfo(paramString1, paramString2);
          paramString1 = new CoverMapView(getContext(), (TencentMapOptions)localObject);
          paramString1.setContentDescription(paramInt1 + "_" + paramInt2);
          paramString1.setParentId(paramInt2);
          this.mCoverViewSparseArray.put(paramInt1, paramString1);
          if (paramInt2 != 0) {
            break label249;
          }
          this.componentLayout.addView(paramString1);
        }
      }
      for (;;)
      {
        if (!(paramString1 instanceof CoverMapView)) {
          break label280;
        }
        paramString2 = new MapContext(this.pageWebview, this.appBrandRuntime.serviceRuntime, (CoverMapView)paramString1, paramInt1, this.apkgInfo);
        this.mapContextArray.put(paramInt1, paramString2);
        paramString1.setTag("MiniAppMapTag");
        return;
        paramString1 = new CoverMapView(getContext());
        break;
        label249:
        paramString2 = (CoverView)this.mCoverViewSparseArray.get(paramInt2);
        if (paramString2 != null) {
          paramString2.addView(paramString1);
        }
        continue;
        paramString1 = (String)localObject;
      }
    }
  }
  
  public void insertScrollView(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    String str = paramJSONObject.optString("data");
    boolean bool1 = paramJSONObject.optBoolean("gesture");
    boolean bool2 = paramJSONObject.optBoolean("fixed", false);
    Object localObject2 = (CoverView)this.mCoverViewSparseArray.get(i);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverScrollView(getContext());
      ((CoverView)localObject1).setData(str, bool1, this);
      ((CoverView)localObject1).setContentDescription(i + "_" + j);
      ((CoverScrollView)localObject1).setParentId(j);
      ((CoverScrollView)localObject1).setFixed(bool2);
      this.mCoverViewSparseArray.put(i, localObject1);
      if (j == 0) {
        break label195;
      }
      localObject2 = (FrameLayout)this.mCoverViewSparseArray.get(j);
      if (localObject2 != null) {
        ((FrameLayout)localObject2).addView((View)localObject1);
      }
    }
    for (;;)
    {
      if ((localObject1 instanceof CoverScrollView)) {
        updateScrollView(paramJSONObject, (CoverScrollView)localObject1);
      }
      return;
      label195:
      if (bool2) {
        addView((View)localObject1);
      } else {
        this.componentLayout.addView((View)localObject1);
      }
    }
  }
  
  public void insertTextArea(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject2 = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    int i = paramJSONObject.optInt("parentId");
    boolean bool = paramJSONObject.optBoolean("fixed", false);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new MiniAppTextArea(getContext());
      ((MiniAppTextArea)localObject1).setFixed(bool);
      this.appTextAreaSparseArray.put(paramInt, localObject1);
      if (i == 0) {
        break label114;
      }
      localObject2 = (FrameLayout)this.mCoverViewSparseArray.get(i);
      if (localObject2 != null)
      {
        ((FrameLayout)localObject2).addView((View)localObject1);
        ((MiniAppTextArea)localObject1).setParentId(i);
      }
    }
    for (;;)
    {
      ((MiniAppTextArea)localObject1).setAttributes(paramInt, paramJSONObject, this);
      return;
      label114:
      if (bool) {
        addView((View)localObject1);
      } else {
        this.componentLayout.addView((View)localObject1);
      }
    }
  }
  
  public void insertTextView(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    String str = paramJSONObject.optString("data");
    boolean bool1 = paramJSONObject.optBoolean("gesture");
    boolean bool2 = paramJSONObject.optBoolean("fixed", false);
    Object localObject2 = (CoverView)this.mCoverViewSparseArray.get(i);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverTextView(getContext());
      ((CoverView)localObject1).setData(str, bool1, this);
      ((CoverView)localObject1).setContentDescription(i + "_" + j);
      ((CoverTextView)localObject1).setParentId(j);
      ((CoverTextView)localObject1).setFixed(bool2);
      this.mCoverViewSparseArray.put(i, localObject1);
      if (j == 0) {
        break label195;
      }
      localObject2 = (FrameLayout)this.mCoverViewSparseArray.get(j);
      if (localObject2 != null) {
        ((FrameLayout)localObject2).addView((View)localObject1);
      }
    }
    for (;;)
    {
      if ((localObject1 instanceof CoverTextView)) {
        updateTextView((CoverTextView)localObject1, paramJSONObject);
      }
      return;
      label195:
      if (bool2) {
        addView((View)localObject1);
      } else {
        this.componentLayout.addView((View)localObject1);
      }
    }
  }
  
  public void insertVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    Log.i("WebViewContainer", "insertVideoPlayer: " + paramJSONObject);
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (localObject == null)
    {
      localObject = new CoverVideoView(getContext());
      ((CoverVideoView)localObject).setAtyRef(new WeakReference(this.appBrandRuntime.activity));
      ((CoverVideoView)localObject).setData(paramJSONObject.optString("data"));
      ((CoverVideoView)localObject).setServiceWebview(this.appBrandRuntime.serviceRuntime);
      ((CoverVideoView)localObject).setPageWebviewId(this.pageWebview.pageWebviewId);
      ((CoverVideoView)localObject).setVideoPlayerId(paramInt);
      MiniAppStateManager.getInstance().addObserver(((CoverVideoView)localObject).getVideoPlayerStatusObserver());
      this.mCoverViewSparseArray.put(paramInt, localObject);
      this.componentLayout.addView((View)localObject);
    }
    for (;;)
    {
      if ((localObject instanceof CoverVideoView))
      {
        ((CoverVideoView)localObject).setWebviewContainer(this);
        ((CoverVideoView)localObject).initVideoPlayerSettings(paramJSONObject);
      }
      return;
    }
  }
  
  public boolean isCustomNavibar()
  {
    return this.pageInfo.windowInfo.navigationBarInfo.style.equals("custom");
  }
  
  public void notifyChangePullDownRefreshStyle()
  {
    this.swipeRefreshLayout.setProgressBackgroundColorSchemeColor(this.appBrandRuntime.pageContainer.refreshStyleColor);
    if (this.appBrandRuntime.pageContainer.refreshStyleColor == -1)
    {
      this.swipeRefreshLayout.setColorSchemeColors(new int[] { -16777216 });
      return;
    }
    this.swipeRefreshLayout.setColorSchemeColors(new int[] { -1 });
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
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onRefresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "onRefresh");
    }
    this.appBrandRuntime.evaluateServiceSubcribeJS("onPullDownRefresh", "{}", this.pageWebview.pageWebviewId);
  }
  
  public void operateCamera(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("cameraId");
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(i);
    if (!(localCoverView instanceof CoverCameraView)) {
      callbackJsEventFail(paramString, null, paramInt);
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if (!paramString.equals("operateCamera")) {
            break;
          }
          str = paramJSONObject.optString("type");
          if ("takePhoto".equals(str))
          {
            ((CoverCameraView)localCoverView).takePhoto(this, paramString, paramInt, paramJSONObject.optString("quality"));
            return;
          }
          if ("startRecord".equals(str))
          {
            ((CoverCameraView)localCoverView).startRecord(this, paramString, paramInt);
            return;
          }
        } while (!"stopRecord".equals(str));
        ((CoverCameraView)localCoverView).stopRecord(this, paramString, paramInt);
        return;
        if (!paramString.equals("updateCamera")) {
          break;
        }
        str = paramJSONObject.optString("devicePosition");
        paramString = paramJSONObject.optString("flash");
        if (paramString.equals("on")) {
          paramString = "on";
        }
        while ("front".equalsIgnoreCase(str))
        {
          ((CoverCameraView)localCoverView).switchCamera(this, false, paramString);
          return;
          if (paramString.equals("auto")) {
            paramString = "auto";
          } else {
            paramString = "off";
          }
        }
      } while (!"back".equalsIgnoreCase(str));
      ((CoverCameraView)localCoverView).switchCamera(this, true, paramString);
      return;
    } while (!paramString.equals("removeCamera"));
    ((CoverCameraView)localCoverView).closeCamera();
    this.mCoverViewSparseArray.delete(i);
    removeCoverChildView(i);
    i = ((CoverCameraView)localCoverView).getParentId();
    if (i == 0) {
      this.componentLayout.removeView(localCoverView);
    }
    for (;;)
    {
      callbackJsEventOK(paramString, null, paramInt);
      return;
      ((FrameLayout)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
    }
  }
  
  public void operateLivePlayer(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (!(localCoverView instanceof CoverLiveView)) {
      return;
    }
    ((CoverLiveView)localCoverView).operateLivePlayer(paramString, paramInt2, paramJSONObject);
  }
  
  public void operateLivePusher(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (!(localCoverView instanceof CoverPusherView)) {
      return;
    }
    ((CoverPusherView)localCoverView).operateLivePusher(paramString, paramInt2, paramJSONObject);
  }
  
  public void operateVideoPlayer(int paramInt, String paramString1, String paramString2)
  {
    int i = 0;
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {
      return;
    }
    if ("play".equals(paramString1)) {
      ((CoverVideoView)localCoverView).playWithUi();
    }
    JSONArray localJSONArray;
    do
    {
      for (;;)
      {
        callbackJsEventOK(paramString1, null, paramInt);
        return;
        if ("pause".equals(paramString1))
        {
          ((CoverVideoView)localCoverView).pauseWithUi();
        }
        else if ("stop".equals(paramString1))
        {
          ((CoverVideoView)localCoverView).stop();
        }
        else if (("seek".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          try
          {
            localJSONArray = new JSONArray(paramString2);
            if (localJSONArray.length() == 1)
            {
              i = (int)(localJSONArray.getDouble(0) * 1000.0D);
              bool = ((CoverVideoView)localCoverView).seekTo(i);
              if (bool) {
                continue;
              }
              callbackJsEventFail(paramString1, null, paramInt);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("WebViewContainer", 2, "wrong seek pram. " + paramString2);
              boolean bool = false;
            }
          }
        }
        else if (("playbackRate".equals(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          QLog.e("WebViewContainer", 2, "playbackRate is not support.");
        }
        else if ("requestFullScreen".equals(paramString1))
        {
          if (!((CoverVideoView)localException).isFullScreen()) {
            ((CoverVideoView)localException).fullScreen();
          }
        }
        else
        {
          if (!"exitFullScreen".equals(paramString1)) {
            break;
          }
          if (((CoverVideoView)localException).isFullScreen()) {
            ((CoverVideoView)localException).smallScreen();
          }
        }
      }
    } while (!"sendDanmu".equals(paramString1));
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray(paramString2);
        if (localJSONArray.length() != 2) {
          break label396;
        }
        paramString2 = localJSONArray.getString(0);
        i = ColorUtil.parseColor(localJSONArray.getString(1));
        ((CoverVideoView)localException).playDanmu(paramString2, i);
      }
      catch (Exception paramString2)
      {
        QLog.e("WebViewContainer", 1, "sendDanmu error." + paramString2);
        callbackJsEventFail(paramString1, null, paramInt);
      }
      break;
      label396:
      if (localJSONArray.length() == 1) {
        paramString2 = localJSONArray.getString(0);
      } else {
        paramString2 = null;
      }
    }
  }
  
  public void putImageData(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (!(localCoverView instanceof CanvasView))
    {
      callbackJsEventFail(paramString, null, paramInt2);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("method", paramString);
      localJSONObject.put("data", paramJSONObject);
      localJSONObject.put("callbackId", paramInt2);
      localJSONArray.put(localJSONObject);
      paramString = new CanvasView.DrawActionCommand(true, localJSONArray, false);
      ((CanvasView)localCoverView).addDrawActionCommand(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void removeCanvas(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void removeHTMLWebView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "removeHTMLWebView htmlId=" + paramInt);
    }
    if ((this.innerWebView == null) || (this.innerWebView.htmlId != paramInt)) {
      return;
    }
    this.innerWebView.loadUrl("about:blank");
    this.innerWebView.clearView();
    this.innerWebView.destroy();
    this.componentLayout.removeView(this.innerWebView);
    this.innerWebView = null;
  }
  
  public void removeImageView(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverImageView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void removeLivePlayer(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverLiveView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void removeLivePusher(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverPusherView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void removeScrollView(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverScrollView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void removeTextArea(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    if (localMiniAppTextArea == null) {
      return;
    }
    localMiniAppTextArea.removeLayoutListener();
    this.appTextAreaSparseArray.remove(paramInt);
    int i = localMiniAppTextArea.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localMiniAppTextArea);
      }
    }
    for (;;)
    {
      this.appTextAreaSparseArray.remove(paramInt);
      return;
      if (localMiniAppTextArea.isFixed()) {
        removeView(localMiniAppTextArea);
      } else {
        this.componentLayout.removeView(localMiniAppTextArea);
      }
    }
  }
  
  public void removeTextView(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverTextView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void removeVideoPlayer(int paramInt)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CoverVideoView)) {
      return;
    }
    removeCoverChildView(paramInt);
    int i = localCoverView.getParentId();
    if (i != 0) {
      if (this.mCoverViewSparseArray.get(i) != null) {
        ((CoverView)this.mCoverViewSparseArray.get(i)).removeView(localCoverView);
      }
    }
    for (;;)
    {
      this.mCoverViewSparseArray.remove(paramInt);
      return;
      if (localCoverView.isFixed()) {
        removeView(localCoverView);
      } else {
        this.componentLayout.removeView(localCoverView);
      }
    }
  }
  
  public void saveCanvasFile(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt1);
    if (!(localCoverView instanceof CanvasView))
    {
      callbackJsEventFail(paramString, null, paramInt2);
      return;
    }
    ((CanvasView)localCoverView).saveBitmap(this, getContext(), paramJSONObject, paramString, paramInt2);
  }
  
  public void setAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    this.appBrandRuntime = paramAppBrandRuntime;
    this.apkgInfo = paramAppBrandRuntime.apkgInfo;
    paramAppBrandRuntime = this.apkgInfo.getAppConfigInfo().globalPageInfo.windowInfo.enablePullDownRefresh;
    if (paramAppBrandRuntime == null) {}
    for (boolean bool = false;; bool = paramAppBrandRuntime.booleanValue())
    {
      this.enableRefresh = bool;
      this.pageOrientation = this.apkgInfo.getAppConfigInfo().globalPageInfo.windowInfo.pageOrientation;
      if (QLog.isColorLevel()) {
        QLog.d("WebViewContainer", 2, "setAppBrandRuntime enableRefresh " + this.enableRefresh + "; pageOrientation : " + this.pageOrientation);
      }
      notifyChangePullDownRefreshStyle();
      return;
    }
  }
  
  public void setDisablePullDownRefresh(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    boolean bool1;
    if ((this.enableRefresh) && (!this.swipeRefreshLayout.isRefreshing()))
    {
      localObject = this.swipeRefreshLayout;
      if (paramBoolean) {
        break label80;
      }
      bool1 = true;
      ((SwipeRefreshLayout)localObject).setEnabled(bool1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("setDisablePullDownRefresh !disable ");
        if (paramBoolean) {
          break label85;
        }
      }
    }
    label80:
    label85:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      QLog.d("WebViewContainer", 2, paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void setPageWebview(PageWebview paramPageWebview)
  {
    QLog.d("WebViewContainer", 2, "setPageWebview enableRefresh " + this.enableRefresh + "; disableScroll : " + this.disableScroll);
    this.pageWebview = paramPageWebview;
    if (this.disableScroll)
    {
      paramPageWebview.setVerticalScrollBarEnabled(false);
      paramPageWebview.setHorizontalScrollBarEnabled(false);
      if ((paramPageWebview.getView() != null) && (paramPageWebview.getView().getViewTreeObserver() != null) && (paramPageWebview.getView().getViewTreeObserver().isAlive())) {
        paramPageWebview.getView().getViewTreeObserver().addOnScrollChangedListener(new WebviewContainer.1(this, paramPageWebview));
      }
    }
    paramPageWebview.setOnWebviewScrollListener(new WebviewContainer.2(this));
    paramPageWebview.setContentDescription("");
    paramPageWebview.addView(this, this.componentLayout, new FrameLayout.LayoutParams(-1, -1));
    this.swipeRefreshLayout.addView(paramPageWebview, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void showLoading(String paramString)
  {
    AppBrandTask.runTaskOnUiThread(new WebviewContainer.4(this, paramString));
  }
  
  public void startPullDownRefresh()
  {
    this.swipeRefreshLayout.setRefreshing(true);
    onRefresh();
  }
  
  public void stopPullDownRefresh()
  {
    if (this.swipeRefreshLayout.isRefreshing())
    {
      this.swipeRefreshLayout.setRefreshing(false);
      this.swipeRefreshLayout.setEnabled(this.enableRefresh);
    }
  }
  
  public void updateCanvas(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localCoverView instanceof CanvasView)) {
      QLog.e("WebViewContainer", 2, "updateCanvas failed! appCanvas return null! canvasId: " + paramInt);
    }
    for (;;)
    {
      return;
      if (paramBoolean) {
        localCoverView.setVisibility(8);
      }
      while (paramJSONObject != null)
      {
        paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
        int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
        int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
        int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
        paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
        paramJSONObject.leftMargin = j;
        paramJSONObject.topMargin = k;
        localCoverView.setLayoutParams(paramJSONObject);
        return;
        localCoverView.setVisibility(0);
      }
    }
  }
  
  public void updateHTMLWebView(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "updateHTMLWebView htmlId=" + paramInt + ",innerWebView=" + this.innerWebView + ",src=" + paramString);
    }
    if ((this.innerWebView == null) || (this.innerWebView.htmlId != paramInt) || (TextUtils.isEmpty(paramString)) || (this.appBrandRuntime == null)) {}
    for (;;)
    {
      return;
      if ((needCookieAppIdList != null) && (needCookieAppIdList.contains(this.appBrandRuntime.appId))) {
        setCookie(paramString);
      }
      this.innerWebView.init(this.appBrandRuntime);
      this.innerWebView.setVisibility(0);
      if (QLog.isDebugVersion())
      {
        String str = CookieManager.getInstance().getCookie(paramString);
        QLog.e("WebViewContainer", 1, "cookie : " + str);
      }
      this.innerWebView.loadUrl(paramString);
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebViewContainer", 2, "innerWebView.hasFocus() : " + this.innerWebView.hasFocus());
        }
        if (!this.innerWebView.hasFocus())
        {
          this.innerWebView.requestFocus();
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("WebViewContainer", 1, "innerWebView requestFocuserror,", paramString);
      }
    }
  }
  
  public void updateImageView(JSONObject paramJSONObject1, String paramString1, int paramInt, String paramString2, Boolean paramBoolean, JSONObject paramJSONObject2)
  {
    paramString1 = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    int i;
    if ((paramString1 instanceof CoverImageView))
    {
      int n = getHeight();
      Object localObject;
      if (paramJSONObject1 != null)
      {
        int j = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
        int k = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
        int m = (int)(this.density * paramJSONObject1.optInt("left") + 0.5F);
        i = (int)(this.density * paramJSONObject1.optInt("top") + 0.5F);
        paramInt = i;
        if (k + i > n) {
          paramInt = n - k;
        }
        localObject = new FrameLayout.LayoutParams(j, k);
        ((FrameLayout.LayoutParams)localObject).leftMargin = m;
        ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
        paramString1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (paramJSONObject2 != null)
      {
        paramString1.setAlpha((float)paramJSONObject2.optDouble("opacity", 0.0D));
        localObject = paramJSONObject2.optJSONArray("padding");
        if ((localObject != null) && (((JSONArray)localObject).length() == 4)) {
          paramString1.setPadding(((JSONArray)localObject).optInt(3, 0), ((JSONArray)localObject).optInt(0, 0), ((JSONArray)localObject).optInt(1, 0), ((JSONArray)localObject).optInt(2, 0));
        }
        paramString1.setBorderRadius((float)paramJSONObject2.optDouble("borderRadius", 0.0D) * this.density);
      }
      if ((!baip.a(paramString2)) && ((!paramString2.startsWith("http")) && (!paramString2.startsWith("https")))) {
        break label405;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject2 = URLDrawable.URLDrawableOptions.obtain();
        i = 0;
        paramInt = 0;
        if (paramJSONObject1 != null)
        {
          i = (int)(this.density * paramJSONObject1.optInt("width") + 0.5F);
          paramInt = (int)(this.density * paramJSONObject1.optInt("height") + 0.5F);
        }
        paramJSONObject2.mRequestWidth = i;
        paramJSONObject2.mRequestHeight = paramInt;
        paramJSONObject1 = URLDrawable.getDrawable(URLDecoder.decode(paramString2), paramJSONObject2);
        if (paramJSONObject1 != null) {
          ((CoverImageView)paramString1).setImageDrawable(paramJSONObject1);
        }
      }
      catch (Throwable paramJSONObject1)
      {
        QLog.e("WebViewContainer", 1, "URLDrawable error.", paramJSONObject1);
        continue;
      }
      if (paramBoolean != null) {
        ((CoverImageView)paramString1).setClickable(paramBoolean.booleanValue());
      }
      return;
      label405:
      paramJSONObject1 = MiniAppFileManager.getInstance().getAbsolutePath(paramString2);
      if (!baip.a(paramJSONObject1)) {
        try
        {
          paramJSONObject1 = ImageUtil.getLocalBitmap(paramJSONObject1);
          if (paramJSONObject1 != null) {
            ((CoverImageView)paramString1).setImageBitmap(paramJSONObject1);
          }
        }
        catch (Throwable paramJSONObject1)
        {
          QLog.e("WebViewContainer", 1, "getLocalBitmap error.", paramJSONObject1);
        }
      }
    }
  }
  
  public void updateLivePlayer(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localObject instanceof CoverLiveView)) {}
    do
    {
      do
      {
        return;
        localObject = (CoverLiveView)localObject;
      } while (((CoverLiveView)localObject).isFullScreen());
      ((CoverLiveView)localObject).updateLivePlayerSettings(paramJSONObject);
      paramJSONObject = paramJSONObject.optJSONObject("position");
    } while (paramJSONObject == null);
    int j = paramJSONObject.optInt("left");
    paramInt = paramJSONObject.optInt("top");
    int i = paramJSONObject.optInt("width");
    int k = paramJSONObject.optInt("height");
    float f = this.density;
    i = (int)(i * f + 0.5F);
    f = this.density;
    k = (int)(k * f + 0.5F);
    j = (int)(this.density * j + 0.5F);
    paramInt = (int)(this.density * paramInt + 0.5F);
    paramJSONObject = (FrameLayout.LayoutParams)((CoverLiveView)localObject).getLayoutParams();
    paramJSONObject.width = i;
    paramJSONObject.height = k;
    paramJSONObject.leftMargin = j;
    paramJSONObject.topMargin = paramInt;
    ((CoverLiveView)localObject).setLayoutParams(paramJSONObject);
  }
  
  public void updateLivePusher(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if (!(localObject instanceof CoverPusherView)) {}
    do
    {
      return;
      localObject = (CoverPusherView)localObject;
      ((CoverPusherView)localObject).updateLivePusherSettings(paramJSONObject);
      paramJSONObject = paramJSONObject.optJSONObject("position");
    } while (paramJSONObject == null);
    int j = paramJSONObject.optInt("left");
    paramInt = paramJSONObject.optInt("top");
    int i = paramJSONObject.optInt("width");
    int k = paramJSONObject.optInt("height");
    float f = this.density;
    i = (int)(i * f + 0.5F);
    f = this.density;
    k = (int)(k * f + 0.5F);
    j = (int)(this.density * j + 0.5F);
    paramInt = (int)(this.density * paramInt + 0.5F);
    paramJSONObject = (FrameLayout.LayoutParams)((CoverPusherView)localObject).getLayoutParams();
    paramJSONObject.width = i;
    paramJSONObject.height = k;
    paramJSONObject.leftMargin = j;
    paramJSONObject.topMargin = paramInt;
    ((CoverPusherView)localObject).setLayoutParams(paramJSONObject);
  }
  
  public void updateScrollView(JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramJSONObject.optInt("viewId"));
    if ((localCoverView instanceof CoverScrollView)) {
      updateScrollView(paramJSONObject, (CoverScrollView)localCoverView);
    }
  }
  
  public void updateTextArea(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.optInt("inputId");
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(i);
      if (localMiniAppTextArea == null) {
        return;
      }
      localMiniAppTextArea.updateAttributes(paramJSONObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("WebViewContainer", 1, "updateTextArea error.", paramJSONObject);
    }
  }
  
  public void updateTextView(JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramJSONObject.optInt("viewId"));
    if ((localCoverView instanceof CoverTextView)) {
      updateTextView((CoverTextView)localCoverView, paramJSONObject);
    }
  }
  
  public void updateVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    CoverView localCoverView = (CoverView)this.mCoverViewSparseArray.get(paramInt);
    if ((localCoverView instanceof CoverVideoView))
    {
      ((CoverVideoView)localCoverView).updateVideoPlayerSettings(paramJSONObject);
      paramJSONObject = paramJSONObject.optString("filePath");
      if (!baip.a(paramJSONObject)) {
        ((CoverVideoView)localCoverView).setVideoPath(paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.WebviewContainer
 * JD-Core Version:    0.7.0.1
 */