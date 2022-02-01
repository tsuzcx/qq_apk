package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import android.os.Build.VERSION;
import androidx.lifecycle.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowEventJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQbizApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.js.MultiVoiceAppJs;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class MultiVoiceWebBizModule
  extends NowCustomWebModule
  implements OnGetRoomExtInfoListener
{
  private Map<String, String> b = new HashMap();
  private Observer<AudioChangeEvent> n = new MultiVoiceWebBizModule.1(this);
  private Observer<MultiVoicePageEvent> o = new MultiVoiceWebBizModule.2(this);
  
  public MultiVoiceWebBizModule()
  {
    m();
  }
  
  private void t()
  {
    this.l.getModuleEvent().observe(AudioChangeEvent.class, this.n);
    this.l.getModuleEvent().observe(MultiVoicePageEvent.class, this.o);
  }
  
  private void u()
  {
    this.l.getModuleEvent().removeObserver(AudioChangeEvent.class, this.n);
    this.l.getModuleEvent().removeObserver(MultiVoicePageEvent.class, this.o);
  }
  
  public String a()
  {
    return "od";
  }
  
  public String a(String paramString)
  {
    String str = Build.VERSION.RELEASE;
    int i = NetworkUtil.getNetworkType(BaseApplicationImpl.getContext());
    if ((!StringUtil.isEmpty(paramString)) && (paramString.contains("NowSDK/"))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" NowLive/");
    localStringBuilder.append(10800);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append(" QQ/8.4.8.1522 NetType/");
    localStringBuilder.append(i);
    localStringBuilder.append(" NowSDK/18_10.20");
    return localStringBuilder.toString();
  }
  
  public RoomExtInfo c()
  {
    return null;
  }
  
  public String d()
  {
    return "https://now.qq.com/qq/qun-jiaoyou/index.html";
  }
  
  public String e()
  {
    return "https://fastest.now.qq.com/qq/qun-jiaoyou/index.html";
  }
  
  public String f()
  {
    return null;
  }
  
  public String g()
  {
    return null;
  }
  
  public String h()
  {
    return null;
  }
  
  public String i()
  {
    return null;
  }
  
  protected void j()
  {
    super.j();
    this.k.registerJsModule(new SsoJavascriptInterface(this.f, this.context, this.l));
    this.k.registerJsModule(new NowQQApiJs(this.f, this.context, this.l));
    this.k.registerJsModule(new MultiVoiceAppJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowAppJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowUIJs(this.f, this.context, this.l, this.roomBizContext));
    this.k.registerJsModule(new NowQbizApiJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowEventJs(this.f, this.context, this.l, this.b));
  }
  
  protected boolean k()
  {
    return false;
  }
  
  protected void l()
  {
    MultiVoiceWebCookieManager.a().a(this.h);
    MultiVoiceWebCookieManager.a().a("https://yutang.qq.com/");
    MultiVoiceWebCookieManager.a().a("https://ilive.qq.com/");
    MultiVoiceWebCookieManager.a().a("https://now.qq.com/");
    MultiVoiceWebCookieManager.a().a("https://fastest.now.qq.com/");
    this.l.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  protected void m()
  {
    MultiVoiceWebCookieManager.a().b("https://now.qq.com/");
    MultiVoiceWebCookieManager.a().b("https://fastest.now.qq.com/");
    this.l.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    t();
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceWebBizModule
 * JD-Core Version:    0.7.0.1
 */