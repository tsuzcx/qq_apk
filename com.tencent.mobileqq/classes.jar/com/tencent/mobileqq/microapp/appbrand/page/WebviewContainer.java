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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.ApkgConfigManager.a;
import com.tencent.mobileqq.microapp.apkg.j;
import com.tencent.mobileqq.microapp.apkg.l;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import com.tencent.mobileqq.microapp.widget.CanvasView;
import com.tencent.mobileqq.microapp.widget.CoverImageView;
import com.tencent.mobileqq.microapp.widget.CoverView;
import com.tencent.mobileqq.microapp.widget.MapContext;
import com.tencent.mobileqq.microapp.widget.MiniAppTextArea;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.mobileqq.microapp.widget.media.MiniAppCamera;
import com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer;
import com.tencent.mobileqq.utils.StringUtil;
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
  protected c apkgInfo$5475ea27;
  public a appBrandRuntime;
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
  private com.tencent.mobileqq.microapp.widget.b miniAppFileView;
  protected j pageInfo;
  private PageWebview pageWebview;
  public SwipeRefreshLayout swipeRefreshLayout;
  private SparseArray videoPlayerSparseArray = new SparseArray();
  
  public WebviewContainer(Context paramContext, a parama, c paramc, String paramString)
  {
    super(paramContext);
    this.density = DisplayUtil.getDensity(paramContext);
    this.appBrandRuntime = parama;
    this.apkgInfo$5475ea27 = paramc;
    this.pageInfo = paramc.b.b(paramString);
    this.componentLayout = new FrameLayout(getContext());
    this.mapContextArray = new SparseArray();
    this.swipeRefreshLayout = new SwipeRefreshLayout(getContext());
    this.swipeRefreshLayout.setEnabled(this.pageInfo.a.b);
    this.swipeRefreshLayout.setOnRefreshListener(this);
    addView(this.swipeRefreshLayout, new FrameLayout.LayoutParams(-1, -1));
    notifyChangePullDownRefreshStyle();
  }
  
  private String getActualColor(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    String str = paramString.substring(paramString.length() - 2);
    paramString = paramString.substring(1, paramString.length() - 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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
    m = (int)(m * f + 0.5F);
    k = (int)(k * f + 0.5F);
    i = (int)(f * i + 0.5F);
    localObject = new FrameLayout.LayoutParams(j, m);
    ((FrameLayout.LayoutParams)localObject).leftMargin = k;
    ((FrameLayout.LayoutParams)localObject).topMargin = i;
    this.componentLayout.addView(paramMiniAppVideoPlayer, (ViewGroup.LayoutParams)localObject);
  }
  
  public void callbackJsEventFail(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.pageWebview != null)
    {
      paramString = c.b(paramString, paramJSONObject);
      if (paramString != null) {
        paramString = paramString.toString();
      } else {
        paramString = "";
      }
      this.pageWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void callbackJsEventOK(String paramString, JSONObject paramJSONObject, int paramInt)
  {
    if (this.pageWebview != null)
    {
      paramString = c.a(paramString, paramJSONObject);
      if (paramString != null) {
        paramString = paramString.toString();
      } else {
        paramString = "";
      }
      this.pageWebview.evaluateCallbackJs(paramInt, paramString);
    }
  }
  
  public void destroy()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WebViewContainer", 2, "-----destroy----");
    }
    Object localObject = this.pageWebview;
    if (localObject != null)
    {
      this.swipeRefreshLayout.removeView((View)localObject);
      this.pageWebview.destroy();
    }
    int j = 0;
    int i = 0;
    while (i < this.videoPlayerSparseArray.size())
    {
      localObject = (MiniAppVideoPlayer)this.videoPlayerSparseArray.valueAt(i);
      if (localObject != null)
      {
        ((MiniAppVideoPlayer)localObject).a();
        ((MiniAppVideoPlayer)localObject).d();
        com.tencent.mobileqq.microapp.app.b.a().deleteObserver(((MiniAppVideoPlayer)localObject).q);
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
    localObject = this.innerWebView;
    if (localObject != null)
    {
      this.componentLayout.removeView((View)localObject);
      h.a().a(this.innerWebView, getContext());
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
    Object localObject = this.innerWebView;
    if ((localObject != null) && (((ProgressWebView)localObject).canGoBack()))
    {
      this.innerWebView.goBack();
      return true;
    }
    int i = 0;
    while (i < this.videoPlayerSparseArray.size())
    {
      localObject = (MiniAppVideoPlayer)this.videoPlayerSparseArray.valueAt(i);
      if (((MiniAppVideoPlayer)localObject).p)
      {
        ((MiniAppVideoPlayer)localObject).g();
        return true;
      }
      i += 1;
    }
    localObject = this.miniAppFileView;
    if (localObject != null)
    {
      ((com.tencent.mobileqq.microapp.widget.b)localObject).a();
      this.miniAppFileView.a(this.componentLayout);
      this.miniAppFileView = null;
      return true;
    }
    return false;
  }
  
  public void insertCamera$6f1019db(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ApkgConfigManager.a parama)
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
    float f = this.density;
    paramInt1 = (int)(paramInt4 * f + 0.5F);
    paramInt4 = (int)(paramInt5 * f + 0.5F);
    paramInt2 = (int)(paramInt2 * f + 0.5F);
    paramInt3 = (int)(f * paramInt3 + 0.5F);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertCanvas currentWebview.getMeasuredHeight: ");
      localStringBuilder.append(k);
      localStringBuilder.append("---canvas height----");
      localStringBuilder.append(paramJSONObject.optInt("height"));
      localStringBuilder.append("---");
      localStringBuilder.append(j);
      QLog.i("WebViewContainer", 2, localStringBuilder.toString());
    }
    k = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
    int m = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
    paramJSONObject = (CanvasView)this.canvasSparseArray.get(paramInt);
    if (paramJSONObject == null)
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
      this.miniAppFileView = new com.tencent.mobileqq.microapp.widget.b(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getPageWebview().getWidth(), getPageWebview().getHeight());
      localLayoutParams.leftMargin = 0;
      localLayoutParams.topMargin = 0;
      this.miniAppFileView.a(this.componentLayout, localLayoutParams);
    }
    this.miniAppFileView.a(paramFile);
  }
  
  public void insertHTMLWebView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertHTMLWebView htmlId=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",innerWebView=");
      ((StringBuilder)localObject).append(this.innerWebView);
      QLog.d("WebViewContainer", 2, ((StringBuilder)localObject).toString());
    }
    if (this.innerWebView != null) {
      return;
    }
    float f = this.density;
    paramInt4 = (int)(paramInt4 * f + 0.5F);
    paramInt5 = (int)(paramInt5 * f + 0.5F);
    paramInt2 = (int)(paramInt2 * f + 0.5F);
    paramInt3 = (int)(f * paramInt3 + 0.5F);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("insertHTMLWebView htmlId=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",left=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",top=");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",w=");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",h=");
      ((StringBuilder)localObject).append(paramInt5);
      QLog.d("WebViewContainer", 2, ((StringBuilder)localObject).toString());
    }
    this.innerWebView = h.a().a(this.apkgInfo$5475ea27.d, paramInt1);
    Object localObject = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
    ((FrameLayout.LayoutParams)localObject).topMargin = paramInt3;
    this.innerWebView.setVisibility(8);
    this.componentLayout.addView(this.innerWebView, (ViewGroup.LayoutParams)localObject);
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
    if (!StringUtil.isEmpty(paramString2)) {
      if ((!paramString2.startsWith("http")) && (!paramString2.startsWith("https")))
      {
        paramString2 = this.appBrandRuntime.c.j(paramString2);
        if (!StringUtil.isEmpty(paramString2)) {
          ((CoverImageView)localObject1).setImageBitmap(c.q(paramString2));
        }
      }
      else
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
          paramString2.printStackTrace();
        }
      }
    }
    ((CoverImageView)localObject1).setClickable(true);
    ((CoverImageView)localObject1).setOnClickListener(new WebviewContainer.2(this, paramString1));
    paramInt1 = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
    paramInt2 = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
    int i = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
    int j = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
    paramJSONObject = new FrameLayout.LayoutParams(paramInt1, paramInt2);
    paramJSONObject.leftMargin = (((FrameLayout.LayoutParams)localObject2).leftMargin + i);
    paramJSONObject.topMargin = (((FrameLayout.LayoutParams)localObject2).topMargin + j);
    this.componentLayout.addView((View)localObject1, paramJSONObject);
  }
  
  public void insertMap(int paramInt)
  {
    Object localObject = (MapContext)this.mapContextArray.get(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertMapView mapId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mapContext=");
      localStringBuilder.append(localObject);
      QLog.d("WebViewContainer", 2, localStringBuilder.toString());
    }
    if (localObject != null) {
      return;
    }
    localObject = new QQMapView(getContext(), null);
    this.componentLayout.addView((View)localObject);
    localObject = new MapContext(this.pageWebview, this.appBrandRuntime.i, (QQMapView)localObject, paramInt, this.apkgInfo$5475ea27);
    this.mapContextArray.put(paramInt, localObject);
  }
  
  public void insertTextArea(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    paramString = paramJSONObject.optJSONObject("style");
    int j = (int)(this.density * paramString.optInt("width") + 0.5F);
    int i = (int)(this.density * paramString.optInt("height", paramString.optInt("minHeight")) + 0.5F);
    paramInt2 = i;
    if (i == 0) {
      paramInt2 = -2;
    }
    i = (int)(this.density * paramString.optInt("left") + 0.5F);
    int k = (int)(this.density * paramString.optInt("top") + 0.5F);
    MiniAppTextArea localMiniAppTextArea = (MiniAppTextArea)this.appTextAreaSparseArray.get(paramInt1);
    paramString = localMiniAppTextArea;
    if (localMiniAppTextArea == null)
    {
      paramString = new MiniAppTextArea(getContext());
      this.appTextAreaSparseArray.put(paramInt1, paramString);
    }
    paramString.a(paramInt1, paramJSONObject, this);
    paramJSONObject = new FrameLayout.LayoutParams(j, paramInt2);
    paramJSONObject.leftMargin = i;
    paramJSONObject.topMargin = (k - getPageWebview().scrollY);
    this.componentLayout.addView(paramString, paramJSONObject);
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
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("insertTextView layoutParams: ");
    ((StringBuilder)localObject2).append(localObject3);
    QLog.i("WebViewContainer", 2, ((StringBuilder)localObject2).toString());
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
    }
    localObject3 = paramJSONObject.optJSONObject("style");
    if ((localObject3 != null) && (!StringUtil.isEmpty(getActualColor(((JSONObject)localObject3).optString("bgColor")))))
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
      if (!StringUtil.isEmpty(((JSONObject)localObject3).optString("color"))) {
        ((CoverView)localObject1).setTextColor(Color.parseColor(getActualColor(((JSONObject)localObject3).optString("color"))));
      }
      ((CoverView)localObject1).setTextSize(1, ((JSONObject)localObject3).optInt("fontSize"));
      if ("left".equals(((JSONObject)localObject3).optString("textAlign"))) {
        ((CoverView)localObject1).setGravity(3);
      } else if ("center".equals(((JSONObject)localObject3).optString("textAlign"))) {
        ((CoverView)localObject1).setGravity(17);
      }
      if (!StringUtil.isEmpty(((JSONObject)localObject3).optString("content"))) {
        ((CoverView)localObject1).setText(((JSONObject)localObject3).optString("content"));
      }
      if ("bold".equals(((JSONObject)localObject3).optString("fontWeight"))) {
        ((CoverView)localObject1).setTypeface(Typeface.defaultFromStyle(1));
      }
    }
    ((CoverView)localObject1).setClickable(paramJSONObject.optBoolean("clickable"));
    ((CoverView)localObject1).setOnClickListener(new WebviewContainer.1(this, paramJSONObject));
    paramJSONObject = paramJSONObject.optJSONObject("position");
    if (paramJSONObject != null)
    {
      i = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      j = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      int k = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      int m = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(i, j);
      paramJSONObject.leftMargin = (((FrameLayout.LayoutParams)localObject2).leftMargin + k);
      paramJSONObject.topMargin = (((FrameLayout.LayoutParams)localObject2).topMargin + m);
      this.componentLayout.addView((View)localObject1, paramJSONObject);
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
      com.tencent.mobileqq.microapp.app.b.a().addObserver(localMiniAppVideoPlayer1.q);
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
    paramString = this.mCurrCanvas;
    if (paramString == null) {
      return -1.0F;
    }
    return paramString.a(paramJSONObject);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVerticalScroll scrollY=");
      localStringBuilder.append(paramInt);
      QLog.d("WebViewContainer", 2, localStringBuilder.toString());
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
    if (localMiniAppCamera == null)
    {
      callbackJsEventFail(paramString, null, paramInt);
      return;
    }
    this.currentCamera = localMiniAppCamera;
    String str = paramJSONObject.optString("type");
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
    if ("stopRecord".equals(str)) {
      localMiniAppCamera.b(this, paramString, paramInt);
    }
  }
  
  public void operateVideoPlayer(int paramInt, String paramString)
  {
    MiniAppVideoPlayer localMiniAppVideoPlayer = (MiniAppVideoPlayer)this.videoPlayerSparseArray.get(paramInt);
    if (localMiniAppVideoPlayer == null) {
      return;
    }
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
    if ("sendDanmu".equals(paramString)) {
      localMiniAppVideoPlayer.b("aaaaa");
    }
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
    if (localCanvasView == null) {
      return;
    }
    if (paramJSONObject == null)
    {
      if (paramBoolean) {
        localCanvasView.setVisibility(8);
      }
    }
    else
    {
      paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = k;
      localCanvasView.setLayoutParams(paramJSONObject);
    }
  }
  
  public void updateHTMLWebView(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateHTMLWebView htmlId=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",innerWebView=");
      ((StringBuilder)localObject).append(this.innerWebView);
      ((StringBuilder)localObject).append(",src=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebViewContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.innerWebView;
    if ((localObject != null) && (((ProgressWebView)localObject).htmlId == paramInt))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.innerWebView.setVisibility(0);
      this.innerWebView.loadUrl(paramString);
    }
  }
  
  public void updateImageView(JSONObject paramJSONObject, int paramInt, String paramString, boolean paramBoolean)
  {
    CoverImageView localCoverImageView = (CoverImageView)this.imageViewSparseArray.get(paramInt);
    if (localCoverImageView != null)
    {
      if (!StringUtil.isEmpty(paramString)) {
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
        {
          paramString = this.appBrandRuntime.c.j(paramString);
          if (!StringUtil.isEmpty(paramString)) {
            localCoverImageView.setImageBitmap(c.q(paramString));
          }
        }
        else
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
            paramString.printStackTrace();
          }
        }
      }
      paramInt = (int)(this.density * paramJSONObject.optInt("width") + 0.5F);
      int i = (int)(this.density * paramJSONObject.optInt("height") + 0.5F);
      int j = (int)(this.density * paramJSONObject.optInt("left") + 0.5F);
      int k = (int)(this.density * paramJSONObject.optInt("top") + 0.5F);
      paramJSONObject = new FrameLayout.LayoutParams(paramInt, i);
      paramJSONObject.leftMargin = j;
      paramJSONObject.topMargin = k;
      localCoverImageView.setLayoutParams(paramJSONObject);
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
        k = (int)(k * f + 0.5F);
        j = (int)(j * f + 0.5F);
        paramInt = (int)(f * paramInt + 0.5F);
        localObject = (FrameLayout.LayoutParams)localMiniAppVideoPlayer.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i;
        ((FrameLayout.LayoutParams)localObject).height = k;
        ((FrameLayout.LayoutParams)localObject).leftMargin = j;
        ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
      }
      paramJSONObject = paramJSONObject.optString("filePath");
      if (!StringUtil.isEmpty(paramJSONObject))
      {
        localMiniAppVideoPlayer.a(paramJSONObject.replace("https:", "http:"));
        if (localMiniAppVideoPlayer.i) {
          localMiniAppVideoPlayer.f();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer
 * JD-Core Version:    0.7.0.1
 */