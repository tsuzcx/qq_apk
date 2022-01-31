package com.tencent.qqmini.sdk.core.auth.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import behf;
import behl;
import behn;
import behs;
import beht;
import behu;
import behv;
import behw;
import behx;
import bemn;
import besl;
import bfff;
import bffu;
import bffy;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.ui.MiniFragmentActivity;
import java.util.List;

public class PermissionSettingFragment
  extends MiniBaseFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static boolean a;
  private static final String jdField_b_of_type_JavaLangString = PermissionSettingFragment.class.getName();
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public behf a;
  private behu jdField_a_of_type_Behu;
  String jdField_a_of_type_JavaLangString;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_appid", paramString1);
    localIntent.putExtra("key_name", paramString2);
    bfff.a(paramActivity, localIntent, MiniFragmentActivity.class, PermissionSettingFragment.class, paramInt);
  }
  
  private void a(Context paramContext)
  {
    behs localbehs = new behs(paramContext);
    paramContext = new beht(paramContext);
    behl.a().a(new behn[] { localbehs, paramContext });
  }
  
  private void a(String paramString)
  {
    List localList;
    if (this.jdField_a_of_type_Behf != null)
    {
      localList = this.jdField_a_of_type_Behf.a(6);
      this.jdField_a_of_type_Behu = new behu(getActivity(), this);
      if ((localList == null) || (localList.size() <= 0)) {
        break label125;
      }
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
      if (!TextUtils.isEmpty(paramString))
      {
        this.d.setVisibility(0);
        this.d.setText("允许\"" + paramString + "\"使用我的");
      }
      this.jdField_a_of_type_Behu.a(localList);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Behu);
      return;
      localList = null;
      break;
      label125:
      this.c.setText(paramString + "未使用你任何信息");
      this.c.setVisibility(0);
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str = (String)paramCompoundButton.getTag();
    if (!TextUtils.isEmpty(str))
    {
      if ((!paramBoolean) && (!jdField_a_of_type_Boolean))
      {
        jdField_a_of_type_Boolean = true;
        bemn localbemn = new bemn(getActivity(), 2131755752);
        localbemn.setContentView(2131559295);
        localbemn.a("权限设置").a("关闭授权后可能会影响使用小程序的部分功能，请确认").b("关闭授权", Color.parseColor("#5B6B92"), new behx(this, str, paramBoolean)).a("取消", Color.parseColor("#000000"), new behw(this, paramCompoundButton));
        localbemn.show();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Behu.a(str, paramBoolean);
    this.jdField_a_of_type_Behf.a(str, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368429) {
      getActivity().finish();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131559307, null);
    if (bffu.jdField_a_of_type_Boolean) {
      paramLayoutInflater.setFitsSystemWindows(true);
    }
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#EFEFF4"));
    if (Build.VERSION.SDK_INT >= 23)
    {
      getActivity().getWindow().clearFlags(67108864);
      getActivity().getWindow().addFlags(-2147483648);
      getActivity().getWindow().setStatusBarColor(Color.parseColor("#EFEFF4"));
      bffy.a(true, getActivity().getWindow());
    }
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("key_appid");
    paramBundle = getActivity().getIntent().getStringExtra("key_name");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      getActivity().finish();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368429));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368472));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("返回");
    this.jdField_b_of_type_AndroidWidgetTextView.setText("设置");
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)paramView.findViewById(2131371379));
    this.c = ((TextView)paramView.findViewById(2131371380));
    this.d = ((TextView)paramView.findViewById(2131370321));
    this.jdField_a_of_type_Behf = MiniAppEnv.g().getAuthSate(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Behf == null)
    {
      besl.d(jdField_b_of_type_JavaLangString, "getAuthorizeCenter(appId), authState is null?!");
      return;
    }
    if (this.jdField_a_of_type_Behf.a())
    {
      a(paramBundle);
      return;
    }
    if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(getActivity());
    }
    this.jdField_a_of_type_AndroidAppProgressDialog.setMessage("正在获取权限信息，请稍候...");
    this.jdField_a_of_type_AndroidAppProgressDialog.show();
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getAuthList(this.jdField_a_of_type_JavaLangString, new behv(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.auth.ui.PermissionSettingFragment
 * JD-Core Version:    0.7.0.1
 */