package com.tencent.mobileqq.gamecenter.fragment;

import afez;
import agyw;
import agyz;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import avjy;
import avkk;
import avkl;
import bcuy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGamePadFaceFragment
  extends PublicBaseFragment
  implements agyz
{
  private agyw jdField_a_of_type_Agyw;
  private avjy jdField_a_of_type_Avjy;
  private bcuy jdField_a_of_type_Bcuy;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PadFaceAd jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    int j = -1;
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd == null) {
      return;
    }
    PadFaceAd localPadFaceAd = this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd;
    this.jdField_a_of_type_Agyw = new agyw();
    this.jdField_a_of_type_Agyw.a(localPadFaceAd.appName, localPadFaceAd.appView, localPadFaceAd.appVersion, localPadFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
    for (;;)
    {
      try
      {
        i = new JSONObject(localPadFaceAd.arkMeta).optInt("fullScreen", 1);
        if (i != 0) {
          continue;
        }
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("QQGamePadFaceFragment", 2, localJSONException, new Object[0]);
        int i = 1;
        continue;
        i = -1;
        continue;
      }
      if (i == 0) {
        continue;
      }
      j = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getWidth();
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getHeight();
      this.jdField_a_of_type_Agyw.setFixSize(j, i);
      this.jdField_a_of_type_Agyw.setMaxSize(j, i);
      this.jdField_a_of_type_Agyw.setHintSize(j, i);
      this.jdField_a_of_type_Agyw.setMinSize(j, i);
      this.jdField_a_of_type_Agyw.a(j, i);
      this.jdField_a_of_type_Agyw.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(new avkl(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_Agyw, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      return;
      i = 1;
    }
  }
  
  public static void a(Activity paramActivity, PadFaceAd paramPadFaceAd)
  {
    paramPadFaceAd = avjy.a(paramPadFaceAd, null);
    paramPadFaceAd.putExtra("public_fragment_window_feature", 1);
    afez.a(paramActivity, paramPadFaceAd, PublicTransFragmentActivity.class, QQGamePadFaceFragment.class, 10000);
  }
  
  private void b()
  {
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  public boolean a(agyw paramagyw)
  {
    b();
    return true;
  }
  
  public boolean a(agyw paramagyw, String paramString1, String paramString2)
  {
    return false;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if (this.jdField_a_of_type_Agyw != null) {
      this.jdField_a_of_type_Agyw.doOnEvent(2);
    }
  }
  
  public boolean onBackEvent()
  {
    b();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Bcuy = ((bcuy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12));
    this.jdField_a_of_type_Avjy = this.jdField_a_of_type_Bcuy.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = avjy.a(getActivity().getIntent());
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd == null) {
      getActivity().finish();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.isValid());
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId > 0) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = this.jdField_a_of_type_Avjy.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.isValid()));
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = new ArkAppView(getActivity(), null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setBorderType(0);
    paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
    paramLayoutInflater.addRule(13);
    paramBundle = new RelativeLayout(paramViewGroup.getContext());
    paramBundle.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, paramLayoutInflater);
    paramViewGroup.addView(paramBundle, -1, -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.addOnLayoutChangeListener(new avkk(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, null);
    return null;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Object localObject;
    int i;
    if (paramBoolean)
    {
      localObject = getActivity().getWindow().getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = (ViewGroup)localObject;
        i = 0;
      }
    }
    for (;;)
    {
      if (i < ((ViewGroup)localObject).getChildCount())
      {
        View localView = ((ViewGroup)localObject).getChildAt(i);
        if ((localView.getClass() == View.class) && (localView.getVisibility() == 0)) {
          ((ViewGroup)localObject).removeViewAt(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment
 * JD-Core Version:    0.7.0.1
 */