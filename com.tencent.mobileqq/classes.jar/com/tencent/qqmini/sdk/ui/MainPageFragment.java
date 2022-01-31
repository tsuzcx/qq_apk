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
import behj;
import betc;
import beut;
import beyk;
import bezl;
import bffq;
import bffr;
import bffs;
import bfft;
import bffw;
import bfgl;
import bfgp;
import bfhk;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainPageFragment
  extends MiniBaseFragment
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = MiniAppEnv.g().getContext().getFilesDir().getPath() + "/mini/";
  private static final String jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + "/tencent/mini/files/";
  private int jdField_a_of_type_Int;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bffs(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Switch jdField_a_of_type_AndroidWidgetSwitch;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfft jdField_a_of_type_Bfft;
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
    int i = bfgl.a(getActivity(), 70.0F);
    Drawable localDrawable = null;
    try
    {
      if (Build.VERSION.SDK_INT >= 21) {
        localDrawable = getActivity().getDrawable(2130840785);
      }
      return this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.getDrawable(getActivity(), paramString, i, i, localDrawable);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        betc.d("MainPageFragment", "getIconDrawable, exception!");
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
    bffw.a(paramContext, localIntent, MiniFragmentActivity.class, MainPageFragment.class);
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)
    {
      betc.d("MainPageFragment", "startMoreInformation, miniAppInfo = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      return;
    }
    String str2 = "https://q.qq.com/os/store/details-more?appid=" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId;
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString)) {
      str1 = str2 + "&token=" + paramString;
    }
    paramString = new Intent();
    paramString.putExtra("url", str1);
    paramString.putExtra("title", "更多资料");
    new Bundle().putBoolean("hide_more_button", true);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.startBrowserActivity(getActivity(), paramString);
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
      if (!bfhk.a())
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
    bezl.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, bezl.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo), null, "user_click", "more_about", paramString);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840786);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840813);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.launchParam.jdField_a_of_type_Int = 1024;
    behj.a(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
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
    this.jdField_a_of_type_Bfft = new bfft(getActivity());
    this.jdField_a_of_type_Bfft.setContentView(LayoutInflater.from(getActivity()).inflate(2131559303, null));
    TextView localTextView = (TextView)this.jdField_a_of_type_Bfft.findViewById(2131370324);
    localTextView.setText("设置");
    localTextView.setOnClickListener(this);
    localTextView = (TextView)this.jdField_a_of_type_Bfft.findViewById(2131370318);
    localTextView.setText("更多资料");
    localTextView.setOnClickListener(this);
    ((TextView)this.jdField_a_of_type_Bfft.findViewById(2131370301)).setOnClickListener(this);
    this.jdField_a_of_type_Bfft.show();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null)
    {
      betc.d("MainPageFragment", "startComplainAndCallback, mApkgConfig = " + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
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
        betc.d("MainPageFragment", "startComplainAndCallback, url = " + "");
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject2 = "https://tucao.qq.com/qq_miniprogram/tucao?appid=" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId + "&openid=" + a() + "&avatar=" + (String)localObject1 + "&nickname=游客";
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("url", (String)localObject2);
    ((Intent)localObject1).putExtra("title", "投诉与反馈");
    localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("hide_more_button", true);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyMiniAppProxy.startBrowserActivity(getActivity(), (Intent)localObject1);
    b("feedback");
    betc.a("MainPageFragment", "feedback, prepare to upload log ");
    localObject1 = new Bundle();
    ((Bundle)localObject1).putString("appid", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).callServer("MiniAppTransferModule", "upload_user_log", (Bundle)localObject1);
  }
  
  private void h() {}
  
  public String a()
  {
    return beut.a().a();
  }
  
  public void a(MiniAppInfo paramMiniAppInfo) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370304)
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
          if (i == 2131370311)
          {
            e();
            return;
          }
          if (i == 2131370323)
          {
            c(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
            return;
          }
          if (i == 2131370321)
          {
            h();
            b("share");
            return;
          }
        } while (i == 2131370322);
        if (i == 2131370298)
        {
          g();
          return;
        }
        if (i == 2131370327)
        {
          getActivity().finish();
          return;
        }
        if (i == 2131370328)
        {
          f();
          return;
        }
        if (i != 2131370324) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId)));
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).openPermissionSettingsActivity(getActivity(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      this.jdField_a_of_type_Bfft.dismiss();
      b("set");
      return;
      if (i == 2131370318)
      {
        if (bfhk.a()) {
          a(null);
        }
        for (;;)
        {
          this.jdField_a_of_type_Bfft.dismiss();
          b("profile");
          return;
          paramView = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
          if (paramView != null) {
            paramView.getSDKOpenKeyToken(null, new bffr(this));
          }
        }
      }
    } while (i != 2131370301);
    this.jdField_a_of_type_Bfft.dismiss();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559304, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(-1);
      bfgp.a(true, getActivity().getWindow());
    }
    if (bfgl.jdField_a_of_type_Boolean)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, bfgl.d(getActivity()), 0, 0);
    }
    a();
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    beyk.a().a(getClass().getSimpleName(), true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370314));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370319));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370300));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370313));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370312));
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131375954);
    this.jdField_a_of_type_AndroidWidgetSwitch = ((Switch)paramView.findViewById(2131370323));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370321));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131370304));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370322);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370298);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370311);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370327));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370328));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375955));
    this.e = paramView.findViewById(2131368376);
    this.jdField_a_of_type_AndroidWidgetSwitch.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnLongClickListener(new bffq(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MainPageFragment
 * JD-Core Version:    0.7.0.1
 */