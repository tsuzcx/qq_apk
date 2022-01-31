package com.tencent.mobileqq.extendfriend.fragment;

import adky;
import aekt;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import apwx;
import apxa;
import apyo;
import apzv;
import apzw;
import apzx;
import apzy;
import apzz;
import aqab;
import aqac;
import aqcp;
import aqcq;
import awpn;
import azib;
import azmj;
import baig;
import bbkt;
import bcxb;
import bcyw;
import bdlr;
import bfhi;
import bhoc;
import bjwp;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import mzy;
import nac;

public class ExtendFriendProfileEditFragment
  extends Fragment
  implements View.OnClickListener
{
  public static final ColorDrawable a;
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new apzv(this);
  public View a;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new apzz(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbkt jdField_a_of_type_Bbkt;
  public ETTextView a;
  private ExtendFriendEditFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment;
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a;
  public ExtendFriendVoiceView a;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  public XEditTextEx a;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
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
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-657931);
  }
  
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
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, nac paramnac)
  {
    for (int i = 1;; i = 0) {
      try
      {
        long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
        byte[] arrayOfByte = new byte[13];
        bdlr.a(arrayOfByte, 0, l);
        arrayOfByte[4] = 0;
        bdlr.a(arrayOfByte, 5, (short)1);
        bdlr.a(arrayOfByte, 7, 42276);
        bdlr.a(arrayOfByte, 9, (short)2);
        if (paramBoolean)
        {
          bdlr.a(arrayOfByte, 11, (short)i);
          mzy.a(paramQQAppInterface, paramnac, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
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
    Object localObject = ((apwx)getActivity().app.getManager(264)).a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(((apxa)localObject).jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_Int = ((apxa)localObject).jdField_f_of_type_Int;
    }
    localObject = getActivity().app;
    String str = ((QQAppInterface)localObject).c();
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(bcxb.a((AppInterface)localObject, 1, str));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_b_of_type_AndroidViewView.findViewById(2131365841));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375895));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363605));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377984));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366458);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370073);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(aqcp.a(aekt.a(27.0F, getResources()), -15550475, 1.0F));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(aqcp.a(aekt.a(27.0F, getResources()), -16777216, 0.08F));
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131377983);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379981);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368110));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379102));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368102));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379105));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.jdField_b_of_type_AndroidViewView.findViewById(2131379972));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379971));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365858));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379426);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener((ExtendFriendEditFragment)localFragment);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368159));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setDeleteIconEnable(true, new apzw(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(new apzx(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369594));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375913));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368681));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368690));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378926));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378606));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new apzy(this));
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
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.jdField_a_of_type_Int;
        ExtendFriendEditFragment localExtendFriendEditFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment;
        if (i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.d();
        }
      }
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
    h();
    l();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void h()
  {
    int i = getResources().getDisplayMetrics().heightPixels;
    int j = this.jdField_d_of_type_Int;
    int k = ImmersiveUtils.getStatusBarHeight(getActivity());
    int m = this.jdField_c_of_type_AndroidWidgetTextView.getHeight();
    int n = aekt.a(96.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(i - j - k - m - n);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxHeight(2147483647);
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
    a(aekt.a(114.0F, getResources()) - ImmersiveUtils.getStatusBarHeight(getActivity()));
  }
  
  private void m()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void n()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a()
  {
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo();
    localExtendFriendInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localExtendFriendInfo.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    if ((this.jdField_a_of_type_Bbkt != null) && ((this.jdField_a_of_type_Bbkt instanceof AudioInfo)))
    {
      localExtendFriendInfo.jdField_b_of_type_Int = (((AudioInfo)this.jdField_a_of_type_Bbkt).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    return localExtendFriendInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      bhoc.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, apyo paramapyo)
  {
    Object localObject;
    boolean bool;
    if ((VipUtils.a()) && (VipUtils.b(paramQQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (paramapyo.mVipHide) {
        break label164;
      }
      bool = true;
      ((Switch)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramapyo.mNickName);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.valueOf(paramapyo.mPopularity));
      localObject = this.jdField_e_of_type_AndroidWidgetImageView;
      if (paramapyo.mGender != 2) {
        break label170;
      }
    }
    label164:
    label170:
    for (int i = 2130844636;; i = 2130844637)
    {
      ((ImageView)localObject).setImageResource(i);
      VipUtils.a(paramapyo, this.jdField_f_of_type_AndroidWidgetImageView);
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(paramapyo);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      azmj.b(paramQQAppInterface, "dc00898", "", "", "0X8009F0E", "0X8009F0E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  public void a(ExtendFriendEditFragment paramExtendFriendEditFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment = paramExtendFriendEditFragment;
  }
  
  public void a(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      int i;
      if (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramExtendFriendInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramExtendFriendInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new baig(bjwp.d(paramExtendFriendInfo.jdField_a_of_type_JavaLangString), 3, 24));
        if (paramExtendFriendInfo.jdField_a_of_type_JavaLangString != null) {
          break label380;
        }
        i = 0;
        label69:
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(i);
        a();
        if (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString)) {
          break label391;
        }
        m();
        this.jdField_b_of_type_JavaLangString = paramExtendFriendInfo.jdField_b_of_type_JavaLangString;
        this.jdField_b_of_type_Int = paramExtendFriendInfo.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(bfhi.a(this.jdField_b_of_type_JavaLangString));
        }
      }
      for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
      {
        b(paramExtendFriendInfo);
        if (!azib.b())
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.a().a() != null))
          {
            i = paramExtendFriendInfo.jdField_c_of_type_Int;
            if (paramExtendFriendInfo.e != 0) {
              i = paramExtendFriendInfo.e;
            }
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.a().setUsingItem(i);
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.a().a().b(i);
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.jdField_a_of_type_Int = 3;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.b() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.b().a() != null))
          {
            i = paramExtendFriendInfo.jdField_d_of_type_Int;
            if (paramExtendFriendInfo.jdField_f_of_type_Int != 0) {
              i = paramExtendFriendInfo.jdField_f_of_type_Int;
            }
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.b().setUsingItem(i);
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.b().a().b(i);
            this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.jdField_a_of_type_Int = 2;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
        if ((paramExtendFriendInfo.jdField_c_of_type_Boolean) || (paramExtendFriendInfo.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.performClick();
        }
        return;
        this.jdField_a_of_type_JavaLangString = "";
        paramExtendFriendInfo.jdField_a_of_type_JavaLangString = "";
        break;
        label380:
        i = paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length();
        break label69;
        label391:
        n();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_Bbkt = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.jdField_b_of_type_JavaLangString = paramAudioInfo.path;
      this.jdField_b_of_type_Int = paramAudioInfo.duration;
      m();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.jdField_b_of_type_Int / 1000);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(bfhi.a(this.jdField_b_of_type_JavaLangString));
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
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-11692801);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-3355444);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  public boolean a()
  {
    String str2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(str1))) || (this.jdField_e_of_type_Boolean);
  }
  
  public void b()
  {
    Object localObject = ((apwx)getActivity().app.getManager(264)).a();
    if (localObject == null) {}
    for (int i = 11000;; i = ((apxa)localObject).jdField_c_of_type_Int * 1000)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("audio_max_length", i);
      ((Intent)localObject).putExtra("auto_start", true);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      adky.a(getActivity(), (Intent)localObject, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
      return;
    }
  }
  
  public void b(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    if ((getActivity() == null) || (paramExtendFriendInfo == null)) {
      return;
    }
    if ((TextUtils.isEmpty(paramExtendFriendInfo.jdField_c_of_type_JavaLangString)) || (TextUtils.isEmpty(paramExtendFriendInfo.jdField_d_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844631);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aqab(this));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    String str = paramExtendFriendInfo.jdField_d_of_type_JavaLangString;
    int i;
    if (paramExtendFriendInfo.jdField_a_of_type_Long == 2L)
    {
      i = 2130844679;
      label132:
      localTextView.setText(bcyw.a(str, false, i, 2131298187, 2131298186, getActivity(), getActivity().app, null));
      if (paramExtendFriendInfo.jdField_a_of_type_Long != 2L) {
        break label224;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new ExtendFriendProfileEditFragment.7(this, paramExtendFriendInfo));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aqac(this, paramExtendFriendInfo));
      break;
      i = 2130844680;
      break label132;
      label224:
      if (paramExtendFriendInfo.jdField_a_of_type_Long == 0L)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699255);
        a(true);
      }
      else if (paramExtendFriendInfo.jdField_a_of_type_Long == 1L)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699256);
        a(false);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699255);
        a(true);
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getScrollY();
      j = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLayout().getHeight() - (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getHeight() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundPaddingTop() - this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getCompoundPaddingBottom());
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
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
        bhoc.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      } while ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_Boolean));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.c(0);
      return;
      b();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a();
      return;
    } while ((getActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null));
    aqcq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.g, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_JavaLangString);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560921, paramViewGroup, false);
    e();
    d();
    if ((getActivity() != null) && (aqcq.c(getActivity().app)))
    {
      aqcq.b(getActivity().app, false);
      getActivity().setResult(8193);
    }
    return this.jdField_b_of_type_AndroidViewView;
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
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */