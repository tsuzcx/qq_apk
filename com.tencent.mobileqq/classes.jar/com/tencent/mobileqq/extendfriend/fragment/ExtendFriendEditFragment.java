package com.tencent.mobileqq.extendfriend.fragment;

import ajya;
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
import aoet;
import aoez;
import aogt;
import aogu;
import aogv;
import aogw;
import aogx;
import aogy;
import aogz;
import aoha;
import aohb;
import axqy;
import aysv;
import ayvx;
import aywb;
import aywc;
import bbdj;
import bbgu;
import bcqf;
import bcql;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendEditFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnTouchListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new aogt(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aoez jdField_a_of_type_Aoez = new aohb(this);
  private aywb jdField_a_of_type_Aywb = new aogu(this);
  private bcqf jdField_a_of_type_Bcqf;
  public ExtendFriendProfileEditFragment a;
  public AudioInfo a;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131368429);
    localTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368457));
    if (ThemeUtil.isInNightMode(getActivity().app)) {
      localTextView.setBackgroundDrawable(getResources().getDrawable(2130844819));
    }
    this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)paramView.findViewById(2131364708));
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getActivity(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnTouchListener(this);
  }
  
  private void a(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
    }
    this.jdField_a_of_type_Bcqf.show();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      return;
    }
    b(paramExtendFriendInfo);
  }
  
  private void a(String paramString)
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.i = paramString;
    localaywc.jdField_a_of_type_Long = System.currentTimeMillis();
    localaywc.jdField_b_of_type_Int = 23;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().a(localaywc);
  }
  
  private void b(ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo)
  {
    int j = 1;
    aoet localaoet = (aoet)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_Int;
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (paramExtendFriendInfo.jdField_a_of_type_JavaLangString.length() < i)) {
        break label168;
      }
      if ((!TextUtils.isEmpty(paramExtendFriendInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramExtendFriendInfo.jdField_b_of_type_JavaLangString))) {
        break label141;
      }
      i = 2;
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092DF", "0X80092DF", i, 0, "", "", "", "");
      localaoet.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), paramExtendFriendInfo.jdField_a_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_JavaLangString, paramExtendFriendInfo.jdField_b_of_type_Int);
      return;
      i = 20;
      break;
      label141:
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
    label168:
    bcql.a(getActivity(), String.format(ajya.a(2131704269), new Object[] { Integer.valueOf(i) }), 0).a();
    this.jdField_a_of_type_Bcqf.dismiss();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment = new ExtendFriendProfileEditFragment();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().add(2131364708, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).commit();
    ExtendFriendProfileEditFragment.ExtendFriendInfo localExtendFriendInfo = (ExtendFriendProfileEditFragment.ExtendFriendInfo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getParcelableExtra("key_extend_friend_info");
    if (localExtendFriendInfo == null)
    {
      ((aoet)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), false);
      this.jdField_a_of_type_Bcqf.show();
      return;
    }
    ((aoet)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a(127)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), true);
    if (localExtendFriendInfo.a()) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(localExtendFriendInfo);
    }
    if (!NetworkState.isNetworkConnected(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp())) {
      bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getApp(), 1, 2131694608, 0).a();
    }
    if ((TextUtils.isEmpty(localExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(localExtendFriendInfo.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (isAdded())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollTo(0, paramInt);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-3355444);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  public boolean needStatusTrans()
  {
    return false;
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
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
      {
        bbgu localbbgu = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, ajya.a(2131704245), ajya.a(2131704266), ajya.a(2131704261), new aogv(this), new aogw(this));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
        localbbgu.show();
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
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
      axqy.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092E0", "0X80092E0", 0, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a()))
      {
        paramView = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, ajya.a(2131704270), ajya.a(2131704250), ajya.a(2131704284), new aogx(this), new aogy(this));
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
      bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, "QQ扩列宣言还没有填写哦", 0).a();
      return;
    }
    if ((TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString)))
    {
      paramView = bbdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, null, ajya.a(2131704257), ajya.a(2131704248), ajya.a(2131704249), new aogz(this), new aoha(this, paramView));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.c();
      paramView.show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.getLineCount() > 30)
    {
      bcql.a(getActivity(), "输入文字不要超过30行", 0).a();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131560736, null);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Aoez);
    a(paramLayoutInflater);
    c();
    this.jdField_a_of_type_Aywb.addFilter(new Class[] { aysv.class });
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().a(this.jdField_a_of_type_Aywb);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Aoez);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.a().b(this.jdField_a_of_type_Aywb);
    this.jdField_a_of_type_Aoez = null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView.getId() == 2131365755) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.b()))
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