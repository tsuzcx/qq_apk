package com.tencent.mobileqq.wxmini.impl.ui;

import NS_MINI_INTERFACE.INTERFACE.StGetWeixinSDKAppInfoRsp;
import NS_MINI_INTERFACE.INTERFACE.StWeixinSDKAppInfo;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.data.WeixinMiniAppInfo;
import com.tencent.mobileqq.wxmini.impl.WxMiniSDKImpl;
import com.tencent.mobileqq.wxmini.impl.loader.WxDFLoader;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class PreloadingFragment
  extends PublicBaseFragment
{
  private View a;
  private LinearLayout b;
  private Handler c;
  private volatile int d;
  
  public PreloadingFragment()
  {
    QLog.i("wxmini.PreloadingFragment", 1, "LoadingFragment()");
    this.a = LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131625349, null);
    this.b = ((LinearLayout)this.a.findViewById(2131437648));
  }
  
  private int a()
  {
    int j = QzoneConfig.getInstance().getConfig("qqminiapp", "wxMiniAppMaxProcessCount", 2);
    int i = j;
    if (j <= 1) {
      i = 1;
    }
    j = i;
    if (i >= 5) {
      j = 5;
    }
    return j;
  }
  
  private WeixinMiniAppInfo a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = (byte[])paramJSONObject.opt("appInfo_pb");
      if (localObject != null)
      {
        paramJSONObject = new INTERFACE.StGetWeixinSDKAppInfoRsp();
        paramJSONObject.mergeFrom((byte[])localObject);
        localObject = new WeixinMiniAppInfo();
        ((WeixinMiniAppInfo)localObject).a = paramJSONObject.appInfo.appid.get();
        ((WeixinMiniAppInfo)localObject).b = paramJSONObject.appInfo.appName.get();
        ((WeixinMiniAppInfo)localObject).c = paramJSONObject.appInfo.appIcon.get();
        ((WeixinMiniAppInfo)localObject).d = paramJSONObject.appInfo.appDesc.get();
        ((WeixinMiniAppInfo)localObject).e = paramJSONObject.appInfo.appType.get();
        return localObject;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("wxmini.PreloadingFragment", 1, "getWeixinAppInfo failed ", paramJSONObject);
    }
    return null;
  }
  
  private void a(Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new PreloadingFragment.10(this, paramContext));
  }
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).getWeixinSDKAppInfo(paramString, new PreloadingFragment.7(this, paramContext, paramInt, paramString));
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    WxMiniSDKImpl.a.c().launchWxaApp(paramContext, paramString1, 0, paramString2, new PreloadingFragment.9(this, paramInt));
  }
  
  private void a(String paramString, int paramInt)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).updateRecentPlay(paramString, paramInt);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      FragmentActivity localFragmentActivity = getActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startWxMiniApp url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("  type:");
      localStringBuilder.append(paramInt1);
      QLog.d("wxmini.PreloadingFragment", 1, localStringBuilder.toString());
      if (WxDFLoader.a().b())
      {
        this.d = 2;
        WxMiniSDKImpl.a.c().checkAuthState(new PreloadingFragment.3(this, paramString, paramInt1, localFragmentActivity, paramInt2));
        return;
      }
      ThreadManager.getUIHandler().post(new PreloadingFragment.4(this, localFragmentActivity));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("wxmini.PreloadingFragment", 1, "doStartWxMiniApp failed", paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      FragmentActivity localFragmentActivity = getActivity();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startWxMiniApp appid:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("  scene:");
      localStringBuilder.append(paramInt);
      QLog.d("wxmini.PreloadingFragment", 1, localStringBuilder.toString());
      if (WxDFLoader.a().b())
      {
        this.d = 2;
        WxMiniSDKImpl.a.c().checkAuthState(new PreloadingFragment.5(this, paramString1, localFragmentActivity, paramString2, paramInt));
        return;
      }
      ThreadManager.getUIHandler().post(new PreloadingFragment.6(this, localFragmentActivity));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("wxmini.PreloadingFragment", 1, "doStartWxMiniApp failed", paramString1);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("page_view", paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  private void b()
  {
    QLog.i("wxmini.PreloadingFragment", 1, "LoadingFragment doTask");
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      c();
      return;
    }
    String str1 = localBundle.getString("wxmini_link");
    String str2 = localBundle.getString("wxmini_appid");
    int i = localBundle.getInt("wxmini_link_type");
    String str3 = localBundle.getString("wxmini_path");
    int j = localBundle.getInt("wxmini_scene", 9999);
    getBaseActivity().runOnUiThread(new PreloadingFragment.2(this));
    if (TextUtils.isEmpty(str2))
    {
      a(str1, i, j);
      return;
    }
    a(str2, str3, j);
  }
  
  private void b(Context paramContext)
  {
    new Handler(Looper.getMainLooper()).post(new PreloadingFragment.11(this, paramContext));
  }
  
  private void b(Context paramContext, String paramString, int paramInt)
  {
    WxMiniSDKImpl.a.c().launchByQRRawData(paramContext, paramString, null, new PreloadingFragment.8(this, paramInt));
  }
  
  private void b(@Nullable String paramString, int paramInt)
  {
    SimpleMiniAppConfig.SimpleMiniAppInfo localSimpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
    localSimpleMiniAppInfo.appId = paramString;
    paramString = new SimpleMiniAppConfig(localSimpleMiniAppInfo);
    paramString.launchParam.scene = paramInt;
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramString, "page_view", "wx_show", "", "");
  }
  
  private void c()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing())) {
      localBaseActivity.finish();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("wxmini.PreloadingFragment", 1, "LoadingFragment onCreate");
    if (!WxMiniSDKImpl.a.a()) {
      WxMiniSDKImpl.a.a(BaseApplicationImpl.sApplication);
    }
    this.d = 1;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("wxmini.PreloadingFragment", 1, "LoadingFragment onCreateView");
    if (this.a == null)
    {
      this.a = LayoutInflater.from(getBaseActivity()).inflate(2131625349, null);
      this.b = ((LinearLayout)this.a.findViewById(2131437648));
    }
    return this.a;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d = 1;
    QLog.d("wxmini.PreloadingFragment", 1, "LoadingFragment onDestroy...");
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.d == 3)
    {
      QLog.i("wxmini.PreloadingFragment", 1, "LoadingFragment preloading_state == STATE_SEND_AUTH return");
      return;
    }
    ThreadManagerV2.excute(new PreloadingFragment.1(this), 16, null, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    QLog.i("wxmini.PreloadingFragment", 1, "LoadingFragment onViewCreated");
    this.c = new Handler(Looper.getMainLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.wxmini.impl.ui.PreloadingFragment
 * JD-Core Version:    0.7.0.1
 */