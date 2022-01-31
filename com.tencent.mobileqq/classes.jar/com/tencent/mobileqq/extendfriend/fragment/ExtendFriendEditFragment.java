package com.tencent.mobileqq.extendfriend.fragment;

import acho;
import achp;
import achq;
import achr;
import achs;
import acht;
import achu;
import achv;
import achw;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new acho(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver = new achw(this);
  public ExtendFriendProfileEditFragment a;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new achp(this);
  public AudioInfo a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131363245);
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363428));
    if (ThemeUtil.isInNightMode(getActivity().app)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130842945));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramView.findViewById(2131363551));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(this);
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
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.i = paramString;
    localTransferRequest.jdField_a_of_type_Long = System.currentTimeMillis();
    localTransferRequest.jdField_b_of_type_Int = 23;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().a(localTransferRequest);
  }
  
  private void b(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    int i = 1;
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(128);
    if ((TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) || (paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length() >= this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_Int))
    {
      if ((TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))) {}
      for (i = 2;; i = 3) {
        do
        {
          ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092DF", "0X80092DF", i, 0, "", "", "", "");
          localExtendFriendHandler.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), paramExtendFriendInfo.jdField_a_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_Int);
          return;
        } while ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString)));
      }
    }
    QQToast.a(getActivity(), String.format("请小主至少填满%d个字(｀ﾟДﾟ´)", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_Int) }), 0).a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment = new ExtendFriendProfileEditFragment();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().add(2131363551, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).commit();
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo = (ExtendFriendProfileEditFragment.ExtendFriendInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("key_extend_friend_info");
    if (localExtendFriendInfo == null)
    {
      ((ExtendFriendHandler)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(128)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    if (localExtendFriendInfo.a()) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(localExtendFriendInfo);
    }
    if (!NetworkState.isNetworkConnected(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp())) {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp(), 1, 2131433213, 0).a();
    }
    if ((TextUtils.isEmpty(localExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(localExtendFriendInfo.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, paramInt);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (isAdded())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131494214));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-3355444);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, "是否放弃编辑？", "继续编辑", "放弃", new achq(this), new achr(this));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
        localQQCustomDialog.show();
        return true;
      }
      return super.d();
    }
    return super.d();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
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
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, "是否放弃编辑？", "继续编辑", "放弃", new achs(this), new acht(this));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
        paramView.show();
        return;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment == null);
    paramView = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a();
    if ((this.jdField_a_of_type_Boolean) && (TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, "扩列宣言还没有填写哦", 0).a();
      return;
    }
    if ((TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString)))
    {
      paramView = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, "清空扩列宣言后你将不在扩列广场中出现，确认清空吗？", "确认", "取消", new achu(this), new achv(this, paramView));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
      paramView.show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.getLineCount() > 30)
    {
      QQToast.a(getActivity(), "输入文字不要超过30行", 0).a();
      return;
    }
    a(paramView);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2130970327, null);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
    a(paramLayoutInflater);
    d();
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendObserver = null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131370080) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.b()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment
 * JD-Core Version:    0.7.0.1
 */