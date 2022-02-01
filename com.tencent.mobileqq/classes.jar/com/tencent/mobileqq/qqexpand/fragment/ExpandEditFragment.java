package com.tencent.mobileqq.qqexpand.fragment;

import QC.SuixintieCheckItem;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.utils.UITools;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.StickyNoteShopSetting;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
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
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;
import cooperation.qzone.widget.QzoneEmotionUtils;
import mqq.app.AppRuntime;

public class ExpandEditFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener, StickyNoteShopLayout.StickyNoteShopSetting, SoftInputDetectView.OnImStateChangedListener
{
  public int a;
  private final SuixintieCheckItem jdField_a_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  private final GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new ExpandEditFragment.2(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StickyNoteShopLayout jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  SoftInputDetectView jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView;
  ExtendFriendInfo jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo;
  ExpandProfileEditFragment jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
  ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExpandEditFragment.1(this);
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ExpandEditFragment.3(this);
  public AudioInfo a;
  private VasRes jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private final SuixintieCheckItem jdField_b_of_type_QCSuixintieCheckItem = new SuixintieCheckItem();
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private StickyNoteShopLayout jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c;
  
  public ExpandEditFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(ExtendFriendInfo paramExtendFriendInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
    if (localObject != null) {
      ((ExpandProfileEditFragment)localObject).c();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((AudioInfo)localObject).path)))
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
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
  }
  
  private void b(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369202);
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369233));
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130845821));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getQBaseActivity(), getQBaseActivity().getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramView.findViewById(2131365187));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getQBaseActivity(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370228));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView = ((SoftInputDetectView)paramView.findViewById(2131368888));
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setExcludeStatusBar(false);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewSoftInputDetectView.setOnImStateChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366928));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131363512));
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(9);
    this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout = ((StickyNoteShopLayout)paramView.findViewById(2131367102));
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setShopCallback(this);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setAppId(5);
    this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout.setUseId(2);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369545));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369546));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(UITools.a);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(this);
  }
  
  private void b(ExtendFriendInfo paramExtendFriendInfo)
  {
    IExpandHandler localIExpandHandler = (IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    ExpandProfileEditFragment localExpandProfileEditFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
    int i;
    if (localExpandProfileEditFragment != null) {
      i = localExpandProfileEditFragment.jdField_a_of_type_Int;
    } else {
      i = 20;
    }
    if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length() < i))
    {
      QQToast.a(getQBaseActivity(), String.format(HardCodeUtil.a(2131704377), new Object[] { Integer.valueOf(i) }), 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
    }
    if ((TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))) {
      i = 2;
    } else if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))) {
      i = 1;
    } else {
      i = 3;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092DF", "0X80092DF", i, 0, "", "", "", "");
    localIExpandHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramExtendFriendInfo.jdField_a_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_Int, this.jdField_b_of_type_QCSuixintieCheckItem.itemId, this.jdField_b_of_type_QCSuixintieCheckItem.fontType, this.jdField_a_of_type_QCSuixintieCheckItem.itemId);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment = new ExpandProfileEditFragment();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.a(this);
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction().add(2131365187, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment).commit();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo = ((ExtendFriendInfo)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getParcelableExtra("key_extend_friend_info"));
    ExtendFriendInfo localExtendFriendInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo;
    boolean bool2 = false;
    if (localExtendFriendInfo == null)
    {
      ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    ((IExpandHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.a()) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo);
    }
    if (!NetworkState.isNetworkConnected(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131694422, 0).a();
    }
    boolean bool1 = bool2;
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_a_of_type_JavaLangString))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_b_of_type_JavaLangString)) {
        bool1 = true;
      }
    }
    this.jdField_c_of_type_Boolean = bool1;
  }
  
  public StickyNoteShopLayout a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
  }
  
  public void a()
  {
    if ((!b()) && (!a()))
    {
      b();
      return;
    }
    if ((!b()) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_c_of_type_Int == this.jdField_b_of_type_QCSuixintieCheckItem.itemId) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.d == this.jdField_a_of_type_QCSuixintieCheckItem.itemId))
    {
      b();
      return;
    }
    if ((isAdded()) || (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    }
  }
  
  public void a(int paramInt)
  {
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).bottomMargin = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (getQBaseActivity() == null) {
        return;
      }
      if (paramInt1 > 10000)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable))
        {
          ((VasResDrawable)this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_AndroidViewView.getBackground()).a(paramInt1);
        }
        else
        {
          VasResDrawable localVasResDrawable = new VasResDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
          SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2130846313);
          localSignatureAdapter.a(true);
          localVasResDrawable.a(localSignatureAdapter);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localVasResDrawable);
        }
        this.jdField_a_of_type_QCSuixintieCheckItem.itemId = paramInt1;
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundColor(Color.alpha(0));
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setBackgroundColor(Color.alpha(0));
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.alpha(0));
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundDrawable(ExpandProfileEditFragment.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setBackgroundDrawable(ExpandProfileEditFragment.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        this.jdField_a_of_type_QCSuixintieCheckItem.itemId = 0;
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_QCSuixintieCheckItem.appid = 9;
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
      if (paramInt2 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramInt2);
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextColor(paramInt2);
      }
      a();
    }
  }
  
  public void a(View paramView)
  {
    StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
    localStickyNoteShopLayout = this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != paramView) {
      localStickyNoteShopLayout.b();
    }
  }
  
  public void a(StickyNoteShopLayout paramStickyNoteShopLayout)
  {
    if (!SimpleUIUtil.a())
    {
      a(paramStickyNoteShopLayout);
      a(paramStickyNoteShopLayout.a(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramStickyNoteShopLayout.a(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null)
    {
      int i;
      if ((paramBoolean) && (!SimpleUIUtil.a())) {
        i = 0;
      } else {
        i = 8;
      }
      localFrameLayout.setVisibility(i);
      if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)
      {
        VasWebviewUtil.a("strangers_makefriend", "icon_show", "", 0, "", "1");
        VasWebviewUtil.a("strangers_makefriend", "icon_show", "", 0, "", "2");
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ExpandProfileEditFragment localExpandProfileEditFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
    if ((localExpandProfileEditFragment != null) && (localExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo != null))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.isResumed()) {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_b_of_type_Int = paramInt;
        if (!SimpleUIUtil.a()) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        a(false);
        a(0);
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_b_of_type_Boolean = false;
          c();
          this.jdField_a_of_type_Int = 3;
          b(3);
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_c_of_type_Boolean = false;
          c();
          this.jdField_a_of_type_Int = 2;
          b(2);
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = false;
        paramInt = this.jdField_a_of_type_Int;
        if (paramInt == 1)
        {
          a(true);
          return;
        }
        if (paramInt == 0)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          a(false);
          return;
        }
        if (paramInt == 2)
        {
          b(2);
          return;
        }
        if (paramInt == 3) {
          b(3);
        }
      }
    }
  }
  
  public boolean a()
  {
    ExpandProfileEditFragment localExpandProfileEditFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
    return (localExpandProfileEditFragment != null) && (localExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()));
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
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        }
        else
        {
          a(true);
          a(this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850653);
          VasWebviewUtil.a("strangers_makefriend", "item_show", "", 0, "", "2");
        }
        d();
        return;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        InputMethodUtil.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      }
      else
      {
        a(true);
        a(this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850650);
        VasWebviewUtil.a("strangers_makefriend", "item_show", "", 0, "", "1");
      }
      d();
      return;
    }
    a(false);
    InputMethodUtil.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return;
    }
    if (getQBaseActivity() == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_b_of_type_QCSuixintieCheckItem;
    ((SuixintieCheckItem)localObject).itemId = paramInt1;
    ((SuixintieCheckItem)localObject).fontType = paramInt2;
    ((SuixintieCheckItem)localObject).appid = 5;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(new QQText(QzoneEmotionUtils.emCodesToQQcodes(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()), 3, 24));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes = new VasRes((AppRuntime)localObject, paramInt1);
      localObject = new SignatureFontAdapter(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes, (AppRuntime)localObject, paramInt2);
      ((SignatureFontAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a((VasResAdapter)localObject);
      ((SignatureFontAdapter)localObject).a(-1);
    }
    else
    {
      ((SignatureFontAdapter)((VasRes)localObject).a()).a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      ((SignatureFontAdapter)this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes.a()).a(paramInt1, paramInt2);
    }
    a();
  }
  
  public boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
    if (localObject == null) {
      return false;
    }
    if (((ExpandProfileEditFragment)localObject).jdField_c_of_type_Boolean) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) {
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_a_of_type_JavaLangString != null)) {
      str = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_a_of_type_JavaLangString;
    }
    return ((String)localObject).equals(str) ^ true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130850652);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850649);
  }
  
  public void d()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null) {
      str = "";
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(str), 3, 24));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    StickyNoteShopLayout localStickyNoteShopLayout = this.jdField_a_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    localStickyNoteShopLayout = this.jdField_b_of_type_ComTencentMobileqqProfileStickynoteVasStickyNoteShopLayout;
    if (localStickyNoteShopLayout != null) {
      localStickyNoteShopLayout.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt1 != 1003) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = ((AudioInfo)paramIntent.getSerializableExtra("audio_info"));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onActivityResult audio_back path: ");
      paramIntent.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      QLog.i("ExtendFriendProfileEdit", 2, paramIntent.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
      if ((localObject != null) && (((ExpandProfileEditFragment)localObject).a()))
      {
        localObject = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, null, HardCodeUtil.a(2131704353), HardCodeUtil.a(2131704374), HardCodeUtil.a(2131704369), new ExpandEditFragment.4(this), new ExpandEditFragment.5(this));
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.c();
        ((QQCustomDialog)localObject).show();
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
    default: 
      return;
    case 2131369546: 
      c();
      b(3);
      VasWebviewUtil.a("strangers_makefriend", "icon_click", "", 0, "", "2");
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#font", true, -1L, -1L, null, true, true);
      return;
    case 2131369545: 
      c();
      b(2);
      VasWebviewUtil.a("strangers_makefriend", "icon_click", "", 0, "", "1");
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#edit_data_page#skin", true, -1L, -1L, null, true, true);
      return;
    case 2131369233: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
      if (paramView == null) {
        return;
      }
      paramView = paramView.a();
      if ((this.jdField_c_of_type_Boolean) && (TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)))
      {
        AudioInfo localAudioInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
        if ((localAudioInfo != null) && (!TextUtils.isEmpty(localAudioInfo.path)))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, "扩列宣言还没有填写哦", 0).a();
          return;
        }
      }
      if ((TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_JavaLangString)))
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, null, HardCodeUtil.a(2131704365), HardCodeUtil.a(2131704356), HardCodeUtil.a(2131704357), new ExpandEditFragment.8(this), new ExpandEditFragment.9(this, paramView));
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.c();
        paramView.show();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLineCount() > 30)
      {
        QQToast.a(getQBaseActivity(), "输入文字不要超过30行", 0).a();
        return;
      }
      if ((!TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.a(paramView.jdField_a_of_type_JavaLangString)))
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, null, HardCodeUtil.a(2131692097), HardCodeUtil.a(2131692096), HardCodeUtil.a(2131692095), new ExpandEditFragment.10(this), new ExpandEditFragment.11(this, paramView));
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.c();
        paramView.show();
        return;
      }
      a(paramView);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
      paramView = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
      if ((paramView != null) && (paramView.a()))
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0, null, HardCodeUtil.a(2131704378), HardCodeUtil.a(2131704358), HardCodeUtil.a(2131704392), new ExpandEditFragment.6(this), new ExpandEditFragment.7(this));
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.c();
        paramView.show();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.doOnBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = getChildFragmentManager();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow();
    if (paramBundle != null)
    {
      paramBundle.setFormat(-3);
      paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      paramBundle.setSoftInputMode(16);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561075, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    b(paramLayoutInflater);
    e();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = null;
    VasRes localVasRes = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasRes;
    if (localVasRes != null) {
      localVasRes.a();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131366323)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment;
      if ((paramView != null) && (paramView.b()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.requestDisallowInterceptTouchEvent(true);
        if (paramMotionEvent.getAction() == 1) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.requestDisallowInterceptTouchEvent(false);
        }
        return false;
      }
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if ((paramView instanceof RelativeLayout))
      {
        paramView = (RelativeLayout)paramView;
        paramBundle = new View(getQBaseActivity());
        paramBundle.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        paramBundle.setBackgroundColor(1056964608);
        paramView.addView(paramBundle);
        return;
      }
      if (!QLog.isDebugVersion()) {
        return;
      }
      throw new RuntimeException("error root type");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandEditFragment
 * JD-Core Version:    0.7.0.1
 */