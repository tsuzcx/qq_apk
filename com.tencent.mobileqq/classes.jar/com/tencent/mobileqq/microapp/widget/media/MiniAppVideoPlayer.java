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
import badq;
import baip;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
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
    if (Build.VERSION.SDK_INT >= 21)
    {
      i1 = 5894;
      if (Build.VERSION.SDK_INT < 19) {
        break label64;
      }
      i1 |= 0x800;
    }
    for (;;)
    {
      paramActivity.getWindow().getDecorView().setSystemUiVisibility(i1);
      return;
      if (Build.VERSION.SDK_INT < 16) {
        break;
      }
      i1 = 1798;
      break;
      label64:
      i1 |= 0x1;
    }
  }
  
  private void a(Context paramContext)
  {
    this.z = paramContext;
    this.r = LayoutInflater.from(paramContext).inflate(R.layout.h, null);
    this.t = ((FrameLayout)this.r.findViewById(R.id.ac));
    this.y = ((FrameLayout)this.r.findViewById(R.id.bh));
    this.w = ((ImageView)this.r.findViewById(R.id.bg));
    this.x = ((ImageView)this.r.findViewById(R.id.ap));
    this.x.setOnClickListener(this);
    addView(this.r);
    this.q = new MiniAppVideoPlayer.a(this);
    com.tencent.mobileqq.microapp.c.a.a().a(new i(this));
  }
  
  private void b(Context paramContext)
  {
    if (!this.aa)
    {
      TVK_SDKMgr.initSdk(getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.aa = true;
    }
    if (!TVK_SDKMgr.isInstalled(getContext())) {
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "TVK_SDK is not installed");
      }
    }
    do
    {
      do
      {
        return;
        this.v = TVK_SDKMgr.getProxyFactory();
      } while (this.v == null);
      this.u = this.v.createVideoView_Scroll(paramContext);
      this.s = this.v.createMediaPlayer(paramContext, this.u);
    } while (this.s == null);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.ab = ((View)this.u);
    this.ab.setLayoutParams(paramContext);
    this.ab.setVisibility(0);
    this.s.setXYaxis(2);
    if (!this.i)
    {
      if (baip.a(this.e)) {
        break label468;
      }
      paramContext = URLDrawable.getDrawable(this.e, null);
      if ((paramContext != null) && (this.w != null)) {
        this.w.setImageDrawable(paramContext);
      }
    }
    for (;;)
    {
      try
      {
        if (this.g)
        {
          paramContext = new Properties();
          if (this.h)
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
        label468:
        paramContext.printStackTrace();
        continue;
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
      if ((this.ac <= 0L) || (!badq.h(this.z))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a, 2, "play current pos is: " + this.ac);
      }
      a(this.ac);
      return;
      if (!baip.a(this.l)) {
        com.tencent.mobileqq.microapp.b.a.a(this.l, new j(this));
      }
    }
  }
  
  private void h()
  {
    if ((this.m == null) || (this.m.get() == null)) {}
    AppBrandUI localAppBrandUI;
    FrameLayout localFrameLayout;
    ViewGroup localViewGroup;
    do
    {
      return;
      localAppBrandUI = (AppBrandUI)this.m.get();
      localFrameLayout = this.n.appBrandRuntime.g.fullScreenLayout;
      localViewGroup = (ViewGroup)this.ab.getParent();
    } while (localViewGroup == null);
    localViewGroup.removeAllViews();
    this.p = true;
    localAppBrandUI.getWindow().setFlags(1024, 1024);
    localAppBrandUI.getWindow().getDecorView().setSystemUiVisibility(2);
    localAppBrandUI.setRequestedOrientation(0);
    a(localAppBrandUI);
    localFrameLayout.addView(this.ab);
    localFrameLayout.setVisibility(0);
    localFrameLayout.bringToFront();
  }
  
  public void a()
  {
    this.s.stop();
  }
  
  public void a(long paramLong)
  {
    if (baip.a(this.l)) {
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
    if ((this.l.startsWith("http")) || (this.l.startsWith("https"))) {
      ((TVK_PlayerVideoInfo)localObject).setPlayType(5);
    }
    for (;;)
    {
      if (this.h) {
        this.s.startPlayDanmu();
      }
      this.s.openMediaPlayerByUrl(getContext(), this.l, paramLong, 0L, (TVK_PlayerVideoInfo)localObject);
      this.y.setVisibility(8);
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("data", this.b);
        this.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoPlay\", " + localObject + "," + this.d + ")");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      localJSONException.setPlayType(4);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString.startsWith("wxfile")) {
      this.l = b.a().d(paramString);
    }
    while ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return;
    }
    this.l = paramString;
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
    if (baip.a(this.e)) {
      this.e = paramJSONObject.optString("poster");
    }
    paramJSONObject.optInt("initialTime");
    if (this.s != null) {
      this.ac = this.s.getCurrentPostion();
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
    if (this.s != null) {
      this.s.addDanmuContentForLocal(paramString);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "initVideoPlayerSettings isFullScreen: " + this.p);
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
    if (this.s.isPlaying()) {
      this.s.pause();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", this.b);
      this.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoPause\", " + localJSONObject + "," + this.d + ")");
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
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
    if ((this.m == null) || (this.m.get() == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!this.p);
        this.ac = this.s.getCurrentPostion();
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, "smallScreen current pos is: " + this.ac);
        }
        this.p = false;
        localObject = this.n.appBrandRuntime.g.fullScreenLayout;
        ((FrameLayout)localObject).setVisibility(8);
        ((FrameLayout)localObject).removeAllViews();
        localObject = (AppBrandUI)this.m.get();
      } while (localObject == null);
      ((AppBrandUI)localObject).setRequestedOrientation(1);
    } while (Build.VERSION.SDK_INT < 16);
    ((AppBrandUI)localObject).getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.ap) {
      a(e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.MiniAppVideoPlayer
 * JD-Core Version:    0.7.0.1
 */