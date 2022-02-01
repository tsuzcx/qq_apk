package com.tencent.mobileqq.kandian.glue.viola.view;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModuleHelper;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.utils.HardwareUtil;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ViolaBaseView$ViolaCreactPageObject
{
  private String a;
  private JSONObject b;
  private String c;
  private String d;
  private int e;
  private int f;
  private int g = 1;
  private String h = "120";
  private int i;
  private String j = "0";
  private int k = 0;
  private String l;
  private boolean m;
  private int n;
  
  public ViolaBaseView$ViolaCreactPageObject(String paramString1, JSONObject paramJSONObject, String paramString2, int paramInt, String paramString3)
  {
    this(paramString1, paramJSONObject, paramString2, paramString3);
    this.f = paramInt;
    this.m = RIJBlackWhiteModeHelper.a.b();
  }
  
  public ViolaBaseView$ViolaCreactPageObject(@NonNull String paramString1, @NonNull JSONObject paramJSONObject, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramJSONObject;
    this.c = paramString2;
    this.l = paramString3;
    if ((!TextUtils.isEmpty(this.a)) && ((this.a.contains("v_present=1")) || (this.a.contains("v_present=2")))) {
      this.e = 1;
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.contains("v_present_auto_top=0"))) {
      this.g = 0;
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.contains("v_present_top"))) {
      this.h = Uri.parse(this.a).getQueryParameter("v_present_top");
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.contains("is_last_index=1"))) {
      this.n = 1;
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.contains("channelId"))) {
      this.j = Uri.parse(this.a).getQueryParameter("channelId");
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.contains("unreadMessageCount"))) {
      try
      {
        paramString1 = Uri.parse(this.a).getQueryParameter("unreadMessageCount");
        if (paramString1 != null) {
          this.k = Integer.valueOf(paramString1).intValue();
        }
      }
      catch (NumberFormatException paramString1)
      {
        QLog.e("ViolaBaseView", 1, paramString1.toString());
      }
    }
    paramString1 = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (paramString1 != null) {
      this.d = paramString1.getAccount();
    }
    this.i = ViewUtils.pxToDp(CommonSuspensionGestureLayout.a(BridgeModuleHelper.e()));
  }
  
  private void a(JSONObject paramJSONObject)
  {
    float f1;
    if ((BridgeModuleHelper.e() != null) && (BridgeModuleHelper.e().getResources() != null)) {
      f1 = ViewUtils.pxToDp(BridgeModuleHelper.e().getResources().getDimensionPixelSize(2131297771));
    } else {
      f1 = 54.0F;
    }
    paramJSONObject.put("qqTabBarHeight", f1);
  }
  
  private boolean f()
  {
    return this.f == 1;
  }
  
  private int g()
  {
    Object localObject = BaseApplicationImpl.getApplication().getResources();
    if (localObject == null) {
      return 1;
    }
    localObject = ((Resources)localObject).getConfiguration();
    if (localObject == null) {
      return 1;
    }
    return ((Configuration)localObject).orientation;
  }
  
  public void a()
  {
    this.f = 1;
  }
  
  public boolean b()
  {
    return (f()) && (this.m);
  }
  
  public String c()
  {
    Object localObject2 = this.b.optString("runtimeName");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      if (ViolaSoLoaderManager.a.a().d())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("default_");
        ((StringBuilder)localObject1).append(hashCode());
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "default";
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("runtimeName: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ViolaLogUtils.d("ViolaBaseView", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    int i1;
    try
    {
      localJSONObject.put("url", this.a);
      this.b.put("unreadMessageCount", this.k);
      localJSONObject.put("param", this.b);
      localJSONObject.put("cache", this.c);
      localJSONObject.put("uin", this.d);
      localJSONObject.put("isPresent", this.e);
      localJSONObject.put("isChannel", this.f);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      i2 = 0;
      if (!ThemeUtil.isNowThemeIsNight((AppRuntime)localObject, false, null)) {
        break label525;
      }
      i1 = 1;
      localJSONObject.put("isNightMode", i1);
      localJSONObject.put("isAutoTop", this.g);
      localJSONObject.put("presentMarginTop", this.h);
      localJSONObject.put("nowNavBarHeight", this.i);
      localJSONObject.put("orientation", g());
      localJSONObject.put("screenWidth", FlexConvertUtils.getScreenWidth(BaseApplicationImpl.getApplication()));
      localJSONObject.put("screenHeight", FlexConvertUtils.getScreenHeight(BaseApplicationImpl.getApplication()));
      i1 = VasUtil.a().getVasFtManager().obtainCardState("016a");
      if (i1 == 1) {
        break label535;
      }
      if (i1 != 2) {
        break label530;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      int i2;
      label232:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ViolaCreactPageObject toJSON error = ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ViolaBaseView", 1, localStringBuilder.toString());
      return localJSONObject;
    }
    localJSONObject.put("isKindCard", i1);
    localJSONObject.put("channel_id", this.j);
    if (PlayerHelper.a.a()) {
      i1 = 1;
    }
    for (;;)
    {
      localJSONObject.put("supportRate", i1);
      localJSONObject.put("netType", HttpUtil.getNetWorkType());
      localObject = ViolaBizUtils.f();
      localJSONObject.put("topActivityWidth", localObject[0]);
      localJSONObject.put("topActivityHeight", localObject[1]);
      localJSONObject.put("navHeight", localObject[2]);
      if (!TextUtils.isEmpty(this.l)) {
        localJSONObject.put("colorBallData", new JSONObject(this.l));
      }
      if (f())
      {
        i1 = i2;
        if (this.m) {
          i1 = 1;
        }
        localJSONObject.put("isBlackWhiteMode", i1);
      }
      if (String.valueOf(41726).equals(this.j)) {
        a(localJSONObject);
      }
      localJSONObject.put("wifiMac", NetworkUtils.c(BaseApplicationImpl.getApplication()));
      localJSONObject.put("wifiSsid", NetworkUtils.d(BaseApplicationImpl.getApplication()));
      localJSONObject.put("is_last_index", this.n);
      localJSONObject.put("deviceLevel", HardwareUtil.judgeDeviceLevel(BaseApplication.getContext()));
      localJSONObject.put("usingV8", ViolaSoLoaderManager.a.a().c());
      return localJSONObject;
      StringBuilder localStringBuilder;
      label525:
      i1 = 0;
      break;
      label530:
      i1 = 0;
      break label537;
      label535:
      i1 = 1;
      label537:
      if (i1 != 0)
      {
        i1 = 1;
        break label232;
      }
      i1 = 0;
      break label232;
      i1 = 0;
    }
  }
  
  public String e()
  {
    return d().toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViolaCreactPageObject : url:");
    boolean bool = TextUtils.isEmpty(this.a);
    String str = "null";
    if (bool) {
      localObject = "null";
    } else {
      localObject = this.a;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    Object localObject = this.b;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((JSONObject)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    localObject = this.c;
    if (localObject == null) {
      localObject = str;
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.ViolaCreactPageObject
 * JD-Core Version:    0.7.0.1
 */