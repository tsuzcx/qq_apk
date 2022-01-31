package com.tencent.mobileqq.richstatus;

import adpn;
import alud;
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
import ayco;
import aycp;
import aycq;
import aycr;
import aycs;
import ayct;
import aycu;
import aycv;
import aydw;
import ayfc;
import ayfd;
import ayfe;
import azqs;
import bdgm;
import bdjz;
import bdtv;
import beft;
import beiq;
import bejh;
import bewj;
import bjvp;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import gb;
import gh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import mww;
import org.json.JSONException;
import org.json.JSONObject;
import xsm;

public class SignatureEditFragment
  extends WebViewFragment
  implements Handler.Callback, ayfd
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ayfe jdField_a_of_type_Ayfe;
  public RichStatus a;
  private Observer jdField_a_of_type_JavaUtilObserver = new ayct(this);
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
      azqs.b(null, "dc00898", "", "", str, str, 0, 0, "0", "0", "", "");
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
      Object localObject = aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      if ((localObject != null) && (((bdtv)localObject).jdField_a_of_type_Bdtx != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.plainText.set(0, ((bdtv)localObject).n);
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
      QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gh.f, (Bundle)localObject, aydw.a().jdField_a_of_type_EipcEIPCResultCallback);
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos.clear();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.mStickerInfos = null;
    }
  }
  
  private void m()
  {
    Object localObject = aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((bdtv)localObject).f < 2) && ("signature_chouti".equals(getActivity().getIntent().getStringExtra("via"))))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", true))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        bdgm.a(getActivity(), 230, alud.a(2131714549), getActivity().getResources().getString(2131692043), alud.a(2131714755), getActivity().getResources().getString(2131692025), new aycq(this), new aycr(this)).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void n()
  {
    Object localObject = aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
    }
    if ((localObject != null) && (((bdtv)localObject).f < 2) && (Integer.parseInt(((bdtv)localObject).jdField_a_of_type_JavaLangString) > 0) && (this.jdField_d_of_type_Boolean))
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if ((((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "edit_signature_version_826", false)) && (((SharedPreferences)localObject).getBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", true)))
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "new_signature_version_826", false).apply();
        bdgm.a(getActivity(), 230, alud.a(2131714549), getActivity().getResources().getString(2131692043), null, alud.a(2131717204), new aycs(this), null).show();
        VasWebviewUtil.reportCommercialDrainage("signature_update", "show", "", 0, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
      }
    }
  }
  
  private void o()
  {
    QIPCClientHelper.getInstance().callServer("VasFontIPCModule", gh.e, null, aydw.a().jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "initSignatureView start");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus == null) {
      return;
    }
    if (this.jdField_a_of_type_Ayfe == null)
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface = getActivity().getAppInterface();
      }
      this.jdField_a_of_type_Ayfe = new ayfe(getActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Ayfe.a(this);
    }
    this.jdField_a_of_type_Ayfe.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
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
    this.jdField_a_of_type_Beft.a.setVisibility(8);
    if (this.jdField_d_of_type_AndroidViewView != null) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    this.jdField_b_of_type_Int = paramBundle.getInt(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + "_sign_edit_red_dot_key", 0);
    if (this.jdField_b_of_type_Int > 0) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_Bejh.a.a(false);
    this.jdField_a_of_type_Beiq.a("web_view_long_click", false);
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
      bdtv localbdtv = aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
      localObject = arrayOfInt;
      if (localbdtv != null)
      {
        localObject = arrayOfInt;
        if (!TextUtils.isEmpty(localbdtv.t))
        {
          paramInt = Color.parseColor(localbdtv.t);
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
        aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
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
    aydw.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    aydw.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
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
  
  public void a(View paramView, int paramInt, ayfc paramayfc)
  {
    QLog.d("Signature.Fragment", 1, new Object[] { "onClick viewType=", paramView });
    if ((paramInt == 2) || (paramInt == 1))
    {
      d(false);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_signature", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  public void aK_()
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
    azqs.b(null, "dc00898", "", "", "0X800A63D", "0X800A63D", 0, 0, "0", "0", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.bOnlyHasTopic())
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(260);
      return;
    }
    Object localObject = aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.tplId);
    if ((i == 0) && (((bdtv)localObject).jdField_a_of_type_Bdtx == null))
    {
      bdgm.a(getActivity(), 230, alud.a(2131714508), alud.a(2131714511), alud.a(2131714521), alud.a(2131714506), new ayco(this), new aycp(this)).show();
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
      QQToast.a(getActivity(), 1, alud.a(2131714499), 1).a();
      return true;
    case 261: 
      QQToast.a(getActivity(), 1, alud.a(2131714501), 1).a();
      return true;
    case 260: 
      QQToast.a(getActivity(), 1, alud.a(2131714512), 1).a();
      return true;
    case 259: 
      a(8589934617L, (HashMap)paramMessage.obj);
      return true;
    }
    if (paramMessage.arg1 >= 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(getString(2131720188), new Object[] { Integer.valueOf(paramMessage.arg1) }));
      return true;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    return true;
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      bdgm.a(getActivity(), 230, alud.a(2131714528), alud.a(2131714522), alud.a(2131714527), alud.a(2131714513), new aycu(this), new aycv(this)).show();
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
    case 2131376770: 
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
    case 2131376776: 
      d(true);
      VasWebviewUtil.reportCommercialDrainage("signature_store", "click_edit", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    case 2131376768: 
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
        aydw.a().a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus);
      }
      for (;;)
      {
        paramView = new Intent(getActivity(), PublicFragmentActivity.class);
        paramView.putExtra("key_uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        paramView.putExtra("key_uin_name", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentNickname());
        paramView.putExtra("key_open_via", "history-geqian");
        adpn.a(getActivity(), paramView, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        azqs.b(null, "dc00898", "", "", "0X800A63C", "0X800A63C", 0, 0, "0", "0", "", "");
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
    gb.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    aydw.a().addObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_c_of_type_Boolean = a().getBooleanExtra("open_diy", false);
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "onCreateView");
    }
    ApngImage.playByTag(17);
    SoftInputDetectView localSoftInputDetectView = (SoftInputDetectView)paramLayoutInflater.inflate(2131561853, null);
    this.jdField_a_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131376755);
    Object localObject = localSoftInputDetectView.findViewById(2131376772).getLayoutParams();
    int i = bjvp.a(getActivity(), getActivity());
    if (i > ((ViewGroup.LayoutParams)localObject).height)
    {
      ((ViewGroup.LayoutParams)localObject).height = i;
      localSoftInputDetectView.findViewById(2131376769).setOnClickListener(this);
      if (this.jdField_c_of_type_Boolean) {
        ((TextView)localSoftInputDetectView.findViewById(2131376773)).setText("DIY签名");
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131376770);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(mww.a);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376776));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnTouchListener(mww.a);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376777));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376768));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localSoftInputDetectView.findViewById(2131376766));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      xsm.a(this.jdField_b_of_type_AndroidWidgetTextView, 0, 0, 0, xsm.a(getActivity(), 10.0F));
      this.jdField_c_of_type_AndroidViewView = localSoftInputDetectView.findViewById(2131376771);
      if (ImmersiveUtils.isSupporImmersive() == 1) {
        break label427;
      }
    }
    label427:
    for (boolean bool = true;; bool = false)
    {
      localSoftInputDetectView.setExcludeStatusBar(bool);
      localObject = (RelativeLayout)localSoftInputDetectView.findViewById(2131376775);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localSoftInputDetectView.findViewById(2131376767));
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
    if (this.jdField_a_of_type_Ayfe != null) {
      this.jdField_a_of_type_Ayfe.k();
    }
    gb.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    aydw.a().deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    aydw.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    aydw.a().jdField_b_of_type_ComTencentMobileqqRichstatusRichStatus = null;
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
      localObject = aydw.a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment
 * JD-Core Version:    0.7.0.1
 */