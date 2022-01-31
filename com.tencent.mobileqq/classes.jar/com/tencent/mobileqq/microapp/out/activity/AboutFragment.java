package com.tencent.mobileqq.microapp.out.activity;

import Wallet.ApkgConfig;
import adpn;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bdnn;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMiniApp;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.app.b.c;
import com.tencent.mobileqq.microapp.ui.a.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private TextView app_desc;
  private ImageView app_logo;
  private TextView app_name;
  a dialogFromBottom;
  private Button enter_miniapp;
  private ApkgConfig mConfig;
  private JSONObject mDescObj;
  private int mVersionType;
  private TextView owner_text;
  private Button recommend_to_friends;
  private TextView service_type_text;
  private ImageView title_back;
  private ImageView title_more;
  
  public static void launch(Context paramContext, MiniAppConfig paramMiniAppConfig, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("app_config", paramMiniAppConfig);
    localIntent.putExtra("versionType", paramInt);
    adpn.a(paramContext, localIntent, PublicFragmentActivityForMiniApp.class, AboutFragment.class);
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.aq) {
      if (this.mDescObj != null) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramView = new b.c(this.mConfig.mini_appid, this.mVersionType, this.mDescObj.optString("share_content"), this.mDescObj.optString("share_pic_url"), null);
                b.a().a(paramView);
                return;
                if (paramView.getId() == R.id.ay)
                {
                  getActivity().finish();
                  return;
                }
                if (paramView.getId() == R.id.az)
                {
                  this.dialogFromBottom = new a(getActivity());
                  this.dialogFromBottom.setContentView(LayoutInflater.from(getActivity()).inflate(R.layout.c, null));
                  paramView = (TextView)this.dialogFromBottom.findViewById(R.id.v);
                  paramView.setText("设置");
                  paramView.setOnClickListener(this);
                  paramView = (TextView)this.dialogFromBottom.findViewById(R.id.t);
                  paramView.setText("意见反馈");
                  paramView.setVisibility(0);
                  paramView.setOnClickListener(this);
                  paramView = (TextView)this.dialogFromBottom.findViewById(R.id.r);
                  paramView.setText("投诉");
                  paramView.setOnClickListener(this);
                  ((TextView)this.dialogFromBottom.findViewById(R.id.s)).setOnClickListener(this);
                  this.dialogFromBottom.show();
                  return;
                }
                if (paramView.getId() != R.id.v) {
                  break;
                }
                PermissionSettingFragment.launch(getActivity(), this.mConfig.mini_appid);
              } while (this.dialogFromBottom == null);
              this.dialogFromBottom.dismiss();
              return;
            } while (paramView.getId() == R.id.au);
            if (paramView.getId() != R.id.s) {
              break;
            }
          } while (this.dialogFromBottom == null);
          this.dialogFromBottom.dismiss();
          return;
          if (paramView.getId() != R.id.t) {
            break;
          }
          paramView = "http://i.qianbao.qq.com/miniapp/opinion/entry.html?appid=" + this.mConfig.mini_appid + "&logourl=" + this.mConfig.icon_url + "&appname=" + this.mConfig.app_name + "&_wv=59163&_wwv=4&appverid=" + this.mConfig.mini_version;
          localIntent = new Intent(getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", paramView);
          startActivity(localIntent);
        } while (this.dialogFromBottom == null);
        this.dialogFromBottom.dismiss();
        return;
        if (paramView.getId() != R.id.r) {
          break;
        }
        paramView = "http://i.qianbao.qq.com/miniapp/complain/entry.html?appid=" + this.mConfig.mini_appid + "&logourl=" + this.mConfig.icon_url + "&appname=" + this.mConfig.app_name + "&_wv=59163&_wwv=4&appverid=" + this.mConfig.mini_version;
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramView);
        startActivity(localIntent);
      } while (this.dialogFromBottom == null);
      this.dialogFromBottom.dismiss();
      return;
    } while (paramView.getId() != R.id.u);
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(R.layout.e, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramLayoutInflater.setFitsSystemWindows(true);
      paramLayoutInflater.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    }
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.title_back = ((ImageView)paramView.findViewById(R.id.ay));
    this.title_back.setOnClickListener(this);
    this.title_more = ((ImageView)paramView.findViewById(R.id.az));
    this.title_more.setOnClickListener(this);
    this.app_logo = ((ImageView)paramView.findViewById(R.id.d));
    this.app_name = ((TextView)paramView.findViewById(R.id.e));
    this.app_desc = ((TextView)paramView.findViewById(R.id.c));
    this.service_type_text = ((TextView)paramView.findViewById(R.id.at));
    this.owner_text = ((TextView)paramView.findViewById(R.id.al));
    this.enter_miniapp = ((Button)paramView.findViewById(R.id.u));
    this.enter_miniapp.setOnClickListener(this);
    this.recommend_to_friends = ((Button)paramView.findViewById(R.id.aq));
    this.recommend_to_friends.setOnClickListener(this);
    paramView = getActivity().getIntent();
    if (paramView != null)
    {
      this.mVersionType = paramView.getIntExtra("versionType", 0);
      paramView = (MiniAppConfig)paramView.getSerializableExtra("app_config");
      if (paramView != null)
      {
        this.mConfig = paramView.config;
        if (this.mConfig != null) {
          break label217;
        }
      }
    }
    label217:
    do
    {
      return;
      paramView = this.mConfig.desc_info;
    } while (bdnn.a(paramView));
    try
    {
      this.mDescObj = new JSONObject(paramView);
      paramView = this.mDescObj.getString("desc_info");
      paramBundle = this.mDescObj.getString("service_type");
      String str = this.mDescObj.getString("owner_info");
      this.app_name.setText(this.mConfig.app_name);
      this.app_desc.setText(paramView);
      this.service_type_text.setText(paramBundle);
      this.owner_text.setText(str);
      this.app_logo.setImageDrawable(URLDrawable.getDrawable(this.mConfig.icon_url));
      return;
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.AboutFragment
 * JD-Core Version:    0.7.0.1
 */