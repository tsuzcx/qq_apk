package com.tencent.mobileqq.richstatus;

import abtq;
import ajya;
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
import awdc;
import awdd;
import awde;
import awdf;
import awdg;
import awdh;
import awdi;
import awdj;
import awek;
import awfq;
import awfr;
import awfs;
import axqy;
import bbdj;
import bbgu;
import bbqs;
import bccj;
import bcfg;
import bcfx;
import bcql;
import bcsr;
import bhpx;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import hs;
import hy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import muc;
import org.json.JSONException;
import org.json.JSONObject;
import vzl;

public class SignatureEditFragment
  extends WebViewFragment
  implements Handler.Callback, awfr
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awfs jdField_a_of_type_Awfs;
  public RichStatus a;
  private Observer jdField_a_of_type_JavaUtilObserver = new awdh(this);
  public boolean a;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public RichStatus b;
  public boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = true;
  
  public SignatureEditFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
    this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
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
    localEditor.putInt(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_sign_edit_red_dot_key", paramInt);
    localEditor.apply();
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    SignTextEditFragment.a(getActivity(), this.jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus, null, null, 16);
    if (paramBoolean) {}
    for (String str = "0X800A63B";; str = "0X800A63A")
    {
      axqy.b(null, "dc00898", "", "", str, str, 0, 0, "0", "0", "", "");
      return;
    }
  }
  
  private void k()
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
      ImmersiveUtils.a(bool1, getActivity().getWindow());
      return;
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = new ArrayList();
      }
    }
    for (;;)
    {
      Object localObject = awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      if ((localObject != null) && (((bbqs)localObject).jdField_a_of_type_Bbqu != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((bbqs)localObject).n);
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
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", hy.f, (Bundle)localObject, awek.a().jdField_a_of_type_EipcEIPCResultCallback);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos.clear();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = null;
    }
  }
  
  private void m()
  {
    Object localObject = awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((bbqs)localObject).f < 2) && ("signature_chouti".equals(getActivity().getIntent().getStringExtra("via"))))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", true))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        bbdj.a(getActivity(), 230, ajya.a(2131714165), getActivity().getResources().getString(2131691987), ajya.a(2131714371), getActivity().getResources().getString(2131691969), new awde(this), new awdf(this)).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void n()
  {
    Object localObject = awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((bbqs)localObject).f < 2) && (Integer.parseInt(((bbqs)localObject).jdField_a_of_type_JavaLangString) > 0) && (this.jdField_d_of_type_Boolean))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if ((((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "edit_signature_version_826", false)) && (((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", true)))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        bbdj.a(getActivity(), 230, ajya.a(2131714165), getActivity().getResources().getString(2131691987), null, ajya.a(2131716820), new awdg(this), null).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void o()
  {
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", hy.e, null, awek.a().jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "initSignatureView start");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    if (this.jdField_a_of_type_Awfs == null)
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
      }
      this.jdField_a_of_type_Awfs = new awfs(getActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Awfs.a(this);
    }
    this.jdField_a_of_type_Awfs.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
    this.jdField_a_of_type_AndroidViewView.invalidate();
    a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    k();
  }
  
  private void r()
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
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    this.jdField_a_of_type_Bccj.a.setVisibility(8);
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    this.jdField_b_of_type_Int = paramBundle.getInt(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_sign_edit_red_dot_key", 0);
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_Bcfx.a.a(false);
    this.jdField_a_of_type_Bcfg.a("web_view_long_click", false);
    j();
    paramBundle.edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_has_history_sig_del_key", false).apply();
    return i;
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
      bbqs localbbqs = awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      localObject = arrayOfInt;
      if (localbbqs != null)
      {
        localObject = arrayOfInt;
        if (!TextUtils.isEmpty(localbbqs.t))
        {
          paramInt = Color.parseColor(localbbqs.t);
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
        awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(257);
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
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
    awek.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    awek.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    o();
    j();
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      i();
    }
    super.a(paramInt, paramKeyEvent);
  }
  
  public void a(View paramView, int paramInt, awfq paramawfq)
  {
    QLog.d("Signature.Fragment", 1, new Object[] { "onClick viewType=", paramView });
    if ((paramInt == 2) || (paramInt == 1))
    {
      d(false);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_signature", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  public void aM_()
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
    axqy.b(null, "dc00898", "", "", "0X800A63D", "0X800A63D", 0, 0, "0", "0", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.bOnlyHasTopic())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(260);
      return;
    }
    Object localObject = awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if ((i == 0) && (((bbqs)localObject).jdField_a_of_type_Bbqu == null))
    {
      bbdj.a(getActivity(), 230, ajya.a(2131714124), ajya.a(2131714127), ajya.a(2131714137), ajya.a(2131714122), new awdc(this), new awdd(this)).show();
      return;
    }
    l();
  }
  
  public int b(int paramInt)
  {
    return paramInt + 1291845632;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    k();
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 257: 
      p();
      return true;
    case 258: 
      bcql.a(getActivity(), 1, ajya.a(2131714115), 1).a();
      return true;
    case 261: 
      bcql.a(getActivity(), 1, ajya.a(2131714117), 1).a();
      return true;
    case 260: 
      bcql.a(getActivity(), 1, ajya.a(2131714128), 1).a();
      return true;
    case 259: 
      a(8589934617L, (HashMap)paramMessage.obj);
      return true;
    }
    if (paramMessage.arg1 >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131719644), new Object[] { Integer.valueOf(paramMessage.arg1) }));
      return true;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    return true;
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      bbdj.a(getActivity(), 230, ajya.a(2131714144), ajya.a(2131714138), ajya.a(2131714143), ajya.a(2131714129), new awdi(this), new awdj(this)).show();
      return;
    }
    getActivity().finish();
  }
  
  public void j() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376214: 
      if (this.jdField_b_of_type_Int < 1)
      {
        b(1);
        this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      }
      a(8589934616L, null);
      paramView = "signature_4";
      if (this.jdField_c_of_type_Boolean) {
        paramView = "signature_7";
      }
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "signature", paramView, "", 1, 0, 0, "", "", "");
      return;
    case 2131376220: 
      d(true);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_edit", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    case 2131376212: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
        awek.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      for (;;)
      {
        paramView = new Intent(getActivity(), PublicFragmentActivity.class);
        paramView.putExtra("key_uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        paramView.putExtra("key_uin_name", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentNickname());
        paramView.putExtra("key_open_via", "history-geqian");
        abtq.a(getActivity(), paramView, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        axqy.b(null, "dc00898", "", "", "0X800A63C", "0X800A63C", 0, 0, "0", "0", "", "");
        VasWebviewUtil.reportCommercialDrainage("signature_store", "history_enter", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        return;
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = new RichStatus(null);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.setEmptyStatus(true);
      }
    }
    i();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    hs.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    awek.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_c_of_type_Boolean = a().getBooleanExtra("open_diy", false);
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "onCreateView");
    }
    ApngImage.playByTag(17);
    SoftInputDetectView localSoftInputDetectView = (SoftInputDetectView)paramLayoutInflater.inflate(2131561644, null);
    this.jdField_a_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131376199);
    Object localObject = localSoftInputDetectView.findViewById(2131376216).getLayoutParams();
    int i = bhpx.a(getActivity(), getActivity());
    if (i > ((ViewGroup.LayoutParams)localObject).height)
    {
      ((ViewGroup.LayoutParams)localObject).height = i;
      localSoftInputDetectView.findViewById(2131376213).setOnClickListener(this);
      if (this.jdField_c_of_type_Boolean) {
        ((TextView)localSoftInputDetectView.findViewById(2131376217)).setText("DIY签名");
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131376214);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(muc.a);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376220));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(muc.a);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376221));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376212));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376210));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      vzl.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 0, 0, vzl.a(getActivity(), 10.0F));
      this.jdField_c_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131376215);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        break label427;
      }
    }
    label427:
    for (boolean bool = true;; bool = false)
    {
      localSoftInputDetectView.setExcludeStatusBar(bool);
      localObject = (RelativeLayout)localSoftInputDetectView.findViewById(2131376219);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localSoftInputDetectView.findViewById(2131376211));
      ((RelativeLayout)localObject).addView(super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle), new RelativeLayout.LayoutParams(-1, -1));
      p();
      o();
      VasWebviewUtil.reportCommercialDrainage("signature_store", "head_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
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
    if (this.jdField_a_of_type_Awfs != null) {
      this.jdField_a_of_type_Awfs.k();
    }
    hs.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    awek.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    awek.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    awek.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
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
      o();
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        if (((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_has_history_sig_del_key", false))
        {
          j();
          ((SharedPreferences)localObject).edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_has_history_sig_del_key", false).apply();
        }
      }
    }
    for (;;)
    {
      n();
      return;
      localObject = awek.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      if ((localObject != null) && (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.copyFrom((RichStatus)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i("Signature.Fragment", 2, String.format("onResume %s", new Object[] { ((RichStatus)localObject).getPlainText() }));
        }
        p();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment
 * JD-Core Version:    0.7.0.1
 */