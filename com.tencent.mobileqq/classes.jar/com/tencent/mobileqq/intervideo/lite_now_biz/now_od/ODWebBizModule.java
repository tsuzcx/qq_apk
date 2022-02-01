package com.tencent.mobileqq.intervideo.lite_now_biz.now_od;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowEventJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQbizApiJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowUIJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.SsoJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.module.NowCustomWebModule;
import com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.OnGetRoomExtInfoListener;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;

public class ODWebBizModule
  extends NowCustomWebModule
  implements OnGetRoomExtInfoListener
{
  Observer<AudioChangeEvent> b = new ODWebBizModule.1(this);
  private Map<String, String> n = new HashMap();
  
  public ODWebBizModule()
  {
    m();
  }
  
  private String t()
  {
    Object localObject = this.roomBizContext.getEnterRoomInfo().extData.getString("mqqschema");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = Uri.parse((String)localObject);
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("anchoruid");
      return localObject;
    }
    catch (Exception localException) {}
    return null;
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
    return "https://now.qq.com/qq/jiaoyou/index.html";
  }
  
  public String e()
  {
    return "https://fastest.now.qq.com/qq/jiaoyou/index.html";
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
    this.k.registerJsModule(new NowAppJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowUIJs(this.f, this.context, this.l, this.roomBizContext));
    this.k.registerJsModule(new NowQbizApiJs(this.f, this.context, this.l));
    this.k.registerJsModule(new NowEventJs(this.f, this.context, this.l, this.n));
  }
  
  protected boolean k()
  {
    return false;
  }
  
  protected void l()
  {
    ODWebCookieManager.a().a(this.h);
    ODWebCookieManager.a().a("https://yutang.qq.com/");
    ODWebCookieManager.a().a("https://ilive.qq.com/");
    ODWebCookieManager.a().a("https://now.qq.com/");
    ODWebCookieManager.a().a("https://fastest.now.qq.com/");
    this.l.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  protected void m()
  {
    ODWebCookieManager.a().b("https://now.qq.com/");
    ODWebCookieManager.a().b("https://fastest.now.qq.com/");
    this.l.callJsFunctionByNative("__WEBVIEW_RELOADCOOKIES", null, null);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    paramContext = t();
    if ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(paramContext)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("&friend_uin=");
      localStringBuilder.append(paramContext);
      this.h = localStringBuilder.toString();
    }
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    this.l.getModuleEvent().observe(AudioChangeEvent.class, this.b);
  }
  
  public void onExitRoom(boolean paramBoolean)
  {
    super.onExitRoom(paramBoolean);
    this.l.getModuleEvent().removeObserver(AudioChangeEvent.class, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODWebBizModule
 * JD-Core Version:    0.7.0.1
 */