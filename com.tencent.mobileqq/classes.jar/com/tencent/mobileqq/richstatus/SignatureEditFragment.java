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
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public RichStatus a;
  private MySignViewHolder jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder;
  private Observer jdField_a_of_type_JavaUtilObserver = new SignatureEditFragment.7(this);
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public RichStatus b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = true;
  
  public SignatureEditFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private static int a(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
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
  
  private void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
    localStringBuilder.append("_sign_edit_red_dot_key");
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.apply();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    SignTextEditFragment.a(getQBaseActivity(), this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus, null, null, 16);
    String str;
    if (paramBoolean) {
      str = "0X800A63B";
    } else {
      str = "0X800A63A";
    }
    ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "0", "0", "", "");
  }
  
  private void d()
  {
    if (getQBaseActivity() != null)
    {
      RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (localRichStatus != null)
      {
        bool1 = bool2;
        if (localRichStatus.tplId != 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId == 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
      ImmersiveUtils.setStatusTextColor(bool1, getQBaseActivity().getWindow());
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = new ArrayList();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos.clear();
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = null;
    }
    Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((SignatureTemplateInfo)localObject).n);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      ((RichStatus)localObject).actionId = 0;
      ((RichStatus)localObject).locationText = "";
      ((RichStatus)localObject).actionText = null;
      ((RichStatus)localObject).dataId = 0;
      ((RichStatus)localObject).dataText = null;
      ((RichStatus)localObject).topics.clear();
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
    }
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("my_signature", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.f, (Bundle)localObject, SignatureManagerForTool.a().jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  private void f()
  {
    Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (getAppRuntime() == null) {
      this.mApp = getQBaseActivity().getAppRuntime();
    }
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).f < 2) && ("signature_chouti".equals(getQBaseActivity().getIntent().getStringExtra("via"))))
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
        DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131714032), getActivity().getResources().getString(2131691880), HardCodeUtil.a(2131714169), getQBaseActivity().getResources().getString(2131691863), new SignatureEditFragment.4(this), new SignatureEditFragment.5(this)).show();
        VasWebviewUtil.a("signature_update", "show", "", 0, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void g()
  {
    Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (getAppRuntime() == null) {
      this.mApp = getQBaseActivity().getAppRuntime();
    }
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).f < 2) && (Integer.parseInt(((SignatureTemplateInfo)localObject).jdField_a_of_type_JavaLangString) > 0) && (this.jdField_d_of_type_Boolean))
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
          DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131714032), getActivity().getResources().getString(2131691880), null, HardCodeUtil.a(2131716293), new SignatureEditFragment.6(this), null).show();
          VasWebviewUtil.a("signature_update", "show", "", 0, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
  
  private void h()
  {
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.e, null, SignatureManagerForTool.a().jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "initSignatureView start");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder == null)
    {
      if (getAppRuntime() == null) {
        this.mApp = getQBaseActivity().getAppRuntime();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder = new MySignViewHolder(getActivity(), (AppInterface)getAppRuntime(), this.jdField_a_of_type_AndroidViewView, getAppRuntime().getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    this.jdField_a_of_type_AndroidViewView.invalidate();
    a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    d();
  }
  
  private void j()
  {
    if (getWebView() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
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
  
  public int a()
  {
    if (this.jdField_b_of_type_Int < 2)
    {
      b(2);
      return 1;
    }
    return 0;
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
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getTotalLenForShow();
    if (i > 80)
    {
      localObject = new Message();
      ((Message)localObject).what = 258;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A63D", "0X800A63D", 0, 0, "0", "0", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.bOnlyHasTopic())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(260);
      return;
    }
    Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if ((i == 0) && (((SignatureTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem == null))
    {
      DialogUtil.a(getQBaseActivity(), 230, HardCodeUtil.a(2131713993), HardCodeUtil.a(2131713996), HardCodeUtil.a(2131714005), HardCodeUtil.a(2131713991), new SignatureEditFragment.2(this), new SignatureEditFragment.3(this)).show();
      return;
    }
    e();
  }
  
  public void a(int paramInt)
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
      SignatureTemplateInfo localSignatureTemplateInfo = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      localObject = arrayOfInt;
      if (localSignatureTemplateInfo != null)
      {
        localObject = arrayOfInt;
        if (!TextUtils.isEmpty(localSignatureTemplateInfo.t))
        {
          paramInt = Color.parseColor(localSignatureTemplateInfo.t);
          localObject = new int[2];
          localObject[0] = b(paramInt);
          localObject[1] = a(paramInt);
        }
      }
    }
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, (int[])localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(-1);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = paramInt5;
      int i;
      if ((!TextUtils.isEmpty(((RichStatus)localObject).actionText)) && (!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText))) {
        i = 1;
      } else {
        i = 0;
      }
      if (((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId) || (paramInt3 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType) || (paramInt4 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId) || (i != 0)) && (paramInt5 == 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      ((RichStatus)localObject).tplId = paramInt1;
      ((RichStatus)localObject).fontId = paramInt2;
      ((RichStatus)localObject).fontType = paramInt3;
      ((RichStatus)localObject).actionId = paramInt4;
      if ((this.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(((RichStatus)localObject).getPlainText())))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, paramString);
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      paramString.dataId = 0;
      paramString.dataText = "";
      if (paramInt5 == 0) {
        SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int b(int paramInt)
  {
    return paramInt + 1291845632;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      DialogUtil.a(getQBaseActivity(), 230, HardCodeUtil.a(2131714011), HardCodeUtil.a(2131714006), HardCodeUtil.a(2131714010), HardCodeUtil.a(2131713998), new SignatureEditFragment.8(this), new SignatureEditFragment.9(this)).show();
      return;
    }
    getQBaseActivity().finish();
  }
  
  public void c() {}
  
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
      SignatureManagerForTool.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
      SignatureManagerForTool.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
      h();
      c();
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
    d();
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
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719140), new Object[] { Integer.valueOf(paramMessage.arg1) }));
        return true;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return true;
    case 261: 
      QQToast.a(getQBaseActivity(), 1, HardCodeUtil.a(2131713986), 1).a();
      return true;
    case 260: 
      QQToast.a(getQBaseActivity(), 1, HardCodeUtil.a(2131713997), 1).a();
      return true;
    case 259: 
      paramMessage = (HashMap)paramMessage.obj;
      this.webViewKernel.a(8589934617L, paramMessage);
      return true;
    case 258: 
      QQToast.a(getQBaseActivity(), 1, HardCodeUtil.a(2131713984), 1).a();
      return true;
    }
    i();
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
    case 2131377609: 
      b(true);
      VasWebviewUtil.a("signature_store", "click_edit", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131377603: 
      if (this.jdField_b_of_type_Int < 1)
      {
        b(1);
        this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      }
      this.webViewKernel.a(8589934616L, null);
      if (this.jdField_c_of_type_Boolean) {
        localObject = "signature_7";
      } else {
        localObject = "signature_4";
      }
      VasWebviewUtil.a(getAppRuntime().getCurrentAccountUin(), "signature", (String)localObject, "", 1, 0, 0, "", "", "");
      break;
    case 2131377601: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
      {
        SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.setEmptyStatus(true);
      }
      localObject = new Intent(getActivity(), PublicFragmentActivity.class);
      ((Intent)localObject).putExtra("key_uin", getAppRuntime().getCurrentAccountUin());
      ((Intent)localObject).putExtra("key_uin_name", ((AppInterface)getAppRuntime()).getCurrentNickname());
      ((Intent)localObject).putExtra("key_open_via", "history-geqian");
      PublicFragmentActivity.Launcher.a(getQBaseActivity(), (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
      ReportController.b(null, "dc00898", "", "", "0X800A63C", "0X800A63C", 0, 0, "0", "0", "", "");
      VasWebviewUtil.a("signature_store", "history_enter", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      break;
    case 2131377599: 
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    FontManagerForTool.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    SignatureManagerForTool.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("open_diy", false);
    f();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "onCreateView");
    }
    ApngImage.playByTag(17);
    SoftInputDetectView localSoftInputDetectView = (SoftInputDetectView)paramLayoutInflater.inflate(2131562045, null);
    this.jdField_a_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131377591);
    Object localObject = localSoftInputDetectView.findViewById(2131377605).getLayoutParams();
    int i = SystemUtil.getNotchHeight(getQBaseActivity(), getQBaseActivity());
    if (i > ((ViewGroup.LayoutParams)localObject).height)
    {
      ((ViewGroup.LayoutParams)localObject).height = i;
    }
    else
    {
      i = a(getQBaseActivity());
      if (i > ((ViewGroup.LayoutParams)localObject).height) {
        ((ViewGroup.LayoutParams)localObject).height = i;
      }
    }
    localSoftInputDetectView.findViewById(2131377602).setOnClickListener(this);
    if (this.jdField_c_of_type_Boolean) {
      ((TextView)localSoftInputDetectView.findViewById(2131377606)).setText("DIY签名");
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131377603);
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131377609));
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(UITools.a);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131377610));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131377601));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131377599));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    UIUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 0, 0, UIUtils.a(getQBaseActivity(), 10.0F));
    this.jdField_c_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131377604);
    i = ImmersiveUtils.isSupporImmersive();
    boolean bool = true;
    if (i == 1) {
      bool = false;
    }
    localSoftInputDetectView.setExcludeStatusBar(bool);
    localObject = (RelativeLayout)localSoftInputDetectView.findViewById(2131377608);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localSoftInputDetectView.findViewById(2131377600));
    ((RelativeLayout)localObject).addView(super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle), new RelativeLayout.LayoutParams(-1, -1));
    i();
    h();
    VasWebviewUtil.a("signature_store", "head_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localSoftInputDetectView);
    return localSoftInputDetectView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder;
    if (localObject != null) {
      ((MySignViewHolder)localObject).k();
    }
    FontManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    SignatureManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    SignatureManagerForTool.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    SignatureManagerForTool.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
    if (localObject == null) {
      return;
    }
    if (((RichStatus)localObject).isEmptyStatus())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.setEmptyStatus(false);
      h();
      if ((getAppRuntime() != null) && (!TextUtils.isEmpty(getAppRuntime().getCurrentAccountUin())))
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(getAppRuntime().getCurrentAccountUin());
        localStringBuilder.append("_has_history_sig_del_key");
        if (((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false))
        {
          c();
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
      localObject = SignatureManagerForTool.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if ((localObject != null) && (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom((RichStatus)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i("Signature.Fragment", 2, String.format("onResume %s", new Object[] { ((RichStatus)localObject).getPlainText() }));
        }
        i();
      }
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment
 * JD-Core Version:    0.7.0.1
 */