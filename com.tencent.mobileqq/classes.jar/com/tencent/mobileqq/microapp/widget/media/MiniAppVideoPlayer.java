package com.tencent.mobileqq.microapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppVideoPlayer
  extends FrameLayout
  implements View.OnClickListener
{
  final String a = MiniAppVideoPlayer.class.getName();
  private boolean aa = false;
  private View ab;
  private long ac;
  public String b;
  public ServiceWebview c;
  public int d;
  public String e;
  public boolean f = false;
  public boolean g;
  public boolean h;
  public boolean i;
  public boolean j;
  public boolean k;
  public String l;
  public WeakReference m;
  public WebviewContainer n;
  public JSONObject o;
  public boolean p;
  public MiniAppVideoPlayer.a q;
  private View r;
  private TVK_IMediaPlayer s = null;
  private ViewGroup t;
  private IVideoViewBase u = null;
  private TVK_IProxyFactory v = null;
  private ImageView w;
  private ImageView x;
  private FrameLayout y;
  private Context z;
  
  public MiniAppVideoPlayer(@NonNull Context paramContext)
  {
    this(paramContext, null);
    a(paramContext);
  }
  
  public MiniAppVideoPlayer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Activity paramActivity)
  {
    int i1 = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
    if (Build.VERSION.SDK_INT >= 21) {
      i1 = 5894;
    } else if (Build.VERSION.SDK_INT >= 16) {
      i1 = 1798;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      i1 |= 0x800;
    } else {
      i1 |= 0x1;
    }
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(i1);
  }
  
  private void a(Context paramContext)
  {
    this.z = paramContext;
    this.r = LayoutInflater.from(paramContext).inflate(R.layout.b, null);
    this.t = ((FrameLayout)this.r.findViewById(R.id.j));
    this.y = ((FrameLayout)this.r.findViewById(R.id.r));
    this.w = ((ImageView)this.r.findViewById(R.id.q));
    this.x = ((ImageView)this.r.findViewById(R.id.k));
    this.x.setOnClickListener(this);
    addView(this.r);
    this.q = new MiniAppVideoPlayer.a(this);
    com.tencent.mobileqq.microapp.a.a.a().a(new i(this));
  }
  
  private void b(Context paramContext)
  {
    if (!this.aa)
    {
      TVK_SDKMgr.initSdk(getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.aa = true;
    }
    if (!TVK_SDKMgr.isInstalled(getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "TVK_SDK is not installed");
      }
      return;
    }
    this.v = TVK_SDKMgr.getProxyFactory();
    Object localObject = this.v;
    if (localObject == null) {
      return;
    }
    this.u = ((TVK_IProxyFactory)localObject).createVideoView_Scroll(paramContext);
    this.s = this.v.createMediaPlayer(paramContext, this.u);
    if (this.s == null) {
      return;
    }
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.ab = ((View)this.u);
    this.ab.setLayoutParams(paramContext);
    this.ab.setVisibility(0);
    this.s.setXYaxis(2);
    if (!this.i) {
      if (!StringUtil.isEmpty(this.e))
      {
        paramContext = URLDrawable.getDrawable(this.e, null);
        if (paramContext != null)
        {
          localObject = this.w;
          if (localObject != null) {
            ((ImageView)localObject).setImageDrawable(paramContext);
          }
        }
      }
      else if (!StringUtil.isEmpty(this.l))
      {
        c.a(this.l, new j(this));
      }
    }
    try
    {
      if (this.g)
      {
        paramContext = new Properties();
        boolean bool = this.h;
        if (bool)
        {
          paramContext.put("mHaveDanmu", "true");
          this.s.attachDanmuView();
        }
        if (this.k) {
          paramContext.put("mHaveCacheDownload", "true");
        }
        this.s.attachControllerView(paramContext);
      }
    }
    catch (IllegalAccessException paramContext)
    {
      paramContext.printStackTrace();
    }
    this.s.setOnControllerClickListener(new k(this));
    this.s.setOnVideoPreparedListener(new l(this));
    this.s.setOnCompletionListener(new m(this));
    this.s.setOnErrorListener(new p(this));
    this.s.setOnInfoListener(new q(this));
    this.s.setOnSeekCompleteListener(new r(this));
    this.y.setVisibility(0);
    this.t.removeAllViews();
    this.t.addView(this.ab);
    this.t.setBackgroundColor(-16777216);
    if ((this.ac > 0L) && (NetworkUtil.isWifiConnected(this.z)))
    {
      if (QLog.isColorLevel())
      {
        paramContext = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("play current pos is: ");
        ((StringBuilder)localObject).append(this.ac);
        QLog.d(paramContext, 2, ((StringBuilder)localObject).toString());
      }
      a(this.ac);
    }
  }
  
  private void h()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (AppBrandUI)this.m.get();
      FrameLayout localFrameLayout = this.n.appBrandRuntime.g.fullScreenLayout;
      ViewGroup localViewGroup = (ViewGroup)this.ab.getParent();
      if (localViewGroup == null) {
        return;
      }
      localViewGroup.removeAllViews();
      this.p = true;
      ((AppBrandUI)localObject).getWindow().setFlags(1024, 1024);
      ((AppBrandUI)localObject).getWindow().getDecorView().setSystemUiVisibility(2);
      ((AppBrandUI)localObject).setRequestedOrientation(0);
      a((Activity)localObject);
      localFrameLayout.addView(this.ab);
      localFrameLayout.setVisibility(0);
      localFrameLayout.bringToFront();
    }
  }
  
  public void a()
  {
    this.s.stop();
  }
  
  public void a(long paramLong)
  {
    if (StringUtil.isEmpty(this.l)) {
      return;
    }
    this.f = true;
    this.s.stop();
    Object localObject = new TVK_PlayerVideoInfo();
    ((TVK_PlayerVideoInfo)localObject).setConfigMap("keep_last_frame", "true");
    if (this.j)
    {
      ((TVK_PlayerVideoInfo)localObject).setPlayType(38);
      this.s.setLoopback(true);
    }
    if ((!this.l.startsWith("http")) && (!this.l.startsWith("https"))) {
      ((TVK_PlayerVideoInfo)localObject).setPlayType(4);
    } else {
      ((TVK_PlayerVideoInfo)localObject).setPlayType(5);
    }
    if (this.h) {
      this.s.startPlayDanmu();
    }
    this.s.openMediaPlayerByUrl(getContext(), this.l, paramLong, 0L, (TVK_PlayerVideoInfo)localObject);
    this.y.setVisibility(8);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("data", this.b);
      ServiceWebview localServiceWebview = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onVideoPlay\", ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(",");
      localStringBuilder.append(this.d);
      localStringBuilder.append(")");
      localServiceWebview.evaluteJs(localStringBuilder.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (paramString.startsWith("wxfile"))
    {
      this.l = b.a().c(paramString);
      return;
    }
    if ((paramString.startsWith("http")) || (paramString.startsWith("https"))) {
      this.l = paramString;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.g = paramJSONObject.optBoolean("showBasicControls");
    this.h = paramJSONObject.optBoolean("enableDanmu");
    paramJSONObject.optBoolean("showDanmuBtn");
    this.i = paramJSONObject.optBoolean("autoplay");
    this.j = paramJSONObject.optBoolean("loop");
    paramJSONObject.optBoolean("pageGesture");
    this.k = paramJSONObject.optBoolean("customCache");
    paramJSONObject.optBoolean("showProgress");
    paramJSONObject.optBoolean("showLiveBtn");
    paramJSONObject.optBoolean("showPlayBtn");
    paramJSONObject.optBoolean("showCenterPlayBtn");
    paramJSONObject.optBoolean("showFullScreenBtn");
    paramJSONObject.optBoolean("enableProgressGesture");
    if (StringUtil.isEmpty(this.e)) {
      this.e = paramJSONObject.optString("poster");
    }
    paramJSONObject.optInt("initialTime");
    paramJSONObject = this.s;
    if (paramJSONObject != null) {
      this.ac = paramJSONObject.getCurrentPostion();
    }
  }
  
  public void b()
  {
    this.f = true;
    if (this.s.isPauseing()) {
      this.s.start();
    }
  }
  
  public void b(String paramString)
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.s;
    if (localTVK_IMediaPlayer != null) {
      localTVK_IMediaPlayer.addDanmuContentForLocal(paramString);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initVideoPlayerSettings isFullScreen: ");
      localStringBuilder.append(this.p);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.p) {
      return;
    }
    a(paramJSONObject);
    b(this.z);
  }
  
  public void c()
  {
    this.f = false;
    if (this.s.isPlaying())
    {
      this.s.pause();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", this.b);
        ServiceWebview localServiceWebview = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onVideoPause\", ");
        localStringBuilder.append(localJSONObject);
        localStringBuilder.append(",");
        localStringBuilder.append(this.d);
        localStringBuilder.append(")");
        localServiceWebview.evaluteJs(localStringBuilder.toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    this.s.release();
  }
  
  public long e()
  {
    return this.s.getCurrentPostion();
  }
  
  public void f()
  {
    a(e());
  }
  
  public void g()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      if (!this.p) {
        return;
      }
      this.ac = this.s.getCurrentPostion();
      if (QLog.isColorLevel())
      {
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("smallScreen current pos is: ");
        localStringBuilder.append(this.ac);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.p = false;
      localObject = this.n.appBrandRuntime.g.fullScreenLayout;
      ((FrameLayout)localObject).setVisibility(8);
      ((FrameLayout)localObject).removeAllViews();
      localObject = (AppBrandUI)this.m.get();
      if (localObject != null)
      {
        ((AppBrandUI)localObject).setRequestedOrientation(1);
        if (Build.VERSION.SDK_INT >= 16) {
          ((AppBrandUI)localObject).getWindow().getDecorView().setSystemUiVisibility(0);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.k) {
      a(e());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */