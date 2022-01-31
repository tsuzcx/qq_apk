package com.tencent.mobileqq.extendfriend.fragment;

import abtq;
import actj;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoeu;
import aoex;
import aogm;
import aohv;
import aohw;
import aohx;
import aohy;
import aohz;
import aokn;
import axqy;
import azmk;
import bayh;
import bbmx;
import bcql;
import bdik;
import bfni;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import mxf;
import mxj;

public class ExtendFriendProfileEditFragment
  extends Fragment
  implements View.OnClickListener
{
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aohv(this);
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aohz(this);
  public EditText a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azmk jdField_a_of_type_Azmk;
  private bcql jdField_a_of_type_Bcql;
  private ExtendFriendProfileEditFragment.ExtendFriendInfo jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo;
  public ExtendFriendVoiceView a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  
  public ExtendFriendProfileEditFragment()
  {
    this.jdField_a_of_type_Int = 20;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = paramString.length();
    int i = j - 1;
    while (i >= 0)
    {
      int k = paramString.charAt(i);
      if ((k != 32) && (k != 10)) {
        break;
      }
      j -= 1;
      i -= 1;
    }
    return paramString.substring(0, j);
  }
  
  private void a(int paramInt)
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).a(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, mxj parammxj)
  {
    for (int i = 1;; i = 0) {
      try
      {
        long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
        byte[] arrayOfByte = new byte[13];
        bbmx.a(arrayOfByte, 0, l);
        arrayOfByte[4] = 0;
        bbmx.a(arrayOfByte, 5, (short)1);
        bbmx.a(arrayOfByte, 7, 42276);
        bbmx.a(arrayOfByte, 9, (short)2);
        if (paramBoolean)
        {
          bbmx.a(arrayOfByte, 11, (short)i);
          mxf.a(paramQQAppInterface, parammxj, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendHandler", 2, "setShowVipIconSwitch: " + paramBoolean);
          }
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.w("ExtendFriendHandler", 1, "setShowVipIconSwitch error", paramQQAppInterface);
        return;
      }
    }
  }
  
  private void d()
  {
    Object localObject = ((aoeu)getActivity().app.getManager(264)).a();
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(((aoex)localObject).jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_Int = ((aoex)localObject).jdField_f_of_type_Int;
    }
    localObject = getActivity().app;
    String str = ((QQAppInterface)localObject).c();
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(bayh.a((AppInterface)localObject, 1, str));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365755));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375410));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363561));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377447));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366355);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131369809);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(aokn.a(actj.a(27.0F, getResources()), -15550475, 1.0F));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(aokn.a(actj.a(27.0F, getResources()), -16777216, 0.08F));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377446);
    this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379280);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367973));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378490));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367965));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378493));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131379271));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379270));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener((ExtendFriendEditFragment)localFragment);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368021));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setDeleteIconEnable(true, new aohw(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundDrawable(new ColorDrawable(-657931));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(new ColorDrawable(-657931));
    this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new aohx(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new aohy(this));
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Boolean = false;
    i();
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    h();
    l();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void h()
  {
    int i = getResources().getDisplayMetrics().heightPixels;
    int j = this.jdField_d_of_type_Int;
    int k = ImmersiveUtils.getStatusBarHeight(getActivity());
    int m = this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
    int n = actj.a(96.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxHeight(i - j - k - m - n);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setMaxHeight(2147483647);
  }
  
  private void j()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).a();
    }
  }
  
  private void k()
  {
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).b();
    }
  }
  
  private void l()
  {
    a(actj.a(114.0F, getResources()) - ImmersiveUtils.getStatusBarHeight(getActivity()));
  }
  
  private void m()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void n()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a()
  {
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo();
    localExtendFriendInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localExtendFriendInfo.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    if ((this.jdField_a_of_type_Azmk != null) && ((this.jdField_a_of_type_Azmk instanceof AudioInfo)))
    {
      localExtendFriendInfo.jdField_b_of_type_Int = (((AudioInfo)this.jdField_a_of_type_Azmk).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    return localExtendFriendInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      bfni.b(this.jdField_a_of_type_AndroidWidgetEditText);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, aogm paramaogm)
  {
    Object localObject;
    boolean bool;
    if ((VipUtils.a()) && (VipUtils.b(paramQQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (paramaogm.mVipHide) {
        break label164;
      }
      bool = true;
      ((Switch)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramaogm.mNickName);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaogm.mPopularity));
      localObject = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramaogm.mGender != 2) {
        break label170;
      }
    }
    label164:
    label170:
    for (int i = 2130844287;; i = 2130844288)
    {
      ((ImageView)localObject).setImageResource(i);
      VipUtils.a(paramaogm, this.jdField_d_of_type_AndroidWidgetImageView);
      this.jdField_d_of_type_AndroidWidgetImageView.setTag(paramaogm);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8009F0E", "0X8009F0E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  public void a(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      if (TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) {
        break label148;
      }
      this.jdField_a_of_type_JavaLangString = paramExtendFriendInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramExtendFriendInfo.jdField_a_of_type_JavaLangString);
      if (paramExtendFriendInfo.jdField_a_of_type_JavaLangString != null) {
        break label157;
      }
      i = 0;
      label45:
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(i);
      a();
      if (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString)) {
        break label168;
      }
      m();
      this.jdField_b_of_type_JavaLangString = paramExtendFriendInfo.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_Int = paramExtendFriendInfo.jdField_b_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(bdik.a(this.jdField_b_of_type_JavaLangString));
      }
    }
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
      return;
      label148:
      this.jdField_a_of_type_JavaLangString = "";
      break;
      label157:
      i = paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length();
      break label45;
      label168:
      n();
    }
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_Azmk = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.jdField_b_of_type_JavaLangString = paramAudioInfo.path;
      this.jdField_b_of_type_Int = paramAudioInfo.duration;
      m();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.jdField_b_of_type_Int / 1000);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(bdik.a(this.jdField_b_of_type_JavaLangString));
      }
      this.jdField_e_of_type_Boolean = true;
      j();
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
  }
  
  public boolean a()
  {
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(str1))) || (this.jdField_e_of_type_Boolean);
  }
  
  public void b()
  {
    Object localObject = ((aoeu)getActivity().app.getManager(264)).a();
    if (localObject == null) {}
    for (int i = 11000;; i = ((aoex)localObject).jdField_c_of_type_Int * 1000)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("audio_max_length", i);
      ((Intent)localObject).putExtra("auto_start", true);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      abtq.a(getActivity(), (Intent)localObject, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
      return;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.jdField_a_of_type_AndroidWidgetEditText.getScrollY();
      j = this.jdField_a_of_type_AndroidWidgetEditText.getLayout().getHeight() - (this.jdField_a_of_type_AndroidWidgetEditText.getHeight() - this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingTop() - this.jdField_a_of_type_AndroidWidgetEditText.getCompoundPaddingBottom());
    } while ((j == 0) || ((i <= 0) && (i >= j - 1)));
    return true;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131365755: 
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      bfni.a(this.jdField_a_of_type_AndroidWidgetEditText);
      return;
    case 2131363561: 
      b();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560737, paramViewGroup, false);
    e();
    d();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidWidgetEditText.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */