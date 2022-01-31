package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import bgte;
import bgxf;
import bgyg;
import bhhv;
import bhhw;
import bhhx;
import bhhy;
import bhib;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainPageFragment
  extends MiniBaseFragment
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = AppLoaderFactory.g().getMiniAppEnv().getContext().getFilesDir().getPath() + "/mini/";
  private static final String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/files/";
  private int jdField_a_of_type_Int;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bhhx(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Switch jdField_a_of_type_AndroidWidgetSwitch;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhhy jdField_a_of_type_Bhhy;
  private MiniAppProxy jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  
  private Drawable a(String paramString)
  {
    int i = DisplayUtil.dip2px(getActivity(), 70.0F);
    Drawable localDrawable = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        localDrawable = getActivity().getDrawable(2130840897);
      }
      return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getDrawable(getActivity(), paramString, i, i, localDrawable);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.e("MainPageFragment", "getIconDrawable, exception!");
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private void a()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = ((MiniAppInfo)localBundle.getParcelable("mini_app_info"));
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isEngineTypeMiniGame();
    }
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText("为小游戏点赞");
      }
    }
    while (paramInt <= 0)
    {
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("为小程序点赞");
      return;
    }
    if (paramInt > 9999)
    {
      float f = paramInt / 10000.0F;
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format("%.2f", new Object[] { Float.valueOf(f) }) + "万" + "个赞");
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramInt + "个赞");
  }
  
  public static void a(Context paramContext, MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("mini_app_info", paramMiniAppInfo);
    localIntent.putExtra("versionType", paramInt);
    bhib.a(paramContext, localIntent, MiniFragmentActivity.class, MainPageFragment.class);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)
    {
      QMLog.e("MainPageFragment", "startMoreInformation, miniAppInfo = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      return;
    }
    Object localObject = "https://q.qq.com/os/store/details-more?appid=" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
    MiniAppProxy localMiniAppProxy;
    if (!TextUtils.isEmpty(paramString)) {
      localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    }
    for (paramString = (String)localObject + "&token=" + paramString + "&uin=" + localMiniAppProxy.getAccount();; paramString = (String)localObject)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("url", paramString);
      ((Intent)localObject).putExtra("title", "更多资料");
      new Bundle().putBoolean("hide_more_button", true);
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.startBrowserActivity(getActivity(), (Intent)localObject);
      return;
    }
  }
  
  private void a(boolean paramBoolean) {}
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.iconUrl));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.desc);
      boolean bool = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isAppStoreMiniApp();
      if ((bool) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isInternalApp()))
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        if (bool)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          if (this.e != null) {
            this.e.setVisibility(8);
          }
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText("添加至我的小程序");
      this.jdField_a_of_type_AndroidWidgetButton.setText("推荐小游戏");
      this.jdField_b_of_type_AndroidWidgetButton.setText("进入小游戏");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("为小游戏点赞");
    }
    for (;;)
    {
      if (!QUAUtil.isQQApp())
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setText("为小程序点赞");
    }
  }
  
  private void b(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo.topType == 0)
    {
      this.jdField_a_of_type_AndroidWidgetSwitch.setChecked(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetSwitch.setChecked(true);
  }
  
  private void b(String paramString)
  {
    bgyg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bgyg.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), null, "user_click", "more_about", paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840898);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840925);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.scene = 1024;
    MiniSDK.startMiniApp(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
  }
  
  private void c(MiniAppInfo paramMiniAppInfo)
  {
    int i;
    if (paramMiniAppInfo.topType == 0)
    {
      i = 1;
      paramMiniAppInfo.topType = i;
      b(paramMiniAppInfo);
      a(paramMiniAppInfo);
      if (paramMiniAppInfo.topType != 0) {
        break label46;
      }
    }
    label46:
    for (paramMiniAppInfo = "settop_off";; paramMiniAppInfo = "settop_on")
    {
      b(paramMiniAppInfo);
      return;
      i = 0;
      break;
    }
  }
  
  private void d() {}
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int -= 1;
      a(this.jdField_a_of_type_Int);
      b(this.jdField_a_of_type_Boolean);
      a(this.jdField_a_of_type_Boolean);
      if (!this.jdField_a_of_type_Boolean) {
        break label81;
      }
    }
    label81:
    for (String str = "like_on";; str = "like_off")
    {
      b(str);
      return;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int += 1;
      break;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Bhhy = new bhhy(getActivity());
    this.jdField_a_of_type_Bhhy.setContentView(LayoutInflater.from(getActivity()).inflate(2131559352, null));
    TextView localTextView = (TextView)this.jdField_a_of_type_Bhhy.findViewById(2131370623);
    localTextView.setText("设置");
    localTextView.setOnClickListener(this);
    localTextView = (TextView)this.jdField_a_of_type_Bhhy.findViewById(2131370617);
    localTextView.setText("更多资料");
    localTextView.setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Bhhy.findViewById(2131370599)).setOnClickListener(this);
    this.jdField_a_of_type_Bhhy.show();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)
    {
      QMLog.e("MainPageFragment", "startComplainAndCallback, mApkgConfig = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      return;
    }
    Object localObject1 = "";
    try
    {
      localObject2 = URLEncoder.encode("https://support.qq.com/data/1368/2018/0927/5e6c84b68d1f3ad390e7beeb6c2f83b0.jpeg", "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        QMLog.e("MainPageFragment", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + "&openid=" + a() + "&avatar=" + (String)localObject1 + "&nickname=游客";
    localObject1 = localObject2;
    if (!QUAUtil.isQQApp()) {
      localObject1 = (String)localObject2 + "&customInfo=-" + this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getPlatformId();
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("title", "投诉与反馈");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("hide_more_button", true);
    ((Intent)localObject2).putExtras((Bundle)localObject1);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.startBrowserActivity(getActivity(), (Intent)localObject2);
    b("feedback");
    QMLog.d("MainPageFragment", "feedback, prepare to upload log ");
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).uploadUserLog(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
  }
  
  private void h() {}
  
  public String a()
  {
    return bgte.a().a();
  }
  
  public void a(MiniAppInfo paramMiniAppInfo) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370602)
    {
      c();
      b("launch");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (i == 2131370609)
          {
            e();
            return;
          }
          if (i == 2131370622)
          {
            c(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
            return;
          }
          if (i == 2131370620)
          {
            h();
            b("share");
            return;
          }
        } while (i == 2131370621);
        if (i == 2131370596)
        {
          g();
          return;
        }
        if (i == 2131370626)
        {
          getActivity().finish();
          return;
        }
        if (i == 2131370627)
        {
          f();
          return;
        }
        if (i != 2131370623) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId)));
      ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      this.jdField_a_of_type_Bhhy.dismiss();
      b("set");
      return;
      if (i == 2131370617)
      {
        if (QUAUtil.isQQApp()) {
          a(null);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bhhy.dismiss();
          b("profile");
          return;
          paramView = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
          if (paramView != null) {
            paramView.getSDKOpenKeyToken(null, new bhhw(this));
          }
        }
      }
    } while (i != 2131370599);
    this.jdField_a_of_type_Bhhy.dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559353, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
    if (DisplayUtil.isImmersiveSupported)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, DisplayUtil.getStatusBarHeight(getActivity()), 0, 0);
    }
    a();
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    bgxf.a().a(getClass().getSimpleName(), true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370612));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370618));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370598));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370611));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370610));
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376453);
    this.jdField_a_of_type_AndroidWidgetSwitch = ((Switch)paramView.findViewById(2131370622));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370620));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370602));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370621);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370596);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370609);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370626));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370627));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376454));
    this.e = paramView.findViewById(2131368559);
    this.jdField_a_of_type_AndroidWidgetSwitch.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnLongClickListener(new bhhv(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment
 * JD-Core Version:    0.7.0.1
 */