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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder;
import com.tencent.mobileqq.richstatus.sign.ISignViewHolder.OnClickListener;
import com.tencent.mobileqq.richstatus.sign.MySignViewHolder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.SystemUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

public class SignatureEditFragment
  extends WebViewFragment
  implements Handler.Callback, ISignViewHolder.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public RichStatus a;
  private MySignViewHolder jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder;
  private Observer jdField_a_of_type_JavaUtilObserver = new SignatureEditFragment.6(this);
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
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
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
    localEditor.putInt(this.mApp.getCurrentAccountUin() + "_sign_edit_red_dot_key", paramInt);
    localEditor.apply();
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    SignTextEditFragment.a(getActivity(), this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus, null, null, 16);
    if (paramBoolean) {}
    for (String str = "0X800A63B";; str = "0X800A63A")
    {
      ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "0", "0", "", "");
      return;
    }
  }
  
  private void d()
  {
    boolean bool2 = true;
    if (getActivity() != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 1) {
          if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId != 0) {
            break label56;
          }
        }
      }
    }
    label56:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ImmersiveUtils.setStatusTextColor(bool1, getActivity().getWindow());
      return;
    }
  }
  
  private void e()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = new ArrayList();
      }
    }
    for (;;)
    {
      Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      if ((localObject != null) && (((SignatureTemplateInfo)localObject).jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$ImageItem != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((SignatureTemplateInfo)localObject).n);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = 0;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.locationText = "";
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText = null;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId = 0;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = null;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.clear();
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topicsPos.clear();
      }
      localObject = new Bundle();
      ((Bundle)localObject).putSerializable("my_signature", this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", VasFontIPCModule.f, (Bundle)localObject, SignatureManagerForTool.a().jdField_a_of_type_EipcEIPCResultCallback);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos.clear();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = null;
    }
  }
  
  private void f()
  {
    Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (this.mApp == null) {
      this.mApp = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).f < 2) && ("signature_chouti".equals(getActivity().getIntent().getStringExtra("via"))))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", true))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131714103), getActivity().getResources().getString(2131691955), HardCodeUtil.a(2131714240), getActivity().getResources().getString(2131691938), new SignatureEditFragment.3(this), new SignatureEditFragment.4(this)).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void g()
  {
    Object localObject = SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (this.mApp == null) {
      this.mApp = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((SignatureTemplateInfo)localObject).f < 2) && (Integer.parseInt(((SignatureTemplateInfo)localObject).jdField_a_of_type_JavaLangString) > 0) && (this.jdField_d_of_type_Boolean))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if ((((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "edit_signature_version_826", false)) && (((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", true)))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.mApp.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131714103), getActivity().getResources().getString(2131691955), null, HardCodeUtil.a(2131716638), new SignatureEditFragment.5(this), null).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
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
      if (this.mApp == null) {
        this.mApp = getActivity().getAppInterface();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder = new MySignViewHolder(getActivity(), this.mApp, this.jdField_a_of_type_AndroidViewView, this.mApp.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder.a(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    this.jdField_a_of_type_AndroidViewView.invalidate();
    a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    d();
  }
  
  private void j()
  {
    Object localObject;
    if ((getWebView() != null) && (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText()))) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("result", 0);
      localObject = WebViewPlugin.toJsScript("gxh.sign.setToDefault", (JSONObject)localObject, null);
      getWebView().callJs((String)localObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
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
      DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131714062), HardCodeUtil.a(2131714065), HardCodeUtil.a(2131714075), HardCodeUtil.a(2131714060), new SignatureEditFragment.1(this), new SignatureEditFragment.2(this)).show();
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
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "handleRenderSignature tplId = " + paramInt1 + " fontId = " + paramInt2 + " fontType = " + paramInt3 + " actionId = " + paramInt4 + " actionText = " + paramString + " isDefault=" + paramInt5);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      this.jdField_a_of_type_Int = paramInt5;
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText)) || (TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText))) {
        break label321;
      }
    }
    label321:
    for (int i = 1;; i = 0)
    {
      if (((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId) || (paramInt3 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType) || (paramInt4 != this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId) || (i != 0)) && (paramInt5 == 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontId = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.fontType = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId = paramInt4;
      if ((this.jdField_b_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.getPlainText())))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataId = 0;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.dataText = "";
      if (paramInt5 == 0) {
        SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(257);
      }
      return;
    }
  }
  
  public void a(View paramView, int paramInt, ISignViewHolder paramISignViewHolder)
  {
    QLog.d("Signature.Fragment", 1, new Object[] { "onClick viewType=", paramView });
    if ((paramInt == 2) || (paramInt == 1))
    {
      b(false);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_signature", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
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
      DialogUtil.a(getActivity(), 230, HardCodeUtil.a(2131714082), HardCodeUtil.a(2131714076), HardCodeUtil.a(2131714081), HardCodeUtil.a(2131714067), new SignatureEditFragment.7(this), new SignatureEditFragment.8(this)).show();
      return;
    }
    getActivity().finish();
  }
  
  public void c() {}
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    this.mSwiftTitleUI.a.setVisibility(8);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setVisibility(8);
    }
    paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    this.jdField_b_of_type_Int = paramBundle.getInt(this.mApp.getCurrentAccountUin() + "_sign_edit_red_dot_key", 0);
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
    this.mUIStyleHandler.a.a(false);
    this.mSetting.a("web_view_long_click", false);
    c();
    paramBundle.edit().putBoolean(this.mApp.getCurrentAccountUin() + "_has_history_sig_del_key", false).apply();
    return i;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("publish_ever", false)));
    if (QLog.isColorLevel()) {
      QLog.i("Signature.Fragment", 2, "doOnActivityResult refetch");
    }
    SignatureManagerForTool.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    SignatureManagerForTool.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    h();
    c();
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
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 257: 
      i();
      return true;
    case 258: 
      QQToast.a(getActivity(), 1, HardCodeUtil.a(2131714053), 1).a();
      return true;
    case 261: 
      QQToast.a(getActivity(), 1, HardCodeUtil.a(2131714055), 1).a();
      return true;
    case 260: 
      QQToast.a(getActivity(), 1, HardCodeUtil.a(2131714066), 1).a();
      return true;
    case 259: 
      dispatchPluginEvent(8589934617L, (HashMap)paramMessage.obj);
      return true;
    }
    if (paramMessage.arg1 >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719422), new Object[] { Integer.valueOf(paramMessage.arg1) }));
      return true;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Int < 1)
      {
        b(1);
        this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      }
      dispatchPluginEvent(8589934616L, null);
      Object localObject = "signature_4";
      if (this.jdField_c_of_type_Boolean) {
        localObject = "signature_7";
      }
      VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "signature", (String)localObject, "", 1, 0, 0, "", "", "");
      continue;
      b(true);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_edit", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      continue;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
        SignatureManagerForTool.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      for (;;)
      {
        localObject = new Intent(getActivity(), PublicFragmentActivity.class);
        ((Intent)localObject).putExtra("key_uin", this.mApp.getCurrentAccountUin());
        ((Intent)localObject).putExtra("key_uin_name", this.mApp.getCurrentNickname());
        ((Intent)localObject).putExtra("key_open_via", "history-geqian");
        PublicFragmentActivity.Launcher.a(getActivity(), (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        ReportController.b(null, "dc00898", "", "", "0X800A63C", "0X800A63C", 0, 0, "0", "0", "", "");
        VasWebviewUtil.reportCommercialDrainage("signature_store", "history_enter", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        break;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.setEmptyStatus(true);
      }
      b();
    }
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
    SoftInputDetectView localSoftInputDetectView = (SoftInputDetectView)paramLayoutInflater.inflate(2131562208, null);
    this.jdField_a_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131378167);
    Object localObject = localSoftInputDetectView.findViewById(2131378189).getLayoutParams();
    int i = SystemUtil.getNotchHeight(getActivity(), getActivity());
    if (i > ((ViewGroup.LayoutParams)localObject).height)
    {
      ((ViewGroup.LayoutParams)localObject).height = i;
      localSoftInputDetectView.findViewById(2131378186).setOnClickListener(this);
      if (this.jdField_c_of_type_Boolean) {
        ((TextView)localSoftInputDetectView.findViewById(2131378190)).setText("DIY签名");
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131378187);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(UITools.a);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131378193));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(UITools.a);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131378194));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131378185));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131378183));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      UIUtils.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 0, 0, UIUtils.a(getActivity(), 10.0F));
      this.jdField_c_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131378188);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        break label433;
      }
    }
    label433:
    for (boolean bool = true;; bool = false)
    {
      localSoftInputDetectView.setExcludeStatusBar(bool);
      localObject = (RelativeLayout)localSoftInputDetectView.findViewById(2131378192);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localSoftInputDetectView.findViewById(2131378184));
      ((RelativeLayout)localObject).addView(super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle), new RelativeLayout.LayoutParams(-1, -1));
      i();
      h();
      VasWebviewUtil.reportCommercialDrainage("signature_store", "head_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      V4FragmentCollector.onV4FragmentViewCreated(this, localSoftInputDetectView);
      return localSoftInputDetectView;
      i = a(getActivity());
      if (i <= ((ViewGroup.LayoutParams)localObject).height) {
        break;
      }
      ((ViewGroup.LayoutParams)localObject).height = i;
      break;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSignMySignViewHolder.k();
    }
    FontManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    SignatureManagerForTool.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    SignatureManagerForTool.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    SignatureManagerForTool.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.isEmptyStatus())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.setEmptyStatus(false);
      h();
      if ((this.mApp != null) && (!TextUtils.isEmpty(this.mApp.getCurrentAccountUin())))
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        if (((SharedPreferences)localObject).getBoolean(this.mApp.getCurrentAccountUin() + "_has_history_sig_del_key", false))
        {
          c();
          ((SharedPreferences)localObject).edit().putBoolean(this.mApp.getCurrentAccountUin() + "_has_history_sig_del_key", false).apply();
        }
      }
    }
    for (;;)
    {
      g();
      return;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment
 * JD-Core Version:    0.7.0.1
 */