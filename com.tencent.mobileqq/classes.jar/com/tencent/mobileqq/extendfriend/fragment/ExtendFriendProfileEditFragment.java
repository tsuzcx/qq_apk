package com.tencent.mobileqq.extendfriend.fragment;

import aeow;
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
import aslo;
import aslx;
import asnq;
import asph;
import aspi;
import aspj;
import aspk;
import aspl;
import aspn;
import aspo;
import asso;
import assp;
import azun;
import bdfk;
import bdla;
import bffk;
import bhaa;
import bkxz;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.AudioRecordFragment;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.widget.QzoneEmotionUtils;
import ntb;
import ntf;

public class ExtendFriendProfileEditFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  public static final ColorDrawable a;
  public int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new asph(this);
  public View a;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aspl(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bffk jdField_a_of_type_Bffk;
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
  public boolean c;
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
  private boolean jdField_f_of_type_Boolean;
  
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
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, ntf paramntf)
  {
    for (int i = 1;; i = 0) {
      try
      {
        long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
        byte[] arrayOfByte = new byte[13];
        PkgTools.DWord2Byte(arrayOfByte, 0, l);
        arrayOfByte[4] = 0;
        PkgTools.Word2Byte(arrayOfByte, 5, (short)1);
        PkgTools.DWordTo2Bytes(arrayOfByte, 7, 42276);
        PkgTools.Word2Byte(arrayOfByte, 9, (short)2);
        if (paramBoolean)
        {
          PkgTools.Word2Byte(arrayOfByte, 11, (short)i);
          ntb.a(paramQQAppInterface, paramntf, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
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
    Object localObject = ((aslo)getActivity().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(((aslx)localObject).jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_Int = ((aslx)localObject).jdField_f_of_type_Int;
    }
    localObject = getActivity().app;
    String str = ((QQAppInterface)localObject).getCurrentUin();
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getFaceDrawable((AppInterface)localObject, 1, str));
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_b_of_type_AndroidViewView.findViewById(2131366271));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376853));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363929));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379107));
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366922);
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370791);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(asso.a(AIOUtils.dp2px(27.0F, getResources()), -15550475, 1.0F));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(asso.a(AIOUtils.dp2px(27.0F, getResources()), -16777216, 0.08F));
    this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379106);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131381251);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368703));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380333));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368695));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380336));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.jdField_b_of_type_AndroidViewView.findViewById(2131381242));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131381241));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366292));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131380659);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    Fragment localFragment = getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener((ExtendFriendEditFragment)localFragment);
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368754));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setDeleteIconEnable(true, new aspi(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(new aspj(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370290));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131376869));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369303));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369317));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380141));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379779));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    this.jdField_b_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new aspk(this));
    this.jdField_d_of_type_Boolean = true;
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
    int n = AIOUtils.dp2px(96.0F, getResources());
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
    a(AIOUtils.dp2px(114.0F, getResources()) - ImmersiveUtils.getStatusBarHeight(getActivity()));
  }
  
  private void m()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void n()
  {
    if (this.jdField_d_of_type_Boolean)
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
    if ((this.jdField_a_of_type_Bffk != null) && ((this.jdField_a_of_type_Bffk instanceof AudioInfo)))
    {
      localExtendFriendInfo.jdField_b_of_type_Int = (((AudioInfo)this.jdField_a_of_type_Bffk).duration / 1000);
      return localExtendFriendInfo;
    }
    localExtendFriendInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    return localExtendFriendInfo;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      bkxz.b(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, asnq paramasnq)
  {
    Object localObject;
    boolean bool;
    if ((VipUtils.a()) && (VipUtils.b(paramQQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
      if (paramasnq.mVipHide) {
        break label164;
      }
      bool = true;
      ((Switch)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramasnq.mNickName);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(String.valueOf(paramasnq.mPopularity));
      localObject = this.jdField_e_of_type_AndroidWidgetImageView;
      if (paramasnq.mGender != 2) {
        break label170;
      }
    }
    label164:
    label170:
    for (int i = 2130845081;; i = 2130845082)
    {
      ((ImageView)localObject).setImageResource(i);
      VipUtils.a(paramasnq, this.jdField_f_of_type_AndroidWidgetImageView);
      this.jdField_f_of_type_AndroidWidgetImageView.setTag(paramasnq);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      bdla.b(paramQQAppInterface, "dc00898", "", "", "0X8009F0E", "0X8009F0E", 0, 0, "", "", "", "");
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
    if (this.jdField_d_of_type_Boolean)
    {
      int i;
      if (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramExtendFriendInfo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramExtendFriendInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramExtendFriendInfo.jdField_a_of_type_JavaLangString), 3, 24));
        i = paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length();
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(i);
        a();
        if (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString)) {
          break label379;
        }
        m();
        this.jdField_b_of_type_JavaLangString = paramExtendFriendInfo.jdField_b_of_type_JavaLangString;
        this.jdField_b_of_type_Int = paramExtendFriendInfo.jdField_b_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.jdField_b_of_type_JavaLangString));
        }
      }
      for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
      {
        b(paramExtendFriendInfo);
        if (!bdfk.b())
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
        label379:
        n();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = paramExtendFriendInfo;
  }
  
  public void a(AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_Bffk = paramAudioInfo;
    if (!TextUtils.isEmpty(paramAudioInfo.path))
    {
      this.jdField_b_of_type_JavaLangString = paramAudioInfo.path;
      this.jdField_b_of_type_Int = paramAudioInfo.duration;
      m();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(this.jdField_b_of_type_Int / 1000);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_JavaLangString.indexOf("file_md5=") <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceFileMD5(MD5Utils.encodeFileHexStr(this.jdField_b_of_type_JavaLangString));
      }
      this.jdField_f_of_type_Boolean = true;
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
    return ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(str1))) || (this.jdField_f_of_type_Boolean);
  }
  
  public void b()
  {
    Object localObject = ((aslo)getActivity().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a();
    if (localObject == null) {}
    for (int i = 11000;; i = ((aslx)localObject).jdField_c_of_type_Int * 1000)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("audio_max_length", i);
      ((Intent)localObject).putExtra("auto_start", true);
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      aeow.a(getActivity(), (Intent)localObject, PublicTransFragmentActivity.class, AudioRecordFragment.class, 1003);
      this.jdField_c_of_type_Boolean = true;
      j();
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
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845076);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aspn(this));
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
      i = 2130845119;
      label132:
      localTextView.setText(bhaa.a(str, false, i, 2131298350, 2131298349, getActivity(), getActivity().app, null));
      if (paramExtendFriendInfo.jdField_a_of_type_Long != 2L) {
        break label224;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new ExtendFriendProfileEditFragment.7(this, paramExtendFriendInfo));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aspo(this, paramExtendFriendInfo));
      break;
      i = 2130845120;
      break label132;
      label224:
      if (paramExtendFriendInfo.jdField_a_of_type_Long == 0L)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698425);
        a(true);
      }
      else if (paramExtendFriendInfo.jdField_a_of_type_Long == 1L)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698426);
        a(false);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698425);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setFocusable(true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      bkxz.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendEditFragment.c(0);
        continue;
        b();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.b();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a();
          continue;
          if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null)) {
            assp.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.g, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_JavaLangString);
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561119, paramViewGroup, false);
    e();
    d();
    if ((getActivity() != null) && (assp.c(getActivity().app)))
    {
      assp.b(getActivity().app, false);
      getActivity().setResult(8193);
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
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
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment
 * JD-Core Version:    0.7.0.1
 */