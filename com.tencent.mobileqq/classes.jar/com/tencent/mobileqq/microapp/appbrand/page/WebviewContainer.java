package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import bbkk;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.r;
import com.tencent.mobileqq.microapp.apkg.t;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.appbrand.utils.p;
import com.tencent.mobileqq.microapp.c.c;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.microapp.widget.CanvasView;
import com.tencent.mobileqq.microapp.widget.CoverImageView;
import com.tencent.mobileqq.microapp.widget.CoverView;
import com.tencent.mobileqq.microapp.widget.MapContext;
import com.tencent.mobileqq.microapp.widget.MiniAppTextArea;
import com.tencent.mobileqq.microapp.widget.d;
import com.tencent.mobileqq.microapp.widget.media.MiniAppCamera;
import com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebviewContainer
  extends FrameLayout
  implements SwipeRefreshLayout.OnRefreshListener, PageWebview.OnWebviewScrollListener
{
  public static final String TAG = "WebViewContainer";
  protected f apkgInfo;
  public com.tencent.mobileqq.microapp.appbrand.a appBrandRuntime;
  private SparseArray appTextAreaSparseArray = new SparseArray();
  private SparseArray cameraViewSparseArray = new SparseArray();
  private SparseArray canvasSparseArray = new SparseArray();
  private FrameLayout componentLayout;
  private MiniAppCamera currentCamera;
  protected float density;
  private SparseArray imageViewSparseArray = new SparseArray();
  private ProgressWebView innerWebView;
  private CanvasView mCurrCanvas;
  private SparseArray mTextViewSparseArray = new SparseArray();
  private SparseArray mapContextArray;
  private d miniAppFileView;
  protected r pageInfo;
  private PageWebview pageWebview;
  public SwipeRefreshLayout swipeRefreshLayout;
  private SparseArray videoPlayerSparseArray = new SparseArray();
  
  public WebviewContainer(Context paramContext, com.tencent.mobileqq.microapp.appbrand.a parama, f paramf, String paramString)
  {
    super(paramContext);
    this.density = DisplayUtil.getDensity(paramContext);
    this.appBrandRuntime = parama;
    this.apkgInfo = paramf;
    this.pageInfo = paramf.b.d(paramString);
    this.componentLayout = new FrameLayout(getContext());
    this.mapContextArray = new SparseArray();
    this.swipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.swipeRefreshLayout.setEnabled(this.pageInfo.a.d);
    this.swipeRefreshLayout.setOnRefreshListener(this);
    addView(this.swipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    notifyChangePullDownRefreshStyle();
  }
  
  private String getActualColor(String paramString)
  {
    if (bbkk.a(paramString)) {
      return "";
    }
    String str = paramString.substring(paramString.length() - 2);
    paramString = paramString.substring(1, paramString.length() - 2);
    return "#" + str + paramString;
  }
  
  private FrameLayout.LayoutParams getLayoutParams(int paramInt)
  {
    Object localObject = (MiniAppVideoPlayer)this.videoPlayerSparseArray.get(paramInt);
    if (localObject != null) {
      return (FrameLayout.LayoutParams)((MiniAppVideoPlayer)localObject).getLayoutParams();
    }
    localObject = (MiniAppCamera)this.cameraViewSparseArray.get(paramInt);
    if (localObject != null) {
      return (FrameLayout.LayoutParams)((MiniAppCamera)localObject).getLayoutParams();
    }
    localObject = (CanvasView)this.canvasSparseArray.get(paramInt);
    if (localObject != null) {
      return (FrameLayout.LayoutParams)((CanvasView)localObject).getLayoutParams();
    }
    localObject = (MapContext)this.mapContextArray.get(paramInt);
    if (localObject != null) {
      return (FrameLayout.LayoutParams)((MapContext)localObject).c.getLayoutParams();
    }
    localObject = (TextView)this.mTextViewSparseArray.get(paramInt);
    if (localObject != null) {
      return (FrameLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    }
    localObject = (ImageView)this.imageViewSparseArray.get(paramInt);
    if (localObject != null) {
      return (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    }
    return null;
  }
  
  private void removeCoverChildView(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      j = k;
      if (i >= this.mTextViewSparseArray.size()) {
        break;
      }
      j = this.mTextViewSparseArray.keyAt(i);
      localObject = (CoverView)this.mTextViewSparseArray.get(j);
      if ((localObject != null) && (((CoverView)localObject).a == paramInt))
      {
        removeCoverChildView(j);
        this.componentLayout.removeView((View)localObject);
      }
      i += 1;
    }
    while (j < this.imageViewSparseArray.size())
    {
      i = this.imageViewSparseArray.keyAt(j);
      localObject = (CoverImageView)this.imageViewSparseArray.get(i);
      if ((localObject != null) && (((CoverImageView)localObject).a == paramInt))
      {
        removeCoverChildView(i);
        this.componentLayout.removeView((View)localObject);
      }
      j += 1;
    }
  }
  
  public void addVidepPlayer(MiniAppVideoPlayer paramMiniAppVideoPlayer)
  {
    Object localObject = paramMiniAppVideoPlayer.o;
    int k = ((JSONObject)localObject).optInt("left");
    int i = ((JSONObject)localObject).optInt("top");
    int j = ((JSONObject)localObject).optInt("width");
    int m = ((JSONObject)localObject).optInt("height");
    float f = this.density;
    j = (int)(j * f + 0.5F);
    f = this.density;
    m = (int)(m * f + 0.5F);
    f = this.density;
    k = (int)(k * f + 0.5F);
    f = this.density;
    i = (int)(i * f + 0.5F);
    localObject = new FrameLayout.LayoutParams(j, m);
    ((FrameLayout.LayoutParams)localObject).leftMargin = k;
    ((FrameLayout.LayoutParams)localObject).topMargin = i;
    this.componentLayout.addView(paramMiniAppVideoPlayer, (ViewGroup.LayoutParams)localObject);
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.pageWebview != null)
    {
      paramString = com.tencent.mobileqq.microapp.b.a.b(paramString, paramJSONObject);
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
      paramString = com.tencent.mobileqq.microapp.b.a.a(paramString, paramJSONObject);
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
  
  public void destroy()
  {
    int j = 0;
    if (QLog.isDevelopLevel()) {
      QLog.i("WebViewContainer", 2, "-----destroy----");
    }
    if (this.pageWebview != null)
    {
      this.swipeRefreshLayout.removeView(this.pageWebview);
      this.pageWebview.destroy();
    }
    int i = 0;
    Object localObject;
    while (i < this.videoPlayerSparseArray.size())
    {
      localObject = (MiniAppVideoPlayer)this.videoPlayerSparseArray.valueAt(i);
      if (localObject != null)
      {
        ((MiniAppVideoPlayer)localObject).a();
        ((MiniAppVideoPlayer)localObject).d();
        b.a().deleteObserver(((MiniAppVideoPlayer)localObject).q);
        this.componentLayout.removeView((View)localObject);
      }
      i += 1;
    }
    this.videoPlayerSparseArray.clear();
    i = j;
    while (i < this.cameraViewSparseArray.size())
    {
      localObject = (MiniAppCamera)this.cameraViewSparseArray.valueAt(i);
      if (localObject != null)
      {
        ((MiniAppCamera)localObject).d();
        this.componentLayout.removeView((View)localObject);
      }
      i += 1;
    }
    this.cameraViewSparseArray.clear();
    this.imageViewSparseArray.clear();
    this.mapContextArray.clear();
    if (this.innerWebView != null)
    {
      this.componentLayout.removeView(this.innerWebView);
      p.a().a(this.innerWebView, getContext());
    }
  }
  
  public void drawCanvas(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, JSONArray paramJSONArray, String paramString, int paramInt2)
  {
    CanvasView localCanvasView = (CanvasView)this.canvasSparseArray.get(paramInt1);
    if (localCanvasView == null)
    {
      callbackJsEventFail(paramString, null, paramInt2);
      return;
    }
    localCanvasView.a = paramBoolean1;
    localCanvasView.b = paramJSONArray;
    localCanvasView.invalidate();
  }
  
  public MapContext getMapContext(int paramInt)
  {
    return (MapContext)this.mapContextArray.get(paramInt);
  }
  
  public PageWebview getPageWebview()
  {
    return this.pageWebview;
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
      while (i < this.videoPlayerSparseArray.size())
      {
        MiniAppVideoPlayer localMiniAppVideoPlayer = (MiniAppVideoPlayer)this.videoPlayerSparseArray.valueAt(i);
        if (localMiniAppVideoPlayer.p)
        {
          localMiniAppVideoPlayer.g();
          return true;
        }
        i += 1;
      }
    } while (this.miniAppFileView == null);
    this.miniAppFileView.a();
    this.miniAppFileView.a(this.componentLayout);
    this.miniAppFileView = null;
    return true;
  }
  
  public void insertCamera$6f1019db$e44775(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ApkgConfigManager.a parama)
  {
    MiniAppCamera localMiniAppCamera2 = (MiniAppCamera)this.cameraViewSparseArray.get(paramInt1);
    MiniAppCamera localMiniAppCamera1 = localMiniAppCamera2;
    if (localMiniAppCamera2 == null)
    {
      localMiniAppCamera1 = new MiniAppCamera(getContext(), this);
      this.cameraViewSparseArray.put(paramInt1, localMiniAppCamera1);
    }
    localMiniAppCamera1.a(parama);
    localMiniAppCamera1.c();
    paramInt1 = (int)(this.density * paramInt4 + 0.5F);
    paramInt4 = (int)(this.density * paramInt5 + 0.5F);
    paramInt2 = (int)(this.density * paramInt2 + 0.5F);
    paramInt3 = (int)(this.density * paramInt3 + 0.5F);
    MiniAppCamera.h = paramInt1;
    MiniAppCamera.i = paramInt4;
    parama = new FrameLayout.LayoutParams(paramInt1, paramInt4);
    parama.leftMargin = paramInt2;
    parama.topMargin = paramInt3;
    this.componentLayout.addView(localMiniAppCamera1, parama);
  }
  
  public void insertCanvas(int paramInt, JSONObject paramJSONObject, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
    int j = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
    int k = this.pageWebview.getMeasuredHeight();
    if (QLog.isColorLevel()) {
      QLog.i("WebViewContainer", 2, "insertCanvas currentWebview.getMeasuredHeight: " + k + "---canvas height----" + paramJSONObject.optInt("height") + "---" + j);
    }
    k = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
    int m = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
    CanvasView localCanvasView = (CanvasView)this.canvasSparseArray.get(paramInt);
    paramJSONObject = localCanvasView;
    if (localCanvasView == null)
    {
      paramJSONObject = new CanvasView(getContext(), this, this.appBrandRuntime.c, paramString, paramInt, paramBoolean2);
      this.canvasSparseArray.put(paramInt, paramJSONObject);
    }
    if (paramBoolean1) {
      paramJSONObject.setVisibility(8);
    }
    this.mCurrCanvas = paramJSONObject;
    paramString = new FrameLayout.LayoutParams(i, j);
    paramString.leftMargin = k;
    paramString.topMargin = m;
    this.componentLayout.addView(paramJSONObject, paramString);
  }
  
  public void insertFileView(File paramFile)
  {
    if (this.miniAppFileView == null)
    {
      this.miniAppFileView = new d(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getPageWebview().getWidth(), getPageWebview().getHeight());
      localLayoutParams.leftMargin = 0;
      localLayoutParams.topMargin = 0;
      this.miniAppFileView.a(this.componentLayout, localLayoutParams);
    }
    this.miniAppFileView.a(paramFile);
  }
  
  public void insertHTMLWebView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "insertHTMLWebView htmlId=" + paramInt1 + ",innerWebView=" + this.innerWebView);
    }
    if (this.innerWebView != null) {
      return;
    }
    paramInt4 = (int)(this.density * paramInt4 + 0.5F);
    paramInt5 = (int)(this.density * paramInt5 + 0.5F);
    paramInt2 = (int)(this.density * paramInt2 + 0.5F);
    paramInt3 = (int)(this.density * paramInt3 + 0.5F);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "insertHTMLWebView htmlId=" + paramInt1 + ",left=" + paramInt2 + ",top=" + paramInt3 + ",w=" + paramInt4 + ",h=" + paramInt5);
    }
    this.innerWebView = p.a().a(this.apkgInfo.d, paramInt1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    this.innerWebView.setVisibility(8);
    this.componentLayout.addView(this.innerWebView, localLayoutParams);
  }
  
  public void insertImageView(JSONObject paramJSONObject, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    Object localObject2 = (CoverImageView)this.imageViewSparseArray.get(paramInt2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverImageView(getContext());
      ((CoverImageView)localObject1).a = paramInt1;
      this.imageViewSparseArray.put(paramInt2, localObject1);
    }
    FrameLayout.LayoutParams localLayoutParams = getLayoutParams(paramInt1);
    localObject2 = localLayoutParams;
    if (localLayoutParams == null) {
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
    }
    if ((bbkk.a(paramString2)) || ((paramString2.startsWith("http")) || (paramString2.startsWith("https")))) {}
    for (;;)
    {
      try
      {
        paramString2 = URLDrawable.getDrawable(paramString2, null);
        if (paramString2 != null) {
          ((CoverImageView)localObject1).setImageDrawable(paramString2);
        }
      }
      catch (OutOfMemoryError paramString2)
      {
        int i;
        int j;
        paramString2.printStackTrace();
        continue;
      }
      ((CoverImageView)localObject1).setClickable(true);
      ((CoverImageView)localObject1).setOnClickListener(new WebviewContainer.2(this, paramString1));
      paramInt1 = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      paramInt2 = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      i = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      j = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramJSONObject.leftMargin = (((FrameLayout.LayoutParams)localObject2).leftMargin + i);
      paramJSONObject.topMargin = (((FrameLayout.LayoutParams)localObject2).topMargin + j);
      this.componentLayout.addView((View)localObject1, paramJSONObject);
      return;
      paramString2 = this.appBrandRuntime.c.j(paramString2);
      if (!bbkk.a(paramString2)) {
        ((CoverImageView)localObject1).setImageBitmap(com.tencent.mobileqq.microapp.b.a.i(paramString2));
      }
    }
  }
  
  public void insertMap(int paramInt)
  {
    Object localObject = (MapContext)this.mapContextArray.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "insertMapView mapId=" + paramInt + ",mapContext=" + localObject);
    }
    if (localObject != null) {
      return;
    }
    localObject = new QQMapView(getContext(), null);
    this.componentLayout.addView((View)localObject);
    localObject = new MapContext(this.pageWebview, this.appBrandRuntime.i, (QQMapView)localObject, paramInt, this.apkgInfo);
    this.mapContextArray.put(paramInt, localObject);
  }
  
  public void insertTextArea(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    paramString = paramJSONObject.optJSONObject("style");
    int i = (int)(this.density * paramString.optInt("width") + 0.5F);
    paramInt2 = (int)(this.density * paramString.optInt("height", paramString.optInt("minHeight")) + 0.5F);
    if (paramInt2 == 0) {
      paramInt2 = -2;
    }
    for (;;)
    {
      int j = (int)(this.density * paramString.optInt("left") + 0.5F);
      int k = (int)(this.density * paramString.optInt("top") + 0.5F);
      MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt1);
      paramString = localMiniAppTextArea;
      if (localMiniAppTextArea == null)
      {
        paramString = new MiniAppTextArea(getContext());
        this.appTextAreaSparseArray.put(paramInt1, paramString);
      }
      paramString.a(paramInt1, paramJSONObject, this);
      paramJSONObject = new FrameLayout.LayoutParams(i, paramInt2);
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = (k - getPageWebview().scrollY);
      this.componentLayout.addView(paramString, paramJSONObject);
      return;
    }
  }
  
  public void insertTextView(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("viewId");
    int j = paramJSONObject.optInt("parentId");
    Object localObject2 = (CoverView)this.mTextViewSparseArray.get(i);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new CoverView(getContext());
      ((CoverView)localObject1).a = j;
      ((CoverView)localObject1).setBackgroundColor(getResources().getColor(17170451));
      this.mTextViewSparseArray.put(i, localObject1);
    }
    Object localObject3 = getLayoutParams(paramJSONObject.optInt("parentId"));
    QLog.i("WebViewContainer", 2, "insertTextView layoutParams: " + localObject3);
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
    }
    localObject3 = paramJSONObject.optJSONObject("style");
    if ((localObject3 != null) && (!bbkk.a(getActualColor(((JSONObject)localObject3).optString("bgColor")))))
    {
      ((CoverView)localObject1).setBackgroundColor(Color.parseColor(getActualColor(((JSONObject)localObject3).optString("bgColor"))));
      ((CoverView)localObject1).setScaleX(Float.parseFloat(((JSONObject)localObject3).optString("scaleX")));
      ((CoverView)localObject1).setScaleY(Float.parseFloat(((JSONObject)localObject3).optString("scaleY")));
      JSONArray localJSONArray = ((JSONObject)localObject3).optJSONArray("padding");
      ((CoverView)localObject1).setPadding(localJSONArray.optInt(3), localJSONArray.optInt(2), localJSONArray.optInt(1), localJSONArray.optInt(0));
      ((CoverView)localObject1).a(((JSONObject)localObject3).optInt("borderWidth"), Color.parseColor(getActualColor(((JSONObject)localObject3).optString("borderColor"))), (float)((JSONObject)localObject3).optDouble("borderRadius"), Color.parseColor(getActualColor(((JSONObject)localObject3).optString("bgColor"))));
    }
    ((CoverView)localObject1).setClickable(paramJSONObject.optBoolean("clickable"));
    ((CoverView)localObject1).setIncludeFontPadding(false);
    localObject3 = paramJSONObject.optJSONObject("label");
    if (localObject3 != null)
    {
      if (!bbkk.a(((JSONObject)localObject3).optString("color"))) {
        ((CoverView)localObject1).setTextColor(Color.parseColor(getActualColor(((JSONObject)localObject3).optString("color"))));
      }
      ((CoverView)localObject1).setTextSize(1, ((JSONObject)localObject3).optInt("fontSize"));
      if (!"left".equals(((JSONObject)localObject3).optString("textAlign"))) {
        break label634;
      }
      ((CoverView)localObject1).setGravity(3);
    }
    for (;;)
    {
      if (!bbkk.a(((JSONObject)localObject3).optString("content"))) {
        ((CoverView)localObject1).setText(((JSONObject)localObject3).optString("content"));
      }
      if ("bold".equals(((JSONObject)localObject3).optString("fontWeight"))) {
        ((CoverView)localObject1).setTypeface(Typeface.defaultFromStyle(1));
      }
      ((CoverView)localObject1).setClickable(paramJSONObject.optBoolean("clickable"));
      ((CoverView)localObject1).setOnClickListener(new WebviewContainer.1(this, paramJSONObject));
      paramJSONObject = paramJSONObject.optJSONObject("position");
      if (paramJSONObject != null)
      {
        i = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
        j = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
        int k = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
        float f = this.density;
        int m = (int)(paramJSONObject.optInt("top") * f + 0.5F);
        paramJSONObject = new FrameLayout.LayoutParams(i, j);
        paramJSONObject.leftMargin = (((FrameLayout.LayoutParams)localObject2).leftMargin + k);
        paramJSONObject.topMargin = (((FrameLayout.LayoutParams)localObject2).topMargin + m);
        this.componentLayout.addView((View)localObject1, paramJSONObject);
      }
      return;
      label634:
      if ("center".equals(((JSONObject)localObject3).optString("textAlign"))) {
        ((CoverView)localObject1).setGravity(17);
      }
    }
  }
  
  public void insertVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    MiniAppVideoPlayer localMiniAppVideoPlayer2 = (MiniAppVideoPlayer)this.videoPlayerSparseArray.get(paramInt);
    MiniAppVideoPlayer localMiniAppVideoPlayer1 = localMiniAppVideoPlayer2;
    if (localMiniAppVideoPlayer2 == null)
    {
      localMiniAppVideoPlayer1 = new MiniAppVideoPlayer(getContext());
      localMiniAppVideoPlayer1.m = new WeakReference(this.appBrandRuntime.d);
      localMiniAppVideoPlayer1.b = paramJSONObject.optString("data");
      localMiniAppVideoPlayer1.c = this.appBrandRuntime.i;
      localMiniAppVideoPlayer1.d = this.pageWebview.pageWebviewId;
      b.a().addObserver(localMiniAppVideoPlayer1.q);
      this.videoPlayerSparseArray.put(paramInt, localMiniAppVideoPlayer1);
    }
    localMiniAppVideoPlayer1.b(paramJSONObject);
    localMiniAppVideoPlayer1.n = this;
    localMiniAppVideoPlayer1.o = paramJSONObject.optJSONObject("position");
    addVidepPlayer(localMiniAppVideoPlayer1);
    if (paramJSONObject.optBoolean("hide")) {
      localMiniAppVideoPlayer1.setVisibility(8);
    }
  }
  
  public float measureText(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    if (this.mCurrCanvas == null) {
      return -1.0F;
    }
    return this.mCurrCanvas.a(paramJSONObject);
  }
  
  public void notifyChangePullDownRefreshStyle()
  {
    this.swipeRefreshLayout.setProgressBackgroundColorSchemeColor(this.appBrandRuntime.g.refreshStyleColor);
    if (this.appBrandRuntime.g.refreshStyleColor == -1)
    {
      this.swipeRefreshLayout.setColorSchemeColors(new int[] { -16777216 });
      return;
    }
    this.swipeRefreshLayout.setColorSchemeColors(new int[] { -1 });
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
    this.appBrandRuntime.a("onPullDownRefresh", "{}", this.pageWebview.pageWebviewId);
  }
  
  public void onVerticalScroll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "onVerticalScroll scrollY=" + paramInt);
    }
    this.componentLayout.scrollTo(0, paramInt);
  }
  
  public void onVideoPlayerPause()
  {
    int i = 0;
    while (i < this.videoPlayerSparseArray.size())
    {
      ((MiniAppVideoPlayer)this.videoPlayerSparseArray.valueAt(i)).c();
      i += 1;
    }
  }
  
  public void onVideoPlayerResume()
  {
    int i = 0;
    while (i < this.videoPlayerSparseArray.size())
    {
      ((MiniAppVideoPlayer)this.videoPlayerSparseArray.valueAt(i)).b();
      i += 1;
    }
  }
  
  public void operateCamera(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.optInt("cameraId");
    MiniAppCamera localMiniAppCamera = (MiniAppCamera)this.cameraViewSparseArray.get(i);
    if (localMiniAppCamera == null) {
      callbackJsEventFail(paramString, null, paramInt);
    }
    String str;
    do
    {
      return;
      this.currentCamera = localMiniAppCamera;
      str = paramJSONObject.optString("type");
      if ("takePhoto".equals(str))
      {
        localMiniAppCamera.a(this, paramString, paramInt, paramJSONObject.optString("quality"));
        return;
      }
      if ("startRecord".equals(str))
      {
        localMiniAppCamera.a(this, paramString, paramInt);
        return;
      }
    } while (!"stopRecord".equals(str));
    localMiniAppCamera.b(this, paramString, paramInt);
  }
  
  public void operateVideoPlayer(int paramInt, String paramString)
  {
    MiniAppVideoPlayer localMiniAppVideoPlayer = (MiniAppVideoPlayer)this.videoPlayerSparseArray.get(paramInt);
    if (localMiniAppVideoPlayer == null) {}
    do
    {
      return;
      if ("play".equals(paramString))
      {
        localMiniAppVideoPlayer.f();
        return;
      }
      if ("pause".equals(paramString))
      {
        localMiniAppVideoPlayer.c();
        return;
      }
    } while (!"sendDanmu".equals(paramString));
    localMiniAppVideoPlayer.b("aaaaa");
  }
  
  public void removeCanvas(int paramInt)
  {
    CanvasView localCanvasView = (CanvasView)this.canvasSparseArray.get(paramInt);
    if (localCanvasView == null) {
      return;
    }
    this.componentLayout.removeView(localCanvasView);
    this.canvasSparseArray.remove(paramInt);
  }
  
  public void removeImageView(int paramInt)
  {
    CoverImageView localCoverImageView = (CoverImageView)this.imageViewSparseArray.get(paramInt);
    if (localCoverImageView == null) {
      return;
    }
    removeCoverChildView(paramInt);
    this.componentLayout.removeView(localCoverImageView);
  }
  
  public void removeTextArea(int paramInt)
  {
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    if (localMiniAppTextArea == null) {
      return;
    }
    this.videoPlayerSparseArray.remove(paramInt);
    this.componentLayout.removeView(localMiniAppTextArea);
  }
  
  public void removeTextView(int paramInt1, int paramInt2)
  {
    CoverView localCoverView = (CoverView)this.mTextViewSparseArray.get(paramInt1);
    if (localCoverView == null) {
      return;
    }
    removeCoverChildView(paramInt1);
    this.componentLayout.removeView(localCoverView);
  }
  
  public void removeVideoPlayer(int paramInt)
  {
    MiniAppVideoPlayer localMiniAppVideoPlayer = (MiniAppVideoPlayer)this.videoPlayerSparseArray.get(paramInt);
    if (localMiniAppVideoPlayer == null) {
      return;
    }
    this.videoPlayerSparseArray.remove(paramInt);
    this.componentLayout.removeView(localMiniAppVideoPlayer);
  }
  
  public void saveCanvasFile(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    CanvasView localCanvasView = (CanvasView)this.canvasSparseArray.get(paramInt1);
    if (localCanvasView == null)
    {
      callbackJsEventFail(paramString, null, paramInt2);
      return;
    }
    localCanvasView.a(this, getContext(), paramJSONObject, paramString, paramInt2);
  }
  
  public void setPageWebview(PageWebview paramPageWebview)
  {
    this.pageWebview = paramPageWebview;
    paramPageWebview.setOnWebviewScrollListener(this);
    paramPageWebview.addView(this.componentLayout, new FrameLayout.LayoutParams(-1, -1));
    this.swipeRefreshLayout.addView(paramPageWebview, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void startPullDownRefresh()
  {
    this.swipeRefreshLayout.setRefreshing(true);
  }
  
  public void stopPullDownRefresh()
  {
    this.swipeRefreshLayout.setRefreshing(false);
  }
  
  public void updateCanvas(int paramInt, JSONObject paramJSONObject, boolean paramBoolean)
  {
    CanvasView localCanvasView = (CanvasView)this.canvasSparseArray.get(paramInt);
    if (localCanvasView == null) {}
    do
    {
      return;
      if (paramJSONObject != null) {
        break;
      }
    } while (!paramBoolean);
    localCanvasView.setVisibility(8);
    return;
    paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
    int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
    int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
    int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
    paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
    paramJSONObject.leftMargin = j;
    paramJSONObject.topMargin = k;
    localCanvasView.setLayoutParams(paramJSONObject);
  }
  
  public void updateHTMLWebView(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewContainer", 2, "updateHTMLWebView htmlId=" + paramInt + ",innerWebView=" + this.innerWebView + ",src=" + paramString);
    }
    if ((this.innerWebView == null) || (this.innerWebView.htmlId != paramInt) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.innerWebView.setVisibility(0);
    this.innerWebView.loadUrl(paramString);
  }
  
  public void updateImageView(JSONObject paramJSONObject, int paramInt, String paramString, boolean paramBoolean)
  {
    CoverImageView localCoverImageView = (CoverImageView)this.imageViewSparseArray.get(paramInt);
    if ((localCoverImageView == null) || ((bbkk.a(paramString)) || ((paramString.startsWith("http")) || (paramString.startsWith("https"))))) {}
    for (;;)
    {
      try
      {
        paramString = URLDrawable.getDrawable(paramString, null);
        if (paramString != null) {
          localCoverImageView.setImageDrawable(paramString);
        }
      }
      catch (OutOfMemoryError paramString)
      {
        int i;
        int j;
        int k;
        paramString.printStackTrace();
        continue;
      }
      paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = k;
      localCoverImageView.setLayoutParams(paramJSONObject);
      return;
      paramString = this.appBrandRuntime.c.j(paramString);
      if (!bbkk.a(paramString)) {
        localCoverImageView.setImageBitmap(com.tencent.mobileqq.microapp.b.a.i(paramString));
      }
    }
  }
  
  public void updateTextArea(int paramInt, String paramString)
  {
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt);
    if (localMiniAppTextArea == null) {
      return;
    }
    localMiniAppTextArea.setText(paramString);
  }
  
  public void updateTextView(int paramInt, JSONObject paramJSONObject, String paramString)
  {
    CoverView localCoverView = (CoverView)this.mTextViewSparseArray.get(paramInt);
    if (localCoverView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localCoverView.getLayoutParams();
      if (paramJSONObject != null)
      {
        paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
        int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
        int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
        int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
        paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
        localLayoutParams.leftMargin += j;
        localLayoutParams.topMargin += k;
        localCoverView.setLayoutParams(paramJSONObject);
      }
      localCoverView.setText(paramString);
    }
  }
  
  public void updateVideoPlayer(int paramInt, JSONObject paramJSONObject)
  {
    MiniAppVideoPlayer localMiniAppVideoPlayer = (MiniAppVideoPlayer)this.videoPlayerSparseArray.get(paramInt);
    if (localMiniAppVideoPlayer != null)
    {
      localMiniAppVideoPlayer.b(paramJSONObject);
      Object localObject = paramJSONObject.optJSONObject("position");
      if (localObject != null)
      {
        int j = ((JSONObject)localObject).optInt("left");
        paramInt = ((JSONObject)localObject).optInt("top");
        int i = ((JSONObject)localObject).optInt("width");
        int k = ((JSONObject)localObject).optInt("height");
        float f = this.density;
        i = (int)(i * f + 0.5F);
        f = this.density;
        k = (int)(k * f + 0.5F);
        j = (int)(this.density * j + 0.5F);
        paramInt = (int)(this.density * paramInt + 0.5F);
        localObject = (FrameLayout.LayoutParams)localMiniAppVideoPlayer.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i;
        ((FrameLayout.LayoutParams)localObject).height = k;
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
      }
      paramJSONObject = paramJSONObject.optString("filePath");
      if (!bbkk.a(paramJSONObject))
      {
        localMiniAppVideoPlayer.a(paramJSONObject.replace("https:", "http:"));
        if (localMiniAppVideoPlayer.i) {
          localMiniAppVideoPlayer.f();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer
 * JD-Core Version:    0.7.0.1
 */