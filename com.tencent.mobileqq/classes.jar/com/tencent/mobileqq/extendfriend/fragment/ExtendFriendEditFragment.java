package com.tencent.mobileqq.extendfriend.fragment;

import QC.SuixintieCheckItem;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import asvg;
import asvt;
import asxy;
import asxz;
import asya;
import asyb;
import asyc;
import asyd;
import asye;
import asyf;
import asyg;
import asyh;
import asyi;
import babc;
import bacp;
import bdgb;
import bdll;
import begp;
import bevi;
import beyb;
import beyf;
import beyg;
import bhlq;
import bhpc;
import biai;
import biaj;
import biap;
import biba;
import bibd;
import bjbs;
import blgx;
import bnqj;
import com.etrump.mixlayout.ETTextView;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime;
import mvd;

public class ExtendFriendEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener, babc, bacp
{
  public int a;
  private SuixintieCheckItem jdField_a_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new asxy(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  asvt jdField_a_of_type_Asvt = new asya(this);
  private beyf jdField_a_of_type_Beyf = new asyb(this);
  private biai jdField_a_of_type_Biai;
  private bjbs jdField_a_of_type_Bjbs;
  public ExtendFriendProfileEditFragment.ExtendFriendInfo a;
  public ExtendFriendProfileEditFragment a;
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  public AudioInfo a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int;
  private SuixintieCheckItem jdField_b_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private StickyNoteShopLayout jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public ExtendFriendEditFragment()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
    }
    this.jdField_a_of_type_Bjbs.show();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      return;
    }
    b(paramExtendFriendInfo);
  }
  
  private void a(String paramString)
  {
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.i = paramString;
    localbeyg.jdField_a_of_type_Long = System.currentTimeMillis();
    localbeyg.jdField_b_of_type_Int = 23;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().a(localbeyg);
  }
  
  private void b(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369042);
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369073));
    if (ThemeUtil.isInNightMode(getActivity().app)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130845666));
    }
    this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramView.findViewById(2131365063));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370134));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)paramView.findViewById(2131368740));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setExcludeStatusBar(false);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366753));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131363404));
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131366997));
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369434));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mvd.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369435));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(mvd.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(this);
  }
  
  private void b(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    int j = 1;
    asvg localasvg = (asvg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_Int;
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length() < i)) {
        break label198;
      }
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))) {
        break label171;
      }
      i = 2;
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092DF", "0X80092DF", i, 0, "", "", "", "");
      localasvg.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), paramExtendFriendInfo.jdField_a_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_Int, this.jdField_b_of_type_QCSuixintieCheckItem.itemId, this.jdField_b_of_type_QCSuixintieCheckItem.fontType, this.jdField_a_of_type_QCSuixintieCheckItem.itemId);
      return;
      i = 20;
      break;
      label171:
      if (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString))
      {
        i = j;
        if (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString)) {}
      }
      else
      {
        i = 3;
      }
    }
    label198:
    QQToast.a(getActivity(), String.format(anzj.a(2131703157), new Object[] { Integer.valueOf(i) }), 0).a();
    this.jdField_a_of_type_Bjbs.dismiss();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment = new ExtendFriendProfileEditFragment();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().add(2131365063, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).commit();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = ((ExtendFriendProfileEditFragment.ExtendFriendInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("key_extend_friend_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null)
    {
      ((asvg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), false);
      this.jdField_a_of_type_Bjbs.show();
      return;
    }
    ((asvg)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), true);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.a()) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
    if (!NetworkState.isNetworkConnected(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp())) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp(), 1, 2131693963, 0).a();
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public StickyNoteShopLayout a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  }
  
  public void a()
  {
    if ((!b()) && (!a())) {
      b();
    }
    do
    {
      return;
      if ((!b()) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_Int == this.jdField_b_of_type_QCSuixintieCheckItem.itemId) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.d == this.jdField_a_of_type_QCSuixintieCheckItem.itemId))
      {
        b();
        return;
      }
    } while ((!isAdded()) && (!this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (getActivity() == null)) {
      return;
    }
    if (paramInt1 > 10000)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidViewView.getBackground()).b(paramInt1);
        this.jdField_a_of_type_QCSuixintieCheckItem.itemId = paramInt1;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundColor(Color.alpha(0));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setBackgroundColor(Color.alpha(0));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_QCSuixintieCheckItem.appid = 9;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
      if (paramInt2 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(paramInt2);
      }
      a();
      return;
      Object localObject1 = new VasResDrawable(getActivity().app, paramInt1);
      Object localObject2 = new biba((VasResDrawable)localObject1, getActivity().app, 2130846136);
      ((biba)localObject2).a(true);
      ((VasResDrawable)localObject1).a((biap)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject1);
      break;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.alpha(0));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment;
      ((XEditTextEx)localObject1).setBackgroundDrawable(ExtendFriendProfileEditFragment.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment;
      ((ETTextView)localObject1).setBackgroundDrawable(ExtendFriendProfileEditFragment.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      this.jdField_a_of_type_QCSuixintieCheckItem.itemId = 0;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.b();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != paramView) {
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.b();
    }
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    if (!bdgb.b())
    {
      a(paramStickyNoteShopLayout);
      b(paramStickyNoteShopLayout.a(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramStickyNoteShopLayout.a(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
      if ((!paramBoolean) || (bdgb.b())) {
        break label78;
      }
    }
    label78:
    for (int i = 0;; i = 8)
    {
      localFrameLayout.setVisibility(i);
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)
      {
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_show", "", 0, "", "1");
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_show", "", 0, "", "2");
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_Int = paramInt;
        if (!bdgb.b()) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        a(false);
        b(0);
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_b_of_type_Boolean = false;
          c();
          this.jdField_a_of_type_Int = 3;
          c(3);
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_c_of_type_Boolean = false;
      c();
      this.jdField_a_of_type_Int = 2;
      c(2);
      return;
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Int == 1)
      {
        a(true);
        return;
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        a(false);
        return;
      }
      if (this.jdField_a_of_type_Int == 2)
      {
        c(2);
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    c(3);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
  }
  
  public StickyNoteShopLayout b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-3355444);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  public void b(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    while (getActivity() == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_QCSuixintieCheckItem.itemId = paramInt1;
    this.jdField_b_of_type_QCSuixintieCheckItem.fontType = paramInt2;
    this.jdField_b_of_type_QCSuixintieCheckItem.appid = 5;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new begp(bnqj.c(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()), 3, 24));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    if (this.jdField_a_of_type_Biai == null)
    {
      Object localObject = getActivity().app;
      this.jdField_a_of_type_Biai = new biai((AppRuntime)localObject, paramInt1);
      localObject = new bibd(this.jdField_a_of_type_Biai, (AppRuntime)localObject, paramInt2);
      ((bibd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Biai.a((biaj)localObject);
      ((bibd)localObject).a(-1);
    }
    for (;;)
    {
      a();
      return;
      ((bibd)this.jdField_a_of_type_Biai.a()).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      ((bibd)this.jdField_a_of_type_Biai.a()).a(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_c_of_type_Boolean) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) {
      return false;
    }
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)
    {
      str1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_JavaLangString != null) {
        break label94;
      }
    }
    label94:
    for (String str2 = "";; str2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_JavaLangString)
    {
      if (!str1.equals(str2)) {
        break label108;
      }
      return false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      break;
    }
    label108:
    return true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850301);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850298);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      a(false);
      blgx.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      c();
      return;
    case 2: 
      if (this.jdField_b_of_type_Boolean) {
        blgx.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      }
      for (;;)
      {
        d();
        return;
        a(true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850299);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "1");
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      blgx.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
    for (;;)
    {
      d();
      return;
      a(true);
      a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850302);
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "2");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new begp(bnqj.c(str), 3, 24));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
      return;
    }
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == 0) {}
    do
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramIntent.getSerializableExtra("audio_info"));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
    } while (!QLog.isColorLevel());
    QLog.i("ExtendFriendProfileEdit", 2, "onActivityResult audio_back path: " + this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
      {
        bhpc localbhpc = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, anzj.a(2131703133), anzj.a(2131703154), anzj.a(2131703149), new asyc(this), new asyd(this));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
        localbhpc.show();
        return true;
      }
      return super.onBackEvent();
    }
    return super.onBackEvent();
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
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        bdll.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
        {
          localObject = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, anzj.a(2131703158), anzj.a(2131703138), anzj.a(2131703172), new asye(this), new asyf(this));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
          ((bhpc)localObject).show();
        }
        else
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a();
            if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
            {
              QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, "校园扩列宣言还没有填写哦", 0).a();
            }
            else if ((TextUtils.isEmpty(((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString)))
            {
              localObject = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, anzj.a(2131703145), anzj.a(2131703136), anzj.a(2131703137), new asyg(this), new asyh(this, (ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject));
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
              ((bhpc)localObject).show();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount() > 30)
            {
              QQToast.a(getActivity(), "输入文字不要超过30行", 0).a();
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
            {
              localObject = bhlq.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, getString(2131698054), getString(2131698055), getString(2131698056), new asyi(this), new asxz(this, (ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject));
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
              ((bhpc)localObject).show();
            }
            else
            {
              a((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject);
              continue;
              c();
              c(2);
              VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "1");
              continue;
              c();
              c(3);
              VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "2");
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = getChildFragmentManager();
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      paramBundle.setSoftInputMode(16);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561183, null);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Asvt);
    b(paramLayoutInflater);
    e();
    this.jdField_a_of_type_Beyf.addFilter(new Class[] { bevi.class });
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().a(this.jdField_a_of_type_Beyf);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Asvt);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_Beyf);
    this.jdField_a_of_type_Asvt = null;
    if (this.jdField_a_of_type_Biai != null) {
      this.jdField_a_of_type_Biai.a();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131366142) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.requestDisallowInterceptTouchEvent(true);
      if (paramMotionEvent.getAction() == 1) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.requestDisallowInterceptTouchEvent(false);
      }
      return false;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (ThemeUtil.isInNightMode(getActivity().app))
    {
      paramView = (FrameLayout)paramView;
      paramBundle = new View(getActivity());
      paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      paramBundle.setBackgroundColor(1056964608);
      paramView.addView(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment
 * JD-Core Version:    0.7.0.1
 */