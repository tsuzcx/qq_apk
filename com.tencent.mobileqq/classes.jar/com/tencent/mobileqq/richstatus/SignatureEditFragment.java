package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.etrump.mixlayout.FontManagerForTool;
import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.av.utils.UITools;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.sign.MySignViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.IWebViewFragmentInitor;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewKernel;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class SignatureEditFragment
  extends WebViewFragment
  implements Handler.Callback, ISignViewHolder.OnClickListener, IWebViewFragmentInitor
{
  public RichStatus a = new RichStatus(null);
  public RichStatus b = new RichStatus(null);
  public boolean c = false;
  public boolean d = false;
  private MySignViewHolder e;
  private View f;
  private View g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private TextView k;
  private TextView l;
  private Handler m;
  private boolean n = false;
  private int o;
  private boolean p = true;
  private View q;
  private int r;
  private Observer s = new SignatureEditFragment.7(this);
  
  private static int a(Context paramContext)
  {
    int i1 = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i1 > 0) {
      return paramContext.getResources().getDimensionPixelSize(i1);
    }
    return 0;
  }
  
  public static SignatureEditFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new SignatureEditFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    SignTextEditFragment.a(getQBaseActivity(), this.b, null, null, 16);
    String str;
    if (paramBoolean) {
      str = "0X800A63B";
    } else {
      str = "0X800A63A";
    }
    ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "0", "0", "", "");
  }
  
  private void d(int paramInt)
  {
    this.r = paramInt;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
    localStringBuilder.append("_sign_edit_red_dot_key");
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.apply();
  }
  
  private void e()
  {
    if (getQBaseActivity() != null)
    {
      RichStatus localRichStatus = this.a;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (localRichStatus != null)
      {
        bool1 = bool2;
        if (localRichStatus.tplId != 1) {
          if (this.a.tplId == 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      ImmersiveUtils.setStatusTextColor(bool1, getQBaseActivity().getWindow());
    }
  }
  
  private void f()
  {
    this.d = false;
    if (this.n)
    {
      if (this.a.mStickerInfos == null) {
        this.a.mStickerInfos = new ArrayList();
      } else {
        this.a.mStickerInfos.clear();
      }
    }
    else {
      this.a.mStickerInfos = null;
    }
    Object localObject = SignatureManagerForTool.a().a(this.a.tplId);
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).D != null))
    {
      this.a.plainText.set(0, ((SignatureTemplateInfo)localObject).s);
      localObject = this.a;
      ((RichStatus)localObject).actionId = 0;
      ((RichStatus)localObject).locationText = "";
      ((RichStatus)localObject).actionText = null;
      ((RichStatus)localObject).dataId = 0;
      ((RichStatus)localObject).dataText = null;
      ((RichStatus)localObject).topics.clear();
      this.a.topicsPos.clear();
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("my_signature", this.a);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.f, (Bundle)localObject, SignatureManagerForTool.a().c);
  }
  
  private void g()
  {
    Object localObject = SignatureManagerForTool.a().a(this.a.tplId);
    if (getAppRuntime() == null) {
      this.mApp = getQBaseActivity().getAppRuntime();
    }
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).B < 2) && ("signature_chouti".equals(getQBaseActivity().getIntent().getStringExtra("via"))))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
      localStringBuilder.append("new_signature_version_826");
      if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true))
      {
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
        localStringBuilder.append("new_signature_version_826");
        ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).apply();
        DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131911563), getActivity().getResources().getString(2131888847), HardCodeUtil.a(2131898212), getQBaseActivity().getResources().getString(2131888828), new SignatureEditFragment.4(this), new SignatureEditFragment.5(this)).show();
        VasWebviewUtil.a("signature_update", "show", "", 0, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void h()
  {
    Object localObject = SignatureManagerForTool.a().a(this.a.tplId);
    if (getAppRuntime() == null) {
      this.mApp = getQBaseActivity().getAppRuntime();
    }
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).B < 2) && (Integer.parseInt(((SignatureTemplateInfo)localObject).b) > 0) && (this.p))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
      localStringBuilder.append("edit_signature_version_826");
      if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
        localStringBuilder.append("new_signature_version_826");
        if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true))
        {
          localObject = ((SharedPreferences)localObject).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
          localStringBuilder.append("new_signature_version_826");
          ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).apply();
          DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131911563), getActivity().getResources().getString(2131888847), null, HardCodeUtil.a(2131913735), new SignatureEditFragment.6(this), null).show();
          VasWebviewUtil.a("signature_update", "show", "", 0, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
  
  private void i()
  {
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.e, null, SignatureManagerForTool.a().c);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "initSignatureView start");
    }
    if (this.a == null) {
      return;
    }
    if (this.e == null)
    {
      if (getAppRuntime() == null) {
        this.mApp = getQBaseActivity().getAppRuntime();
      }
      this.e = new MySignViewHolder(getActivity(), (AppInterface)getAppRuntime(), this.f, getAppRuntime().getCurrentAccountUin());
      this.e.a(this);
    }
    this.e.a(this.a);
    this.f.invalidate();
    c(this.a.tplId);
    e();
  }
  
  private void k()
  {
    if (getWebView() != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (TextUtils.isEmpty(((RichStatus)localObject).getPlainText())))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("result", 0);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localObject = WebViewPlugin.toJsScript("gxh.sign.setToDefault", (JSONObject)localObject, null);
        getWebView().callJs((String)localObject);
      }
    }
  }
  
  public int a(int paramInt)
  {
    return paramInt + -2147483648;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 1, "publishRichStatus");
    }
    int i1 = this.a.getTotalLenForShow();
    if (i1 > 80)
    {
      localObject = new Message();
      ((Message)localObject).what = 258;
      this.m.sendMessage((Message)localObject);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A63D", "0X800A63D", 0, 0, "0", "0", "", "");
    if (this.a.bOnlyHasTopic())
    {
      this.m.sendEmptyMessage(260);
      return;
    }
    Object localObject = SignatureManagerForTool.a().a(this.a.tplId);
    if ((i1 == 0) && (((SignatureTemplateInfo)localObject).D == null))
    {
      DialogUtil.a(getQBaseActivity(), 230, HardCodeUtil.a(2131911524), HardCodeUtil.a(2131911527), HardCodeUtil.a(2131911536), HardCodeUtil.a(2131911522), new SignatureEditFragment.2(this), new SignatureEditFragment.3(this)).show();
      return;
    }
    f();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleRenderSignature tplId = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" fontId = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" fontType = ");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(" actionId = ");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(" actionText = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" isDefault=");
      ((StringBuilder)localObject).append(paramInt5);
      QLog.d("Signature.Fragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      this.o = paramInt5;
      int i1;
      if ((!TextUtils.isEmpty(((RichStatus)localObject).actionText)) && (!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.a.actionText))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (((paramInt1 != this.a.tplId) || (paramInt2 != this.a.fontId) || (paramInt3 != this.a.fontType) || (paramInt4 != this.a.actionId) || (i1 != 0)) && (paramInt5 == 0)) {
        this.c = true;
      }
      localObject = this.a;
      ((RichStatus)localObject).tplId = paramInt1;
      ((RichStatus)localObject).fontId = paramInt2;
      ((RichStatus)localObject).fontType = paramInt3;
      ((RichStatus)localObject).actionId = paramInt4;
      if ((this.d) || (TextUtils.isEmpty(((RichStatus)localObject).getPlainText())))
      {
        this.d = true;
        this.a.plainText.set(0, paramString);
      }
      paramString = this.a;
      paramString.dataId = 0;
      paramString.dataText = "";
      if (paramInt5 == 0) {
        SignatureManagerForTool.a().a(this.a);
      }
      paramString = this.m;
      if (paramString != null) {
        paramString.sendEmptyMessage(257);
      }
    }
  }
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("Signature.Fragment", 1, new Object[] { "onClick viewType=", paramView });
    if ((paramInt != 2) && (paramInt != 1)) {
      return;
    }
    b(false);
    VasWebviewUtil.a("signature_store", "click_signature", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public int b(int paramInt)
  {
    return paramInt + 1291845632;
  }
  
  public void b()
  {
    if ((this.c) && (!this.p))
    {
      DialogUtil.a(getQBaseActivity(), 230, HardCodeUtil.a(2131911542), HardCodeUtil.a(2131911537), HardCodeUtil.a(2131911541), HardCodeUtil.a(2131911529), new SignatureEditFragment.8(this), new SignatureEditFragment.9(this)).show();
      return;
    }
    getQBaseActivity().finish();
  }
  
  public int c()
  {
    if (this.r < 2)
    {
      d(2);
      return 1;
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = -2611;
    int[] tmp11_5 = tmp5_4;
    tmp11_5[1] = -1046;
    tmp11_5;
    Object localObject = arrayOfInt;
    if (paramInt > 1)
    {
      SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(this.a.tplId);
      localObject = arrayOfInt;
      if (localSignatureTemplateInfo != null)
      {
        localObject = arrayOfInt;
        if (!TextUtils.isEmpty(localSignatureTemplateInfo.A))
        {
          paramInt = Color.parseColor(localSignatureTemplateInfo.A);
          localObject = new int[2];
          localObject[0] = b(paramInt);
          localObject[1] = a(paramInt);
        }
      }
    }
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, (int[])localObject);
    this.j.setImageDrawable((Drawable)localObject);
    this.j.setBackgroundColor(-1);
  }
  
  public void d() {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 16) {
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("publish_ever", false)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Signature.Fragment", 2, "doOnActivityResult refetch");
      }
      SignatureManagerForTool.a().a = null;
      SignatureManagerForTool.a().b = null;
      i();
      d();
    }
  }
  
  public void doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      b();
    }
    super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    e();
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new SignatureEditFragment.1(this, this.webViewSurface);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 262: 
      if (paramMessage.arg1 >= 0)
      {
        this.k.setVisibility(0);
        this.k.setText(String.format(getString(2131916676), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.k.setVisibility(8);
      return true;
    case 261: 
      QQToast.makeText(getQBaseActivity(), 1, HardCodeUtil.a(2131911517), 1).show();
      return true;
    case 260: 
      QQToast.makeText(getQBaseActivity(), 1, HardCodeUtil.a(2131911528), 1).show();
      return true;
    case 259: 
      paramMessage = (HashMap)paramMessage.obj;
      this.webViewKernel.a(8589934617L, paramMessage);
      return true;
    case 258: 
      QQToast.makeText(getQBaseActivity(), 1, HardCodeUtil.a(2131911515), 1).show();
      return true;
    }
    j();
    return true;
  }
  
  public WebViewFragment newInstance(int paramInt, SwiftWebViewFragmentSupporter paramSwiftWebViewFragmentSupporter, WebViewTabBarData paramWebViewTabBarData, Intent paramIntent)
  {
    if (paramWebViewTabBarData.url.contains("signatureEdit=1")) {
      return a(paramIntent);
    }
    paramIntent.removeExtra("isTransparentTitle");
    if (paramSwiftWebViewFragmentSupporter != null) {
      return paramSwiftWebViewFragmentSupporter.createFragment(paramIntent);
    }
    return WebViewFragment.newInstance(paramIntent);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131446017: 
      b(true);
      VasWebviewUtil.a("signature_store", "click_edit", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131446011: 
      if (this.r < 1)
      {
        d(1);
        this.q.setVisibility(4);
      }
      this.webViewKernel.a(8589934616L, null);
      if (this.n) {
        localObject = "signature_7";
      } else {
        localObject = "signature_4";
      }
      VasWebviewUtil.a(getAppRuntime().getCurrentAccountUin(), "signature", (String)localObject, "", 1, 0, 0, "", "", "");
      break;
    case 2131446009: 
      if ((this.c) && (this.o == 0))
      {
        SignatureManagerForTool.a().a(this.a);
      }
      else
      {
        this.a = new RichStatus(null);
        this.a.setEmptyStatus(true);
      }
      localObject = new Intent(getActivity(), PublicFragmentActivity.class);
      ((Intent)localObject).putExtra("key_uin", getAppRuntime().getCurrentAccountUin());
      ((Intent)localObject).putExtra("key_uin_name", ((AppInterface)getAppRuntime()).getCurrentNickname());
      ((Intent)localObject).putExtra("key_open_via", "history-geqian");
      PublicFragmentActivity.Launcher.a(getQBaseActivity(), (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
      ReportController.b(null, "dc00898", "", "", "0X800A63C", "0X800A63C", 0, 0, "0", "0", "", "");
      VasWebviewUtil.a("signature_store", "history_enter", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131446007: 
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.m = new Handler(Looper.getMainLooper(), this);
    FontManagerForTool.a().addObserver(this.s);
    SignatureManagerForTool.a().addObserver(this.s);
    this.n = getIntent().getBooleanExtra("open_diy", false);
    g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "onCreateView");
    }
    ApngImage.playByTag(17);
    SoftInputDetectView localSoftInputDetectView = (SoftInputDetectView)paramLayoutInflater.inflate(2131628471, null);
    this.f = localSoftInputDetectView.findViewById(2131445999);
    Object localObject = localSoftInputDetectView.findViewById(2131446013).getLayoutParams();
    int i1 = SystemUtil.getNotchHeight(getQBaseActivity(), getQBaseActivity());
    if (i1 > ((ViewGroup.LayoutParams)localObject).height)
    {
      ((ViewGroup.LayoutParams)localObject).height = i1;
    }
    else
    {
      i1 = a(getQBaseActivity());
      if (i1 > ((ViewGroup.LayoutParams)localObject).height) {
        ((ViewGroup.LayoutParams)localObject).height = i1;
      }
    }
    localSoftInputDetectView.findViewById(2131446010).setOnClickListener(this);
    if (this.n) {
      ((TextView)localSoftInputDetectView.findViewById(2131446014)).setText("DIY签名");
    }
    this.f.setOnClickListener(this);
    this.g = localSoftInputDetectView.findViewById(2131446011);
    this.g.setOnTouchListener(UITools.a);
    this.g.setOnClickListener(this);
    this.l = ((TextView)localSoftInputDetectView.findViewById(2131446017));
    this.l.setOnClickListener(this);
    this.l.setOnTouchListener(UITools.a);
    this.k = ((TextView)localSoftInputDetectView.findViewById(2131446018));
    this.h = ((TextView)localSoftInputDetectView.findViewById(2131446009));
    this.h.setOnClickListener(this);
    this.i = ((TextView)localSoftInputDetectView.findViewById(2131446007));
    this.i.setOnClickListener(this);
    UIUtils.a(this.i, 0, 0, 0, UIUtils.a(getQBaseActivity(), 10.0F));
    this.q = localSoftInputDetectView.findViewById(2131446012);
    i1 = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (i1 == 1) {
      bool = false;
    }
    localSoftInputDetectView.setExcludeStatusBar(bool);
    localObject = (RelativeLayout)localSoftInputDetectView.findViewById(2131446016);
    this.j = ((ImageView)localSoftInputDetectView.findViewById(2131446008));
    ((RelativeLayout)localObject).addView(super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle), new RelativeLayout.LayoutParams(-1, -1));
    j();
    i();
    VasWebviewUtil.a("signature_store", "head_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localSoftInputDetectView);
    return localSoftInputDetectView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((MySignViewHolder)localObject).v();
    }
    FontManagerForTool.a().deleteObserver(this.s);
    SignatureManagerForTool.a().deleteObserver(this.s);
    localObject = this.m;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    SignatureManagerForTool.a().a = null;
    SignatureManagerForTool.a().b = null;
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (((RichStatus)localObject).isEmptyStatus())
    {
      this.a.setEmptyStatus(false);
      i();
      if ((getAppRuntime() != null) && (!TextUtils.isEmpty(getAppRuntime().getCurrentAccountUin())))
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
        localStringBuilder.append("_has_history_sig_del_key");
        if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
        {
          d();
          localObject = ((SharedPreferences)localObject).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
          localStringBuilder.append("_has_history_sig_del_key");
          ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), false).apply();
        }
      }
    }
    else
    {
      localObject = SignatureManagerForTool.a().a;
      if ((localObject != null) && (this.o == 0))
      {
        this.a.copyFrom((RichStatus)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i("Signature.Fragment", 2, String.format("onResume %s", new Object[] { ((RichStatus)localObject).getPlainText() }));
        }
        j();
      }
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment
 * JD-Core Version:    0.7.0.1
 */