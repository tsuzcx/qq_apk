package com.tencent.mobileqq.gamecenter.fragment;

import aeow;
import agnx;
import agoa;
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
import avce;
import avcp;
import avcq;
import bcvc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGamePadFaceFragment
  extends PublicBaseFragment
  implements agoa
{
  private agnx jdField_a_of_type_Agnx;
  private avce jdField_a_of_type_Avce;
  private bcvc jdField_a_of_type_Bcvc;
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
    this.jdField_a_of_type_Agnx = new agnx();
    this.jdField_a_of_type_Agnx.a(localPadFaceAd.appName, localPadFaceAd.appView, localPadFaceAd.appVersion, localPadFaceAd.arkMeta, getResources().getDisplayMetrics().scaledDensity, new SessionInfo());
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
      this.jdField_a_of_type_Agnx.setFixSize(j, i);
      this.jdField_a_of_type_Agnx.setMaxSize(j, i);
      this.jdField_a_of_type_Agnx.setHintSize(j, i);
      this.jdField_a_of_type_Agnx.setMinSize(j, i);
      this.jdField_a_of_type_Agnx.a(j, i);
      this.jdField_a_of_type_Agnx.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(new avcq(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_Agnx, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      return;
      i = 1;
    }
  }
  
  public static void a(Activity paramActivity, PadFaceAd paramPadFaceAd)
  {
    paramPadFaceAd = avce.a(paramPadFaceAd, null);
    paramPadFaceAd.putExtra("public_fragment_window_feature", 1);
    aeow.a(paramActivity, paramPadFaceAd, PublicTransFragmentActivity.class, QQGamePadFaceFragment.class, 10000);
  }
  
  private void b()
  {
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    if (this.jdField_a_of_type_Agnx != null) {
      this.jdField_a_of_type_Agnx.doOnEvent(2);
    }
  }
  
  public boolean closeView(agnx paramagnx)
  {
    b();
    return true;
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
    this.jdField_a_of_type_Bcvc = ((bcvc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER));
    this.jdField_a_of_type_Avce = this.jdField_a_of_type_Bcvc.a();
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = avce.a(getActivity().getIntent());
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
        this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd = this.jdField_a_of_type_Avce.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataPadFaceAd.redPointId);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.addOnLayoutChangeListener(new avcp(this));
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
  
  public boolean openCardView(agnx paramagnx, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment
 * JD-Core Version:    0.7.0.1
 */