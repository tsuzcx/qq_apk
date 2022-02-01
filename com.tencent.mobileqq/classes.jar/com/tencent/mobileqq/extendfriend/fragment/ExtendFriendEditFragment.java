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
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.UITools;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.StickyNoteShopSetting;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.VasResDrawableAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.widget.QzoneEmotionUtils;
import mqq.app.AppRuntime;

public class ExtendFriendEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener, StickyNoteShopLayout.StickyNoteShopSetting, SoftInputDetectView.OnImStateChangedListener
{
  public int a;
  private SuixintieCheckItem jdField_a_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new ExtendFriendEditFragment.1(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ExtendFriendProfileEditFragment.ExtendFriendInfo jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo;
  ExtendFriendProfileEditFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment;
  ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendEditFragment.9(this);
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ExtendFriendEditFragment.2(this);
  public AudioInfo a;
  private VasRes jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private SuixintieCheckItem jdField_b_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private StickyNoteShopLayout jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public ExtendFriendEditFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      return;
    }
    b(paramExtendFriendInfo);
  }
  
  private void a(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = 23;
    ((ITransFileController)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void b(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369487);
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369518));
    if (ThemeUtil.isInNightMode(getActivity().app)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130845947));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramView.findViewById(2131365312));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370572));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)paramView.findViewById(2131369156));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setExcludeStatusBar(false);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367087));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131363589));
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131367319));
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369859));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369860));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(this);
  }
  
  private void b(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    int j = 1;
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_Int;
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length() < i)) {
        break label199;
      }
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))) {
        break label172;
      }
      i = 2;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092DF", "0X80092DF", i, 0, "", "", "", "");
      localExtendFriendHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), paramExtendFriendInfo.jdField_a_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_Int, this.jdField_b_of_type_QCSuixintieCheckItem.itemId, this.jdField_b_of_type_QCSuixintieCheckItem.fontType, this.jdField_a_of_type_QCSuixintieCheckItem.itemId);
      return;
      i = 20;
      break;
      label172:
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
    label199:
    QQToast.a(getActivity(), String.format(HardCodeUtil.a(2131704286), new Object[] { Integer.valueOf(i) }), 0).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment = new ExtendFriendProfileEditFragment();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).commit();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = ((ExtendFriendProfileEditFragment.ExtendFriendInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("key_extend_friend_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null)
    {
      ((ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    ((ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), true);
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.a()) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
    if (!NetworkState.isNetworkConnected(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp())) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp(), 1, 2131694457, 0).a();
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
      Object localObject2 = new SignatureAdapter((VasResDrawable)localObject1, getActivity().app, 2130846437);
      ((SignatureAdapter)localObject2).a(true);
      ((VasResDrawable)localObject1).a((VasResDrawable.VasResDrawableAdapter)localObject2);
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
    if (!SimpleUIUtil.a())
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
      if ((!paramBoolean) || (SimpleUIUtil.a())) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment == null) || (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.isResumed())) {}
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
        if (!SimpleUIUtil.a()) {
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
    return (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
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
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()), 3, 24));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes == null)
    {
      Object localObject = getActivity().app;
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes((AppRuntime)localObject, paramInt1);
      localObject = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, (AppRuntime)localObject, paramInt2);
      ((SignatureFontAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(-1);
    }
    for (;;)
    {
      a();
      return;
      ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(paramInt1, paramInt2);
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
    String str2;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)
    {
      str2 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) {
        break label91;
      }
      str1 = "";
    }
    for (;;)
    {
      if (!str2.equals(str1)) {
        break label125;
      }
      return false;
      str2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      break;
      label91:
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_JavaLangString == null) {
        str1 = "";
      } else {
        str1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_JavaLangString;
      }
    }
    label125:
    return true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850726);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850723);
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
      InputMethodUtil.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      c();
      return;
    case 2: 
      if (this.jdField_b_of_type_Boolean) {
        InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      }
      for (;;)
      {
        d();
        return;
        a(true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850724);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "1");
      }
    }
    if (this.jdField_b_of_type_Boolean) {
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
    for (;;)
    {
      d();
      return;
      a(true);
      a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850727);
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "item_show", "", 0, "", "2");
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(str), 3, 24));
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
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, HardCodeUtil.a(2131704262), HardCodeUtil.a(2131704283), HardCodeUtil.a(2131704278), new ExtendFriendEditFragment.3(this), new ExtendFriendEditFragment.4(this));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
        localQQCustomDialog.show();
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
        ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
        {
          localObject = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, HardCodeUtil.a(2131704287), HardCodeUtil.a(2131704267), HardCodeUtil.a(2131704301), new ExtendFriendEditFragment.5(this), new ExtendFriendEditFragment.6(this));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
          ((QQCustomDialog)localObject).show();
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
              QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, "扩列宣言还没有填写哦", 0).a();
            }
            else if ((TextUtils.isEmpty(((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject).jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString)))
            {
              localObject = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, HardCodeUtil.a(2131704274), HardCodeUtil.a(2131704265), HardCodeUtil.a(2131704266), new ExtendFriendEditFragment.7(this), new ExtendFriendEditFragment.8(this, (ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject));
              this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
              ((QQCustomDialog)localObject).show();
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount() > 30)
            {
              QQToast.a(getActivity(), "输入文字不要超过30行", 0).a();
            }
            else
            {
              a((ExtendFriendProfileEditFragment.ExtendFriendInfo)localObject);
              continue;
              c();
              c(2);
              VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "1");
              ExpandReportUtils.a("click#edit_data_page#skin", true, -1L, -1L, null, true, true);
              continue;
              c();
              c(3);
              VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "icon_click", "", 0, "", "2");
              ExpandReportUtils.a("click#edit_data_page#font", true, -1L, -1L, null, true, true);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131561210, null);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    b(paramLayoutInflater);
    e();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    ((ITransFileController)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = null;
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131366443) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.b()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment
 * JD-Core Version:    0.7.0.1
 */